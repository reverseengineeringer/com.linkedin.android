package com.google.android.exoplayer.upstream;

public final class HttpDataSource$InvalidContentTypeException
  extends HttpDataSource.HttpDataSourceException
{
  public final String contentType;
  
  public HttpDataSource$InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
  {
    super("Invalid content type: " + paramString, paramDataSpec);
    contentType = paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.HttpDataSource.InvalidContentTypeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */