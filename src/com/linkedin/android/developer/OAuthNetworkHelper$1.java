package com.linkedin.android.developer;

import android.os.Bundle;
import android.util.Log;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.response.RawResponseParseUtils;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

final class OAuthNetworkHelper$1
  implements ResponseListener<Bundle, JSONObject>
{
  OAuthNetworkHelper$1(OAuthNetworkHelper paramOAuthNetworkHelper, OAuthNetworkHelper.OAuthResponseListener paramOAuthResponseListener) {}
  
  private Bundle parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    try
    {
      paramRawResponse = new JSONObject(RawResponseParseUtils.parseString(paramRawResponse));
      if (paramRawResponse.optString("status", "fail").equals("ok"))
      {
        paramRawResponse = paramRawResponse.getJSONObject("content");
        Bundle localBundle = new Bundle();
        localBundle.putInt("expires_in", paramRawResponse.getInt("expires_in"));
        localBundle.putString("access_token", paramRawResponse.getString("access_token"));
        OAuthNetworkHelper.access$000(this$0).setSamsungOAuth2Token(paramRawResponse.getString("access_token"));
        return localBundle;
      }
      paramRawResponse = paramRawResponse.getJSONObject("errors");
      Log.e(OAuthNetworkHelper.access$100(), "error " + paramRawResponse.getString("error") + " : " + paramRawResponse.getString("error_description"));
      throw new IOException("Response returned errors " + paramRawResponse.getString("error") + " : " + paramRawResponse.getString("error_description"));
    }
    catch (JSONException paramRawResponse)
    {
      Log.e(OAuthNetworkHelper.access$100(), "error in parse response", paramRawResponse);
      throw new IOException(paramRawResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthNetworkHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */