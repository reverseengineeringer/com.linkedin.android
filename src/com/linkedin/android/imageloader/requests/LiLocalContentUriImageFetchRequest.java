package com.linkedin.android.imageloader.requests;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import com.linkedin.android.networking.util.ByteArrayPool;

public class LiLocalContentUriImageFetchRequest
  extends LiLocalImageFetchRequest
{
  private static final String TAG = LiLocalContentUriImageFetchRequest.class.getSimpleName();
  private final ByteArrayPool mByteArrayPool;
  private final Uri mContentUri;
  private final Context mContext;
  private final ImageListener mImageListener;
  private final ImageTransformer mImageTransformer;
  private final PerfEventListener mPerfEventListener;
  
  private LiLocalContentUriImageFetchRequest(Context paramContext, Uri paramUri, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener, ByteArrayPool paramByteArrayPool)
  {
    super(paramImageListener, paramImageDecoder);
    mContext = paramContext;
    mContentUri = paramUri;
    mImageTransformer = paramImageTransformer;
    mImageListener = paramImageListener;
    mPerfEventListener = paramPerfEventListener;
    mByteArrayPool = paramByteArrayPool;
  }
  
  public static LiLocalImageFetchRequest startImageFetchRequest(Context paramContext, Uri paramUri, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener, ByteArrayPool paramByteArrayPool)
  {
    return new LiLocalContentUriImageFetchRequest(paramContext, paramUri, paramImageDecoder, paramImageTransformer, paramImageListener, paramPerfEventListener, paramByteArrayPool).startDecode();
  }
  
  protected final ManagedBitmap decode()
  {
    Pair localPair = null;
    if (mImageListener != null) {
      localPair = mImageListener.getTargetDimensions();
    }
    return mImageDecoder.decode(mContentUri, localPair, mImageTransformer, mPerfEventListener);
  }
  
  protected final long getResourceSize()
  {
    return -1L;
  }
  
  protected final String getResourceURI()
  {
    return mContentUri.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalContentUriImageFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */