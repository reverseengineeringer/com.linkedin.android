package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzp
  extends zzz
{
  private final long zzaVj = zzd.zzBp();
  private final char zzaWB;
  public final zza zzaWC;
  private final zza zzaWD;
  private final zza zzaWE;
  public final zza zzaWF;
  final zza zzaWG;
  final zza zzaWH;
  final zza zzaWI;
  final zza zzaWJ;
  public final zza zzaWK;
  private final String zzamn = zzd.zzBz();
  
  zzp(zzw paramzzw)
  {
    super(paramzzw);
    if (super.zzCp().zzks())
    {
      if (zzd.zzkr()) {}
      for (c = 'P';; c = 'C')
      {
        zzaWB = c;
        zzaWC = new zza(6, false, false);
        zzaWD = new zza(6, true, false);
        zzaWE = new zza(6, false, true);
        zzaWF = new zza(5, false, false);
        zzaWG = new zza(5, true, false);
        zzaWH = new zza(5, false, true);
        zzaWI = new zza(4, false, false);
        zzaWJ = new zza(3, false, false);
        zzaWK = new zza(2, false, false);
        return;
      }
    }
    if (zzd.zzkr()) {}
    for (char c = 'p';; c = 'c')
    {
      zzaWB = c;
      break;
    }
  }
  
  private static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzc(paramBoolean, paramObject1);
    paramObject2 = zzc(paramBoolean, paramObject2);
    paramObject3 = zzc(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzc(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof Integer)) {
      paramObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      String str1;
      if ((paramObject instanceof Long))
      {
        if (!paramBoolean) {
          return String.valueOf(paramObject);
        }
        if (Math.abs(((Long)paramObject).longValue()) < 100L) {
          return String.valueOf(paramObject);
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (str1 = "-";; str1 = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          return str1 + Math.round(Math.pow(10.0D, ((String)paramObject).length() - 1)) + "..." + str1 + Math.round(Math.pow(10.0D, ((String)paramObject).length()) - 1.0D);
        }
      }
      if ((paramObject instanceof Boolean)) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof Throwable))
      {
        Object localObject1 = (Throwable)paramObject;
        paramObject = new StringBuilder(((Throwable)localObject1).toString());
        str1 = zzff(AppMeasurement.class.getCanonicalName());
        String str2 = zzff(zzw.class.getCanonicalName());
        localObject1 = ((Throwable)localObject1).getStackTrace();
        int j = localObject1.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!((StackTraceElement)localObject2).isNativeMethod())
            {
              String str3 = ((StackTraceElement)localObject2).getClassName();
              if (str3 != null)
              {
                str3 = zzff(str3);
                if ((str3.equals(str1)) || (str3.equals(str2)))
                {
                  ((StringBuilder)paramObject).append(": ");
                  ((StringBuilder)paramObject).append(localObject2);
                }
              }
            }
          }
          else
          {
            return ((StringBuilder)paramObject).toString();
          }
          i += 1;
        }
      }
      if (paramBoolean) {
        return "-";
      }
      return String.valueOf(paramObject);
    }
  }
  
  private static String zzff(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public final String zzCL()
  {
    Object localObject = zzCozzaXi;
    zzaXA.zzjk();
    zzaXA.zzjk();
    long l = ((zzt.zzc)localObject).zzlO();
    if (l == 0L)
    {
      ((zzt.zzc)localObject).zzlL();
      l = 0L;
      if (l >= zzTl) {
        break label77;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label175;
      }
      return null;
      l = Math.abs(l - zzaXA.zzjl().currentTimeMillis());
      break;
      label77:
      if (l > zzTl * 2L)
      {
        ((zzt.zzc)localObject).zzlL();
        localObject = null;
      }
      else
      {
        String str = zzt.zzc(zzaXA).getString(zzaXE, null);
        l = zzt.zzc(zzaXA).getLong(zzaXD, 0L);
        ((zzt.zzc)localObject).zzlL();
        if ((str == null) || (l <= 0L)) {
          localObject = zzt.zzaXh;
        } else {
          localObject = new Pair(str, Long.valueOf(l));
        }
      }
    }
    label175:
    return String.valueOf(second) + ":" + (String)first;
  }
  
  protected final boolean zzQ(int paramInt)
  {
    return Log.isLoggable(zzamn, paramInt);
  }
  
  protected final void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, final Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zzQ(paramInt))) {
      zzl(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    zzv localzzv;
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      zzx.zzz(paramString);
      localzzv = zzaTV.zzaYa;
      if (localzzv == null) {
        zzl(6, "Scheduler not set. Not logging error/warn.");
      }
    }
    else
    {
      return;
    }
    if (!localzzv.isInitialized())
    {
      zzl(6, "Scheduler not initialized. Not logging error/warn.");
      return;
    }
    if (zzaYC)
    {
      zzl(6, "Scheduler shutdown. Not logging error/warn.");
      return;
    }
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 9) {
        i = 8;
      }
      paramObject2 = "1" + "01VDIWEA?".charAt(i) + zzaWB + zzaVj + ":" + zza(true, paramString, paramObject1, paramObject2, paramObject3);
      paramObject1 = paramObject2;
      if (((String)paramObject2).length() > 1024) {
        paramObject1 = paramString.substring(0, 1024);
      }
      localzzv.zzg(new Runnable()
      {
        public final void run()
        {
          zzt localzzt = zzaTV.zzCo();
          if ((!localzzt.isInitialized()) || (zzaYC))
          {
            zzl(6, "Persisted config not initialized . Not logging error/warn.");
            return;
          }
          zzaXi.zzf(paramObject1, 1L);
        }
      });
      return;
    }
  }
  
  protected final void zziJ() {}
  
  protected final void zzl(int paramInt, String paramString)
  {
    Log.println(paramInt, zzamn, paramString);
  }
  
  public final class zza
  {
    private final int mPriority;
    private final boolean zzaWN;
    private final boolean zzaWO;
    
    zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      mPriority = paramInt;
      zzaWN = paramBoolean1;
      zzaWO = paramBoolean2;
    }
    
    public final void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      zza(mPriority, zzaWN, zzaWO, paramString, paramObject1, paramObject2, paramObject3);
    }
    
    public final void zze(String paramString, Object paramObject1, Object paramObject2)
    {
      zza(mPriority, zzaWN, zzaWO, paramString, paramObject1, paramObject2, null);
    }
    
    public final void zzfg(String paramString)
    {
      zza(mPriority, zzaWN, zzaWO, paramString, null, null, null);
    }
    
    public final void zzj(String paramString, Object paramObject)
    {
      zza(mPriority, zzaWN, zzaWO, paramString, paramObject, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */