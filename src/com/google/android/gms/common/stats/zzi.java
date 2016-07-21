package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmv;
import java.util.List;

public final class zzi
{
  private static String TAG = "WakeLockTracker";
  private static zzi zzanY = new zzi();
  private static Integer zzanv;
  
  private static int getLogLevel()
  {
    try
    {
      if (zzmp.zzkr()) {
        return ((Integer)zzc.zzb.zzanz.get()).intValue();
      }
      int i = zzd.LOG_LEVEL_OFF;
      return i;
    }
    catch (SecurityException localSecurityException) {}
    return zzd.LOG_LEVEL_OFF;
  }
  
  public static void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, List<String> paramList, long paramLong)
  {
    if (zzanv == null) {
      zzanv = Integer.valueOf(getLogLevel());
    }
    int i;
    if (zzanv.intValue() != zzd.LOG_LEVEL_OFF)
    {
      i = 1;
      if (i != 0) {
        break label42;
      }
    }
    label42:
    long l;
    do
    {
      return;
      i = 0;
      break;
      if (TextUtils.isEmpty(paramString1))
      {
        Log.e(TAG, "missing wakeLock key. " + paramString1);
        return;
      }
      l = System.currentTimeMillis();
    } while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, paramList, paramString1, SystemClock.elapsedRealtime(), zzmv.zzax(paramContext), paramString3, paramContext.getPackageName(), zzmv.zzay(paramContext), paramLong);
    try
    {
      paramContext.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (Exception paramContext)
    {
      Log.wtf(TAG, paramContext);
    }
  }
  
  public static void zza$2861d97a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList)
  {
    zza(paramContext, paramString1, 8, paramString2, paramString3, paramInt, paramList, 0L);
  }
  
  public static zzi zzrZ()
  {
    return zzanY;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */