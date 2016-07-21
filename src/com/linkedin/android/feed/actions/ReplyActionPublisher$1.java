package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.data.lite.VoidRecord;

public final class ReplyActionPublisher$1
  implements RecordTemplateListener<VoidRecord>
{
  public ReplyActionPublisher$1(FragmentComponent paramFragmentComponent, Comment paramComment1, Comment paramComment2) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    int j = statusCode;
    int i = j;
    if (error != null)
    {
      i = j;
      if (error.errorResponse != null) {
        i = error.errorResponse.code();
      }
    }
    if ((error != null) || (i != 200))
    {
      ReplyActionPublisher.publishErrorDeleteReplyEvent(val$fragmentComponent, val$comment, val$reply);
      CommentModelUtils.displayCommentActionMessage(val$fragmentComponent, 2131231140, 2131623950);
      return;
    }
    ReplyActionPublisher.publishConfirmDeleteReplyEvent(val$fragmentComponent, val$comment, val$reply);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ReplyActionPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */