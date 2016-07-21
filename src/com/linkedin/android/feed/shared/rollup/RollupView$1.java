package com.linkedin.android.feed.shared.rollup;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import java.util.List;

final class RollupView$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  RollupView$1(RollupView paramRollupView, int paramInt, ViewTreeObserver paramViewTreeObserver) {}
  
  public final void onGlobalLayout()
  {
    int i = this$0.getWidth();
    if (val$oldWidth != i)
    {
      RollupView localRollupView = this$0;
      List localList = RollupViewModelUtils.ellipsize(unellipsizedViewModels, maxNumColumns, rollupTotalCount);
      if (adapter != null)
      {
        adapter.setValues(localList);
        adapter.notifyDataSetChanged();
      }
      JellyBeanUtils.removeOnGlobalLayoutListener(val$observer, this);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.rollup.RollupView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */