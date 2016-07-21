package com.linkedin.android.deeplink;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class IDeferredDeeplinkingService$Stub$Proxy
  implements IDeferredDeeplinkingService
{
  private IBinder mRemote;
  
  IDeferredDeeplinkingService$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return mRemote;
  }
  
  public final void clearDeferredDeeplink(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
      localParcel1.writeString(paramString);
      mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final String getDeferredDeeplink(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
      localParcel1.writeString(paramString);
      mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final long getDeferredDeeplinkTimestamp(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
      localParcel1.writeString(paramString);
      mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      long l = localParcel2.readLong();
      return l;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.IDeferredDeeplinkingService.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */