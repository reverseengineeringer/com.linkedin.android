package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzh
  implements Parcelable.Creator<WakeLockEvent>
{
  static void zza$7ab08521(WakeLockEvent paramWakeLockEvent, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzane);
    zzb.zza$2cfb68bf(paramParcel, 4, zzanQ);
    zzb.zzc(paramParcel, 5, zzanR);
    zzb.zzb$62107c48(paramParcel, 6, zzanS);
    zzb.zza(paramParcel, 8, zzanm);
    zzb.zza$2cfb68bf(paramParcel, 10, zzanV);
    zzb.zzc(paramParcel, 11, zzanf);
    zzb.zza$2cfb68bf(paramParcel, 12, zzanT);
    zzb.zza$2cfb68bf(paramParcel, 13, zzanW);
    zzb.zzc(paramParcel, 14, zzanU);
    zzb.zza(paramParcel, 15, zzanX);
    zzb.zza(paramParcel, 16, mTimeout);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */