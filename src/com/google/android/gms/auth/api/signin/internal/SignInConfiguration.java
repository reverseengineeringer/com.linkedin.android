package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzp();
  final int versionCode;
  final String zzXL;
  public EmailSignInOptions zzXM;
  public GoogleSignInOptions zzXN;
  String zzXO;
  String zzXd;
  
  SignInConfiguration(int paramInt, String paramString1, String paramString2, EmailSignInOptions paramEmailSignInOptions, GoogleSignInOptions paramGoogleSignInOptions, String paramString3)
  {
    versionCode = paramInt;
    zzXL = zzx.zzcM(paramString1);
    zzXd = paramString2;
    zzXM = paramEmailSignInOptions;
    zzXN = paramGoogleSignInOptions;
    zzXO = paramString3;
  }
  
  public SignInConfiguration(String paramString)
  {
    this(2, paramString, null, null, null, null);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (SignInConfiguration)paramObject;
        if (zzXL.equals(zzXL))
        {
          if (TextUtils.isEmpty(zzXd))
          {
            if (!TextUtils.isEmpty(zzXd)) {
              continue;
            }
            label45:
            if (!TextUtils.isEmpty(zzXO)) {
              break label113;
            }
            if (!TextUtils.isEmpty(zzXO)) {
              continue;
            }
            label65:
            if (zzXM != null) {
              break label130;
            }
            if (zzXM != null) {
              continue;
            }
          }
          for (;;)
          {
            if (zzXN != null) {
              break label147;
            }
            if (zzXN != null) {
              break;
            }
            break label169;
            if (!zzXd.equals(zzXd)) {
              break;
            }
            break label45;
            label113:
            if (!zzXO.equals(zzXO)) {
              break;
            }
            break label65;
            label130:
            if (!zzXM.equals(zzXM)) {
              break;
            }
          }
          label147:
          boolean bool = zzXN.equals(zzXN);
          if (!bool) {}
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label169:
    return true;
  }
  
  public final int hashCode()
  {
    return zzezzpzzXL).zzp(zzXd).zzp(zzXO).zzp(zzXM).zzp(zzXN).zzXz;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  final JSONObject zzmJ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("consumerPackageName", zzXL);
      if (!TextUtils.isEmpty(zzXd)) {
        localJSONObject.put("serverClientId", zzXd);
      }
      if (zzXM != null) {
        localJSONObject.put("emailSignInOptions", zzXM.zzmJ().toString());
      }
      if (zzXN != null) {
        localJSONObject.put("googleSignInOptions", zzXN.zzmJ().toString());
      }
      if (!TextUtils.isEmpty(zzXO)) {
        localJSONObject.put("apiKey", zzXO);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */