package com.google.android.exoplayer.upstream;

import java.io.IOException;

public abstract interface Loader$Callback
{
  public abstract void onLoadCanceled$35e469eb();
  
  public abstract void onLoadCompleted(Loader.Loadable paramLoadable);
  
  public abstract void onLoadError(Loader.Loadable paramLoadable, IOException paramIOException);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Loader.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */