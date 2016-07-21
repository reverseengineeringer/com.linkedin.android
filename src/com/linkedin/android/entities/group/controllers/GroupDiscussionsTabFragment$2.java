package com.linkedin.android.entities.group.controllers;

import com.linkedin.android.entities.group.GroupsViewModelAdapter;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class GroupDiscussionsTabFragment$2
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  GroupDiscussionsTabFragment$2(GroupDiscussionsTabFragment paramGroupDiscussionsTabFragment, EntityFeedUpdateWrapperCardViewModel paramEntityFeedUpdateWrapperCardViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(GroupDiscussionsTabFragment.access$000(this$0).getViewState().getState("updateViewState" + viewModel).updateUrn));
    EntityFeedUpdateWrapperCardViewModel localEntityFeedUpdateWrapperCardViewModel = new EntityFeedUpdateWrapperCardViewModel();
    feedUpdateViewModel = ((FeedUpdateViewModel)viewModel);
    GroupDiscussionsTabFragment.access$000(this$0).changeViewModel(val$originalWrapperViewModel, localEntityFeedUpdateWrapperCardViewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupDiscussionsTabFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */