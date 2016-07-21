package com.google.android.exoplayer.upstream;

import java.io.IOException;

public final class Loader$UnexpectedLoaderException
  extends IOException
{
  public Loader$UnexpectedLoaderException(Exception paramException)
  {
    super("Unexpected " + paramException.getClass().getSimpleName() + ": " + paramException.getMessage(), paramException);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Loader.UnexpectedLoaderException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */