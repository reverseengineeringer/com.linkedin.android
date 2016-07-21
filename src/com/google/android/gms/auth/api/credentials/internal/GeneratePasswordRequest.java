package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GeneratePasswordRequest> CREATOR = new zzh();
  final int mVersionCode;
  final PasswordSpecification zzVM;
  
  GeneratePasswordRequest(int paramInt, PasswordSpecification paramPasswordSpecification)
  {
    mVersionCode = paramInt;
    zzVM = paramPasswordSpecification;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */