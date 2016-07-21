package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class ValidateAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzae();
  final int mVersionCode;
  final String zzVO;
  final Scope[] zzafT;
  final IBinder zzakA;
  final int zzamy;
  final Bundle zzamz;
  
  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt1;
    zzamy = paramInt2;
    zzakA = paramIBinder;
    zzafT = paramArrayOfScope;
    zzamz = paramBundle;
    zzVO = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */