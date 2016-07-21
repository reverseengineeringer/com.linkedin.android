package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.TopBarComponent;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.CollectionUtils;
import java.util.List;

public final class FeedTopBarManager
{
  public static void configureTopBar(FragmentComponent paramFragmentComponent, FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {}
    do
    {
      do
      {
        return;
        paramFragmentComponent = paramFeedUpdateViewModel.getComponentSegmentsForBorders();
      } while (CollectionUtils.isEmpty(paramFragmentComponent));
      paramFragmentComponent = (List)paramFragmentComponent.get(0);
    } while (paramFragmentComponent == null);
    int j = 1;
    int m = paramFragmentComponent.size();
    int i = 0;
    label47:
    if (i < m)
    {
      paramFeedUpdateViewModel = (FeedComponentViewModel)paramFragmentComponent.get(i);
      k = j;
      if ((paramFeedUpdateViewModel instanceof TopBarComponent))
      {
        paramFeedUpdateViewModel = (TopBarComponent)paramFeedUpdateViewModel;
        if ((j == 0) || (!paramFeedUpdateViewModel.canRenderControlDropdown())) {
          break label112;
        }
        paramFeedUpdateViewModel.setIsTopBar(true);
      }
    }
    for (int k = 0;; k = j)
    {
      i += 1;
      j = k;
      break label47;
      break;
      label112:
      paramFeedUpdateViewModel.setIsTopBar(false);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedTopBarManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */