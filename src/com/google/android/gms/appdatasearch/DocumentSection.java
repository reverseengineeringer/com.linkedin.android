package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection
  implements SafeParcelable
{
  public static final zzd CREATOR;
  public static final int zzTM = Integer.parseInt("-1");
  private static final RegisterSectionInfo zzTN;
  final int mVersionCode;
  public final String zzTO;
  final RegisterSectionInfo zzTP;
  public final int zzTQ;
  public final byte[] zzTR;
  
  static
  {
    CREATOR = new zzd();
    RegisterSectionInfo.zza localzza = new RegisterSectionInfo.zza("SsbContext");
    zzUl = true;
    zzUk = "blob";
    zzTN = localzza.zzmh();
  }
  
  DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((paramInt2 == zzTM) || (zzh.zzao(paramInt2) != null))
    {
      bool = true;
      zzx.zzb(bool, "Invalid section type " + paramInt2);
      mVersionCode = paramInt1;
      zzTO = paramString;
      zzTP = paramRegisterSectionInfo;
      zzTQ = paramInt2;
      zzTR = paramArrayOfByte;
      if ((zzTQ == zzTM) || (zzh.zzao(zzTQ) != null)) {
        break label131;
      }
      paramString = "Invalid section type " + zzTQ;
    }
    for (;;)
    {
      if (paramString == null) {
        return;
      }
      throw new IllegalArgumentException(paramString);
      bool = false;
      break;
      label131:
      if ((zzTO != null) && (zzTR != null)) {
        paramString = "Both content and blobContent set";
      } else {
        paramString = null;
      }
    }
  }
  
  public DocumentSection(String paramString, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, paramString, paramRegisterSectionInfo, zzTM, null);
  }
  
  public DocumentSection(String paramString1, RegisterSectionInfo paramRegisterSectionInfo, String paramString2)
  {
    this(1, paramString1, paramRegisterSectionInfo, zzh.zzbA(paramString2), null);
  }
  
  public DocumentSection(byte[] paramArrayOfByte, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, null, paramRegisterSectionInfo, zzTM, paramArrayOfByte);
  }
  
  public static DocumentSection zzh(byte[] paramArrayOfByte)
  {
    return new DocumentSection(paramArrayOfByte, zzTN);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentSection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */