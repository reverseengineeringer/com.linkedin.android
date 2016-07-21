package com.google.android.exoplayer.upstream;

import java.io.IOException;

public abstract interface Loader$Loadable
{
  public abstract void cancelLoad();
  
  public abstract boolean isLoadCanceled();
  
  public abstract void load()
    throws IOException, InterruptedException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Loader.Loadable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */