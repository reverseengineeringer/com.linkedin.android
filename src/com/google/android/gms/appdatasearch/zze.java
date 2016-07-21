package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<Feature>
{
  static void zza$3d5036(Feature paramFeature, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, id);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$f7bef55(paramParcel, 2, zzTS);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */