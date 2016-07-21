package com.linkedin.android.imageloader;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class PoolingBitmapFactory$BitmapPool
{
  final Set<SoftReference<Bitmap>> mReusableBitmaps = new HashSet();
  
  public final Bitmap get(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject2 = null;
    Set localSet = mReusableBitmaps;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        Iterator localIterator;
        if (!mReusableBitmaps.isEmpty())
        {
          localIterator = mReusableBitmaps.iterator();
          localObject1 = localObject2;
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap == null) || (!localBitmap.isMutable())) {
              continue;
            }
            localObject1 = localBitmap.getConfig();
            if (localObject1 != Bitmap.Config.ARGB_8888) {
              continue;
            }
            i = 4;
            if (paramConfig != null) {
              break label215;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            if ((localObject1 != localBitmap.getConfig()) || (paramInt1 * paramInt2 * i > localBitmap.getAllocationByteCount())) {
              break label221;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localObject1 = localBitmap;
            localIterator.remove();
          }
        }
        return (Bitmap)localObject1;
        if (localObject1 == Bitmap.Config.RGB_565)
        {
          i = 2;
          continue;
        }
        if (localObject1 == Bitmap.Config.ARGB_4444)
        {
          i = 2;
          continue;
        }
        localObject1 = Bitmap.Config.ALPHA_8;
        i = 1;
        continue;
        localIterator.remove();
        continue;
        localObject1 = paramConfig;
      }
      finally {}
      label215:
      continue;
      label221:
      int i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.PoolingBitmapFactory.BitmapPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */