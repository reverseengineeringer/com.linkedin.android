package com.google.android.gms.internal;

import java.util.Map;

@zzhb
public final class zzfo
{
  final boolean zzDp;
  final String zzDq;
  final zzjp zzpD;
  
  public zzfo(zzjp paramzzjp, Map<String, String> paramMap)
  {
    zzpD = paramzzjp;
    zzDq = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      zzDp = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    zzDp = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */