package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Predicate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends UriDataSource
{
  public static final Predicate<String> REJECT_PAYWALL_TYPES = new Predicate() {};
  
  public static class HttpDataSourceException
    extends IOException
  {
    public final DataSpec dataSpec;
    
    public HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec)
    {
      super();
      dataSpec = paramDataSpec;
    }
    
    public HttpDataSourceException(String paramString, DataSpec paramDataSpec)
    {
      super();
      dataSpec = paramDataSpec;
    }
    
    public HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
    {
      super(paramIOException);
      dataSpec = paramDataSpec;
    }
  }
  
  public static final class InvalidContentTypeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final String contentType;
    
    public InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
      contentType = paramString;
    }
  }
  
  public static final class InvalidResponseCodeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final Map<String, List<String>> headerFields;
    public final int responseCode;
    
    public InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
      responseCode = paramInt;
      headerFields = paramMap;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.HttpDataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */