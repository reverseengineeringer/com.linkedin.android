package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<AuthAccountResult>
{
  static void zza(AuthAccountResult paramAuthAccountResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, zzbhd);
    zzb.zza$377a007(paramParcel, 3, zzbhe, paramInt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */