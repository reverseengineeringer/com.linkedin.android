package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

public class UsageInfo
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final DocumentId zzUs;
  final long zzUt;
  int zzUu;
  final DocumentContents zzUv;
  final boolean zzUw;
  int zzUx;
  int zzUy;
  public final String zzvp;
  
  UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    mVersionCode = paramInt1;
    zzUs = paramDocumentId;
    zzUt = paramLong;
    zzUu = paramInt2;
    zzvp = paramString;
    zzUv = paramDocumentContents;
    zzUw = paramBoolean;
    zzUx = paramInt3;
    zzUy = paramInt4;
  }
  
  private UsageInfo(DocumentId paramDocumentId, long paramLong, int paramInt1, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this(1, paramDocumentId, paramLong, paramInt1, paramString, paramDocumentContents, paramBoolean, paramInt2, paramInt3);
  }
  
  public static DocumentId zza(String paramString, Intent paramIntent)
  {
    return new DocumentId(paramString, "", zzg(paramIntent));
  }
  
  public static DocumentContents.zza zza$262286ff(Intent paramIntent, String paramString1, Uri paramUri, String paramString2)
  {
    DocumentContents.zza localzza = new DocumentContents.zza();
    RegisterSectionInfo.zza localzza1 = new RegisterSectionInfo.zza("title").zzap(1);
    zzUn = true;
    zzUr = "name";
    localzza.zza(new DocumentSection(paramString1, localzza1.zzmh(), "text1"));
    if (paramUri != null)
    {
      paramString1 = paramUri.toString();
      paramUri = new RegisterSectionInfo.zza("web_url").zzap(4);
      zzUl = true;
      zzUr = "url";
      localzza.zza(new DocumentSection(paramString1, paramUri.zzmh()));
    }
    paramString1 = paramIntent.getAction();
    if (paramString1 != null) {
      localzza.zza(zzo("intent_action", paramString1));
    }
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null) {
      localzza.zza(zzo("intent_data", paramString1));
    }
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null) {
      localzza.zza(zzo("intent_activity", paramString1.getClassName()));
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null) {
        localzza.zza(zzo("intent_extra_data", paramIntent));
      }
    }
    zzTG = paramString2;
    zzTH = true;
    return localzza;
  }
  
  private static String zzg(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      throw new IllegalStateException(paramIntent);
    }
  }
  
  private static DocumentSection zzo(String paramString1, String paramString2)
  {
    RegisterSectionInfo.zza localzza = new RegisterSectionInfo.zza(paramString1);
    zzUl = true;
    return new DocumentSection(paramString2, localzza.zzmh(), paramString1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { zzUs, Long.valueOf(zzUt), Integer.valueOf(zzUu), Integer.valueOf(zzUy) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public static final class zza
  {
    public String zzOJ;
    public DocumentId zzUs;
    public long zzUt = -1L;
    public int zzUu = -1;
    public DocumentContents zzUv;
    public boolean zzUw = false;
    public int zzUx = -1;
    public int zzUy = 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.UsageInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */