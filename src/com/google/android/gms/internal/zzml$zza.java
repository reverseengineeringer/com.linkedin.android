package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzml$zza
  extends Binder
  implements zzml
{
  public static zzml zzaY(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
    if ((localIInterface != null) && ((localIInterface instanceof zzml))) {
      return (zzml)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
    paramParcel1 = paramParcel1.readStrongBinder();
    if (paramParcel1 == null) {
      paramParcel1 = null;
    }
    for (;;)
    {
      zza(paramParcel1);
      return true;
      paramParcel2 = paramParcel1.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
      if ((paramParcel2 != null) && ((paramParcel2 instanceof zzmk))) {
        paramParcel1 = (zzmk)paramParcel2;
      } else {
        paramParcel1 = new zzmk.zza.zza(paramParcel1);
      }
    }
  }
  
  private static final class zza
    implements zzml
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzml.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */