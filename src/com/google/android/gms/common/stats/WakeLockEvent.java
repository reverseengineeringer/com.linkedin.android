package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
  final long mTimeout;
  final int mVersionCode;
  final String zzanQ;
  final int zzanR;
  final List<String> zzanS;
  final String zzanT;
  int zzanU;
  final String zzanV;
  final String zzanW;
  final float zzanX;
  final long zzane;
  int zzanf;
  final long zzanm;
  private long zzano;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    mVersionCode = paramInt1;
    zzane = paramLong1;
    zzanf = paramInt2;
    zzanQ = paramString1;
    zzanV = paramString3;
    zzanR = paramInt3;
    zzano = -1L;
    zzanS = paramList;
    zzanT = paramString2;
    zzanm = paramLong2;
    zzanU = paramInt4;
    zzanW = paramString4;
    zzanX = paramFloat;
    mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this(1, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3);
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
    zzh.zza$7ab08521(this, paramParcel);
  }
  
  public final long zzrL()
  {
    return zzano;
  }
  
  public final String zzrO()
  {
    StringBuilder localStringBuilder = new StringBuilder("\t").append(zzanQ).append("\t").append(zzanR).append("\t");
    if (zzanS == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("\t").append(zzanU).append("\t");
      if (zzanV != null) {
        break label132;
      }
      str = "";
      label77:
      localStringBuilder = localStringBuilder.append(str).append("\t");
      if (zzanW != null) {
        break label140;
      }
    }
    label132:
    label140:
    for (String str = "";; str = zzanW)
    {
      return str + "\t" + zzanX;
      str = TextUtils.join(",", zzanS);
      break;
      str = zzanV;
      break label77;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */