package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public final class zzsp<M extends zzso<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzbuk;
  protected final boolean zzbul;
  
  private int zzaa(Object paramObject)
  {
    int i = zzsx.zzmJ(tag);
    switch (type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + type);
    case 10: 
      paramObject = (zzsu)paramObject;
      return zzsn.zzmA(i) * 2 + ((zzsu)paramObject).getSerializedSize();
    }
    return zzsn.zzc(i, (zzsu)paramObject);
  }
  
  private void zzb(Object paramObject, zzsn paramzzsn)
  {
    for (;;)
    {
      try
      {
        paramzzsn.zzmB(tag);
        switch (type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (zzsu)paramObject;
      int i = zzsx.zzmJ(tag);
      ((zzsu)paramObject).writeTo(paramzzsn);
      paramzzsn.zzE(i, 4);
      return;
      paramzzsn.zzc((zzsu)paramObject);
      return;
    }
  }
  
  final int zzY(Object paramObject)
  {
    int i = 0;
    if (zzbul)
    {
      int m = Array.getLength(paramObject);
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (Array.get(paramObject, j) != null) {
          k = i + zzaa(Array.get(paramObject, j));
        }
        j += 1;
        i = k;
      }
    }
    int k = zzaa(paramObject);
    return k;
  }
  
  final void zza(Object paramObject, zzsn paramzzsn)
    throws IOException
  {
    if (zzbul)
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        if (localObject != null) {
          zzb(localObject, paramzzsn);
        }
        i += 1;
      }
    }
    zzb(paramObject, paramzzsn);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */