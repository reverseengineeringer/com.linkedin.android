package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class GoogleSignInResult
  implements Result
{
  public Status zzUX;
  public GoogleSignInAccount zzXg;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    zzXg = paramGoogleSignInAccount;
    zzUX = paramStatus;
  }
  
  public final Status getStatus()
  {
    return zzUX;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */