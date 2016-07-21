package android.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;

final class AppCompatSpinner$1
  extends ListPopupWindow.ForwardingListener
{
  AppCompatSpinner$1(AppCompatSpinner paramAppCompatSpinner, View paramView, AppCompatSpinner.DropdownPopup paramDropdownPopup)
  {
    super(paramView);
  }
  
  public final ListPopupWindow getPopup()
  {
    return val$popup;
  }
  
  public final boolean onForwardingStarted()
  {
    if (!access$000this$0).mPopup.isShowing()) {
      AppCompatSpinner.access$000(this$0).show();
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */