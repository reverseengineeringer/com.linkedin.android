package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.zzc;

abstract class zzn
  extends BroadcastReceiver
{
  protected Context mContext;
  
  public static <T extends zzn> T zza(Context paramContext, T paramT)
  {
    zzc.zzoK();
    return zza$245690a7(paramContext, paramT);
  }
  
  public static <T extends zzn> T zza$245690a7(Context paramContext, T paramT)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    paramContext.registerReceiver(paramT, (IntentFilter)localObject);
    mContext = paramContext;
    localObject = paramT;
    if (!zzc.zzi(paramContext, "com.google.android.gms"))
    {
      paramT.zzpJ();
      paramT.unregister();
      localObject = null;
    }
    return (T)localObject;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      zzpJ();
      unregister();
    }
  }
  
  public final void unregister()
  {
    try
    {
      if (mContext != null) {
        mContext.unregisterReceiver(this);
      }
      mContext = null;
      return;
    }
    finally {}
  }
  
  protected abstract void zzpJ();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */