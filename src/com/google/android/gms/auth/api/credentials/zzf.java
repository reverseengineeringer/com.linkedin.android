package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzf
  implements Parcelable.Creator<PasswordSpecification>
{
  static void zza$18e098bf(PasswordSpecification paramPasswordSpecification, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzWn);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzb$62107c48(paramParcel, 2, zzWo);
    zzb.zza$62107c48(paramParcel, 3, zzWp);
    zzb.zzc(paramParcel, 4, zzWq);
    zzb.zzc(paramParcel, 5, zzWr);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */