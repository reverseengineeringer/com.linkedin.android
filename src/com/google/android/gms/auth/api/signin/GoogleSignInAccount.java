package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzb();
  public static zzmq zzWO = zzmt.zzsc();
  private static Comparator<Scope> zzWV = new Comparator() {};
  final int versionCode;
  List<Scope> zzVs;
  String zzWP;
  String zzWQ;
  Uri zzWR;
  String zzWS;
  public long zzWT;
  public String zzWU;
  public String zzWk;
  String zzyv;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList)
  {
    versionCode = paramInt;
    zzyv = paramString1;
    zzWk = paramString2;
    zzWP = paramString3;
    zzWQ = paramString4;
    zzWR = paramUri;
    zzWS = paramString5;
    zzWT = paramLong;
    zzWU = paramString6;
    zzVs = paramList;
  }
  
  public static GoogleSignInAccount zzbH(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      Object localObject = localJSONObject.getJSONArray("grantedScopes");
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        localHashSet.add(new Scope(((JSONArray)localObject).getString(i)));
        i += 1;
      }
      String str1 = localJSONObject.optString("id");
      String str2 = localJSONObject.optString("tokenId", null);
      String str3 = localJSONObject.optString("email", null);
      String str4 = localJSONObject.optString("displayName", null);
      localObject = Long.valueOf(l);
      String str5 = localJSONObject.getString("obfuscatedIdentifier");
      if (localObject == null) {
        localObject = Long.valueOf(zzWO.currentTimeMillis() / 1000L);
      }
      for (;;)
      {
        paramString = new GoogleSignInAccount(2, str1, str2, str3, str4, paramString, null, ((Long)localObject).longValue(), zzx.zzcM(str5), new ArrayList((Collection)zzx.zzz(localHashSet)));
        zzWS = localJSONObject.optString("serverAuthCode", null);
        return paramString;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).zzmJ().toString().equals(zzmJ().toString());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public final JSONObject zzmJ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (zzyv != null) {
        localJSONObject.put("id", zzyv);
      }
      if (zzWk != null) {
        localJSONObject.put("tokenId", zzWk);
      }
      if (zzWP != null) {
        localJSONObject.put("email", zzWP);
      }
      if (zzWQ != null) {
        localJSONObject.put("displayName", zzWQ);
      }
      if (zzWR != null) {
        localJSONObject.put("photoUrl", zzWR.toString());
      }
      if (zzWS != null) {
        localJSONObject.put("serverAuthCode", zzWS);
      }
      localJSONObject.put("expirationTime", zzWT);
      localJSONObject.put("obfuscatedIdentifier", zzWU);
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(zzVs, zzWV);
      Iterator localIterator = zzVs.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(nextzzagB);
      }
      localJSONException.put("grantedScopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONException;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */