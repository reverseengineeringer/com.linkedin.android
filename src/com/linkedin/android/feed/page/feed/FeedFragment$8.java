package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Collections;

final class FeedFragment$8
  implements ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel>
{
  FeedFragment$8(FeedFragment paramFeedFragment, String paramString) {}
  
  public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramModelData)
  {
    if (!this$0.isAdded()) {}
    boolean bool1;
    do
    {
      return;
      boolean bool2 = this$0.feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel, val$updateUrn);
      bool1 = bool2;
      if (!bool2) {
        bool1 = this$0.feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
      }
    } while (bool1);
    this$0.feedAdapter.prependValues(Collections.singletonList(viewModel));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */