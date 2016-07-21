package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc.zza;
import com.google.android.gms.location.zzd.zza;
import java.util.HashMap;
import java.util.Map;

public final class zzk
{
  private final Context mContext;
  ContentProviderClient zzaOG = null;
  boolean zzaOH = false;
  Map<Object, zza> zzaOI = new HashMap();
  final zzp<zzi> zzaOt;
  Map<LocationListener, zzc> zzaxd = new HashMap();
  
  public zzk(Context paramContext, zzp<zzi> paramzzp)
  {
    mContext = paramContext;
    zzaOt = paramzzp;
  }
  
  public final Location getLastLocation()
  {
    zzaOt.zzqI();
    try
    {
      Location localLocation = ((zzi)zzaOt.zzqJ()).zzei(mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  final zzc zza$75719f23(LocationListener paramLocationListener)
  {
    synchronized (zzaxd)
    {
      zzc localzzc2 = (zzc)zzaxd.get(paramLocationListener);
      zzc localzzc1 = localzzc2;
      if (localzzc2 == null) {
        localzzc1 = new zzc(paramLocationListener);
      }
      zzaxd.put(paramLocationListener, localzzc1);
      return localzzc1;
    }
  }
  
  private static final class zza
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
  
  private static final class zzb
    extends Handler
  {
    private final LocationListener zzaOL;
    
    public zzb(LocationListener paramLocationListener)
    {
      zzaOL = paramLocationListener;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      paramMessage = new Location((Location)obj);
      zzaOL.onLocationChanged(paramMessage);
    }
  }
  
  private static final class zzc
    extends zzd.zza
  {
    Handler zzaOJ;
    
    zzc(LocationListener paramLocationListener)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */