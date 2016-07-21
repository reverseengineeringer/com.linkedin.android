package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzg
  implements Parcelable.Creator<LocationSettingsResult>
{
  static void zza(LocationSettingsResult paramLocationSettingsResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, zzUX, paramInt);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$377a007(paramParcel, 2, zzaOi, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */