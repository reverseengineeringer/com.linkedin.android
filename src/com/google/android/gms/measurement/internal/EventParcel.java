package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel
  implements SafeParcelable
{
  public static final zzk CREATOR = new zzk();
  public final String name;
  public final int versionCode;
  public final EventParams zzaVV;
  public final String zzaVW;
  public final long zzaVX;
  
  EventParcel(int paramInt, String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    versionCode = paramInt;
    name = paramString1;
    zzaVV = paramEventParams;
    zzaVW = paramString2;
    zzaVX = paramLong;
  }
  
  public EventParcel(String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    versionCode = 1;
    name = paramString1;
    zzaVV = paramEventParams;
    zzaVW = paramString2;
    zzaVX = paramLong;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "origin=" + zzaVW + ",name=" + name + ",params=" + zzaVV;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.EventParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */