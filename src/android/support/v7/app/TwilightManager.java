package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

final class TwilightManager
{
  static final TwilightState sTwilightState = new TwilightState((byte)0);
  final Context mContext;
  private final LocationManager mLocationManager;
  
  TwilightManager(Context paramContext)
  {
    mContext = paramContext;
    mLocationManager = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  static boolean isStateValid(TwilightState paramTwilightState)
  {
    return (paramTwilightState != null) && (nextUpdate > System.currentTimeMillis());
  }
  
  static void updateState(Location paramLocation)
  {
    TwilightState localTwilightState = sTwilightState;
    long l1 = System.currentTimeMillis();
    if (TwilightCalculator.sInstance == null) {
      TwilightCalculator.sInstance = new TwilightCalculator();
    }
    TwilightCalculator localTwilightCalculator = TwilightCalculator.sInstance;
    localTwilightCalculator.calculateTwilight(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = sunset;
    localTwilightCalculator.calculateTwilight(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = sunrise;
      l4 = sunset;
      localTwilightCalculator.calculateTwilight(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = sunrise;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 += 43200000L;
      isNight = bool;
      yesterdaySunset = l2;
      todaySunrise = l3;
      todaySunset = l4;
      tomorrowSunrise = l5;
      nextUpdate = l1;
      return;
    }
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
  }
  
  final Location getLastKnownLocationForProvider(String paramString)
  {
    if (mLocationManager != null) {
      try
      {
        if (mLocationManager.isProviderEnabled(paramString))
        {
          paramString = mLocationManager.getLastKnownLocation(paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.d("TwilightManager", "Failed to get last known location", paramString);
      }
    }
    return null;
  }
  
  private static final class TwilightState
  {
    boolean isNight;
    long nextUpdate;
    long todaySunrise;
    long todaySunset;
    long tomorrowSunrise;
    long yesterdaySunset;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.TwilightManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */