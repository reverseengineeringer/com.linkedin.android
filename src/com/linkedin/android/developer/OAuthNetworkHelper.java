package com.linkedin.android.developer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.networking.response.RawResponseParseUtils;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OAuthNetworkHelper
{
  private static final String TAG = OAuthNetworkHelper.class.getSimpleName();
  public final Context context;
  public final FlagshipSharedPreferences flagshipSharedPreferences;
  public final NetworkClient networkClient;
  
  public OAuthNetworkHelper(Context paramContext, NetworkClient paramNetworkClient, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    context = paramContext;
    networkClient = paramNetworkClient;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
  }
  
  public final void getToken(String paramString1, String paramString2, String paramString3, final OAuthResponseListener paramOAuthResponseListener)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    localArrayMap1.put("X-IsAJAXForm", "1");
    ArrayMap localArrayMap2 = new ArrayMap();
    localArrayMap2.put("client_id", paramString1);
    localArrayMap2.put("client_secret", paramString3);
    localArrayMap2.put("scope", paramString2);
    paramString1 = createsetAdditionalHeaderssetParams"application/x-www-form-urlencoded"requestDelegate;
    paramString2 = new ResponseListener()
    {
      private Bundle parseSuccessResponse(RawResponse paramAnonymousRawResponse)
        throws IOException
      {
        try
        {
          paramAnonymousRawResponse = new JSONObject(RawResponseParseUtils.parseString(paramAnonymousRawResponse));
          if (paramAnonymousRawResponse.optString("status", "fail").equals("ok"))
          {
            paramAnonymousRawResponse = paramAnonymousRawResponse.getJSONObject("content");
            Bundle localBundle = new Bundle();
            localBundle.putInt("expires_in", paramAnonymousRawResponse.getInt("expires_in"));
            localBundle.putString("access_token", paramAnonymousRawResponse.getString("access_token"));
            flagshipSharedPreferences.setSamsungOAuth2Token(paramAnonymousRawResponse.getString("access_token"));
            return localBundle;
          }
          paramAnonymousRawResponse = paramAnonymousRawResponse.getJSONObject("errors");
          Log.e(OAuthNetworkHelper.TAG, "error " + paramAnonymousRawResponse.getString("error") + " : " + paramAnonymousRawResponse.getString("error_description"));
          throw new IOException("Response returned errors " + paramAnonymousRawResponse.getString("error") + " : " + paramAnonymousRawResponse.getString("error_description"));
        }
        catch (JSONException paramAnonymousRawResponse)
        {
          Log.e(OAuthNetworkHelper.TAG, "error in parse response", paramAnonymousRawResponse);
          throw new IOException(paramAnonymousRawResponse);
        }
      }
    };
    paramString1 = networkClient.factory.getRelativeRequest$3868be9b(1, "/uas/oauth2/createToken", paramString2, paramString1);
    networkClient.add(paramString1);
  }
  
  public static abstract interface OAuthResponseListener
  {
    public abstract void onFailure();
    
    public abstract void onSuccess(Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthNetworkHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */