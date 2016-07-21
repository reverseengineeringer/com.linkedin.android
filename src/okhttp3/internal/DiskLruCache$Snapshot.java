package okhttp3.internal;

import java.io.Closeable;
import okio.Source;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  public final String key;
  private final long[] lengths;
  public final long sequenceNumber;
  public final Source[] sources;
  
  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
  {
    key = paramString;
    sequenceNumber = paramLong;
    sources = paramArrayOfSource;
    lengths = paramArrayOfLong;
  }
  
  public final void close()
  {
    Source[] arrayOfSource = sources;
    int j = arrayOfSource.length;
    int i = 0;
    while (i < j)
    {
      Util.closeQuietly(arrayOfSource[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.DiskLruCache.Snapshot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */