package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<Credential>
{
  static void zza(Credential paramCredential, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzyv);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, mName);
    zzb.zza$377a007(paramParcel, 3, zzVV, paramInt);
    zzb.zzc$62107c48(paramParcel, 4, zzVW);
    zzb.zza$2cfb68bf(paramParcel, 5, zzVX);
    zzb.zza$2cfb68bf(paramParcel, 6, zzVY);
    zzb.zza$2cfb68bf(paramParcel, 7, zzVZ);
    zzb.zza$2cfb68bf(paramParcel, 8, zzWa);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */