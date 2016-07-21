package com.linkedin.android.imageloader.requests;

import android.util.Pair;
import com.linkedin.android.imageloader.Utils;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import java.io.File;

public final class LiLocalFileImageFetchRequest
  extends LiLocalImageFetchRequest
{
  private final File mFile;
  private final ImageListener mImageListener;
  private final ImageTransformer mImageTransformer;
  private final PerfEventListener mPerfEventListener;
  
  private LiLocalFileImageFetchRequest(File paramFile, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener)
  {
    super(paramImageListener, paramImageDecoder);
    mFile = paramFile;
    mImageTransformer = paramImageTransformer;
    mImageListener = paramImageListener;
    mPerfEventListener = paramPerfEventListener;
  }
  
  public static LiLocalImageFetchRequest startFileImageFetchRequest(File paramFile, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener)
  {
    return new LiLocalFileImageFetchRequest(paramFile, paramImageDecoder, paramImageTransformer, paramImageListener, paramPerfEventListener).startDecode();
  }
  
  protected final ManagedBitmap decode()
  {
    Pair localPair = null;
    if (mImageListener != null) {
      localPair = mImageListener.getTargetDimensions();
    }
    return mImageDecoder.decode(mFile.getAbsolutePath(), localPair, mImageTransformer, mPerfEventListener);
  }
  
  protected final long getResourceSize()
  {
    return mFile.length();
  }
  
  protected final String getResourceURI()
  {
    return Utils.getFileUrl(mFile);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiLocalFileImageFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */