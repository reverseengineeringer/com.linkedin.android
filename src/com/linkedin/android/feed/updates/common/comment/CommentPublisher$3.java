package com.linkedin.android.feed.updates.common.comment;

import android.content.Context;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.net.URISyntaxException;

public final class CommentPublisher$3
  implements RecordTemplateListener<VoidRecord>
{
  public CommentPublisher$3(CommentPublisher paramCommentPublisher, Context paramContext, Comment paramComment1, Comment paramComment2, Urn paramUrn) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    Comment localComment2 = null;
    Object localObject2 = OptimisticWrite.getModelIdFromHeaders(paramDataStoreResponse);
    Object localObject1 = localComment2;
    if (localObject2 != null) {}
    Comment localComment1;
    try
    {
      localObject1 = Urn.createFromString((String)localObject2);
      if ((error != null) || (localObject1 == null))
      {
        paramDataStoreResponse = CommentModelUtils.removeReplyFromComment(val$commentWithNewReply, val$reply.urn.toString());
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
        localComment1 = localComment2;
      }
      Bus.publish(FeedReplyUpdateEvent.confirmDeleteReplyEvent(paramDataStoreResponse, val$reply));
      Toast.makeText(val$context, 2131231157, 1).show();
      return;
    }
    try
    {
      paramDataStoreResponse = new SocialDetail.Builder(val$reply.socialDetail).setUrn(localComment1).setEntityUrn(Urn.createFromTuple("fs_socialDetail", new Object[] { localComment1 })).setThreadId(localComment1.getNSS()).build(RecordTemplate.Flavor.RECORD);
      paramDataStoreResponse = new Comment.Builder(val$reply).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localComment1 })).setUrn(localComment1).setSocialDetail(paramDataStoreResponse).build();
      localComment2 = CommentModelUtils.updateReplyWithinComment(val$commentWithNewReply, paramDataStoreResponse, val$reply);
      if (localComment2 == null)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Error updating reply within comment"));
        return;
      }
    }
    catch (BuilderException paramDataStoreResponse)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramDataStoreResponse));
      return;
    }
    FeedBundleBuilder.saveCommentToCache(this$0.dataManager, localComment2);
    localObject2 = val$fakeUrn;
    FeedReplyUpdateEvent localFeedReplyUpdateEvent = new FeedReplyUpdateEvent();
    updateEventType = 7;
    newComment = localComment2;
    changedReply = paramDataStoreResponse;
    fakeId = ((Urn)localObject2).toString();
    realId = localComment1.toString();
    Bus.publish(localFeedReplyUpdateEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.CommentPublisher.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */