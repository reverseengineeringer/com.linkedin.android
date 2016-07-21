package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzlf.zza;

final class SignInHubActivity$1
  implements zzlf.zza
{
  SignInHubActivity$1(SignInHubActivity paramSignInHubActivity, String paramString) {}
  
  public final void zzk(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!TextUtils.isEmpty(zzXY)) {
        paramIntent.putExtra("scopes", zzXY);
      }
      SignInHubActivity.zza(zzXZ, paramIntent);
      return;
    }
    Log.w("AuthSignInClient", "Idp signin failed!");
    SignInHubActivity.zza$7bc45402(zzXZ);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */