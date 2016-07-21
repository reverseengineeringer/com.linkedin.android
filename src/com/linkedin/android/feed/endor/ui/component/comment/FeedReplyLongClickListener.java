package com.linkedin.android.feed.endor.ui.component.comment;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.linkedin.android.feed.events.FeedReplyLongClickEvent;
import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import java.util.List;

public final class FeedReplyLongClickListener
  implements View.OnLongClickListener
{
  private List<CommentActionModel> actions;
  private final Bus bus;
  private Comment comment;
  private Comment reply;
  
  public FeedReplyLongClickListener(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2, List<CommentActionModel> paramList)
  {
    comment = paramComment1;
    reply = paramComment2;
    bus = paramFragmentComponent.eventBus();
    actions = paramList;
  }
  
  public final boolean onLongClick(View paramView)
  {
    Bus.publish(new FeedReplyLongClickEvent(comment, reply, actions));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLongClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */