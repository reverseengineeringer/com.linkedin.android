package com.linkedin.android.networking;

import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.response.LinkedInRawResponse;
import com.linkedin.android.networking.util.ExceptionUtil;

final class LinkedInNetwork$5
  implements Runnable
{
  LinkedInNetwork$5(LinkedInNetwork paramLinkedInNetwork, AbstractRequest paramAbstractRequest, LinkedInRawResponse paramLinkedInRawResponse, Throwable paramThrowable) {}
  
  public final void run()
  {
    LinkedInNetwork.access$100$f8801a9(val$request).onFailure(val$rawResponse.code(), null, val$rawResponse.responseHeaders, ExceptionUtil.asIOException(val$e));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */