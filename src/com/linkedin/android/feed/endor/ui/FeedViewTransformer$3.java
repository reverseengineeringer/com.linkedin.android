package com.linkedin.android.feed.endor.ui;

import android.os.Handler;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedViewTransformer$3
  implements Runnable
{
  FeedViewTransformer$3(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, UpdateActionModel paramUpdateActionModel, ModelTransformedCallback paramModelTransformedCallback) {}
  
  public final void run()
  {
    final ModelData localModelData = FeedViewTransformer.toCollapsedViewModel(val$fragmentComponent, val$viewPool, val$update, val$updateAction);
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
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */