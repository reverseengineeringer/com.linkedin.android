package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzk
{
  final Map<zzd, zzlf> zzXD;
  
  public zzk(Activity paramActivity, List<zzd> paramList, Map<zzd, List<String>> paramMap)
  {
    zzx.zzz(paramActivity);
    zzx.zzz(paramList);
    zzx.zzz(paramMap);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    label125:
    while (localIterator.hasNext())
    {
      zzd localzzd = (zzd)localIterator.next();
      List localList = (List)paramMap.get(localzzd);
      paramList = localList;
      if (localList == null) {
        paramList = Collections.emptyList();
      }
      if (zzd.zzXi.equals(localzzd)) {}
      for (paramList = new zzlh(paramActivity, paramList);; paramList = null)
      {
        if (paramList == null) {
          break label125;
        }
        localHashMap.put(localzzd, paramList);
        break;
      }
    }
    zzXD = Collections.unmodifiableMap(localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */