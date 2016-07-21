package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public final class zzrp
{
  public static boolean DEBUG = false;
  public static String TAG = "WakeLock";
  private static String zzbhl = "*gcore*:";
  public final Context mContext;
  public final String zzanQ;
  public final PowerManager.WakeLock zzbhm;
  public WorkSource zzbhn;
  public final int zzbho;
  public final String zzbhp;
  public boolean zzbhq = true;
  public int zzbhr;
  public int zzbhs;
  
  public zzrp(Context paramContext, String paramString) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  private zzrp(Context paramContext, String paramString1, String paramString2)
  {
    zzx.zzh(paramString1, "Wake lock name can NOT be empty");
    zzbho = 1;
    zzbhp = null;
    mContext = paramContext.getApplicationContext();
    if ((!zzni.zzcV(paramString2)) && ("com.google.android.gms" != paramString2))
    {
      zzanQ = (zzbhl + paramString1);
      zzbhm = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, paramString1);
      if (zznj.zzaA(mContext))
      {
        paramString1 = paramString2;
        if (zzni.zzcV(paramString2))
        {
          if ((!zzd.zzakE) || (!zzlz.isInitialized())) {
            break label225;
          }
          Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + zzanQ + "!", new IllegalArgumentException());
          paramString1 = "com.google.android.gms";
        }
        label161:
        zzbhn = zznj.zzl(paramContext, paramString1);
        paramContext = zzbhn;
        if ((zznj.zzaA(mContext)) && (paramContext != null))
        {
          if (zzbhn == null) {
            break label233;
          }
          zzbhn.add(paramContext);
        }
      }
    }
    for (;;)
    {
      zzbhm.setWorkSource(zzbhn);
      return;
      zzanQ = paramString1;
      break;
      label225:
      paramString1 = paramContext.getPackageName();
      break label161;
      label233:
      zzbhn = paramContext;
    }
  }
  
  public final boolean zzfK$552c4dfd()
  {
    if (!TextUtils.isEmpty(null))
    {
      String str = zzbhp;
      throw new NullPointerException();
    }
    return false;
  }
  
  public final String zzn$185c6b75(boolean paramBoolean)
  {
    if (zzbhq)
    {
      if (paramBoolean) {
        return null;
      }
      return zzbhp;
    }
    return zzbhp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */