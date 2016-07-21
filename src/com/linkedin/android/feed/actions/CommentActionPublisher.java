package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.VoidRecord;

public final class CommentActionPublisher
{
  static void publishConfirmDeleteCommentEvent(FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment)
  {
    paramUpdate = FeedCommentUpdateEvent.confirmDeleteCommentEvent(paramUpdate, paramComment);
    paramFragmentComponent.eventBus();
    Bus.publish(paramUpdate);
  }
  
  public static void publishDeleteCommentEvent(FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment)
  {
    paramComment = FeedCommentUpdateEvent.deleteCommentEvent(paramUpdate, paramComment);
    paramFragmentComponent.eventBus();
    Bus.publish(paramComment);
    FeedBundleBuilder.saveUpdateToCache(paramFragmentComponent.dataManager(), paramUpdate);
  }
  
  static void publishErrorDeleteCommentEvent(FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment)
  {
    FeedCommentUpdateEvent localFeedCommentUpdateEvent = new FeedCommentUpdateEvent();
    updateEventType = 10;
    newUpdate = paramUpdate;
    changedComment = paramComment;
    realId = urn.toString();
    hide = false;
    paramFragmentComponent.eventBus();
    Bus.publish(localFeedCommentUpdateEvent);
    FeedBundleBuilder.saveUpdateToCache(paramFragmentComponent.dataManager(), paramUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.CommentActionPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */