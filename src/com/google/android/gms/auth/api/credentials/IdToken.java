package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zze();
  final int mVersionCode;
  final String zzVY;
  public final String zzWk;
  
  IdToken(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzVY = paramString1;
    zzWk = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza$209b9bb7(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */