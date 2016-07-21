package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.internal.zzx;

public final class zzg
  implements Api.ApiOptions.HasOptions
{
  public final SignInConfiguration zzXo;
  
  private zzg(SignInConfiguration paramSignInConfiguration)
  {
    zzXo = paramSignInConfiguration;
  }
  
  public static final class zza
  {
    public final SignInConfiguration zzXo;
    
    public zza(String paramString)
    {
      zzx.zzcM(paramString);
      zzXo = new SignInConfiguration(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */