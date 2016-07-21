package com.linkedin.android.entities.group.controllers;

import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class GroupUpdatesFragment$2
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  GroupUpdatesFragment$2(GroupUpdatesFragment paramGroupUpdatesFragment, EntityFeedUpdateWrapperCardViewModel paramEntityFeedUpdateWrapperCardViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(GroupUpdatesFragment.access$100(this$0).getViewState().getState("updateViewState" + viewModel).updateUrn));
    EntityFeedUpdateWrapperCardViewModel localEntityFeedUpdateWrapperCardViewModel = new EntityFeedUpdateWrapperCardViewModel();
    feedUpdateViewModel = ((FeedUpdateViewModel)viewModel);
    GroupUpdatesFragment.access$200(this$0).changeViewModel(val$originalWrapperViewModel, localEntityFeedUpdateWrapperCardViewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupUpdatesFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */