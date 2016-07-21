package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();
  final int versionCode;
  final Uri zzWL;
  String zzWM;
  Uri zzWN;
  
  EmailSignInOptions(int paramInt, Uri paramUri1, String paramString, Uri paramUri2)
  {
    zzx.zzb(paramUri1, "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzh(paramUri1.toString(), "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzb(Patterns.WEB_URL.matcher(paramUri1.toString()).matches(), "Invalid server widget url");
    versionCode = paramInt;
    zzWL = paramUri1;
    zzWM = paramString;
    zzWN = paramUri2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (EmailSignInOptions)paramObject;
        if (zzWL.equals(zzWL)) {
          if (zzWN == null)
          {
            if (zzWN != null) {}
          }
          else
          {
            for (;;)
            {
              if (!TextUtils.isEmpty(zzWM)) {
                break label79;
              }
              if (!TextUtils.isEmpty(zzWM)) {
                break;
              }
              break label101;
              if (!zzWN.equals(zzWN)) {
                break;
              }
            }
            label79:
            boolean bool = zzWM.equals(zzWM);
            if (!bool) {}
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label101:
    return true;
  }
  
  public int hashCode()
  {
    return zzezzpzzWL).zzp(zzWN).zzp(zzWM).zzXz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final JSONObject zzmJ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("serverWidgetUrl", zzWL.toString());
      if (!TextUtils.isEmpty(zzWM)) {
        localJSONObject.put("modeQueryName", zzWM);
      }
      if (zzWN != null) {
        localJSONObject.put("tosUrl", zzWN.toString());
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
 * Qualified Name:     com.google.android.gms.auth.api.signin.EmailSignInOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */