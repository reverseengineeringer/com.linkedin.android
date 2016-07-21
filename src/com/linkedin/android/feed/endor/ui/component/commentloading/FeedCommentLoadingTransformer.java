package com.linkedin.android.feed.endor.ui.component.commentloading;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedCommentLoadingTransformer
{
  public static FeedCommentLoadingViewModel toViewModel(FragmentComponent paramFragmentComponent, Update paramUpdate, int paramInt, boolean paramBoolean)
  {
    return toViewModel(paramFragmentComponent, paramUpdate, null, paramInt, paramBoolean, false);
  }
  
  public static FeedCommentLoadingViewModel toViewModel(FragmentComponent paramFragmentComponent, Update paramUpdate, Comment paramComment, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 0)
    {
      if (paramBoolean2)
      {
        paramInt = 2131231279;
        if (!FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {
          break label111;
        }
      }
      label111:
      for (int i = paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493106);; i = 0)
      {
        FeedCommentLoadingViewModel localFeedCommentLoadingViewModel = new FeedCommentLoadingViewModel(new FeedCommentLoadingLayout(FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent), true, i));
        loadType = 0;
        loadingText = paramFragmentComponent.i18NManager().getString(paramInt);
        isLoading = paramBoolean1;
        if (!paramBoolean1) {
          loadingListener = FeedTracking.newLoadPreviousCommentsListener(paramFragmentComponent, paramUpdate, paramComment);
        }
        return localFeedCommentLoadingViewModel;
        paramInt = 2131231158;
        break;
      }
    }
    if (paramInt == 1)
    {
      if (FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {}
      for (paramInt = paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493106);; paramInt = 0)
      {
        paramFragmentComponent = new FeedCommentLoadingViewModel(new FeedCommentLoadingLayout(false, false, paramInt));
        loadType = 1;
        return paramFragmentComponent;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */