package com.linkedin.android.feed.actions;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.viewmodels.models.BaseActionModel;

final class ControlPanelDialog$2
  implements View.OnClickListener
{
  ControlPanelDialog$2(ControlPanelDialog paramControlPanelDialog, BaseActionModel paramBaseActionModel) {}
  
  public final void onClick(View paramView)
  {
    if (this$0.itemClickListener != null) {
      this$0.itemClickListener.onActionPerformed$23f734e3(ControlPanelDialog.access$000(this$0), val$actionItem);
    }
    this$0.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlPanelDialog.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */