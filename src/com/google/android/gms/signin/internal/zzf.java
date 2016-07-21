package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzf
  implements Parcelable.Creator<RecordConsentRequest>
{
  static void zza(RecordConsentRequest paramRecordConsentRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza$377a007(paramParcel, 2, zzTI, paramInt);
    zzb.zza$2d7953c6(paramParcel, 3, zzbhh, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 4, zzXd);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */