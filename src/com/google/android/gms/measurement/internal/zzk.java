package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzk
  implements Parcelable.Creator<EventParcel>
{
  static void zza(EventParcel paramEventParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, name);
    zzb.zza$377a007(paramParcel, 3, zzaVV, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 4, zzaVW);
    zzb.zza(paramParcel, 5, zzaVX);
    zzb.zzH(paramParcel, i);
  }
  
  public static EventParcel zzfN(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    EventParams localEventParams = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localEventParams = (EventParams)zza.zza(paramParcel, k, EventParams.CREATOR);
        break;
      case 4: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new EventParcel(i, str2, localEventParams, str1, l);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */