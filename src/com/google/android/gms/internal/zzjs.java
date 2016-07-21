package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import org.json.JSONObject;

@zzhb
public final class zzjs
  extends FrameLayout
  implements zzjp
{
  private final zzjp zzNN;
  private final zzjo zzNO;
  
  public zzjs(zzjp paramzzjp)
  {
    super(paramzzjp.getContext());
    zzNN = paramzzjp;
    zzNO = new zzjo(paramzzjp.zzhQ(), this, this);
    paramzzjp = zzNN.zzhU();
    if (paramzzjp != null) {
      paramzzjp.zzh(this);
    }
    addView(zzNN.getView());
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final WebView getWebView()
  {
    return zzNN.getWebView();
  }
  
  public final boolean isDestroyed()
  {
    return zzNN.isDestroyed();
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    zzNN.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void loadUrl(String paramString)
  {
    zzNN.loadUrl(paramString);
  }
  
  public final void onPause()
  {
    zzx.zzcD("onPause must be called from the UI thread.");
    zzNN.onPause();
  }
  
  public final void onResume()
  {
    zzNN.onResume();
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    zzNN.setBackgroundColor(paramInt);
  }
  
  public final void setContext(Context paramContext)
  {
    zzNN.setContext(paramContext);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzNN.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    zzNN.setOnTouchListener(paramOnTouchListener);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    zzNN.setRequestedOrientation(paramInt);
  }
  
  public final void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    zzNN.setWebChromeClient(paramWebChromeClient);
  }
  
  public final void setWebViewClient(WebViewClient paramWebViewClient)
  {
    zzNN.setWebViewClient(paramWebViewClient);
  }
  
  public final void zzD(boolean paramBoolean)
  {
    zzNN.zzD(paramBoolean);
  }
  
  public final void zzE(boolean paramBoolean)
  {
    zzNN.zzE(paramBoolean);
  }
  
  public final void zzF(boolean paramBoolean)
  {
    zzNN.zzF(paramBoolean);
  }
  
  public final void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzNN.zza(paramAdSizeParcel);
  }
  
  public final void zza(String paramString, Map<String, ?> paramMap)
  {
    zzNN.zza(paramString, paramMap);
  }
  
  public final void zzaL(String paramString)
  {
    zzNN.zzaL(paramString);
  }
  
  public final AdSizeParcel zzaN()
  {
    return zzNN.zzaN();
  }
  
  public final void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzNN.zzb(paramzzd);
  }
  
  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzNN.zzb(paramString, paramJSONObject);
  }
  
  public final void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzNN.zzc(paramzzd);
  }
  
  public final boolean zzfL()
  {
    return zzNN.zzfL();
  }
  
  public final void zzfr()
  {
    zzNN.zzfr();
  }
  
  public final void zzhN()
  {
    zzNN.zzhN();
  }
  
  public final Activity zzhP()
  {
    return zzNN.zzhP();
  }
  
  public final Context zzhQ()
  {
    return zzNN.zzhQ();
  }
  
  public final com.google.android.gms.ads.internal.zzd zzhR()
  {
    return zzNN.zzhR();
  }
  
  public final com.google.android.gms.ads.internal.overlay.zzd zzhS()
  {
    return zzNN.zzhS();
  }
  
  public final com.google.android.gms.ads.internal.overlay.zzd zzhT()
  {
    return zzNN.zzhT();
  }
  
  public final zzjq zzhU()
  {
    return zzNN.zzhU();
  }
  
  public final boolean zzhV()
  {
    return zzNN.zzhV();
  }
  
  public final zzan zzhW()
  {
    return zzNN.zzhW();
  }
  
  public final VersionInfoParcel zzhX()
  {
    return zzNN.zzhX();
  }
  
  public final boolean zzhY()
  {
    return zzNN.zzhY();
  }
  
  public final void zzhZ()
  {
    Object localObject = zzNO;
    zzx.zzcD("onDestroy must be called from the UI thread.");
    if (zzFo != null)
    {
      localObject = zzFo;
      zzu localzzu = zzEO;
      mCancelled = true;
      zzir.zzMc.removeCallbacks(localzzu);
      if ((zzpD.zzhP() != null) && (zzEQ) && (!zzER))
      {
        zzpD.zzhP().getWindow().clearFlags(128);
        zzEQ = false;
      }
    }
    zzNN.zzhZ();
  }
  
  public final zzjo zzia()
  {
    return zzNO;
  }
  
  public final zzbz zzib()
  {
    return zzNN.zzib();
  }
  
  public final zzca zzic()
  {
    return zzNN.zzic();
  }
  
  public final void zzid()
  {
    zzNN.zzid();
  }
  
  public final void zzie()
  {
    zzNN.zzie();
  }
  
  public final void zzy(int paramInt)
  {
    zzNN.zzy(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */