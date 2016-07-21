package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public final class ActivityRecognitionResultCreator
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  public static ActivityRecognitionResult createFromParcel(Parcel paramParcel)
  {
    long l1 = 0L;
    Bundle localBundle = null;
    int i = 0;
    int k = zza.zzau(paramParcel);
    long l2 = 0L;
    ArrayList localArrayList = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, m, DetectedActivity.CREATOR);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ActivityRecognitionResult(j, localArrayList, l2, l1, i, localBundle);
  }
  
  static void zza$193b9a6d(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc$62107c48(paramParcel, 1, zzaNu);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaNv);
    zzb.zza(paramParcel, 3, zzaNw);
    zzb.zzc(paramParcel, 4, zzaNx);
    zzb.zza$f7bef55(paramParcel, 5, extras);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResultCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */