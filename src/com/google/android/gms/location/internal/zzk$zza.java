package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc.zza;

final class zzk$zza
  extends zzc.zza
{
  private Handler zzaOJ;
  
  private void zzb(int paramInt, Object paramObject)
  {
    if (zzaOJ == null)
    {
      Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
      return;
    }
    Message localMessage = Message.obtain();
    what = paramInt;
    obj = paramObject;
    zzaOJ.sendMessage(localMessage);
  }
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
  {
    zzb(1, paramLocationAvailability);
  }
  
  public final void onLocationResult(LocationResult paramLocationResult)
  {
    zzb(0, paramLocationResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */