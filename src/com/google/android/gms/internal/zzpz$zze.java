package com.google.android.gms.internal;

import java.io.IOException;

public final class zzpz$zze
  extends zzsu
{
  private static volatile zze[] zzaZK;
  public String zzaZL = null;
  public zzpz.zzc zzaZM = null;
  public Integer zzaZv = null;
  
  public zzpz$zze()
  {
    zzbuu = -1;
  }
  
  public static zze[] zzDH()
  {
    if (zzaZK == null) {}
    synchronized (zzss.zzbut)
    {
      if (zzaZK == null) {
        zzaZK = new zze[0];
      }
      return zzaZK;
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
        if (!(paramObject instanceof zze)) {
          return false;
        }
        paramObject = (zze)paramObject;
        if (zzaZv == null)
        {
          if (zzaZv != null) {
            return false;
          }
        }
        else if (!zzaZv.equals(zzaZv)) {
          return false;
        }
        if (zzaZL == null)
        {
          if (zzaZL != null) {
            return false;
          }
        }
        else if (!zzaZL.equals(zzaZL)) {
          return false;
        }
        if (zzaZM != null) {
          break;
        }
      } while (zzaZM == null);
      return false;
    } while (zzaZM.equals(zzaZM));
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (zzaZv == null)
    {
      i = 0;
      if (zzaZL != null) {
        break label72;
      }
      j = 0;
      label32:
      if (zzaZM != null) {
        break label83;
      }
    }
    for (;;)
    {
      return (j + (i + (m + 527) * 31) * 31) * 31 + k;
      i = zzaZv.hashCode();
      break;
      label72:
      j = zzaZL.hashCode();
      break label32;
      label83:
      k = zzaZM.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzaZv != null) {
      paramzzsn.zzA(1, zzaZv.intValue());
    }
    if (zzaZL != null) {
      paramzzsn.zzn(2, zzaZL);
    }
    if (zzaZM != null) {
      paramzzsn.zza(3, zzaZM);
    }
    super.writeTo(paramzzsn);
  }
  
  public final zze zzx(zzsm paramzzsm)
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
      case 8: 
        zzaZv = Integer.valueOf(paramzzsm.zzJf());
        break;
      case 18: 
        zzaZL = paramzzsm.readString();
        break;
      case 26: 
        if (zzaZM == null) {
          zzaZM = new zzpz.zzc();
        }
        paramzzsm.zza(zzaZM);
      }
    }
  }
  
  protected final int zzz()
  {
    int j = super.zzz();
    int i = j;
    if (zzaZv != null) {
      i = j + zzsn.zzC(1, zzaZv.intValue());
    }
    j = i;
    if (zzaZL != null) {
      j = i + zzsn.zzo(2, zzaZL);
    }
    i = j;
    if (zzaZM != null) {
      i = j + zzsn.zzc(3, zzaZM);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpz.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */