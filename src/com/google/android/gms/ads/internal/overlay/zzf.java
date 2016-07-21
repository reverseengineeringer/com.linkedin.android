package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zzf
  implements Parcelable.Creator<AdOverlayInfoParcel>
{
  static void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$377a007(paramParcel, 2, zzEA, paramInt);
    zzb.zza$cdac282(paramParcel, 3, zze.zzC(zzEB).asBinder());
    zzb.zza$cdac282(paramParcel, 4, zze.zzC(zzEC).asBinder());
    zzb.zza$cdac282(paramParcel, 5, zze.zzC(zzED).asBinder());
    zzb.zza$cdac282(paramParcel, 6, zze.zzC(zzEE).asBinder());
    zzb.zza$2cfb68bf(paramParcel, 7, zzEF);
    zzb.zza(paramParcel, 8, zzEG);
    zzb.zza$2cfb68bf(paramParcel, 9, zzEH);
    zzb.zza$cdac282(paramParcel, 10, zze.zzC(zzEI).asBinder());
    zzb.zzc(paramParcel, 11, orientation);
    zzb.zzc(paramParcel, 12, zzEJ);
    zzb.zza$2cfb68bf(paramParcel, 13, url);
    zzb.zza$377a007(paramParcel, 14, zzrl, paramInt);
    zzb.zza$cdac282(paramParcel, 15, zze.zzC(zzEK).asBinder());
    zzb.zza$377a007(paramParcel, 17, zzEM, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 16, zzEL);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */