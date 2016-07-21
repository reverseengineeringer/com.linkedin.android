package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class zzex$zza$zza
  implements zzex
{
  private IBinder zzoz;
  
  zzex$zza$zza(IBinder paramIBinder)
  {
    zzoz = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return zzoz;
  }
  
  public final zzey zzaf(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      localParcel1.writeString(paramString);
      zzoz.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = zzey.zza.zzF(localParcel2.readStrongBinder());
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean zzag(String paramString)
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      localParcel1.writeString(paramString);
      zzoz.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzex.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */