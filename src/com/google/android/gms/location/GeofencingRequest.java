package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class GeofencingRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
  final int mVersionCode;
  final List<ParcelableGeofence> zzaNN;
  final int zzaNO;
  
  GeofencingRequest(int paramInt1, List<ParcelableGeofence> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaNN = paramList;
    zzaNO = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza$75418c60(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */