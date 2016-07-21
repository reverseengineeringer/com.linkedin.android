package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzi
  implements Parcelable.Creator<RegisterSectionInfo>
{
  static void zza(RegisterSectionInfo paramRegisterSectionInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, name);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, zzUd);
    zzb.zza(paramParcel, 3, zzUe);
    zzb.zzc(paramParcel, 4, weight);
    zzb.zza(paramParcel, 5, zzUf);
    zzb.zza$2cfb68bf(paramParcel, 6, zzUg);
    zzb.zza$2d7953c6(paramParcel, 7, zzUh, paramInt);
    int[] arrayOfInt = zzUi;
    if (arrayOfInt != null)
    {
      paramInt = zzb.zzG(paramParcel, 8);
      paramParcel.writeIntArray(arrayOfInt);
      zzb.zzH(paramParcel, paramInt);
    }
    zzb.zza$2cfb68bf(paramParcel, 11, zzUj);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */