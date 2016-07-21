package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;

public final class AdSize
{
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER;
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  public final int zzoG;
  public final int zzoH;
  private final String zzoI;
  
  static
  {
    SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  }
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  public AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1) && (paramInt1 != -3)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2) && (paramInt2 != -4)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    zzoG = paramInt1;
    zzoH = paramInt2;
    zzoI = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      paramObject = (AdSize)paramObject;
    } while ((zzoG == zzoG) && (zzoH == zzoH) && (zzoI.equals(zzoI)));
    return false;
  }
  
  public final int getHeightInPixels(Context paramContext)
  {
    switch (zzoH)
    {
    default: 
      zzn.zzcS();
      return zza.zzb(paramContext, zzoH);
    case -2: 
      return AdSizeParcel.zzb(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public final int getWidthInPixels(Context paramContext)
  {
    switch (zzoG)
    {
    case -2: 
    default: 
      zzn.zzcS();
      return zza.zzb(paramContext, zzoG);
    case -1: 
      return AdSizeParcel.zza(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public final int hashCode()
  {
    return zzoI.hashCode();
  }
  
  public final String toString()
  {
    return zzoI;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */