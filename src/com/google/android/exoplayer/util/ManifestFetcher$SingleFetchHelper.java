package com.google.android.exoplayer.util;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.UriLoadable;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public final class ManifestFetcher$SingleFetchHelper
  implements Loader.Callback
{
  public final Looper callbackLooper;
  public long loadStartTimestamp;
  public final UriLoadable<T> singleUseLoadable;
  public final Loader singleUseLoader;
  private final ManifestFetcher.ManifestCallback<T> wrappedCallback;
  
  public ManifestFetcher$SingleFetchHelper(UriLoadable<T> paramUriLoadable, Looper paramLooper, ManifestFetcher.ManifestCallback<T> paramManifestCallback)
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
      ManifestFetcher localManifestFetcher = this$0;
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.ManifestFetcher.SingleFetchHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */