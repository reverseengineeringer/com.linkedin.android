package okhttp3;

public final class CacheControl$Builder
{
  int maxAgeSeconds = -1;
  int maxStaleSeconds = -1;
  int minFreshSeconds = -1;
  boolean noCache;
  public boolean noStore;
  boolean noTransform;
  boolean onlyIfCached;
  
  public final CacheControl build()
  {
    return new CacheControl(this, (byte)0);
  }
}

/* Location:
 * Qualified Name:     okhttp3.CacheControl.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */