package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<AccountChangeEventsRequest>
{
  static void zza(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersion);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, zzVc);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 3, zzVa);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$377a007(paramParcel, 4, zzTI, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */