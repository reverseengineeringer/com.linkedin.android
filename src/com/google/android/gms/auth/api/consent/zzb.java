package com.google.android.gms.auth.api.consent;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<GetConsentIntentRequest>
{
  static void zza(GetConsentIntentRequest paramGetConsentIntentRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 2, zzVO);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, zzVP);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 4, zzVQ);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$377a007(paramParcel, 5, zzTI, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2d7953c6(paramParcel, 6, zzVR, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzVS);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 8, zzVT);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 9, zzVU);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.consent.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */