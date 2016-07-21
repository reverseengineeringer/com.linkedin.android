package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzx
  extends IInterface
{
  public abstract long getValue()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzx
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
      long l = getValue();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */