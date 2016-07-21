package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;

public final class zzrl
{
  public static final Api<zzro> API = new Api("SignIn.API", zzUJ, zzUI);
  public static final Api.zzc<zzh> zzUI = new Api.zzc();
  public static final Api.zza<zzh, zzro> zzUJ;
  public static final Scope zzWW;
  public static final Scope zzWX;
  public static final Api<zza> zzaoG = new Api("SignIn.INTERNAL_API", zzbgS, zzavN);
  public static final Api.zzc<zzh> zzavN = new Api.zzc();
  static final Api.zza<zzh, zza> zzbgS;
  public static final zzrm zzbgT = new zzg();
  
  static
  {
    zzUJ = new Api.zza() {};
    zzbgS = new Api.zza() {};
    zzWW = new Scope("profile");
    zzWX = new Scope("email");
  }
  
  public static final class zza
    implements Api.ApiOptions.HasOptions
  {
    final Bundle zzbgU;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */