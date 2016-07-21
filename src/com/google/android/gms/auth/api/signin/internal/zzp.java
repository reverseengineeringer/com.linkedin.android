package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzp
  implements Parcelable.Creator<SignInConfiguration>
{
  static void zza(SignInConfiguration paramSignInConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzXL);
    zzb.zza$2cfb68bf(paramParcel, 3, zzXd);
    zzb.zza$377a007(paramParcel, 4, zzXM, paramInt);
    zzb.zza$377a007(paramParcel, 5, zzXN, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 7, zzXO);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */