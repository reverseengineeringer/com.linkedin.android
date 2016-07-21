package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
@TargetApi(11)
public final class zzjw
  extends zzjq
{
  public zzjw(zzjp paramzzjp, boolean paramBoolean)
  {
    super(paramzzjp, paramBoolean);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName())) {
          return super.shouldInterceptRequest(paramWebView, paramString);
        }
        if (!(paramWebView instanceof zzjp))
        {
          zzin.zzaK("Tried to intercept request from a WebView that wasn't an AdWebView.");
          return super.shouldInterceptRequest(paramWebView, paramString);
        }
        localObject3 = (zzjp)paramWebView;
        localObject5 = ((zzjp)localObject3).zzhU();
      }
      catch (IOException localIOException)
      {
        Object localObject3;
        Object localObject5;
        zzin.zzaK("Could not fetch MRAID JS. " + localIOException.getMessage());
        return super.shouldInterceptRequest(paramWebView, paramString);
        if (!((zzjp)localObject4).zzhY()) {
          continue;
        }
        Object localObject2 = zzbt.zzwe;
        localObject2 = (String)zzr.zzbL().zzd((zzbp)localObject2);
        continue;
        localObject2 = zzbt.zzwd;
        localObject2 = (String)zzr.zzbL().zzd((zzbp)localObject2);
        continue;
        localObject2 = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(((String)localObject2).getBytes("UTF-8")));
        return (WebResourceResponse)localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      catch (ExecutionException localExecutionException)
      {
        continue;
      }
      catch (TimeoutException localTimeoutException)
      {
        continue;
      }
      synchronized (zzpV)
      {
        zzND = false;
        zzsz = true;
        zzir.runOnUiThread(new zzjq.1((zzjq)localObject5));
        if (zzaNzzui)
        {
          ??? = zzbt.zzwf;
          ??? = (String)zzr.zzbL().zzd((zzbp)???);
          zzin.v("shouldInterceptRequest(" + (String)??? + ")");
          localObject5 = ((zzjp)localObject3).getContext();
          Object localObject6 = zzpD.zzhX().afmaVersion;
          localObject3 = new HashMap();
          ((Map)localObject3).put("User-Agent", zzr.zzbC().zze((Context)localObject5, (String)localObject6));
          ((Map)localObject3).put("Cache-Control", "max-stale=3600");
          localObject6 = new zziw((Context)localObject5);
          localObject5 = new zziw.zzc((zziw)localObject6, (byte)0);
          ??? = new zziw.3((zziw)localObject6, (String)???, (zzm.zzb)localObject5, new zziw.2((zziw)localObject6, (String)???, (zziw.zzc)localObject5), (Map)localObject3);
          zziw.zzMy.zze((zzk)???);
          ??? = (String)((zzjg)localObject5).get(60L, TimeUnit.SECONDS);
          if (??? != null) {
            continue;
          }
          return null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */