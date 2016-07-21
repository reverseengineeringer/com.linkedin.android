package com.linkedin.android.ConfirmEmailAddress;

import android.util.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.response.RawResponseParseUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class EmailManagementController$1
  implements ResponseListener<JSONObject, Object>
{
  EmailManagementController$1(EmailManagementController paramEmailManagementController, EmailManagementController.ResultListener paramResultListener) {}
  
  private static JSONObject parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    paramRawResponse = RawResponseParseUtils.parseString(paramRawResponse);
    if (paramRawResponse == null) {
      return null;
    }
    try
    {
      paramRawResponse = new JSONObject(paramRawResponse);
      return paramRawResponse;
    }
    catch (JSONException paramRawResponse)
    {
      Log.e(EmailManagementController.access$000(), "Failed to parse response", paramRawResponse);
      throw new IOException("Failed to parse JSON");
    }
  }
  
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
  {
    Log.e(EmailManagementController.access$000(), "Failed to send email confirmation message", paramIOException);
    val$resultListener.onResult(new EmailManagementController.Result(false, null));
  }
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.EmailManagementController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */