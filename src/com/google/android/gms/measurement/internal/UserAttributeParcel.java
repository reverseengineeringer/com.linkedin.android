package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class UserAttributeParcel
  implements SafeParcelable
{
  public static final zzah CREATOR = new zzah();
  public final String name;
  public final int versionCode;
  public final String zzaVW;
  public final long zzaZm;
  public final Long zzaZn;
  public final Float zzaZo;
  public final String zzamJ;
  
  UserAttributeParcel(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3)
  {
    versionCode = paramInt;
    name = paramString1;
    zzaZm = paramLong;
    zzaZn = paramLong1;
    zzaZo = paramFloat;
    zzamJ = paramString2;
    zzaVW = paramString3;
  }
  
  UserAttributeParcel(zzai paramzzai)
  {
    this(mName, zzaZp, zzNc, zzaUa);
  }
  
  UserAttributeParcel(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    zzx.zzcM(paramString1);
    versionCode = 1;
    name = paramString1;
    zzaZm = paramLong;
    zzaVW = paramString2;
    if (paramObject == null)
    {
      zzaZn = null;
      zzaZo = null;
      zzamJ = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzaZn = ((Long)paramObject);
      zzaZo = null;
      zzamJ = null;
      return;
    }
    if ((paramObject instanceof Float))
    {
      zzaZn = null;
      zzaZo = ((Float)paramObject);
      zzamJ = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      zzaZn = null;
      zzaZo = null;
      zzamJ = ((String)paramObject);
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Object getValue()
  {
    if (zzaZn != null) {
      return zzaZn;
    }
    if (zzaZo != null) {
      return zzaZo;
    }
    if (zzamJ != null) {
      return zzamJ;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzah.zza$2732f0dd(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.UserAttributeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */