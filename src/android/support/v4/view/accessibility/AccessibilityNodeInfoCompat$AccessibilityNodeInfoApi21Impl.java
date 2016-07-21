package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
{
  public final Object newAccessibilityAction$442b94a0(int paramInt)
  {
    return new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);
  }
  
  public final Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false, 0);
  }
  
  public final Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false);
  }
  
  public final boolean removeAction(Object paramObject1, Object paramObject2)
  {
    return ((AccessibilityNodeInfo)paramObject1).removeAction((AccessibilityNodeInfo.AccessibilityAction)paramObject2);
  }
  
  public final void setError(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setError(paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */