package com.linkedin.android.feed.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ControlPanelDialog$1
  implements View.OnClickListener
{
  ControlPanelDialog$1(ControlPanelDialog paramControlPanelDialog, String paramString, ClipboardManager paramClipboardManager, SnackbarUtil paramSnackbarUtil) {}
  
  public final void onClick(View paramView)
  {
    paramView = ClipData.newPlainText(val$label, access$000this$0).urn.toString());
    val$clipboard.setPrimaryClip(paramView);
    val$snackbar.make(2131233820, 0).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlPanelDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */