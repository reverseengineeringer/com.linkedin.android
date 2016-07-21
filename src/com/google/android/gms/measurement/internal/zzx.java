package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzx
  extends zzm.zza
{
  private final zzw zzaTV;
  private final boolean zzaYw;
  
  public zzx(zzw paramzzw)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramzzw);
    zzaTV = paramzzw;
    zzaYw = false;
  }
  
  public zzx(zzw paramzzw, byte paramByte)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramzzw);
    zzaTV = paramzzw;
    zzaYw = true;
  }
  
  private void zzfm(String paramString)
    throws SecurityException
  {
    if (TextUtils.isEmpty(paramString))
    {
      zzaTV.zzAo().zzaWC.zzfg("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
    }
    for (;;)
    {
      try
      {
        if (zzaYw)
        {
          i = Process.myUid();
          if ((com.google.android.gms.common.zze.zzb(zzaTV.mContext, i, paramString)) || (com.google.android.gms.common.zze.zzf(zzaTV.mContext, i))) {
            break;
          }
          throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
        }
      }
      catch (SecurityException localSecurityException)
      {
        zzaTV.zzAo().zzaWC.zzj("Measurement Service called with invalid calling package", paramString);
        throw localSecurityException;
      }
      int i = Binder.getCallingUid();
    }
  }
  
  /* Error */
  public final List<UserAttributeParcel> zza(final AppMetadata paramAppMetadata, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: aload_1
    //   7: getfield 125	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   10: invokespecial 127	com/google/android/gms/measurement/internal/zzx:zzfm	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 35	com/google/android/gms/measurement/internal/zzx:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   17: invokevirtual 131	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   20: new 16	com/google/android/gms/measurement/internal/zzx$6
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 134	com/google/android/gms/measurement/internal/zzx$6:<init>	(Lcom/google/android/gms/measurement/internal/zzx;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   29: invokevirtual 140	com/google/android/gms/measurement/internal/zzv:zzd	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 146 1 0
    //   39: checkcast 148	java/util/List
    //   42: astore_3
    //   43: new 150	java/util/ArrayList
    //   46: dup
    //   47: aload_3
    //   48: invokeinterface 153 1 0
    //   53: invokespecial 156	java/util/ArrayList:<init>	(I)V
    //   56: astore_1
    //   57: aload_3
    //   58: invokeinterface 160 1 0
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 166 1 0
    //   70: ifeq +67 -> 137
    //   73: aload_3
    //   74: invokeinterface 169 1 0
    //   79: checkcast 171	com/google/android/gms/measurement/internal/zzai
    //   82: astore 4
    //   84: iload_2
    //   85: ifne +14 -> 99
    //   88: aload 4
    //   90: getfield 174	com/google/android/gms/measurement/internal/zzai:mName	Ljava/lang/String;
    //   93: invokestatic 180	com/google/android/gms/measurement/internal/zzaj:zzfv	(Ljava/lang/String;)Z
    //   96: ifne -32 -> 64
    //   99: aload_1
    //   100: new 182	com/google/android/gms/measurement/internal/UserAttributeParcel
    //   103: dup
    //   104: aload 4
    //   106: invokespecial 185	com/google/android/gms/measurement/internal/UserAttributeParcel:<init>	(Lcom/google/android/gms/measurement/internal/zzai;)V
    //   109: invokeinterface 189 2 0
    //   114: pop
    //   115: goto -51 -> 64
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 35	com/google/android/gms/measurement/internal/zzx:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   123: invokevirtual 57	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   126: getfield 63	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   129: ldc -65
    //   131: aload_1
    //   132: invokevirtual 108	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   135: aconst_null
    //   136: areturn
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: goto -21 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	zzx
    //   0	143	1	paramAppMetadata	AppMetadata
    //   0	143	2	paramBoolean	boolean
    //   42	32	3	localObject	Object
    //   82	23	4	localzzai	zzai
    // Exception table:
    //   from	to	target	type
    //   33	64	118	java/lang/InterruptedException
    //   64	84	118	java/lang/InterruptedException
    //   88	99	118	java/lang/InterruptedException
    //   99	115	118	java/lang/InterruptedException
    //   33	64	139	java/util/concurrent/ExecutionException
    //   64	84	139	java/util/concurrent/ExecutionException
    //   88	99	139	java/util/concurrent/ExecutionException
    //   99	115	139	java/util/concurrent/ExecutionException
  }
  
  public final void zza(final AppMetadata paramAppMetadata)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramAppMetadata);
    zzfm(packageName);
    zzaTV.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzfl(paramAppMetadatazzaVx);
        zzx.zza(zzx.this).zzd(paramAppMetadata);
      }
    });
  }
  
  public final void zza(final EventParcel paramEventParcel, final AppMetadata paramAppMetadata)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramEventParcel);
    com.google.android.gms.common.internal.zzx.zzz(paramAppMetadata);
    zzfm(packageName);
    zzaTV.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzfl(paramAppMetadatazzaVx);
        zzx.zza(zzx.this).zzb(paramEventParcel, paramAppMetadata);
      }
    });
  }
  
  public final void zza(final EventParcel paramEventParcel, final String paramString1, final String paramString2)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramEventParcel);
    com.google.android.gms.common.internal.zzx.zzcM(paramString1);
    zzfm(paramString1);
    zzaTV.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzfl(paramString2);
        zzx.zza(zzx.this).zza(paramEventParcel, paramString1);
      }
    });
  }
  
  public final void zza(final UserAttributeParcel paramUserAttributeParcel, final AppMetadata paramAppMetadata)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramUserAttributeParcel);
    com.google.android.gms.common.internal.zzx.zzz(paramAppMetadata);
    zzfm(packageName);
    if (paramUserAttributeParcel.getValue() == null)
    {
      zzaTV.zzCn().zzg(new Runnable()
      {
        public final void run()
        {
          zzfl(paramAppMetadatazzaVx);
          zzw localzzw = zzx.zza(zzx.this);
          UserAttributeParcel localUserAttributeParcel = paramUserAttributeParcel;
          AppMetadata localAppMetadata = paramAppMetadata;
          localzzw.zzCn().zzjk();
          localzzw.zzjv();
          if (!TextUtils.isEmpty(zzaVt))
          {
            if (!zzaVy) {
              localzzw.zze(localAppMetadata);
            }
          }
          else {
            return;
          }
          zzAozzaWJ.zzj("Removing user property", name);
          localzzw.zzCj().beginTransaction();
          try
          {
            localzzw.zze(localAppMetadata);
            localzzw.zzCj().zzJ(packageName, name);
            localzzw.zzCj().setTransactionSuccessful();
            zzAozzaWJ.zzj("User property removed", name);
            return;
          }
          finally
          {
            localzzw.zzCj().endTransaction();
          }
        }
      });
      return;
    }
    zzaTV.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzfl(paramAppMetadatazzaVx);
        zzx.zza(zzx.this).zzb(paramUserAttributeParcel, paramAppMetadata);
      }
    });
  }
  
  public final void zzb(final AppMetadata paramAppMetadata)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramAppMetadata);
    zzfm(packageName);
    zzaTV.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzfl(paramAppMetadatazzaVx);
        zzw localzzw = zzx.zza(zzx.this);
        AppMetadata localAppMetadata = paramAppMetadata;
        localzzw.zzCn().zzjk();
        localzzw.zzjv();
        com.google.android.gms.common.internal.zzx.zzcM(packageName);
        localzzw.zze(localAppMetadata);
      }
    });
  }
  
  final void zzfl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(":", 2);
      if (paramString.length != 2) {}
    }
    long l;
    try
    {
      l = Long.valueOf(paramString[0]).longValue();
      if (l > 0L)
      {
        zzaTV.zzCo().zzaXi.zzf(paramString[1], l);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzaTV.zzAo().zzaWF.zzj("Combining sample with a non-number weight", paramString[0]);
      return;
    }
    zzaTV.zzAo().zzaWF.zzj("Combining sample with a non-positive weight", Long.valueOf(l));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */