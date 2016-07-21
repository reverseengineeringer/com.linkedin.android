package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;

class zzr
  extends BroadcastReceiver
{
  static final String zzSZ = zzr.class.getName();
  boolean zzTa;
  boolean zzTb;
  final zzw zzaTV;
  
  zzr(zzw paramzzw)
  {
    zzx.zzz(paramzzw);
    zzaTV = paramzzw;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzaTV.zzjv();
    paramContext = paramIntent.getAction();
    zzaTV.zzAo().zzaWK.zzj("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      final boolean bool = zzaTV.zzCW().zzlB();
      if (zzTb != bool)
      {
        zzTb = bool;
        zzaTV.zzCn().zzg(new Runnable()
        {
          public final void run()
          {
            zzr.zza(zzr.this).zzDe();
          }
        });
      }
      return;
    }
    zzaTV.zzAo().zzaWF.zzj("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public final void unregister()
  {
    zzaTV.zzjv();
    zzaTV.zzCn().zzjk();
    zzaTV.zzCn().zzjk();
    if (!zzTa) {
      return;
    }
    zzaTV.zzAo().zzaWK.zzfg("Unregistering connectivity change receiver");
    zzTa = false;
    zzTb = false;
    Context localContext = zzaTV.mContext;
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzaTV.zzAo().zzaWC.zzj("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */