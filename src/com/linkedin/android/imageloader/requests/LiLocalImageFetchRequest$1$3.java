package com.linkedin.android.imageloader.requests;

import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

final class LiLocalImageFetchRequest$1$3
  implements Runnable
{
  LiLocalImageFetchRequest$1$3(LiLocalImageFetchRequest.1 param1, ManagedBitmap paramManagedBitmap) {}
  
  public final void run()
  {
    try
    {
      this$1.val$listener.onResponse(this$1.this$0.getResourceURI(), val$managedBitmap, true);
      return;
    }
    finally
    {
      val$managedBitmap.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalImageFetchRequest.1.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */