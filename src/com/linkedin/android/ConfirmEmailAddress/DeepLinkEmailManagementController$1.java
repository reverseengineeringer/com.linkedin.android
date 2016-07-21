package com.linkedin.android.ConfirmEmailAddress;

import android.util.Log;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.linkedin.android.Constants;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class DeepLinkEmailManagementController$1
  implements ResponseListener<String, Object>
{
  public DeepLinkEmailManagementController$1(DeepLinkEmailManagementController paramDeepLinkEmailManagementController, DeepLinkEmailManagementController.ResultListener paramResultListener, String paramString) {}
  
  private static String parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    JsonParser localJsonParser;
    try
    {
      localJsonParser = Constants.JSON_FACTORY.createParser(paramRawResponse.body(false));
      localObject1 = localJsonParser;
      if (localJsonParser.getCurrentToken() == null)
      {
        localObject1 = localJsonParser;
        localJsonParser.nextToken();
      }
      localObject1 = localJsonParser;
      if (localJsonParser.getCurrentToken() != JsonToken.START_OBJECT)
      {
        localObject1 = localJsonParser;
        localJsonParser.skipChildren();
        localObject1 = localJsonParser;
        throw new IOException("Server returned malformatted JSON. Failed to find '{' when building JSON object");
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
    try
    {
      ((JsonParser)localObject1).close();
      throw paramRawResponse;
      do
      {
        do
        {
          localObject1 = localJsonParser;
          paramRawResponse = (RawResponse)localObject2;
          if (localJsonParser.nextToken() == JsonToken.END_OBJECT) {
            break;
          }
          localObject1 = localJsonParser;
          paramRawResponse = localJsonParser.getCurrentName();
        } while (paramRawResponse == null);
        localObject1 = localJsonParser;
      } while (!paramRawResponse.equals("emailAddress"));
      localObject1 = localJsonParser;
      localJsonParser.nextToken();
      localObject1 = localJsonParser;
      paramRawResponse = localJsonParser.getValueAsString();
      if (localJsonParser != null) {}
      try
      {
        localJsonParser.close();
        return paramRawResponse;
      }
      catch (IOException localIOException1)
      {
        Log.e(DeepLinkEmailManagementController.access$000(), "Unable to close JSON parser", localIOException1);
        return paramRawResponse;
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e(DeepLinkEmailManagementController.access$000(), "Unable to close JSON parser", localIOException2);
      }
    }
  }
  
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
  {
    Log.e(DeepLinkEmailManagementController.access$000(), "Failed to confirm email", paramIOException);
    val$resultListener.onResult(DeepLinkEmailManagementController.Result.fail(Integer.valueOf(paramInt)));
  }
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */