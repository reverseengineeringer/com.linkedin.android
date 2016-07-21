package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.cropphotoview.PhotoView;
import com.linkedin.android.identity.shared.asyncTasks.CreateCroppedImageFileAsyncTask;
import com.linkedin.android.identity.shared.asyncTasks.CreateCroppedImageFileAsyncTaskInputs;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploadFinishedEvent;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.cropoverlay.CropOverlayView;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.FileUploadTokenType;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoCropFragment
  extends PageFragment
{
  private static final String TAG = PhotoCropFragment.class.getSimpleName();
  @InjectView(2131756564)
  CropOverlayView cropOverlayView;
  String croppedImageId;
  String croppedImageSig;
  Uri croppedPhotoUri;
  @Inject
  Bus eventBus;
  private ImageListener imageListener = new PhotoCropFragment.1(this);
  String masterImageId;
  String masterImageSig;
  Uri masterPhotoUri;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MediaUploader mediaUploader;
  protected PhotoCropListener photoCropListener;
  @Inject
  public PhotoUtils photoUtils;
  @InjectView(2131756563)
  PhotoView targetPhoto;
  WeakReference<PhotoView> targetPhotoRef;
  
  public void customOnLoadSuccess(PhotoView paramPhotoView) {}
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
  }
  
  public boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() != null) && ((getParentFragment() instanceof PhotoCropListener)))
    {
      photoCropListener = ((PhotoCropListener)getParentFragment());
      return;
    }
    if ((getTargetFragment() != null) && ((getTargetFragment() instanceof PhotoCropListener)))
    {
      photoCropListener = ((PhotoCropListener)getTargetFragment());
      return;
    }
    if ((getActivity() != null) && ((getActivity() instanceof PhotoCropListener)))
    {
      photoCropListener = ((PhotoCropListener)paramActivity);
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Parent fragment/activity does not implement PhotoCropListener"));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    cropOverlayView.invalidate();
    if (masterPhotoUri != null) {
      cropOverlayView.init(mediaCenter, masterPhotoUri, imageListener, targetPhoto);
    }
    while (masterImageId == null) {
      return;
    }
    cropOverlayView.init(mediaCenter, masterImageId, imageListener, targetPhoto);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968947, paramViewGroup, false);
  }
  
  public final void onCropComplete()
  {
    if (targetPhoto != null)
    {
      if (masterPhotoUri != null) {
        mediaUploader.submitMediaUpload("master", masterPhotoUri, FileUploadTokenType.PROFILE_IMAGE);
      }
      Bitmap localBitmap = PhotoUtils.getCroppedImage(targetPhoto);
      new PhotoCropFragment.2(this, photoUtils).execute(new CreateCroppedImageFileAsyncTaskInputs[] { new CreateCroppedImageFileAsyncTaskInputs(getActivity(), localBitmap) });
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("photoView is null, cannot proceed with uploading"));
  }
  
  public void onCropFailure()
  {
    photoCropListener.onUploadFail();
  }
  
  public void onCropSuccess(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    photoCropListener.onUploadSuccess(paramString1, paramString2, paramString3, paramString4);
  }
  
  @Subscribe
  public void onEvent(MediaUploadFinishedEvent paramMediaUploadFinishedEvent)
  {
    for (;;)
    {
      try
      {
        String str1 = responseModel.getString("value");
        String str2 = responseModel.getString("sig");
        if (filePath.equals(croppedPhotoUri))
        {
          croppedImageId = str1;
          croppedImageSig = str2;
          if ((!TextUtils.isEmpty(masterImageId)) && (!TextUtils.isEmpty(croppedImageId)) && (!TextUtils.isEmpty(croppedImageSig))) {
            onCropSuccess(masterImageId, croppedImageId, masterImageSig, croppedImageSig);
          }
          return;
        }
        if (filePath.equals(masterPhotoUri))
        {
          masterImageId = str1;
          masterImageSig = str2;
          continue;
        }
        getActivity();
      }
      catch (JSONException paramMediaUploadFinishedEvent)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Json error"));
        photoCropListener.onUploadFail();
        return;
      }
      Util.safeThrow$7a8b4789(new IllegalArgumentException("invalid photo passed to media uploader"));
    }
  }
  
  @Subscribe
  public void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    if (croppedPhotoUri.equals(filePath)) {
      Log.e(TAG, "Failed to upload cropped profile photo: " + error.getMessage());
    }
    for (;;)
    {
      onCropFailure();
      return;
      if (masterPhotoUri.equals(filePath))
      {
        Log.e(TAG, "Failed to upload master photo: " + error.getMessage());
      }
      else
      {
        getActivity();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("invalid photo passed to media uploader"));
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    prepareViewRefs();
    if (getArguments() != null)
    {
      masterPhotoUri = ((Uri)getArguments().getParcelable("master_photo_uri"));
      masterImageId = getArguments().getString("master_photo_id");
    }
    if (masterPhotoUri != null) {
      cropOverlayView.init(mediaCenter, masterPhotoUri, imageListener, targetPhoto);
    }
    while (masterImageId == null) {
      return;
    }
    cropOverlayView.init(mediaCenter, masterImageId, imageListener, targetPhoto);
  }
  
  public String pageKey()
  {
    return "";
  }
  
  public void prepareViewRefs()
  {
    targetPhotoRef = new WeakReference(targetPhoto);
  }
  
  public boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.PhotoCropFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */