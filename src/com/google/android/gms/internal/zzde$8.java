package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzd;
import java.util.Map;
import org.json.JSONObject;

final class zzde$8
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    boolean bool1;
    if ("checkSupport".equals(paramMap.get("action")))
    {
      zzin.zzaJ("Received support message, responding.");
      boolean bool2 = false;
      paramMap = paramzzjp.zzhR();
      bool1 = bool2;
      if (paramMap != null)
      {
        paramMap = zzpy;
        bool1 = bool2;
        if (paramMap != null) {
          bool1 = paramMap.zzfM();
        }
      }
      paramMap = new JSONObject();
    }
    try
    {
      paramMap.put("event", "checkSupport");
      paramMap.put("supports", bool1);
      paramzzjp.zzb("appStreaming", paramMap);
      return;
    }
    catch (Throwable paramzzjp) {}
    paramzzjp.zzhS();
    return;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */