package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public int mPriority;
  final int mVersionCode;
  public boolean zzaBr;
  long zzaND;
  public long zzaNY;
  public long zzaNZ;
  int zzaOa;
  float zzaOb;
  long zzaOc;
  
  public LocationRequest()
  {
    mVersionCode = 1;
    mPriority = 102;
    zzaNY = 3600000L;
    zzaNZ = 600000L;
    zzaBr = false;
    zzaND = Long.MAX_VALUE;
    zzaOa = Integer.MAX_VALUE;
    zzaOb = 0.0F;
    zzaOc = 0L;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4)
  {
    mVersionCode = paramInt1;
    mPriority = paramInt2;
    zzaNY = paramLong1;
    zzaNZ = paramLong2;
    zzaBr = paramBoolean;
    zzaND = paramLong3;
    zzaOa = paramInt3;
    zzaOb = paramFloat;
    zzaOc = paramLong4;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  public static void zzL$1349ef()
  {
    if (0L < 0L) {
      throw new IllegalArgumentException("invalid interval: 0");
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LocationRequest)) {
        return false;
      }
      paramObject = (LocationRequest)paramObject;
    } while ((mPriority == mPriority) && (zzaNY == zzaNY) && (zzaNZ == zzaNZ) && (zzaBr == zzaBr) && (zzaND == zzaND) && (zzaOa == zzaOa) && (zzaOb == zzaOb));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(mPriority), Long.valueOf(zzaNY), Long.valueOf(zzaNZ), Boolean.valueOf(zzaBr), Long.valueOf(zzaND), Integer.valueOf(zzaOa), Float.valueOf(zzaOb) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Request[");
    String str;
    switch (mPriority)
    {
    case 101: 
    case 103: 
    default: 
      str = "???";
    }
    for (;;)
    {
      localStringBuilder2.append(str);
      if (mPriority != 105)
      {
        localStringBuilder1.append(" requested=");
        localStringBuilder1.append(zzaNY).append("ms");
      }
      localStringBuilder1.append(" fastest=");
      localStringBuilder1.append(zzaNZ).append("ms");
      if (zzaOc > zzaNY)
      {
        localStringBuilder1.append(" maxWait=");
        localStringBuilder1.append(zzaOc).append("ms");
      }
      if (zzaND != Long.MAX_VALUE)
      {
        long l1 = zzaND;
        long l2 = SystemClock.elapsedRealtime();
        localStringBuilder1.append(" expireIn=");
        localStringBuilder1.append(l1 - l2).append("ms");
      }
      if (zzaOa != Integer.MAX_VALUE) {
        localStringBuilder1.append(" num=").append(zzaOa);
      }
      localStringBuilder1.append(']');
      return localStringBuilder1.toString();
      str = "PRIORITY_HIGH_ACCURACY";
      continue;
      str = "PRIORITY_BALANCED_POWER_ACCURACY";
      continue;
      str = "PRIORITY_LOW_POWER";
      continue;
      str = "PRIORITY_NO_POWER";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.zza$1fef69e8(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */