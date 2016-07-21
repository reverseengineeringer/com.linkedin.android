package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzd.zza;

final class zzk$zzc
  extends zzd.zza
{
  Handler zzaOJ;
  
  zzk$zzc(LocationListener paramLocationListener)
  {
    if (Looper.myLooper() != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      zzaOJ = new zzk.zzb(paramLocationListener);
      return;
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (zzaOJ == null)
    {
      Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
      return;
    }
    Message localMessage = Message.obtain();
    what = 1;
    obj = paramLocation;
    zzaOJ.sendMessage(localMessage);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */