package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@zzhb
public final class zzfn
  extends zzfs
{
  static final Set<String> zzDa = Collections.unmodifiableSet(new zzmm(Arrays.asList(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" })));
  AdSizeParcel zzCh;
  String zzDb = "top-right";
  boolean zzDc = true;
  int zzDd = 0;
  int zzDe = 0;
  int zzDf = 0;
  int zzDg = 0;
  final Activity zzDh;
  ImageView zzDi;
  LinearLayout zzDj;
  private zzft zzDk;
  PopupWindow zzDl;
  RelativeLayout zzDm;
  ViewGroup zzDn;
  int zzoG = -1;
  int zzoH = -1;
  final zzjp zzpD;
  final Object zzpV = new Object();
  
  public zzfn(zzjp paramzzjp)
  {
    super(paramzzjp, "resize");
    zzpD = paramzzjp;
    zzDh = paramzzjp.zzhP();
    zzDk = null;
  }
  
  public final boolean zzeN()
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zzDl != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void zzp(boolean paramBoolean)
  {
    synchronized (zzpV)
    {
      if (zzDl != null)
      {
        zzDl.dismiss();
        zzDm.removeView(zzpD.getView());
        if (zzDn != null)
        {
          zzDn.removeView(zzDi);
          zzDn.addView(zzpD.getView());
          zzpD.zza(zzCh);
        }
        if (paramBoolean) {
          zzao("default");
        }
        zzDl = null;
        zzDm = null;
        zzDn = null;
        zzDj = null;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */