package com.linkedin.android.growth.login.prereg.jobs;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

final class PreRegJobsFragmentViewModel$2
  implements View.OnLayoutChangeListener
{
  PreRegJobsFragmentViewModel$2(PreRegJobsFragmentViewModel paramPreRegJobsFragmentViewModel) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setPivotX(paramView.getWidth());
    paramView.setPivotY(paramView.getHeight() / 2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.jobs.PreRegJobsFragmentViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */