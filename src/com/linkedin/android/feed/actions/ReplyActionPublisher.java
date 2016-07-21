package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.data.lite.VoidRecord;

public final class ReplyActionPublisher
{
  static void publishConfirmDeleteReplyEvent(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2)
  {
    paramComment1 = CommentModelUtils.removeReplyFromComment(paramComment1, urn.toString());
    if (paramComment1 == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Error while removing reply from comment"));
      CommentModelUtils.displayCommentActionMessage(paramFragmentComponent, 2131231140, 2131623950);
      return;
    }
    paramComment2 = FeedReplyUpdateEvent.confirmDeleteReplyEvent(paramComment1, paramComment2);
    paramFragmentComponent.eventBus();
    Bus.publish(paramComment2);
    FeedBundleBuilder.saveCommentToCache(paramFragmentComponent.dataManager(), paramComment1);
  }
  
  public static void publishDeleteReplyEvent(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2)
  {
    paramComment2 = FeedReplyUpdateEvent.deleteReplyEvent(paramComment1, paramComment2);
    paramFragmentComponent.eventBus();
    Bus.publish(paramComment2);
    FeedBundleBuilder.saveCommentToCache(paramFragmentComponent.dataManager(), paramComment1);
  }
  
  static void publishErrorDeleteReplyEvent(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2)
  {
    FeedReplyUpdateEvent localFeedReplyUpdateEvent = new FeedReplyUpdateEvent();
    updateEventType = 10;
    newComment = paramComment1;
    changedReply = paramComment2;
    realId = urn.toString();
    hide = false;
    paramFragmentComponent.eventBus();
    Bus.publish(localFeedReplyUpdateEvent);
    FeedBundleBuilder.saveCommentToCache(paramFragmentComponent.dataManager(), paramComment1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ReplyActionPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */