package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<FACLConfig>
{
  static void zza$5331385a(FACLConfig paramFACLConfig, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, version);
    zzb.zza(paramParcel, 2, zzYm);
    zzb.zza$2cfb68bf(paramParcel, 3, zzYn);
    zzb.zza(paramParcel, 4, zzYo);
    zzb.zza(paramParcel, 5, zzYp);
    zzb.zza(paramParcel, 6, zzYq);
    zzb.zza(paramParcel, 7, zzYr);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */