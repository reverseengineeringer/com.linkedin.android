package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  Bundle extras;
  final int mVersionCode;
  List<DetectedActivity> zzaNu;
  long zzaNv;
  long zzaNw;
  int zzaNx;
  
  public ActivityRecognitionResult(int paramInt1, List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt2, Bundle paramBundle)
  {
    mVersionCode = paramInt1;
    zzaNu = paramList;
    zzaNv = paramLong1;
    zzaNw = paramLong2;
    zzaNx = paramInt2;
    extras = paramBundle;
  }
  
  private static boolean zzc(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return true;
    }
    if (((paramBundle1 == null) && (paramBundle2 != null)) || ((paramBundle1 != null) && (paramBundle2 == null))) {
      return false;
    }
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle2.containsKey(str)) {
        return false;
      }
      if (paramBundle1.get(str) == null)
      {
        if (paramBundle2.get(str) != null) {
          return false;
        }
      }
      else if ((paramBundle1.get(str) instanceof Bundle))
      {
        if (!zzc(paramBundle1.getBundle(str), paramBundle2.getBundle(str))) {
          return false;
        }
      }
      else if (!paramBundle1.get(str).equals(paramBundle2.get(str))) {
        return false;
      }
    }
    return true;
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
      paramObject = (ActivityRecognitionResult)paramObject;
    } while ((zzaNv == zzaNv) && (zzaNw == zzaNw) && (zzaNx == zzaNx) && (zzw.equal(zzaNu, zzaNu)) && (zzc(extras, extras)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(zzaNv), Long.valueOf(zzaNw), Integer.valueOf(zzaNx), zzaNu, extras });
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + zzaNu + ", timeMillis=" + zzaNv + ", elapsedRealtimeMillis=" + zzaNw + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.zza$193b9a6d(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */