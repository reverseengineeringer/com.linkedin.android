package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class LocationAvailability
  implements SafeParcelable
{
  public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
  final int mVersionCode;
  int zzaNU;
  int zzaNV;
  long zzaNW;
  int zzaNX;
  
  LocationAvailability(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    mVersionCode = paramInt1;
    zzaNX = paramInt2;
    zzaNU = paramInt3;
    zzaNV = paramInt4;
    zzaNW = paramLong;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationAvailability)) {}
    do
    {
      return false;
      paramObject = (LocationAvailability)paramObject;
    } while ((zzaNX != zzaNX) || (zzaNU != zzaNU) || (zzaNV != zzaNV) || (zzaNW != zzaNW));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzaNX), Integer.valueOf(zzaNU), Integer.valueOf(zzaNV), Long.valueOf(zzaNW) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LocationAvailability[isLocationAvailable: ");
    if (zzaNX < 1000) {}
    for (boolean bool = true;; bool = false) {
      return bool + "]";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationAvailabilityCreator.zza$13ba70a6(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */