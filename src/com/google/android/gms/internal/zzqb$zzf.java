package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqb$zzf
  extends zzsu
{
  public long[] zzbaG = zzsx.zzbux;
  public long[] zzbaH = zzsx.zzbux;
  
  public zzqb$zzf()
  {
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzf)) {
        return false;
      }
      paramObject = (zzf)paramObject;
      if (!zzss.equals(zzbaG, zzbaG)) {
        return false;
      }
    } while (zzss.equals(zzbaH, zzbaH));
    return false;
  }
  
  public final int hashCode()
  {
    return ((getClass().getName().hashCode() + 527) * 31 + zzss.hashCode(zzbaG)) * 31 + zzss.hashCode(zzbaH);
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    int j = 0;
    int i;
    if ((zzbaG != null) && (zzbaG.length > 0))
    {
      i = 0;
      while (i < zzbaG.length)
      {
        paramzzsn.zza(1, zzbaG[i]);
        i += 1;
      }
    }
    if ((zzbaH != null) && (zzbaH.length > 0))
    {
      i = j;
      while (i < zzbaH.length)
      {
        paramzzsn.zza(2, zzbaH[i]);
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  public final zzf zzH(zzsm paramzzsm)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzsm.zzIX();
      int j;
      long[] arrayOfLong;
      int k;
      switch (i)
      {
      default: 
        if (zzsx.zzb(paramzzsm, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        j = zzsx.zzc(paramzzsm, 8);
        if (zzbaG == null) {}
        for (i = 0;; i = zzbaG.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbaG, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramzzsm.zzJg();
            paramzzsm.zzIX();
            j += 1;
          }
        }
        arrayOfLong[j] = paramzzsm.zzJg();
        zzbaG = arrayOfLong;
        break;
      case 10: 
        k = paramzzsm.zzmq(paramzzsm.zzJf());
        i = paramzzsm.getPosition();
        j = 0;
        while (paramzzsm.zzJk() > 0)
        {
          paramzzsm.zzJg();
          j += 1;
        }
        paramzzsm.zzms(i);
        if (zzbaG == null) {}
        for (i = 0;; i = zzbaG.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbaG, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramzzsm.zzJg();
            j += 1;
          }
        }
        zzbaG = arrayOfLong;
        paramzzsm.zzmr(k);
        break;
      case 16: 
        j = zzsx.zzc(paramzzsm, 16);
        if (zzbaH == null) {}
        for (i = 0;; i = zzbaH.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbaH, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramzzsm.zzJg();
            paramzzsm.zzIX();
            j += 1;
          }
        }
        arrayOfLong[j] = paramzzsm.zzJg();
        zzbaH = arrayOfLong;
        break;
      case 18: 
        k = paramzzsm.zzmq(paramzzsm.zzJf());
        i = paramzzsm.getPosition();
        j = 0;
        while (paramzzsm.zzJk() > 0)
        {
          paramzzsm.zzJg();
          j += 1;
        }
        paramzzsm.zzms(i);
        if (zzbaH == null) {}
        for (i = 0;; i = zzbaH.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbaH, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramzzsm.zzJg();
            j += 1;
          }
        }
        zzbaH = arrayOfLong;
        paramzzsm.zzmr(k);
      }
    }
  }
  
  protected final int zzz()
  {
    int m = 0;
    int k = super.zzz();
    int j;
    if ((zzbaG != null) && (zzbaG.length > 0))
    {
      i = 0;
      j = 0;
      while (i < zzbaG.length)
      {
        j += zzsn.zzav(zzbaG[i]);
        i += 1;
      }
    }
    for (int i = k + j + zzbaG.length * 1;; i = k)
    {
      j = i;
      if (zzbaH != null)
      {
        j = i;
        if (zzbaH.length > 0)
        {
          k = 0;
          j = m;
          while (j < zzbaH.length)
          {
            k += zzsn.zzav(zzbaH[j]);
            j += 1;
          }
          j = i + k + zzbaH.length * 1;
        }
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */