package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View;

final class ActionMenuPresenter$OverflowMenuButton
  extends AppCompatImageView
  implements ActionMenuView.ActionMenuChildView
{
  private final float[] mTempPts = new float[2];
  
  public ActionMenuPresenter$OverflowMenuButton(final ActionMenuPresenter paramActionMenuPresenter, Context paramContext)
  {
    super(paramContext, null, R.attr.actionOverflowButtonStyle);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    setOnTouchListener(new ListPopupWindow.ForwardingListener(this)
    {
      public final ListPopupWindow getPopup()
      {
        if (this$0.mOverflowPopup == null) {
          return null;
        }
        return this$0.mOverflowPopup.mPopup;
      }
      
      public final boolean onForwardingStarted()
      {
        this$0.showOverflowMenu();
        return true;
      }
      
      public final boolean onForwardingStopped()
      {
        if (this$0.mPostedOpenRunnable != null) {
          return false;
        }
        this$0.hideOverflowMenu();
        return true;
      }
    });
  }
  
  public final boolean needsDividerAfter()
  {
    return false;
  }
  
  public final boolean needsDividerBefore()
  {
    return false;
  }
  
  public final boolean performClick()
  {
    if (super.performClick()) {
      return true;
    }
    playSoundEffect(0);
    this$0.showOverflowMenu();
    return true;
  }
  
  protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable1 = getDrawable();
    Drawable localDrawable2 = getBackground();
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      int i = getWidth();
      paramInt2 = getHeight();
      paramInt1 = Math.max(i, paramInt2) / 2;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      i = (i + (j - k)) / 2;
      paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
      DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */