package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

@zzhb
public abstract interface zzjp
  extends zzeh
{
  public abstract Context getContext();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract ViewParent getParent();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract boolean isDestroyed();
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void zzD(boolean paramBoolean);
  
  public abstract void zzE(boolean paramBoolean);
  
  public abstract void zzF(boolean paramBoolean);
  
  public abstract void zza(AdSizeParcel paramAdSizeParcel);
  
  public abstract void zza(String paramString, Map<String, ?> paramMap);
  
  public abstract void zzaL(String paramString);
  
  public abstract AdSizeParcel zzaN();
  
  public abstract void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract boolean zzfL();
  
  public abstract void zzfr();
  
  public abstract void zzhN();
  
  public abstract Activity zzhP();
  
  public abstract Context zzhQ();
  
  public abstract com.google.android.gms.ads.internal.zzd zzhR();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhS();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhT();
  
  public abstract zzjq zzhU();
  
  public abstract boolean zzhV();
  
  public abstract zzan zzhW();
  
  public abstract VersionInfoParcel zzhX();
  
  public abstract boolean zzhY();
  
  public abstract void zzhZ();
  
  public abstract zzjo zzia();
  
  public abstract zzbz zzib();
  
  public abstract zzca zzic();
  
  public abstract void zzid();
  
  public abstract void zzie();
  
  public abstract void zzy(int paramInt);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */