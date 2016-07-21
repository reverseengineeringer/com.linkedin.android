package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.ParserException;
import java.io.IOException;
import java.io.InputStream;

public abstract interface UriLoadable$Parser<T>
{
  public abstract T parse(String paramString, InputStream paramInputStream)
    throws ParserException, IOException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.UriLoadable.Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */