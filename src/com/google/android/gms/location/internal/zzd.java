package com.google.android.gms.location.internal;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.zza;

public final class zzd
  implements FusedLocationProviderApi
{
  public final Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzi(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = zzaOM.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public final PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient) {});
  }
  
  public final PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient) {});
  }
  
  private static abstract class zza
    extends LocationServices.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
  }
  
  private static final class zzb
    extends zzg.zza
  {
    private final zza.zzb<Status> zzamC;
    
    public zzb(zza.zzb<Status> paramzzb)
    {
      zzamC = paramzzb;
    }
    
    public final void zza(FusedLocationProviderResult paramFusedLocationProviderResult)
    {
      zzamC.zzs(zzUX);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */