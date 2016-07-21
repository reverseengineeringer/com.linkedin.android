package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;

@TargetApi(11)
public class zzis$zzb
  extends zzis.zza
{
  public final boolean zza(DownloadManager.Request paramRequest)
  {
    paramRequest.allowScanningByMediaScanner();
    paramRequest.setNotificationVisibility(1);
    return true;
  }
  
  public boolean zza(final Context paramContext, WebSettings paramWebSettings)
  {
    super.zza(paramContext, paramWebSettings);
    if ((File)zzjb.zzb(new Callable() {}) != null)
    {
      paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
      paramWebSettings.setAppCacheMaxSize(0L);
      paramWebSettings.setAppCacheEnabled(true);
    }
    paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
    paramWebSettings.setDatabaseEnabled(true);
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setDisplayZoomControls(false);
    paramWebSettings.setBuiltInZoomControls(true);
    paramWebSettings.setSupportZoom(true);
    paramWebSettings.setAllowContentAccess(false);
    return true;
  }
  
  public final boolean zza(Window paramWindow)
  {
    paramWindow.setFlags(16777216, 16777216);
    return true;
  }
  
  public final zzjq zzb(zzjp paramzzjp, boolean paramBoolean)
  {
    return new zzjw(paramzzjp, paramBoolean);
  }
  
  public final Set<String> zzf(Uri paramUri)
  {
    return paramUri.getQueryParameterNames();
  }
  
  public WebChromeClient zzk(zzjp paramzzjp)
  {
    return new zzjv(paramzzjp);
  }
  
  public final boolean zzm(View paramView)
  {
    paramView.setLayerType(0, null);
    return true;
  }
  
  public final boolean zzn(View paramView)
  {
    paramView.setLayerType(1, null);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzis.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */