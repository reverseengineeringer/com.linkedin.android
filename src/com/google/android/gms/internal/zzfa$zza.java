package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzfa$zza
  extends Binder
  implements zzfa
{
  public zzfa$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    paramInt1 = zzeD();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
  
  private static final class zza
    implements zzfa
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
    
    public final int zzeD()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
        zzoz.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfa.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */