package com.linkedin.android.liauthlib.thirdparty;

import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class LiThirdPartyAuthorizeResponse
  extends LiResponse
{
  private final String TAG = "LiThirdPartyAuthorizeRespose";
  public String errorDescription;
  public String errorInfo;
  public String m_accessToken;
  public String m_appName;
  public long m_expiresOn;
  public String m_logo;
  public List<LiThirdPartyPermissionInfo> m_permissionInfoList;
  
  public LiThirdPartyAuthorizeResponse() {}
  
  public LiThirdPartyAuthorizeResponse(int paramInt, LiError paramLiError)
  {
    statusCode = paramInt;
    error = paramLiError;
  }
  
  public LiThirdPartyAuthorizeResponse(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    statusCode = paramInt;
    Object localObject1;
    if (paramJSONObject.has("at"))
    {
      localObject1 = paramJSONObject.getJSONObject("at");
      if (((JSONObject)localObject1).has("access_token")) {
        m_accessToken = ((JSONObject)localObject1).getString("access_token");
      }
      if (((JSONObject)localObject1).has("expires_in"))
      {
        m_expiresOn = ((JSONObject)localObject1).getLong("expires_in");
        new StringBuilder("expires_in = ").append(m_expiresOn);
      }
    }
    if (paramJSONObject.has("appInfo"))
    {
      localObject1 = paramJSONObject.getJSONObject("appInfo");
      m_appName = ((JSONObject)localObject1).getString("name");
      if (((JSONObject)localObject1).has("logo")) {
        m_logo = ((JSONObject)localObject1).getString("logo");
      }
      localObject1 = paramJSONObject.getJSONArray("permInfo");
      if (localObject1 != null)
      {
        m_permissionInfoList = new ArrayList(((JSONArray)localObject1).length());
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
          String str1 = ((JSONObject)localObject2).getString("name");
          String str2 = ((JSONObject)localObject2).getString("title");
          localObject2 = ((JSONObject)localObject2).getString("description");
          m_permissionInfoList.add(new LiThirdPartyPermissionInfo(str1, str2, (String)localObject2));
          paramInt += 1;
        }
      }
    }
    if (paramJSONObject.has("error"))
    {
      errorInfo = paramJSONObject.getString("error");
      if (paramJSONObject.has("error_description")) {
        errorDescription = paramJSONObject.getString("error_description");
      }
      statusCode = 400;
      new StringBuilder("Error from uas ").append(errorInfo).append(" : ").append(errorDescription);
    }
    if (paramJSONObject.has("submitRequired")) {
      statusCode = 401;
    }
  }
  
  public static abstract interface AuthListener
  {
    public abstract void onResponse(LiThirdPartyAuthorizeResponse paramLiThirdPartyAuthorizeResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */