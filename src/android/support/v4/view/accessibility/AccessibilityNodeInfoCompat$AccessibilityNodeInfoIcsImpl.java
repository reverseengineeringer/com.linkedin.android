package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
{
  public final void addAction(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addAction(paramInt);
  }
  
  public final void addChild(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView);
  }
  
  public final int getActions(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getActions();
  }
  
  public final void getBoundsInParent(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInScreen(paramRect);
  }
  
  public final CharSequence getClassName(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getClassName();
  }
  
  public final CharSequence getContentDescription(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getContentDescription();
  }
  
  public final CharSequence getPackageName(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getPackageName();
  }
  
  public final CharSequence getText(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getText();
  }
  
  public final boolean isCheckable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isCheckable();
  }
  
  public final boolean isChecked(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isChecked();
  }
  
  public final boolean isClickable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isClickable();
  }
  
  public final boolean isEnabled(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isEnabled();
  }
  
  public final boolean isFocusable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocusable();
  }
  
  public final boolean isFocused(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocused();
  }
  
  public final boolean isLongClickable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isLongClickable();
  }
  
  public final boolean isPassword(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isPassword();
  }
  
  public final boolean isScrollable(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isScrollable();
  }
  
  public final boolean isSelected(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isSelected();
  }
  
  public final Object obtain(Object paramObject)
  {
    return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)paramObject);
  }
  
  public final void recycle(Object paramObject)
  {
    ((AccessibilityNodeInfo)paramObject).recycle();
  }
  
  public final void setBoundsInParent(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInScreen(paramRect);
  }
  
  public final void setClassName(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setClassName(paramCharSequence);
  }
  
  public final void setClickable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setClickable(paramBoolean);
  }
  
  public final void setContentDescription(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setContentDescription(paramCharSequence);
  }
  
  public final void setEnabled(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setEnabled(paramBoolean);
  }
  
  public final void setFocusable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocusable(paramBoolean);
  }
  
  public final void setFocused(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocused(paramBoolean);
  }
  
  public final void setLongClickable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setPackageName(paramCharSequence);
  }
  
  public final void setParent(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView);
  }
  
  public final void setScrollable(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setScrollable(paramBoolean);
  }
  
  public final void setSelected(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setSelected(paramBoolean);
  }
  
  public final void setSource(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView);
  }
  
  public final void setText(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setText(paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */