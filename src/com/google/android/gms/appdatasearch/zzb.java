package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<DocumentContents>
{
  static void zza(DocumentContents paramDocumentContents, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2d7953c6(paramParcel, 1, zzTC, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 2, zzTD);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzTE);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$377a007(paramParcel, 4, account, paramInt);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */