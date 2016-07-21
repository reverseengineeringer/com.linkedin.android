package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzm
  implements Parcelable.Creator<LocationRequestInternal>
{
  static void zza(LocationRequestInternal paramLocationRequestInternal, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$377a007(paramParcel, 1, zzaBp, paramInt);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaOP);
    zzb.zza(paramParcel, 3, zzaOQ);
    zzb.zza(paramParcel, 4, zzaOR);
    zzb.zzc$62107c48(paramParcel, 5, zzaOS);
    zzb.zza$2cfb68bf(paramParcel, 6, mTag);
    zzb.zza(paramParcel, 7, zzaOT);
    zzb.zzH(paramParcel, i);
  }
  
  public static LocationRequestInternal zzeX(Parcel paramParcel)
  {
    String str = null;
    boolean bool2 = true;
    boolean bool1 = false;
    int j = zza.zzau(paramParcel);
    Object localObject = LocationRequestInternal.zzaOO;
    boolean bool3 = true;
    boolean bool4 = false;
    LocationRequest localLocationRequest = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localLocationRequest = (LocationRequest)zza.zza(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        localObject = zza.zzc(paramParcel, k, ClientIdentity.CREATOR);
        break;
      case 6: 
        str = zza.zzp(paramParcel, k);
        break;
      case 7: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationRequestInternal(i, localLocationRequest, bool4, bool3, bool2, (List)localObject, str, bool1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */