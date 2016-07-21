package com.google.android.exoplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer.ParserException;
import java.io.IOException;
import java.io.InputStream;

public final class UriLoadable<T>
  implements Loader.Loadable
{
  private final DataSpec dataSpec;
  private volatile boolean isCanceled;
  private final Parser<T> parser;
  public volatile T result;
  private final UriDataSource uriDataSource;
  
  public UriLoadable(String paramString, UriDataSource paramUriDataSource, Parser<T> paramParser)
  {
    uriDataSource = paramUriDataSource;
    parser = paramParser;
    dataSpec = new DataSpec(Uri.parse(paramString));
  }
  
  public final void cancelLoad()
  {
    isCanceled = true;
  }
  
  public final boolean isLoadCanceled()
  {
    return isCanceled;
  }
  
  public final void load()
    throws IOException, InterruptedException
  {
    DataSourceInputStream localDataSourceInputStream = new DataSourceInputStream(uriDataSource, dataSpec);
    try
    {
      localDataSourceInputStream.checkOpened();
      result = parser.parse(uriDataSource.getUri(), localDataSourceInputStream);
      return;
    }
    finally
    {
      localDataSourceInputStream.close();
    }
  }
  
  public static abstract interface Parser<T>
  {
    public abstract T parse(String paramString, InputStream paramInputStream)
      throws ParserException, IOException;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.UriLoadable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */