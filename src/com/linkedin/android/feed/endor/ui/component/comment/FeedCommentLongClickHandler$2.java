package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.actions.CommentActionPublisher;
import com.linkedin.android.feed.actions.CommentActionPublisher.1;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

final class FeedCommentLongClickHandler$2
  implements DialogInterface.OnClickListener
{
  FeedCommentLongClickHandler$2(Update paramUpdate, Comment paramComment, FragmentComponent paramFragmentComponent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject2 = val$update;
    Object localObject1 = val$comment;
    paramDialogInterface = val$fragmentComponent;
    if (urn == null)
    {
      paramDialogInterface.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Comment should not have a null urn"));
      CommentModelUtils.displayCommentActionMessage(paramDialogInterface, 2131231133, 2131623950);
    }
    for (;;)
    {
      FeedTracking.trackCommentClick(val$fragmentComponent, "delete_comment", ActionCategory.DELETE, "deleteComment", val$update, val$comment);
      return;
      Update localUpdate = CommentModelUtils.removeCommentFromUpdate((Update)localObject2, urn.toString());
      if (localUpdate == null)
      {
        paramDialogInterface.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Error while removing comment from update"));
        CommentModelUtils.displayCommentActionMessage(paramDialogInterface, 2131231133, 2131623950);
      }
      else
      {
        CommentActionPublisher.publishDeleteCommentEvent(paramDialogInterface, localUpdate, (Comment)localObject1);
        localObject2 = new CommentActionPublisher.1(paramDialogInterface, (Update)localObject2, (Comment)localObject1, localUpdate);
        localObject1 = Request.delete().url(FeedRouteUtils.getFeedDeleteCommentUrl(urn)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener((RecordTemplateListener)localObject2);
        paramDialogInterface.dataManager().submit((Request.Builder)localObject1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentLongClickHandler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */