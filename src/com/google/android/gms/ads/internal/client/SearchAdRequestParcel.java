package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class SearchAdRequestParcel
  implements SafeParcelable
{
  public static final zzam CREATOR = new zzam();
  public final int backgroundColor;
  public final int versionCode;
  public final int zzvd;
  public final int zzve;
  public final int zzvf;
  public final int zzvg;
  public final int zzvh;
  public final int zzvi;
  public final int zzvj;
  public final String zzvk;
  public final int zzvl;
  public final String zzvm;
  public final int zzvn;
  public final int zzvo;
  public final String zzvp;
  
  SearchAdRequestParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    versionCode = paramInt1;
    zzvd = paramInt2;
    backgroundColor = paramInt3;
    zzve = paramInt4;
    zzvf = paramInt5;
    zzvg = paramInt6;
    zzvh = paramInt7;
    zzvi = paramInt8;
    zzvj = paramInt9;
    zzvk = paramString1;
    zzvl = paramInt10;
    zzvm = paramString2;
    zzvn = paramInt11;
    zzvo = paramInt12;
    zzvp = paramString3;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzam.zza$a7ba428(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.SearchAdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */