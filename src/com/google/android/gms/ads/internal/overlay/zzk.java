package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.HashMap;

@zzhb
public final class zzk
  extends FrameLayout
{
  final FrameLayout zzEN;
  public final zzu zzEO;
  public zzi zzEP;
  public boolean zzEQ;
  public boolean zzER;
  TextView zzES;
  long zzET;
  private String zzEV;
  public final zzjp zzpD;
  public String zzzK;
  
  public zzk(Context paramContext, zzjp paramzzjp)
  {
    super(paramContext);
    zzpD = paramzzjp;
    zzEN = new FrameLayout(paramContext);
    addView(zzEN, new FrameLayout.LayoutParams(-1, -1));
    zzb.zzv(paramzzjp.zzhR());
    zzEP = zzhRzzpx.zza$6b8130d6();
    if (zzEP != null) {
      zzEN.addView(zzEP, new FrameLayout.LayoutParams(-1, -1, 17));
    }
    zzES = new TextView(paramContext);
    zzES.setBackgroundColor(-16777216);
    if (!zzfI())
    {
      zzEN.addView(zzES, new FrameLayout.LayoutParams(-1, -1));
      zzEN.bringChildToFront(zzES);
    }
    zzEO = new zzu(this);
    zzEO.zzfQ();
    if (zzEP == null) {
      zza("error", new String[] { "what", "AdVideoUnderlay Error", "extra", "Allocating player failed." });
    }
  }
  
  public static void zzg(zzjp paramzzjp)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzzjp.zza("onVideoEvent", localHashMap);
  }
  
  public final void setMimeType(String paramString)
  {
    zzEV = paramString;
  }
  
  final void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    zzpD.zza("onVideoEvent", localHashMap);
  }
  
  public final void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    zzEN.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public final void zzfD()
  {
    if (zzEP == null) {
      return;
    }
    if (!TextUtils.isEmpty(zzzK))
    {
      zzEP.setMimeType(zzEV);
      zzEP.setVideoPath(zzzK);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public final void zzfE()
  {
    if (zzEP == null) {
      return;
    }
    TextView localTextView = new TextView(zzEP.getContext());
    localTextView.setText("AdMob - " + zzEP.zzeZ());
    localTextView.setTextColor(-65536);
    localTextView.setBackgroundColor(65280);
    zzEN.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
    zzEN.bringChildToFront(localTextView);
  }
  
  final boolean zzfI()
  {
    return zzES.getParent() != null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */