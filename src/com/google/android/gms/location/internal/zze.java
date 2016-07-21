package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<FusedLocationProviderResult>
{
  static void zza(FusedLocationProviderResult paramFusedLocationProviderResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, zzUX, paramInt);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */