package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zze
  implements Parcelable.Creator<SignInAccount>
{
  static void zza(SignInAccount paramSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzXj);
    zzb.zza$2cfb68bf(paramParcel, 3, zzWk);
    zzb.zza$2cfb68bf(paramParcel, 4, zzWP);
    zzb.zza$2cfb68bf(paramParcel, 5, zzWQ);
    zzb.zza$377a007(paramParcel, 6, zzWR, paramInt);
    zzb.zza$377a007(paramParcel, 7, zzXm, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 8, zzrG);
    zzb.zza$2cfb68bf(paramParcel, 9, zzXn);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */