package com.linkedin.android.feed.actions;

import android.util.Log;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.semaphore.api.ResponseListener;
import com.linkedin.semaphore.client.android.ReportEntityClientAction;
import com.linkedin.semaphore.client.android.ReportEntityResponse;
import com.linkedin.semaphore.client.android.ReportEntityResponseCode;
import com.linkedin.semaphore.client.android.ReportEntityResponseStatus;
import java.util.List;

public final class ReplyReportResponseHandler
  implements ResponseListener
{
  private final Comment comment;
  private final FragmentComponent fragmentComponent;
  private boolean isSuccessCalled;
  private final Comment reply;
  
  public ReplyReportResponseHandler(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2)
  {
    fragmentComponent = paramFragmentComponent;
    comment = paramComment1;
    reply = paramComment2;
  }
  
  public final void errorFetchingMenu$508f4980(String paramString)
  {
    FeatureLog.i(paramString, "Feed Logging");
    CommentModelUtils.displayCommentActionMessage(fragmentComponent, 2131233721, 2131623950);
  }
  
  public final void processCancelResponse$3a729177()
  {
    FeatureLog.i("Report flow canceled.", "Feed Logging");
  }
  
  public final void processErrorResponse$3a729177(ReportEntityResponse paramReportEntityResponse)
  {
    if (status == ReportEntityResponseStatus.FAILURE)
    {
      Log.e("Feed Logging", "Report response resulted in error.");
      if (isSuccessCalled)
      {
        paramReportEntityResponse = comment;
        Comment localComment = reply;
        FragmentComponent localFragmentComponent = fragmentComponent;
        ReplyActionPublisher.publishErrorDeleteReplyEvent(localFragmentComponent, paramReportEntityResponse, localComment);
        CommentModelUtils.displayCommentActionMessage(localFragmentComponent, 2131231143, 2131623950);
      }
    }
    else
    {
      return;
    }
    CommentModelUtils.displayCommentActionMessage(fragmentComponent, 2131233721, 2131623950);
  }
  
  public final void processSuccessResponse$3a729177(ReportEntityResponse paramReportEntityResponse)
  {
    Object localObject;
    Comment localComment;
    FragmentComponent localFragmentComponent;
    if ((status == ReportEntityResponseStatus.SUCCESS) && (clientAction != null) && (clientAction.reportAction != null))
    {
      isSuccessCalled = true;
      localObject = FeedReplyUpdateEvent.deleteReplyEvent(comment, reply);
      fragmentComponent.eventBus();
      Bus.publish(localObject);
      localComment = comment;
      localObject = reply;
      localFragmentComponent = fragmentComponent;
      paramReportEntityResponse = (ReportEntityResponseCode)clientAction.reportAction.get(0);
      localComment = CommentModelUtils.removeReplyFromComment(localComment, urn.toString());
      if (localComment == null)
      {
        localFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Error while removing reply from comment"));
        CommentModelUtils.displayCommentActionMessage(localFragmentComponent, 2131231143, 2131623950);
      }
    }
    else
    {
      return;
    }
    ReplyActionPublisher.publishDeleteReplyEvent(localFragmentComponent, localComment, (Comment)localObject);
    ReplyActionPublisher.publishConfirmDeleteReplyEvent(localFragmentComponent, localComment, (Comment)localObject);
    int i;
    if (localFragmentComponent.lixManager().getTreatment(Lix.LIX_SEMAPHORE_SHOW_ADDITIONAL_ACTION_TOAST).equals("enabled")) {
      switch (ReplyActionPublisher.2.$SwitchMap$com$linkedin$semaphore$client$android$ReportEntityResponseCode[paramReportEntityResponse.ordinal()])
      {
      default: 
        i = 2131231145;
      }
    }
    for (;;)
    {
      CommentModelUtils.displayCommentActionMessage(localFragmentComponent, i, 2131623952);
      return;
      i = 2131231144;
      continue;
      i = 2131231142;
      continue;
      i = 2131231146;
      continue;
      i = 2131231145;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ReplyReportResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */