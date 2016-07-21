package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzl
  implements Parcelable.Creator<InterstitialAdParameterParcel>
{
  static void zza$2350bab8(InterstitialAdParameterParcel paramInterstitialAdParameterParcel, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzql);
    zzb.zza(paramParcel, 3, zzqm);
    zzb.zza$2cfb68bf(paramParcel, 4, zzqn);
    zzb.zza(paramParcel, 5, zzqo);
    zzb.zza(paramParcel, 6, zzqp);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */