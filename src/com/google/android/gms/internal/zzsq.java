package com.google.android.gms.internal;

public final class zzsq
  implements Cloneable
{
  static final zzsr zzbum = new zzsr();
  int mSize;
  boolean zzbun = false;
  int[] zzbuo;
  zzsr[] zzbup;
  
  zzsq()
  {
    this(10);
  }
  
  private zzsq(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    zzbuo = new int[paramInt];
    zzbup = new zzsr[paramInt];
    mSize = 0;
  }
  
  static int idealIntArraySize(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label71:
    label93:
    label131:
    label138:
    label141:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof zzsq)) {
        return false;
      }
      paramObject = (zzsq)paramObject;
      if (size() != ((zzsq)paramObject).size()) {
        return false;
      }
      Object localObject = zzbuo;
      int[] arrayOfInt = zzbuo;
      int j = mSize;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          if (i != 0)
          {
            localObject = zzbup;
            paramObject = zzbup;
            j = mSize;
            i = 0;
            if (i >= j) {
              break label138;
            }
            if (localObject[i].equals(paramObject[i])) {
              break label131;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label141;
        }
        return false;
        i += 1;
        break;
        i = 1;
        break label71;
        i += 1;
        break label93;
      }
    }
  }
  
  final void gc()
  {
    int m = mSize;
    int[] arrayOfInt = zzbuo;
    zzsr[] arrayOfzzsr = zzbup;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      zzsr localzzsr = arrayOfzzsr[i];
      k = j;
      if (localzzsr != zzbum)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfzzsr[j] = localzzsr;
          arrayOfzzsr[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    zzbun = false;
    mSize = j;
  }
  
  public final int hashCode()
  {
    if (zzbun) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + zzbuo[i]) * 31 + zzbup[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  final int size()
  {
    if (zzbun) {
      gc();
    }
    return mSize;
  }
  
  public final zzsq zzJq()
  {
    int i = 0;
    int j = size();
    zzsq localzzsq = new zzsq(j);
    System.arraycopy(zzbuo, 0, zzbuo, 0, j);
    while (i < j)
    {
      if (zzbup[i] != null) {
        zzbup[i] = zzbup[i].zzJr();
      }
      i += 1;
    }
    mSize = j;
    return localzzsq;
  }
  
  final zzsr zzmG(int paramInt)
  {
    if (zzbun) {
      gc();
    }
    return zzbup[paramInt];
  }
  
  final int zzmH(int paramInt)
  {
    int j = mSize;
    int i = 0;
    j -= 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = zzbuo[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */