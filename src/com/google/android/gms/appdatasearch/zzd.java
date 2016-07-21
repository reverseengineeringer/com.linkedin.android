package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzd
  implements Parcelable.Creator<DocumentSection>
{
  static void zza(DocumentSection paramDocumentSection, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, zzTO);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$377a007(paramParcel, 3, zzTP, paramInt);
    zzb.zzc(paramParcel, 4, zzTQ);
    zzb.zza$52910762(paramParcel, 5, zzTR);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */