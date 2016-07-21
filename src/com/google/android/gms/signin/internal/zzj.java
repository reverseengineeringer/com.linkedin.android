package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzj
  implements Parcelable.Creator<SignInResponse>
{
  static void zza(SignInResponse paramSignInResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza$377a007(paramParcel, 2, zzams, paramInt);
    zzb.zza$377a007(paramParcel, 3, zzbhk, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */