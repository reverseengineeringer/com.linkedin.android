package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsStates
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
  final int mVersionCode;
  final boolean zzaOj;
  final boolean zzaOk;
  final boolean zzaOl;
  final boolean zzaOm;
  final boolean zzaOn;
  final boolean zzaOo;
  
  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    mVersionCode = paramInt;
    zzaOj = paramBoolean1;
    zzaOk = paramBoolean2;
    zzaOl = paramBoolean3;
    zzaOm = paramBoolean4;
    zzaOn = paramBoolean5;
    zzaOo = paramBoolean6;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza$511ad450(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsStates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */