package com.linkedin.android.axle.rta;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;

final class RateTheApp$8
  implements DialogInterface.OnClickListener
{
  RateTheApp$8(RateTheApp paramRateTheApp, FragmentComponent paramFragmentComponent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    RateTheApp.dismissSoftKeyboard(val$fragmentComponent);
    RateTheApp.animationSet(val$fragmentComponent);
    this$0.dislikeView.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */