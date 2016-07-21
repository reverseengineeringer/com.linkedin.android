package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

public final class zzn
  implements Parcelable.Creator<LocationRequestUpdateData>
{
  static void zza(LocationRequestUpdateData paramLocationRequestUpdateData, Parcel paramParcel, int paramInt)
  {
    Object localObject = null;
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, zzaOU);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza$377a007(paramParcel, 2, zzaOV, paramInt);
    IBinder localIBinder;
    if (zzaOW == null)
    {
      localIBinder = null;
      zzb.zza$cdac282(paramParcel, 3, localIBinder);
      zzb.zza$377a007(paramParcel, 4, mPendingIntent, paramInt);
      if (zzaOX != null) {
        break label122;
      }
      localIBinder = null;
      label78:
      zzb.zza$cdac282(paramParcel, 5, localIBinder);
      if (zzaOY != null) {
        break label136;
      }
    }
    label122:
    label136:
    for (paramLocationRequestUpdateData = (LocationRequestUpdateData)localObject;; paramLocationRequestUpdateData = zzaOY.asBinder())
    {
      zzb.zza$cdac282(paramParcel, 6, paramLocationRequestUpdateData);
      zzb.zzH(paramParcel, i);
      return;
      localIBinder = zzaOW.asBinder();
      break;
      localIBinder = zzaOX.asBinder();
      break label78;
    }
  }
  
  public static LocationRequestUpdateData zzeY(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int k = zza.zzau(paramParcel);
    int j = 0;
    int i = 1;
    IBinder localIBinder2 = null;
    PendingIntent localPendingIntent = null;
    IBinder localIBinder3 = null;
    LocationRequestInternal localLocationRequestInternal = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localLocationRequestInternal = (LocationRequestInternal)zza.zza(paramParcel, m, LocationRequestInternal.CREATOR);
        break;
      case 3: 
        localIBinder3 = zza.zzq(paramParcel, m);
        break;
      case 4: 
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 5: 
        localIBinder2 = zza.zzq(paramParcel, m);
        break;
      case 6: 
        localIBinder1 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new LocationRequestUpdateData(j, i, localLocationRequestInternal, localIBinder3, localPendingIntent, localIBinder2, localIBinder1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */