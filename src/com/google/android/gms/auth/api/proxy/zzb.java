package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzb
  implements Parcelable.Creator<ProxyRequest>
{
  static void zza$2c5dc67a(ProxyRequest paramProxyRequest, Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$2cfb68bf(paramParcel, 1, url);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, httpMethod);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, timeoutMillis);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$52910762(paramParcel, 4, body);
    com.google.android.gms.common.internal.safeparcel.zzb.zza$f7bef55(paramParcel, 5, zzWB);
    com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */