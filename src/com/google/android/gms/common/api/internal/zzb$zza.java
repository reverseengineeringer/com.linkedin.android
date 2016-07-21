package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public final class zzb$zza<R extends Result>
  extends Handler
{
  public zzb$zza()
  {
    this(Looper.getMainLooper());
  }
  
  public zzb$zza(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.wtf("BasePendingResult", "Don't know how to handle message: " + what, new Exception());
      return;
    case 1: 
      Object localObject = (Pair)obj;
      paramMessage = (ResultCallback)first;
      localObject = (Result)second;
      try
      {
        paramMessage.onResult((Result)localObject);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        throw paramMessage;
      }
    }
    ((zzb)obj).zzx(Status.zzagF);
  }
  
  public final void zza(ResultCallback<? super R> paramResultCallback, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */