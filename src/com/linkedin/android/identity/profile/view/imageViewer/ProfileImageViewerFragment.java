package com.linkedin.android.identity.profile.view.imageViewer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.edit.ProfileEditFragmentUtils;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.ProfilePictureSelectDialogFragment.OnUserSelectionListener;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class ProfileImageViewerFragment
  extends PageFragment
  implements ProfilePictureSelectDialogFragment.OnUserSelectionListener, OnBackPressedListener, PhotoUtils.UriListener
{
  @InjectView(2131757657)
  ImageView cameraButton;
  @InjectView(2131757656)
  ImageView cropButton;
  @InjectView(2131757658)
  ImageView deleteButton;
  @InjectView(2131757655)
  LinearLayout editPanel;
  @InjectView(2131757654)
  ImageView imageHolder;
  private String masterImage;
  private Uri photoUri;
  @Inject
  PhotoUtils photoUtils;
  private String profileId;
  private ProfileViewListener profileViewListener;
  private ProgressDialog progressDialog;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  private ProfileDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.profileDataProvider();
  }
  
  public static ProfileImageViewerFragment newInstance()
  {
    return new ProfileImageViewerFragment();
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if ((profileId != null) && (fragmentComponent.memberUtil().isSelf(profileId))) {}
    for (String str = "profile_self_member_photo_view";; str = "profile_view_member_photo")
    {
      delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, str));
      return;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 11) {
        break label65;
      }
      photoUri = paramIntent.getData();
    }
    for (;;)
    {
      if ((photoUri != null) && (!photoUri.toString().isEmpty()))
      {
        if (profileViewListener == null) {
          break;
        }
        ProfileEditFragmentUtils.startEditPhoto(profileViewListener, photoUri);
      }
      return;
      label65:
      if (paramInt1 == 12) {
        getActivity().getContentResolver().notifyChange(photoUri, null);
      }
    }
    ProfileEditFragmentUtils.startEditPhoto((ProfileEditListener)getActivity(), photoUri);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public final boolean onBackPressed()
  {
    getFragmentManager().popBackStack();
    return true;
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    photoUri = paramUri;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    getDataProvider().setModifiedNormProfileModel(null);
    getDataProvider().setMasterImageUploadSignature(null);
    getDataProvider().setCroppedImageUploadSignature(null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return paramLayoutInflater.inflate(2130969210, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramType == DataStore.Type.NETWORK) && (paramSet != null) && (ProfileRoutes.isEditTopCardRoute(profileId, paramSet)))
    {
      photoUtils.deleteTempFiles(getActivity());
      if (progressDialog != null) {
        progressDialog.dismiss();
      }
      onBackPressed();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    toolbar.setNavigationOnClickListener(null);
  }
  
  public final void onUserSelected(int paramInt)
  {
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
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setBackgroundColor(getResources().getColor(2131624051));
    toolbar.setNavigationOnClickListener(new ProfileImageViewerFragment.1(this));
    cropButton.setOnClickListener(new ProfileImageViewerFragment.2(this, tracker, "profile_photo_crop", new TrackingEventBuilder[0]));
    cameraButton.setOnClickListener(new ProfileImageViewerFragment.3(this, tracker, "profile_photo_upload", new TrackingEventBuilder[0]));
    deleteButton.setOnClickListener(new ProfileImageViewerFragment.4(this, tracker, "profile_photo_delete", new TrackingEventBuilder[0]));
    paramView = getDataProvider();
    if (paramView.getProfileModel() != null)
    {
      paramView = paramView.getProfileModel();
      profileId = miniProfile.entityUrn.getId();
      if (hasPictureInfo) {
        masterImage = pictureInfo.masterImage;
      }
      paramView = miniProfile.picture;
      fragmentComponent.mediaCenter().load(paramView, getRumSessionId()).into(imageHolder);
      if (fragmentComponent.memberUtil().isSelf(profileId)) {
        if ("control".equals(getActivityactivityComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_PHOTO_EDIT))) {
          break label276;
        }
      }
    }
    label276:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        editPanel.setVisibility(0);
      }
      return;
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_base_member_photo_view";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.imageViewer.ProfileImageViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */