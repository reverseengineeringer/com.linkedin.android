package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzgd$zza
  extends Binder
  implements zzgd
{
  public zzgd$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
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
      paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
    paramParcel1 = paramParcel1.readStrongBinder();
    if (paramParcel1 == null) {
      paramParcel1 = null;
    }
    for (;;)
    {
      zza(paramParcel1);
      paramParcel2.writeNoException();
      return true;
      IInterface localIInterface = paramParcel1.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
      if ((localIInterface != null) && ((localIInterface instanceof zzgc))) {
        paramParcel1 = (zzgc)localIInterface;
      } else {
        paramParcel1 = new zzgc.zza.zza(paramParcel1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */