package com.linkedin.android.developer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IOAuthService
  extends IInterface
{
  public abstract void getToken$628af682(String paramString1, String paramString2, String paramString3, IOAuthServiceResultCallback paramIOAuthServiceResultCallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOAuthService
  {
    public Stub()
    {
      attachInterface(this, "com.linkedin.android.developer.IOAuthService");
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
        paramParcel2.writeString("com.linkedin.android.developer.IOAuthService");
        return true;
      }
      paramParcel1.enforceInterface("com.linkedin.android.developer.IOAuthService");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      paramParcel1.readInt();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = null;
      }
      for (;;)
      {
        getToken$628af682(str1, str2, str3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = paramParcel1.queryLocalInterface("com.linkedin.android.developer.IOAuthServiceResultCallback");
        if ((localIInterface != null) && ((localIInterface instanceof IOAuthServiceResultCallback))) {
          paramParcel1 = (IOAuthServiceResultCallback)localIInterface;
        } else {
          paramParcel1 = new IOAuthServiceResultCallback.Stub.Proxy(paramParcel1);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.IOAuthService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */