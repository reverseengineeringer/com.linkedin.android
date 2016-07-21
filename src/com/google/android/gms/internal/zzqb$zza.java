package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqb$zza
  extends zzsu
{
  private static volatile zza[] zzaZZ;
  public Integer zzaZr = null;
  public zzqb.zzf zzbaa = null;
  public zzqb.zzf zzbab = null;
  public Boolean zzbac = null;
  
  public zzqb$zza()
  {
    zzbuu = -1;
  }
  
  public static zza[] zzDP()
  {
    if (zzaZZ == null) {}
    synchronized (zzss.zzbut)
    {
      if (zzaZZ == null) {
        zzaZZ = new zza[0];
      }
      return zzaZZ;
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
        if (zzbaa == null)
        {
          if (zzbaa != null) {
            return false;
          }
        }
        else if (!zzbaa.equals(zzbaa)) {
          return false;
        }
        if (zzbab == null)
        {
          if (zzbab != null) {
            return false;
          }
        }
        else if (!zzbab.equals(zzbab)) {
          return false;
        }
        if (zzbac != null) {
          break;
        }
      } while (zzbac == null);
      return false;
    } while (zzbac.equals(zzbac));
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    if (zzaZr == null)
    {
      i = 0;
      if (zzbaa != null) {
        break label88;
      }
      j = 0;
      if (zzbab != null) {
        break label99;
      }
      k = 0;
      label42:
      if (zzbac != null) {
        break label110;
      }
    }
    for (;;)
    {
      return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      i = zzaZr.hashCode();
      break;
      label88:
      j = zzbaa.hashCode();
      break label33;
      label99:
      k = zzbab.hashCode();
      break label42;
      label110:
      m = zzbac.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzaZr != null) {
      paramzzsn.zzA(1, zzaZr.intValue());
    }
    if (zzbaa != null) {
      paramzzsn.zza(2, zzbaa);
    }
    if (zzbab != null) {
      paramzzsn.zza(3, zzbab);
    }
    if (zzbac != null) {
      paramzzsn.zze(4, zzbac.booleanValue());
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int j = super.zzz();
    int i = j;
    if (zzaZr != null) {
      i = j + zzsn.zzC(1, zzaZr.intValue());
    }
    j = i;
    if (zzbaa != null) {
      j = i + zzsn.zzc(2, zzbaa);
    }
    i = j;
    if (zzbab != null) {
      i = j + zzsn.zzc(3, zzbab);
    }
    j = i;
    if (zzbac != null)
    {
      zzbac.booleanValue();
      j = i + (zzsn.zzmA(4) + 1);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */