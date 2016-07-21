package com.linkedin.android.imageloader.requests;

import android.content.Context;
import android.util.Pair;
import com.linkedin.android.imageloader.Utils;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;

public final class LiLocalResourceImageFetchRequest
  extends LiLocalImageFetchRequest
{
  private final Context mContext;
  private final int mDrawableResource;
  private final ImageListener mImageListener;
  private final ImageTransformer mImageTransformer;
  private final PerfEventListener mPerfEventListener;
  
  private LiLocalResourceImageFetchRequest(Context paramContext, int paramInt, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener)
  {
    super(paramImageListener, paramImageDecoder);
    mContext = paramContext.getApplicationContext();
    mDrawableResource = paramInt;
    mImageTransformer = paramImageTransformer;
    mImageListener = paramImageListener;
    mPerfEventListener = paramPerfEventListener;
  }
  
  public static LiLocalImageFetchRequest startResourceImageFetchRequest(Context paramContext, int paramInt, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener)
  {
    return new LiLocalResourceImageFetchRequest(paramContext, paramInt, paramImageDecoder, paramImageTransformer, paramImageListener, paramPerfEventListener).startDecode();
  }
  
  protected final ManagedBitmap decode()
  {
    Pair localPair = null;
    if (mImageListener != null) {
      localPair = mImageListener.getTargetDimensions();
    }
    return mImageDecoder.decode(mDrawableResource, localPair, mImageTransformer, mPerfEventListener);
  }
  
  protected final long getResourceSize()
  {
    return -1L;
  }
  
  protected final String getResourceURI()
  {
    return Utils.getResourceUrl(mContext, mDrawableResource);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalResourceImageFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */