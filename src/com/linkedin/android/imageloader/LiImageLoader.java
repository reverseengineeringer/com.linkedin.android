package com.linkedin.android.imageloader;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageFetchRequest;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.imageloader.interfaces.ImageLoaderNetworkStack;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;
import com.linkedin.android.imageloader.requests.LiLocalContentUriImageFetchRequest;
import com.linkedin.android.imageloader.requests.LiLocalFileImageFetchRequest;
import com.linkedin.android.imageloader.requests.LiLocalResourceImageFetchRequest;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.File;

public class LiImageLoader
  implements ImageLoader
{
  private static final StringBuilder CACHE_KEY_BUILDER = new StringBuilder();
  private static final String TAG = LiImageLoader.class.getSimpleName();
  private final ByteArrayPool mByteArrayPool;
  private final Context mContext;
  private final ImageLoaderCache mImageCache;
  private final ImageDecoder mImageDecoder;
  private final ImageLoaderNetworkStack mNetworkStack;
  
  public LiImageLoader(Context paramContext, ImageLoaderNetworkStack paramImageLoaderNetworkStack, ImageDecoder paramImageDecoder, ImageLoaderCache paramImageLoaderCache, ByteArrayPool paramByteArrayPool)
  {
    FeatureLog.registerFeature("LI Image Loader");
    mContext = paramContext;
    mNetworkStack = paramImageLoaderNetworkStack;
    mImageDecoder = paramImageDecoder;
    mImageCache = paramImageLoaderCache;
    mByteArrayPool = paramByteArrayPool;
  }
  
  private static String getCacheKey(String paramString, ImageTransformer paramImageTransformer)
  {
    CACHE_KEY_BUILDER.setLength(0);
    if (paramImageTransformer != null) {
      CACHE_KEY_BUILDER.append(paramImageTransformer.getIdentifier());
    }
    if (CACHE_KEY_BUILDER.length() > 0) {
      CACHE_KEY_BUILDER.append(":");
    }
    CACHE_KEY_BUILDER.append(paramString);
    return CACHE_KEY_BUILDER.toString();
  }
  
  private ManagedBitmap getCachedBitMap(PerfEventListener paramPerfEventListener, String paramString)
  {
    if (paramPerfEventListener != null) {
      paramPerfEventListener.cacheLookupDidStart$1385ff();
    }
    paramString = mImageCache.get(paramString);
    if (paramPerfEventListener != null) {
      if (paramString == null) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      paramPerfEventListener.cacheLookupDidEnd$25decb5(bool);
      return paramString;
    }
  }
  
  private static void onGetImageError$5bc45bcf(String paramString, Exception paramException, ImageListener paramImageListener)
  {
    if (paramImageListener != null) {
      paramImageListener.onErrorResponse(paramString, paramException);
    }
  }
  
  private static void throwIfNotOnMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }
  }
  
  public final ImageFetchRequest loadImageFromContentUri(Uri paramUri, final ImageListener paramImageListener, ImageTransformer paramImageTransformer, final PerfEventListener paramPerfEventListener)
  {
    
    if (paramUri == null) {
      onGetImageError$5bc45bcf(null, new Exception("URI was null"), paramImageListener);
    }
    String str1;
    final String str2;
    ManagedBitmap localManagedBitmap;
    do
    {
      return null;
      str1 = paramUri.toString();
      str2 = getCacheKey(str1, paramImageTransformer);
      localManagedBitmap = getCachedBitMap(paramPerfEventListener, str2);
      if (localManagedBitmap == null) {
        break;
      }
    } while (paramImageListener == null);
    try
    {
      localManagedBitmap.retain();
      paramImageListener.onResponse(str1, localManagedBitmap, true);
      return null;
    }
    finally
    {
      localManagedBitmap.release();
    }
    LiLocalContentUriImageFetchRequest.startImageFetchRequest(mContext, paramUri, mImageDecoder, paramImageTransformer, new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        if (paramImageListener != null) {
          return paramImageListener.getTargetDimensions();
        }
        return null;
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        LiImageLoader.access$100$7891660f$5bc45bcf(paramAnonymousString, paramAnonymousException, paramImageListener);
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        LiImageLoader.access$000$676ebb83(LiImageLoader.this, paramAnonymousString, str2, paramAnonymousManagedBitmap, paramImageListener);
      }
    }, paramPerfEventListener, mByteArrayPool);
  }
  
  public final ImageFetchRequest loadImageFromFile(File paramFile, final ImageListener paramImageListener, ImageTransformer paramImageTransformer, final PerfEventListener paramPerfEventListener)
  {
    
    if (paramFile == null) {
      onGetImageError$5bc45bcf(null, new Exception("File was null"), paramImageListener);
    }
    String str1;
    final String str2;
    ManagedBitmap localManagedBitmap;
    do
    {
      return null;
      str1 = Utils.getFileUrl(paramFile);
      str2 = getCacheKey(str1, paramImageTransformer);
      localManagedBitmap = getCachedBitMap(paramPerfEventListener, str2);
      if (localManagedBitmap == null) {
        break;
      }
    } while (paramImageListener == null);
    try
    {
      localManagedBitmap.retain();
      paramImageListener.onResponse(str1, localManagedBitmap, true);
      return null;
    }
    finally
    {
      localManagedBitmap.release();
    }
    LiLocalFileImageFetchRequest.startFileImageFetchRequest(paramFile, mImageDecoder, paramImageTransformer, new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        if (paramImageListener != null) {
          return paramImageListener.getTargetDimensions();
        }
        return null;
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        LiImageLoader.access$100$7891660f$5bc45bcf(paramAnonymousString, paramAnonymousException, paramImageListener);
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        LiImageLoader.access$000$676ebb83(LiImageLoader.this, paramAnonymousString, str2, paramAnonymousManagedBitmap, paramImageListener);
      }
    }, paramPerfEventListener);
  }
  
  public final ImageFetchRequest loadImageFromResource(int paramInt, final ImageListener paramImageListener, ImageTransformer paramImageTransformer, final PerfEventListener paramPerfEventListener)
  {
    throwIfNotOnMainThread();
    String str1 = Utils.getResourceUrl(mContext, paramInt);
    final String str2 = getCacheKey(str1, paramImageTransformer);
    ManagedBitmap localManagedBitmap = getCachedBitMap(paramPerfEventListener, str2);
    if (localManagedBitmap != null)
    {
      if (paramImageListener != null) {}
      try
      {
        localManagedBitmap.retain();
        paramImageListener.onResponse(str1, localManagedBitmap, true);
        return null;
      }
      finally
      {
        localManagedBitmap.release();
      }
    }
    LiLocalResourceImageFetchRequest.startResourceImageFetchRequest(mContext, paramInt, mImageDecoder, paramImageTransformer, new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        if (paramImageListener != null) {
          return paramImageListener.getTargetDimensions();
        }
        return null;
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        LiImageLoader.access$100$7891660f$5bc45bcf(paramAnonymousString, paramAnonymousException, paramImageListener);
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        LiImageLoader.access$000$676ebb83(LiImageLoader.this, paramAnonymousString, str2, paramAnonymousManagedBitmap, paramImageListener);
      }
    }, paramPerfEventListener);
  }
  
  public final ImageFetchRequest loadImageFromUrl(String paramString, final ImageListener paramImageListener, ImageTransformer paramImageTransformer, final PerfEventListener paramPerfEventListener)
  {
    
    if (paramString == null) {
      onGetImageError$5bc45bcf(null, new Exception("URL was null"), paramImageListener);
    }
    final String str;
    ManagedBitmap localManagedBitmap;
    do
    {
      return null;
      str = getCacheKey(paramString, paramImageTransformer);
      localManagedBitmap = getCachedBitMap(paramPerfEventListener, str);
      if (localManagedBitmap == null) {
        break;
      }
    } while (paramImageListener == null);
    try
    {
      localManagedBitmap.retain();
      paramImageListener.onResponse(paramString, localManagedBitmap, true);
      return null;
    }
    finally
    {
      localManagedBitmap.release();
    }
    mNetworkStack.loadImage(mContext, paramString, mImageDecoder, paramImageTransformer, new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        if (paramImageListener != null) {
          return paramImageListener.getTargetDimensions();
        }
        return null;
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        LiImageLoader.access$100$7891660f$5bc45bcf(paramAnonymousString, paramAnonymousException, paramImageListener);
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        LiImageLoader.access$000$676ebb83(LiImageLoader.this, paramAnonymousString, str, paramAnonymousManagedBitmap, paramImageListener);
      }
    }, paramPerfEventListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */