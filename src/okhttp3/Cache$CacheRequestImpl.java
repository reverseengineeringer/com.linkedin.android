package okhttp3;

import java.io.IOException;
import okhttp3.internal.DiskLruCache.Editor;
import okhttp3.internal.Util;
import okhttp3.internal.http.CacheRequest;
import okio.Sink;

final class Cache$CacheRequestImpl
  implements CacheRequest
{
  private Sink body;
  private Sink cacheOut;
  boolean done;
  private final DiskLruCache.Editor editor;
  
  public Cache$CacheRequestImpl(Cache paramCache, DiskLruCache.Editor paramEditor)
    throws IOException
  {
    editor = paramEditor;
    cacheOut = paramEditor.newSink(1);
    body = new Cache.CacheRequestImpl.1(this, cacheOut, paramCache, paramEditor);
  }
  
  public final void abort()
  {
    synchronized (this$0)
    {
      if (done) {
        return;
      }
      done = true;
      Cache.access$908(this$0);
      Util.closeQuietly(cacheOut);
      try
      {
        editor.abort();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public final Sink body()
  {
    return body;
  }
}

/* Location:
 * Qualified Name:     okhttp3.Cache.CacheRequestImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */