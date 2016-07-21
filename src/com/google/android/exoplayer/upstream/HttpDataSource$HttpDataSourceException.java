package com.google.android.exoplayer.upstream;

import java.io.IOException;

public class HttpDataSource$HttpDataSourceException
  extends IOException
{
  public final DataSpec dataSpec;
  
  public HttpDataSource$HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec)
  {
    super(paramIOException);
    dataSpec = paramDataSpec;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, DataSpec paramDataSpec)
  {
    super(paramString);
    dataSpec = paramDataSpec;
  }
  
  public HttpDataSource$HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
  {
    super(paramString, paramIOException);
    dataSpec = paramDataSpec;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.HttpDataSource.HttpDataSourceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */