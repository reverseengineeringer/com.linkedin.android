package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public final class zzg
  implements Parcelable.Creator<AdRequestParcel>
{
  static void zza(AdRequestParcel paramAdRequestParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zztC);
    zzb.zza$f7bef55(paramParcel, 3, extras);
    zzb.zzc(paramParcel, 4, zztD);
    zzb.zzb$62107c48(paramParcel, 5, zztE);
    zzb.zza(paramParcel, 6, zztF);
    zzb.zzc(paramParcel, 7, zztG);
    zzb.zza(paramParcel, 8, zztH);
    zzb.zza$2cfb68bf(paramParcel, 9, zztI);
    zzb.zza$377a007(paramParcel, 10, zztJ, paramInt);
    zzb.zza$377a007(paramParcel, 11, zztK, paramInt);
    zzb.zza$2cfb68bf(paramParcel, 12, zztL);
    zzb.zza$f7bef55(paramParcel, 13, zztM);
    zzb.zza$f7bef55(paramParcel, 14, zztN);
    zzb.zzb$62107c48(paramParcel, 15, zztO);
    zzb.zza$2cfb68bf(paramParcel, 17, zztQ);
    zzb.zza$2cfb68bf(paramParcel, 16, zztP);
    zzb.zza(paramParcel, 18, zztR);
    zzb.zzH(paramParcel, i);
  }
  
  public static AdRequestParcel zzb(Parcel paramParcel)
  {
    int m = zza.zzau(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    boolean bool3 = false;
    int i = 0;
    boolean bool2 = false;
    String str4 = null;
    SearchAdRequestParcel localSearchAdRequestParcel = null;
    Location localLocation = null;
    String str3 = null;
    Bundle localBundle2 = null;
    Bundle localBundle1 = null;
    ArrayList localArrayList1 = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < m)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l = zza.zzi(paramParcel, n);
        break;
      case 3: 
        localBundle3 = zza.zzr(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList2 = zza.zzD(paramParcel, n);
        break;
      case 6: 
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 7: 
        i = zza.zzg(paramParcel, n);
        break;
      case 8: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 9: 
        str4 = zza.zzp(paramParcel, n);
        break;
      case 10: 
        localSearchAdRequestParcel = (SearchAdRequestParcel)zza.zza(paramParcel, n, SearchAdRequestParcel.CREATOR);
        break;
      case 11: 
        localLocation = (Location)zza.zza(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 13: 
        localBundle2 = zza.zzr(paramParcel, n);
        break;
      case 14: 
        localBundle1 = zza.zzr(paramParcel, n);
        break;
      case 15: 
        localArrayList1 = zza.zzD(paramParcel, n);
        break;
      case 17: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 16: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 18: 
        bool1 = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AdRequestParcel(k, l, localBundle3, j, localArrayList2, bool3, i, bool2, str4, localSearchAdRequestParcel, localLocation, str3, localBundle2, localBundle1, localArrayList1, str2, str1, bool1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */