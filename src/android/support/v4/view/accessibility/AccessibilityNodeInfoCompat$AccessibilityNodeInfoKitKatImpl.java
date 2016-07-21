package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl
  extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl
{
  public Object obtainCollectionInfo$50cb9c52(int paramInt1, int paramInt2)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false);
  }
  
  public Object obtainCollectionItemInfo$771e0323(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public final void setCollectionInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject2);
  }
  
  public final void setCollectionItemInfo(Object paramObject1, Object paramObject2)
  {
    ((AccessibilityNodeInfo)paramObject1).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject2);
  }
  
  public final void setContentInvalid$4cfd3ce3(Object paramObject)
  {
    ((AccessibilityNodeInfo)paramObject).setContentInvalid(true);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */