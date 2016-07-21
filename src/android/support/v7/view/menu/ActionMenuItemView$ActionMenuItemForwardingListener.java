package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.widget.PopupWindow;

final class ActionMenuItemView$ActionMenuItemForwardingListener
  extends ListPopupWindow.ForwardingListener
{
  public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public final ListPopupWindow getPopup()
  {
    if (ActionMenuItemView.access$000(this$0) != null) {
      return ActionMenuItemView.access$000(this$0).getPopup();
    }
    return null;
  }
  
  protected final boolean onForwardingStarted()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ActionMenuItemView.access$100(this$0) != null)
    {
      bool1 = bool2;
      if (ActionMenuItemView.access$100(this$0).invokeItem(ActionMenuItemView.access$200(this$0)))
      {
        ListPopupWindow localListPopupWindow = getPopup();
        bool1 = bool2;
        if (localListPopupWindow != null)
        {
          bool1 = bool2;
          if (mPopup.isShowing()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */