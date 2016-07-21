package com.linkedin.android.feed.shared.rollup;

import com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem.FeedEllipsisRollupItemViewModel;
import com.linkedin.android.infra.viewmodel.ViewModel;
import java.util.ArrayList;
import java.util.List;

public final class RollupViewModelUtils
{
  public static final FeedEllipsisRollupItemViewModel ELLIPSIS_VIEW_MODEL = new FeedEllipsisRollupItemViewModel();
  
  public static List<ViewModel> ellipsize(List<ViewModel> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      paramList = new ArrayList();
    }
    List<ViewModel> localList;
    do
    {
      do
      {
        return paramList;
        localList = paramList;
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          if (localList.get(i) == ELLIPSIS_VIEW_MODEL) {
            localList.remove(i);
          }
          i -= 1;
        }
        if (localList.size() < paramInt2) {
          break;
        }
        paramList = localList;
      } while (localList.size() <= paramInt1);
      paramInt1 = Math.min(localList.size(), paramInt1 - 1);
      paramList = localList;
    } while (paramInt1 < 0);
    localList.add(paramInt1, ELLIPSIS_VIEW_MODEL);
    return localList.subList(0, paramInt1 + 1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.rollup.RollupViewModelUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */