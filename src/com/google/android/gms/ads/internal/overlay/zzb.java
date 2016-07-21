package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<AdLauncherIntentInfoParcel>
{
  static void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 2, intentAction);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 3, url);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 4, mimeType);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 5, packageName);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 6, zzDK);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 7, zzDL);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 8, zzDM);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$377a007(paramParcel, 9, intent, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */