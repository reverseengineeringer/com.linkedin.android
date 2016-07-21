package com.linkedin.android.feed.endor.ui.component.comment;

import android.os.Handler;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

final class FeedCommentTransformer$1
  implements Runnable
{
  FeedCommentTransformer$1(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List paramList, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata, ModelsTransformedCallback paramModelsTransformedCallback) {}
  
  public final void run()
  {
    final ModelsData localModelsData = FeedCommentTransformer.toViewModels(val$fragmentComponent, val$viewPool, val$comments, val$parentUpdate, val$metadata);
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
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */