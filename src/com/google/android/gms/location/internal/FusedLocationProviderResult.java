package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FusedLocationProviderResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<FusedLocationProviderResult> CREATOR = new zze();
  public static final FusedLocationProviderResult zzaOC = new FusedLocationProviderResult(Status.zzagC);
  final int mVersionCode;
  final Status zzUX;
  
  FusedLocationProviderResult(int paramInt, Status paramStatus)
  {
    mVersionCode = paramInt;
    zzUX = paramStatus;
  }
  
  private FusedLocationProviderResult(Status paramStatus)
  {
    this(1, paramStatus);
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
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.FusedLocationProviderResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */