package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzbhf;
  final List<Scope> zzbhg;
  
  CheckServerAuthResult(int paramInt, boolean paramBoolean, List<Scope> paramList)
  {
    mVersionCode = paramInt;
    zzbhf = paramBoolean;
    zzbhg = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza$2809d959(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.CheckServerAuthResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */