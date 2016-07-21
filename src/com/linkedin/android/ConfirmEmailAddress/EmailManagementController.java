package com.linkedin.android.ConfirmEmailAddress;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.networking.response.RawResponseParseUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailManagementController
{
  public static final String TAG = EmailManagementController.class.getName();
  public final Context mContext;
  public final AbstractNetworkClient mNetworkClient;
  
  public EmailManagementController(AbstractNetworkClient paramAbstractNetworkClient, Context paramContext)
  {
    mNetworkClient = paramAbstractNetworkClient;
    mContext = paramContext;
  }
  
  public final ResponseListener<JSONObject, Object> getResponseListener(final ResultListener paramResultListener)
  {
    new ResponseListener()
    {
      private static JSONObject parseSuccessResponse(RawResponse paramAnonymousRawResponse)
        throws IOException
      {
        paramAnonymousRawResponse = RawResponseParseUtils.parseString(paramAnonymousRawResponse);
        if (paramAnonymousRawResponse == null) {
          return null;
        }
        try
        {
          paramAnonymousRawResponse = new JSONObject(paramAnonymousRawResponse);
          return paramAnonymousRawResponse;
        }
        catch (JSONException paramAnonymousRawResponse)
        {
          Log.e(EmailManagementController.TAG, "Failed to parse response", paramAnonymousRawResponse);
          throw new IOException("Failed to parse JSON");
        }
      }
      
      public final void onFailure(int paramAnonymousInt, Object paramAnonymousObject, Map<String, List<String>> paramAnonymousMap, IOException paramAnonymousIOException)
      {
        Log.e(EmailManagementController.TAG, "Failed to send email confirmation message", paramAnonymousIOException);
        paramResultListener.onResult(new EmailManagementController.Result(false, null));
      }
      
      public final Object parseErrorResponse(RawResponse paramAnonymousRawResponse)
        throws IOException
      {
        return null;
      }
    };
  }
  
  public final void send(String paramString1, String paramString2, String paramString3, ResultListener paramResultListener)
  {
    ArrayMap localArrayMap = new ArrayMap(3);
    localArrayMap.put("emailAddress", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayMap.put("emailKey", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localArrayMap.put("completionRedirUrlAlias", paramString3);
    }
    paramString1 = mNetworkClient.getRequestFactory().getAbsoluteRequest$3868be9b(1, "https://www.linkedin.com/psettings/email/emailConfirmationMessages", getResponseListener(paramResultListener), createsetParams"application/x-www-form-urlencoded"requestDelegate);
    mNetworkClient.add(paramString1);
  }
  
  public static final class Result
  {
    public final JSONObject response;
    public final boolean success;
    
    Result(boolean paramBoolean, JSONObject paramJSONObject)
    {
      success = paramBoolean;
      response = paramJSONObject;
    }
  }
  
  public static abstract interface ResultListener
  {
    public abstract void onResult(EmailManagementController.Result paramResult);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.EmailManagementController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */