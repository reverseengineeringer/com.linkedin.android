package com.linkedin.android.imageloader;

import android.graphics.Bitmap;
import com.linkedin.android.imageloader.interfaces.IBitmapFactory;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.util.ByteArrayPool;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiGifManagedBitmap
  extends LiManagedBitmap
{
  private static final String TAG = LiGifManagedBitmap.class.getSimpleName();
  private ExecutorService mAnimationExecutorService;
  private volatile Bitmap mCurrentBitmap;
  GifDecoder mDecoder;
  private volatile boolean mIsAnimating;
  private volatile boolean mIsRecycled;
  
  public LiGifManagedBitmap(GifDecoder paramGifDecoder, Bitmap paramBitmap, IBitmapFactory paramIBitmapFactory)
  {
    super(paramBitmap, paramIBitmapFactory);
    mCurrentBitmap = paramBitmap;
    mDecoder = paramGifDecoder;
  }
  
  private void cleanup()
  {
    try
    {
      GifDecoder localGifDecoder = mDecoder;
      header = null;
      if (mainPixels != null) {
        byteArrayPool.returnBuf(mainPixels);
      }
      if (mainScratch != null) {
        intArrayPool.returnBuf(mainScratch);
      }
      if (previousImage != null) {
        bitmapFactory.recycle(previousImage);
      }
      previousImage = null;
      rawData = null;
      isFirstFrameTransparent = false;
      if (block != null) {
        byteArrayPool.returnBuf(block);
      }
      if (workBuffer != null) {
        byteArrayPool.returnBuf(workBuffer);
      }
      mDecoder = null;
      mCurrentBitmap = null;
      mBitmapFactory = null;
      mAnimationExecutorService.shutdownNow();
      mAnimationExecutorService = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void finalize()
    throws Throwable
  {
    if ((mDecoder != null) || (mBitmapFactory != null))
    {
      if (DEBUG_RETAIN_RELEASE)
      {
        Log.e(TAG, "RefCount: " + mRefCount + "\n");
        Iterator localIterator = mRetainReleaseTraces.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.e(TAG, str + "\n");
        }
      }
      throw new RuntimeException("Frames were non-null when managed bitmap was finalized");
    }
    super.finalize();
  }
  
  public final Bitmap getBitmap()
  {
    return mCurrentBitmap;
  }
  
  public final int getSize()
  {
    if (mBitmapSize > 0) {
      return mBitmapSize;
    }
    if (mDecoder != null) {
      mBitmapSize = (mDecoder.byteSize / 1024);
    }
    return mBitmapSize;
  }
  
  public final boolean isGif()
  {
    return true;
  }
  
  public final void pauseAnimation()
  {
    mIsAnimating = false;
    if ((mAnimationExecutorService != null) && (!mAnimationExecutorService.isShutdown())) {
      mAnimationExecutorService.shutdownNow();
    }
  }
  
  final void recycle()
  {
    if ((mDecoder == null) || (mBitmapFactory == null))
    {
      if (DEBUG_RETAIN_RELEASE) {
        Log.e(TAG, "RefCount: " + mRefCount + "\n" + mRetainReleaseTraces.toString());
      }
      throw new RuntimeException("Bitmap was null when recycle was called");
    }
    mIsRecycled = true;
    if (!mIsAnimating)
    {
      cleanup();
      return;
    }
    mIsAnimating = false;
  }
  
  public final void startAnimation()
  {
    if (mIsRecycled) {
      Log.e(TAG, "Cannot start animation on recycled instance");
    }
    do
    {
      return;
      mIsAnimating = true;
    } while (mDecoder == null);
    if ((mAnimationExecutorService == null) || (mAnimationExecutorService.isShutdown())) {
      mAnimationExecutorService = Executors.newSingleThreadExecutor();
    }
    mAnimationExecutorService.execute(new GifAnimationRunnable((byte)0));
  }
  
  private final class GifAnimationRunnable
    implements Runnable
  {
    private GifAnimationRunnable() {}
    
    public final void run()
    {
      label50:
      int j;
      try
      {
        bool = mIsRecycled;
        if (bool) {
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        int m;
        long l;
        Bitmap localBitmap;
        GifDecoder localGifDecoder;
        return;
      }
      finally
      {
        if (!mIsRecycled) {
          break label329;
        }
        LiGifManagedBitmap.this.cleanup();
      }
      m = mDecoder.header.frameCount;
      break label332;
      if ((j < m) && (mIsAnimating) && (!mIsRecycled))
      {
        l = System.nanoTime();
        localBitmap = mDecoder.getNextFrame();
        l = (System.nanoTime() - l) / 1000000L;
        if ((mIsAnimating) && (!mIsRecycled))
        {
          mDecoder.advance();
          localGifDecoder = mDecoder;
          if (header.frameCount <= 0) {
            break label337;
          }
          if (framePointer < 0) {
            break label337;
          }
        }
      }
      for (;;)
      {
        l = i - l;
        if (l > 0L) {
          Thread.sleep(l);
        }
        LiGifManagedBitmap.access$402(LiGifManagedBitmap.this, localBitmap);
        j += 1;
        break label50;
        int n = framePointer;
        int k = -1;
        int i = k;
        if (n >= 0)
        {
          i = k;
          if (n < header.frameCount)
          {
            i = header.frames.get(n)).delay;
            continue;
            bool = mIsAnimating;
            if (!bool)
            {
              if (!mIsRecycled) {
                break;
              }
              LiGifManagedBitmap.this.cleanup();
              return;
            }
            label329:
            label332:
            j = 0;
            break label50;
            label337:
            i = 0;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiGifManagedBitmap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */