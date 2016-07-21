package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;

public final class zzl
  extends zzf.zza
{
  private final Context mContext;
  
  public zzl(Context paramContext)
  {
    mContext = paramContext;
  }
  
  /* Error */
  public final void zznf()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/google/android/gms/auth/api/signin/internal/zzl:mContext	Landroid/content/Context;
    //   4: invokestatic 21	android/os/Binder:getCallingUid	()I
    //   7: invokestatic 27	com/google/android/gms/common/GooglePlayServicesUtil:zzf	(Landroid/content/Context;I)Z
    //   10: ifne +34 -> 44
    //   13: new 29	java/lang/SecurityException
    //   16: dup
    //   17: new 31	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 33
    //   23: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: invokestatic 21	android/os/Binder:getCallingUid	()I
    //   29: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 42
    //   34: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 50	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload_0
    //   45: getfield 13	com/google/android/gms/auth/api/signin/internal/zzl:mContext	Landroid/content/Context;
    //   48: invokestatic 56	com/google/android/gms/auth/api/signin/internal/zzq:zzaf	(Landroid/content/Context;)Lcom/google/android/gms/auth/api/signin/internal/zzq;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 60	com/google/android/gms/auth/api/signin/internal/zzq:zzno	()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   56: astore_2
    //   57: getstatic 66	com/google/android/gms/auth/api/signin/GoogleSignInOptions:DEFAULT_SIGN_IN	Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +8 -> 70
    //   65: aload_3
    //   66: invokevirtual 70	com/google/android/gms/auth/api/signin/internal/zzq:zznp	()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   69: astore_1
    //   70: new 72	com/google/android/gms/common/api/GoogleApiClient$Builder
    //   73: dup
    //   74: aload_0
    //   75: getfield 13	com/google/android/gms/auth/api/signin/internal/zzl:mContext	Landroid/content/Context;
    //   78: invokespecial 74	com/google/android/gms/common/api/GoogleApiClient$Builder:<init>	(Landroid/content/Context;)V
    //   81: getstatic 80	com/google/android/gms/auth/api/Auth:GOOGLE_SIGN_IN_API	Lcom/google/android/gms/common/api/Api;
    //   84: aload_1
    //   85: invokevirtual 84	com/google/android/gms/common/api/GoogleApiClient$Builder:addApi	(Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/Api$ApiOptions$HasOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    //   88: invokevirtual 88	com/google/android/gms/common/api/GoogleApiClient$Builder:build	()Lcom/google/android/gms/common/api/GoogleApiClient;
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 94	com/google/android/gms/common/api/GoogleApiClient:blockingConnect	()Lcom/google/android/gms/common/ConnectionResult;
    //   96: invokevirtual 100	com/google/android/gms/common/ConnectionResult:isSuccess	()Z
    //   99: ifeq +17 -> 116
    //   102: aload_2
    //   103: ifnull +18 -> 121
    //   106: getstatic 104	com/google/android/gms/auth/api/Auth:GoogleSignInApi	Lcom/google/android/gms/auth/api/signin/GoogleSignInApi;
    //   109: aload_1
    //   110: invokeinterface 110 2 0
    //   115: pop
    //   116: aload_1
    //   117: invokevirtual 113	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   120: return
    //   121: aload_1
    //   122: invokevirtual 117	com/google/android/gms/common/api/GoogleApiClient:clearDefaultAccountAndReconnect	()Lcom/google/android/gms/common/api/PendingResult;
    //   125: pop
    //   126: goto -10 -> 116
    //   129: astore_2
    //   130: aload_1
    //   131: invokevirtual 113	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	zzl
    //   60	71	1	localObject1	Object
    //   56	47	2	localGoogleSignInAccount	com.google.android.gms.auth.api.signin.GoogleSignInAccount
    //   129	6	2	localObject2	Object
    //   51	15	3	localzzq	zzq
    // Exception table:
    //   from	to	target	type
    //   92	102	129	finally
    //   106	116	129	finally
    //   121	126	129	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */