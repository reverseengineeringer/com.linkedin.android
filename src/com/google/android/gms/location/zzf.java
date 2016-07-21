package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Collections;

public final class zzf
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza$3b05d9e5(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc$62107c48(paramParcel, 1, Collections.unmodifiableList(zzaBm));
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaOf);
    zzb.zza(paramParcel, 3, zzaOg);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */