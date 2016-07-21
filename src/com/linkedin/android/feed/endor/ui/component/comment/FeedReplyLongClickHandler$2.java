package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.actions.ReplyActionPublisher;
import com.linkedin.android.feed.actions.ReplyActionPublisher.1;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

final class FeedReplyLongClickHandler$2
  implements DialogInterface.OnClickListener
{
  FeedReplyLongClickHandler$2(Comment paramComment1, Comment paramComment2, FragmentComponent paramFragmentComponent, Update paramUpdate) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject2 = val$comment;
    Object localObject1 = val$reply;
    paramDialogInterface = val$fragmentComponent;
    if (urn == null)
    {
      paramDialogInterface.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Comment should not have a null urn"));
      CommentModelUtils.displayCommentActionMessage(paramDialogInterface, 2131231140, 2131623950);
    }
    for (;;)
    {
      FeedTracking.trackCommentClick(val$fragmentComponent, "delete_comment", ActionCategory.DELETE, "deleteComment", val$update, val$reply);
      return;
      ReplyActionPublisher.publishDeleteReplyEvent(paramDialogInterface, (Comment)localObject2, (Comment)localObject1);
      localObject2 = new ReplyActionPublisher.1(paramDialogInterface, (Comment)localObject2, (Comment)localObject1);
      localObject1 = Request.delete().url(FeedRouteUtils.getFeedDeleteCommentUrl(urn)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener((RecordTemplateListener)localObject2);
      paramDialogInterface.dataManager().submit((Request.Builder)localObject1);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLongClickHandler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */