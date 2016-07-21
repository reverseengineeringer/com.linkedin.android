package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  String description;
  final int version;
  List<String> zzYA;
  public FACLData zzYB;
  String zzYw;
  String zzYx;
  String zzYy;
  String zzYz;
  
  ScopeDetail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, FACLData paramFACLData)
  {
    version = paramInt;
    description = paramString1;
    zzYw = paramString2;
    zzYx = paramString3;
    zzYy = paramString4;
    zzYz = paramString5;
    zzYA = paramList;
    zzYB = paramFACLData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.ScopeDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */