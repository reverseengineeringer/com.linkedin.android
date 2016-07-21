package com.linkedin.android.identity.shared;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.PhotoCropBundle;
import com.linkedin.android.infra.shared.PhotoCropListener;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ProfileEditPhotoCropFragment
  extends ProfileEditBaseFragment
  implements ProfilePictureSelectDialogFragment.OnUserSelectionListener, PhotoCropListener, PhotoUtils.UriListener
{
  private static final String TAG = ProfileEditPhotoCropFragment.class.getSimpleName();
  @Inject
  FragmentRegistry fragmentRegistry;
  private NormProfile.Builder modifiedNormProfileBuilder;
  private ProfilePhotoCropFragment photoCropFragment;
  private OnPhotoEditListener photoEditListener;
  private String photoId;
  private Uri photoUri;
  @Inject
  PhotoUtils photoUtils;
  
  public static ProfileEditPhotoCropFragment newInstance(ProfileEditPhotoCropBundleBuilder paramProfileEditPhotoCropBundleBuilder)
  {
    ProfileEditPhotoCropFragment localProfileEditPhotoCropFragment = new ProfileEditPhotoCropFragment();
    localProfileEditPhotoCropFragment.setArguments(paramProfileEditPhotoCropBundleBuilder.build());
    return localProfileEditPhotoCropFragment;
  }
  
  public final void doResume()
  {
    super.doResume();
    if (photoUri != null)
    {
      localObject = photoUri;
      photoCropFragment = ((ProfilePhotoCropFragment)fragmentRegistry.profilePhotoCrop.newFragment(new PhotoCropBundle((Uri)localObject)));
      getChildFragmentManager().popBackStackImmediate();
      getChildFragmentManager().beginTransaction().add(2131757569, photoCropFragment).commit();
    }
    while (photoId == null) {
      return;
    }
    Object localObject = photoId;
    photoCropFragment = ((ProfilePhotoCropFragment)fragmentRegistry.profilePhotoCrop.newFragment(new PhotoCropBundle((String)localObject)));
    getChildFragmentManager().popBackStackImmediate();
    getChildFragmentManager().beginTransaction().add(2131757569, photoCropFragment).commit();
  }
  
  public final String getCancelTrackingControlName()
  {
    return "profile_photo_crop_back";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  public final int getContentViewResourceId()
  {
    return 2130969196;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131233272;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    return i18NManager.getString(2131232658);
  }
  
  protected final void goBackToPreviousFragment()
  {
    photoEditListener.onPhotoEditCancel();
  }
  
  public final void initializeFields()
  {
    if (getDataProvider().getModifiedNormProfileModel() != null) {
      modifiedNormProfileBuilder = new NormProfile.Builder(getDataProvider().getModifiedNormProfileModel());
    }
    setEditSaveMenuItemEnabled(true);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    return true;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 11) {
        break label20;
      }
      photoUri = paramIntent.getData();
    }
    label20:
    while (paramInt1 != 12) {
      return;
    }
    getActivity().getContentResolver().notifyChange(photoUri, null);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() instanceof OnPhotoEditListener))
    {
      photoEditListener = ((OnPhotoEditListener)getParentFragment());
      return;
    }
    if ((paramActivity instanceof OnPhotoEditListener))
    {
      photoEditListener = ((OnPhotoEditListener)paramActivity);
      return;
    }
    if (profileViewListener != null)
    {
      photoEditListener = profileViewListener;
      return;
    }
    throw new IllegalStateException("Activity must implement OnPhotoEditListener");
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    photoUri = paramUri;
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramType == DataStore.Type.NETWORK) && (paramSet != null) && (ProfileRoutes.isEditTopCardRoute(getProfileId(), paramSet)))
    {
      photoUtils.deleteTempFiles(getActivity());
      dismissSubmitProgressDialog();
      photoEditListener.onPhotoSaved();
    }
  }
  
  @Subscribe
  public void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    if (filePath.equals(photoUri))
    {
      Log.d(TAG, "Failed to upload profile photo: " + error.getMessage());
      return;
    }
    Log.d(TAG, "Failed to upload cropped profile photo: " + error.getMessage());
  }
  
  public final void onFormSubmitFailure()
  {
    photoUtils.deleteTempFiles(getActivity());
  }
  
  public final void onFormSubmitSuccess()
  {
    try
    {
      if (modifiedNormProfileBuilder != null)
      {
        getDataProvider().setModifiedNormProfileModel(modifiedNormProfileBuilder.build(RecordTemplate.Flavor.RECORD));
        photoEditListener.onPhotoSaved();
        photoUtils.deleteTempFiles(getActivity());
        dismissSubmitProgressDialog();
        return;
      }
      Object localObject;
      String str;
      Profile localProfile;
      if ((getDataProvider() != null) && (getDataProvider().isDataAvailable()))
      {
        localObject = getDataProviderstate).masterImageId;
        str = getDataProviderstate).croppedImageId;
        if ((localObject != null) && (str != null))
        {
          localProfile = getDataProvider().getProfileModel();
          if (localProfile != null) {
            if ((hasPictureInfo) && (pictureInfo.masterImage.equals(localObject)))
            {
              boolean bool = pictureInfo.croppedImage.equals(str);
              if (bool) {
                return;
              }
            }
          }
        }
      }
      NormProfile localNormProfile;
      NormProfile.Builder localBuilder;
      return;
    }
    catch (BuilderException localBuilderException1)
    {
      try
      {
        localNormProfile = ProfileModelUtils.toNormProfile(localProfile);
        localBuilder = new NormProfile.Builder(localNormProfile);
        localBuilder.setPictureInfo(PhotoUtils.createPicture((String)localObject, str));
        localObject = localBuilder.build(RecordTemplate.Flavor.RECORD);
        getDataProvider().postUpdateProfilePicture(busSubscriberId, getRumSessionId(), entityUrn.getId(), localNormProfile, (NormProfile)localObject, versionTag, Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
      catch (BuilderException localBuilderException2)
      {
        Util.safeThrow(new RuntimeException("Failed to convert profile to core profile", localBuilderException2));
      }
      localBuilderException1 = localBuilderException1;
      Util.safeThrow(new RuntimeException("Failed to get build the core profile in Profile Edit Photo Fragment: " + localBuilderException1.getMessage()));
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("photoUri", photoUri);
  }
  
  public final void onUploadFail()
  {
    onFormSubmitFailure();
  }
  
  public final void onUploadSuccess(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int j = 0;
    int i;
    if (photoUri != null)
    {
      i = j;
      if (paramString3 != null)
      {
        i = j;
        if (paramString1 != null)
        {
          i = j;
          if (paramString2 != null)
          {
            i = j;
            if (paramString4 != null)
            {
              getDataProvider().setMasterImageId(paramString1);
              getDataProvider().setCroppedImageId(paramString2);
              getDataProvider().setMasterImageUploadSignature(paramString3);
              getDataProvider().setCroppedImageUploadSignature(paramString4);
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (modifiedNormProfileBuilder != null) {
        paramString3 = null;
      }
      try
      {
        paramString1 = PhotoUtils.createPicture(paramString1, paramString2);
        modifiedNormProfileBuilder.setPictureInfo(paramString1);
        i = 1;
        if (i != 0) {
          onFormSubmitSuccess();
        }
        return;
        i = j;
        if (photoId == null) {
          continue;
        }
        i = j;
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString2 == null) {
          continue;
        }
        i = j;
        if (paramString4 == null) {
          continue;
        }
        getDataProvider().setMasterImageId(paramString1);
        getDataProvider().setCroppedImageId(paramString2);
        getDataProvider().setCroppedImageUploadSignature(paramString4);
        i = 1;
      }
      catch (BuilderException paramString1)
      {
        for (;;)
        {
          getContext();
          Util.safeThrow$7a8b4789(new RuntimeException(paramString1));
          paramString1 = paramString3;
        }
      }
    }
  }
  
  public final void onUserSelected(int paramInt)
  {
    if ((photoCropFragment == null) || (photoCropFragment.getHost() == null))
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Host of child fragment is null, cannot proceed with onUserSelect"));
      return;
    }
    getChildFragmentManager().popBackStackImmediate();
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      photoUtils.onUserSelection(paramInt, null, this, this, tracker, str);
      return;
      str = "profile_self_member_photo_view";
      continue;
      str = "profile_self_member_photo_library";
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    enableEditSave = true;
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_self_member_photo_crop";
  }
  
  @OnClick({2131757570})
  public void retakePhoto()
  {
    if (!PhotoUtils.deviceHasCamera(getActivity()))
    {
      PhotoUtils.startImageChooserForResult(this);
      return;
    }
    ProfilePictureSelectDialogFragment localProfilePictureSelectDialogFragment = ProfilePictureSelectDialogFragment.newInstance(ProfilePictureSelectDialogBundleBuilder.create(false));
    onUserSelectionListener = this;
    localProfilePictureSelectDialogFragment.show(getFragmentManager(), "selectionDialog");
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    super.setFragmentData(paramBundle);
    if (paramBundle != null) {}
    for (photoUri = ((Uri)paramBundle.getParcelable("photoUri"));; photoUri = ((Uri)getArguments().getParcelable("photoUri")))
    {
      photoId = getArguments().getString("photoId");
      return;
    }
  }
  
  protected final void updateProfileData()
  {
    photoCropFragment.onCropComplete();
  }
  
  public static abstract interface OnPhotoEditListener
  {
    public abstract void onPhotoEditCancel();
    
    public abstract void onPhotoSaved();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */