package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzc();
  public final byte[] body;
  public final int googlePlayServicesStatusCode;
  public final PendingIntent recoveryAction;
  public final int statusCode;
  final int versionCode;
  final Bundle zzWB;
  
  ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    versionCode = paramInt1;
    googlePlayServicesStatusCode = paramInt2;
    statusCode = paramInt3;
    zzWB = paramBundle;
    body = paramArrayOfByte;
    recoveryAction = paramPendingIntent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */