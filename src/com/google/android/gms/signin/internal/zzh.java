package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzj.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;

public final class zzh
  extends zzj<zze>
  implements zzrn
{
  private final zzf zzahz;
  private Integer zzale;
  private final Bundle zzbgU;
  private final boolean zzbhi;
  
  public zzh(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, true, paramzzf, localBundle, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public zzh(Context paramContext, Looper paramLooper, boolean paramBoolean, zzf paramzzf, Bundle paramBundle, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 44, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzbhi = paramBoolean;
    zzahz = paramzzf;
    zzbgU = paramBundle;
    zzale = zzale;
  }
  
  public final void connect()
  {
    zza(new zzj.zzf(this));
  }
  
  public final void zzFG()
  {
    try
    {
      ((zze)zzqJ()).zzka(zzale.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public final void zza(zzp paramzzp, boolean paramBoolean)
  {
    try
    {
      ((zze)zzqJ()).zza(paramzzp, zzale.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public final void zza(zzd paramzzd)
  {
    zzx.zzb(paramzzd, "Expecting a valid ISignInCallbacks");
    try
    {
      Object localObject = zzahz;
      if (zzTI != null) {}
      for (localObject = zzTI;; localObject = new Account("<<default account>>", "com.google"))
      {
        GoogleSignInAccount localGoogleSignInAccount = null;
        if ("<<default account>>".equals(name)) {
          localGoogleSignInAccount = zzq.zzaf(mContext).zzno();
        }
        localObject = new ResolveAccountRequest((Account)localObject, zzale.intValue(), localGoogleSignInAccount);
        ((zze)zzqJ()).zza(new SignInRequest((ResolveAccountRequest)localObject), paramzzd);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramzzd.zzb(new SignInResponse());
        return;
      }
      catch (RemoteException paramzzd)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected final String zzgu()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public final boolean zzmE()
  {
    return zzbhi;
  }
  
  protected final Bundle zzml()
  {
    String str = zzahz.zzUW;
    if (!mContext.getPackageName().equals(str)) {
      zzbgU.putString("com.google.android.gms.signin.internal.realClientPackageName", zzahz.zzUW);
    }
    return zzbgU;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */