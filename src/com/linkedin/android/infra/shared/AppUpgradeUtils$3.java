package com.linkedin.android.infra.shared;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;

public final class AppUpgradeUtils$3
  implements View.OnClickListener
{
  public AppUpgradeUtils$3(AppUpgradeUtils paramAppUpgradeUtils, boolean paramBoolean, AlertDialog paramAlertDialog, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    if (val$cancelable) {
      val$dialog.dismiss();
    }
    val$positiveListener.onClick(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.AppUpgradeUtils.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */