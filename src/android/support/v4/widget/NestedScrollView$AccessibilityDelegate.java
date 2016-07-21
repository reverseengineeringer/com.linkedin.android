package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat.AccessibilityRecordImpl;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

final class NestedScrollView$AccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
    if (NestedScrollView.access$000(paramView) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      int i = paramView.getScrollX();
      AccessibilityRecordCompat.IMPL.setScrollX(mRecord, i);
      i = paramView.getScrollY();
      AccessibilityRecordCompat.IMPL.setScrollY(mRecord, i);
      i = paramView.getScrollX();
      AccessibilityRecordCompat.IMPL.setMaxScrollX(mRecord, i);
      i = NestedScrollView.access$000(paramView);
      AccessibilityRecordCompat.IMPL.setMaxScrollY(mRecord, i);
      return;
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
    if (paramView.isEnabled())
    {
      int i = NestedScrollView.access$000(paramView);
      if (i > 0)
      {
        paramAccessibilityNodeInfoCompat.setScrollable(true);
        if (paramView.getScrollY() > 0) {
          paramAccessibilityNodeInfoCompat.addAction(8192);
        }
        if (paramView.getScrollY() < i) {
          paramAccessibilityNodeInfoCompat.addAction(4096);
        }
      }
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    paramView = (NestedScrollView)paramView;
    if (!paramView.isEnabled()) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      paramInt = paramView.getHeight();
      i = paramView.getPaddingBottom();
      j = paramView.getPaddingTop();
      paramInt = Math.min(paramView.getScrollY() + (paramInt - i - j), NestedScrollView.access$000(paramView));
      if (paramInt != paramView.getScrollY())
      {
        paramView.smoothScrollTo$255f295(paramInt);
        return true;
      }
      return false;
    }
    paramInt = paramView.getHeight();
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
    if (paramInt != paramView.getScrollY())
    {
      paramView.smoothScrollTo$255f295(paramInt);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.NestedScrollView.AccessibilityDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */