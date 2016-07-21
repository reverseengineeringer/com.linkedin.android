package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;

final class FeedViewTransformer$3$1
  implements Runnable
{
  FeedViewTransformer$3$1(FeedViewTransformer.3 param3, ModelData paramModelData) {}
  
  public final void run()
  {
    this$0.val$callback.onModelTransformed(val$output);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformer.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */