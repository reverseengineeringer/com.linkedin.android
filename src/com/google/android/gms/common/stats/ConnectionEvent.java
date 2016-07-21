package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  final long zzane;
  int zzanf;
  final String zzang;
  final String zzanh;
  final String zzani;
  final String zzanj;
  final String zzank;
  final String zzanl;
  final long zzanm;
  final long zzann;
  private long zzano;
  
  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    mVersionCode = paramInt1;
    zzane = paramLong1;
    zzanf = paramInt2;
    zzang = paramString1;
    zzanh = paramString2;
    zzani = paramString3;
    zzanj = paramString4;
    zzano = -1L;
    zzank = paramString5;
    zzanl = paramString6;
    zzanm = paramLong2;
    zzann = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getEventType()
  {
    return zzanf;
  }
  
  public final long getTimeMillis()
  {
    return zzane;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza$151b04f0(this, paramParcel);
  }
  
  public final long zzrL()
  {
    return zzano;
  }
  
  public final String zzrO()
  {
    StringBuilder localStringBuilder = new StringBuilder("\t").append(zzang).append("/").append(zzanh).append("\t").append(zzani).append("/").append(zzanj).append("\t");
    if (zzank == null) {}
    for (String str = "";; str = zzank) {
      return str + "\t" + zzann;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */