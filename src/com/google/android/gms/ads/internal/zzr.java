package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.internal.zzbq;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzih;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzis.zza;
import com.google.android.gms.internal.zzis.zzb;
import com.google.android.gms.internal.zzis.zzc;
import com.google.android.gms.internal.zzis.zzd;
import com.google.android.gms.internal.zzis.zze;
import com.google.android.gms.internal.zzis.zzf;
import com.google.android.gms.internal.zzis.zzg;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;

@zzhb
public final class zzr
{
  private static zzr zzqN;
  private static final Object zzqy = new Object();
  private final com.google.android.gms.ads.internal.request.zza zzqO = new com.google.android.gms.ads.internal.request.zza();
  private final com.google.android.gms.ads.internal.overlay.zza zzqP = new com.google.android.gms.ads.internal.overlay.zza();
  private final zze zzqQ = new zze();
  private final zzgr zzqR = new zzgr();
  private final zzir zzqS = new zzir();
  private final zzjr zzqT = new zzjr();
  private final zzis zzqU;
  private final zzih zzqV;
  private final zzmq zzqW;
  private final zzbw zzqX;
  private final zzhk zzqY;
  private final zzbr zzqZ;
  private final zzbq zzra;
  private final zzbs zzrb;
  private final zzi zzrc;
  private final zzdy zzrd;
  private final zzix zzre;
  private final zzet zzrf;
  private final zzo zzrg;
  private final zzdq zzrh;
  
  static
  {
    zzr localzzr = new zzr();
    synchronized (zzqy)
    {
      zzqN = localzzr;
      return;
    }
  }
  
  protected zzr()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i >= 19) {
      localObject = new zzis.zzg();
    }
    for (;;)
    {
      zzqU = ((zzis)localObject);
      zzqV = new zzih();
      zzqW = new zzmt();
      zzqX = new zzbw();
      zzqY = new zzhk();
      zzqZ = new zzbr();
      zzra = new zzbq();
      zzrb = new zzbs();
      zzrc = new zzi();
      zzrd = new zzdy();
      zzre = new zzix();
      zzrf = new zzet();
      zzrg = new zzo();
      zzrh = new zzdq();
      return;
      if (i >= 18) {
        localObject = new zzis.zze();
      } else if (i >= 17) {
        localObject = new zzis.zzd();
      } else if (i >= 16) {
        localObject = new zzis.zzf();
      } else if (i >= 14) {
        localObject = new zzis.zzc();
      } else if (i >= 11) {
        localObject = new zzis.zzb();
      } else if (i >= 9) {
        localObject = new zzis.zza();
      } else {
        localObject = new zzis();
      }
    }
  }
  
  public static zze zzbA()
  {
    return zzbxzzqQ;
  }
  
  public static zzir zzbC()
  {
    return zzbxzzqS;
  }
  
  public static zzjr zzbD()
  {
    return zzbxzzqT;
  }
  
  public static zzis zzbE()
  {
    return zzbxzzqU;
  }
  
  public static zzih zzbF()
  {
    return zzbxzzqV;
  }
  
  public static zzmq zzbG()
  {
    return zzbxzzqW;
  }
  
  public static zzbq zzbK()
  {
    return zzbxzzra;
  }
  
  public static zzbs zzbL()
  {
    return zzbxzzrb;
  }
  
  public static zzi zzbM()
  {
    return zzbxzzrc;
  }
  
  public static zzdq zzbR()
  {
    return zzbxzzrh;
  }
  
  private static zzr zzbx()
  {
    synchronized (zzqy)
    {
      zzr localzzr = zzqN;
      return localzzr;
    }
  }
  
  public static com.google.android.gms.ads.internal.overlay.zza zzbz()
  {
    return zzbxzzqP;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */