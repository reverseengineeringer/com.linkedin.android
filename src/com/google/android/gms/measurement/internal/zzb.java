package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public final class zzb
  implements Parcelable.Creator<AppMetadata>
{
  static void zza$4fcb2b27(AppMetadata paramAppMetadata, Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 2, packageName);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 3, zzaVt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 4, zzaMV);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 5, zzaVu);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzaVv);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzaVw);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 8, zzaVx);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, zzaVy);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, zzaVz);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
  
  public static AppMetadata zzfL(Parcel paramParcel)
  {
    long l1 = 0L;
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzau(paramParcel);
    boolean bool2 = false;
    long l2 = 0L;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        l2 = zza.zzi(paramParcel, k);
        break;
      case 7: 
        l1 = zza.zzi(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 10: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppMetadata(i, str5, str4, str3, str2, l2, l1, str1, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */