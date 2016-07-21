package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.actions.ControlPanelDialog;
import com.linkedin.android.feed.actions.ControlPanelDialog.OnActionItemClickListener;
import com.linkedin.android.feed.actions.ReplyActionPublisher;
import com.linkedin.android.feed.actions.ReplyActionPublisher.1;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.util.List;

public final class FeedReplyLongClickHandler
{
  public static void handleLongClick(FragmentComponent paramFragmentComponent, Update paramUpdate, final Comment paramComment1, final Comment paramComment2, List<CommentActionModel> paramList)
  {
    paramComment1 = new ControlPanelDialog.OnActionItemClickListener() {};
    ControlPanelDialog localControlPanelDialog = new ControlPanelDialog(paramFragmentComponent);
    update = paramUpdate;
    localControlPanelDialog.setUpdateActions(paramList).setOnActionItemClickListener(paramComment1).show();
    FeedTracking.trackCommentClick(paramFragmentComponent, "comment_options", ActionCategory.EXPAND, "expandCommentOptions", paramUpdate, paramComment2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedReplyLongClickHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */