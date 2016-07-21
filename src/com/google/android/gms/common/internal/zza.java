package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.zze;

public final class zza
  extends zzp.zza
{
  private Context mContext;
  private Account zzTI;
  int zzakz;
  
  public static Account zza(zzp paramzzp)
  {
    Account localAccount = null;
    long l;
    if (paramzzp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramzzp.getAccount();
      return localAccount;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    return zzTI.equals(zzTI);
  }
  
  public final Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == zzakz) {
      return zzTI;
    }
    if (zze.zzf(mContext, i))
    {
      zzakz = i;
      return zzTI;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */