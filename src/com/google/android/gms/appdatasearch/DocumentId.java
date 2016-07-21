package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final String zzTJ;
  final String zzTK;
  final String zzTL;
  
  DocumentId(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    mVersionCode = paramInt;
    zzTJ = paramString1;
    zzTK = paramString2;
    zzTL = paramString3;
  }
  
  public DocumentId(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { zzTJ, zzTK, zzTL });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza$107737e6(this, paramParcel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */