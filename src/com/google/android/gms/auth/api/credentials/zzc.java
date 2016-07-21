package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<CredentialRequest>
{
  static void zza(CredentialRequest paramCredentialRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza(paramParcel, 1, zzWd);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$41b439c0(paramParcel, 2, zzWe);
    zzb.zza$377a007(paramParcel, 3, zzWf, paramInt);
    zzb.zza$377a007(paramParcel, 4, zzWg, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */