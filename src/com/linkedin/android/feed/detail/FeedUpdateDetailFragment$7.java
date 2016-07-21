package com.linkedin.android.feed.detail;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import java.util.List;

final class FeedUpdateDetailFragment$7
  implements ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel>
{
  FeedUpdateDetailFragment$7(FeedUpdateDetailFragment paramFeedUpdateDetailFragment, boolean paramBoolean) {}
  
  public final void onModelsTransformed(ModelsData<Comment, CommentDataModel, FeedComponentViewModel> paramModelsData)
  {
    if ((!this$0.isAdded()) || (this$0.detailAdapter == null) || (FeedUpdateDetailFragment.access$1100(this$0) == null)) {
      return;
    }
    Object localObject1 = this$0.detailAdapter;
    Object localObject2 = viewModels;
    int i;
    boolean bool;
    label169:
    Object localObject3;
    if (val$fullUpdateFetch)
    {
      i = 0;
      ((FeedUpdateDetailAdapter)localObject1).addNewComments((List)localObject2, i, this$0.fragmentComponent, FeedUpdateDetailFragment.access$200(this$0));
      if (FeedUpdateDetailFragment.access$2000(this$0) == 2)
      {
        localObject1 = this$0;
        localObject2 = this$0.fragmentComponent;
        bool = val$fullUpdateFetch;
        if (detailAdapter != null)
        {
          ((FragmentComponent)localObject2).timeWrapper();
          if ((System.currentTimeMillis() - displayedTime <= FeedLixHelper.parseLong(((FragmentComponent)localObject2).lixManager(), Lix.FEED_HIGHLIGHTED_COMMENT_ANCHOR_TIME, 2000L, 1L)) || (bool))
          {
            localObject2 = detailAdapter;
            i = 0;
            if (i >= ((BaseDetailAdapter)localObject2).getItemCount()) {
              break label375;
            }
            localObject3 = (FeedComponentViewModel)((BaseDetailAdapter)localObject2).getItemAtPosition(i);
            if (localObject3 == null) {
              break label368;
            }
            if (!(localObject3 instanceof FeedCommentViewModel)) {
              break label286;
            }
            bool = isHighlighted;
            label212:
            if (!bool) {
              break label368;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        detailRecyclerView.smoothScrollToPosition(i);
      }
      if (this$0.detailRecyclerView != null) {
        FeedUpdateDetailFragment.access$2100(this$0).onScrolled(this$0.detailRecyclerView, 0, 0);
      }
      FeedUpdateDetailFragment.access$1100(this$0).listenForUpdates(inputModels, FeedUpdateDetailFragment.access$1300(this$0));
      return;
      i = 1;
      break;
      label286:
      if ((localObject3 instanceof FeedComponentListViewModel))
      {
        localObject3 = components;
        int j = 0;
        for (;;)
        {
          if (j >= ((List)localObject3).size()) {
            break label362;
          }
          FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)((List)localObject3).get(j);
          if (((localFeedComponentViewModel instanceof FeedCommentViewModel)) && (isHighlighted))
          {
            bool = true;
            break;
          }
          j += 1;
        }
      }
      label362:
      bool = false;
      break label212;
      label368:
      i += 1;
      break label169;
      label375:
      i = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */