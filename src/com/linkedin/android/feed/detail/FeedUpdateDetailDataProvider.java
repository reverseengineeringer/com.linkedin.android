package com.linkedin.android.feed.detail;

import android.net.Uri;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;

public final class FeedUpdateDetailDataProvider
  extends DataProvider<UpdateDetailState, DataProvider.DataProviderListener>
{
  @Inject
  public FeedUpdateDetailDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  static void addCommentRequests(MultiplexRequest.Builder paramBuilder, String[] paramArrayOfString, Map<String, String> paramMap)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          paramBuilder.optional(Request.get().url(FeedRouteUtils.getSingleCommentUrl(str)).customHeaders(paramMap).builder(Comment.BUILDER).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
        }
        i += 1;
      }
    }
  }
  
  static void addLikeRequests(MultiplexRequest.Builder paramBuilder, String[] paramArrayOfString, Map<String, String> paramMap)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          paramBuilder.optional(Request.get().url(FeedRouteUtils.getSingleLikeUrl(str)).customHeaders(paramMap).builder(Like.BUILDER).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
        }
        i += 1;
      }
    }
  }
  
  final RecordTemplateListener<CollectionTemplate<Comment, Metadata>> getCommentsListener(final Uri paramUri, final String paramString1, final String paramString2, final int paramInt)
  {
    new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<CollectionTemplate<Comment, Metadata>> paramAnonymousDataStoreResponse)
      {
        activityComponent.eventBus();
        if (error != null)
        {
          Bus.publish(new DataErrorEvent(paramString1, paramString2, Collections.singleton(paramUri.toString()), type, error));
          return;
        }
        Bus.publish(new CollectionDataEvent(paramString1, paramString2, paramUri.toString(), type, (CollectionTemplate)model, paramInt));
      }
    };
  }
  
  public final boolean hasNextComments()
  {
    if ((state).commentsCollectionHelper != null) && (state).commentsCollectionHelper.getPaging() != null) && (state).commentsCollectionHelper.getPaging().total == 0)) {
      return false;
    }
    return (state).commentsCollectionHelper != null) && (state).commentsCollectionHelper.hasMoreDataToFetch());
  }
  
  public final void initCommentsCollectionTemplate(SocialDetail paramSocialDetail, FlagshipDataManager paramFlagshipDataManager)
  {
    if (paramSocialDetail == null) {
      return;
    }
    paramSocialDetail = comments;
    paramSocialDetail = new CollectionTemplate(elements, null, paging, null, null, true, true, true);
    state).commentsCollectionHelper = new CollectionTemplateHelper(paramFlagshipDataManager, null, paramSocialDetail, Comment.BUILDER, Metadata.BUILDER);
  }
  
  public final void performFullUpdateFetch(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, Map<String, String> paramMap)
  {
    state).updateRoute = paramString3;
    Object localObject = newModelListener(paramString1, paramString2);
    paramString3 = Request.get().url(paramString3).customHeaders(paramMap).builder(Update.BUILDER).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    localObject = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramString3 = ((MultiplexRequest.Builder)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(paramString3);
    addCommentRequests(paramString3, paramArrayOfString1, paramMap);
    addCommentRequests(paramString3, paramArrayOfString3, paramMap);
    addLikeRequests(paramString3, paramArrayOfString2, paramMap);
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3);
  }
  
  public static final class UpdateDetailState
    extends DataProvider.State
  {
    public CollectionTemplateHelper<Comment, Metadata> commentsCollectionHelper;
    public String socialDetailRoute;
    public String updateRoute;
    
    public UpdateDetailState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    public final Comment comment(String paramString)
    {
      return (Comment)getModel(FeedRouteUtils.getSingleCommentUrl(paramString));
    }
    
    public final Update update()
    {
      return (Update)getModel(updateRoute);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */