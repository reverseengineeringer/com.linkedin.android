package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class LocationAvailabilityCreator
  implements Parcelable.Creator<LocationAvailability>
{
  public static LocationAvailability createFromParcel(Parcel paramParcel)
  {
    int i = 1;
    int n = zza.zzau(paramParcel);
    int m = 0;
    int k = 1000;
    long l = 0L;
    int j = 1;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = paramParcel.readInt();
      switch (0xFFFF & i1)
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        l = zza.zzi(paramParcel, i1);
        break;
      case 4: 
        k = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new LocationAvailability(m, k, j, i, l);
  }
  
  static void zza$13ba70a6(LocationAvailability paramLocationAvailability, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, zzaNU);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, zzaNV);
    zzb.zza(paramParcel, 3, zzaNW);
    zzb.zzc(paramParcel, 4, zzaNX);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationAvailabilityCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */