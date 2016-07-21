package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<AccountChangeEvent>
{
  static void zza$119e69c0(AccountChangeEvent paramAccountChangeEvent, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zza(paramParcel, 2, zzUZ);
    zzb.zza$2cfb68bf(paramParcel, 3, zzVa);
    zzb.zzc(paramParcel, 4, zzVb);
    zzb.zzc(paramParcel, 5, zzVc);
    zzb.zza$2cfb68bf(paramParcel, 6, zzVd);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */