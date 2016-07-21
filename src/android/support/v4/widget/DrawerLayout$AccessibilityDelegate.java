package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

final class DrawerLayout$AccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  private final Rect mTmpRect = new Rect();
  
  DrawerLayout$AccessibilityDelegate(DrawerLayout paramDrawerLayout) {}
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent = paramAccessibilityEvent.getText();
      paramView = DrawerLayout.access$600(this$0);
      int i;
      if (paramView != null)
      {
        i = this$0.getDrawerViewAbsoluteGravity(paramView);
        paramView = this$0;
        i = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(paramView));
        if (i != 3) {
          break label73;
        }
        paramView = mTitleLeft;
      }
      for (;;)
      {
        if (paramView != null) {
          paramAccessibilityEvent.add(paramView);
        }
        return true;
        label73:
        if (i == 5) {
          paramView = mTitleRight;
        } else {
          paramView = null;
        }
      }
    }
    return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (DrawerLayout.access$500()) {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    }
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setFocusable(false);
      paramAccessibilityNodeInfoCompat.setFocused(false);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
      return;
      Object localObject1 = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, (AccessibilityNodeInfoCompat)localObject1);
      AccessibilityNodeInfoCompat.IMPL.setSource(mInfo, paramView);
      Object localObject2 = ViewCompat.getParentForAccessibility(paramView);
      if ((localObject2 instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)localObject2);
      }
      localObject2 = mTmpRect;
      ((AccessibilityNodeInfoCompat)localObject1).getBoundsInParent((Rect)localObject2);
      AccessibilityNodeInfoCompat.IMPL.setBoundsInParent(mInfo, (Rect)localObject2);
      ((AccessibilityNodeInfoCompat)localObject1).getBoundsInScreen((Rect)localObject2);
      AccessibilityNodeInfoCompat.IMPL.setBoundsInScreen(mInfo, (Rect)localObject2);
      boolean bool = AccessibilityNodeInfoCompat.IMPL.isVisibleToUser(mInfo);
      AccessibilityNodeInfoCompat.IMPL.setVisibleToUser(mInfo, bool);
      localObject2 = ((AccessibilityNodeInfoCompat)localObject1).getPackageName();
      AccessibilityNodeInfoCompat.IMPL.setPackageName(mInfo, (CharSequence)localObject2);
      paramAccessibilityNodeInfoCompat.setClassName(((AccessibilityNodeInfoCompat)localObject1).getClassName());
      localObject2 = ((AccessibilityNodeInfoCompat)localObject1).getContentDescription();
      AccessibilityNodeInfoCompat.IMPL.setContentDescription(mInfo, (CharSequence)localObject2);
      bool = ((AccessibilityNodeInfoCompat)localObject1).isEnabled();
      AccessibilityNodeInfoCompat.IMPL.setEnabled(mInfo, bool);
      bool = ((AccessibilityNodeInfoCompat)localObject1).isClickable();
      AccessibilityNodeInfoCompat.IMPL.setClickable(mInfo, bool);
      paramAccessibilityNodeInfoCompat.setFocusable(((AccessibilityNodeInfoCompat)localObject1).isFocusable());
      paramAccessibilityNodeInfoCompat.setFocused(((AccessibilityNodeInfoCompat)localObject1).isFocused());
      bool = AccessibilityNodeInfoCompat.IMPL.isAccessibilityFocused(mInfo);
      AccessibilityNodeInfoCompat.IMPL.setAccessibilityFocused(mInfo, bool);
      bool = ((AccessibilityNodeInfoCompat)localObject1).isSelected();
      AccessibilityNodeInfoCompat.IMPL.setSelected(mInfo, bool);
      bool = ((AccessibilityNodeInfoCompat)localObject1).isLongClickable();
      AccessibilityNodeInfoCompat.IMPL.setLongClickable(mInfo, bool);
      paramAccessibilityNodeInfoCompat.addAction(((AccessibilityNodeInfoCompat)localObject1).getActions());
      AccessibilityNodeInfoCompat.IMPL.recycle(mInfo);
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject1 = paramView.getChildAt(i);
        if (DrawerLayout.access$700((View)localObject1)) {
          AccessibilityNodeInfoCompat.IMPL.addChild(mInfo, (View)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((DrawerLayout.access$500()) || (DrawerLayout.access$700(paramView))) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.DrawerLayout.AccessibilityDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */