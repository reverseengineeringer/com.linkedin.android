package com.linkedin.android.imageloader.interfaces;

import android.content.Context;

public abstract interface ImageLoaderNetworkStack
{
  public abstract ImageFetchRequest loadImage(Context paramContext, String paramString, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, PerfEventListener paramPerfEventListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ImageLoaderNetworkStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */