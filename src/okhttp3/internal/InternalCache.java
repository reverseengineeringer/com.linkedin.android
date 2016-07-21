package okhttp3.internal;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;

public abstract interface InternalCache
{
  public abstract Response get(Request paramRequest)
    throws IOException;
  
  public abstract CacheRequest put(Response paramResponse)
    throws IOException;
  
  public abstract void remove(Request paramRequest)
    throws IOException;
  
  public abstract void trackConditionalCacheHit();
  
  public abstract void trackResponse(CacheStrategy paramCacheStrategy);
  
  public abstract void update(Response paramResponse1, Response paramResponse2)
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.internal.InternalCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */