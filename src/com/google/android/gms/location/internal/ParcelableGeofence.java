package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class ParcelableGeofence
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  final int mVersionCode;
  final String zzEY;
  final int zzaNC;
  final short zzaNE;
  final double zzaNF;
  final double zzaNG;
  final float zzaNH;
  final int zzaNI;
  final int zzaNJ;
  final long zzaOZ;
  
  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
    int i = paramInt2 & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt2);
    }
    mVersionCode = paramInt1;
    zzaNE = paramShort;
    zzEY = paramString;
    zzaNF = paramDouble1;
    zzaNG = paramDouble2;
    zzaNH = paramFloat;
    zzaOZ = paramLong;
    zzaNC = i;
    zzaNI = paramInt3;
    zzaNJ = paramInt4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof ParcelableGeofence)) {
        return false;
      }
      paramObject = (ParcelableGeofence)paramObject;
      if (zzaNH != zzaNH) {
        return false;
      }
      if (zzaNF != zzaNF) {
        return false;
      }
      if (zzaNG != zzaNG) {
        return false;
      }
    } while (zzaNE == zzaNE);
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(zzaNF);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(zzaNG);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(zzaNH)) * 31 + zzaNE) * 31 + zzaNC;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    switch (zzaNE)
    {
    }
    for (String str = null;; str = "CIRCLE") {
      return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { str, zzEY, Integer.valueOf(zzaNC), Double.valueOf(zzaNF), Double.valueOf(zzaNG), Float.valueOf(zzaNH), Integer.valueOf(zzaNI / 1000), Integer.valueOf(zzaNJ), Long.valueOf(zzaOZ) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza$3125d07d(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.ParcelableGeofence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */