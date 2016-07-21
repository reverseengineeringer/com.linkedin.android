package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  static final List<ClientIdentity> zzaOO = ;
  String mTag;
  final int mVersionCode;
  LocationRequest zzaBp;
  boolean zzaOP;
  boolean zzaOQ;
  boolean zzaOR;
  List<ClientIdentity> zzaOS;
  boolean zzaOT;
  
  LocationRequestInternal(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<ClientIdentity> paramList, String paramString, boolean paramBoolean4)
  {
    mVersionCode = paramInt;
    zzaBp = paramLocationRequest;
    zzaOP = paramBoolean1;
    zzaOQ = paramBoolean2;
    zzaOR = paramBoolean3;
    zzaOS = paramList;
    mTag = paramString;
    zzaOT = paramBoolean4;
  }
  
  @Deprecated
  public static LocationRequestInternal zzb(LocationRequest paramLocationRequest)
  {
    return new LocationRequestInternal(1, paramLocationRequest, false, true, true, zzaOO, null, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationRequestInternal)) {}
    do
    {
      return false;
      paramObject = (LocationRequestInternal)paramObject;
    } while ((!zzw.equal(zzaBp, zzaBp)) || (zzaOP != zzaOP) || (zzaOQ != zzaOQ) || (zzaOR != zzaOR) || (zzaOT != zzaOT) || (!zzw.equal(zzaOS, zzaOS)));
    return true;
  }
  
  public int hashCode()
  {
    return zzaBp.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzaBp.toString());
    if (mTag != null) {
      localStringBuilder.append(" tag=").append(mTag);
    }
    localStringBuilder.append(" nlpDebug=").append(zzaOP);
    localStringBuilder.append(" trigger=").append(zzaOR);
    localStringBuilder.append(" restorePIListeners=").append(zzaOQ);
    localStringBuilder.append(" hideAppOps=").append(zzaOT);
    localStringBuilder.append(" clients=").append(zzaOS);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.LocationRequestInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */