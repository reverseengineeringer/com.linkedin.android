package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqb$zzb
  extends zzsu
{
  private static volatile zzb[] zzbad;
  public Integer count = null;
  public String name = null;
  public zzqb.zzc[] zzbae = zzqb.zzc.zzDT();
  public Long zzbaf = null;
  public Long zzbag = null;
  
  public zzqb$zzb()
  {
    zzbuu = -1;
  }
  
  public static zzb[] zzDR()
  {
    if (zzbad == null) {}
    synchronized (zzss.zzbut)
    {
      if (zzbad == null) {
        zzbad = new zzb[0];
      }
      return zzbad;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
        if (!zzss.equals(zzbae, zzbae)) {
          return false;
        }
        if (name == null)
        {
          if (name != null) {
            return false;
          }
        }
        else if (!name.equals(name)) {
          return false;
        }
        if (zzbaf == null)
        {
          if (zzbaf != null) {
            return false;
          }
        }
        else if (!zzbaf.equals(zzbaf)) {
          return false;
        }
        if (zzbag == null)
        {
          if (zzbag != null) {
            return false;
          }
        }
        else if (!zzbag.equals(zzbag)) {
          return false;
        }
        if (count != null) {
          break;
        }
      } while (count == null);
      return false;
    } while (count.equals(count));
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = zzss.hashCode(zzbae);
    int i;
    int j;
    label42:
    int k;
    if (name == null)
    {
      i = 0;
      if (zzbaf != null) {
        break label103;
      }
      j = 0;
      if (zzbag != null) {
        break label114;
      }
      k = 0;
      label51:
      if (count != null) {
        break label125;
      }
    }
    for (;;)
    {
      return (k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m;
      i = name.hashCode();
      break;
      label103:
      j = zzbaf.hashCode();
      break label42;
      label114:
      k = zzbag.hashCode();
      break label51;
      label125:
      m = count.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if ((zzbae != null) && (zzbae.length > 0))
    {
      int i = 0;
      while (i < zzbae.length)
      {
        zzqb.zzc localzzc = zzbae[i];
        if (localzzc != null) {
          paramzzsn.zza(1, localzzc);
        }
        i += 1;
      }
    }
    if (name != null) {
      paramzzsn.zzn(2, name);
    }
    if (zzbaf != null) {
      paramzzsn.zzb(3, zzbaf.longValue());
    }
    if (zzbag != null) {
      paramzzsn.zzb(4, zzbag.longValue());
    }
    if (count != null) {
      paramzzsn.zzA(5, count.intValue());
    }
    super.writeTo(paramzzsn);
  }
  
  public final zzb zzD(zzsm paramzzsm)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzsm.zzIX();
      switch (i)
      {
      default: 
        if (zzsx.zzb(paramzzsm, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        int j = zzsx.zzc(paramzzsm, 10);
        if (zzbae == null) {}
        zzqb.zzc[] arrayOfzzc;
        for (i = 0;; i = zzbae.length)
        {
          arrayOfzzc = new zzqb.zzc[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzbae, 0, arrayOfzzc, 0, i);
            j = i;
          }
          while (j < arrayOfzzc.length - 1)
          {
            arrayOfzzc[j] = new zzqb.zzc();
            paramzzsm.zza(arrayOfzzc[j]);
            paramzzsm.zzIX();
            j += 1;
          }
        }
        arrayOfzzc[j] = new zzqb.zzc();
        paramzzsm.zza(arrayOfzzc[j]);
        zzbae = arrayOfzzc;
        break;
      case 18: 
        name = paramzzsm.readString();
        break;
      case 24: 
        zzbaf = Long.valueOf(paramzzsm.zzJg());
        break;
      case 32: 
        zzbag = Long.valueOf(paramzzsm.zzJg());
        break;
      case 40: 
        count = Integer.valueOf(paramzzsm.zzJf());
      }
    }
  }
  
  protected final int zzz()
  {
    int i = super.zzz();
    int j = i;
    if (zzbae != null)
    {
      j = i;
      if (zzbae.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= zzbae.length) {
            break;
          }
          zzqb.zzc localzzc = zzbae[k];
          j = i;
          if (localzzc != null) {
            j = i + zzsn.zzc(1, localzzc);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (name != null) {
      i = j + zzsn.zzo(2, name);
    }
    j = i;
    if (zzbaf != null) {
      j = i + zzsn.zzd(3, zzbaf.longValue());
    }
    i = j;
    if (zzbag != null) {
      i = j + zzsn.zzd(4, zzbag.longValue());
    }
    j = i;
    if (count != null) {
      j = i + zzsn.zzC(5, count.intValue());
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */