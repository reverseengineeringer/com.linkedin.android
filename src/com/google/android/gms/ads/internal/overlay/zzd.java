package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzfv.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjq.zza;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import java.util.Collections;

@zzhb
public final class zzd
  extends zzfv.zza
  implements zzs
{
  static final int zzEg = Color.argb(0, 0, 0, 0);
  public final Activity mActivity;
  public RelativeLayout zzDm;
  AdOverlayInfoParcel zzEh;
  zzc zzEi;
  public zzo zzEj;
  public boolean zzEk = false;
  public FrameLayout zzEl;
  public WebChromeClient.CustomViewCallback zzEm;
  boolean zzEn = false;
  boolean zzEo = false;
  public boolean zzEp = false;
  int zzEq = 0;
  zzl zzEr;
  public boolean zzEs;
  private boolean zzEt = false;
  private boolean zzEu = true;
  zzjp zzpD;
  
  public zzd(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzEr = new zzq();
  }
  
  private void zzfp()
  {
    if ((!mActivity.isFinishing()) || (zzEt)) {
      return;
    }
    zzEt = true;
    if (zzpD != null)
    {
      int i = zzEq;
      zzpD.zzy(i);
      zzDm.removeView(zzpD.getView());
      if (zzEi == null) {
        break label167;
      }
      zzpD.setContext(zzEi.context);
      zzpD.zzD(false);
      zzEi.zzEx.addView(zzpD.getView(), zzEi.index, zzEi.zzEw);
      zzEi = null;
    }
    for (;;)
    {
      zzpD = null;
      if ((zzEh == null) || (zzEh.zzEC == null)) {
        break;
      }
      zzEh.zzEC.zzaW();
      return;
      label167:
      if (mActivity.getApplicationContext() != null) {
        zzpD.setContext(mActivity.getApplicationContext());
      }
    }
  }
  
  private void zzx(boolean paramBoolean)
    throws zzd.zza
  {
    zzm localzzm = null;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!zzEs) {
      mActivity.requestWindowFeature(1);
    }
    Object localObject = mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!zzEo) || ((zzEh.zzEM != null) && (zzEh.zzEM.zzqm))) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    boolean bool3 = zzEh.zzED.zzhU().zzcv();
    zzEp = false;
    if (bool3)
    {
      if (zzEh.orientation == zzr.zzbE().zzhv())
      {
        if (mActivity.getResources().getConfiguration().orientation == 1) {
          bool1 = true;
        }
        zzEp = bool1;
      }
    }
    else
    {
      zzin.zzaI("Delay onShow to next orientation change: " + zzEp);
      setRequestedOrientation(zzEh.orientation);
      if (zzr.zzbE().zza((Window)localObject)) {
        zzin.zzaI("Hardware acceleration on the AdActivity window enabled.");
      }
      if (zzEo) {
        break label661;
      }
      zzDm.setBackgroundColor(-16777216);
      label222:
      mActivity.setContentView(zzDm);
      zzEs = true;
      if (!paramBoolean) {
        break label728;
      }
      zzr.zzbD();
      localObject = new zzjs(zzjt.zzb$44e1b059$6f32e7e1(mActivity, zzEh.zzED.zzaN(), zzEh.zzrl, zzEh.zzED.zzhR()));
      ((zzjp)localObject).setWebViewClient(zzr.zzbE().zzb((zzjp)localObject, bool3));
      ((zzjp)localObject).setWebChromeClient(zzr.zzbE().zzk((zzjp)localObject));
      zzpD = ((zzjp)localObject);
      zzpD.zzhU().zzb$45b6a852(zzEh.zzEE, zzEh.zzEI, zzEh.zzEK, zzEh.zzED.zzhU().zzzA);
      zzpD.zzhU().zzGm = new zzjq.zza()
      {
        public final void zza$7d63705e(zzjp paramAnonymouszzjp)
        {
          paramAnonymouszzjp.zzfr();
        }
      };
      if (zzEh.url == null) {
        break label674;
      }
      zzpD.loadUrl(zzEh.url);
      label425:
      if (zzEh.zzED != null) {
        zzEh.zzED.zzc(this);
      }
    }
    for (;;)
    {
      zzpD.zzb(this);
      localObject = zzpD.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(zzpD.getView());
      }
      if (zzEo) {
        zzpD.setBackgroundColor(zzEg);
      }
      zzDm.addView(zzpD.getView(), -1, -1);
      if ((!paramBoolean) && (!zzEp)) {
        zzfr();
      }
      zzw(bool3);
      if (zzpD.zzhV()) {
        zza(bool3, true);
      }
      localObject = zzpD.zzhR();
      if (localObject != null) {
        localzzm = zzpy;
      }
      if (localzzm == null) {
        break label755;
      }
      zzEr = localzzm.zza$7d4afbc5();
      return;
      if (zzEh.orientation != zzr.zzbE().zzhw()) {
        break;
      }
      bool1 = bool2;
      if (mActivity.getResources().getConfiguration().orientation == 2) {
        bool1 = true;
      }
      zzEp = bool1;
      break;
      label661:
      zzDm.setBackgroundColor(zzEg);
      break label222;
      label674:
      if (zzEh.zzEH != null)
      {
        zzpD.loadDataWithBaseURL(zzEh.zzEF, zzEh.zzEH, "text/html", "UTF-8", null);
        break label425;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      label728:
      zzpD = zzEh.zzED;
      zzpD.setContext(mActivity);
    }
    label755:
    zzin.zzaK("Appstreaming controller is null.");
  }
  
  public final void close()
  {
    zzEq = 2;
    mActivity.finish();
  }
  
  public final void onBackPressed()
  {
    zzEq = 0;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    zzEn = bool;
    try
    {
      zzEh = AdOverlayInfoParcel.zzb(mActivity.getIntent());
      if (zzEh != null) {
        break label73;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzin.zzaK(paramBundle.getMessage());
      zzEq = 3;
      mActivity.finish();
    }
    return;
    label73:
    if (zzEh.zzrl.zzNa > 7500000) {
      zzEq = 3;
    }
    if (mActivity.getIntent() != null) {
      zzEu = mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    label146:
    Object localObject;
    if (zzEh.zzEM != null)
    {
      zzEo = zzEh.zzEM.zzql;
      localObject = zzbt.zzxe;
      if ((((Boolean)zzr.zzbL().zzd((zzbp)localObject)).booleanValue()) && (zzEo) && (zzEh.zzEM.zzqn != null)) {
        new zzd((byte)0).zzhn();
      }
      if (paramBundle == null)
      {
        if ((zzEh.zzEC != null) && (zzEu)) {
          zzEh.zzEC.zzaX();
        }
        if ((zzEh.zzEJ != 1) && (zzEh.zzEB != null)) {
          paramBundle = zzEh.zzEB;
        }
      }
      zzDm = new zzb(mActivity, zzEh.zzEL);
      zzDm.setId(1000);
      switch (zzEh.zzEJ)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      zzEo = false;
      break label146;
      zzx(false);
      return;
      zzEi = new zzc(zzEh.zzED);
      zzx(false);
      return;
      zzx(true);
      return;
      if (zzEn)
      {
        zzEq = 3;
        mActivity.finish();
        return;
      }
      zzr.zzbz();
      paramBundle = mActivity;
      localObject = zzEh.zzEA;
      zzp localzzp = zzEh.zzEI;
      if (zza.zza$1d984e39(paramBundle, (AdLauncherIntentInfoParcel)localObject)) {
        break;
      }
      zzEq = 3;
      mActivity.finish();
      return;
    }
  }
  
  public final void onDestroy()
  {
    if (zzpD != null) {
      zzDm.removeView(zzpD.getView());
    }
    zzfp();
  }
  
  public final void onPause()
  {
    zzfl();
    Object localObject;
    if (zzEh.zzEC != null) {
      localObject = zzEh.zzEC;
    }
    if ((zzpD != null) && ((!mActivity.isFinishing()) || (zzEi == null)))
    {
      zzr.zzbE();
      localObject = zzpD;
      if (localObject != null) {
        ((zzjp)localObject).onPause();
      }
    }
    zzfp();
  }
  
  public final void onRestart() {}
  
  public final void onResume()
  {
    if ((zzEh != null) && (zzEh.zzEJ == 4))
    {
      if (!zzEn) {
        break label94;
      }
      zzEq = 3;
      mActivity.finish();
    }
    for (;;)
    {
      if (zzEh.zzEC != null) {
        localObject = zzEh.zzEC;
      }
      if ((zzpD == null) || (zzpD.isDestroyed())) {
        break;
      }
      zzr.zzbE();
      Object localObject = zzpD;
      if (localObject != null) {
        ((zzjp)localObject).onResume();
      }
      return;
      label94:
      zzEn = true;
    }
    zzin.zzaK("The webview does not exit. Ignoring action.");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", zzEn);
  }
  
  public final void onStart() {}
  
  public final void onStop()
  {
    zzfp();
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    mActivity.setRequestedOrientation(paramInt);
  }
  
  public final void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (zzEj != null) {
      zzEj.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public final void zzaD()
  {
    zzEs = true;
  }
  
  public final void zzfl()
  {
    if ((zzEh != null) && (zzEk)) {
      setRequestedOrientation(zzEh.orientation);
    }
    if (zzEl != null)
    {
      mActivity.setContentView(zzDm);
      zzEs = true;
      zzEl.removeAllViews();
      zzEl = null;
    }
    if (zzEm != null)
    {
      zzEm.onCustomViewHidden();
      zzEm = null;
    }
    zzEk = false;
  }
  
  public final void zzfm()
  {
    zzEq = 1;
    mActivity.finish();
  }
  
  public final boolean zzfn()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    zzEq = 0;
    if (zzpD == null) {
      return bool2;
    }
    if (zzpD.zzfL()) {}
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      zzpD.zza("onbackblocked", Collections.emptyMap());
      return bool1;
      bool1 = false;
    }
  }
  
  public final void zzfr()
  {
    zzpD.zzfr();
  }
  
  public final void zzw(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      zzEj = new zzo(mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      zzEj.zza(paramBoolean, zzEh.zzEG);
      zzDm.addView(zzEj, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  @zzhb
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzhb
  static final class zzb
    extends RelativeLayout
  {
    zziu zzrU;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      zzrU = new zziu(paramContext, paramString);
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      zziu localzziu = zzrU;
      int j = paramMotionEvent.getHistorySize();
      int i = 0;
      while (i < j)
      {
        localzziu.zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
        i += 1;
      }
      localzziu.zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
      return false;
    }
  }
  
  @zzhb
  public static final class zzc
  {
    public final Context context;
    public final int index;
    public final ViewGroup.LayoutParams zzEw;
    public final ViewGroup zzEx;
    
    public zzc(zzjp paramzzjp)
      throws zzd.zza
    {
      zzEw = paramzzjp.getLayoutParams();
      ViewParent localViewParent = paramzzjp.getParent();
      context = paramzzjp.zzhQ();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        zzEx = ((ViewGroup)localViewParent);
        index = zzEx.indexOfChild(paramzzjp.getView());
        zzEx.removeView(paramzzjp.getView());
        paramzzjp.zzD(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzhb
  private final class zzd
    extends zzim
  {
    private zzd() {}
    
    public final void zzbr()
    {
      zzr.zzbC();
      final Object localObject = zzir.zzf(zzd.zza(zzd.this), zzEh.zzEM.zzqn);
      if (localObject != null)
      {
        localObject = zzr.zzbE().zza(zzd.zza(zzd.this), (Bitmap)localObject, zzEh.zzEM.zzqo, zzEh.zzEM.zzqp);
        zzir.zzMc.post(new Runnable()
        {
          public final void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localObject);
          }
        });
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */