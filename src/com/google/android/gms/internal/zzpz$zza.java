package com.google.android.gms.internal;

import java.io.IOException;

public final class zzpz$zza
  extends zzsu
{
  private static volatile zza[] zzaZq;
  public Integer zzaZr = null;
  public zzpz.zze[] zzaZs = zzpz.zze.zzDH();
  public zzpz.zzb[] zzaZt = zzpz.zzb.zzDC();
  
  public zzpz$zza()
  {
    zzbuu = -1;
  }
  
  public static zza[] zzDA()
  {
    if (zzaZq == null) {}
    synchronized (zzss.zzbut)
    {
      if (zzaZq == null) {
        zzaZq = new zza[0];
      }
      return zzaZq;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (zzaZr == null)
      {
        if (zzaZr != null) {
          return false;
        }
      }
      else if (!zzaZr.equals(zzaZr)) {
        return false;
      }
      if (!zzss.equals(zzaZs, zzaZs)) {
        return false;
      }
    } while (zzss.equals(zzaZt, zzaZt));
    return false;
  }
  
  public final int hashCode()
  {
    int j = getClass().getName().hashCode();
    if (zzaZr == null) {}
    for (int i = 0;; i = zzaZr.hashCode()) {
      return ((i + (j + 527) * 31) * 31 + zzss.hashCode(zzaZs)) * 31 + zzss.hashCode(zzaZt);
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    int j = 0;
    if (zzaZr != null) {
      paramzzsn.zzA(1, zzaZr.intValue());
    }
    int i;
    Object localObject;
    if ((zzaZs != null) && (zzaZs.length > 0))
    {
      i = 0;
      while (i < zzaZs.length)
      {
        localObject = zzaZs[i];
        if (localObject != null) {
          paramzzsn.zza(2, (zzsu)localObject);
        }
        i += 1;
      }
    }
    if ((zzaZt != null) && (zzaZt.length > 0))
    {
      i = j;
      while (i < zzaZt.length)
      {
        localObject = zzaZt[i];
        if (localObject != null) {
          paramzzsn.zza(3, (zzsu)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int m = 0;
    int i = super.zzz();
    int j = i;
    if (zzaZr != null) {
      j = i + zzsn.zzC(1, zzaZr.intValue());
    }
    i = j;
    Object localObject;
    if (zzaZs != null)
    {
      i = j;
      if (zzaZs.length > 0)
      {
        i = j;
        j = 0;
        while (j < zzaZs.length)
        {
          localObject = zzaZs[j];
          k = i;
          if (localObject != null) {
            k = i + zzsn.zzc(2, (zzsu)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (zzaZt != null)
    {
      k = i;
      if (zzaZt.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= zzaZt.length) {
            break;
          }
          localObject = zzaZt[j];
          k = i;
          if (localObject != null) {
            k = i + zzsn.zzc(3, (zzsu)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpz.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */