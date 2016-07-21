package com.linkedin.android.feed.promptresponselist;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Collections;

final class FeedPromptResponseListFragment$3
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedPromptResponseListFragment$3(FeedPromptResponseListFragment paramFeedPromptResponseListFragment) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {
      return;
    }
    FeedPromptResponseListFragment.access$400(this$0, Collections.singletonList(viewModel));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */