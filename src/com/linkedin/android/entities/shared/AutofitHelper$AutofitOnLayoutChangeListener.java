package com.linkedin.android.entities.shared;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

final class AutofitHelper$AutofitOnLayoutChangeListener
  implements View.OnLayoutChangeListener
{
  private AutofitHelper$AutofitOnLayoutChangeListener(AutofitHelper paramAutofitHelper) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this$0.autofit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.AutofitHelper.AutofitOnLayoutChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */