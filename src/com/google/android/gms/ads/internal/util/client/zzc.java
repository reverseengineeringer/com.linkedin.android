package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<VersionInfoParcel>
{
  static void zza$1ad68b2d(VersionInfoParcel paramVersionInfoParcel, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, afmaVersion);
    zzb.zzc(paramParcel, 3, zzMZ);
    zzb.zzc(paramParcel, 4, zzNa);
    zzb.zza(paramParcel, 5, zzNb);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */