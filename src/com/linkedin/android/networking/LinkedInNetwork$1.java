package com.linkedin.android.networking;

import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class LinkedInNetwork$1
  implements ResponseListener<Object, Object>
{
  public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException) {}
  
  public final void onSuccess(int paramInt, Object paramObject, Map<String, List<String>> paramMap) {}
  
  public final Object parseErrorResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
  
  public final Object parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */