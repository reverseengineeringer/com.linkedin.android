package okhttp3;

import java.io.IOException;
import okhttp3.internal.InternalCache;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;

final class Cache$1
  implements InternalCache
{
  Cache$1(Cache paramCache) {}
  
  public final Response get(Request paramRequest)
    throws IOException
  {
    return this$0.get(paramRequest);
  }
  
  public final CacheRequest put(Response paramResponse)
    throws IOException
  {
    return Cache.access$000(this$0, paramResponse);
  }
  
  public final void remove(Request paramRequest)
    throws IOException
  {
    Cache.access$100(this$0, paramRequest);
  }
  
  public final void trackConditionalCacheHit()
  {
    Cache.access$300(this$0);
  }
  
  public final void trackResponse(CacheStrategy paramCacheStrategy)
  {
    Cache.access$400(this$0, paramCacheStrategy);
  }
  
  public final void update(Response paramResponse1, Response paramResponse2)
    throws IOException
  {
    Cache.access$200$2d360e6(paramResponse1, paramResponse2);
  }
}

/* Location:
 * Qualified Name:     okhttp3.Cache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */