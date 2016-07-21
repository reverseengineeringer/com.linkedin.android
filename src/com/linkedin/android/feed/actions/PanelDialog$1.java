package com.linkedin.android.feed.actions;

import android.view.View;
import android.view.View.OnClickListener;

final class PanelDialog$1
  implements View.OnClickListener
{
  PanelDialog$1(PanelDialog paramPanelDialog, PanelDialog.PanelDialogItem paramPanelDialogItem) {}
  
  public final void onClick(View paramView)
  {
    if (val$dialogItem.listener != null) {
      val$dialogItem.listener.onClick(paramView);
    }
    this$0.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.PanelDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */