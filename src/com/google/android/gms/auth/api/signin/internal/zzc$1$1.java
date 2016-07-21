package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class zzc$1$1
  extends zza
{
  zzc$1$1(zzc.1 param1, zzq paramzzq) {}
  
  public final void zza(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException
  {
    if (paramGoogleSignInAccount != null) {
      zzXt.zzb(paramGoogleSignInAccount, zzXu.zzXr);
    }
    zzXu.zza(new GoogleSignInResult(paramGoogleSignInAccount, paramStatus));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzc.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */