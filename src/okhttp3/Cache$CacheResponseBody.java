package okhttp3;

import okhttp3.internal.DiskLruCache.Snapshot;
import okio.BufferedSource;
import okio.Okio;

final class Cache$CacheResponseBody
  extends ResponseBody
{
  private final BufferedSource bodySource;
  private final String contentLength;
  private final String contentType;
  final DiskLruCache.Snapshot snapshot;
  
  public Cache$CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
  {
    snapshot = paramSnapshot;
    contentType = paramString1;
    contentLength = paramString2;
    bodySource = Okio.buffer(new Cache.CacheResponseBody.1(this, sources[1], paramSnapshot));
  }
  
  public final long contentLength()
  {
    long l = -1L;
    try
    {
      if (contentLength != null) {
        l = Long.parseLong(contentLength);
      }
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return -1L;
  }
  
  public final MediaType contentType()
  {
    if (contentType != null) {
      return MediaType.parse(contentType);
    }
    return null;
  }
  
  public final BufferedSource source()
  {
    return bodySource;
  }
}

/* Location:
 * Qualified Name:     okhttp3.Cache.CacheResponseBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */