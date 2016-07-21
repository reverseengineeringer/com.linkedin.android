package okhttp3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache
  implements Closeable, Flushable
{
  static final Pattern LEGAL_KEY_PATTERN;
  private static final Sink NULL_SINK;
  private final int appVersion;
  private final Runnable cleanupRunnable = new DiskLruCache.1(this);
  private boolean closed;
  private final File directory;
  private final Executor executor;
  private final FileSystem fileSystem;
  private boolean hasJournalErrors;
  private boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private BufferedSink journalWriter;
  private final LinkedHashMap<String, DiskLruCache.Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private boolean mostRecentTrimFailed;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      NULL_SINK = new DiskLruCache.4();
      return;
    }
  }
  
  private DiskLruCache(FileSystem paramFileSystem, File paramFile, long paramLong, Executor paramExecutor)
  {
    fileSystem = paramFileSystem;
    directory = paramFile;
    appVersion = 201105;
    journalFile = new File(paramFile, "journal");
    journalFileTmp = new File(paramFile, "journal.tmp");
    journalFileBackup = new File(paramFile, "journal.bkp");
    valueCount = 2;
    maxSize = paramLong;
    executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      if (isClosed()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    DiskLruCache.Entry localEntry;
    try
    {
      localEntry = entry;
      if (currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    if ((paramBoolean) && (!readable))
    {
      i = 0;
      while (i < valueCount)
      {
        if (written[i] == 0)
        {
          paramEditor.abort();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i);
        }
        if (!fileSystem.exists(dirtyFiles[i]))
        {
          paramEditor.abort();
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      long l1;
      if (i < valueCount)
      {
        paramEditor = dirtyFiles[i];
        if (paramBoolean)
        {
          if (fileSystem.exists(paramEditor))
          {
            File localFile = cleanFiles[i];
            fileSystem.rename(paramEditor, localFile);
            l1 = lengths[i];
            long l2 = fileSystem.size(localFile);
            lengths[i] = l2;
            size = (size - l1 + l2);
          }
        }
        else {
          fileSystem.delete(paramEditor);
        }
      }
      else
      {
        redundantOpCount += 1;
        currentEditor = null;
        if ((readable | paramBoolean))
        {
          readable = true;
          journalWriter.writeUtf8("CLEAN").writeByte(32);
          journalWriter.writeUtf8(key);
          localEntry.writeLengths(journalWriter);
          journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l1 = nextSequenceNumber;
            nextSequenceNumber = (1L + l1);
            sequenceNumber = l1;
          }
        }
        for (;;)
        {
          journalWriter.flush();
          if ((size <= maxSize) && (!journalRebuildRequired())) {
            break;
          }
          executor.execute(cleanupRunnable);
          break;
          lruEntries.remove(key);
          journalWriter.writeUtf8("REMOVE").writeByte(32);
          journalWriter.writeUtf8(key);
          journalWriter.writeByte(10);
        }
      }
      i += 1;
    }
  }
  
  public static DiskLruCache create$bcfeaba(FileSystem paramFileSystem, File paramFile, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    return new DiskLruCache(paramFileSystem, paramFile, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  private void initialize()
    throws IOException
  {
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = initialized;
    if (bool) {
      return;
    }
    if (fileSystem.exists(journalFileBackup))
    {
      if (!fileSystem.exists(journalFile)) {
        break label200;
      }
      fileSystem.delete(journalFileBackup);
    }
    for (;;)
    {
      bool = fileSystem.exists(journalFile);
      if (bool) {
        try
        {
          readJournal();
          processJournal();
          initialized = true;
        }
        catch (IOException localIOException)
        {
          Platform.get();
          Platform.logW("DiskLruCache " + directory + " is corrupt: " + localIOException.getMessage() + ", removing");
          close();
          fileSystem.deleteContents(directory);
          closed = false;
        }
      }
      rebuildJournal();
      initialized = true;
      break;
      label200:
      fileSystem.rename(journalFileBackup, journalFile);
    }
  }
  
  private boolean isClosed()
  {
    try
    {
      boolean bool = closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean journalRebuildRequired()
  {
    return (redundantOpCount >= 2000) && (redundantOpCount >= lruEntries.size());
  }
  
  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    return Okio.buffer(new DiskLruCache.2(this, fileSystem.appendingSink(journalFile)));
  }
  
  private void processJournal()
    throws IOException
  {
    fileSystem.delete(journalFileTmp);
    Iterator localIterator = lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      int i;
      if (currentEditor == null)
      {
        i = 0;
        while (i < valueCount)
        {
          size += lengths[i];
          i += 1;
        }
      }
      else
      {
        currentEditor = null;
        i = 0;
        while (i < valueCount)
        {
          fileSystem.delete(cleanFiles[i]);
          fileSystem.delete(dirtyFiles[i]);
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void readJournal()
    throws IOException
  {
    BufferedSource localBufferedSource = Okio.buffer(fileSystem.source(journalFile));
    Object localObject3;
    Object localObject4;
    String str2;
    int i;
    int j;
    int k;
    int m;
    Object localObject2;
    try
    {
      String str1 = localBufferedSource.readUtf8LineStrict();
      localObject3 = localBufferedSource.readUtf8LineStrict();
      localObject4 = localBufferedSource.readUtf8LineStrict();
      str2 = localBufferedSource.readUtf8LineStrict();
      String str3 = localBufferedSource.readUtf8LineStrict();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(localObject3)) || (!Integer.toString(appVersion).equals(localObject4)) || (!Integer.toString(valueCount).equals(str2)) || (!"".equals(str3))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + (String)localObject3 + ", " + str2 + ", " + str3 + "]");
      }
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
      throw ((Throwable)localObject1);
      i = 0;
    }
  }
  
  private void rebuildJournal()
    throws IOException
  {
    for (;;)
    {
      DiskLruCache.Entry localEntry;
      try
      {
        if (journalWriter != null) {
          journalWriter.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(fileSystem.sink(journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (DiskLruCache.Entry)localIterator.next();
          if (currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(key);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (fileSystem.exists(journalFile)) {
      fileSystem.rename(journalFile, journalFileBackup);
    }
    fileSystem.rename(journalFileTmp, journalFile);
    fileSystem.delete(journalFileBackup);
    journalWriter = newJournalWriter();
    hasJournalErrors = false;
  }
  
  private boolean removeEntry(DiskLruCache.Entry paramEntry)
    throws IOException
  {
    if (currentEditor != null) {
      currentEditor.hasErrors = true;
    }
    int i = 0;
    while (i < valueCount)
    {
      fileSystem.delete(cleanFiles[i]);
      size -= lengths[i];
      lengths[i] = 0L;
      i += 1;
    }
    redundantOpCount += 1;
    journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(key).writeByte(10);
    lruEntries.remove(key);
    if (journalRebuildRequired()) {
      executor.execute(cleanupRunnable);
    }
    return true;
  }
  
  private void trimToSize()
    throws IOException
  {
    while (size > maxSize) {
      removeEntry((DiskLruCache.Entry)lruEntries.values().iterator().next());
    }
    mostRecentTrimFailed = false;
  }
  
  private static void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  public final void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if ((!initialized) || (closed))
        {
          closed = true;
          return;
        }
        DiskLruCache.Entry[] arrayOfEntry = (DiskLruCache.Entry[])lruEntries.values().toArray(new DiskLruCache.Entry[lruEntries.size()]);
        int j = arrayOfEntry.length;
        int i = 0;
        if (i < j)
        {
          DiskLruCache.Entry localEntry = arrayOfEntry[i];
          if (currentEditor != null) {
            currentEditor.abort();
          }
        }
        else
        {
          trimToSize();
          journalWriter.close();
          journalWriter = null;
          closed = true;
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public final Editor edit(String paramString, long paramLong)
    throws IOException
  {
    Object localObject2 = null;
    for (;;)
    {
      DiskLruCache.Entry localEntry;
      try
      {
        initialize();
        checkNotClosed();
        validateKey(paramString);
        localEntry = (DiskLruCache.Entry)lruEntries.get(paramString);
        if (paramLong != -1L)
        {
          localObject1 = localObject2;
          if (localEntry != null)
          {
            long l = sequenceNumber;
            if (l != paramLong) {
              localObject1 = localObject2;
            }
          }
          else
          {
            return (Editor)localObject1;
          }
        }
        if (localEntry != null)
        {
          localObject1 = localObject2;
          if (currentEditor != null) {
            continue;
          }
        }
        if (mostRecentTrimFailed)
        {
          executor.execute(cleanupRunnable);
          localObject1 = localObject2;
          continue;
        }
        journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
      }
      finally {}
      journalWriter.flush();
      Object localObject1 = localObject2;
      if (!hasJournalErrors)
      {
        localObject1 = localEntry;
        if (localEntry == null)
        {
          localObject1 = new DiskLruCache.Entry(this, paramString, (byte)0);
          lruEntries.put(paramString, localObject1);
        }
        paramString = new Editor((DiskLruCache.Entry)localObject1, (byte)0);
        currentEditor = paramString;
        localObject1 = paramString;
      }
    }
  }
  
  /* Error */
  public final void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	okhttp3/internal/DiskLruCache:initialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 545	okhttp3/internal/DiskLruCache:checkNotClosed	()V
    //   18: aload_0
    //   19: invokespecial 142	okhttp3/internal/DiskLruCache:trimToSize	()V
    //   22: aload_0
    //   23: getfield 259	okhttp3/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   26: invokeinterface 285 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	DiskLruCache
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public final Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 543	okhttp3/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 545	okhttp3/internal/DiskLruCache:checkNotClosed	()V
    //   10: aload_1
    //   11: invokestatic 547	okhttp3/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 90	okhttp3/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 484	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 13	okhttp3/internal/DiskLruCache$Entry
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +12 -> 39
    //   30: aload_3
    //   31: getfield 209	okhttp3/internal/DiskLruCache$Entry:readable	Z
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +9 -> 45
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aload_3
    //   46: invokevirtual 554	okhttp3/internal/DiskLruCache$Entry:snapshot	()Lokhttp3/internal/DiskLruCache$Snapshot;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnonnull +8 -> 59
    //   54: aconst_null
    //   55: astore_1
    //   56: goto -15 -> 41
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 183	okhttp3/internal/DiskLruCache:redundantOpCount	I
    //   64: iconst_1
    //   65: iadd
    //   66: putfield 183	okhttp3/internal/DiskLruCache:redundantOpCount	I
    //   69: aload_0
    //   70: getfield 259	okhttp3/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   73: ldc_w 508
    //   76: invokeinterface 267 2 0
    //   81: bipush 32
    //   83: invokeinterface 271 2 0
    //   88: aload_1
    //   89: invokeinterface 267 2 0
    //   94: bipush 10
    //   96: invokeinterface 271 2 0
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload_0
    //   105: invokespecial 176	okhttp3/internal/DiskLruCache:journalRebuildRequired	()Z
    //   108: ifeq -67 -> 41
    //   111: aload_0
    //   112: getfield 129	okhttp3/internal/DiskLruCache:executor	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 99	okhttp3/internal/DiskLruCache:cleanupRunnable	Ljava/lang/Runnable;
    //   119: invokeinterface 291 2 0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -85 -> 41
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DiskLruCache
    //   0	134	1	paramString	String
    //   34	2	2	bool	boolean
    //   25	100	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	129	finally
    //   30	35	129	finally
    //   45	50	129	finally
    //   59	102	129	finally
    //   104	124	129	finally
  }
  
  /* Error */
  public final boolean remove(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 543	okhttp3/internal/DiskLruCache:initialize	()V
    //   8: aload_0
    //   9: invokespecial 545	okhttp3/internal/DiskLruCache:checkNotClosed	()V
    //   12: aload_1
    //   13: invokestatic 547	okhttp3/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 90	okhttp3/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   20: aload_1
    //   21: invokevirtual 484	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 13	okhttp3/internal/DiskLruCache$Entry
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +7 -> 36
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 167	okhttp3/internal/DiskLruCache:removeEntry	(Lokhttp3/internal/DiskLruCache$Entry;)Z
    //   41: pop
    //   42: aload_0
    //   43: getfield 82	okhttp3/internal/DiskLruCache:size	J
    //   46: aload_0
    //   47: getfield 127	okhttp3/internal/DiskLruCache:maxSize	J
    //   50: lcmp
    //   51: ifgt +8 -> 59
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 172	okhttp3/internal/DiskLruCache:mostRecentTrimFailed	Z
    //   59: iconst_1
    //   60: istore_2
    //   61: goto -29 -> 32
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	DiskLruCache
    //   0	69	1	paramString	String
    //   1	60	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	28	64	finally
    //   36	59	64	finally
  }
  
  public final class Editor
  {
    private boolean committed;
    final DiskLruCache.Entry entry;
    boolean hasErrors;
    final boolean[] written;
    
    private Editor(DiskLruCache.Entry paramEntry)
    {
      entry = paramEntry;
      if (readable) {}
      for (this$1 = null;; this$1 = new boolean[valueCount])
      {
        written = DiskLruCache.this;
        return;
      }
    }
    
    public final void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
      }
    }
    
    public final void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (hasErrors)
        {
          DiskLruCache.this.completeEdit(this, false);
          DiskLruCache.this.removeEntry(entry);
          committed = true;
          return;
        }
        DiskLruCache.this.completeEdit(this, true);
      }
    }
    
    public final Sink newSink(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
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
        localObject2 = fileSystem.sink((File)localObject2);
        localObject2 = new DiskLruCache.Editor.1(this, (Sink)localObject2);
        return (Sink)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Sink localSink = DiskLruCache.NULL_SINK;
        return localSink;
      }
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    public final String key;
    private final long[] lengths;
    public final long sequenceNumber;
    public final Source[] sources;
    
    private Snapshot(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
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
}

/* Location:
 * Qualified Name:     okhttp3.internal.DiskLruCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */