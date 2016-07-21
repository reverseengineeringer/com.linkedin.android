package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class DetectedActivityCreator
  implements Parcelable.Creator<DetectedActivity>
{
  static void zza$120025c7(DetectedActivity paramDetectedActivity, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, zzaNA);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, zzaNB);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.DetectedActivityCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */