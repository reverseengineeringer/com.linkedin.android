package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzah
  implements Parcelable.Creator<UserAttributeParcel>
{
  static void zza$2732f0dd(UserAttributeParcel paramUserAttributeParcel, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza$2cfb68bf(paramParcel, 2, name);
    zzb.zza(paramParcel, 3, zzaZm);
    zzb.zza$53422a(paramParcel, 4, zzaZn);
    Float localFloat = zzaZo;
    if (localFloat != null)
    {
      zzb.zzb(paramParcel, 5, 4);
      paramParcel.writeFloat(localFloat.floatValue());
    }
    zzb.zza$2cfb68bf(paramParcel, 6, zzamJ);
    zzb.zza$2cfb68bf(paramParcel, 7, zzaVW);
    zzb.zzH(paramParcel, i);
  }
  
  public static UserAttributeParcel zzfO(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    String str1 = null;
    String str2 = null;
    Float localFloat = null;
    Long localLong = null;
    String str3 = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        l = zza.zzi(paramParcel, k);
        break;
      case 4: 
        localLong = zza.zzj(paramParcel, k);
        break;
      case 5: 
        k = zza.zza(paramParcel, k);
        if (k == 0)
        {
          localFloat = null;
        }
        else
        {
          zza.zza$ae3cd4b(paramParcel, k, 4);
          localFloat = Float.valueOf(paramParcel.readFloat());
        }
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UserAttributeParcel(i, str3, l, localLong, localFloat, str2, str1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */