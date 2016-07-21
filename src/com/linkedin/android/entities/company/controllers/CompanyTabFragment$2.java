package com.linkedin.android.entities.company.controllers;

import com.linkedin.android.entities.company.transformers.CompanyCardsTransformer;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class CompanyTabFragment$2
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  CompanyTabFragment$2(CompanyTabFragment paramCompanyTabFragment, EntityFeedUpdateWrapperCardViewModel paramEntityFeedUpdateWrapperCardViewModel) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if ((!this$0.isAdded()) || (CompanyTabFragment.access$100(this$0) == null)) {
      return;
    }
    ((FeedUpdateViewModel)viewModel).onRestoreUpdateViewState(CompanyTabFragment.access$200(this$0).getViewState().getState("updateViewState" + viewModel).updateUrn));
    paramModelData = (FeedSingleUpdateViewModel)viewModel;
    CompanyCardsTransformer.addHeaderAndFooterToCompanyUpdateCard(this$0.fragmentComponent, CompanyTabFragment.access$100(this$0), paramModelData);
    EntityFeedUpdateWrapperCardViewModel localEntityFeedUpdateWrapperCardViewModel = new EntityFeedUpdateWrapperCardViewModel();
    feedUpdateViewModel = paramModelData;
    CompanyTabFragment.access$200(this$0).changeViewModel(val$originalViewModel, localEntityFeedUpdateWrapperCardViewModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyTabFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */