package com.google.android.exoplayer.extractor;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ExtractorSampleSource
  implements SampleSource, SampleSource.SampleSourceReader, ExtractorOutput, Loader.Callback
{
  private static final List<Class<? extends Extractor>> DEFAULT_EXTRACTOR_CLASSES = new ArrayList();
  private final Allocator allocator;
  private IOException currentLoadableException;
  private int currentLoadableExceptionCount;
  private long currentLoadableExceptionTimestamp;
  private final DataSource dataSource;
  private long downstreamPositionUs;
  private volatile DrmInitData drmInitData;
  private int enabledTrackCount;
  private int extractedSampleCount;
  private int extractedSampleCountAtStartOfLoad;
  private final ExtractorHolder extractorHolder;
  private boolean havePendingNextSampleUs;
  private long lastSeekPositionUs;
  private ExtractingLoadable loadable;
  private Loader loader;
  private boolean loadingFinished;
  private long maxTrackDurationUs;
  private final int minLoadableRetryCount;
  private boolean[] pendingDiscontinuities;
  private boolean[] pendingMediaFormat;
  private long pendingNextSampleUs;
  private long pendingResetPositionUs;
  private boolean prepared;
  private int remainingReleaseCount;
  private final int requestedBufferSize;
  private final SparseArray<InternalTrackOutput> sampleQueues;
  private long sampleTimeOffsetUs;
  private volatile SeekMap seekMap;
  private boolean[] trackEnabledStates;
  private TrackInfo[] trackInfos;
  private volatile boolean tracksBuilt;
  private final Uri uri;
  
  static
  {
    try
    {
      DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.webm.WebmExtractor").asSubclass(Extractor.class));
      try
      {
        DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor").asSubclass(Extractor.class));
        try
        {
          DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp4.Mp4Extractor").asSubclass(Extractor.class));
          try
          {
            DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.mp3.Mp3Extractor").asSubclass(Extractor.class));
            try
            {
              DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.ts.AdtsExtractor").asSubclass(Extractor.class));
              try
              {
                DEFAULT_EXTRACTOR_CLASSES.add(Class.forName("com.google.android.exoplayer.extractor.ts.TsExtractor").asSubclass(Extractor.class));
                return;
              }
              catch (ClassNotFoundException localClassNotFoundException1) {}
            }
            catch (ClassNotFoundException localClassNotFoundException2)
            {
              for (;;) {}
            }
          }
          catch (ClassNotFoundException localClassNotFoundException3)
          {
            for (;;) {}
          }
        }
        catch (ClassNotFoundException localClassNotFoundException4)
        {
          for (;;) {}
        }
      }
      catch (ClassNotFoundException localClassNotFoundException5)
      {
        for (;;) {}
      }
    }
    catch (ClassNotFoundException localClassNotFoundException6)
    {
      for (;;) {}
    }
  }
  
  public ExtractorSampleSource(Uri paramUri, DataSource paramDataSource, Allocator paramAllocator, Extractor... paramVarArgs)
  {
    uri = paramUri;
    dataSource = paramDataSource;
    allocator = paramAllocator;
    requestedBufferSize = 10485760;
    minLoadableRetryCount = 2;
    extractorHolder = new ExtractorHolder(paramVarArgs, this);
    sampleQueues = new SparseArray();
    pendingResetPositionUs = -1L;
  }
  
  private void clearState()
  {
    int i = 0;
    while (i < sampleQueues.size())
    {
      ((InternalTrackOutput)sampleQueues.valueAt(i)).clear();
      i += 1;
    }
    loadable = null;
    currentLoadableException = null;
    currentLoadableExceptionCount = 0;
  }
  
  private ExtractingLoadable createLoadableFromStart()
  {
    return new ExtractingLoadable(uri, dataSource, extractorHolder, allocator, requestedBufferSize, 0L);
  }
  
  private boolean isPendingReset()
  {
    return pendingResetPositionUs != -1L;
  }
  
  private void maybeStartLoading()
  {
    boolean bool = false;
    if ((loadingFinished) || (loader.loading)) {}
    do
    {
      do
      {
        return;
        if (currentLoadableException == null) {
          break;
        }
      } while ((currentLoadableException instanceof UnrecognizedInputFormatException));
      if (loadable != null) {
        bool = true;
      }
      Assertions.checkState(bool);
    } while (SystemClock.elapsedRealtime() - currentLoadableExceptionTimestamp < Math.min((currentLoadableExceptionCount - 1L) * 1000L, 5000L));
    currentLoadableException = null;
    int i;
    if (!prepared)
    {
      i = 0;
      while (i < sampleQueues.size())
      {
        ((InternalTrackOutput)sampleQueues.valueAt(i)).clear();
        i += 1;
      }
      loadable = createLoadableFromStart();
    }
    for (;;)
    {
      extractedSampleCountAtStartOfLoad = extractedSampleCount;
      loader.startLoading(loadable, this);
      return;
      if (!seekMap.isSeekable())
      {
        i = 0;
        while (i < sampleQueues.size())
        {
          ((InternalTrackOutput)sampleQueues.valueAt(i)).clear();
          i += 1;
        }
        loadable = createLoadableFromStart();
        pendingNextSampleUs = downstreamPositionUs;
        havePendingNextSampleUs = true;
      }
    }
    sampleTimeOffsetUs = 0L;
    havePendingNextSampleUs = false;
    if (!prepared) {
      loadable = createLoadableFromStart();
    }
    for (;;)
    {
      extractedSampleCountAtStartOfLoad = extractedSampleCount;
      loader.startLoading(loadable, this);
      return;
      Assertions.checkState(isPendingReset());
      if ((maxTrackDurationUs != -1L) && (pendingResetPositionUs >= maxTrackDurationUs))
      {
        loadingFinished = true;
        pendingResetPositionUs = -1L;
        return;
      }
      long l = pendingResetPositionUs;
      loadable = new ExtractingLoadable(uri, dataSource, extractorHolder, allocator, requestedBufferSize, seekMap.getPosition(l));
      pendingResetPositionUs = -1L;
    }
  }
  
  private void restartFrom(long paramLong)
  {
    pendingResetPositionUs = paramLong;
    loadingFinished = false;
    if (loader.loading)
    {
      loader.cancelLoading();
      return;
    }
    clearState();
    maybeStartLoading();
  }
  
  public final boolean continueBuffering(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    Assertions.checkState(prepared);
    Assertions.checkState(trackEnabledStates[paramInt]);
    downstreamPositionUs = paramLong;
    paramLong = downstreamPositionUs;
    int i = 0;
    while (i < trackEnabledStates.length)
    {
      if (trackEnabledStates[i] == 0) {
        ((InternalTrackOutput)sampleQueues.valueAt(i)).discardUntil(paramLong);
      }
      i += 1;
    }
    boolean bool1;
    if (loadingFinished) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        maybeStartLoading();
        bool1 = bool2;
      } while (isPendingReset());
      bool1 = bool2;
    } while (((InternalTrackOutput)sampleQueues.valueAt(paramInt)).isEmpty());
    return true;
  }
  
  public final void disable(int paramInt)
  {
    Assertions.checkState(prepared);
    Assertions.checkState(trackEnabledStates[paramInt]);
    enabledTrackCount -= 1;
    trackEnabledStates[paramInt] = false;
    if (enabledTrackCount == 0)
    {
      downstreamPositionUs = Long.MIN_VALUE;
      if (loader.loading) {
        loader.cancelLoading();
      }
    }
    else
    {
      return;
    }
    clearState();
    allocator.trim(0);
  }
  
  public final void drmInitData(DrmInitData paramDrmInitData)
  {
    drmInitData = paramDrmInitData;
  }
  
  public final void enable(int paramInt, long paramLong)
  {
    Assertions.checkState(prepared);
    if (trackEnabledStates[paramInt] == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      enabledTrackCount += 1;
      trackEnabledStates[paramInt] = true;
      pendingMediaFormat[paramInt] = true;
      if (enabledTrackCount == 1) {
        seekToUs(paramLong);
      }
      pendingDiscontinuities[paramInt] = false;
      return;
    }
  }
  
  public final void endTracks()
  {
    tracksBuilt = true;
  }
  
  public final long getBufferedPositionUs()
  {
    long l2;
    if (loadingFinished) {
      l2 = -3L;
    }
    long l1;
    do
    {
      return l2;
      if (isPendingReset()) {
        return pendingResetPositionUs;
      }
      l1 = Long.MIN_VALUE;
      int i = 0;
      while (i < sampleQueues.size())
      {
        l1 = Math.max(l1, sampleQueues.valueAt(i)).largestParsedTimestampUs);
        i += 1;
      }
      l2 = l1;
    } while (l1 != Long.MIN_VALUE);
    return downstreamPositionUs;
  }
  
  public final int getTrackCount()
  {
    return sampleQueues.size();
  }
  
  public final TrackInfo getTrackInfo(int paramInt)
  {
    Assertions.checkState(prepared);
    return trackInfos[paramInt];
  }
  
  public final void maybeThrowError()
    throws IOException
  {
    if (currentLoadableException == null) {}
    for (;;)
    {
      return;
      if ((currentLoadableException instanceof UnrecognizedInputFormatException)) {
        throw currentLoadableException;
      }
      int i;
      if (minLoadableRetryCount != -1) {
        i = minLoadableRetryCount;
      }
      while (currentLoadableExceptionCount > i)
      {
        throw currentLoadableException;
        if ((seekMap != null) && (!seekMap.isSeekable())) {
          i = 6;
        } else {
          i = 3;
        }
      }
    }
  }
  
  public final void onLoadCanceled$35e469eb()
  {
    if (enabledTrackCount > 0)
    {
      restartFrom(pendingResetPositionUs);
      return;
    }
    clearState();
    allocator.trim(0);
  }
  
  public final void onLoadCompleted(Loader.Loadable paramLoadable)
  {
    loadingFinished = true;
  }
  
  public final void onLoadError(Loader.Loadable paramLoadable, IOException paramIOException)
  {
    currentLoadableException = paramIOException;
    if (extractedSampleCount > extractedSampleCountAtStartOfLoad) {}
    for (int i = 1;; i = currentLoadableExceptionCount + 1)
    {
      currentLoadableExceptionCount = i;
      currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
      maybeStartLoading();
      return;
    }
  }
  
  public final boolean prepare(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if (prepared) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (loader == null) {
          loader = new Loader("Loader:ExtractorSampleSource");
        }
        maybeStartLoading();
        bool1 = bool2;
      } while (seekMap == null);
      bool1 = bool2;
    } while (!tracksBuilt);
    int i = 0;
    label65:
    if (i < sampleQueues.size()) {
      if (((InternalTrackOutput)sampleQueues.valueAt(i)).hasFormat()) {}
    }
    for (i = 0;; i = 1)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      int j = sampleQueues.size();
      trackEnabledStates = new boolean[j];
      pendingDiscontinuities = new boolean[j];
      pendingMediaFormat = new boolean[j];
      trackInfos = new TrackInfo[j];
      maxTrackDurationUs = -1L;
      i = 0;
      while (i < j)
      {
        MediaFormat localMediaFormat = sampleQueues.valueAt(i)).format;
        trackInfos[i] = new TrackInfo(mimeType, durationUs);
        if ((durationUs != -1L) && (durationUs > maxTrackDurationUs)) {
          maxTrackDurationUs = durationUs;
        }
        i += 1;
      }
      i += 1;
      break label65;
    }
    prepared = true;
    return true;
  }
  
  public final int readData(int paramInt, long paramLong, MediaFormatHolder paramMediaFormatHolder, SampleHolder paramSampleHolder, boolean paramBoolean)
  {
    downstreamPositionUs = paramLong;
    if (pendingDiscontinuities[paramInt] != 0)
    {
      pendingDiscontinuities[paramInt] = false;
      return -5;
    }
    if ((paramBoolean) || (isPendingReset())) {
      return -2;
    }
    InternalTrackOutput localInternalTrackOutput = (InternalTrackOutput)sampleQueues.valueAt(paramInt);
    if (pendingMediaFormat[paramInt] != 0)
    {
      format = format;
      drmInitData = drmInitData;
      pendingMediaFormat[paramInt] = false;
      return -4;
    }
    if (localInternalTrackOutput.getSample(paramSampleHolder))
    {
      int i;
      if (timeUs < lastSeekPositionUs)
      {
        paramInt = 1;
        i = flags;
        if (paramInt == 0) {
          break label188;
        }
      }
      label188:
      for (paramInt = 134217728;; paramInt = 0)
      {
        flags = (paramInt | i);
        if (havePendingNextSampleUs)
        {
          sampleTimeOffsetUs = (pendingNextSampleUs - timeUs);
          havePendingNextSampleUs = false;
        }
        timeUs += sampleTimeOffsetUs;
        return -3;
        paramInt = 0;
        break;
      }
    }
    if (loadingFinished) {
      return -1;
    }
    return -2;
  }
  
  public final SampleSource.SampleSourceReader register()
  {
    remainingReleaseCount += 1;
    return this;
  }
  
  public final void release()
  {
    if (remainingReleaseCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      int i = remainingReleaseCount - 1;
      remainingReleaseCount = i;
      if ((i == 0) && (loader != null))
      {
        loader.release();
        loader = null;
      }
      return;
    }
  }
  
  public final void seekMap(SeekMap paramSeekMap)
  {
    seekMap = paramSeekMap;
  }
  
  public final void seekToUs(long paramLong)
  {
    Assertions.checkState(prepared);
    boolean bool;
    long l;
    if (enabledTrackCount > 0)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!seekMap.isSeekable()) {
        paramLong = 0L;
      }
      if (!isPendingReset()) {
        break label73;
      }
      l = pendingResetPositionUs;
      label49:
      downstreamPositionUs = paramLong;
      lastSeekPositionUs = paramLong;
      if (l != paramLong) {
        break label82;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label73:
      l = downstreamPositionUs;
      break label49;
      label82:
      int j;
      label100:
      RollingSampleBuffer localRollingSampleBuffer;
      if (!isPendingReset())
      {
        i = 1;
        k = 0;
        j = i;
        i = k;
        if ((j == 0) || (i >= sampleQueues.size())) {
          break label187;
        }
        localRollingSampleBuffer = sampleQueues.valueAt(i)).rollingBuffer;
        l = infoQueue.skipToKeyframeBefore(paramLong);
        if (l != -1L) {
          break label174;
        }
      }
      for (int k = 0;; k = 1)
      {
        j &= k;
        i += 1;
        break label100;
        i = 0;
        break;
        label174:
        localRollingSampleBuffer.dropDownstreamTo(l);
      }
      label187:
      if (j == 0) {
        restartFrom(paramLong);
      }
      int i = 0;
      while (i < pendingDiscontinuities.length)
      {
        pendingDiscontinuities[i] = true;
        i += 1;
      }
    }
  }
  
  public final TrackOutput track(int paramInt)
  {
    InternalTrackOutput localInternalTrackOutput2 = (InternalTrackOutput)sampleQueues.get(paramInt);
    InternalTrackOutput localInternalTrackOutput1 = localInternalTrackOutput2;
    if (localInternalTrackOutput2 == null)
    {
      localInternalTrackOutput1 = new InternalTrackOutput(allocator);
      sampleQueues.put(paramInt, localInternalTrackOutput1);
    }
    return localInternalTrackOutput1;
  }
  
  private static final class ExtractingLoadable
    implements Loader.Loadable
  {
    private final Allocator allocator;
    private final DataSource dataSource;
    private final ExtractorSampleSource.ExtractorHolder extractorHolder;
    private volatile boolean loadCanceled;
    private boolean pendingExtractorSeek;
    private final PositionHolder positionHolder;
    private final int requestedBufferSize;
    private final Uri uri;
    
    public ExtractingLoadable(Uri paramUri, DataSource paramDataSource, ExtractorSampleSource.ExtractorHolder paramExtractorHolder, Allocator paramAllocator, int paramInt, long paramLong)
    {
      uri = ((Uri)Assertions.checkNotNull(paramUri));
      dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
      extractorHolder = ((ExtractorSampleSource.ExtractorHolder)Assertions.checkNotNull(paramExtractorHolder));
      allocator = ((Allocator)Assertions.checkNotNull(paramAllocator));
      requestedBufferSize = paramInt;
      positionHolder = new PositionHolder();
      positionHolder.position = paramLong;
      pendingExtractorSeek = true;
    }
    
    public final void cancelLoad()
    {
      loadCanceled = true;
    }
    
    public final boolean isLoadCanceled()
    {
      return loadCanceled;
    }
    
    /* Error */
    public final void load()
      throws IOException, InterruptedException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iload_1
      //   3: ifne +251 -> 254
      //   6: aload_0
      //   7: getfield 68	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:loadCanceled	Z
      //   10: ifne +244 -> 254
      //   13: aload_0
      //   14: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
      //   17: getfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
      //   20: lstore 8
      //   22: aload_0
      //   23: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
      //   26: new 77	com/google/android/exoplayer/upstream/DataSpec
      //   29: dup
      //   30: aload_0
      //   31: getfield 39	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:uri	Landroid/net/Uri;
      //   34: lload 8
      //   36: ldc2_w 78
      //   39: invokespecial 82	com/google/android/exoplayer/upstream/DataSpec:<init>	(Landroid/net/Uri;JJ)V
      //   42: invokeinterface 86 2 0
      //   47: lstore 6
      //   49: lload 6
      //   51: lstore 4
      //   53: lload 6
      //   55: ldc2_w 78
      //   58: lcmp
      //   59: ifeq +10 -> 69
      //   62: lload 6
      //   64: lload 8
      //   66: ladd
      //   67: lstore 4
      //   69: new 88	com/google/android/exoplayer/extractor/DefaultExtractorInput
      //   72: dup
      //   73: aload_0
      //   74: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
      //   77: lload 8
      //   79: lload 4
      //   81: invokespecial 91	com/google/android/exoplayer/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer/upstream/DataSource;JJ)V
      //   84: astore 10
      //   86: iload_1
      //   87: istore_3
      //   88: aload_0
      //   89: getfield 47	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:extractorHolder	Lcom/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractorHolder;
      //   92: aload 10
      //   94: invokevirtual 95	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractorHolder:selectExtractor	(Lcom/google/android/exoplayer/extractor/ExtractorInput;)Lcom/google/android/exoplayer/extractor/Extractor;
      //   97: astore 11
      //   99: iload_1
      //   100: istore_2
      //   101: iload_1
      //   102: istore_3
      //   103: aload_0
      //   104: getfield 64	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:pendingExtractorSeek	Z
      //   107: ifeq +21 -> 128
      //   110: iload_1
      //   111: istore_3
      //   112: aload 11
      //   114: invokeinterface 100 1 0
      //   119: iload_1
      //   120: istore_3
      //   121: aload_0
      //   122: iconst_0
      //   123: putfield 64	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:pendingExtractorSeek	Z
      //   126: iload_1
      //   127: istore_2
      //   128: iload_2
      //   129: ifne +46 -> 175
      //   132: iload_2
      //   133: istore_3
      //   134: aload_0
      //   135: getfield 68	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:loadCanceled	Z
      //   138: ifne +37 -> 175
      //   141: iload_2
      //   142: istore_3
      //   143: aload_0
      //   144: getfield 51	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:allocator	Lcom/google/android/exoplayer/upstream/Allocator;
      //   147: aload_0
      //   148: getfield 53	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:requestedBufferSize	I
      //   151: invokeinterface 104 2 0
      //   156: iload_2
      //   157: istore_3
      //   158: aload 11
      //   160: aload 10
      //   162: aload_0
      //   163: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
      //   166: invokeinterface 108 3 0
      //   171: istore_2
      //   172: goto -44 -> 128
      //   175: iload_2
      //   176: iconst_1
      //   177: if_icmpne +17 -> 194
      //   180: iconst_0
      //   181: istore_1
      //   182: aload_0
      //   183: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
      //   186: invokeinterface 111 1 0
      //   191: goto -189 -> 2
      //   194: aload_0
      //   195: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
      //   198: aload 10
      //   200: invokeinterface 117 1 0
      //   205: putfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
      //   208: iload_2
      //   209: istore_1
      //   210: goto -28 -> 182
      //   213: astore 11
      //   215: aconst_null
      //   216: astore 10
      //   218: iload_1
      //   219: iconst_1
      //   220: if_icmpeq +22 -> 242
      //   223: aload 10
      //   225: ifnull +17 -> 242
      //   228: aload_0
      //   229: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
      //   232: aload 10
      //   234: invokeinterface 117 1 0
      //   239: putfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
      //   242: aload_0
      //   243: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
      //   246: invokeinterface 111 1 0
      //   251: aload 11
      //   253: athrow
      //   254: return
      //   255: astore 11
      //   257: iload_3
      //   258: istore_1
      //   259: goto -41 -> 218
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	ExtractingLoadable
      //   1	258	1	i	int
      //   100	109	2	j	int
      //   87	171	3	k	int
      //   51	29	4	l1	long
      //   47	16	6	l2	long
      //   20	58	8	l3	long
      //   84	149	10	localDefaultExtractorInput	DefaultExtractorInput
      //   97	62	11	localExtractor	Extractor
      //   213	39	11	localObject1	Object
      //   255	1	11	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   13	49	213	finally
      //   69	86	213	finally
      //   88	99	255	finally
      //   103	110	255	finally
      //   112	119	255	finally
      //   121	126	255	finally
      //   134	141	255	finally
      //   143	156	255	finally
      //   158	172	255	finally
    }
  }
  
  private static final class ExtractorHolder
  {
    private Extractor extractor;
    private final ExtractorOutput extractorOutput;
    private final Extractor[] extractors;
    
    public ExtractorHolder(Extractor[] paramArrayOfExtractor, ExtractorOutput paramExtractorOutput)
    {
      extractors = paramArrayOfExtractor;
      extractorOutput = paramExtractorOutput;
    }
    
    public final Extractor selectExtractor(ExtractorInput paramExtractorInput)
      throws ExtractorSampleSource.UnrecognizedInputFormatException, IOException, InterruptedException
    {
      if (extractor != null) {
        return extractor;
      }
      Extractor[] arrayOfExtractor = extractors;
      int j = arrayOfExtractor.length;
      int i = 0;
      for (;;)
      {
        Extractor localExtractor;
        if (i < j) {
          localExtractor = arrayOfExtractor[i];
        }
        try
        {
          if (localExtractor.sniff(paramExtractorInput))
          {
            extractor = localExtractor;
            if (extractor != null) {
              break;
            }
            throw new ExtractorSampleSource.UnrecognizedInputFormatException(extractors);
          }
        }
        catch (EOFException localEOFException)
        {
          paramExtractorInput.resetPeekPosition();
          i += 1;
        }
      }
      extractor.init(extractorOutput);
      return extractor;
    }
  }
  
  private final class InternalTrackOutput
    extends DefaultTrackOutput
  {
    public InternalTrackOutput(Allocator paramAllocator)
    {
      super();
    }
    
    public final void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      super.sampleMetadata(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
      ExtractorSampleSource.access$008(ExtractorSampleSource.this);
    }
  }
  
  public static final class UnrecognizedInputFormatException
    extends ParserException
  {
    public UnrecognizedInputFormatException(Extractor[] paramArrayOfExtractor)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorSampleSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */