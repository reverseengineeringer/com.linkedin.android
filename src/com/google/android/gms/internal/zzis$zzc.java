package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
public class zzis$zzc
  extends zzis.zzb
{
  public final String zza(SslError paramSslError)
  {
    return paramSslError.getUrl();
  }
  
  public final WebChromeClient zzk(zzjp paramzzjp)
  {
    return new zzjx(paramzzjp);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzis.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */