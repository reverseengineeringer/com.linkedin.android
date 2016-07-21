package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.View;

final class ActionMenuPresenter$OpenOverflowRunnable
  implements Runnable
{
  private ActionMenuPresenter.OverflowPopup mPopup;
  
  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter paramActionMenuPresenter, ActionMenuPresenter.OverflowPopup paramOverflowPopup)
  {
    mPopup = paramOverflowPopup;
  }
  
  public final void run()
  {
    Object localObject = this$0.mMenu;
    if (mCallback != null) {
      mCallback.onMenuModeChange((MenuBuilder)localObject);
    }
    localObject = (View)this$0.mMenuView;
    if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (mPopup.tryShow())) {
      this$0.mOverflowPopup = mPopup;
    }
    this$0.mPostedOpenRunnable = null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OpenOverflowRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */