package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

@zzhb
public final class zzjo
{
  final Context mContext;
  zzk zzFo;
  final ViewGroup zzNx;
  final zzjp zzpD;
  
  public zzjo(Context paramContext, ViewGroup paramViewGroup, zzjp paramzzjp)
  {
    this(paramContext, paramViewGroup, paramzzjp, (byte)0);
  }
  
  private zzjo(Context paramContext, ViewGroup paramViewGroup, zzjp paramzzjp, byte paramByte)
  {
    mContext = paramContext;
    zzNx = paramViewGroup;
    zzpD = paramzzjp;
    zzFo = null;
  }
  
  public final zzk zzhM()
  {
    zzx.zzcD("getAdVideoUnderlay must be called from the UI thread.");
    return zzFo;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */