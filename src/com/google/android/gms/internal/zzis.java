package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzhb
@TargetApi(8)
public class zzis
{
  public String getDefaultUserAgent(Context paramContext)
  {
    return "";
  }
  
  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public String zza(SslError paramSslError)
  {
    return "";
  }
  
  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean zza(DownloadManager.Request paramRequest)
  {
    return false;
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    return false;
  }
  
  public boolean zza(Window paramWindow)
  {
    return false;
  }
  
  public zzjq zzb(zzjp paramzzjp, boolean paramBoolean)
  {
    return new zzjq(paramzzjp, paramBoolean);
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
    }
  }
  
  public Set<String> zzf(Uri paramUri)
  {
    if (paramUri.isOpaque()) {
      return Collections.emptySet();
    }
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int j = 0;
    int i;
    do
    {
      int k = paramUri.indexOf('&', j);
      i = k;
      if (k == -1) {
        i = paramUri.length();
      }
      int m = paramUri.indexOf('=', j);
      if (m <= i)
      {
        k = m;
        if (m != -1) {}
      }
      else
      {
        k = i;
      }
      localLinkedHashSet.add(Uri.decode(paramUri.substring(j, k)));
      i += 1;
      j = i;
    } while (i < paramUri.length());
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public int zzhv()
  {
    return 0;
  }
  
  public int zzhw()
  {
    return 1;
  }
  
  public int zzhx()
  {
    return 5;
  }
  
  public WebChromeClient zzk(zzjp paramzzjp)
  {
    return null;
  }
  
  public boolean zzm(View paramView)
  {
    return false;
  }
  
  public boolean zzn(View paramView)
  {
    return false;
  }
  
  @TargetApi(9)
  public static class zza
    extends zzis
  {
    public zza()
    {
      super();
    }
    
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.setShowRunningNotification(true);
      return true;
    }
    
    public final int zzhv()
    {
      return 6;
    }
    
    public final int zzhw()
    {
      return 7;
    }
  }
  
  @TargetApi(11)
  public static class zzb
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
  
  @TargetApi(14)
  public static class zzc
    extends zzis.zzb
  {
    public final String zza(SslError paramSslError)
    {
      return paramSslError.getUrl();
    }
    
    public final WebChromeClient zzk(zzjp paramzzjp)
    {
      return new zzjx(paramzzjp);
    }
  }
  
  @TargetApi(17)
  public static class zzd
    extends zzis.zzf
  {
    public final String getDefaultUserAgent(Context paramContext)
    {
      return WebSettings.getDefaultUserAgent(paramContext);
    }
    
    public final Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
    {
      if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
        return new BitmapDrawable(paramContext.getResources(), paramBitmap);
      }
      try
      {
        Object localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
        Object localObject1 = Bitmap.createBitmap((Bitmap)localObject3);
        Object localObject2 = RenderScript.create(paramContext);
        ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
        localObject3 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject3);
        localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
        localScriptIntrinsicBlur.setRadius(paramFloat);
        localScriptIntrinsicBlur.setInput((Allocation)localObject3);
        localScriptIntrinsicBlur.forEach((Allocation)localObject2);
        ((Allocation)localObject2).copyTo((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject1);
        return (Drawable)localObject1;
      }
      catch (RuntimeException localRuntimeException) {}
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    }
    
    public final boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
      return true;
    }
  }
  
  @TargetApi(18)
  public static class zze
    extends zzis.zzd
  {
    public final int zzhx()
    {
      return 14;
    }
  }
  
  @TargetApi(16)
  public static class zzf
    extends zzis.zzc
  {
    public final void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setAllowFileAccessFromFileURLs(false);
      paramWebSettings.setAllowUniversalAccessFromFileURLs(false);
      return true;
    }
    
    public final void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramActivity = paramActivity.getWindow();
      if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
        paramActivity.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
      }
    }
  }
  
  @TargetApi(19)
  public static final class zzg
    extends zzis.zze
  {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */