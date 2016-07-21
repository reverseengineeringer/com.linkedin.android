package com.linkedin.android.feed.updates.common.comment.detail;

import android.net.Uri;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import java.util.Collections;

final class CommentDetailDataProvider$1
  implements RecordTemplateListener<CollectionTemplate<Comment, Metadata>>
{
  CommentDetailDataProvider$1(CommentDetailDataProvider paramCommentDetailDataProvider, String paramString1, String paramString2, Uri paramUri, int paramInt) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<Comment, Metadata>> paramDataStoreResponse)
  {
    this$0.activityComponent.eventBus();
    if (error != null)
    {
      Bus.publish(new DataErrorEvent(val$subscriberId, val$rumSessionId, Collections.singleton(val$baseUrl.toString()), type, error));
      return;
    }
    Bus.publish(new CollectionDataEvent(val$subscriberId, val$rumSessionId, val$baseUrl.toString(), type, (CollectionTemplate)model, val$state));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */