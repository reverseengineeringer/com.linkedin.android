package android.support.v4.view.accessibility;

public final class AccessibilityNodeInfoCompat$CollectionItemInfoCompat
{
  final Object mInfo;
  
  private AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object paramObject)
  {
    mInfo = paramObject;
  }
  
  public static CollectionItemInfoCompat obtain$430787b1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionItemInfo$771e0323(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */