package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.SignInAccount;

final class zzh$zza$zza
  implements zzh
{
  private IBinder zzoz;
  
  zzh$zza$zza(IBinder paramIBinder)
  {
    zzoz = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return zzoz;
  }
  
  /* Error */
  public final void zza(zzg paramzzg, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzh$zza$zza:zzoz	Landroid/os/IBinder;
    //   50: bipush 101
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 59 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 62	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 65	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 65	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 65	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzg	zzg
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	Parcel
    //   7	85	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
  
  /* Error */
  public final void zza(zzg paramzzg, SignInConfiguration paramSignInConfiguration)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +60 -> 76
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 70	com/google/android/gms/auth/api/signin/internal/SignInConfiguration:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzh$zza$zza:zzoz	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 59 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 62	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 65	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 65	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 65	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzg	zzg
    //   0	101	2	paramSignInConfiguration	SignInConfiguration
    //   3	93	3	localParcel1	Parcel
    //   7	84	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	89	finally
    //   19	26	89	finally
    //   26	31	89	finally
    //   35	46	89	finally
    //   46	66	89	finally
    //   81	86	89	finally
  }
  
  public final void zza(zzg paramzzg, SignInConfiguration paramSignInConfiguration, SignInAccount paramSignInAccount, String paramString)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label134:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (paramzzg != null)
        {
          paramzzg = paramzzg.asBinder();
          localParcel1.writeStrongBinder(paramzzg);
          if (paramSignInConfiguration != null)
          {
            localParcel1.writeInt(1);
            paramSignInConfiguration.writeToParcel(localParcel1, 0);
            if (paramSignInAccount == null) {
              break label134;
            }
            localParcel1.writeInt(1);
            paramSignInAccount.writeToParcel(localParcel1, 0);
            localParcel1.writeString(paramString);
            zzoz.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          paramzzg = null;
          continue;
        }
        localParcel1.writeInt(0);
        continue;
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
  public final void zzb(zzg paramzzg, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzh$zza$zza:zzoz	Landroid/os/IBinder;
    //   50: bipush 102
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 59 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 62	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 65	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 65	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 65	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzg	zzg
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	Parcel
    //   7	85	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
  
  /* Error */
  public final void zzb(zzg paramzzg, SignInConfiguration paramSignInConfiguration)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +60 -> 76
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 70	com/google/android/gms/auth/api/signin/internal/SignInConfiguration:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzh$zza$zza:zzoz	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 59 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 62	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 65	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 65	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 65	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzg	zzg
    //   0	101	2	paramSignInConfiguration	SignInConfiguration
    //   3	93	3	localParcel1	Parcel
    //   7	84	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	89	finally
    //   19	26	89	finally
    //   26	31	89	finally
    //   35	46	89	finally
    //   46	66	89	finally
    //   81	86	89	finally
  }
  
  /* Error */
  public final void zzc(zzg paramzzg, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzh$zza$zza:zzoz	Landroid/os/IBinder;
    //   50: bipush 103
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 59 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 62	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 65	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 65	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 65	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzg	zzg
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	Parcel
    //   7	85	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzh.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */