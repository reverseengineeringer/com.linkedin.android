package com.linkedin.android.feed.updates.common.comment.detail;

import android.net.Uri;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import java.util.Collections;
import javax.inject.Inject;

public final class CommentDetailDataProvider
  extends DataProvider<CommentDetailState, DataProvider.DataProviderListener>
{
  @Inject
  public CommentDetailDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
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
  
  public final void initCommentsCollectionTemplate(SocialDetail paramSocialDetail, FlagshipDataManager paramFlagshipDataManager)
  {
    if (paramSocialDetail == null) {
      return;
    }
    paramSocialDetail = comments;
    paramSocialDetail = new CollectionTemplate(elements, null, paging, null, null, true, true, true);
    state).commentsCollectionHelper = new CollectionTemplateHelper(paramFlagshipDataManager, null, paramSocialDetail, Comment.BUILDER, Metadata.BUILDER);
  }
  
  public static final class CommentDetailState
    extends DataProvider.State
  {
    public CollectionTemplateHelper<Comment, Metadata> commentsCollectionHelper;
    public String singleCommentRoute;
    public String socialDetailRoute;
    
    public CommentDetailState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */