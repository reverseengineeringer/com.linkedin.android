package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<LocationResult>
{
  static void zza$3d3ce068(LocationResult paramLocationResult, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc$62107c48(paramParcel, 1, zzaOe);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */