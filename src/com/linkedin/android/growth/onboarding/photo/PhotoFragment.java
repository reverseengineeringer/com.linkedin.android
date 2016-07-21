package com.linkedin.android.growth.onboarding.photo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.PhotoCropListener;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONObject;

public class PhotoFragment
  extends OnboardingProfileEditFragment
  implements PhotoCropListener, PhotoUtils.UriListener
{
  @Inject
  Context context;
  @InjectView(2131756106)
  Button continueButton;
  String croppedImageId;
  String croppedImageSignature;
  @Inject
  FragmentRegistry fragmentRegistry;
  @InjectView(2131756216)
  TextView headline;
  private boolean isPhotoSet;
  @InjectView(2131756217)
  TextView location;
  String masterImageId;
  String masterImageSignature;
  Uri masterPhotoUri;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MemberUtil memberUtil;
  @InjectView(2131756215)
  TextView name;
  int photoSource;
  @Inject
  PhotoUtils photoUtils;
  @InjectView(2131756213)
  LiImageView pictureFrame;
  @Inject
  ProfileUtil profileUtil;
  boolean shouldStartPhotoCrop;
  @Inject
  SnackbarUtil snackbar;
  @InjectView(2131756132)
  TextView subtitle;
  @InjectView(2131756131)
  TextView title;
  
  private JSONObject createPhotoDiff()
  {
    if (getDataProvider().isProfileAvailable()) {
      try
      {
        Object localObject = ProfileModelUtils.toNormProfile(getDataProvider().getProfile());
        localObject = createProfileDiff((NormProfile)localObject, new NormProfile.Builder((NormProfile)localObject).setPictureInfo(PhotoUtils.createPicture(masterImageId, croppedImageId)).build(RecordTemplate.Flavor.RECORD));
        return (JSONObject)localObject;
      }
      catch (BuilderException localBuilderException)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed NormProfile validation", localBuilderException));
        return null;
      }
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Profile is not available"));
    getDataProvider().fetchProfile("", null, Tracker.createPageInstanceHeader(getPageInstance()));
    return null;
  }
  
  private void loadImageIntoPictureFrame(String paramString)
  {
    isPhotoSet = true;
    pictureFrame.setOval(true);
    I18NManager localI18NManager = i18NManager;
    title.setText(localI18NManager.getString(2131231586, new Object[] { I18NManager.getName(memberUtil.getMiniProfile()) }));
    if (getDataProvider().isProfileAvailable())
    {
      paramString = mediaCenter.load(paramString);
      placeholderDrawable = GhostImageUtils.getPerson(2131492968, getDataProvidergetProfileminiProfile).getDrawable(context);
      paramString.into(pictureFrame);
    }
    for (;;)
    {
      subtitle.setText(i18NManager.getString(2131231587));
      continueButton.setText(2131231512);
      continueButton.setOnClickListener(new PhotoFragment.4(this, legoWidget.getTrackingToken(), ActionCategory.PRIMARY_ACTION, legoTrackingDataProvider, tracker, "continue", new TrackingEventBuilder[0]));
      skipButton.setText(2131231585);
      skipButton.setOnClickListener(new PhotoFragment.5(this, tracker, "edit", new TrackingEventBuilder[0]));
      pictureFrame.setOnClickListener(null);
      return;
      getDataProvider().fetchProfile(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
      paramString = mediaCenter.load(paramString);
      placeholderDrawable = GhostImageUtils.getAnonymousPerson(2131492968).getDrawable(context);
      paramString.into(pictureFrame);
    }
  }
  
  private void setFieldsToInitialState()
  {
    isPhotoSet = false;
    title.setText(2131231590);
    subtitle.setText(2131231589);
    skipButton.setEnabled(true);
    skipButton.setVisibility(0);
    skipButton.setText(2131231613);
    skipButton.setOnClickListener(new PhotoFragment.1(this, legoWidget.getTrackingToken(), ActionCategory.SKIP, legoTrackingDataProvider, tracker, "skip", new TrackingEventBuilder[0]));
    continueButton.setText(2131231580);
    continueButton.setOnClickListener(new PhotoFragment.2(this, tracker, "add_photo_button", new TrackingEventBuilder[0]));
    pictureFrame.setOval(false);
    pictureFrame.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    pictureFrame.setImageResource(2130837865);
    pictureFrame.setOnClickListener(new PhotoFragment.3(this, tracker, "add_photo_image", new TrackingEventBuilder[0]));
    Object localObject = getDataProvider().getProfile();
    if (localObject != null) {
      setTopCardInformation((Profile)localObject);
    }
    localObject = getActivity().getIntent().getExtras();
    if (localObject == null) {}
    for (localObject = null;; localObject = (Uri)((Bundle)localObject).getParcelable("smartlockImageUri"))
    {
      if (localObject != null)
      {
        shouldStartPhotoCrop = true;
        masterPhotoUri = ((Uri)localObject);
        photoSource = -1;
      }
      return;
    }
  }
  
  private void setTopCardInformation(Profile paramProfile)
  {
    I18NManager localI18NManager = i18NManager;
    name.setText(localI18NManager.getString(2131233236, new Object[] { I18NManager.getName(miniProfile) }));
    headline.setText(headline);
    if (hasLocationName)
    {
      location.setText(locationName);
      return;
    }
    location.setVisibility(8);
  }
  
  public final void doResume()
  {
    super.doResume();
    continueButton.setEnabled(true);
    if ((shouldStartPhotoCrop) && (masterPhotoUri != null))
    {
      PhotoLegoWidget localPhotoLegoWidget = (PhotoLegoWidget)legoWidget;
      Object localObject = masterPhotoUri;
      int i = photoSource;
      Fragment localFragment = localPhotoLegoWidget.getCurrentActiveFragment();
      currentFragmentTag = "crop";
      localObject = fragmentRegistry.onboardingPhotoCrop.newFragment(new OnboardingPhotoCropBundle((Uri)localObject, i));
      ((Fragment)localObject).setTargetFragment(localFragment, 0);
      localPhotoLegoWidget.addFragment$4857f75f((Fragment)localObject, currentFragmentTag);
      shouldStartPhotoCrop = false;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 11)
      {
        masterPhotoUri = paramIntent.getData();
        photoSource = 1;
        shouldStartPhotoCrop = true;
      }
    }
    else {
      return;
    }
    if (paramInt1 == 12)
    {
      if (masterPhotoUri == null)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new IllegalStateException("Camera returned result but masterPhotoUri was never set"));
      }
      photoSource = 0;
      shouldStartPhotoCrop = true;
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalArgumentException("onActivityResult called with unknown request code"));
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    masterPhotoUri = paramUri;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968843, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet != null) && ((paramSet.contains(getDataProviderstate).editProfileRoute)) || (paramSet.contains(getDataProviderstate).profileRoute)))) {
      onPostFailed();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet != null) && (paramSet.contains(getDataProviderstate).profileRoute))) {
      setTopCardInformation((Profile)getgetDataProviderstate).profileRoute)).model);
    }
    while ((paramSet == null) || (!paramSet.contains(getDataProviderstate).editProfileRoute))) {
      return;
    }
    onPostSuccess();
  }
  
  protected final void onInputError() {}
  
  protected final void onPostFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231509, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  protected final void onPostSuccess()
  {
    Snackbar localSnackbar = snackbar.make(2131231591, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
    legoWidget.finishCurrentFragment();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("masterPhotoUri", masterPhotoUri);
    paramBundle.putString("masterImageId", masterImageId);
    paramBundle.putString("masterImageSig", masterImageSignature);
    paramBundle.putString("croppedImageId", croppedImageId);
    paramBundle.putString("croppedImageSig", croppedImageSignature);
    paramBundle.putBoolean("shouldStartPhotoCrop", shouldStartPhotoCrop);
    paramBundle.putInt("photoSource", photoSource);
  }
  
  public final void onUploadFail()
  {
    onPostFailed();
  }
  
  public final void onUploadSuccess(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    masterImageId = paramString1;
    masterImageSignature = paramString3;
    croppedImageId = paramString2;
    croppedImageSignature = paramString4;
    loadImageIntoPictureFrame(paramString2);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    setFieldsToInitialState();
    if (paramBundle != null)
    {
      masterPhotoUri = ((Uri)paramBundle.getParcelable("masterPhotoUri"));
      masterImageId = paramBundle.getString("masterImageId");
      masterImageSignature = paramBundle.getString("masterImageSig");
      croppedImageId = paramBundle.getString("croppedImageId");
      croppedImageSignature = paramBundle.getString("croppedImageSig");
      shouldStartPhotoCrop = paramBundle.getBoolean("shouldStartPhotoCrop");
      photoSource = paramBundle.getInt("photoSource");
      if (!TextUtils.isEmpty(croppedImageId)) {
        loadImageIntoPictureFrame(croppedImageId);
      }
    }
  }
  
  public final String pageKey()
  {
    if (isPhotoSet) {
      return "onboarding_photo_confirm";
    }
    return "onboarding_photo";
  }
  
  protected final void postData()
  {
    JSONObject localJSONObject = createPhotoDiff();
    if (localJSONObject != null)
    {
      if (localJSONObject.length() > 0)
      {
        ArrayMap localArrayMap = new ArrayMap(2);
        localArrayMap.put("masterProfilePhotoSignature", masterImageSignature);
        localArrayMap.put("croppedProfilePhotoSignature", croppedImageSignature);
        postUpdateProfile(localJSONObject, localArrayMap);
        return;
      }
      onPostSuccess();
      return;
    }
    onPostFailed();
  }
  
  protected final void startImageChooserOrCamera()
  {
    new PageViewEvent(tracker, "onboarding_photo_action_sheet", false).send();
    photoUtils.startImageChooserOrCameraForResult(this, this, tracker, "ask_for_camera", "ask_for_photo");
  }
  
  protected final boolean verifyAllInputsFilled()
  {
    return (masterPhotoUri != null) && (!TextUtils.isEmpty(masterImageId)) && (!TextUtils.isEmpty(croppedImageId));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.photo.PhotoFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */