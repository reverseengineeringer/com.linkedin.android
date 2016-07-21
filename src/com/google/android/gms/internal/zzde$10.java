package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

final class zzde$10
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("u");
    if (paramMap == null)
    {
      zzin.zzaK("URL missing from httpTrack GMSG.");
      return;
    }
    new zziy(paramzzjp.getContext(), zzhXafmaVersion, paramMap).zzhn();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */