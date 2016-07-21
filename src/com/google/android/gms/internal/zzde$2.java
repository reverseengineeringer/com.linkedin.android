package com.google.android.gms.internal;

import java.util.Map;

final class zzde$2
  implements zzdf
{
  public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("tx");
    String str2 = (String)paramMap.get("ty");
    paramMap = (String)paramMap.get("td");
    try
    {
      Integer.parseInt(str1);
      Integer.parseInt(str2);
      Integer.parseInt(paramMap);
      paramzzjp = paramzzjp.zzhW();
      if (paramzzjp != null) {
        paramzzjp = zzow;
      }
      return;
    }
    catch (NumberFormatException paramzzjp)
    {
      zzin.zzaK("Could not parse touch parameters from gmsg.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */