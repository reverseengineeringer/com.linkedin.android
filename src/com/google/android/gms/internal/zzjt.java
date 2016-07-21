package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import org.json.JSONException;

@zzhb
public final class zzjt
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzjp
{
  private AdSizeParcel zzCh;
  private int zzDC = -1;
  private int zzDD = -1;
  private int zzDF = -1;
  private int zzDG = -1;
  private String zzEY = "";
  private Boolean zzLB;
  private final zza zzNP;
  private zzjq zzNQ;
  private com.google.android.gms.ads.internal.overlay.zzd zzNR;
  private boolean zzNS;
  private boolean zzNT;
  private boolean zzNU;
  private boolean zzNV;
  private int zzNW;
  private boolean zzNX = true;
  private zzbz zzNY;
  private zzbz zzNZ;
  private zzbz zzOa;
  private zzca zzOb;
  private WeakReference<View.OnClickListener> zzOc;
  private com.google.android.gms.ads.internal.overlay.zzd zzOd;
  private Map<String, zzdr> zzOe;
  private final VersionInfoParcel zzpT;
  private final Object zzpV = new Object();
  private final com.google.android.gms.ads.internal.zzd zzpm;
  private zzjc zzrV;
  private final WindowManager zzsb;
  private final zzan zzyt;
  
  private zzjt(zza arg1, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    super(???);
    zzNP = ???;
    zzCh = paramAdSizeParcel;
    zzNU = true;
    zzNW = -1;
    zzyt = null;
    zzpT = paramVersionInfoParcel;
    zzpm = paramzzd;
    zzsb = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramAdSizeParcel = getSettings();
    paramAdSizeParcel.setAllowFileAccess(false);
    paramAdSizeParcel.setJavaScriptEnabled(true);
    paramAdSizeParcel.setSavePassword(false);
    paramAdSizeParcel.setSupportMultipleWindows(true);
    paramAdSizeParcel.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAdSizeParcel.setMixedContentMode(0);
    }
    paramAdSizeParcel.setUserAgentString(zzr.zzbC().zze(???, afmaVersion));
    zzr.zzbE().zza(getContext(), paramAdSizeParcel);
    setDownloadListener(this);
    zziq();
    if (zzne.zzcp(17)) {
      addJavascriptInterface(new zzju(this), "googleAdsJsInterface");
    }
    zzrV = new zzjc(zzNP.zzMM, this);
    zziu();
    zzOb = new zzca(new zzcb("make_wv", zzCh.zzuh));
    paramAdSizeParcel = zzOb.zzpe;
    synchronized (zzpV)
    {
      zzxD = null;
      zzNZ = zzbx.zzb(zzOb.zzpe);
      zzOb.zza("native:view_create", zzNZ);
      zzOa = null;
      zzNY = null;
      return;
    }
  }
  
  private void zzaO(String paramString)
  {
    synchronized (zzpV)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzin.zzaK("The webview is destroyed. Ignoring action.");
    }
  }
  
  private void zzb(Boolean paramBoolean)
  {
    zzLB = paramBoolean;
    zzih localzzih = zzr.zzbF();
    synchronized (zzpV)
    {
      zzLB = paramBoolean;
      return;
    }
  }
  
  public static zzjt zzb$44e1b059$6f32e7e1(Context paramContext, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    return new zzjt(new zza(paramContext), paramAdSizeParcel, paramVersionInfoParcel, paramzzd);
  }
  
  private Boolean zzhg()
  {
    synchronized (zzpV)
    {
      Boolean localBoolean = zzLB;
      return localBoolean;
    }
  }
  
  private boolean zzin()
  {
    if (!zzNQ.zzcv()) {
      return false;
    }
    zzr.zzbC();
    DisplayMetrics localDisplayMetrics = zzir.zza(zzsb);
    zzn.zzcS();
    int k = zza.zzb(localDisplayMetrics, widthPixels);
    zzn.zzcS();
    int m = zza.zzb(localDisplayMetrics, heightPixels);
    Object localObject = zzNP.zzMM;
    int j;
    int i;
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      j = m;
      i = k;
      label83:
      if ((zzDC == k) && (zzDD == m) && (zzDF == i) && (zzDG == j)) {
        break label233;
      }
      if ((zzDC == k) && (zzDD == m)) {
        break label235;
      }
    }
    label233:
    label235:
    for (boolean bool = true;; bool = false)
    {
      zzDC = k;
      zzDD = m;
      zzDF = i;
      zzDG = j;
      new zzfs(this).zza(k, m, i, j, density, zzsb.getDefaultDisplay().getRotation());
      return bool;
      zzr.zzbC();
      localObject = zzir.zze((Activity)localObject);
      zzn.zzcS();
      i = zza.zzb(localDisplayMetrics, localObject[0]);
      zzn.zzcS();
      j = zza.zzb(localDisplayMetrics, localObject[1]);
      break label83;
      break;
    }
  }
  
  private void zzip()
  {
    zzbx.zza(zzOb.zzpe, zzNY, new String[] { "aeh" });
  }
  
  private void zziq()
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        if ((zzNU) || (zzCh.zzui))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzin.zzaI("Disabling hardware acceleration on an overlay.");
            zzir();
            return;
          }
          zzin.zzaI("Enabling hardware acceleration on an overlay.");
          zzis();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzin.zzaI("Disabling hardware acceleration on an AdView.");
        zzir();
      }
      else
      {
        zzin.zzaI("Enabling hardware acceleration on an AdView.");
        zzis();
      }
    }
  }
  
  private void zzir()
  {
    synchronized (zzpV)
    {
      if (!zzNV) {
        zzr.zzbE().zzn(this);
      }
      zzNV = true;
      return;
    }
  }
  
  private void zzis()
  {
    synchronized (zzpV)
    {
      if (zzNV) {
        zzr.zzbE().zzm(this);
      }
      zzNV = false;
      return;
    }
  }
  
  private void zzit()
  {
    synchronized (zzpV)
    {
      if (zzOe != null)
      {
        Iterator localIterator = zzOe.values().iterator();
        if (localIterator.hasNext()) {
          localIterator.next();
        }
      }
    }
  }
  
  private void zziu()
  {
    if (zzOb == null) {}
    zzcb localzzcb;
    do
    {
      return;
      localzzcb = zzOb.zzpe;
    } while ((localzzcb == null) || (zzr.zzbF().zzhb() == null));
    zzbFzzhbzzxl.offer(localzzcb);
  }
  
  public final void destroy()
  {
    synchronized (zzpV)
    {
      zziu();
      ??? = zzrV;
      zzMP = false;
      ((zzjc)???).zzhH();
      if (zzNR != null)
      {
        zzNR.close();
        zzNR.onDestroy();
        zzNR = null;
      }
      zzjq localzzjq = zzNQ;
      synchronized (zzpV)
      {
        zzNA.clear();
        zztz = null;
        zzNB = null;
        zzGm = null;
        zzyW = null;
        zzND = false;
        zzsz = false;
        zzNE = false;
        zzzD = null;
        zzNF = null;
        zzNC = null;
        if (zzzB != null)
        {
          zzzB.zzp(true);
          zzzB = null;
        }
        if (zzNT) {
          return;
        }
      }
    }
    zzr.zzbR();
    zzdq.zzd(this);
    zzit();
    zzNT = true;
    zzin.v("Initiating WebView self destruct sequence in 3...");
    zzNQ.zzii();
  }
  
  @TargetApi(19)
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzpV)
    {
      if (isDestroyed())
      {
        zzin.zzaK("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  protected final void finalize()
    throws Throwable
  {
    synchronized (zzpV)
    {
      if (!zzNT)
      {
        zzr.zzbR();
        zzdq.zzd(this);
        zzit();
      }
      super.finalize();
      return;
    }
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final WebView getWebView()
  {
    return this;
  }
  
  public final boolean isDestroyed()
  {
    synchronized (zzpV)
    {
      boolean bool = zzNT;
      return bool;
    }
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (zzpV)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzin.zzaK("The webview is destroyed. Ignoring action.");
    }
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (zzpV)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzin.zzaK("The webview is destroyed. Ignoring action.");
    }
  }
  
  public final void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable paramString)
          {
            zzin.zzaK("Could not call loadUrl. " + paramString);
            continue;
          }
        }
      }
      zzin.zzaK("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected final void onAttachedToWindow()
  {
    synchronized (zzpV)
    {
      super.onAttachedToWindow();
      if (!isDestroyed())
      {
        zzjc localzzjc = zzrV;
        zzMO = true;
        if (zzMP) {
          localzzjc.zzhG();
        }
      }
      return;
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    synchronized (zzpV)
    {
      if (!isDestroyed())
      {
        zzjc localzzjc = zzrV;
        zzMO = false;
        localzzjc.zzhH();
      }
      super.onDetachedFromWindow();
      return;
    }
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      zzr.zzbC();
      zzir.zzb(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      zzin.zzaI("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  @TargetApi(21)
  protected final void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow())) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public final void onGlobalLayout()
  {
    boolean bool = zzin();
    com.google.android.gms.ads.internal.overlay.zzd localzzd = zzhS();
    if ((localzzd != null) && (bool) && (zzEp))
    {
      zzEp = false;
      localzzd.zzfr();
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    synchronized (zzpV)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (zzNU) || (zzCh.zzuk) || (zzCh.zzul))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    if (zzCh.zzui)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      zzsb.getDefaultDisplay().getMetrics(localDisplayMetrics);
      setMeasuredDimension(widthPixels, heightPixels);
      return;
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (n != Integer.MIN_VALUE) {
      if (n == 1073741824) {
        break label365;
      }
    }
    for (;;)
    {
      if ((zzCh.widthPixels > paramInt1) || (zzCh.heightPixels > paramInt2))
      {
        float f = zzNP.getResources().getDisplayMetrics().density;
        zzin.zzaK("Not enough space to show ad. Needs " + (int)(zzCh.widthPixels / f) + "x" + (int)(zzCh.heightPixels / f) + " dp, but only has " + (int)(i / f) + "x" + (int)(k / f) + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(zzCh.widthPixels, zzCh.heightPixels);
      }
      paramInt1 = Integer.MAX_VALUE;
      break label368;
      label365:
      paramInt1 = i;
      label368:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = j;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = k;
      }
    }
  }
  
  public final void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzne.zzcp(11))
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzin.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public final void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzne.zzcp(11))
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzin.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isDestroyed()) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void setContext(Context paramContext)
  {
    zzNP.setBaseContext(paramContext);
    zzrV.zzMM = zzNP.zzMM;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzOc = new WeakReference(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    synchronized (zzpV)
    {
      zzNW = paramInt;
      if (zzNR != null) {
        zzNR.setRequestedOrientation(zzNW);
      }
      return;
    }
  }
  
  public final void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzjq)) {
      zzNQ = ((zzjq)paramWebViewClient);
    }
  }
  
  public final void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzin.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public final void zzD(boolean paramBoolean)
  {
    synchronized (zzpV)
    {
      zzNU = paramBoolean;
      zziq();
      return;
    }
  }
  
  public final void zzE(boolean paramBoolean)
  {
    synchronized (zzpV)
    {
      if (zzNR != null)
      {
        zzNR.zza(zzNQ.zzcv(), paramBoolean);
        return;
      }
      zzNS = paramBoolean;
    }
  }
  
  public final void zzF(boolean paramBoolean)
  {
    synchronized (zzpV)
    {
      zzNX = paramBoolean;
      return;
    }
  }
  
  public final void zza(AdSizeParcel paramAdSizeParcel)
  {
    synchronized (zzpV)
    {
      zzCh = paramAdSizeParcel;
      requestLayout();
      return;
    }
  }
  
  public final void zza(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = zzr.zzbC().zzG(paramMap);
      zzb(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      zzin.zzaK("Could not convert parameters to JSON.");
    }
  }
  
  public final void zzaL(String paramString)
  {
    synchronized (zzpV)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          zzin.zzaK("Could not call loadUrl. " + paramString);
        }
      }
    }
  }
  
  public final AdSizeParcel zzaN()
  {
    synchronized (zzpV)
    {
      AdSizeParcel localAdSizeParcel = zzCh;
      return localAdSizeParcel;
    }
  }
  
  public final void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzpV)
    {
      zzNR = paramzzd;
      return;
    }
  }
  
  /* Error */
  public final void zzb(String paramString, org.json.JSONObject arg2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull +11 -> 14
    //   6: new 792	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 793	org/json/JSONObject:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 794	org/json/JSONObject:toString	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 572	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 795	java/lang/StringBuilder:<init>	()V
    //   26: astore_3
    //   27: aload_3
    //   28: ldc_w 797
    //   31: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc_w 799
    //   45: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: ldc_w 801
    //   53: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: ldc_w 803
    //   67: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: new 572	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 805
    //   78: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_3
    //   82: invokevirtual 584	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 584	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 532	com/google/android/gms/internal/zzin:v	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 584	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_1
    //   99: bipush 19
    //   101: invokestatic 198	com/google/android/gms/internal/zzne:zzcp	(I)Z
    //   104: ifeq +140 -> 244
    //   107: aload_0
    //   108: invokespecial 807	com/google/android/gms/internal/zzjt:zzhg	()Ljava/lang/Boolean;
    //   111: ifnonnull +47 -> 158
    //   114: aload_0
    //   115: getfield 77	com/google/android/gms/internal/zzjt:zzpV	Ljava/lang/Object;
    //   118: astore_2
    //   119: aload_2
    //   120: monitorenter
    //   121: aload_0
    //   122: invokestatic 294	com/google/android/gms/ads/internal/zzr:zzbF	()Lcom/google/android/gms/internal/zzih;
    //   125: invokevirtual 808	com/google/android/gms/internal/zzih:zzhg	()Ljava/lang/Boolean;
    //   128: putfield 290	com/google/android/gms/internal/zzjt:zzLB	Ljava/lang/Boolean;
    //   131: aload_0
    //   132: getfield 290	com/google/android/gms/internal/zzjt:zzLB	Ljava/lang/Boolean;
    //   135: astore_3
    //   136: aload_3
    //   137: ifnonnull +19 -> 156
    //   140: aload_0
    //   141: ldc_w 810
    //   144: aconst_null
    //   145: invokevirtual 811	com/google/android/gms/internal/zzjt:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   148: aload_0
    //   149: iconst_1
    //   150: invokestatic 817	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   153: invokespecial 819	com/google/android/gms/internal/zzjt:zzb	(Ljava/lang/Boolean;)V
    //   156: aload_2
    //   157: monitorexit
    //   158: aload_0
    //   159: invokespecial 807	com/google/android/gms/internal/zzjt:zzhg	()Ljava/lang/Boolean;
    //   162: invokevirtual 822	java/lang/Boolean:booleanValue	()Z
    //   165: ifeq +57 -> 222
    //   168: aload_0
    //   169: getfield 77	com/google/android/gms/internal/zzjt:zzpV	Ljava/lang/Object;
    //   172: astore_2
    //   173: aload_2
    //   174: monitorenter
    //   175: aload_0
    //   176: invokevirtual 277	com/google/android/gms/internal/zzjt:isDestroyed	()Z
    //   179: ifne +29 -> 208
    //   182: aload_0
    //   183: aload_1
    //   184: aconst_null
    //   185: invokevirtual 811	com/google/android/gms/internal/zzjt:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   188: aload_2
    //   189: monitorexit
    //   190: return
    //   191: astore_3
    //   192: aload_0
    //   193: iconst_0
    //   194: invokestatic 817	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   197: invokespecial 819	com/google/android/gms/internal/zzjt:zzb	(Ljava/lang/Boolean;)V
    //   200: goto -44 -> 156
    //   203: astore_1
    //   204: aload_2
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    //   208: ldc_w 282
    //   211: invokestatic 287	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   214: goto -26 -> 188
    //   217: astore_1
    //   218: aload_2
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: aload_0
    //   223: new 572	java/lang/StringBuilder
    //   226: dup
    //   227: ldc_w 824
    //   230: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 584	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 826	com/google/android/gms/internal/zzjt:zzaO	(Ljava/lang/String;)V
    //   243: return
    //   244: aload_0
    //   245: new 572	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 824
    //   252: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload_1
    //   256: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 584	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokespecial 826	com/google/android/gms/internal/zzjt:zzaO	(Ljava/lang/String;)V
    //   265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	zzjt
    //   0	266	1	paramString	String
    //   1	136	3	localObject	Object
    //   191	1	3	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   140	156	191	java/lang/IllegalStateException
    //   121	136	203	finally
    //   140	156	203	finally
    //   156	158	203	finally
    //   192	200	203	finally
    //   204	206	203	finally
    //   175	188	217	finally
    //   188	190	217	finally
    //   208	214	217	finally
    //   218	220	217	finally
  }
  
  public final void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzpV)
    {
      zzOd = paramzzd;
      return;
    }
  }
  
  public final boolean zzfL()
  {
    synchronized (zzpV)
    {
      zzbx.zza(zzOb.zzpe, zzNY, new String[] { "aebb" });
      boolean bool = zzNX;
      return bool;
    }
  }
  
  public final void zzfr()
  {
    if (zzNY == null)
    {
      zzbx.zza(zzOb.zzpe, zzOa, new String[] { "aes" });
      zzNY = zzbx.zzb(zzOb.zzpe);
      zzOb.zza("native:view_show", zzNY);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzpT.afmaVersion);
    zza("onshow", localHashMap);
  }
  
  public final void zzhN()
  {
    zzip();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzpT.afmaVersion);
    zza("onhide", localHashMap);
  }
  
  public final Activity zzhP()
  {
    return zzNP.zzMM;
  }
  
  public final Context zzhQ()
  {
    return zzNP.zzOg;
  }
  
  public final com.google.android.gms.ads.internal.zzd zzhR()
  {
    return zzpm;
  }
  
  public final com.google.android.gms.ads.internal.overlay.zzd zzhS()
  {
    synchronized (zzpV)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzNR;
      return localzzd;
    }
  }
  
  public final com.google.android.gms.ads.internal.overlay.zzd zzhT()
  {
    synchronized (zzpV)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzOd;
      return localzzd;
    }
  }
  
  public final zzjq zzhU()
  {
    return zzNQ;
  }
  
  public final boolean zzhV()
  {
    return zzNS;
  }
  
  public final zzan zzhW()
  {
    return zzyt;
  }
  
  public final VersionInfoParcel zzhX()
  {
    return zzpT;
  }
  
  public final boolean zzhY()
  {
    synchronized (zzpV)
    {
      boolean bool = zzNU;
      return bool;
    }
  }
  
  public final void zzhZ()
  {
    synchronized (zzpV)
    {
      zzin.v("Destroying WebView!");
      zzir.zzMc.post(new Runnable()
      {
        public final void run()
        {
          zzjt.zza(zzjt.this);
        }
      });
      return;
    }
  }
  
  public final zzjo zzia()
  {
    return null;
  }
  
  public final zzbz zzib()
  {
    return zzOa;
  }
  
  public final zzca zzic()
  {
    return zzOb;
  }
  
  public final void zzid()
  {
    zzjc localzzjc = zzrV;
    zzMP = true;
    if (zzMO) {
      localzzjc.zzhG();
    }
  }
  
  public final void zzie()
  {
    if (zzOa == null)
    {
      zzOa = zzbx.zzb(zzOb.zzpe);
      zzOb.zza("native:view_load", zzOa);
    }
  }
  
  public final void zzy(int paramInt)
  {
    zzip();
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", zzpT.afmaVersion);
    zza("onhide", localHashMap);
  }
  
  @zzhb
  public static final class zza
    extends MutableContextWrapper
  {
    Activity zzMM;
    Context zzOg;
    private Context zzsa;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public final Object getSystemService(String paramString)
    {
      return zzOg.getSystemService(paramString);
    }
    
    public final void setBaseContext(Context paramContext)
    {
      zzsa = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        zzMM = localActivity;
        zzOg = paramContext;
        super.setBaseContext(zzsa);
        return;
      }
    }
    
    public final void startActivity(Intent paramIntent)
    {
      if ((zzMM != null) && (!zzne.zzcp(21)))
      {
        zzMM.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      zzsa.startActivity(paramIntent);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */