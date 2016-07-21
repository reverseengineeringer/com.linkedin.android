package com.google.android.gms.ads.internal.purchase;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzi
{
  public static String zzaq(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("developerPayload");
      return paramString;
    }
    catch (JSONException paramString)
    {
      zzin.zzaK("Fail to parse purchase data");
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */