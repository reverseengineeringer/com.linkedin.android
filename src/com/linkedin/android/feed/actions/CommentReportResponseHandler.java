package com.linkedin.android.feed.actions;

import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.semaphore.api.ResponseListener;
import com.linkedin.semaphore.client.android.ReportEntityClientAction;
import com.linkedin.semaphore.client.android.ReportEntityResponse;
import com.linkedin.semaphore.client.android.ReportEntityResponseCode;
import com.linkedin.semaphore.client.android.ReportEntityResponseStatus;
import java.util.List;

public final class CommentReportResponseHandler
  implements ResponseListener
{
  private final Comment comment;
  private final FragmentComponent fragmentComponent;
  private boolean isSuccessCalled;
  private final Update parentUpdate;
  
  public CommentReportResponseHandler(FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment)
  {
    fragmentComponent = paramFragmentComponent;
    parentUpdate = paramUpdate;
    comment = paramComment;
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
        paramReportEntityResponse = parentUpdate;
        Comment localComment = comment;
        FragmentComponent localFragmentComponent = fragmentComponent;
        CommentActionPublisher.publishErrorDeleteCommentEvent(localFragmentComponent, paramReportEntityResponse, localComment);
        CommentModelUtils.displayCommentActionMessage(localFragmentComponent, 2131231149, 2131623950);
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
    Update localUpdate;
    FragmentComponent localFragmentComponent;
    if ((status == ReportEntityResponseStatus.SUCCESS) && (clientAction != null) && (clientAction.reportAction != null))
    {
      isSuccessCalled = true;
      localObject = FeedCommentUpdateEvent.deleteCommentEvent(parentUpdate, comment);
      fragmentComponent.eventBus();
      Bus.publish(localObject);
      localUpdate = parentUpdate;
      localObject = comment;
      localFragmentComponent = fragmentComponent;
      paramReportEntityResponse = (ReportEntityResponseCode)clientAction.reportAction.get(0);
      localUpdate = CommentModelUtils.removeCommentFromUpdate(localUpdate, urn.toString());
      if (localUpdate == null)
      {
        localFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Error while removing comment from update"));
        CommentModelUtils.displayCommentActionMessage(localFragmentComponent, 2131231149, 2131623950);
      }
    }
    else
    {
      return;
    }
    CommentActionPublisher.publishDeleteCommentEvent(localFragmentComponent, localUpdate, (Comment)localObject);
    CommentActionPublisher.publishConfirmDeleteCommentEvent(localFragmentComponent, localUpdate, (Comment)localObject);
    int i;
    if (localFragmentComponent.lixManager().getTreatment(Lix.LIX_SEMAPHORE_SHOW_ADDITIONAL_ACTION_TOAST).equals("enabled")) {
      switch (CommentActionPublisher.2.$SwitchMap$com$linkedin$semaphore$client$android$ReportEntityResponseCode[paramReportEntityResponse.ordinal()])
      {
      default: 
        i = 2131231151;
      }
    }
    for (;;)
    {
      CommentModelUtils.displayCommentActionMessage(localFragmentComponent, i, 2131623952);
      return;
      i = 2131231150;
      continue;
      i = 2131231148;
      continue;
      i = 2131231152;
      continue;
      i = 2131231151;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.CommentReportResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */