package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzro;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  public final Account zzTI;
  public final String zzUW;
  public final Set<Scope> zzagh;
  private final int zzagj;
  private final View zzagk;
  final String zzagl;
  public final Set<Scope> zzalb;
  public final Map<Api<?>, zza> zzalc;
  public final zzro zzald;
  public Integer zzale;
  
  public zzf(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzro paramzzro)
  {
    zzTI = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      zzagh = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      zzalc = paramAccount;
      zzagk = paramView;
      zzagj = paramInt;
      zzUW = paramString1;
      zzagl = paramString2;
      zzald = paramzzro;
      paramAccount = new HashSet(zzagh);
      paramSet = zzalc.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(nextzzXf);
      }
    }
    zzalb = Collections.unmodifiableSet(paramAccount);
  }
  
  public static final class zza
  {
    public final Set<Scope> zzXf;
    public final boolean zzalf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */