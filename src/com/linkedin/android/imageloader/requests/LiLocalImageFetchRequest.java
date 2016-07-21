package com.linkedin.android.imageloader.requests;

import android.os.Handler;
import android.os.Looper;
import com.linkedin.android.imageloader.LiImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageFetchRequest;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.logger.Log;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class LiLocalImageFetchRequest
  implements ImageFetchRequest
{
  private static final Executor DECODE_EXECUTOR = Executors.newSingleThreadExecutor();
  private static final String TAG = LiLocalImageFetchRequest.class.getSimpleName();
  private final Runnable mDecodeRunnable;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  protected final ImageDecoder mImageDecoder;
  private boolean mIsCancelled;
  private ManagedBitmap mManagedBitmap;
  
  protected LiLocalImageFetchRequest(final ImageListener paramImageListener, ImageDecoder paramImageDecoder)
  {
    mImageDecoder = paramImageDecoder;
    mDecodeRunnable = new Runnable()
    {
      private void handleError(final Exception paramAnonymousException)
      {
        if (paramImageListener != null) {
          mHandler.post(new Runnable()
          {
            public final void run()
            {
              val$listener.onErrorResponse(getResourceURI(), paramAnonymousException);
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
            LiLocalImageFetchRequest.access$002(LiLocalImageFetchRequest.this, decode());
            if (mManagedBitmap == null)
            {
              handleError(new IOException("Exception when decoding bitmap"));
              return;
            }
          }
          localManagedBitmap = mManagedBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Log.e(LiLocalImageFetchRequest.TAG, "Caught OOM for " + getResourceSize() + " byte image, URI=" + getResourceURI());
          handleError(new IOException(localOutOfMemoryError));
          return;
          if (mIsCancelled)
          {
            mHandler.post(new Runnable()
            {
              public final void run()
              {
                mManagedBitmap.release();
              }
            });
            handleError(new IOException("Request cancelled"));
            return;
          }
        }
        catch (Exception localException)
        {
          Log.e(LiLocalImageFetchRequest.TAG, "Error decoding bitmap. This occurs when the image file is malformed or empty.", localException);
          handleError(localException);
          return;
        }
        final ManagedBitmap localManagedBitmap;
        if (paramImageListener != null)
        {
          mHandler.post(new Runnable()
          {
            public final void run()
            {
              try
              {
                val$listener.onResponse(getResourceURI(), localManagedBitmap, true);
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
    };
  }
  
  protected abstract ManagedBitmap decode();
  
  protected abstract long getResourceSize();
  
  protected abstract String getResourceURI();
  
  protected final LiLocalImageFetchRequest startDecode()
  {
    DECODE_EXECUTOR.execute(mDecodeRunnable);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalImageFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */