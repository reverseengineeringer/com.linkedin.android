package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class zzku$zza
  extends Binder
  implements zzku
{
  public static zzku zzas(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
    if ((localIInterface != null) && ((localIInterface instanceof zzku))) {
      return (zzku)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    IInterface localIInterface = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
    Account localAccount;
    if (paramParcel1.readInt() != 0)
    {
      localAccount = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      paramInt1 = paramParcel1.readInt();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null) {
        break label114;
      }
      paramParcel1 = localIInterface;
    }
    for (;;)
    {
      zza(localAccount, paramInt1, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localAccount = null;
      break;
      label114:
      localIInterface = paramParcel1.queryLocalInterface("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzkt))) {
        paramParcel1 = (zzkt)localIInterface;
      } else {
        paramParcel1 = new zzkt.zza.zza(paramParcel1);
      }
    }
  }
  
  private static final class zza
    implements zzku
  {
    private IBinder zzoz;
    
    zza(IBinder paramIBinder)
    {
      zzoz = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return zzoz;
    }
    
    public final void zza(Account paramAccount, int paramInt, zzkt paramzzkt)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
          if (paramAccount != null)
          {
            localParcel1.writeInt(1);
            paramAccount.writeToParcel(localParcel1, 0);
            localParcel1.writeInt(paramInt);
            if (paramzzkt != null)
            {
              paramAccount = paramzzkt.asBinder();
              localParcel1.writeStrongBinder(paramAccount);
              zzoz.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramAccount = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzku.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */