package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR = new zze();
  final int versionCode;
  String zzWP;
  String zzWQ;
  Uri zzWR;
  String zzWk;
  public String zzXj;
  public GoogleSignInAccount zzXm;
  String zzXn;
  public String zzrG;
  
  SignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, GoogleSignInAccount paramGoogleSignInAccount, String paramString5, String paramString6)
  {
    versionCode = paramInt;
    zzWP = zzx.zzh(paramString3, "Email cannot be empty.");
    zzWQ = paramString4;
    zzWR = paramUri;
    zzXj = paramString1;
    zzWk = paramString2;
    zzXm = paramGoogleSignInAccount;
    zzrG = zzx.zzcM(paramString5);
    zzXn = paramString6;
  }
  
  public static SignInAccount zzbM(String paramString)
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
      Object localObject = zzd.zzbL(localJSONObject.optString("providerId", null));
      String str1 = localJSONObject.optString("tokenId", null);
      String str2 = localJSONObject.getString("email");
      String str3 = localJSONObject.optString("displayName", null);
      String str4 = localJSONObject.getString("localId");
      String str5 = localJSONObject.optString("refreshToken");
      if (localObject != null) {}
      for (localObject = zzXj;; localObject = null)
      {
        paramString = new SignInAccount(2, (String)localObject, str1, str2, str3, paramString, null, str4, str5);
        zzXm = GoogleSignInAccount.zzbH(localJSONObject.optString("googleSignInAccount"));
        return paramString;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public final JSONObject zzmJ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("email", zzWP);
      if (!TextUtils.isEmpty(zzWQ)) {
        localJSONObject.put("displayName", zzWQ);
      }
      if (zzWR != null) {
        localJSONObject.put("photoUrl", zzWR.toString());
      }
      if (!TextUtils.isEmpty(zzXj)) {
        localJSONObject.put("providerId", zzXj);
      }
      if (!TextUtils.isEmpty(zzWk)) {
        localJSONObject.put("tokenId", zzWk);
      }
      if (zzXm != null) {
        localJSONObject.put("googleSignInAccount", zzXm.zzmJ().toString());
      }
      if (!TextUtils.isEmpty(zzXn)) {
        localJSONObject.put("refreshToken", zzXn);
      }
      localJSONObject.put("localId", zzrG);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.SignInAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */