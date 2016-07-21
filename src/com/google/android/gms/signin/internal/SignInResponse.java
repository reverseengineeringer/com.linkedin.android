package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInResponse> CREATOR = new zzj();
  final int mVersionCode;
  public final ConnectionResult zzams;
  public final ResolveAccountResponse zzbhk;
  
  public SignInResponse()
  {
    this(new ConnectionResult(8, null));
  }
  
  SignInResponse(int paramInt, ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    mVersionCode = paramInt;
    zzams = paramConnectionResult;
    zzbhk = paramResolveAccountResponse;
  }
  
  private SignInResponse(ConnectionResult paramConnectionResult)
  {
    this(1, paramConnectionResult, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */