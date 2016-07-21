package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<AuthAccountRequest>
{
  static void zza(AuthAccountRequest paramAuthAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza$cdac282(paramParcel, 2, zzakA);
    zzb.zza$2d7953c6(paramParcel, 3, zzafT, paramInt);
    zzb.zza$1ed7098(paramParcel, 4, zzakB);
    zzb.zza$1ed7098(paramParcel, 5, zzakC);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */