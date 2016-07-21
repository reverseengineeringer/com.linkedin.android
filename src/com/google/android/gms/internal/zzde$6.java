package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

final class zzde$6
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    str = (String)paramMap.get("u");
    if (str == null)
    {
      zzin.zzaK("URL missing from click GMSG.");
      return;
    }
    paramMap = Uri.parse(str);
    try
    {
      Object localObject = paramzzjp.zzhW();
      if ((localObject == null) || (!((zzan)localObject).zzb(paramMap))) {
        break label118;
      }
      paramzzjp.getContext();
      localObject = ((zzan)localObject).zza$7d090533(paramMap);
      paramMap = (Map<String, String>)localObject;
    }
    catch (zzao localzzao)
    {
      for (;;)
      {
        zzin.zzaK("Unable to append parameter to URL: " + str);
      }
    }
    paramMap = paramMap.toString();
    new zziy(paramzzjp.getContext(), zzhXafmaVersion, paramMap).zzhn();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */