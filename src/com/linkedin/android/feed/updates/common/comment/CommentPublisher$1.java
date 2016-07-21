package com.linkedin.android.feed.updates.common.comment;

import android.content.Context;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.net.URISyntaxException;

public final class CommentPublisher$1
  implements RecordTemplateListener<VoidRecord>
{
  public CommentPublisher$1(CommentPublisher paramCommentPublisher, Context paramContext, Update paramUpdate1, Comment paramComment, Update paramUpdate2, Urn paramUrn) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    Update localUpdate2 = null;
    Object localObject2 = OptimisticWrite.getModelIdFromHeaders(paramDataStoreResponse);
    Object localObject1 = localUpdate2;
    if (localObject2 != null) {}
    Update localUpdate1;
    try
    {
      localObject1 = Urn.createFromString((String)localObject2);
      if ((error != null) || (localObject1 == null))
      {
        paramDataStoreResponse = CommentModelUtils.removeCommentFromUpdate(val$updateWithComment, val$comment.urn.toString());
        if (paramDataStoreResponse == null)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Problem removing optimistic comment"));
          return;
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("couldn't parse the urn from the optimistic write response! [" + (String)localObject2 + "]"));
        localUpdate1 = localUpdate2;
      }
      Bus.publish(FeedCommentUpdateEvent.confirmDeleteCommentEvent(paramDataStoreResponse, val$comment));
      Toast.makeText(val$context, 2131231157, 1).show();
      return;
    }
    paramDataStoreResponse = null;
    try
    {
      if (val$update.value.discussionUpdateValue == null) {
        paramDataStoreResponse = new SocialDetail.Builder(val$comment.socialDetail).setUrn(localUpdate1).setEntityUrn(Urn.createFromTuple("fs_socialDetail", new Object[] { localUpdate1 })).setThreadId(localUpdate1.getNSS()).build(RecordTemplate.Flavor.RECORD);
      }
      paramDataStoreResponse = new Comment.Builder(val$comment).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localUpdate1 })).setUrn(localUpdate1).setSocialDetail(paramDataStoreResponse).build();
      localUpdate2 = CommentModelUtils.updateCommentWithinUpdate(val$updateWithComment, paramDataStoreResponse, val$comment);
      if (localUpdate2 == null)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Error updating comment within update"));
        return;
      }
    }
    catch (BuilderException paramDataStoreResponse)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramDataStoreResponse));
      return;
    }
    FeedBundleBuilder.saveUpdateToCache(this$0.dataManager, localUpdate2);
    localObject2 = val$fakeUrn;
    FeedCommentUpdateEvent localFeedCommentUpdateEvent = new FeedCommentUpdateEvent();
    updateEventType = 7;
    newUpdate = localUpdate2;
    changedComment = paramDataStoreResponse;
    fakeId = ((Urn)localObject2).toString();
    realId = localUpdate1.toString();
    Bus.publish(localFeedCommentUpdateEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.CommentPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */