package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzi
{
  public static void zza(SignInConfiguration paramSignInConfiguration, List<zzd> paramList, Map<zzd, List<String>> paramMap)
  {
    zzx.zzz(paramSignInConfiguration);
    zzx.zzz(paramList);
    zzx.zzz(paramMap);
    paramSignInConfiguration = zzXN;
    if (paramSignInConfiguration != null)
    {
      paramList.add(zzd.zzXh);
      paramList = new LinkedList();
      paramSignInConfiguration = paramSignInConfiguration.zzmN().iterator();
      while (paramSignInConfiguration.hasNext()) {
        paramList.add(nextzzagB);
      }
      paramMap.put(zzd.zzXh, paramList);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */