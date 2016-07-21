package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfs
{
  private final String zzDJ;
  final zzjp zzpD;
  
  public zzfs(zzjp paramzzjp)
  {
    this(paramzzjp, "");
  }
  
  public zzfs(zzjp paramzzjp, String paramString)
  {
    zzpD = paramzzjp;
    zzDJ = paramString;
  }
  
  public final void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      zzpD.zzb("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzin.zzb("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public final void zzam(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", zzDJ);
      zzpD.zzb("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzin.zzb("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public final void zzao(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      zzpD.zzb("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzin.zzb("Error occured while dispatching state change.", paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */