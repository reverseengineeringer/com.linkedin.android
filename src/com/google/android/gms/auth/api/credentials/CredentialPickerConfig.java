package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
  final boolean mShowCancelButton;
  final int mVersionCode;
  final boolean zzWb;
  final boolean zzWc;
  
  CredentialPickerConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt;
    zzWb = paramBoolean1;
    mShowCancelButton = paramBoolean2;
    zzWc = paramBoolean3;
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(1, zzWb, mShowCancelButton, zzWc);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza$13561712(this, paramParcel);
  }
  
  public static final class Builder
  {
    boolean mShowCancelButton = true;
    boolean zzWb = false;
    boolean zzWc = false;
    
    public final CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, (byte)0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */