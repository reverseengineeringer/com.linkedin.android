package com.linkedin.android.feed.detail;

import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.consistency.ModelListConsistencyCoordinator;

final class FeedUpdateDetailFragment$5
  implements ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel>
{
  FeedUpdateDetailFragment$5(FeedUpdateDetailFragment paramFeedUpdateDetailFragment, int paramInt) {}
  
  public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramModelsData)
  {
    if ((this$0.detailAdapter == null) || (FeedUpdateDetailFragment.access$1100(this$0) == null)) {
      return;
    }
    if (CollectionUtils.isEmpty(viewModels))
    {
      FeedUpdateDetailFragment.access$1200(this$0);
      return;
    }
    if (val$requestState == 5) {
      this$0.detailAdapter.addNewComments(viewModels, 3, this$0.fragmentComponent, FeedUpdateDetailFragment.access$200(this$0));
    }
    for (;;)
    {
      FeedUpdateDetailFragment.access$1100(this$0).listenForUpdates(inputModels, FeedUpdateDetailFragment.access$1300(this$0));
      return;
      if (val$requestState == 6) {
        this$0.detailAdapter.addNewComments(viewModels, 2, this$0.fragmentComponent, FeedUpdateDetailFragment.access$200(this$0));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */