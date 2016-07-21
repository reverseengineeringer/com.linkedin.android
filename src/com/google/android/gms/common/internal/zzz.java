package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzz
  implements Parcelable.Creator<ResolveAccountResponse>
{
  static void zza(ResolveAccountResponse paramResolveAccountResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza$cdac282(paramParcel, 2, zzakA);
    zzb.zza$377a007(paramParcel, 3, zzams, paramInt);
    zzb.zza(paramParcel, 4, zzahx);
    zzb.zza(paramParcel, 5, zzamt);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */