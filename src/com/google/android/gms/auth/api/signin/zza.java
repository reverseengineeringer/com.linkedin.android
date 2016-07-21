package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<EmailSignInOptions>
{
  static void zza(EmailSignInOptions paramEmailSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$377a007(paramParcel, 2, zzWL, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 3, zzWM);
    zzb.zza$377a007(paramParcel, 4, zzWN, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */