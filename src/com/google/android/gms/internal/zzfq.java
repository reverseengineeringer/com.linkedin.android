package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzfq
{
  private final boolean zzDu;
  private final boolean zzDv;
  private final boolean zzDw;
  private final boolean zzDx;
  private final boolean zzDy;
  
  private zzfq(zza paramzza)
  {
    zzDu = zzDu;
    zzDv = zzDv;
    zzDw = zzDw;
    zzDx = zzDx;
    zzDy = zzDy;
  }
  
  public final JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", zzDu).put("tel", zzDv).put("calendar", zzDw).put("storePicture", zzDx).put("inlineVideo", zzDy);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzin.zzb("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class zza
  {
    boolean zzDu;
    boolean zzDv;
    boolean zzDw;
    boolean zzDx;
    boolean zzDy;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */