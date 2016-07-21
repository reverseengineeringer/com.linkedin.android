package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import java.util.Map;

final class zzde$7
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    paramMap = paramzzjp.zzhS();
    if (paramMap != null)
    {
      paramMap.close();
      return;
    }
    paramzzjp = paramzzjp.zzhT();
    if (paramzzjp != null)
    {
      paramzzjp.close();
      return;
    }
    zzin.zzaK("A GMSG tried to close something that wasn't an overlay.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */