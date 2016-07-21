package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc$62107c48(paramParcel, 2, paramGoogleSignInOptions.zzmN());
    zzb.zza$377a007(paramParcel, 3, zzTI, paramInt);
    zzb.zza(paramParcel, 4, zzXa);
    zzb.zza(paramParcel, 5, zzXb);
    zzb.zza(paramParcel, 6, zzXc);
    zzb.zza$2cfb68bf(paramParcel, 7, zzXd);
    zzb.zza$2cfb68bf(paramParcel, 8, zzXe);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */