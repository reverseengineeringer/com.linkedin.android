package com.linkedin.android.feed.endor.ui;

import android.os.Handler;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.infra.components.FragmentComponent;
import java.util.List;

final class FeedViewTransformer$1
  implements Runnable
{
  FeedViewTransformer$1(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List paramList, FeedDataModelMetadata paramFeedDataModelMetadata, ModelsTransformedCallback paramModelsTransformedCallback) {}
  
  public final void run()
  {
    final ModelsData localModelsData = FeedViewTransformer.toViewModels(val$fragmentComponent, val$viewPool, val$updates, val$metadata);
    val$fragmentComponent.mainHandler().post(new Runnable()
    {
      public final void run()
      {
        val$callback.onModelsTransformed(localModelsData);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */