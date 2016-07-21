package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzj;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzkz
  extends zzj<zzlb>
{
  private final Bundle zzVN;
  
  public zzkz(Context paramContext, Looper paramLooper, zzf paramzzf, Auth.zza paramzza, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 16, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramzza == null) {}
    for (paramContext = new Bundle();; paramContext = new Bundle(zzVN))
    {
      zzVN = paramContext;
      return;
    }
  }
  
  protected final String zzgu()
  {
    return "com.google.android.gms.auth.service.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.auth.api.internal.IAuthService";
  }
  
  public final boolean zzmE()
  {
    zzf localzzf = zzahz;
    Object localObject;
    zzf.zza localzza;
    if (zzTI != null)
    {
      localObject = zzTI.name;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label108;
      }
      localObject = Auth.PROXY_API;
      localzza = (zzf.zza)zzalc.get(localObject);
      if ((localzza != null) && (!zzXf.isEmpty())) {
        break label82;
      }
      localObject = zzagh;
    }
    for (;;)
    {
      if (((Set)localObject).isEmpty()) {
        break label108;
      }
      return true;
      localObject = null;
      break;
      label82:
      localObject = new HashSet(zzagh);
      ((Set)localObject).addAll(zzXf);
    }
    label108:
    return false;
  }
  
  protected final Bundle zzml()
  {
    return zzVN;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */