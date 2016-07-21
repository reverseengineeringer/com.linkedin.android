package com.linkedin.android.imageloader.interfaces;

import android.net.Uri;
import java.io.File;

public abstract interface ImageLoader
{
  public abstract ImageFetchRequest loadImageFromContentUri(Uri paramUri, ImageListener paramImageListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ImageFetchRequest loadImageFromFile(File paramFile, ImageListener paramImageListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ImageFetchRequest loadImageFromResource(int paramInt, ImageListener paramImageListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ImageFetchRequest loadImageFromUrl(String paramString, ImageListener paramImageListener, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */