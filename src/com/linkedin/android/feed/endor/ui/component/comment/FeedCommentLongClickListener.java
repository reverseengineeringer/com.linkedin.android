package com.linkedin.android.feed.endor.ui.component.comment;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.linkedin.android.feed.events.FeedCommentLongClickEvent;
import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class FeedCommentLongClickListener
  implements View.OnLongClickListener
{
  private List<CommentActionModel> actions;
  private final Bus bus;
  private Comment comment;
  private Update parentUpdate;
  
  public FeedCommentLongClickListener(FragmentComponent paramFragmentComponent, Comment paramComment, Update paramUpdate, List<CommentActionModel> paramList)
  {
    parentUpdate = paramUpdate;
    comment = paramComment;
    bus = paramFragmentComponent.eventBus();
    actions = paramList;
  }
  
  public final boolean onLongClick(View paramView)
  {
    Bus.publish(new FeedCommentLongClickEvent(parentUpdate, comment, actions));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentLongClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */