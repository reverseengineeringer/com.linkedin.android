package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzWd;
  final String[] zzWe;
  final CredentialPickerConfig zzWf;
  final CredentialPickerConfig zzWg;
  
  CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2)
  {
    mVersionCode = paramInt;
    zzWd = paramBoolean;
    zzWe = ((String[])zzx.zzz(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzWf = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzWg = paramArrayOfString;
  }
  
  private CredentialRequest(Builder paramBuilder)
  {
    this(2, zzWd, zzWe, zzWf, zzWg);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public boolean zzWd;
    public String[] zzWe;
    CredentialPickerConfig zzWf;
    CredentialPickerConfig zzWg;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */