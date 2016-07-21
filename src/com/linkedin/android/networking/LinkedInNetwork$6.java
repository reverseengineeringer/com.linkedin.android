package com.linkedin.android.networking;

import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.util.ExceptionUtil;

final class LinkedInNetwork$6
  implements Runnable
{
  LinkedInNetwork$6(LinkedInNetwork paramLinkedInNetwork, AbstractRequest paramAbstractRequest, Throwable paramThrowable) {}
  
  public final void run()
  {
    LinkedInNetwork.access$100$f8801a9(val$request).onFailure(400, null, null, ExceptionUtil.asIOException(val$e));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.LinkedInNetwork.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */