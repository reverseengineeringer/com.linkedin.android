package com.linkedin.android.feed.endor.ui.component.comment;

import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;

final class FeedCommentTransformer$2$1
  implements Runnable
{
  FeedCommentTransformer$2$1(FeedCommentTransformer.2 param2, ModelsData paramModelsData) {}
  
  public final void run()
  {
    this$0.val$callback.onModelsTransformed(val$output);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentTransformer.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */