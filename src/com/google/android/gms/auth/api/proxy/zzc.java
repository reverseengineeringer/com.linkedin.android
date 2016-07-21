package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzc
  implements Parcelable.Creator<ProxyResponse>
{
  static void zza(ProxyResponse paramProxyResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zzc(paramParcel, 1, googlePlayServicesStatusCode);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zza$377a007(paramParcel, 2, recoveryAction, paramInt);
    zzb.zzc(paramParcel, 3, statusCode);
    zzb.zza$f7bef55(paramParcel, 4, zzWB);
    zzb.zza$52910762(paramParcel, 5, body);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */