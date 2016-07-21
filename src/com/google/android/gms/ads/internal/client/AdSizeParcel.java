package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class AdSizeParcel
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  public final String zzuh;
  public final boolean zzui;
  public final AdSizeParcel[] zzuj;
  public final boolean zzuk;
  public final boolean zzul;
  public boolean zzum;
  
  public AdSizeParcel()
  {
    this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  AdSizeParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    versionCode = paramInt1;
    zzuh = paramString;
    height = paramInt2;
    heightPixels = paramInt3;
    zzui = paramBoolean1;
    width = paramInt4;
    widthPixels = paramInt5;
    zzuj = paramArrayOfAdSizeParcel;
    zzuk = paramBoolean2;
    zzul = paramBoolean3;
    zzum = paramBoolean4;
  }
  
  public AdSizeParcel(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public AdSizeParcel(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    versionCode = 5;
    zzui = false;
    boolean bool;
    label75:
    int j;
    label86:
    int k;
    label98:
    DisplayMetrics localDisplayMetrics;
    int i;
    label156:
    int m;
    if ((zzoG == -3) && (zzoH == -4))
    {
      bool = true;
      zzul = bool;
      if (!zzul) {
        break label325;
      }
      width = BANNERzzoG;
      height = BANNERzzoH;
      if (width != -1) {
        break label346;
      }
      j = 1;
      if (height != -2) {
        break label352;
      }
      k = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (j == 0) {
        break label370;
      }
      zzn.zzcS();
      if (!zza.zzV(paramContext)) {
        break label358;
      }
      zzn.zzcS();
      if (!zza.zzW(paramContext)) {
        break label358;
      }
      i = widthPixels;
      zzn.zzcS();
      widthPixels = (i - zza.zzX(paramContext));
      double d = widthPixels / density;
      m = (int)d;
      i = m;
      if (d - (int)d >= 0.01D) {
        i = m + 1;
      }
      label195:
      if (k == 0) {
        break label396;
      }
      m = zzc(localDisplayMetrics);
      label207:
      zzn.zzcS();
      heightPixels = zza.zza(localDisplayMetrics, m);
      if ((j == 0) && (k == 0)) {
        break label405;
      }
      zzuh = (i + "x" + m + "_as");
    }
    for (;;)
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label433;
      }
      zzuj = new AdSizeParcel[paramArrayOfAdSize.length];
      i = 0;
      while (i < paramArrayOfAdSize.length)
      {
        zzuj[i] = new AdSizeParcel(paramContext, paramArrayOfAdSize[i]);
        i += 1;
      }
      bool = false;
      break;
      label325:
      width = zzoG;
      height = zzoH;
      break label75;
      label346:
      j = 0;
      break label86;
      label352:
      k = 0;
      break label98;
      label358:
      widthPixels = widthPixels;
      break label156;
      label370:
      i = width;
      zzn.zzcS();
      widthPixels = zza.zza(localDisplayMetrics, width);
      break label195;
      label396:
      m = height;
      break label207;
      label405:
      if (zzul) {
        zzuh = "320x50_mb";
      } else {
        zzuh = localAdSize.toString();
      }
    }
    label433:
    zzuj = null;
    zzuk = false;
    zzum = false;
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics)
  {
    return widthPixels;
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzc(paramDisplayMetrics) * density);
  }
  
  private static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(heightPixels / density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdSizeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */