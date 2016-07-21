package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzj
  implements Parcelable.Creator<EventParams>
{
  static void zza$789d8329(EventParams paramEventParams, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$f7bef55(paramParcel, 2, paramEventParams.zzCC());
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */