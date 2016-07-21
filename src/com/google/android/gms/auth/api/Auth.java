package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.consent.zza;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;

public final class Auth
{
  public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi;
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  public static final GoogleSignInApi GoogleSignInApi = new zzc();
  public static final Api<zza> PROXY_API;
  public static final ProxyApi ProxyApi;
  private static final Api.zza<com.google.android.gms.auth.api.credentials.internal.zzf, AuthCredentialsOptions> zzVA;
  private static final Api.zza<zzks, Object> zzVB;
  private static final Api.zza<zzkw, Object> zzVC;
  private static final Api.zza<zzo, zzg> zzVD;
  private static final Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> zzVE;
  public static final Api<zzg> zzVF;
  public static final Api<Object> zzVG;
  public static final Api<Object> zzVH;
  public static final zzkq zzVI;
  public static final com.google.android.gms.auth.api.signin.zzf zzVJ;
  public static final zza zzVK = new zzkv();
  public static final Api.zzc<zzkz> zzVt = new Api.zzc();
  public static final Api.zzc<com.google.android.gms.auth.api.credentials.internal.zzf> zzVu = new Api.zzc();
  public static final Api.zzc<zzks> zzVv = new Api.zzc();
  public static final Api.zzc<zzo> zzVw = new Api.zzc();
  public static final Api.zzc<com.google.android.gms.auth.api.signin.internal.zzd> zzVx = new Api.zzc();
  public static final Api.zzc<zzkw> zzVy = new Api.zzc();
  private static final Api.zza<zzkz, zza> zzVz = new Api.zza() {};
  
  static
  {
    zzVA = new Api.zza() {};
    zzVB = new Api.zza() {};
    zzVC = new Api.zza() {};
    zzVD = new Api.zza() {};
    zzVE = new Api.zza() {};
    PROXY_API = new Api("Auth.PROXY_API", zzVz, zzVt);
    CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzVA, zzVu);
    zzVF = new Api("Auth.SIGN_IN_API", zzVD, zzVw);
    GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
    zzVG = new Api("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
    zzVH = new Api("Auth.CONSENT_API", zzVC, zzVy);
    ProxyApi = new zzld();
    CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
    zzVI = new zzkr();
    zzVJ = new zzn();
  }
  
  public static final class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    public final String zzVL;
    public final PasswordSpecification zzVM;
  }
  
  public static final class zza
    implements Api.ApiOptions.Optional
  {
    public final Bundle zzVN;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */