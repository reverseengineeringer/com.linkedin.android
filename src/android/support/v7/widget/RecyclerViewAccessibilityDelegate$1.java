package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

final class RecyclerViewAccessibilityDelegate$1
  extends AccessibilityDelegateCompat
{
  RecyclerViewAccessibilityDelegate$1(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate) {}
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((!this$0.shouldIgnore()) && (this$0.mRecyclerView.getLayoutManager() != null)) {
      this$0.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this$0.shouldIgnore());
      bool1 = bool2;
    } while (this$0.mRecyclerView.getLayoutManager() == null);
    paramView = this$0.mRecyclerView.getLayoutManager();
    paramBundle = mRecyclerView.mRecycler;
    paramView = mRecyclerView.mState;
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerViewAccessibilityDelegate.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */