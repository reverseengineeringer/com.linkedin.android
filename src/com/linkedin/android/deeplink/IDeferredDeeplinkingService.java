package com.linkedin.android.deeplink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IDeferredDeeplinkingService
  extends IInterface
{
  public abstract void clearDeferredDeeplink(String paramString)
    throws RemoteException;
  
  public abstract String getDeferredDeeplink(String paramString)
    throws RemoteException;
  
  public abstract long getDeferredDeeplinkTimestamp(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IDeferredDeeplinkingService
  {
    public Stub()
    {
      attachInterface(this, "com.linkedin.android.deeplink.IDeferredDeeplinkingService");
    }
    
    public static IDeferredDeeplinkingService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
      if ((localIInterface != null) && ((localIInterface instanceof IDeferredDeeplinkingService))) {
        return (IDeferredDeeplinkingService)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
        long l = getDeferredDeeplinkTimestamp(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
        paramParcel1 = getDeferredDeeplink(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.linkedin.android.deeplink.IDeferredDeeplinkingService");
      clearDeferredDeeplink(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static final class Proxy
      implements IDeferredDeeplinkingService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.IDeferredDeeplinkingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */