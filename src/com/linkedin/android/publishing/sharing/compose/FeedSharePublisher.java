package com.linkedin.android.publishing.sharing.compose;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.FeedModelGenUtils;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.mediaupload.SlideShareResponse;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.AvailableSizes;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.Size;
import com.linkedin.android.infra.mediaupload.SlideShareUploadFinishedEvent;
import com.linkedin.android.infra.mediaupload.UploadProgressEvent;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.Image.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleType;
import com.linkedin.android.pegasus.gen.voyager.feed.ProviderType;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareAudience;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreatedEvent;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreatingEvent;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreationFailedEvent;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FeedSharePublisher
{
  final FlagshipApplication app;
  private final Bus bus;
  private final ConsistencyManager consistencyManager;
  private final FlagshipDataManager dataManager;
  private final ImageLoaderCache imageCache;
  private final MediaUploader mediaUploader;
  public final List<Update> pendingShares = new ArrayList();
  private final Map<String, FeedSharePublisher.PendingSlideShareUpload> pendingSlideShareUploads = new HashMap();
  
  public FeedSharePublisher(Context paramContext, FlagshipDataManager paramFlagshipDataManager, Bus paramBus, MediaUploader paramMediaUploader, ImageLoaderCache paramImageLoaderCache, ConsistencyManager paramConsistencyManager)
  {
    app = ((FlagshipApplication)paramContext.getApplicationContext());
    dataManager = paramFlagshipDataManager;
    bus = paramBus;
    mediaUploader = paramMediaUploader;
    imageCache = paramImageLoaderCache;
    consistencyManager = paramConsistencyManager;
    Bus.subscribe(this);
  }
  
  private void handleError(Map<String, String> paramMap, Update paramUpdate, List<ProviderType> paramList, Throwable paramThrowable)
  {
    Util.safeThrow$7a8b4789(new RuntimeException("Error encountered by share publisher!", paramThrowable));
    Bus.publish(new FeedUpdateCreationFailedEvent(paramUpdate, paramThrowable));
    removeFromPendingShares(paramUpdate);
    paramMap = new FeedSharePublisher.3(this, paramMap, paramUpdate, paramList);
    app.getAppComponent().snackbarUtil().showWhenAvailable(SnackbarBuilder.basic(app, 2131233663, 2131233680, -65536, paramMap, 0));
  }
  
  private static JsonModel wrapEditShareUpdate(Update paramUpdate, AnnotatedText paramAnnotatedText)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (value.reshareValue != null)
        {
          paramUpdate = value.reshareValue.shareUrn;
          if (paramUpdate == null)
          {
            Util.safeThrow$7a8b4789(new RuntimeException("Couldn't get urn for edited update", null));
            return null;
          }
        }
        else
        {
          if (value.shareUpdateValue == null) {
            break label119;
          }
          paramUpdate = value.shareUpdateValue.shareUrn;
          continue;
        }
        localJSONObject.put("urn", paramUpdate.toString());
        localJSONObject.put("text", PegasusPatchGenerator.modelToJSON(paramAnnotatedText));
        return new JsonModel(localJSONObject);
      }
      catch (JSONException paramUpdate)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Error parsing edited share into JSONObject wrapper before posting edited share", paramUpdate));
        return null;
      }
      label119:
      paramUpdate = null;
    }
  }
  
  private static JsonModel wrapUpdate(Update paramUpdate, List<ProviderType> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("update", PegasusPatchGenerator.modelToJSON(paramUpdate));
      if (paramList.size() > 0)
      {
        paramUpdate = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          paramUpdate.put((ProviderType)paramList.next());
        }
        localJSONObject.put("providerTypes", paramUpdate);
      }
    }
    catch (JSONException paramUpdate)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Error parsing update into JSONObject wrapper before posting share", paramUpdate));
      return null;
    }
    return new JsonModel(localJSONObject);
  }
  
  final void addPendingShare(Update paramUpdate)
  {
    pendingShares.add(0, paramUpdate);
  }
  
  final void handleEditShareError(BaseShareComposeFragment paramBaseShareComposeFragment, Update paramUpdate, AnnotatedText paramAnnotatedText, Throwable paramThrowable)
  {
    Util.safeThrow$7a8b4789(new RuntimeException("Error encountered by edit share publisher!", paramThrowable));
    consistencyManager.updateModel(paramUpdate);
    FeedBundleBuilder.saveUpdateToCache(dataManager, paramUpdate);
    paramUpdate = new FeedSharePublisher.4(this, paramBaseShareComposeFragment, paramUpdate, paramAnnotatedText);
    paramUpdate = SnackbarBuilder.basic(app, 2131233662, 2131233680, -65536, paramUpdate, 0);
    app.getAppComponent().snackbarUtil().showWhenAvailableWithErrorTracking$62c2858b(paramUpdate, tracker, paramBaseShareComposeFragment.getPageInstance(), "Edit share failed");
  }
  
  @Subscribe
  public final void onEvent(SlideShareUploadFinishedEvent paramSlideShareUploadFinishedEvent)
  {
    if (!pendingSlideShareUploads.containsKey(uploadId)) {}
    for (;;)
    {
      return;
      Object localObject2 = responseModel;
      Object localObject1 = new MediaProxyImage.Builder().setUrl(responseModel.getUrl("original"));
      Object localObject3;
      if ((availableSizes != null) && (availableSizes.original != null))
      {
        localObject3 = availableSizes.original;
        ((MediaProxyImage.Builder)localObject1).setOriginalWidth(Integer.valueOf(width));
        ((MediaProxyImage.Builder)localObject1).setOriginalHeight(Integer.valueOf(height));
      }
      try
      {
        localObject1 = new Image.Builder().setMediaProxyImageValue(((MediaProxyImage.Builder)localObject1).build(RecordTemplate.Flavor.RECORD)).build();
        try
        {
          localObject3 = removeFromPendingSlideShareUploads(uploadId);
          ShareImage.Builder localBuilder = new ShareImage.Builder(newShare.value.shareUpdateValue.content.shareImageValue);
          localBuilder.setContentType(contentType).setFileId(fileKey).setImage((Image)localObject1);
          localObject2 = new ShareUpdate.Builder(newShare.value.shareUpdateValue);
          ((ShareUpdate.Builder)localObject2).setContent(new ShareUpdateContent.Content.Builder().setShareImageValue(localBuilder.build(RecordTemplate.Flavor.RECORD)).build());
          localObject2 = new Update.Builder(newShare).setValue(new Update.Value.Builder().setShareUpdateValue(((ShareUpdate.Builder)localObject2).build()).build()).build();
          publishNewShare(trackingHeader, (Update)localObject2, audiences);
          paramSlideShareUploadFinishedEvent = imageCache.get(imageUri.toString());
          if (paramSlideShareUploadFinishedEvent == null) {
            continue;
          }
          imageCache.put(mediaProxyImageValue.url, paramSlideShareUploadFinishedEvent);
          return;
        }
        catch (BuilderException paramSlideShareUploadFinishedEvent)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("can't publish new share", paramSlideShareUploadFinishedEvent));
          return;
        }
        return;
      }
      catch (BuilderException paramSlideShareUploadFinishedEvent)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("can't create this image model", paramSlideShareUploadFinishedEvent));
      }
    }
  }
  
  public final void publishEditShare(BaseShareComposeFragment paramBaseShareComposeFragment, Update paramUpdate, AnnotatedText paramAnnotatedText)
  {
    Update localUpdate = FeedModelGenUtils.editUpdateText(paramUpdate, paramAnnotatedText);
    JsonModel localJsonModel = wrapEditShareUpdate(localUpdate, paramAnnotatedText);
    if (localJsonModel == null) {
      handleEditShareError(paramBaseShareComposeFragment, paramUpdate, paramAnnotatedText, new RuntimeException("Error wrapping edit share update"));
    }
    paramUpdate = new FeedSharePublisher.2(this, paramBaseShareComposeFragment, paramUpdate, paramAnnotatedText);
    paramBaseShareComposeFragment = Tracker.createPageInstanceHeader(paramBaseShareComposeFragment.getPageInstance());
    consistencyManager.updateModel(localUpdate);
    FeedBundleBuilder.saveUpdateToCache(dataManager, localUpdate);
    dataManager.submit(Request.post().url(Routes.FEED_SHARES.buildUponRoot().buildUpon().appendQueryParameter("action", "edit").toString()).customHeaders(paramBaseShareComposeFragment).model(localJsonModel).builder(JsonModel.BUILDER).listener(paramUpdate).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final Update publishNewShare(Map<String, String> paramMap, Update paramUpdate, List<ProviderType> paramList)
  {
    JsonModel localJsonModel = wrapUpdate(paramUpdate, paramList);
    if (localJsonModel == null)
    {
      handleError(paramMap, paramUpdate, paramList, new RuntimeException("Error wrapping update before sharing"));
      return paramUpdate;
    }
    paramList = new FeedSharePublisher.1(this, paramMap, paramUpdate, paramList);
    dataManager.submit(Request.post().url(Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("action", "create").toString()).customHeaders(paramMap).model(localJsonModel).builder(JsonModel.BUILDER).listener(paramList).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    paramMap = urn.toString();
    Bus.publish(new FeedUpdateCreatingEvent(paramMap));
    Bus.publish(new FeedUpdateCreatedEvent(paramUpdate));
    Bus.publish(new UploadProgressEvent(paramMap, 1.0F));
    return paramUpdate;
  }
  
  public final void publishSlideShare(FeedSharePublisher.PendingSlideShareUpload paramPendingSlideShareUpload, Map<String, String> paramMap)
  {
    String str = newShare.urn.toString();
    Bus.publish(new FeedUpdateCreatingEvent(str));
    addPendingShare(newShare);
    pendingSlideShareUploads.put(tempId, paramPendingSlideShareUpload);
    mediaUploader.submitSlideShareUpload(tempId, imageUri, str, paramMap);
  }
  
  public final void publishUrlPreviewArticle(Map<String, String> paramMap, UrlPreviewData paramUrlPreviewData, AnnotatedText paramAnnotatedText, MiniProfile paramMiniProfile, List<ProviderType> paramList, ShareAudience paramShareAudience)
  {
    Object localObject2 = title;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("no title in this preview, can't create a share"));
      localObject1 = "";
    }
    localObject2 = null;
    List localList = previewImages;
    if (localList.size() > 0) {
      localObject2 = get0mediaProxyImage;
    }
    paramUrlPreviewData = FeedModelGenUtils.generateShareUpdate(FeedModelGenUtils.generateShareArticle(urn, paramAnnotatedText, (Image)localObject2, ArticleType.REGULAR, (String)localObject1, source, url, resolvedUrl, description), paramMiniProfile, paramShareAudience);
    addPendingShare(paramUrlPreviewData);
    publishNewShare(paramMap, paramUrlPreviewData, paramList);
  }
  
  public final void removeFromPendingShares(Update paramUpdate)
  {
    int i = 0;
    for (;;)
    {
      if (i < pendingShares.size())
      {
        Update localUpdate = (Update)pendingShares.get(i);
        if (urn.equals(urn)) {
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
  
  public final FeedSharePublisher.PendingSlideShareUpload removeFromPendingSlideShareUploads(String paramString)
  {
    return (FeedSharePublisher.PendingSlideShareUpload)pendingSlideShareUploads.remove(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.compose.FeedSharePublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */