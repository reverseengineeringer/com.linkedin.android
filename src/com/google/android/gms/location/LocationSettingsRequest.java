package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class LocationSettingsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
  final int mVersionCode;
  final List<LocationRequest> zzaBm;
  final boolean zzaOf;
  final boolean zzaOg;
  
  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzaBm = paramList;
    zzaOf = paramBoolean1;
    zzaOg = paramBoolean2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza$3b05d9e5(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */