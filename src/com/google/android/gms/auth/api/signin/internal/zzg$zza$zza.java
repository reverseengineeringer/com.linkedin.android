package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

final class zzg$zza$zza
  implements zzg
{
  private IBinder zzoz;
  
  zzg$zza$zza(IBinder paramIBinder)
  {
    zzoz = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return zzoz;
  }
  
  public final void zza(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        if (paramGoogleSignInAccount != null)
        {
          localParcel1.writeInt(1);
          paramGoogleSignInAccount.writeToParcel(localParcel1, 0);
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
            zzoz.transact(101, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void zza(Status paramStatus, SignInAccount paramSignInAccount)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        if (paramStatus != null)
        {
          localParcel1.writeInt(1);
          paramStatus.writeToParcel(localParcel1, 0);
          if (paramSignInAccount != null)
          {
            localParcel1.writeInt(1);
            paramSignInAccount.writeToParcel(localParcel1, 0);
            zzoz.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void zza(Status paramStatus, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 6
    //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 7
    //   10: aload 6
    //   12: ldc 32
    //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +67 -> 85
    //   21: aload 6
    //   23: iconst_1
    //   24: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   27: aload_1
    //   28: aload 6
    //   30: iconst_0
    //   31: invokevirtual 49	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 70	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload 6
    //   42: aload_3
    //   43: invokevirtual 70	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 6
    //   48: lload 4
    //   50: invokevirtual 74	android/os/Parcel:writeLong	(J)V
    //   53: aload_0
    //   54: getfield 18	com/google/android/gms/auth/api/signin/internal/zzg$zza$zza:zzoz	Landroid/os/IBinder;
    //   57: iconst_3
    //   58: aload 6
    //   60: aload 7
    //   62: iconst_0
    //   63: invokeinterface 55 5 0
    //   68: pop
    //   69: aload 7
    //   71: invokevirtual 58	android/os/Parcel:readException	()V
    //   74: aload 7
    //   76: invokevirtual 61	android/os/Parcel:recycle	()V
    //   79: aload 6
    //   81: invokevirtual 61	android/os/Parcel:recycle	()V
    //   84: return
    //   85: aload 6
    //   87: iconst_0
    //   88: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   91: goto -57 -> 34
    //   94: astore_1
    //   95: aload 7
    //   97: invokevirtual 61	android/os/Parcel:recycle	()V
    //   100: aload 6
    //   102: invokevirtual 61	android/os/Parcel:recycle	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	zza
    //   0	107	1	paramStatus	Status
    //   0	107	2	paramString1	String
    //   0	107	3	paramString2	String
    //   0	107	4	paramLong	long
    //   3	98	6	localParcel1	Parcel
    //   8	88	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	94	finally
    //   21	34	94	finally
    //   34	74	94	finally
    //   85	91	94	finally
  }
  
  /* Error */
  public final void zzk(Status paramStatus)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 32
    //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 49	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/auth/api/signin/internal/zzg$zza$zza:zzoz	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 55 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 58	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 61	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 61	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 61	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 61	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramStatus	Status
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public final void zzl(Status paramStatus)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 32
    //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 49	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/auth/api/signin/internal/zzg$zza$zza:zzoz	Landroid/os/IBinder;
    //   33: bipush 102
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 58	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 61	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 61	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 61	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 61	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zza
    //   0	76	1	paramStatus	Status
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public final void zzm(Status paramStatus)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 32
    //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 49	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/auth/api/signin/internal/zzg$zza$zza:zzoz	Landroid/os/IBinder;
    //   33: bipush 103
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 58	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 61	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 61	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 61	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 61	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zza
    //   0	76	1	paramStatus	Status
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */