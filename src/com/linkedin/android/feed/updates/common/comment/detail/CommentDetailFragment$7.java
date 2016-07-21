package com.linkedin.android.feed.updates.common.comment.detail;

import android.support.v7.widget.RecyclerView;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.consistency.ModelListConsistencyCoordinator;

final class CommentDetailFragment$7
  implements ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel>
{
  CommentDetailFragment$7(CommentDetailFragment paramCommentDetailFragment, Comment paramComment) {}
  
  public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramModelsData)
  {
    if ((!this$0.isAdded()) || (CommentDetailFragment.access$400(this$0) == null) || (CommentDetailFragment.access$800(this$0) == null)) {
      return;
    }
    CommentDetailFragment.access$1100(this$0, CommentDetailFragment.access$000(this$0), val$comment);
    CommentDetailFragment.access$400(this$0).addNewComments(viewModels, 1, this$0.fragmentComponent, CommentDetailFragment.access$000(this$0));
    if (CommentDetailFragment.access$1200(this$0) != null)
    {
      int i = CommentDetailFragment.access$400(this$0).getIndexOfCommentWithId(access$1200this$0).urn.toString());
      if (i >= 0) {
        this$0.detailRecyclerView.smoothScrollToPosition(i);
      }
    }
    CommentDetailFragment.access$800(this$0).listenForUpdates(inputModels, CommentDetailFragment.access$1000(this$0));
    CommentDetailFragment.access$1300$27b9cf55(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */