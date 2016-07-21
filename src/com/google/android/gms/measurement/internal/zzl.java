package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlz;

public final class zzl
{
  public static zza<Boolean> zzaVY = zza.zzm$2f5d3f0e("measurement.service_enabled");
  public static zza<Boolean> zzaVZ = zza.zzm$2f5d3f0e("measurement.service_client_enabled");
  public static zza<String> zzaWa = zza.zzl("measurement.log_tag", "GMPM", "GMPM-SVC");
  public static zza<Long> zzaWb = zza.zze("measurement.ad_id_cache_time", 10000L);
  public static zza<Long> zzaWc = zza.zze("measurement.monitoring.sample_period_millis", 86400000L);
  public static zza<Long> zzaWd = zza.zze("measurement.config.cache_time", 86400000L);
  public static zza<String> zzaWe = zza.zzl("measurement.config.url_scheme", "https", "https");
  public static zza<String> zzaWf = zza.zzl("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
  public static zza<Integer> zzaWg = zza.zzD("measurement.upload.max_bundles", 100);
  public static zza<Integer> zzaWh = zza.zzD("measurement.upload.max_batch_size", 65536);
  public static zza<Integer> zzaWi = zza.zzD("measurement.upload.max_bundle_size", 65536);
  public static zza<Integer> zzaWj = zza.zzD("measurement.upload.max_events_per_bundle", 1000);
  public static zza<Integer> zzaWk = zza.zzD("measurement.upload.max_events_per_day", 100000);
  public static zza<Integer> zzaWl = zza.zzD("measurement.upload.max_public_events_per_day", 50000);
  public static zza<Integer> zzaWm = zza.zzD("measurement.upload.max_conversions_per_day", 500);
  public static zza<Integer> zzaWn = zza.zzD("measurement.store.max_stored_events_per_app", 100000);
  public static zza<String> zzaWo = zza.zzl("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
  public static zza<Long> zzaWp = zza.zze("measurement.upload.backoff_period", 43200000L);
  public static zza<Long> zzaWq = zza.zze("measurement.upload.window_interval", 3600000L);
  public static zza<Long> zzaWr = zza.zze("measurement.upload.interval", 3600000L);
  public static zza<Long> zzaWs = zza.zze("measurement.upload.stale_data_deletion_interval", 86400000L);
  public static zza<Long> zzaWt = zza.zze("measurement.upload.initial_upload_delay_time", 15000L);
  public static zza<Long> zzaWu = zza.zze("measurement.upload.retry_time", 1800000L);
  public static zza<Integer> zzaWv = zza.zzD("measurement.upload.retry_count", 6);
  public static zza<Long> zzaWw = zza.zze("measurement.upload.max_queue_time", 2419200000L);
  public static zza<Integer> zzaWx = zza.zzD("measurement.lifetimevalue.max_currency_tracked", 4);
  public static zza<Long> zzaWy = zza.zze("measurement.service_client.idle_disconnect_millis", 5000L);
  
  public static final class zza<V>
  {
    private final V zzSA;
    private final zzlz<V> zzSB;
    private V zzSC;
    final String zzvs;
    
    private zza(String paramString, zzlz<V> paramzzlz, V paramV)
    {
      zzx.zzz(paramzzlz);
      zzSB = paramzzlz;
      zzSA = paramV;
      zzvs = paramString;
    }
    
    static zza<Integer> zzD(String paramString, int paramInt)
    {
      return new zza(paramString, zzlz.zza(paramString, Integer.valueOf(paramInt)), Integer.valueOf(paramInt));
    }
    
    static zza<Long> zze(String paramString, long paramLong)
    {
      return new zza(paramString, zzlz.zza(paramString, Long.valueOf(paramLong)), Long.valueOf(paramLong));
    }
    
    static zza<String> zzl(String paramString1, String paramString2, String paramString3)
    {
      return new zza(paramString1, zzlz.zzv(paramString1, paramString3), paramString2);
    }
    
    static zza<Boolean> zzm$2f5d3f0e(String paramString)
    {
      return new zza(paramString, zzlz.zzk$15457046(paramString), Boolean.valueOf(true));
    }
    
    public final V get()
    {
      if (zzSC != null) {
        return (V)zzSC;
      }
      if ((zzd.zzakE) && (zzlz.isInitialized())) {
        return (V)zzSB.zzpX();
      }
      return (V)zzSA;
    }
    
    public final V get(V paramV)
    {
      Object localObject;
      if (zzSC != null) {
        localObject = zzSC;
      }
      do
      {
        return (V)localObject;
        localObject = paramV;
      } while (paramV != null);
      if ((zzd.zzakE) && (zzlz.isInitialized())) {
        return (V)zzSB.zzpX();
      }
      return (V)zzSA;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */