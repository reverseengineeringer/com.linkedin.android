package com.linkedin.android.feed.shared;

import android.support.v4.app.Fragment;
import android.view.View;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.events.FeedOpenCommentDetailEvent;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailIntent;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

public final class FeedCommentDetailOnClickListener
  extends TrackingOnClickListener
{
  protected final int anchor;
  protected final Comment comment;
  protected final WeakReference<FragmentComponent> fragmentComponent;
  protected final Comment parentComment;
  protected boolean populateMention;
  protected final Update update;
  
  public FeedCommentDetailOnClickListener(Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    this(paramUpdate, paramComment, null, 0, paramFragmentComponent, paramString, false, paramVarArgs);
  }
  
  public FeedCommentDetailOnClickListener(Update paramUpdate, Comment paramComment1, Comment paramComment2, int paramInt, FragmentComponent paramFragmentComponent, String paramString, boolean paramBoolean, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    update = paramUpdate;
    comment = paramComment1;
    parentComment = paramComment2;
    fragmentComponent = new WeakReference(paramFragmentComponent);
    anchor = paramInt;
    populateMention = paramBoolean;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
    if ((localFragmentComponent == null) || (FeedUpdateUtils.isGroupDiscussionUpdate(update))) {
      return;
    }
    if (FeedViewTransformerHelpers.isDetailPage(localFragmentComponent))
    {
      localFragmentComponent.eventBus();
      Bus.publish(new FeedOpenCommentDetailEvent(comment, parentComment, anchor, FeedViewTransformerHelpers.getFeedType(localFragmentComponent), populateMention));
      return;
    }
    if (comment.parentCommentUrn == null)
    {
      paramView = CommentDetailBundleBuilder.create(update.urn.toString(), comment.urn.toString());
      paramView.comment(comment);
    }
    for (;;)
    {
      paramView.populateMention(populateMention);
      paramView.update(update);
      paramView.anchor(anchor);
      paramView.previousPage(FeedViewTransformerHelpers.getFeedType(localFragmentComponent));
      Object localObject = localFragmentComponent.fragment();
      ((Fragment)localObject).startActivityForResult(intentRegistrycommentDetail.newIntent(((Fragment)localObject).getActivity(), paramView), 14);
      return;
      localObject = CommentDetailBundleBuilder.create(update.urn.toString(), comment.parentCommentUrn.toString());
      ((CommentDetailBundleBuilder)localObject).reply(comment);
      paramView = (View)localObject;
      if (parentComment != null)
      {
        ((CommentDetailBundleBuilder)localObject).comment(parentComment);
        paramView = (View)localObject;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedCommentDetailOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */