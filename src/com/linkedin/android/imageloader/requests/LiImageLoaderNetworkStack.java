package com.linkedin.android.imageloader.requests;

import android.content.Context;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageFetchRequest;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageLoaderNetworkStack;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import com.linkedin.android.networking.AbstractNetworkClient;

public final class LiImageLoaderNetworkStack
  implements ImageLoaderNetworkStack
{
  private final AbstractNetworkClient mNetworkClient;
  
  public LiImageLoaderNetworkStack(AbstractNetworkClient paramAbstractNetworkClient)
  {
    mNetworkClient = paramAbstractNetworkClient;
  }
  
  public final ImageFetchRequest loadImage(Context paramContext, String paramString, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener)
  {
    paramContext = new LiNetworkImageFetchRequest(paramContext, paramString, paramImageDecoder, paramImageTransformer, paramImageListener, paramPerfEventListener);
    mNetworkClient.add(paramContext);
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiImageLoaderNetworkStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */