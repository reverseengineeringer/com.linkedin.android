package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<DocumentId>
{
  static void zza$107737e6(DocumentId paramDocumentId, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzTJ);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzTK);
    zzb.zza$2cfb68bf(paramParcel, 3, zzTL);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */