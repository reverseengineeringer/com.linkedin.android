package com.linkedin.android.imageloader.requests;

import com.linkedin.android.imageloader.interfaces.ImageListener;

final class LiLocalImageFetchRequest$1$2
  implements Runnable
{
  LiLocalImageFetchRequest$1$2(LiLocalImageFetchRequest.1 param1, Exception paramException) {}
  
  public final void run()
  {
    this$1.val$listener.onErrorResponse(this$1.this$0.getResourceURI(), val$exception);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalImageFetchRequest.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */