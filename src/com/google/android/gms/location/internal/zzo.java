package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzo
  implements Parcelable.Creator<ParcelableGeofence>
{
  static void zza$3125d07d(ParcelableGeofence paramParcelableGeofence, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzEY);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaOZ);
    int j = zzaNE;
    zzb.zzb(paramParcel, 3, 4);
    paramParcel.writeInt(j);
    zzb.zza(paramParcel, 4, zzaNF);
    zzb.zza(paramParcel, 5, zzaNG);
    zzb.zza(paramParcel, 6, zzaNH);
    zzb.zzc(paramParcel, 7, zzaNC);
    zzb.zzc(paramParcel, 8, zzaNI);
    zzb.zzc(paramParcel, 9, zzaNJ);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */