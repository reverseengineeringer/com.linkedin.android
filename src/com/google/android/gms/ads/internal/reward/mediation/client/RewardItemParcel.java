package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzhb;
import java.util.Arrays;

@zzhb
public final class RewardItemParcel
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String type;
  public final int versionCode;
  public final int zzKS;
  
  public RewardItemParcel(int paramInt1, String paramString, int paramInt2)
  {
    versionCode = paramInt1;
    type = paramString;
    zzKS = paramInt2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RewardItemParcel))) {}
    do
    {
      return false;
      paramObject = (RewardItemParcel)paramObject;
    } while ((!zzw.equal(type, type)) || (!zzw.equal(Integer.valueOf(zzKS), Integer.valueOf(zzKS))));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { type, Integer.valueOf(zzKS) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza$41e7b039(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */