package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class VersionInfoParcel
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public String afmaVersion;
  public final int versionCode;
  public int zzMZ;
  public int zzNa;
  public boolean zzNb;
  
  VersionInfoParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    versionCode = paramInt1;
    afmaVersion = paramString;
    zzMZ = paramInt2;
    zzNa = paramInt3;
    zzNb = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza$1ad68b2d(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.VersionInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */