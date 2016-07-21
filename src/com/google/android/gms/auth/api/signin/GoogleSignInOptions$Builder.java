package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

public final class GoogleSignInOptions$Builder
{
  public Account zzTI;
  public boolean zzXa;
  private boolean zzXb;
  private boolean zzXc;
  public String zzXd;
  private String zzXe;
  public Set<Scope> zzXf = new HashSet();
  
  public GoogleSignInOptions$Builder() {}
  
  public GoogleSignInOptions$Builder(GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzx.zzz(paramGoogleSignInOptions);
    zzXf = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
    zzXb = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
    zzXc = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
    zzXa = GoogleSignInOptions.zze(paramGoogleSignInOptions);
    zzXd = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
    zzTI = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
    zzXe = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
  }
  
  public final GoogleSignInOptions build()
  {
    if ((zzXa) && ((zzTI == null) || (!zzXf.isEmpty()))) {
      requestId();
    }
    return new GoogleSignInOptions(zzXf, zzTI, zzXa, zzXb, zzXc, zzXd, zzXe, (byte)0);
  }
  
  public final Builder requestId()
  {
    zzXf.add(GoogleSignInOptions.zzWY);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */