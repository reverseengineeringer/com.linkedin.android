package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class InterstitialAdParameterParcel
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final int versionCode;
  public final boolean zzql;
  public final boolean zzqm;
  public final String zzqn;
  public final boolean zzqo;
  public final float zzqp;
  
  InterstitialAdParameterParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    versionCode = paramInt;
    zzql = paramBoolean1;
    zzqm = paramBoolean2;
    zzqn = paramString;
    zzqo = paramBoolean3;
    zzqp = paramFloat;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza$2350bab8(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.InterstitialAdParameterParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */