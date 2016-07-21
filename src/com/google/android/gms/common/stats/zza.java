package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<ConnectionEvent>
{
  static void zza$151b04f0(ConnectionEvent paramConnectionEvent, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzane);
    zzb.zza$2cfb68bf(paramParcel, 4, zzang);
    zzb.zza$2cfb68bf(paramParcel, 5, zzanh);
    zzb.zza$2cfb68bf(paramParcel, 6, zzani);
    zzb.zza$2cfb68bf(paramParcel, 7, zzanj);
    zzb.zza$2cfb68bf(paramParcel, 8, zzank);
    zzb.zza(paramParcel, 10, zzanm);
    zzb.zza(paramParcel, 11, zzann);
    zzb.zzc(paramParcel, 12, zzanf);
    zzb.zza$2cfb68bf(paramParcel, 13, zzanl);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */