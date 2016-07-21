package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

@zzhb
@TargetApi(14)
public final class zzbf
  extends Thread
{
  private boolean zzam;
  private final Object zzpV;
  final int zzsK;
  final int zzsM;
  private boolean zzsY;
  private final zzbe zzsZ;
  final zzbd zzta;
  final zzha zztb;
  private final int zztc;
  final int zztd;
  final int zzte;
  
  private boolean zzcH()
  {
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        Object localObject1 = zzsZ.mContext;
        if (localObject1 == null) {
          return false;
        }
        Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
        KeyguardManager localKeyguardManager = (KeyguardManager)((Context)localObject1).getSystemService("keyguard");
        if ((localObject2 != null) && (localKeyguardManager != null))
        {
          localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
          if (localObject2 == null) {
            return false;
          }
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            if (Process.myPid() != pid) {
              continue;
            }
            if (importance != 100) {
              break label169;
            }
            i = 1;
            if ((i != 0) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              localObject1 = (PowerManager)((Context)localObject1).getSystemService("power");
              if (localObject1 == null)
              {
                bool = false;
                break label163;
              }
              bool = ((PowerManager)localObject1).isScreenOn();
              break label163;
            }
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      return false;
      label163:
      if (bool)
      {
        return true;
        label169:
        i = 0;
      }
    }
  }
  
  public final void run()
  {
    while (!zzam) {
      try
      {
        if (zzcH())
        {
          localActivity = zzsZ.mActivity;
          if (localActivity == null) {
            zzin.zzaI("ContentFetchThread: no activity");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Activity localActivity;
        zzin.zzb("Error in ContentFetchTask", localThrowable);
        zztb.zza(localThrowable, true);
        synchronized (zzpV)
        {
          for (;;)
          {
            boolean bool = zzsY;
            if (!bool) {
              break;
            }
            try
            {
              zzin.zzaI("ContentFetchTask: waiting");
              zzpV.wait();
            }
            catch (InterruptedException localInterruptedException) {}
          }
          if (localActivity != null)
          {
            Object localObject2 = null;
            ??? = localObject2;
            if (localActivity.getWindow() != null)
            {
              ??? = localObject2;
              if (localActivity.getWindow().getDecorView() != null) {
                ??? = localActivity.getWindow().getDecorView().findViewById(16908290);
              }
            }
            if ((??? != null) && (??? != null)) {
              ((View)???).post(new Runnable()
              {
                public final void run()
                {
                  zzbf localzzbf = zzbf.this;
                  ??? = localObject1;
                  try
                  {
                    zzbc localzzbc = new zzbc(zzsK, zztd, zzsM, zzte);
                    ??? = localzzbf.zza((View)???, localzzbc);
                    localzzbc.zzcD();
                    if ((zztm == 0) && (zztn == 0)) {
                      return;
                    }
                    if (((zztn != 0) || (zzsQ != 0)) && ((zztn != 0) || (!zzta.zza(localzzbc))))
                    {
                      zzbd localzzbd = zzta;
                      synchronized (zzpV)
                      {
                        if (zzsX.size() >= 10)
                        {
                          zzin.zzaI("Queue is full, current size = " + zzsX.size());
                          zzsX.remove(0);
                        }
                        int i = zzsW;
                        zzsW = (i + 1);
                        zzsR = i;
                        zzsX.add(localzzbc);
                        return;
                      }
                    }
                    return;
                  }
                  catch (Exception localException)
                  {
                    zzin.zzb("Exception in fetchContentOnUIThread", localException);
                    zztb.zza(localException, true);
                  }
                }
              });
            }
          }
          for (;;)
          {
            Thread.sleep(zztc * 1000);
            break;
            zzin.zzaI("ContentFetchTask: sleeping");
            synchronized (zzpV)
            {
              zzsY = true;
              zzin.zzaI("ContentFetchThread: paused, mPause = " + zzsY);
            }
          }
        }
      }
    }
  }
  
  final zza zza(final View paramView, final zzbc paramzzbc)
  {
    int i = 0;
    if (paramView == null) {
      return new zza(0, 0);
    }
    final boolean bool = paramView.getGlobalVisibleRect(new Rect());
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      paramView = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(paramView))
      {
        paramzzbc.zze(paramView.toString(), bool);
        return new zza(1, 0);
      }
      return new zza(0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zzjp)))
    {
      paramzzbc.zzcC();
      paramView = (WebView)paramView;
      if (!zzne.zzcp(19)) {}
      for (i = 0; i != 0; i = 1)
      {
        return new zza(0, 1);
        paramzzbc.zzcC();
        paramView.post(new Runnable()
        {
          ValueCallback<String> zzth = new ValueCallback() {};
          
          public final void run()
          {
            if (paramView.getSettings().getJavaScriptEnabled()) {}
            try
            {
              paramView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzth);
              return;
            }
            catch (Throwable localThrowable)
            {
              zzth.onReceiveValue("");
            }
          }
        });
      }
      return new zza(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < paramView.getChildCount())
      {
        zza localzza = zza(paramView.getChildAt(i), paramzzbc);
        k += zztm;
        j += zztn;
        i += 1;
      }
      return new zza(k, j);
    }
    return new zza(0, 0);
  }
  
  @zzhb
  final class zza
  {
    final int zztm;
    final int zztn;
    
    zza(int paramInt1, int paramInt2)
    {
      zztm = paramInt1;
      zztn = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */