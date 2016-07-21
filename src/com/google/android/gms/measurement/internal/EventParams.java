package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public class EventParams
  implements SafeParcelable, Iterable<String>
{
  public static final zzj CREATOR = new zzj();
  public final int versionCode;
  final Bundle zzaVS;
  
  EventParams(int paramInt, Bundle paramBundle)
  {
    versionCode = paramInt;
    zzaVS = paramBundle;
  }
  
  EventParams(Bundle paramBundle)
  {
    zzx.zzz(paramBundle);
    zzaVS = paramBundle;
    versionCode = 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> zzaVT = EventParams.zza(EventParams.this).keySet().iterator();
      
      public final boolean hasNext()
      {
        return zzaVT.hasNext();
      }
      
      public final void remove()
      {
        throw new UnsupportedOperationException("Remove not supported");
      }
    };
  }
  
  public String toString()
  {
    return zzaVS.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza$789d8329(this, paramParcel);
  }
  
  public final Bundle zzCC()
  {
    return new Bundle(zzaVS);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.EventParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */