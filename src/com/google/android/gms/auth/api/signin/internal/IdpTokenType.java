package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class IdpTokenType
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdpTokenType> CREATOR = new zzj();
  public static final IdpTokenType zzXA = new IdpTokenType("accessToken");
  public static final IdpTokenType zzXB = new IdpTokenType("idToken");
  final int versionCode;
  final String zzXC;
  
  IdpTokenType(int paramInt, String paramString)
  {
    versionCode = paramInt;
    zzXC = zzx.zzcM(paramString);
  }
  
  private IdpTokenType(String paramString)
  {
    this(1, paramString);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {}
    try
    {
      boolean bool3 = zzXC.equals(zzXC);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public final int hashCode()
  {
    return zzXC.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza$17cea525(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.IdpTokenType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */