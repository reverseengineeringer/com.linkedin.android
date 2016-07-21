package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;
import java.lang.reflect.Method;

@zzhb
public final class zza
{
  public static final Handler zzMS = new Handler(Looper.getMainLooper());
  private static final String zzMT = AdView.class.getName();
  private static final String zzMU = InterstitialAd.class.getName();
  private static final String zzMV = PublisherAdView.class.getName();
  private static final String zzMW = PublisherInterstitialAd.class.getName();
  private static final String zzMX = SearchAdView.class.getName();
  private static final String zzMY = AdLoader.class.getName();
  
  public static boolean zzV(Context paramContext)
  {
    if (getResourcesgetConfigurationorientation != 2) {}
    do
    {
      return false;
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while ((int)(heightPixels / density) >= 600);
    return true;
  }
  
  public static boolean zzW(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    int i;
    if (zzne.zzcp(17))
    {
      paramContext.getRealMetrics(localDisplayMetrics);
      j = heightPixels;
      i = widthPixels;
    }
    for (;;)
    {
      paramContext.getMetrics(localDisplayMetrics);
      int k = heightPixels;
      int m = widthPixels;
      if ((k == j) && (m == i))
      {
        return true;
        try
        {
          j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          i = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        }
        catch (Exception paramContext)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  public static int zzX(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public static int zzb(Context paramContext, int paramInt)
  {
    return zza(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return Math.round(paramInt / density);
  }
  
  public static int zzc(Context paramContext, int paramInt)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return zzb(localDisplayMetrics, paramInt);
  }
  
  public static boolean zzhJ()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */