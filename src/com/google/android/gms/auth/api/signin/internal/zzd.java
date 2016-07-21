package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.auth.api.signin.zzg.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public final class zzd
  extends zzj<zzh>
{
  final GoogleSignInOptions zzXx;
  
  public zzd(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions != null) {}
    for (;;)
    {
      paramContext = paramGoogleSignInOptions;
      if (zzalb.isEmpty()) {
        break label123;
      }
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      paramLooper = zzalb.iterator();
      while (paramLooper.hasNext())
      {
        paramzzf = (Scope)paramLooper.next();
        zzXf.add(paramzzf);
        zzXf.addAll(Arrays.asList(new Scope[0]));
      }
      paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
    }
    paramContext = paramContext.build();
    label123:
    zzXx = paramContext;
  }
  
  protected final String zzgu()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  protected final String zzgv()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
  
  public final boolean zznb()
  {
    return true;
  }
  
  public final Intent zznc()
  {
    Object localObject1 = new zzg.zza(mContext.getPackageName());
    Object localObject2 = zzXx;
    zzx.zzz(localObject2);
    zzXo.zzXN = ((GoogleSignInOptions)zzx.zzb(localObject2, "GoogleSignInOptions cannot be null."));
    if ((zzXo.zzXM != null) || (zzXo.zzXN != null)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Must support either Facebook, Google or Email sign-in.");
      localObject1 = zzgzzXo, (byte)0).zzXo;
      localObject2 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
      ((Intent)localObject2).setClass(mContext, SignInHubActivity.class);
      ((Intent)localObject2).putExtra("config", (Parcelable)localObject1);
      return (Intent)localObject2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */