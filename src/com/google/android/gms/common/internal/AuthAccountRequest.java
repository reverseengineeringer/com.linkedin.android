package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzc();
  final int mVersionCode;
  final Scope[] zzafT;
  final IBinder zzakA;
  Integer zzakB;
  Integer zzakC;
  
  AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2)
  {
    mVersionCode = paramInt;
    zzakA = paramIBinder;
    zzafT = paramArrayOfScope;
    zzakB = paramInteger1;
    zzakC = paramInteger2;
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
 * Qualified Name:     com.google.android.gms.common.internal.AuthAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */