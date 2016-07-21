package com.linkedin.android.networking;

import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.response.LinkedInRawResponse;
import java.io.IOException;

final class LinkedInNetwork$4
  implements Runnable
{
  LinkedInNetwork$4(LinkedInNetwork paramLinkedInNetwork, AbstractRequest paramAbstractRequest, LinkedInRawResponse paramLinkedInRawResponse, Object paramObject) {}
  
  public final void run()
  {
    LinkedInNetwork.access$100$f8801a9(val$request).onFailure(val$rawResponse.code(), val$errorResponse, val$rawResponse.responseHeaders, new IOException("Status code: " + val$rawResponse.code()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */