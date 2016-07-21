package com.linkedin.android.publishing.sharing.compose;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.mediaupload.SlideShareResponse;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.AvailableSizes;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.Size;
import com.linkedin.android.infra.mediaupload.SlideShareUploadFinishedEvent;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.Image.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.publishing.sharing.events.GroupUpdateCreatedEvent;
import com.linkedin.android.publishing.sharing.events.GroupUpdateCreatedSuccessEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;

public final class GroupSharePublisher
{
  protected final FlagshipApplication app;
  protected final Bus bus;
  protected final FlagshipDataManager dataManager;
  private final ImageLoaderCache imageCache;
  protected final MediaUploader mediaUploader;
  public final List<Update> pendingShares = new ArrayList();
  private final Map<String, GroupSharePublisher.PendingSlideShareUpload> pendingSlideShareUploads = new HashMap();
  
  public GroupSharePublisher(Context paramContext, FlagshipDataManager paramFlagshipDataManager, Bus paramBus, MediaUploader paramMediaUploader, ImageLoaderCache paramImageLoaderCache)
  {
    app = ((FlagshipApplication)paramContext.getApplicationContext());
    dataManager = paramFlagshipDataManager;
    bus = paramBus;
    mediaUploader = paramMediaUploader;
    imageCache = paramImageLoaderCache;
    Bus.subscribe(this);
  }
  
  @Subscribe
  public final void onEvent(SlideShareUploadFinishedEvent paramSlideShareUploadFinishedEvent)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (pendingSlideShareUploads.containsKey(uploadId))
    {
      localObject1 = responseModel;
      localObject2 = uploadId;
      paramSlideShareUploadFinishedEvent = trackingHeader;
      localObject3 = new MediaProxyImage.Builder().setUrl(((SlideShareResponse)localObject1).getUrl("original"));
      if ((availableSizes != null) && (availableSizes.original != null))
      {
        SlideShareResponse.Size localSize = availableSizes.original;
        ((MediaProxyImage.Builder)localObject3).setOriginalWidth(Integer.valueOf(width));
        ((MediaProxyImage.Builder)localObject3).setOriginalHeight(Integer.valueOf(height));
      }
    }
    try
    {
      localObject3 = new Image.Builder().setMediaProxyImageValue(((MediaProxyImage.Builder)localObject3).build(RecordTemplate.Flavor.RECORD)).build();
      localObject2 = (GroupSharePublisher.PendingSlideShareUpload)pendingSlideShareUploads.remove(localObject2);
      localObject1 = GroupDiscussionModelGenUtils.generateDiscussionUpdate$29b7c900(newShare, (Image)localObject3, fileKey);
      if ((localObject1 != null) && (paramSlideShareUploadFinishedEvent != null)) {
        publishNewDiscussion(paramSlideShareUploadFinishedEvent, (Update)localObject1, value.discussionUpdateValue.miniGroup.entityUrn.getId(), true);
      }
      paramSlideShareUploadFinishedEvent = imageCache.get(imageUri.toString());
      if (paramSlideShareUploadFinishedEvent != null) {
        imageCache.put(mediaProxyImageValue.url, paramSlideShareUploadFinishedEvent);
      }
      return;
    }
    catch (BuilderException paramSlideShareUploadFinishedEvent)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("can't create this image model", paramSlideShareUploadFinishedEvent));
    }
  }
  
  public final void onPostGroupUpdateCreateSuccess(GroupUpdateCreatedSuccessEvent paramGroupUpdateCreatedSuccessEvent, FragmentComponent paramFragmentComponent)
  {
    if (newUpdate == null)
    {
      paramGroupUpdateCreatedSuccessEvent = new GroupSharePublisher.4(this, paramFragmentComponent.tracker(), "see_moderation_details", new TrackingEventBuilder[0], paramFragmentComponent);
      paramFragmentComponent.snackbarUtil().showWhenAvailable(SnackbarBuilder.basic(app, 2131233665, 2131233666, -16711681, paramGroupUpdateCreatedSuccessEvent, 5000));
      return;
    }
    paramGroupUpdateCreatedSuccessEvent = new GroupSharePublisher.3(this, newUpdate, paramFragmentComponent);
    paramFragmentComponent.snackbarUtil().showWhenAvailable(SnackbarBuilder.basic(app, 2131233668, 2131233669, -16711681, paramGroupUpdateCreatedSuccessEvent, 5000));
  }
  
  public final String onSlideShareUploadFailed(FragmentComponent paramFragmentComponent, UploadFailedEvent paramUploadFailedEvent, Map<String, String> paramMap)
  {
    if (!pendingSlideShareUploads.containsKey(optimisticUpdateId)) {
      return null;
    }
    paramUploadFailedEvent = (GroupSharePublisher.PendingSlideShareUpload)pendingSlideShareUploads.remove(optimisticUpdateId);
    removeFromPendingShares(newShare);
    paramMap = new GroupSharePublisher.6(this, paramUploadFailedEvent, paramMap);
    paramFragmentComponent.snackbarUtil().showWhenAvailable(SnackbarBuilder.basic(app, 2131233663, 2131233680, -65536, paramMap, 5000));
    if (newShare.urn == null) {
      return null;
    }
    return newShare.urn.toString();
  }
  
  final void publishNewDiscussion(Map<String, String> paramMap, Update paramUpdate, String paramString, boolean paramBoolean)
  {
    GroupSharePublisher.1 local1 = new GroupSharePublisher.1(this, paramMap, paramUpdate, paramString);
    dataManager.submit(Request.post().url(Routes.GROUP.buildRouteForId(paramString).buildUpon().appendPath("discussions").build().toString()).customHeaders(paramMap).model(paramUpdate).listener(local1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    if (!paramBoolean)
    {
      pendingShares.add(0, paramUpdate);
      Bus.publish(new GroupUpdateCreatedEvent(paramUpdate));
    }
  }
  
  final void publishSlideShare(GroupSharePublisher.PendingSlideShareUpload paramPendingSlideShareUpload, Map<String, String> paramMap)
  {
    Bus.publish(new GroupUpdateCreatedEvent(newShare));
    pendingShares.add(0, newShare);
    pendingSlideShareUploads.put(tempId, paramPendingSlideShareUpload);
    mediaUploader.submitSlideShareUpload(tempId, imageUri, tempId, paramMap);
  }
  
  final void removeFromPendingShares(Update paramUpdate)
  {
    int i = 0;
    for (;;)
    {
      if (i < pendingShares.size())
      {
        Update localUpdate = (Update)pendingShares.get(i);
        if ((urn != null) && (urn.equals(urn))) {
          pendingShares.remove(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.compose.GroupSharePublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */