package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public final class zzd$zzc
{
  public final Context context;
  public final int index;
  public final ViewGroup.LayoutParams zzEw;
  public final ViewGroup zzEx;
  
  public zzd$zzc(zzjp paramzzjp)
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

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */