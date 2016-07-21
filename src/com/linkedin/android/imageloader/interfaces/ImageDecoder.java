package com.linkedin.android.imageloader.interfaces;

import android.net.Uri;
import android.util.Pair;
import java.io.InputStream;

public abstract interface ImageDecoder
{
  public abstract ManagedBitmap decode(int paramInt, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ManagedBitmap decode(Uri paramUri, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ManagedBitmap decode(InputStream paramInputStream, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
  
  public abstract ManagedBitmap decode(String paramString, Pair<Integer, Integer> paramPair, ImageTransformer paramImageTransformer, PerfEventListener paramPerfEventListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ImageDecoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */