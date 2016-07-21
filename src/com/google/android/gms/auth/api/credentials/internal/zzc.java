package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzc
  implements CredentialRequestResult
{
  private final Status zzUX;
  private final Credential zzWu;
  
  public zzc(Status paramStatus, Credential paramCredential)
  {
    zzUX = paramStatus;
    zzWu = paramCredential;
  }
  
  public static zzc zzh(Status paramStatus)
  {
    return new zzc(paramStatus, null);
  }
  
  public final Credential getCredential()
  {
    return zzWu;
  }
  
  public final Status getStatus()
  {
    return zzUX;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */