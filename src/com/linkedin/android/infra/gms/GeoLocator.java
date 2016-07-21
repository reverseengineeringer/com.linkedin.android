package com.linkedin.android.infra.gms;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.linkedin.android.infra.shared.KitKatUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class GeoLocator
{
  private static final String TAG = GeoLocator.class.getSimpleName();
  private Context context;
  private GeoLocatorListener geoLocatorListener;
  private GoogleApiClient googleApiClient;
  private android.location.LocationListener locationListener;
  private final LocationManager locationManager;
  private GeoLocator.PlayServiceListener playServiceListener;
  
  @Inject
  public GeoLocator(Context paramContext)
  {
    context = paramContext;
    locationManager = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  private Address getAddressFromLocation(Location paramLocation)
  {
    if (!Geocoder.isPresent()) {
      return null;
    }
    Object localObject = new Geocoder(context, context.getResources().getConfiguration().locale);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject = ((Geocoder)localObject).getFromLocation(paramLocation.getLatitude(), paramLocation.getLongitude(), 1);
      paramLocation = (Location)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e(TAG, "Geocoder failed to get address from location: " + paramLocation.toString(), localIOException);
        paramLocation = localArrayList;
      }
    }
    if (paramLocation.isEmpty()) {
      return null;
    }
    return (Address)paramLocation.get(0);
  }
  
  private void getLocationFromLocationManager()
  {
    int i = 0;
    if (i < 2)
    {
      String str = new String[] { "gps", "network" }[i];
      if (!locationManager.isProviderEnabled(str)) {
        Log.d(TAG, str + " is not enabled; skipping...");
      }
      for (;;)
      {
        i += 1;
        break;
        Location localLocation = locationManager.getLastKnownLocation(str);
        if ((localLocation != null) && (!isLocationOutdated(localLocation)))
        {
          geoLocatorListener.handleAddress(getAddressFromLocation(localLocation));
        }
        else
        {
          if (locationListener == null) {
            locationListener = new GeoLocator.1(this);
          }
          locationManager.requestLocationUpdates(str, 0L, 0.0F, locationListener);
        }
      }
    }
  }
  
  private static boolean isLocationOutdated(Location paramLocation)
  {
    return System.currentTimeMillis() - paramLocation.getTime() > TimeUnit.HOURS.toMillis(1L);
  }
  
  private void lookupLocationByFusedLocationApi(com.google.android.gms.location.LocationListener paramLocationListener)
  {
    Object localObject = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
    if ((localObject != null) && (!isLocationOutdated((Location)localObject)))
    {
      geoLocatorListener.handleAddress(getAddressFromLocation((Location)localObject));
      return;
    }
    Log.d(TAG, "Send a request for location updates");
    localObject = LocationRequest.create();
    mPriority = 100;
    LocationRequest.zzL$1349ef();
    zzaNY = 0L;
    if (!zzaBr) {
      zzaNZ = ((zzaNY / 6.0D));
    }
    LocationRequest.zzL$1349ef();
    zzaBr = true;
    zzaNZ = 0L;
    LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, (LocationRequest)localObject, paramLocationListener);
  }
  
  public final void start(GeoLocatorListener paramGeoLocatorListener)
  {
    int j = 0;
    for (;;)
    {
      boolean bool;
      try
      {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Missing Location Permission"));
          return;
        }
        geoLocatorListener = paramGeoLocatorListener;
        bool = KitKatUtils.isLocationDisabled(context.getContentResolver());
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
          break label83;
        }
        i = 1;
      }
      finally {}
      geoLocatorListener.onLocationServiceDisabled();
      continue;
      label83:
      int i = 0;
      while (!bool)
      {
        if (i != 0)
        {
          i = 1;
          break label214;
        }
        i = 2;
        break label214;
        if (googleApiClient == null)
        {
          playServiceListener = new GeoLocator.PlayServiceListener(this, (byte)0);
          paramGeoLocatorListener = playServiceListener;
          googleApiClient = new GoogleApiClient.Builder(context).addApi(LocationServices.API).addConnectionCallbacks(paramGeoLocatorListener).addOnConnectionFailedListener(paramGeoLocatorListener).build();
        }
        if (googleApiClient.isConnected())
        {
          lookupLocationByFusedLocationApi(playServiceListener);
          break;
        }
        if (googleApiClient.isConnecting()) {
          break;
        }
        googleApiClient.connect();
        break;
        getLocationFromLocationManager();
        break;
      }
      i = j;
      label214:
      switch (i)
      {
      }
    }
  }
  
  /* Error */
  public final void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/linkedin/android/infra/gms/GeoLocator:context	Landroid/content/Context;
    //   6: ldc_w 268
    //   9: invokestatic 274	android/support/v4/content/ContextCompat:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   12: iconst_m1
    //   13: if_icmpne +19 -> 32
    //   16: new 276	java/lang/RuntimeException
    //   19: dup
    //   20: ldc_w 278
    //   23: invokespecial 279	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   26: invokestatic 285	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 88	com/linkedin/android/infra/gms/GeoLocator:googleApiClient	Lcom/google/android/gms/common/api/GoogleApiClient;
    //   36: ifnull +47 -> 83
    //   39: aload_0
    //   40: getfield 88	com/linkedin/android/infra/gms/GeoLocator:googleApiClient	Lcom/google/android/gms/common/api/GoogleApiClient;
    //   43: invokevirtual 336	com/google/android/gms/common/api/GoogleApiClient:isConnected	()Z
    //   46: ifeq +37 -> 83
    //   49: getstatic 60	com/google/android/gms/location/LocationServices:FusedLocationApi	Lcom/google/android/gms/location/FusedLocationProviderApi;
    //   52: aload_0
    //   53: getfield 88	com/linkedin/android/infra/gms/GeoLocator:googleApiClient	Lcom/google/android/gms/common/api/GoogleApiClient;
    //   56: aload_0
    //   57: getfield 92	com/linkedin/android/infra/gms/GeoLocator:playServiceListener	Lcom/linkedin/android/infra/gms/GeoLocator$PlayServiceListener;
    //   60: invokeinterface 349 3 0
    //   65: pop
    //   66: aload_0
    //   67: getfield 88	com/linkedin/android/infra/gms/GeoLocator:googleApiClient	Lcom/google/android/gms/common/api/GoogleApiClient;
    //   70: invokevirtual 352	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 88	com/linkedin/android/infra/gms/GeoLocator:googleApiClient	Lcom/google/android/gms/common/api/GoogleApiClient;
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 92	com/linkedin/android/infra/gms/GeoLocator:playServiceListener	Lcom/linkedin/android/infra/gms/GeoLocator$PlayServiceListener;
    //   83: aload_0
    //   84: getfield 74	com/linkedin/android/infra/gms/GeoLocator:locationListener	Landroid/location/LocationListener;
    //   87: ifnull +19 -> 106
    //   90: aload_0
    //   91: getfield 50	com/linkedin/android/infra/gms/GeoLocator:locationManager	Landroid/location/LocationManager;
    //   94: aload_0
    //   95: getfield 74	com/linkedin/android/infra/gms/GeoLocator:locationListener	Landroid/location/LocationListener;
    //   98: invokevirtual 356	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 74	com/linkedin/android/infra/gms/GeoLocator:locationListener	Landroid/location/LocationListener;
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 64	com/linkedin/android/infra/gms/GeoLocator:geoLocatorListener	Lcom/linkedin/android/infra/gms/GeoLocatorListener;
    //   111: goto -82 -> 29
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	GeoLocator
    //   114	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	114	finally
    //   32	83	114	finally
    //   83	106	114	finally
    //   106	111	114	finally
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.gms.GeoLocator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */