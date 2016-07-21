package com.google.android.exoplayer.upstream;

import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException
  extends HttpDataSource.HttpDataSourceException
{
  public final Map<String, List<String>> headerFields;
  public final int responseCode;
  
  public HttpDataSource$InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
  {
    super("Response code: " + paramInt, paramDataSpec);
    responseCode = paramInt;
    headerFields = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */