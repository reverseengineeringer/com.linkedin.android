package com.linkedin.android.liauthlib.sso;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

final class IAuthService$Stub$Proxy
  implements IAuthService
{
  private IBinder mRemote;
  
  IAuthService$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return mRemote;
  }
  
  public final Map getEmailAndPhoneSignedInUserWithProfileData(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.liauthlib.sso.IAuthService");
      localParcel1.writeString(paramString);
      mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readHashMap(getClass().getClassLoader());
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final android.graphics.Bitmap getProfilePicForUser(String paramString)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 34
    //   11: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 41	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 19	com/linkedin/android/liauthlib/sso/IAuthService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   23: iconst_5
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 47 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 50	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 74	android/os/Parcel:readInt	()I
    //   41: ifeq +26 -> 67
    //   44: getstatic 80	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
    //   47: aload_3
    //   48: invokeinterface 86 2 0
    //   53: checkcast 76	android/graphics/Bitmap
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 67	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 67	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 67	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: invokevirtual 67	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	Proxy
    //   0	83	1	paramString	String
    //   3	75	2	localParcel1	Parcel
    //   7	67	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	57	72	finally
  }
  
  public final Map getSignedInUser(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.liauthlib.sso.IAuthService");
      localParcel1.writeString(paramString);
      mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readHashMap(getClass().getClassLoader());
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final Map getSignedInUserWithProfileData(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.liauthlib.sso.IAuthService");
      localParcel1.writeString(paramString);
      mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readHashMap(getClass().getClassLoader());
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final List getTokensForUser(String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.liauthlib.sso.IAuthService");
      localParcel1.writeString(paramString);
      mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readArrayList(getClass().getClassLoader());
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void signout()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.linkedin.android.liauthlib.sso.IAuthService");
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.sso.IAuthService.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */