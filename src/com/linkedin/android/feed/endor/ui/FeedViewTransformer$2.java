package com.linkedin.android.feed.endor.ui;

import android.os.Handler;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedViewTransformer$2
  implements Runnable
{
  FeedViewTransformer$2(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata, ModelTransformedCallback paramModelTransformedCallback) {}
  
  public final void run()
  {
    final ModelData localModelData = FeedViewTransformer.toViewModel(val$fragmentComponent, val$viewPool, val$update, val$metadata);
    val$fragmentComponent.mainHandler().post(new Runnable()
    {
      public final void run()
      {
        val$callback.onModelTransformed(localModelData);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */