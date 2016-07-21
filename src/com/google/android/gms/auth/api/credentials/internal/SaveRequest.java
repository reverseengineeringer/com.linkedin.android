package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SaveRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SaveRequest> CREATOR = new zzk();
  final int mVersionCode;
  final Credential zzWu;
  
  SaveRequest(int paramInt, Credential paramCredential)
  {
    mVersionCode = paramInt;
    zzWu = paramCredential;
  }
  
  public SaveRequest(Credential paramCredential)
  {
    this(1, paramCredential);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.SaveRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */