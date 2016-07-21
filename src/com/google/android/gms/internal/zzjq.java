package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzhb
public class zzjq
  extends WebViewClient
{
  private static final String[] zzNy = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzNz = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private zzft zzDk;
  public zza zzGm;
  final HashMap<String, List<zzdf>> zzNA = new HashMap();
  zzg zzNB;
  zzb zzNC;
  boolean zzND = false;
  boolean zzNE;
  zzp zzNF;
  private final zzfr zzNG;
  private boolean zzNH;
  private boolean zzNI;
  private boolean zzNJ;
  private int zzNK;
  protected zzjp zzpD;
  final Object zzpV = new Object();
  boolean zzsz;
  com.google.android.gms.ads.internal.client.zza zztz;
  zzdb zzyW;
  public zze zzzA;
  zzfn zzzB;
  zzdh zzzD;
  private zzdj zzzy;
  
  public zzjq(zzjp paramzzjp, boolean paramBoolean)
  {
    this(paramzzjp, paramBoolean, new zzfr(paramzzjp, paramzzjp.zzhQ(), new zzbl(paramzzjp.getContext())));
  }
  
  private zzjq(zzjp paramzzjp, boolean paramBoolean, zzfr paramzzfr)
  {
    zzpD = paramzzjp;
    zzsz = paramBoolean;
    zzNG = paramzzfr;
    zzzB = null;
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = zzbt.zzwO;
    if (!((Boolean)zzr.zzbL().zzd((zzbp)localObject)).booleanValue()) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("err", paramString1);
    ((Bundle)localObject).putString("code", paramString2);
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = Uri.parse(paramString3);
      if (paramString1.getHost() == null) {}
    }
    for (paramString1 = paramString1.getHost();; paramString1 = "")
    {
      ((Bundle)localObject).putString("host", paramString1);
      zzr.zzbC();
      zzir.zza$6b82a487(paramContext, zzpD.zzhX().afmaVersion, "gmob-apps", (Bundle)localObject);
      return;
    }
  }
  
  private void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (zzzB != null) {}
    for (boolean bool1 = zzzB.zzeN();; bool1 = false)
    {
      zzr.zzbA();
      Context localContext = zzpD.getContext();
      if (!bool1) {
        bool2 = true;
      }
      if ((zzEJ == 4) && (zzEC == null))
      {
        if (zzEB != null) {
          localObject = zzEB;
        }
        zzr.zzbz();
        localObject = zzEA;
        paramAdOverlayInfoParcel = zzEI;
        com.google.android.gms.ads.internal.overlay.zza.zza$1d984e39(localContext, (AdLauncherIntentInfoParcel)localObject);
        return;
      }
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(localContext, "com.google.android.gms.ads.AdActivity");
      ((Intent)localObject).putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", zzrl.zzNb);
      ((Intent)localObject).putExtra("shouldCallOnOverlayOpened", bool2);
      AdOverlayInfoParcel.zza((Intent)localObject, paramAdOverlayInfoParcel);
      if (!zzne.zzcp(21)) {
        ((Intent)localObject).addFlags(524288);
      }
      if (!(localContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      zzr.zzbC();
      zzir.zzb(localContext, (Intent)localObject);
      return;
    }
  }
  
  private void zza(String paramString, zzdf paramzzdf)
  {
    synchronized (zzpV)
    {
      List localList = (List)zzNA.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        zzNA.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramzzdf);
      return;
    }
  }
  
  private void zzh(Uri paramUri)
  {
    Object localObject2 = paramUri.getPath();
    Object localObject1 = (List)zzNA.get(localObject2);
    if (localObject1 != null)
    {
      zzr.zzbC();
      paramUri = zzir.zze(paramUri);
      if (zzin.zzQ(2))
      {
        zzin.v("Received GMSG: " + (String)localObject2);
        localObject2 = paramUri.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          zzin.v("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((zzdf)((Iterator)localObject1).next()).zza(zzpD, paramUri);
      }
    }
    zzin.v("No GMSG handler found for GMSG: " + paramUri);
  }
  
  private void zzim()
  {
    if ((zzGm != null) && (((zzNI) && (zzNK <= 0)) || (zzNJ)))
    {
      zzGm.zza$7d63705e(zzpD);
      zzGm = null;
    }
    zzpD.zzie();
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    zzin.v("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      zzh(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (zzpV)
    {
      if (zzNH)
      {
        zzin.v("Blank page loaded, 1...");
        zzpD.zzhZ();
        return;
      }
      zzNI = true;
      zzim();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzNy.length)) {}
    for (String str = zzNy[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zza(zzpD.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzNz.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzNz[i];; str = String.valueOf(i))
    {
      zza(zzpD.getContext(), "ssl_err", str, zzr.zzbE().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzin.v("AdWebView shouldOverrideUrlLoading: " + paramString);
    Object localObject1 = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(((Uri)localObject1).getScheme())) && ("mobileads.google.com".equalsIgnoreCase(((Uri)localObject1).getHost()))) {
      zzh((Uri)localObject1);
    }
    for (;;)
    {
      return true;
      Object localObject2;
      if ((zzND) && (paramWebView == zzpD.getWebView()))
      {
        localObject2 = ((Uri)localObject1).getScheme();
        if (("http".equalsIgnoreCase((String)localObject2)) || ("https".equalsIgnoreCase((String)localObject2))) {}
        for (int i = 1; i != 0; i = 0)
        {
          if (zztz != null)
          {
            localObject1 = zzbt.zzww;
            if (((Boolean)zzr.zzbL().zzd((zzbp)localObject1)).booleanValue()) {
              zztz = null;
            }
          }
          return super.shouldOverrideUrlLoading(paramWebView, paramString);
        }
      }
      if (!zzpD.getWebView().willNotDraw())
      {
        try
        {
          localObject2 = zzpD.zzhW();
          paramWebView = (WebView)localObject1;
          if (localObject2 != null)
          {
            paramWebView = (WebView)localObject1;
            if (((zzan)localObject2).zzb((Uri)localObject1))
            {
              zzpD.getContext();
              paramWebView = ((zzan)localObject2).zza$7d090533((Uri)localObject1);
            }
          }
        }
        catch (zzao paramWebView)
        {
          for (;;)
          {
            zzin.zzaK("Unable to append parameter to URL: " + paramString);
            paramWebView = (WebView)localObject1;
          }
          zzin.zzaI("Action was blocked because no click was detected.");
        }
        if ((zzzA == null) || (zzzA.zzbh())) {
          zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
        }
      }
      else
      {
        zzin.zzaK("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public final void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    zzg localzzg = null;
    boolean bool = zzpD.zzhY();
    com.google.android.gms.ads.internal.client.zza localzza;
    if ((bool) && (!zzpD.zzaN().zzui))
    {
      localzza = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, localzza, localzzg, zzNF, zzpD.zzhX()));
      return;
      localzza = zztz;
      break;
      label75:
      localzzg = zzNB;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((zzpD.zzhY()) && (!zzpD.zzaN().zzui)) {}
    for (com.google.android.gms.ads.internal.client.zza localzza = null;; localzza = zztz)
    {
      zza(new AdOverlayInfoParcel(localzza, zzNB, zzNF, zzpD, paramBoolean, paramInt, zzpD.zzhX()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = zzpD.zzhY();
    com.google.android.gms.ads.internal.client.zza localzza;
    if ((bool) && (!zzpD.zzaN().zzui))
    {
      localzza = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzyW, zzNF, zzpD, paramBoolean, paramInt, paramString, zzpD.zzhX(), zzzD));
      return;
      localzza = zztz;
      break;
      label95:
      localObject = new zzc(zzpD, zzNB);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = zzpD.zzhY();
    com.google.android.gms.ads.internal.client.zza localzza;
    if ((bool) && (!zzpD.zzaN().zzui))
    {
      localzza = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzc(zzpD, zzNB))
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzyW, zzNF, zzpD, paramBoolean, paramInt, paramString1, paramString2, zzpD.zzhX(), zzzD));
      return;
      localzza = zztz;
      break;
    }
  }
  
  public final void zzb$45b6a852(zzdb paramzzdb, zzp paramzzp, zzdh paramzzdh, zze paramzze)
  {
    zze localzze = paramzze;
    if (paramzze == null) {
      localzze = new zze((byte)0);
    }
    zzzB = new zzfn(zzpD);
    zza("/appEvent", new zzda(paramzzdb));
    zza("/backButton", zzde.zzzh);
    zza("/canOpenURLs", zzde.zzyY);
    zza("/canOpenIntents", zzde.zzyZ);
    zza("/click", zzde.zzza);
    zza("/close", zzde.zzzb);
    zza("/customClose", zzde.zzzd);
    zza("/instrument", zzde.zzzk);
    zza("/delayPageLoaded", new zzd((byte)0));
    zza("/httpTrack", zzde.zzze);
    zza("/log", zzde.zzzf);
    zza("/mraid", new zzdl(localzze, zzzB));
    zza("/mraidLoaded", zzNG);
    zza("/open", new zzdm(paramzzdh, localzze, zzzB));
    zza("/precache", zzde.zzzj);
    zza("/touch", zzde.zzzg);
    zza("/video", zzde.zzzi);
    zza("/appStreaming", zzde.zzzc);
    zztz = null;
    zzNB = null;
    zzyW = paramzzdb;
    zzzD = paramzzdh;
    zzNF = paramzzp;
    zzzA = localzze;
    zzDk = null;
    zzzy = null;
    zzND = true;
  }
  
  public final boolean zzcv()
  {
    synchronized (zzpV)
    {
      boolean bool = zzsz;
      return bool;
    }
  }
  
  public final void zzh(zzjp paramzzjp)
  {
    zzpD = paramzzjp;
  }
  
  public final void zzii()
  {
    synchronized (zzpV)
    {
      zzin.v("Loading blank page in WebView, 2...");
      zzNH = true;
      zzpD.zzaL("about:blank");
      return;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza$7d63705e(zzjp paramzzjp);
  }
  
  public static abstract interface zzb {}
  
  private static final class zzc
    implements zzg
  {
    private zzg zzNB;
    private zzjp zzNM;
    
    public zzc(zzjp paramzzjp, zzg paramzzg)
    {
      zzNM = paramzzjp;
      zzNB = paramzzg;
    }
    
    public final void zzaW()
    {
      zzNB.zzaW();
      zzNM.zzhN();
    }
    
    public final void zzaX()
    {
      zzNB.zzaX();
      zzNM.zzfr();
    }
  }
  
  private final class zzd
    implements zzdf
  {
    private zzd() {}
    
    public final void zza(zzjp paramzzjp, Map<String, String> paramMap)
    {
      if (paramMap.keySet().contains("start")) {
        zzjq.zza(zzjq.this);
      }
      do
      {
        return;
        if (paramMap.keySet().contains("stop"))
        {
          zzjq.zzb(zzjq.this);
          return;
        }
      } while (!paramMap.keySet().contains("cancel"));
      zzjq.zzc(zzjq.this);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */