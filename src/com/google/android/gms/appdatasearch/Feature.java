package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final int id;
  final int mVersionCode;
  final Bundle zzTS;
  
  Feature(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    mVersionCode = paramInt1;
    id = paramInt2;
    zzTS = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza$3d5036(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.Feature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */