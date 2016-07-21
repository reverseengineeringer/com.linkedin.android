package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.PopupWindow;

public abstract class ListPopupWindow$ForwardingListener
  implements View.OnTouchListener
{
  private int mActivePointerId;
  private Runnable mDisallowIntercept;
  private boolean mForwarding;
  private final int mLongPressTimeout;
  private final float mScaledTouchSlop;
  private final View mSrc;
  private final int mTapTimeout;
  private final int[] mTmpLocation = new int[2];
  private Runnable mTriggerLongPress;
  private boolean mWasLongPress;
  
  public ListPopupWindow$ForwardingListener(View paramView)
  {
    mSrc = paramView;
    mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    mTapTimeout = ViewConfiguration.getTapTimeout();
    mLongPressTimeout = ((mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void clearCallbacks()
  {
    if (mTriggerLongPress != null) {
      mSrc.removeCallbacks(mTriggerLongPress);
    }
    if (mDisallowIntercept != null) {
      mSrc.removeCallbacks(mDisallowIntercept);
    }
  }
  
  private boolean onTouchForwarded(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    Object localObject1 = mSrc;
    Object localObject2 = getPopup();
    if ((localObject2 == null) || (!mPopup.isShowing())) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      localObject2 = ListPopupWindow.access$600((ListPopupWindow)localObject2);
      if ((localObject2 == null) || (!((ListPopupWindow.DropDownListView)localObject2).isShown())) {
        return false;
      }
      MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
      int[] arrayOfInt = mTmpLocation;
      ((View)localObject1).getLocationOnScreen(arrayOfInt);
      localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      localObject1 = mTmpLocation;
      ((View)localObject2).getLocationOnScreen((int[])localObject1);
      localMotionEvent.offsetLocation(-localObject1[0], -localObject1[1]);
      boolean bool2 = ((ListPopupWindow.DropDownListView)localObject2).onForwardedEvent(localMotionEvent, mActivePointerId);
      localMotionEvent.recycle();
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      if ((i != 1) && (i != 3)) {}
      for (i = 1; (!bool2) || (i == 0); i = 0) {
        return false;
      }
    }
  }
  
  public abstract ListPopupWindow getPopup();
  
  public boolean onForwardingStarted()
  {
    ListPopupWindow localListPopupWindow = getPopup();
    if ((localListPopupWindow != null) && (!mPopup.isShowing())) {
      localListPopupWindow.show();
    }
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    ListPopupWindow localListPopupWindow = getPopup();
    if ((localListPopupWindow != null) && (mPopup.isShowing())) {
      localListPopupWindow.dismiss();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool4 = mForwarding;
    boolean bool1;
    if (bool4)
    {
      if (mWasLongPress)
      {
        bool1 = onTouchForwarded(paramMotionEvent);
        mForwarding = bool1;
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool4) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if ((onTouchForwarded(paramMotionEvent)) || (!onForwardingStopped())) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
    }
    paramView = mSrc;
    if (paramView.isEnabled()) {}
    label128:
    int i;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    default: 
      i = 0;
      label131:
      if ((i == 0) || (!onForwardingStarted())) {
        break;
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      long l = SystemClock.uptimeMillis();
      paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      mSrc.onTouchEvent(paramView);
      paramView.recycle();
      bool1 = bool2;
      break;
      mActivePointerId = paramMotionEvent.getPointerId(0);
      mWasLongPress = false;
      if (mDisallowIntercept == null) {
        mDisallowIntercept = new DisallowIntercept((byte)0);
      }
      paramView.postDelayed(mDisallowIntercept, mTapTimeout);
      if (mTriggerLongPress == null) {
        mTriggerLongPress = new TriggerLongPress((byte)0);
      }
      paramView.postDelayed(mTriggerLongPress, mLongPressTimeout);
      break label128;
      i = paramMotionEvent.findPointerIndex(mActivePointerId);
      if (i < 0) {
        break label128;
      }
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float f3 = mScaledTouchSlop;
      if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
      for (i = 1; i == 0; i = 0)
      {
        clearCallbacks();
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
        i = 1;
        break label131;
      }
      clearCallbacks();
      break label128;
    }
  }
  
  private final class DisallowIntercept
    implements Runnable
  {
    private DisallowIntercept() {}
    
    public final void run()
    {
      mSrc.getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private final class TriggerLongPress
    implements Runnable
  {
    private TriggerLongPress() {}
    
    public final void run()
    {
      ListPopupWindow.ForwardingListener.access$1000(ListPopupWindow.ForwardingListener.this);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ForwardingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */