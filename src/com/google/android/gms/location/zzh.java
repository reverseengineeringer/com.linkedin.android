package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzh
  implements Parcelable.Creator<LocationSettingsStates>
{
  static void zza$511ad450(LocationSettingsStates paramLocationSettingsStates, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza(paramParcel, 1, zzaOj);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaOk);
    zzb.zza(paramParcel, 3, zzaOl);
    zzb.zza(paramParcel, 4, zzaOm);
    zzb.zza(paramParcel, 5, zzaOn);
    zzb.zza(paramParcel, 6, zzaOo);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */