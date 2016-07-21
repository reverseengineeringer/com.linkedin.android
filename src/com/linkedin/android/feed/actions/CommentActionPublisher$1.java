package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.VoidRecord;

public final class CommentActionPublisher$1
  implements RecordTemplateListener<VoidRecord>
{
  public CommentActionPublisher$1(FragmentComponent paramFragmentComponent, Update paramUpdate1, Comment paramComment, Update paramUpdate2) {}
  
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
      CommentActionPublisher.publishErrorDeleteCommentEvent(val$fragmentComponent, val$parentUpdate, val$comment);
      CommentModelUtils.displayCommentActionMessage(val$fragmentComponent, 2131231133, 2131623950);
      return;
    }
    CommentActionPublisher.publishConfirmDeleteCommentEvent(val$fragmentComponent, val$updateWithoutComment, val$comment);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.CommentActionPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */