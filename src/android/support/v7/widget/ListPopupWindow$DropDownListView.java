package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R.attr;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Field;

final class ListPopupWindow$DropDownListView
  extends ListViewCompat
{
  private ViewPropertyAnimatorCompat mClickAnimation;
  private boolean mDrawsInPressedState;
  private boolean mHijackFocus;
  private boolean mListSelectionHidden;
  private ListViewAutoScrollHelper mScrollHelper;
  
  public ListPopupWindow$DropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  public final boolean hasFocus()
  {
    return (mHijackFocus) || (super.hasFocus());
  }
  
  public final boolean hasWindowFocus()
  {
    return (mHijackFocus) || (super.hasWindowFocus());
  }
  
  public final boolean isFocused()
  {
    return (mHijackFocus) || (super.isFocused());
  }
  
  public final boolean isInTouchMode()
  {
    return ((mHijackFocus) && (mListSelectionHidden)) || (super.isInTouchMode());
  }
  
  public final boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    int i = 0;
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    View localView;
    switch (j)
    {
    default: 
      bool1 = bool2;
      paramInt = i;
      if ((!bool1) || (paramInt != 0))
      {
        mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(mMotionPosition - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        if (mClickAnimation != null)
        {
          mClickAnimation.cancel();
          mClickAnimation = null;
        }
      }
      if (bool1)
      {
        if (mScrollHelper == null) {
          mScrollHelper = new ListViewAutoScrollHelper(this);
        }
        mScrollHelper.setEnabled(true);
        mScrollHelper.onTouch(this, paramMotionEvent);
      }
      break;
    }
    label418:
    while (mScrollHelper == null)
    {
      return bool1;
      bool1 = false;
      paramInt = i;
      break;
      bool1 = false;
      int k = paramMotionEvent.findPointerIndex(paramInt);
      if (k < 0)
      {
        bool1 = false;
        paramInt = i;
        break;
      }
      paramInt = (int)paramMotionEvent.getX(k);
      int m = (int)paramMotionEvent.getY(k);
      k = pointToPosition(paramInt, m);
      if (k == -1)
      {
        paramInt = 1;
        break;
      }
      localView = getChildAt(k - getFirstVisiblePosition());
      float f1 = paramInt;
      float f2 = m;
      mDrawsInPressedState = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(f1, f2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (mMotionPosition != -1)
      {
        localObject1 = getChildAt(mMotionPosition - getFirstVisiblePosition());
        if ((localObject1 != null) && (localObject1 != localView) && (((View)localObject1).isPressed())) {
          ((View)localObject1).setPressed(false);
        }
      }
      mMotionPosition = k;
      float f3 = localView.getLeft();
      float f4 = localView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        localView.drawableHotspotChanged(f1 - f3, f2 - f4);
      }
      if (!localView.isPressed()) {
        localView.setPressed(true);
      }
      Object localObject1 = getSelector();
      Object localObject2;
      if ((localObject1 != null) && (k != -1))
      {
        paramInt = 1;
        if (paramInt != 0) {
          ((Drawable)localObject1).setVisible(false, false);
        }
        localObject2 = mSelectorRect;
        ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        left -= mSelectionLeftPadding;
        top -= mSelectionTopPadding;
        right += mSelectionRightPadding;
        bottom += mSelectionBottomPadding;
      }
      for (;;)
      {
        try
        {
          bool1 = mIsChildViewEnabled.getBoolean(this);
          if (localView.isEnabled() != bool1)
          {
            localObject2 = mIsChildViewEnabled;
            if (bool1) {
              continue;
            }
            bool1 = true;
            ((Field)localObject2).set(this, Boolean.valueOf(bool1));
            if (k != -1) {
              refreshDrawableState();
            }
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          continue;
          bool1 = false;
          continue;
        }
        if (paramInt != 0)
        {
          localObject2 = mSelectorRect;
          f3 = ((Rect)localObject2).exactCenterX();
          f4 = ((Rect)localObject2).exactCenterY();
          if (getVisibility() != 0) {
            continue;
          }
          bool1 = true;
          ((Drawable)localObject1).setVisible(bool1, false);
          DrawableCompat.setHotspot((Drawable)localObject1, f3, f4);
        }
        localObject1 = getSelector();
        if ((localObject1 != null) && (k != -1)) {
          DrawableCompat.setHotspot((Drawable)localObject1, f1, f2);
        }
        setSelectorEnabled(false);
        refreshDrawableState();
        bool2 = true;
        paramInt = i;
        bool1 = bool2;
        if (j != 1) {
          break;
        }
        performItemClick(localView, k, getItemIdAtPosition(k));
        paramInt = i;
        bool1 = bool2;
        break;
        paramInt = 0;
        break label418;
        bool1 = false;
      }
    }
    mScrollHelper.setEnabled(false);
    return bool1;
  }
  
  protected final boolean touchModeDrawsInPressedStateCompat()
  {
    return (mDrawsInPressedState) || (super.touchModeDrawsInPressedStateCompat());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.DropDownListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */