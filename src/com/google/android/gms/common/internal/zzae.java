package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzae
  implements Parcelable.Creator<ValidateAccountRequest>
{
  static void zza(ValidateAccountRequest paramValidateAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, zzamy);
    zzb.zza$cdac282(paramParcel, 3, zzakA);
    zzb.zza$2d7953c6(paramParcel, 4, zzafT, paramInt);
    zzb.zza$f7bef55(paramParcel, 5, zzamz);
    zzb.zza$2cfb68bf(paramParcel, 6, zzVO);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */