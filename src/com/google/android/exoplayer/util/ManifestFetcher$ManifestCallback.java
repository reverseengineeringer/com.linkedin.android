package com.google.android.exoplayer.util;

import java.io.IOException;

public abstract interface ManifestFetcher$ManifestCallback<T>
{
  public abstract void onSingleManifest(T paramT);
  
  public abstract void onSingleManifestError(IOException paramIOException);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.ManifestFetcher.ManifestCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */