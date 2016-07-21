package com.linkedin.android.developer;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class IOAuthServiceResultCallback$Stub$Proxy
  implements IOAuthServiceResultCallback
{
  private IBinder mRemote;
  
  IOAuthServiceResultCallback$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return mRemote;
  }
  
  public final void onError(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.developer.IOAuthServiceResultCallback");
      localParcel1.writeString(paramString);
      mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void onSuccess(android.os.Bundle paramBundle)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 34
    //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +53 -> 68
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 65	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 19	com/linkedin/android/developer/IOAuthServiceResultCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   33: iconst_1
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 46 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 49	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 69	android/os/Parcel:readInt	()I
    //   51: ifeq +8 -> 59
    //   54: aload_1
    //   55: aload_3
    //   56: invokevirtual 73	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   59: aload_3
    //   60: invokevirtual 52	android/os/Parcel:recycle	()V
    //   63: aload_2
    //   64: invokevirtual 52	android/os/Parcel:recycle	()V
    //   67: return
    //   68: aload_2
    //   69: iconst_0
    //   70: invokevirtual 59	android/os/Parcel:writeInt	(I)V
    //   73: goto -44 -> 29
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 52	android/os/Parcel:recycle	()V
    //   81: aload_2
    //   82: invokevirtual 52	android/os/Parcel:recycle	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	Proxy
    //   0	87	1	paramBundle	android.os.Bundle
    //   3	79	2	localParcel1	Parcel
    //   7	71	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	76	finally
    //   18	29	76	finally
    //   29	59	76	finally
    //   68	73	76	finally
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.IOAuthServiceResultCallback.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */