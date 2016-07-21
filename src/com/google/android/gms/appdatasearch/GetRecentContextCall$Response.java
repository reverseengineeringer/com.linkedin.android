package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall$Response
  implements Result, SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int mVersionCode;
  public Status zzTY;
  public List<UsageInfo> zzTZ;
  @Deprecated
  public String[] zzUa;
  
  public GetRecentContextCall$Response()
  {
    mVersionCode = 1;
  }
  
  GetRecentContextCall$Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
  {
    mVersionCode = paramInt;
    zzTY = paramStatus;
    zzTZ = paramList;
    zzUa = paramArrayOfString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Status getStatus()
  {
    return zzTY;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */