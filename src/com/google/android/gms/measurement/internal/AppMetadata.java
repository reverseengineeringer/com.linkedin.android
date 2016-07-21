package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AppMetadata
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String packageName;
  public final int versionCode;
  public final String zzaMV;
  public final String zzaVt;
  public final String zzaVu;
  public final long zzaVv;
  public final long zzaVw;
  public final String zzaVx;
  public final boolean zzaVy;
  public final boolean zzaVz;
  
  AppMetadata(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    versionCode = paramInt;
    packageName = paramString1;
    zzaVt = paramString2;
    zzaMV = paramString3;
    zzaVu = paramString4;
    zzaVv = paramLong1;
    zzaVw = paramLong2;
    zzaVx = paramString5;
    if (paramInt >= 3) {}
    for (zzaVy = paramBoolean1;; zzaVy = true)
    {
      zzaVz = paramBoolean2;
      return;
    }
  }
  
  AppMetadata(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzx.zzcM(paramString1);
    versionCode = 4;
    packageName = paramString1;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    zzaVt = paramString1;
    zzaMV = paramString3;
    zzaVu = paramString4;
    zzaVv = paramLong1;
    zzaVw = paramLong2;
    zzaVx = paramString5;
    zzaVy = paramBoolean1;
    zzaVz = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza$4fcb2b27(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.AppMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */