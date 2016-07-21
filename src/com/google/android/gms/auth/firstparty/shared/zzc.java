package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<ScopeDetail>
{
  static void zza(ScopeDetail paramScopeDetail, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza$2cfb68bf(paramParcel, 2, description);
    zzb.zza$2cfb68bf(paramParcel, 3, zzYw);
    zzb.zza$2cfb68bf(paramParcel, 4, zzYx);
    zzb.zza$2cfb68bf(paramParcel, 5, zzYy);
    zzb.zza$2cfb68bf(paramParcel, 6, zzYz);
    zzb.zzb$62107c48(paramParcel, 7, zzYA);
    zzb.zza$377a007(paramParcel, 8, zzYB, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */