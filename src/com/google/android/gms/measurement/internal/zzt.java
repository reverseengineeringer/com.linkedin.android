package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.zza;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

final class zzt
  extends zzz
{
  static final Pair<String, Long> zzaXh = new Pair("", Long.valueOf(0L));
  private SharedPreferences zzTh;
  public final zzc zzaXi = new zzc("health_monitor", zzd.zzkX(), (byte)0);
  public final zzb zzaXj = new zzb("last_upload", 0L);
  public final zzb zzaXk = new zzb("last_upload_attempt", 0L);
  public final zzb zzaXl = new zzb("backoff", 0L);
  public final zzb zzaXm = new zzb("last_delete_stale", 0L);
  public final zzb zzaXn = new zzb("midnight_offset", 0L);
  private String zzaXo;
  private boolean zzaXp;
  private long zzaXq;
  private final SecureRandom zzaXr = new SecureRandom();
  public final zzb zzaXs = new zzb("time_before_start", 10000L);
  public final zzb zzaXt = new zzb("session_timeout", 1800000L);
  public final zza zzaXu = new zza("start_new_session");
  public final zzb zzaXv = new zzb("last_pause_time", 0L);
  public final zzb zzaXw = new zzb("time_active", 0L);
  public boolean zzaXx;
  
  zzt(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  final boolean zzAr()
  {
    zzjk();
    SharedPreferences localSharedPreferences = zzCO();
    if (!zza.zzAs()) {}
    for (boolean bool = true;; bool = false) {
      return localSharedPreferences.getBoolean("measurement_enabled", bool);
    }
  }
  
  final String zzCM()
  {
    byte[] arrayOfByte = new byte[16];
    zzaXr.nextBytes(arrayOfByte);
    return String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, arrayOfByte) });
  }
  
  final long zzCN()
  {
    zzjv();
    zzjk();
    long l2 = zzaXn.get();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = zzaXr.nextInt(86400000) + 1;
      zzaXn.set(l1);
    }
    return l1;
  }
  
  final SharedPreferences zzCO()
  {
    zzjk();
    zzjv();
    return zzTh;
  }
  
  final Boolean zzCP()
  {
    zzjk();
    if (!zzCO().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzCO().getBoolean("use_service", false));
  }
  
  final Pair<String, Boolean> zzfh(String paramString)
  {
    zzjk();
    long l = zzjl().elapsedRealtime();
    if ((zzaXo != null) && (l < zzaXq)) {
      return new Pair(zzaXo, Boolean.valueOf(zzaXp));
    }
    zzaXq = (l + zzCp().zza(paramString, zzl.zzaWb));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      paramString = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      zzaXo = paramString.getId();
      zzaXp = paramString.isLimitAdTrackingEnabled();
      AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
      return new Pair(zzaXo, Boolean.valueOf(zzaXp));
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        zzAozzaWJ.zzj("Unable to get advertising id", paramString);
        zzaXo = "";
      }
    }
  }
  
  final String zzfi(String paramString)
  {
    paramString = (String)zzfhfirst;
    MessageDigest localMessageDigest = zzaj.zzbv("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  protected final void zziJ()
  {
    zzTh = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    zzaXx = zzTh.getBoolean("has_been_opened", false);
    if (!zzaXx)
    {
      SharedPreferences.Editor localEditor = zzTh.edit();
      localEditor.putBoolean("has_been_opened", true);
      localEditor.apply();
    }
  }
  
  public final class zza
  {
    private final boolean zzaXy;
    private boolean zzaXz;
    private boolean zzagf;
    private final String zzvs;
    
    public zza(String paramString)
    {
      zzx.zzcM(paramString);
      zzvs = paramString;
      zzaXy = true;
    }
    
    public final boolean get()
    {
      if (!zzaXz)
      {
        zzaXz = true;
        zzagf = zzt.zza(zzt.this).getBoolean(zzvs, zzaXy);
      }
      return zzagf;
    }
    
    public final void set(boolean paramBoolean)
    {
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.putBoolean(zzvs, paramBoolean);
      localEditor.apply();
      zzagf = paramBoolean;
    }
  }
  
  public final class zzb
  {
    private long zzaDV;
    private final long zzaXB;
    private boolean zzaXz;
    private final String zzvs;
    
    public zzb(String paramString, long paramLong)
    {
      zzx.zzcM(paramString);
      zzvs = paramString;
      zzaXB = paramLong;
    }
    
    public final long get()
    {
      if (!zzaXz)
      {
        zzaXz = true;
        zzaDV = zzt.zza(zzt.this).getLong(zzvs, zzaXB);
      }
      return zzaDV;
    }
    
    public final void set(long paramLong)
    {
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.putLong(zzvs, paramLong);
      localEditor.apply();
      zzaDV = paramLong;
    }
  }
  
  public final class zzc
  {
    final long zzTl;
    final String zzaXC;
    final String zzaXD;
    final String zzaXE;
    
    private zzc(String paramString, long paramLong)
    {
      zzx.zzcM(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzac(bool);
        zzaXC = (paramString + ":start");
        zzaXD = (paramString + ":count");
        zzaXE = (paramString + ":value");
        zzTl = paramLong;
        return;
      }
    }
    
    public final void zzf(String paramString, long paramLong)
    {
      zzjk();
      if (zzlO() == 0L) {
        zzlL();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      long l = zzt.zza(zzt.this).getLong(zzaXD, 0L);
      if (l <= 0L)
      {
        paramString = zzt.zza(zzt.this).edit();
        paramString.putString(zzaXE, str);
        paramString.putLong(zzaXD, paramLong);
        paramString.apply();
        return;
      }
      if ((zzt.zzb(zzt.this).nextLong() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + paramLong) * paramLong) {}
      for (int i = 1;; i = 0)
      {
        paramString = zzt.zza(zzt.this).edit();
        if (i != 0) {
          paramString.putString(zzaXE, str);
        }
        paramString.putLong(zzaXD, l + paramLong);
        paramString.apply();
        return;
      }
    }
    
    final void zzlL()
    {
      zzjk();
      long l = zzjl().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzt.zza(zzt.this).edit();
      localEditor.remove(zzaXD);
      localEditor.remove(zzaXE);
      localEditor.putLong(zzaXC, l);
      localEditor.apply();
    }
    
    final long zzlO()
    {
      return zzt.zzc(zzt.this).getLong(zzaXC, 0L);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */