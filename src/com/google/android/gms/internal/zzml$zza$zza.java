package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class zzml$zza$zza
  implements zzml
{
  private IBinder zzoz;
  
  zzml$zza$zza(IBinder paramIBinder)
  {
    zzoz = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return zzoz;
  }
  
  public final void zza(zzmk paramzzmk)
    throws RemoteException
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
      if (paramzzmk != null) {
        localIBinder = paramzzmk.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      zzoz.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzml.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */