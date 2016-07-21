package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
{
  public final boolean isAccessibilityFocused(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
  
  public final boolean isVisibleToUser(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }
  
  public final void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }
  
  public final void setVisibleToUser(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */