package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<AccountChangeEventsResponse>
{
  static void zza$346cd6a8(AccountChangeEventsResponse paramAccountChangeEventsResponse, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersion);
    zzb.zzc$62107c48(paramParcel, 2, zzpH);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */