package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<CredentialPickerConfig>
{
  static void zza$13561712(CredentialPickerConfig paramCredentialPickerConfig, Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, zzWb);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, mShowCancelButton);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzWc);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */