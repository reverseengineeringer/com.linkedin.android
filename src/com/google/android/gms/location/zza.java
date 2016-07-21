package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<GeofencingRequest>
{
  static void zza$75418c60(GeofencingRequest paramGeofencingRequest, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc$62107c48(paramParcel, 1, zzaNN);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, zzaNO);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */