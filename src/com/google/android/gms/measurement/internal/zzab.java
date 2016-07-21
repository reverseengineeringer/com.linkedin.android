package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.AppMeasurement.zza;
import java.util.Iterator;
import java.util.Set;

public final class zzab
  extends zzz
{
  private zza zzaYD;
  private AppMeasurement.zza zzaYE;
  private boolean zzaYF;
  
  protected zzab(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  private void zza(final String paramString1, final String paramString2, final long paramLong, final Object paramObject)
  {
    super.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzab.zza(zzab.this, paramString1, paramString2, paramObject, paramLong);
      }
    });
  }
  
  @TargetApi(14)
  public final void zzDk()
  {
    if ((super.getContext().getApplicationContext() instanceof Application))
    {
      Application localApplication = (Application)super.getContext().getApplicationContext();
      if (zzaYD == null) {
        zzaYD = new zza((byte)0);
      }
      localApplication.unregisterActivityLifecycleCallbacks(zzaYD);
      localApplication.registerActivityLifecycleCallbacks(zzaYD);
      zzAozzaWK.zzfg("Registered activity lifecycle callback");
    }
  }
  
  public final void zzDl()
  {
    super.zzjk();
    super.zzjj();
    zzjv();
    if (!zzaTV.zzCS()) {}
    String str;
    do
    {
      return;
      super.zzCi().zzDl();
      Object localObject2 = super.zzCo();
      ((zzt)localObject2).zzjk();
      str = ((zzt)localObject2).zzCO().getString("previous_os_version", null);
      localObject1 = ((zzt)localObject2).zzCh().zzCy();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(str)))
      {
        localObject2 = ((zzt)localObject2).zzCO().edit();
        ((SharedPreferences.Editor)localObject2).putString("previous_os_version", (String)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
      }
    } while ((TextUtils.isEmpty(str)) || (str.equals(super.zzCh().zzCy())));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("_po", str);
    zze("auto", "_ou", (Bundle)localObject1);
  }
  
  public final void zza(String paramString1, String paramString2, Object paramObject)
  {
    zzx.zzcM(paramString1);
    long l = super.zzjl().currentTimeMillis();
    super.zzCk();
    zzaj.zzfs(paramString2);
    if (paramObject != null)
    {
      zzaj localzzaj = super.zzCk();
      if ("_ldl".equals(paramString2)) {
        localzzaj.zza("user attribute referrer", paramString2, zzaj.zzfu(paramString2), paramObject);
      }
      for (;;)
      {
        super.zzCk();
        paramObject = zzaj.zzm(paramString2, paramObject);
        if (paramObject != null) {
          zza(paramString1, paramString2, l, paramObject);
        }
        return;
        localzzaj.zza("user attribute", paramString2, zzaj.zzfu(paramString2), paramObject);
      }
    }
    zza(paramString1, paramString2, l, null);
  }
  
  public final void zze(final String paramString1, final String paramString2, Bundle paramBundle)
  {
    super.zzjj();
    final long l = super.zzjl().currentTimeMillis();
    zzx.zzcM(paramString1);
    super.zzCk();
    zzaj.zzc("event", zzd.zzBB(), paramString2);
    Bundle localBundle = new Bundle();
    zzd.zzBA();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      super.zzCk();
      zzaj.zzc("event param", zzd.zzBC(), str);
      int j = i;
      if (zzaj.zzfq(str))
      {
        j = i + 1;
        if (j > 25) {
          break label183;
        }
      }
      label183:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Event can't contain more then 25 params");
        super.zzCk();
        Object localObject = zzaj.zzk(str, paramBundle.get(str));
        i = j;
        if (localObject == null) {
          break;
        }
        super.zzCk().zza(localBundle, str, localObject);
        i = j;
        break;
      }
    }
    zzd.zzBD();
    if (paramString1.length() <= 36) {}
    for (paramBundle = paramString1;; paramBundle = paramString1.substring(0, 36))
    {
      localBundle.putString("_o", paramBundle);
      zzx.zzz(localBundle);
      super.zzCn().zzg(new Runnable()
      {
        public final void run()
        {
          zzab.zza(zzab.this, paramString1, paramString2, l, zzaYK, zzaYL, zzaHU);
        }
      });
      return;
    }
  }
  
  protected final void zziJ() {}
  
  @TargetApi(14)
  private final class zza
    implements Application.ActivityLifecycleCallbacks
  {
    private zza() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      try
      {
        zzAo().zzaWK.zzfg("onActivityCreated");
        paramActivity = paramActivity.getIntent();
        if (paramActivity == null) {
          return;
        }
        paramActivity = paramActivity.getData();
        if ((paramActivity == null) || (!paramActivity.isHierarchical())) {
          return;
        }
        paramActivity = paramActivity.getQueryParameter("referrer");
        if (TextUtils.isEmpty(paramActivity)) {
          return;
        }
        if (!paramActivity.contains("gclid"))
        {
          zzAo().zzaWJ.zzfg("Activity created with data 'referrer' param without gclid");
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        zzAo().zzaWC.zzj("Throwable caught in onActivityCreated", paramActivity);
        return;
      }
      zzAo().zzaWJ.zzj("Activity created with referrer", paramActivity);
      if (!TextUtils.isEmpty(paramActivity)) {
        zza("auto", "_ldl", paramActivity);
      }
    }
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity)
    {
      paramActivity = zzCm();
      long l = paramActivity.zzjl().elapsedRealtime();
      paramActivity.zzCn().zzg(new zzad.5(paramActivity, l));
    }
    
    public final void onActivityResumed(Activity arg1)
    {
      synchronized (zzCm())
      {
        ???.zzDv();
        mHandler.removeCallbacks(zzaZb);
        long l = ???.zzjl().elapsedRealtime();
        ???.zzCn().zzg(new zzad.4(???, l));
        return;
      }
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity) {}
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */