package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope
  implements SafeParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzb();
  final int mVersionCode;
  public final String zzagB;
  
  Scope(int paramInt, String paramString)
  {
    zzx.zzh(paramString, "scopeUri must not be null or empty");
    mVersionCode = paramInt;
    zzagB = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return zzagB.equals(zzagB);
  }
  
  public final int hashCode()
  {
    return zzagB.hashCode();
  }
  
  public final String toString()
  {
    return zzagB;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza$514aa83(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */