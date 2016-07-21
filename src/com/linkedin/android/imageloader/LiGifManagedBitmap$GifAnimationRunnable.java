package com.linkedin.android.imageloader;

import android.graphics.Bitmap;
import java.util.List;

final class LiGifManagedBitmap$GifAnimationRunnable
  implements Runnable
{
  private LiGifManagedBitmap$GifAnimationRunnable(LiGifManagedBitmap paramLiGifManagedBitmap) {}
  
  public final void run()
  {
    label50:
    int j;
    try
    {
      bool = LiGifManagedBitmap.access$100(this$0);
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
      if (!LiGifManagedBitmap.access$100(this$0)) {
        break label329;
      }
      LiGifManagedBitmap.access$500(this$0);
    }
    m = access$200this$0).header.frameCount;
    break label332;
    if ((j < m) && (LiGifManagedBitmap.access$300(this$0)) && (!LiGifManagedBitmap.access$100(this$0)))
    {
      l = System.nanoTime();
      localBitmap = LiGifManagedBitmap.access$200(this$0).getNextFrame();
      l = (System.nanoTime() - l) / 1000000L;
      if ((LiGifManagedBitmap.access$300(this$0)) && (!LiGifManagedBitmap.access$100(this$0)))
      {
        LiGifManagedBitmap.access$200(this$0).advance();
        localGifDecoder = LiGifManagedBitmap.access$200(this$0);
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
      LiGifManagedBitmap.access$402(this$0, localBitmap);
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
          bool = LiGifManagedBitmap.access$300(this$0);
          if (!bool)
          {
            if (!LiGifManagedBitmap.access$100(this$0)) {
              break;
            }
            LiGifManagedBitmap.access$500(this$0);
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

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiGifManagedBitmap.GifAnimationRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */