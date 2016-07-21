package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzb;
import java.util.Map;

@zzhb
public final class zzds
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    zzr.zzbR();
    if (paramMap.containsKey("abort"))
    {
      if (!zzdq.zzd(paramzzjp)) {
        zzin.zzaK("Precache abort but no preload task running.");
      }
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      zzin.zzaK("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      Integer.parseInt((String)paramMap.get("player"));
      if (paramMap.containsKey("mimetype")) {
        paramMap.get("mimetype");
      }
      if (zzdq.zzf(paramzzjp) != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        zzin.zzaK("Precache task already running.");
        return;
      }
      zzb.zzv(paramzzjp.zzhR());
      new zzdp(paramzzjp, zzhRzzpw.zza$1e3f7598(), str).zzhn();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */