package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzj
  implements Parcelable.Creator<UsageInfo>
{
  static void zza(UsageInfo paramUsageInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, zzUs, paramInt);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzUt);
    zzb.zzc(paramParcel, 3, zzUu);
    zzb.zza$2cfb68bf(paramParcel, 4, zzvp);
    zzb.zza$377a007(paramParcel, 5, zzUv, paramInt);
    zzb.zza(paramParcel, 6, zzUw);
    zzb.zzc(paramParcel, 7, zzUx);
    zzb.zzc(paramParcel, 8, zzUy);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */