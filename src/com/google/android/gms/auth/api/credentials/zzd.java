package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzd
  implements Parcelable.Creator<HintRequest>
{
  static void zza(HintRequest paramHintRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, zzWh, paramInt);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzWi);
    zzb.zza(paramParcel, 3, zzWj);
    zzb.zza$41b439c0(paramParcel, 4, zzWe);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */