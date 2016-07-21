package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public final class zzio
  extends Handler
{
  public zzio(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      zzr.zzbF().zzb(paramMessage, false);
      throw paramMessage;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */