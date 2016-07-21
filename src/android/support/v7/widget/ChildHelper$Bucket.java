package android.support.v7.widget;

final class ChildHelper$Bucket
{
  long mData = 0L;
  Bucket next;
  
  private void ensureNext()
  {
    if (next == null) {
      next = new Bucket();
    }
  }
  
  final void clear(int paramInt)
  {
    Bucket localBucket = this;
    while (paramInt >= 64)
    {
      if (next == null) {
        return;
      }
      localBucket = next;
      paramInt -= 64;
    }
    mData &= (1L << paramInt ^ 0xFFFFFFFFFFFFFFFF);
  }
  
  final int countOnesBefore(int paramInt)
  {
    if (next == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(mData);
      }
      return Long.bitCount(mData & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(mData & (1L << paramInt) - 1L);
    }
    return next.countOnesBefore(paramInt - 64) + Long.bitCount(mData);
  }
  
  final boolean get(int paramInt)
  {
    Bucket localBucket = this;
    while (paramInt >= 64)
    {
      localBucket.ensureNext();
      localBucket = next;
      paramInt -= 64;
    }
    return (mData & 1L << paramInt) != 0L;
  }
  
  final void insert(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    Bucket localBucket = this;
    while (paramInt >= 64)
    {
      localBucket.ensureNext();
      localBucket = next;
      paramInt -= 64;
    }
    if ((mData & 0x8000000000000000) != 0L)
    {
      paramBoolean = true;
      label47:
      long l = (1L << paramInt) - 1L;
      mData = (mData & l | (mData & (0xFFFFFFFFFFFFFFFF ^ l)) << 1);
      if (!bool) {
        break label128;
      }
      localBucket.set(paramInt);
    }
    for (;;)
    {
      if ((!paramBoolean) && (next == null)) {
        return;
      }
      localBucket.ensureNext();
      localBucket = next;
      paramInt = 0;
      bool = paramBoolean;
      break;
      paramBoolean = false;
      break label47;
      label128:
      localBucket.clear(paramInt);
    }
  }
  
  final boolean remove(int paramInt)
  {
    Bucket localBucket = this;
    while (paramInt >= 64)
    {
      localBucket.ensureNext();
      localBucket = next;
      paramInt -= 64;
    }
    long l = 1L << paramInt;
    if ((mData & l) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      mData &= (0xFFFFFFFFFFFFFFFF ^ l);
      l -= 1L;
      mData = (mData & l | Long.rotateRight(mData & (0xFFFFFFFFFFFFFFFF ^ l), 1));
      if (next != null)
      {
        if (next.get(0)) {
          localBucket.set(63);
        }
        next.remove(0);
      }
      return bool;
    }
  }
  
  final void set(int paramInt)
  {
    Bucket localBucket = this;
    while (paramInt >= 64)
    {
      localBucket.ensureNext();
      localBucket = next;
      paramInt -= 64;
    }
    mData |= 1L << paramInt;
  }
  
  public final String toString()
  {
    if (next == null) {
      return Long.toBinaryString(mData);
    }
    return next.toString() + "xx" + Long.toBinaryString(mData);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ChildHelper.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */