package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzn
{
  private static final Object zzqy = new Object();
  private static zzn zzur;
  private final zza zzus = new zza();
  private final zze zzut = new zze();
  private final zzl zzuu = new zzl();
  private final zzaf zzuv = new zzaf();
  private final zzcv zzuw = new zzcv();
  private final zzf zzux = new zzf();
  
  static
  {
    zzn localzzn = new zzn();
    synchronized (zzqy)
    {
      zzur = localzzn;
      return;
    }
  }
  
  private static zzn zzcR()
  {
    synchronized (zzqy)
    {
      zzn localzzn = zzur;
      return localzzn;
    }
  }
  
  public static zza zzcS()
  {
    return zzcRzzus;
  }
  
  public static zzl zzcU()
  {
    return zzcRzzuu;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */