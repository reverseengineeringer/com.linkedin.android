package android.support.v4.util;

public final class LongSparseArray<E>
  implements Cloneable
{
  public static final Object DELETED = new Object();
  public boolean mGarbage = false;
  public long[] mKeys;
  public int mSize;
  public Object[] mValues;
  
  public LongSparseArray()
  {
    this((byte)0);
  }
  
  private LongSparseArray(byte paramByte)
  {
    paramByte = ContainerHelpers.idealLongArraySize(10);
    mKeys = new long[paramByte];
    mValues = new Object[paramByte];
    mSize = 0;
  }
  
  private LongSparseArray<E> clone()
  {
    Object localObject = null;
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)super.clone();
      localObject = localLongSparseArray;
      mKeys = ((long[])mKeys.clone());
      localObject = localLongSparseArray;
      mValues = ((Object[])mValues.clone());
      return localLongSparseArray;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return (LongSparseArray<E>)localObject;
  }
  
  private void gc()
  {
    int m = mSize;
    int j = 0;
    long[] arrayOfLong = mKeys;
    Object[] arrayOfObject = mValues;
    int i = 0;
    while (i < m)
    {
      Object localObject = arrayOfObject[i];
      int k = j;
      if (localObject != DELETED)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    mGarbage = false;
    mSize = j;
  }
  
  private long keyAt(int paramInt)
  {
    if (mGarbage) {
      gc();
    }
    return mKeys[paramInt];
  }
  
  public final E get(long paramLong)
  {
    int i = ContainerHelpers.binarySearch(mKeys, mSize, paramLong);
    if ((i < 0) || (mValues[i] == DELETED)) {
      return null;
    }
    return (E)mValues[i];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(mKeys, mSize, paramLong);
    if (i >= 0)
    {
      mValues[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < mSize) && (mValues[j] == DELETED))
    {
      mKeys[j] = paramLong;
      mValues[j] = paramE;
      return;
    }
    i = j;
    if (mGarbage)
    {
      i = j;
      if (mSize >= mKeys.length)
      {
        gc();
        i = ContainerHelpers.binarySearch(mKeys, mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (mSize >= mKeys.length)
    {
      j = ContainerHelpers.idealLongArraySize(mSize + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(mKeys, 0, arrayOfLong, 0, mKeys.length);
      System.arraycopy(mValues, 0, arrayOfObject, 0, mValues.length);
      mKeys = arrayOfLong;
      mValues = arrayOfObject;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
      System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
    }
    mKeys[i] = paramLong;
    mValues[i] = paramE;
    mSize += 1;
  }
  
  public final int size()
  {
    if (mGarbage) {
      gc();
    }
    return mSize;
  }
  
  public final String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final E valueAt(int paramInt)
  {
    if (mGarbage) {
      gc();
    }
    return (E)mValues[paramInt];
  }
}

/* Location:
 * Qualified Name:     android.support.v4.util.LongSparseArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */