package com.google.android.gms.ads.internal.purchase;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zza
  implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel>
{
  static void zza$629388ef(GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$cdac282(paramParcel, 3, zze.zzC(zzrI).asBinder());
    zzb.zza$cdac282(paramParcel, 4, zze.zzC(zzFw).asBinder());
    zzb.zza$cdac282(paramParcel, 5, zze.zzC(zzFx).asBinder());
    zzb.zza$cdac282(paramParcel, 6, zze.zzC(zzFy).asBinder());
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */