package okhttp3.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okhttp3.internal.io.FileSystem;
import okio.Sink;

public final class DiskLruCache$Editor
{
  private boolean committed;
  final DiskLruCache.Entry entry;
  boolean hasErrors;
  final boolean[] written;
  
  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, DiskLruCache.Entry paramEntry)
  {
    entry = paramEntry;
    if (readable) {}
    for (paramDiskLruCache = null;; paramDiskLruCache = new boolean[DiskLruCache.access$2400(paramDiskLruCache)])
    {
      written = paramDiskLruCache;
      return;
    }
  }
  
  public final void abort()
    throws IOException
  {
    synchronized (this$0)
    {
      DiskLruCache.access$2700(this$0, this, false);
      return;
    }
  }
  
  public final void commit()
    throws IOException
  {
    synchronized (this$0)
    {
      if (hasErrors)
      {
        DiskLruCache.access$2700(this$0, this, false);
        DiskLruCache.access$2800(this$0, entry);
        committed = true;
        return;
      }
      DiskLruCache.access$2700(this$0, this, true);
    }
  }
  
  public final Sink newSink(int paramInt)
    throws IOException
  {
    synchronized (this$0)
    {
      if (entry.currentEditor != this) {
        throw new IllegalStateException();
      }
    }
    if (!entry.readable) {
      written[paramInt] = true;
    }
    Object localObject2 = entry.dirtyFiles[paramInt];
    try
    {
      localObject2 = DiskLruCache.access$2500(this$0).sink((File)localObject2);
      localObject2 = new DiskLruCache.Editor.1(this, (Sink)localObject2);
      return (Sink)localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Sink localSink = DiskLruCache.access$2600();
      return localSink;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.DiskLruCache.Editor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */