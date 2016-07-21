package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

public class zzd
{
  public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
  public static final String KEY_CALLER_UID;
  static final ComponentName zzVe = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  private static final ComponentName zzVf = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    KEY_CALLER_UID = "callerUid";
    i = Build.VERSION.SDK_INT;
  }
  
  /* Error */
  static <T> T zza(android.content.Context paramContext, ComponentName paramComponentName, zza<T> paramzza)
    throws IOException, GoogleAuthException
  {
    // Byte code:
    //   0: new 61	com/google/android/gms/common/zza
    //   3: dup
    //   4: invokespecial 62	com/google/android/gms/common/zza:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 68	com/google/android/gms/common/internal/zzl:zzau	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: aload_3
    //   18: ldc 70
    //   20: invokevirtual 73	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   23: ifeq +54 -> 77
    //   26: aload_2
    //   27: aload_3
    //   28: invokevirtual 77	com/google/android/gms/common/zza:zzoJ	()Landroid/os/IBinder;
    //   31: invokeinterface 81 2 0
    //   36: astore_0
    //   37: aload 4
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 85	com/google/android/gms/common/internal/zzl:zzb$9b3168c	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: ldc 70
    //   49: ldc 87
    //   51: aload_0
    //   52: invokestatic 93	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   55: pop
    //   56: new 53	java/io/IOException
    //   59: dup
    //   60: ldc 87
    //   62: aload_0
    //   63: invokespecial 96	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_0
    //   68: aload 4
    //   70: aload_1
    //   71: aload_3
    //   72: invokevirtual 85	com/google/android/gms/common/internal/zzl:zzb$9b3168c	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;)V
    //   75: aload_0
    //   76: athrow
    //   77: new 53	java/io/IOException
    //   80: dup
    //   81: ldc 98
    //   83: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore_0
    //   88: goto -41 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramContext	android.content.Context
    //   0	91	1	paramComponentName	ComponentName
    //   0	91	2	paramzza	zza<T>
    //   7	65	3	localzza	com.google.android.gms.common.zza
    //   12	57	4	localzzl	com.google.android.gms.common.internal.zzl
    // Exception table:
    //   from	to	target	type
    //   26	37	46	java/lang/InterruptedException
    //   26	37	67	finally
    //   47	67	67	finally
    //   26	37	87	android/os/RemoteException
  }
  
  private static abstract interface zza<T>
  {
    public abstract T zzan(IBinder paramIBinder)
      throws RemoteException, IOException, GoogleAuthException;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */