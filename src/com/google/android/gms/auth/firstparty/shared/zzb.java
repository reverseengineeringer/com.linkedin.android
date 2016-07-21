package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<FACLData>
{
  static void zza(FACLData paramFACLData, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, version);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$377a007(paramParcel, 2, zzYs, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 3, zzYt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzYu);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 5, zzYv);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */