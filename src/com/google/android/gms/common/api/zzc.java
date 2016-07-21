package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<Status>
{
  static void zza(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, zzade);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzafC);
    zzb.zza$377a007(paramParcel, 3, mPendingIntent, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */