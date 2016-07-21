package com.google.android.exoplayer.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.upstream.UriLoadable;
import com.google.android.exoplayer.upstream.UriLoadable.Parser;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public final class ManifestFetcher<T>
  implements Loader.Callback
{
  private long currentLoadStartTimestamp;
  private UriLoadable<T> currentLoadable;
  private final Handler eventHandler;
  private final EventListener eventListener;
  private IOException loadException;
  private int loadExceptionCount;
  private long loadExceptionTimestamp;
  volatile T manifest;
  volatile long manifestLoadCompleteTimestamp;
  volatile long manifestLoadStartTimestamp;
  public volatile String manifestUri;
  public final UriLoadable.Parser<T> parser;
  public final UriDataSource uriDataSource;
  
  public ManifestFetcher(String paramString, UriDataSource paramUriDataSource, UriLoadable.Parser<T> paramParser)
  {
    this(paramString, paramUriDataSource, paramParser, (byte)0);
  }
  
  private ManifestFetcher(String paramString, UriDataSource paramUriDataSource, UriLoadable.Parser<T> paramParser, byte paramByte)
  {
    parser = paramParser;
    manifestUri = paramString;
    uriDataSource = paramUriDataSource;
    eventHandler = null;
    eventListener = null;
  }
  
  public final void onLoadCanceled$35e469eb() {}
  
  public final void onLoadCompleted(Loader.Loadable paramLoadable)
  {
    if (currentLoadable != paramLoadable) {}
    do
    {
      return;
      manifest = currentLoadable.result;
      manifestLoadStartTimestamp = currentLoadStartTimestamp;
      manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
      loadExceptionCount = 0;
      loadException = null;
      if ((manifest instanceof RedirectingManifest))
      {
        paramLoadable = ((RedirectingManifest)manifest).getNextManifestUri();
        if (!TextUtils.isEmpty(paramLoadable)) {
          manifestUri = paramLoadable;
        }
      }
    } while ((eventHandler == null) || (eventListener == null));
    eventHandler.post(new Runnable()
    {
      public final void run() {}
    });
  }
  
  public final void onLoadError(final Loader.Loadable paramLoadable, IOException paramIOException)
  {
    if (currentLoadable != paramLoadable) {}
    do
    {
      return;
      loadExceptionCount += 1;
      loadExceptionTimestamp = SystemClock.elapsedRealtime();
      loadException = new IOException(paramIOException);
      paramLoadable = loadException;
    } while ((eventHandler == null) || (eventListener == null));
    eventHandler.post(new Runnable()
    {
      public final void run() {}
    });
  }
  
  public static abstract interface EventListener {}
  
  public static abstract interface ManifestCallback<T>
  {
    public abstract void onSingleManifest(T paramT);
    
    public abstract void onSingleManifestError(IOException paramIOException);
  }
  
  public static abstract interface RedirectingManifest
  {
    public abstract String getNextManifestUri();
  }
  
  private final class SingleFetchHelper
    implements Loader.Callback
  {
    public final Looper callbackLooper;
    public long loadStartTimestamp;
    public final UriLoadable<T> singleUseLoadable;
    public final Loader singleUseLoader;
    private final ManifestFetcher.ManifestCallback<T> wrappedCallback;
    
    public SingleFetchHelper(Looper paramLooper, ManifestFetcher.ManifestCallback<T> paramManifestCallback)
    {
      singleUseLoadable = paramLooper;
      callbackLooper = paramManifestCallback;
      ManifestFetcher.ManifestCallback localManifestCallback;
      wrappedCallback = localManifestCallback;
      singleUseLoader = new Loader("manifestLoader:single");
    }
    
    public final void onLoadCanceled$35e469eb()
    {
      try
      {
        IOException localIOException = new IOException("Load cancelled", new CancellationException());
        wrappedCallback.onSingleManifestError(localIOException);
        return;
      }
      finally
      {
        singleUseLoader.release();
      }
    }
    
    public final void onLoadCompleted(Loader.Loadable paramLoadable)
    {
      try
      {
        paramLoadable = singleUseLoadable.result;
        ManifestFetcher localManifestFetcher = ManifestFetcher.this;
        long l = loadStartTimestamp;
        manifest = paramLoadable;
        manifestLoadStartTimestamp = l;
        manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
        wrappedCallback.onSingleManifest(paramLoadable);
        return;
      }
      finally
      {
        singleUseLoader.release();
      }
    }
    
    public final void onLoadError(Loader.Loadable paramLoadable, IOException paramIOException)
    {
      try
      {
        wrappedCallback.onSingleManifestError(paramIOException);
        return;
      }
      finally
      {
        singleUseLoader.release();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.ManifestFetcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */