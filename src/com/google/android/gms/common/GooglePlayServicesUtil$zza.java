package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class GooglePlayServicesUtil$zza
  extends Handler
{
  private final Context zzsa;
  
  GooglePlayServicesUtil$zza(Context paramContext) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + what);
    }
    int i;
    do
    {
      return;
      i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzsa);
    } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
    GooglePlayServicesUtil.zzb(i, zzsa);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */