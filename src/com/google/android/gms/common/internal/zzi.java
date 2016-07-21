package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzi
  implements Parcelable.Creator<GetServiceRequest>
{
  static void zza(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, version);
    zzb.zzc(paramParcel, 2, zzall);
    zzb.zzc(paramParcel, 3, zzalm);
    zzb.zza$2cfb68bf(paramParcel, 4, zzaln);
    zzb.zza$cdac282(paramParcel, 5, zzalo);
    zzb.zza$2d7953c6(paramParcel, 6, zzalp, paramInt);
    zzb.zza$f7bef55(paramParcel, 7, zzalq);
    zzb.zza$377a007(paramParcel, 8, zzalr, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */