package com.linkedin.android.imageloader.requests;

import android.os.Handler;
import com.linkedin.android.imageloader.LiImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.logger.Log;
import java.io.IOException;

final class LiLocalImageFetchRequest$1
  implements Runnable
{
  LiLocalImageFetchRequest$1(LiLocalImageFetchRequest paramLiLocalImageFetchRequest, ImageListener paramImageListener) {}
  
  private void handleError(final Exception paramException)
  {
    if (val$listener != null) {
      LiLocalImageFetchRequest.access$200(this$0).post(new Runnable()
      {
        public final void run()
        {
          val$listener.onErrorResponse(this$0.getResourceURI(), paramException);
        }
      });
    }
  }
  
  public final void run()
  {
    try
    {
      synchronized (LiImageDecoder.sDecodeLock)
      {
        LiLocalImageFetchRequest.access$002(this$0, this$0.decode());
        if (LiLocalImageFetchRequest.access$000(this$0) == null)
        {
          handleError(new IOException("Exception when decoding bitmap"));
          return;
        }
      }
      localManagedBitmap = LiLocalImageFetchRequest.access$000(this$0);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e(LiLocalImageFetchRequest.access$300(), "Caught OOM for " + this$0.getResourceSize() + " byte image, URI=" + this$0.getResourceURI());
      handleError(new IOException(localOutOfMemoryError));
      return;
      if (LiLocalImageFetchRequest.access$100(this$0))
      {
        LiLocalImageFetchRequest.access$200(this$0).post(new Runnable()
        {
          public final void run()
          {
            LiLocalImageFetchRequest.access$000(this$0).release();
          }
        });
        handleError(new IOException("Request cancelled"));
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(LiLocalImageFetchRequest.access$300(), "Error decoding bitmap. This occurs when the image file is malformed or empty.", localException);
      handleError(localException);
      return;
    }
    final ManagedBitmap localManagedBitmap;
    if (val$listener != null)
    {
      LiLocalImageFetchRequest.access$200(this$0).post(new Runnable()
      {
        public final void run()
        {
          try
          {
            val$listener.onResponse(this$0.getResourceURI(), localManagedBitmap, true);
            return;
          }
          finally
          {
            localManagedBitmap.release();
          }
        }
      });
      return;
    }
    localManagedBitmap.release();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalImageFetchRequest.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */