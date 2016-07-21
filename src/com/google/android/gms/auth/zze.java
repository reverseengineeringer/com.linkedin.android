package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<TokenData>
{
  static void zza$6d52043c(TokenData paramTokenData, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzVo);
    zzb.zza$53422a(paramParcel, 3, zzVp);
    zzb.zza(paramParcel, 4, zzVq);
    zzb.zza(paramParcel, 5, zzVr);
    zzb.zzb$62107c48(paramParcel, 6, zzVs);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */