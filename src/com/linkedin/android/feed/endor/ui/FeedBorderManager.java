package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderLayout;
import com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.shared.CollectionUtils;
import java.util.List;

public final class FeedBorderManager
{
  public static void applyBorders$2d7435b4(FeedComponentsViewPool paramFeedComponentsViewPool, FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    List localList1 = paramFeedUpdateViewModel.getComponentSegmentsForBorders();
    if (CollectionUtils.isEmpty(localList1)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < localList1.size())
      {
        List localList2 = (List)localList1.get(i);
        int k = localList2.size();
        FeedComponentLayout.Borders[] arrayOfBorders = new FeedComponentLayout.Borders[k];
        int j = 0;
        while (j < k)
        {
          arrayOfBorders[j] = getlayout.getBorders();
          j += 1;
        }
        j = 0;
        if (j < k)
        {
          FeedComponentLayout.Borders localBorders2;
          if (arrayOfBorders[j] != null)
          {
            if ((j < 0) || (j >= arrayOfBorders.length)) {
              throw new IndexOutOfBoundsException("check your bounds first!");
            }
            localBorders2 = arrayOfBorders[j];
            if (j - 1 < 0) {
              break label215;
            }
            paramFeedUpdateViewModel = arrayOfBorders[(j - 1)];
            label148:
            if (j + 1 >= arrayOfBorders.length) {
              break label220;
            }
          }
          label215:
          label220:
          for (FeedComponentLayout.Borders localBorders1 = arrayOfBorders[(j + 1)];; localBorders1 = null)
          {
            localList2.set(j, new FeedUpdateInnerBorderViewModel(new FeedUpdateInnerBorderLayout(localBorders2.mergeWith(paramFeedUpdateViewModel, localBorders1)), paramFeedComponentsViewPool, (FeedComponentViewModel)localList2.get(j)));
            j += 1;
            break;
            paramFeedUpdateViewModel = null;
            break label148;
          }
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedBorderManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */