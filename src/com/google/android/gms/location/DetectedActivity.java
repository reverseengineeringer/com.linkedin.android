package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final Comparator<DetectedActivity> zzaNy = new Comparator() {};
  public static final int[] zzaNz = { 0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14 };
  final int mVersionCode;
  int zzaNA;
  int zzaNB;
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaNA = paramInt2;
    zzaNB = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DetectedActivity)paramObject;
    } while ((zzaNA == zzaNA) && (zzaNB == zzaNB));
    return false;
  }
  
  public final int getType()
  {
    int j = zzaNA;
    int i = j;
    if (j > 15) {
      i = 4;
    }
    return i;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzaNA), Integer.valueOf(zzaNB) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetectedActivity [type=");
    int i = getType();
    String str;
    switch (i)
    {
    case 6: 
    default: 
      str = Integer.toString(i);
    }
    for (;;)
    {
      return str + ", confidence=" + zzaNB + "]";
      str = "IN_VEHICLE";
      continue;
      str = "ON_BICYCLE";
      continue;
      str = "ON_FOOT";
      continue;
      str = "STILL";
      continue;
      str = "UNKNOWN";
      continue;
      str = "TILTING";
      continue;
      str = "WALKING";
      continue;
      str = "RUNNING";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.zza$120025c7(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */