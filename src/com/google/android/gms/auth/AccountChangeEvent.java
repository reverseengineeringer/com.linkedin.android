package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final int mVersion;
  final long zzUZ;
  final String zzVa;
  final int zzVb;
  final int zzVc;
  final String zzVd;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    mVersion = paramInt1;
    zzUZ = paramLong;
    zzVa = ((String)zzx.zzz(paramString1));
    zzVb = paramInt2;
    zzVc = paramInt3;
    zzVd = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      paramObject = (AccountChangeEvent)paramObject;
    } while ((mVersion == mVersion) && (zzUZ == zzUZ) && (zzw.equal(zzVa, zzVa)) && (zzVb == zzVb) && (zzVc == zzVc) && (zzw.equal(zzVd, zzVd)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(mVersion), Long.valueOf(zzUZ), zzVa, Integer.valueOf(zzVb), Integer.valueOf(zzVc), zzVd });
  }
  
  public String toString()
  {
    String str = "UNKNOWN";
    switch (zzVb)
    {
    }
    for (;;)
    {
      return "AccountChangeEvent {accountName = " + zzVa + ", changeType = " + str + ", changeData = " + zzVd + ", eventIndex = " + zzVc + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza$119e69c0(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */