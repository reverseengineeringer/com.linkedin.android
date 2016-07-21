package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqb$zzd
  extends zzsu
{
  public zzqb.zze[] zzbaj = zzqb.zze.zzDW();
  
  public zzqb$zzd()
  {
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
    } while (zzss.equals(zzbaj, zzbaj));
    return false;
  }
  
  public final int hashCode()
  {
    return (getClass().getName().hashCode() + 527) * 31 + zzss.hashCode(zzbaj);
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if ((zzbaj != null) && (zzbaj.length > 0))
    {
      int i = 0;
      while (i < zzbaj.length)
      {
        zzqb.zze localzze = zzbaj[i];
        if (localzze != null) {
          paramzzsn.zza(1, localzze);
        }
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int i = super.zzz();
    int k = i;
    if (zzbaj != null)
    {
      k = i;
      if (zzbaj.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= zzbaj.length) {
            break;
          }
          zzqb.zze localzze = zzbaj[j];
          k = i;
          if (localzze != null) {
            k = i + zzsn.zzc(1, localzze);
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
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */