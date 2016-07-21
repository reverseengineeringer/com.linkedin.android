package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  final String mName;
  final int mVersionCode;
  public final Uri zzVV;
  public final List<IdToken> zzVW;
  public final String zzVX;
  final String zzVY;
  final String zzVZ;
  final String zzWa;
  public final String zzyv;
  
  public Credential(int paramInt, String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    mVersionCode = paramInt;
    paramString1 = ((String)zzx.zzb(paramString1, "credential identifier cannot be null")).trim();
    zzx.zzh(paramString1, "credential identifier cannot be empty");
    zzyv = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2.trim())) {
        paramString1 = null;
      }
    }
    mName = paramString1;
    zzVV = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      zzVW = paramString1;
      zzVX = paramString3;
      if ((paramString3 == null) || (!paramString3.isEmpty())) {
        break;
      }
      throw new IllegalArgumentException("password cannot be empty");
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = Uri.parse(paramString4).getScheme();
      if ((!"http".equalsIgnoreCase(paramString1)) && (!"https".equalsIgnoreCase(paramString1))) {
        break label208;
      }
    }
    label208:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzac(bool);
      zzVY = paramString4;
      zzVZ = paramString5;
      zzWa = paramString6;
      if ((TextUtils.isEmpty(zzVX)) || (TextUtils.isEmpty(zzVY))) {
        break;
      }
      throw new IllegalStateException("password and accountType cannot both be set");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(zzyv, zzyv)) && (TextUtils.equals(mName, mName)) && (zzw.equal(zzVV, zzVV)) && (TextUtils.equals(zzVX, zzVX)) && (TextUtils.equals(zzVY, zzVY)) && (TextUtils.equals(zzVZ, zzVZ)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzyv, mName, zzVV, zzVX, zzVY, zzVZ });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public String mName;
    public Uri zzVV;
    public List<IdToken> zzVW;
    public String zzVX;
    public String zzVY;
    public String zzVZ;
    public String zzWa;
    public final String zzyv;
    
    public Builder(String paramString)
    {
      zzyv = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */