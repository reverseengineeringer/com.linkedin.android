package com.linkedin.android.entities;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class EntityUpdatesFragment$3
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  EntityUpdatesFragment$3(EntityUpdatesFragment paramEntityUpdatesFragment, FeedUpdateViewModel paramFeedUpdateViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(this$0.arrayAdapter.getViewState().getState("updateViewState" + viewModel).updateUrn));
    this$0.arrayAdapter.changeViewModel(val$originalViewModel, viewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityUpdatesFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */