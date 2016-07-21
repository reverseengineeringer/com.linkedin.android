package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<IdToken>
{
  static void zza$209b9bb7(IdToken paramIdToken, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzVY);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzWk);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */