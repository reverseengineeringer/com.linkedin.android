package com.linkedin.android.networking;

import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.response.LinkedInRawResponse;

final class LinkedInNetwork$3
  implements Runnable
{
  LinkedInNetwork$3(LinkedInNetwork paramLinkedInNetwork, AbstractRequest paramAbstractRequest, LinkedInRawResponse paramLinkedInRawResponse, Object paramObject) {}
  
  public final void run()
  {
    LinkedInNetwork.access$100$f8801a9(val$request).onSuccess(val$rawResponse.code(), val$successResponse, val$rawResponse.responseHeaders);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */