package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zza
  implements Parcelable.Creator<ProxyGrpcRequest>
{
  static void zza$41bca3c(ProxyGrpcRequest paramProxyGrpcRequest, Parcel paramParcel)
  {
    int i = zzb.zzG(paramParcel, 20293);
    zzb.zza$2cfb68bf(paramParcel, 1, hostname);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zzc(paramParcel, 2, port);
    zzb.zza(paramParcel, 3, timeoutMillis);
    zzb.zza$52910762(paramParcel, 4, body);
    zzb.zza$2cfb68bf(paramParcel, 5, method);
    zzb.zzH(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */