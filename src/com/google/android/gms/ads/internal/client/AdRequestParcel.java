package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzhb;
import java.util.Arrays;
import java.util.List;

@zzhb
public final class AdRequestParcel
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final long zztC;
  public final int zztD;
  public final List<String> zztE;
  public final boolean zztF;
  public final int zztG;
  public final boolean zztH;
  public final String zztI;
  public final SearchAdRequestParcel zztJ;
  public final Location zztK;
  public final String zztL;
  public final Bundle zztM;
  public final Bundle zztN;
  public final List<String> zztO;
  public final String zztP;
  public final String zztQ;
  public final boolean zztR;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    versionCode = paramInt1;
    zztC = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    extras = localBundle;
    zztD = paramInt2;
    zztE = paramList1;
    zztF = paramBoolean1;
    zztG = paramInt3;
    zztH = paramBoolean2;
    zztI = paramString1;
    zztJ = paramSearchAdRequestParcel;
    zztK = paramLocation;
    zztL = paramString2;
    zztM = paramBundle2;
    zztN = paramBundle3;
    zztO = paramList2;
    zztP = paramString3;
    zztQ = paramString4;
    zztR = paramBoolean3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    do
    {
      return false;
      paramObject = (AdRequestParcel)paramObject;
    } while ((versionCode != versionCode) || (zztC != zztC) || (!zzw.equal(extras, extras)) || (zztD != zztD) || (!zzw.equal(zztE, zztE)) || (zztF != zztF) || (zztG != zztG) || (zztH != zztH) || (!zzw.equal(zztI, zztI)) || (!zzw.equal(zztJ, zztJ)) || (!zzw.equal(zztK, zztK)) || (!zzw.equal(zztL, zztL)) || (!zzw.equal(zztM, zztM)) || (!zzw.equal(zztN, zztN)) || (!zzw.equal(zztO, zztO)) || (!zzw.equal(zztP, zztP)) || (!zzw.equal(zztQ, zztQ)) || (zztR != zztR));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(versionCode), Long.valueOf(zztC), extras, Integer.valueOf(zztD), zztE, Boolean.valueOf(zztF), Integer.valueOf(zztG), Boolean.valueOf(zztH), zztI, zztJ, zztK, zztL, zztM, zztN, zztO, zztP, zztQ, Boolean.valueOf(zztR) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.AdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */