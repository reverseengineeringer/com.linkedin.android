package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzam
  implements Parcelable.Creator<SearchAdRequestParcel>
{
  static void zza$a7ba428(SearchAdRequestParcel paramSearchAdRequestParcel, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, zzvd);
    zzb.zzc(paramParcel, 3, backgroundColor);
    zzb.zzc(paramParcel, 4, zzve);
    zzb.zzc(paramParcel, 5, zzvf);
    zzb.zzc(paramParcel, 6, zzvg);
    zzb.zzc(paramParcel, 7, zzvh);
    zzb.zzc(paramParcel, 8, zzvi);
    zzb.zzc(paramParcel, 9, zzvj);
    zzb.zza$2cfb68bf(paramParcel, 10, zzvk);
    zzb.zzc(paramParcel, 11, zzvl);
    zzb.zza$2cfb68bf(paramParcel, 12, zzvm);
    zzb.zzc(paramParcel, 13, zzvn);
    zzb.zzc(paramParcel, 14, zzvo);
    zzb.zza$2cfb68bf(paramParcel, 15, zzvp);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */