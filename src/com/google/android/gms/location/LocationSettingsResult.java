package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();
  final int mVersionCode;
  final Status zzUX;
  final LocationSettingsStates zzaOi;
  
  LocationSettingsResult(int paramInt, Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    mVersionCode = paramInt;
    zzUX = paramStatus;
    zzaOi = paramLocationSettingsStates;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Status getStatus()
  {
    return zzUX;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */