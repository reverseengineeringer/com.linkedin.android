package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class HintRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
  final int mVersionCode;
  final String[] zzWe;
  final CredentialPickerConfig zzWh;
  final boolean zzWi;
  final boolean zzWj;
  
  HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString)
  {
    mVersionCode = paramInt;
    zzWh = ((CredentialPickerConfig)zzx.zzz(paramCredentialPickerConfig));
    zzWi = paramBoolean1;
    zzWj = paramBoolean2;
    zzWe = ((String[])zzx.zzz(paramArrayOfString));
  }
  
  private HintRequest(Builder paramBuilder)
  {
    this(1, zzWh, zzWi, zzWj, zzWe);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public String[] zzWe;
    CredentialPickerConfig zzWh = new CredentialPickerConfig.Builder().build();
    public boolean zzWi;
    public boolean zzWj;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.HintRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */