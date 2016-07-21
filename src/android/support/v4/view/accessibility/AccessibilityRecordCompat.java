package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class AccessibilityRecordCompat
{
  public static final AccessibilityRecordImpl IMPL = new AccessibilityRecordStubImpl();
  public final Object mRecord;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityRecordJellyBeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      IMPL = new AccessibilityRecordIcsMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityRecordIcsImpl();
      return;
    }
  }
  
  public AccessibilityRecordCompat(Object paramObject)
  {
    mRecord = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityRecordCompat)paramObject;
        if (mRecord != null) {
          break;
        }
      } while (mRecord == null);
      return false;
    } while (mRecord.equals(mRecord));
    return false;
  }
  
  public final int hashCode()
  {
    if (mRecord == null) {
      return 0;
    }
    return mRecord.hashCode();
  }
  
  public final void setFromIndex(int paramInt)
  {
    IMPL.setFromIndex(mRecord, paramInt);
  }
  
  public final void setItemCount(int paramInt)
  {
    IMPL.setItemCount(mRecord, paramInt);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mRecord, paramBoolean);
  }
  
  public final void setToIndex(int paramInt)
  {
    IMPL.setToIndex(mRecord, paramInt);
  }
  
  static class AccessibilityRecordIcsImpl
    extends AccessibilityRecordCompat.AccessibilityRecordStubImpl
  {
    public final void setFromIndex(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setFromIndex(paramInt);
    }
    
    public final void setItemCount(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setItemCount(paramInt);
    }
    
    public final void setScrollX(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setScrollX(paramInt);
    }
    
    public final void setScrollY(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setScrollY(paramInt);
    }
    
    public final void setScrollable(Object paramObject, boolean paramBoolean)
    {
      ((AccessibilityRecord)paramObject).setScrollable(paramBoolean);
    }
    
    public final void setToIndex(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setToIndex(paramInt);
    }
  }
  
  static class AccessibilityRecordIcsMr1Impl
    extends AccessibilityRecordCompat.AccessibilityRecordIcsImpl
  {
    public final void setMaxScrollX(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setMaxScrollX(paramInt);
    }
    
    public final void setMaxScrollY(Object paramObject, int paramInt)
    {
      ((AccessibilityRecord)paramObject).setMaxScrollY(paramInt);
    }
  }
  
  public static abstract interface AccessibilityRecordImpl
  {
    public abstract void setFromIndex(Object paramObject, int paramInt);
    
    public abstract void setItemCount(Object paramObject, int paramInt);
    
    public abstract void setMaxScrollX(Object paramObject, int paramInt);
    
    public abstract void setMaxScrollY(Object paramObject, int paramInt);
    
    public abstract void setScrollX(Object paramObject, int paramInt);
    
    public abstract void setScrollY(Object paramObject, int paramInt);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setToIndex(Object paramObject, int paramInt);
  }
  
  static final class AccessibilityRecordJellyBeanImpl
    extends AccessibilityRecordCompat.AccessibilityRecordIcsMr1Impl
  {}
  
  static class AccessibilityRecordStubImpl
    implements AccessibilityRecordCompat.AccessibilityRecordImpl
  {
    public void setFromIndex(Object paramObject, int paramInt) {}
    
    public void setItemCount(Object paramObject, int paramInt) {}
    
    public void setMaxScrollX(Object paramObject, int paramInt) {}
    
    public void setMaxScrollY(Object paramObject, int paramInt) {}
    
    public void setScrollX(Object paramObject, int paramInt) {}
    
    public void setScrollY(Object paramObject, int paramInt) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setToIndex(Object paramObject, int paramInt) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityRecordCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */