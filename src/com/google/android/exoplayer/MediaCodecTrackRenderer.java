package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecTrackRenderer
  extends TrackRenderer
{
  MediaCodec codec;
  public final CodecCounters codecCounters;
  private boolean codecHasQueuedBuffers;
  private long codecHotswapTimeMs;
  private boolean codecIsAdaptive;
  private boolean codecNeedsEndOfStreamWorkaround;
  private int codecReconfigurationState;
  private boolean codecReconfigured;
  private int codecReinitializationState;
  private final List<Long> decodeOnlyPresentationTimestamps;
  private DrmInitData drmInitData;
  private final DrmSessionManager drmSessionManager;
  protected final Handler eventHandler;
  final EventListener eventListener;
  private MediaFormat format;
  private final MediaFormatHolder formatHolder;
  private ByteBuffer[] inputBuffers;
  private int inputIndex;
  private boolean inputStreamEnded;
  private boolean openedDrmSession;
  private final MediaCodec.BufferInfo outputBufferInfo;
  private ByteBuffer[] outputBuffers;
  private int outputIndex;
  private boolean outputStreamEnded;
  private final boolean playClearSamplesWithoutKeys;
  private final SampleHolder sampleHolder;
  private final SampleSource.SampleSourceReader source;
  int sourceState;
  private int trackIndex;
  private boolean waitingForFirstSyncFrame;
  private boolean waitingForKeys;
  
  public MediaCodecTrackRenderer(SampleSource paramSampleSource, Handler paramHandler, EventListener paramEventListener)
  {
    if (Util.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      source = paramSampleSource.register();
      drmSessionManager = null;
      playClearSamplesWithoutKeys = true;
      eventHandler = paramHandler;
      eventListener = paramEventListener;
      codecCounters = new CodecCounters();
      sampleHolder = new SampleHolder(0);
      formatHolder = new MediaFormatHolder();
      decodeOnlyPresentationTimestamps = new ArrayList();
      outputBufferInfo = new MediaCodec.BufferInfo();
      codecReconfigurationState = 0;
      codecReinitializationState = 0;
      return;
    }
  }
  
  private boolean feedInputBuffer(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    if ((inputStreamEnded) || (codecReinitializationState == 2)) {
      return false;
    }
    if (inputIndex < 0)
    {
      inputIndex = codec.dequeueInputBuffer(0L);
      if (inputIndex < 0) {
        return false;
      }
      sampleHolder.data = inputBuffers[inputIndex];
      sampleHolder.data.clear();
    }
    if (codecReinitializationState == 1)
    {
      if (!codecNeedsEndOfStreamWorkaround)
      {
        codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
        inputIndex = -1;
      }
      codecReinitializationState = 2;
      return false;
    }
    int i;
    if (waitingForKeys) {
      i = -3;
    }
    int j;
    while (i == -2)
    {
      return false;
      if (codecReconfigurationState == 1)
      {
        i = 0;
        while (i < format.initializationData.size())
        {
          byte[] arrayOfByte = (byte[])format.initializationData.get(i);
          sampleHolder.data.put(arrayOfByte);
          i += 1;
        }
        codecReconfigurationState = 2;
      }
      j = source.readData(trackIndex, paramLong, formatHolder, sampleHolder, false);
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (sourceState == 1)
        {
          i = j;
          if (j == -2)
          {
            sourceState = 2;
            i = j;
          }
        }
      }
    }
    if (i == -5)
    {
      flushCodec();
      return true;
    }
    if (i == -4)
    {
      if (codecReconfigurationState == 2)
      {
        sampleHolder.data.clear();
        codecReconfigurationState = 1;
      }
      onInputFormatChanged(formatHolder);
      return true;
    }
    if (i == -1)
    {
      if (codecReconfigurationState == 2)
      {
        sampleHolder.data.clear();
        codecReconfigurationState = 1;
      }
      inputStreamEnded = true;
      try
      {
        if (!codecNeedsEndOfStreamWorkaround)
        {
          codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
          inputIndex = -1;
        }
        return false;
      }
      catch (MediaCodec.CryptoException localCryptoException1)
      {
        notifyCryptoError(localCryptoException1);
        throw new ExoPlaybackException(localCryptoException1);
      }
    }
    if (waitingForFirstSyncFrame)
    {
      if (!sampleHolder.isSyncFrame())
      {
        sampleHolder.data.clear();
        if (codecReconfigurationState == 2) {
          codecReconfigurationState = 1;
        }
        return true;
      }
      waitingForFirstSyncFrame = false;
    }
    boolean bool = sampleHolder.isEncrypted();
    if (openedDrmSession)
    {
      i = drmSessionManager.getState();
      if (i == 0) {
        throw new ExoPlaybackException(drmSessionManager.getError());
      }
      if ((i == 4) || ((!bool) && (playClearSamplesWithoutKeys))) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      waitingForKeys = paramBoolean;
      if (!waitingForKeys) {
        break;
      }
      return false;
    }
    for (;;)
    {
      try
      {
        i = sampleHolder.data.position();
        j = i - sampleHolder.size;
        paramLong = sampleHolder.timeUs;
        if (sampleHolder.isDecodeOnly()) {
          decodeOnlyPresentationTimestamps.add(Long.valueOf(paramLong));
        }
        if (bool)
        {
          MediaCodec.CryptoInfo localCryptoInfo = sampleHolder.cryptoInfo.frameworkCryptoInfo;
          if (j == 0)
          {
            codec.queueSecureInputBuffer(inputIndex, 0, localCryptoInfo, paramLong, 0);
            inputIndex = -1;
            codecHasQueuedBuffers = true;
            codecReconfigurationState = 0;
            return true;
          }
          if (numBytesOfClearData == null) {
            numBytesOfClearData = new int[1];
          }
          int[] arrayOfInt = numBytesOfClearData;
          arrayOfInt[0] += j;
          continue;
        }
        codec.queueInputBuffer(inputIndex, 0, i, paramLong, 0);
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        notifyCryptoError(localCryptoException2);
        throw new ExoPlaybackException(localCryptoException2);
      }
    }
  }
  
  private void flushCodec()
    throws ExoPlaybackException
  {
    codecHotswapTimeMs = -1L;
    inputIndex = -1;
    outputIndex = -1;
    waitingForFirstSyncFrame = true;
    waitingForKeys = false;
    decodeOnlyPresentationTimestamps.clear();
    if ((Util.SDK_INT >= 18) && (codecReinitializationState == 0))
    {
      codec.flush();
      codecHasQueuedBuffers = false;
    }
    for (;;)
    {
      if ((codecReconfigured) && (format != null)) {
        codecReconfigurationState = 1;
      }
      return;
      releaseCodec();
      maybeInitCodec();
    }
  }
  
  private void notifyAndThrowDecoderInitError(final DecoderInitializationException paramDecoderInitializationException)
    throws ExoPlaybackException
  {
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run()
        {
          eventListener.onDecoderInitializationError(paramDecoderInitializationException);
        }
      });
    }
    throw new ExoPlaybackException(paramDecoderInitializationException);
  }
  
  private void notifyCryptoError(final MediaCodec.CryptoException paramCryptoException)
  {
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run()
        {
          eventListener.onCryptoError(paramCryptoException);
        }
      });
    }
  }
  
  private void processEndOfStream()
    throws ExoPlaybackException
  {
    if (codecReinitializationState == 2)
    {
      releaseCodec();
      maybeInitCodec();
      return;
    }
    outputStreamEnded = true;
  }
  
  private void seekToInternal()
  {
    sourceState = 0;
    inputStreamEnded = false;
    outputStreamEnded = false;
  }
  
  protected boolean canReconfigureCodec$6df5a06d(boolean paramBoolean, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2)
  {
    return false;
  }
  
  protected void configureCodec(MediaCodec paramMediaCodec, String paramString, android.media.MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
  }
  
  protected final int doPrepare(long paramLong)
  {
    if (!source.prepare(paramLong)) {
      return 0;
    }
    int j = source.getTrackCount();
    int i = 0;
    while (i < j)
    {
      if (handlesMimeType(source.getTrackInfo(i).mimeType))
      {
        trackIndex = i;
        return 1;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void doSomeWork(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    int i;
    Object localObject;
    if (source.continueBuffering(trackIndex, paramLong1)) {
      if (sourceState == 0)
      {
        i = 1;
        sourceState = i;
        if ((codec != null) && (source.readData(trackIndex, paramLong1, formatHolder, sampleHolder, true) == -5)) {
          flushCodec();
        }
        if ((format == null) && (source.readData(trackIndex, paramLong1, formatHolder, sampleHolder, false) == -4)) {
          onInputFormatChanged(formatHolder);
        }
        if ((codec == null) && (shouldInitCodec())) {
          maybeInitCodec();
        }
        if (codec != null)
        {
          TraceUtil.beginSection("drainAndFeed");
          if (outputStreamEnded) {
            break label375;
          }
          if (outputIndex < 0) {
            outputIndex = codec.dequeueOutputBuffer(outputBufferInfo, 0L);
          }
          if (outputIndex != -2) {
            break label270;
          }
          onOutputFormatChanged(format, codec.getOutputFormat());
          localObject = codecCounters;
          outputFormatChangedCount += 1;
          i = 1;
        }
      }
    }
    for (;;)
    {
      label221:
      if (i == 0)
      {
        while ((feedInputBuffer(paramLong1, true)) && (feedInputBuffer(paramLong1, false))) {}
        TraceUtil.endSection();
        codecCounters.ensureUpdated();
        return;
        i = sourceState;
        break;
        i = 0;
        break;
        label270:
        if (outputIndex == -3)
        {
          outputBuffers = codec.getOutputBuffers();
          localObject = codecCounters;
          outputBuffersChangedCount += 1;
          i = 1;
        }
        else if (outputIndex < 0)
        {
          if ((codecNeedsEndOfStreamWorkaround) && ((inputStreamEnded) || (codecReinitializationState == 2)))
          {
            processEndOfStream();
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        else if ((outputBufferInfo.flags & 0x4) != 0)
        {
          processEndOfStream();
        }
      }
    }
    label375:
    label404:
    label434:
    label535:
    label539:
    for (;;)
    {
      i = 0;
      break label221;
      long l = outputBufferInfo.presentationTimeUs;
      int j = decodeOnlyPresentationTimestamps.size();
      i = 0;
      ByteBuffer localByteBuffer;
      MediaCodec.BufferInfo localBufferInfo;
      if (i < j) {
        if (((Long)decodeOnlyPresentationTimestamps.get(i)).longValue() == l)
        {
          localObject = codec;
          localByteBuffer = outputBuffers[outputIndex];
          localBufferInfo = outputBufferInfo;
          j = outputIndex;
          if (i == -1) {
            break label535;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (!processOutputBuffer(paramLong1, paramLong2, (MediaCodec)localObject, localByteBuffer, localBufferInfo, j, bool)) {
          break label539;
        }
        if (i != -1) {
          decodeOnlyPresentationTimestamps.remove(i);
        }
        outputIndex = -1;
        i = 1;
        break label221;
        break;
        i += 1;
        break label404;
        i = -1;
        break label434;
      }
    }
  }
  
  protected final long getBufferedPositionUs()
  {
    return source.getBufferedPositionUs();
  }
  
  protected DecoderInfo getDecoderInfo(String paramString, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    return MediaCodecUtil.getDecoderInfo(paramString, paramBoolean);
  }
  
  protected final long getDurationUs()
  {
    return source.getTrackInfo(trackIndex).durationUs;
  }
  
  protected boolean handlesMimeType(String paramString)
  {
    return true;
  }
  
  protected boolean isEnded()
  {
    return outputStreamEnded;
  }
  
  protected boolean isReady()
  {
    if ((format != null) && (!waitingForKeys))
    {
      if ((sourceState == 0) && (outputIndex < 0)) {
        if (SystemClock.elapsedRealtime() >= codecHotswapTimeMs + 1000L) {
          break label51;
        }
      }
      label51:
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  protected final void maybeInitCodec()
    throws ExoPlaybackException
  {
    if (!shouldInitCodec()) {}
    int i;
    do
    {
      return;
      localObject3 = format.mimeType;
      localObject1 = null;
      bool = false;
      if (drmInitData == null) {
        break;
      }
      if (drmSessionManager == null) {
        throw new ExoPlaybackException("Media requires a DrmSessionManager");
      }
      if (!openedDrmSession) {
        openedDrmSession = true;
      }
      i = drmSessionManager.getState();
      if (i == 0) {
        throw new ExoPlaybackException(drmSessionManager.getError());
      }
    } while ((i != 3) && (i != 4));
    Object localObject1 = drmSessionManager.getMediaCrypto();
    bool = drmSessionManager.requiresSecureDecoderComponent$552c4dfd();
    Object localObject2 = null;
    try
    {
      localObject3 = getDecoderInfo((String)localObject3, bool);
      localObject2 = localObject3;
    }
    catch (MediaCodecUtil.DecoderQueryException localDecoderQueryException)
    {
      for (;;)
      {
        notifyAndThrowDecoderInitError(new DecoderInitializationException(format, localDecoderQueryException, -49998));
        continue;
        bool = false;
      }
    }
    if (localObject2 == null) {
      notifyAndThrowDecoderInitError(new DecoderInitializationException(format, null, -49999));
    }
    final Object localObject3 = name;
    codecIsAdaptive = adaptive;
    if ((Util.SDK_INT <= 17) && ("ht7s3".equals(Util.DEVICE)) && ("OMX.rk.video_decoder.avc".equals(localObject3)))
    {
      bool = true;
      codecNeedsEndOfStreamWorkaround = bool;
    }
    try
    {
      l1 = SystemClock.elapsedRealtime();
      TraceUtil.beginSection("createByCodecName(" + (String)localObject3 + ")");
      codec = MediaCodec.createByCodecName((String)localObject3);
      TraceUtil.endSection();
      TraceUtil.beginSection("configureCodec");
      configureCodec(codec, (String)localObject3, format.getFrameworkMediaFormatV16(), (MediaCrypto)localObject1);
      TraceUtil.endSection();
      TraceUtil.beginSection("codec.start()");
      codec.start();
      TraceUtil.endSection();
      final long l2 = SystemClock.elapsedRealtime();
      if ((eventHandler != null) && (eventListener != null)) {
        eventHandler.post(new Runnable()
        {
          public final void run()
          {
            eventListener.onDecoderInitialized(localObject3, l2, val$initializationDuration);
          }
        });
      }
      inputBuffers = codec.getInputBuffers();
      outputBuffers = codec.getOutputBuffers();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        notifyAndThrowDecoderInitError(new DecoderInitializationException(format, localException, localDecoderQueryException));
        continue;
        long l1 = -1L;
      }
    }
    if (state == 3)
    {
      l1 = SystemClock.elapsedRealtime();
      codecHotswapTimeMs = l1;
      inputIndex = -1;
      outputIndex = -1;
      waitingForFirstSyncFrame = true;
      localObject1 = codecCounters;
      codecInitCount += 1;
      return;
    }
  }
  
  protected final void maybeThrowError()
    throws ExoPlaybackException
  {
    try
    {
      source.maybeThrowError();
      return;
    }
    catch (IOException localIOException)
    {
      throw new ExoPlaybackException(localIOException);
    }
  }
  
  /* Error */
  protected void onDisabled()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 171	com/google/android/exoplayer/MediaCodecTrackRenderer:format	Lcom/google/android/exoplayer/MediaFormat;
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 444	com/google/android/exoplayer/MediaCodecTrackRenderer:drmInitData	Lcom/google/android/exoplayer/drm/DrmInitData;
    //   10: aload_0
    //   11: invokevirtual 296	com/google/android/exoplayer/MediaCodecTrackRenderer:releaseCodec	()V
    //   14: aload_0
    //   15: getfield 227	com/google/android/exoplayer/MediaCodecTrackRenderer:openedDrmSession	Z
    //   18: ifeq +8 -> 26
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 227	com/google/android/exoplayer/MediaCodecTrackRenderer:openedDrmSession	Z
    //   26: aload_0
    //   27: getfield 91	com/google/android/exoplayer/MediaCodecTrackRenderer:source	Lcom/google/android/exoplayer/SampleSource$SampleSourceReader;
    //   30: aload_0
    //   31: getfield 194	com/google/android/exoplayer/MediaCodecTrackRenderer:trackIndex	I
    //   34: invokeinterface 539 2 0
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 91	com/google/android/exoplayer/MediaCodecTrackRenderer:source	Lcom/google/android/exoplayer/SampleSource$SampleSourceReader;
    //   45: aload_0
    //   46: getfield 194	com/google/android/exoplayer/MediaCodecTrackRenderer:trackIndex	I
    //   49: invokeinterface 539 2 0
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 227	com/google/android/exoplayer/MediaCodecTrackRenderer:openedDrmSession	Z
    //   61: ifeq +8 -> 69
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 227	com/google/android/exoplayer/MediaCodecTrackRenderer:openedDrmSession	Z
    //   69: aload_0
    //   70: getfield 91	com/google/android/exoplayer/MediaCodecTrackRenderer:source	Lcom/google/android/exoplayer/SampleSource$SampleSourceReader;
    //   73: aload_0
    //   74: getfield 194	com/google/android/exoplayer/MediaCodecTrackRenderer:trackIndex	I
    //   77: invokeinterface 539 2 0
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 91	com/google/android/exoplayer/MediaCodecTrackRenderer:source	Lcom/google/android/exoplayer/SampleSource$SampleSourceReader;
    //   89: aload_0
    //   90: getfield 194	com/google/android/exoplayer/MediaCodecTrackRenderer:trackIndex	I
    //   93: invokeinterface 539 2 0
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	MediaCodecTrackRenderer
    //   40	15	1	localObject1	Object
    //   56	27	1	localObject2	Object
    //   84	15	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	40	finally
    //   10	14	56	finally
    //   57	69	84	finally
  }
  
  protected void onEnabled(long paramLong, boolean paramBoolean)
  {
    source.enable(trackIndex, paramLong);
    seekToInternal();
  }
  
  protected void onInputFormatChanged(MediaFormatHolder paramMediaFormatHolder)
    throws ExoPlaybackException
  {
    MediaFormat localMediaFormat = format;
    format = format;
    drmInitData = drmInitData;
    if ((codec != null) && (canReconfigureCodec$6df5a06d(codecIsAdaptive, localMediaFormat, format)))
    {
      codecReconfigured = true;
      codecReconfigurationState = 1;
      return;
    }
    if (codecHasQueuedBuffers)
    {
      codecReinitializationState = 1;
      return;
    }
    releaseCodec();
    maybeInitCodec();
  }
  
  protected void onOutputFormatChanged(MediaFormat paramMediaFormat, android.media.MediaFormat paramMediaFormat1) {}
  
  protected final void onReleased()
  {
    source.release();
  }
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  protected abstract boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
    throws ExoPlaybackException;
  
  /* Error */
  protected final void releaseCodec()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   4: ifnull +108 -> 112
    //   7: aload_0
    //   8: ldc2_w 281
    //   11: putfield 284	com/google/android/exoplayer/MediaCodecTrackRenderer:codecHotswapTimeMs	J
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 141	com/google/android/exoplayer/MediaCodecTrackRenderer:inputIndex	I
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 286	com/google/android/exoplayer/MediaCodecTrackRenderer:outputIndex	I
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 169	com/google/android/exoplayer/MediaCodecTrackRenderer:waitingForKeys	Z
    //   29: aload_0
    //   30: getfield 121	com/google/android/exoplayer/MediaCodecTrackRenderer:decodeOnlyPresentationTimestamps	Ljava/util/List;
    //   33: invokeinterface 288 1 0
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 151	com/google/android/exoplayer/MediaCodecTrackRenderer:inputBuffers	[Ljava/nio/ByteBuffer;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 393	com/google/android/exoplayer/MediaCodecTrackRenderer:outputBuffers	[Ljava/nio/ByteBuffer;
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 293	com/google/android/exoplayer/MediaCodecTrackRenderer:codecReconfigured	Z
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 273	com/google/android/exoplayer/MediaCodecTrackRenderer:codecHasQueuedBuffers	Z
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 472	com/google/android/exoplayer/MediaCodecTrackRenderer:codecIsAdaptive	Z
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 163	com/google/android/exoplayer/MediaCodecTrackRenderer:codecNeedsEndOfStreamWorkaround	Z
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 128	com/google/android/exoplayer/MediaCodecTrackRenderer:codecReconfigurationState	I
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 130	com/google/android/exoplayer/MediaCodecTrackRenderer:codecReinitializationState	I
    //   78: aload_0
    //   79: getfield 104	com/google/android/exoplayer/MediaCodecTrackRenderer:codecCounters	Lcom/google/android/exoplayer/CodecCounters;
    //   82: astore_1
    //   83: aload_1
    //   84: aload_1
    //   85: getfield 560	com/google/android/exoplayer/CodecCounters:codecReleaseCount	I
    //   88: iconst_1
    //   89: iadd
    //   90: putfield 560	com/google/android/exoplayer/CodecCounters:codecReleaseCount	I
    //   93: aload_0
    //   94: getfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   97: invokevirtual 563	android/media/MediaCodec:stop	()V
    //   100: aload_0
    //   101: getfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   104: invokevirtual 564	android/media/MediaCodec:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   126: invokevirtual 564	android/media/MediaCodec:release	()V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 143	com/google/android/exoplayer/MediaCodecTrackRenderer:codec	Landroid/media/MediaCodec;
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	MediaCodecTrackRenderer
    //   82	3	1	localCodecCounters	CodecCounters
    //   113	7	1	localObject1	Object
    //   121	14	1	localObject2	Object
    //   136	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   100	107	113	finally
    //   93	100	121	finally
    //   122	129	136	finally
  }
  
  protected void seekTo(long paramLong)
    throws ExoPlaybackException
  {
    source.seekToUs(paramLong);
    seekToInternal();
  }
  
  protected boolean shouldInitCodec()
  {
    return (codec == null) && (format != null);
  }
  
  public static final class DecoderInitializationException
    extends Exception
  {
    public final String decoderName;
    public final String diagnosticInfo;
    
    public DecoderInitializationException(MediaFormat paramMediaFormat, Throwable paramThrowable, int paramInt)
    {
      super(paramThrowable);
      decoderName = null;
      if (paramInt < 0) {}
      for (paramMediaFormat = "neg_";; paramMediaFormat = "")
      {
        diagnosticInfo = ("com.google.android.exoplayer.MediaCodecTrackRenderer_" + paramMediaFormat + Math.abs(paramInt));
        return;
      }
    }
    
    public DecoderInitializationException(MediaFormat paramMediaFormat, Throwable paramThrowable, String paramString)
    {
      super(paramThrowable);
      decoderName = paramString;
      paramMediaFormat = (MediaFormat)localObject;
      if (Util.SDK_INT >= 21)
      {
        paramMediaFormat = (MediaFormat)localObject;
        if ((paramThrowable instanceof MediaCodec.CodecException)) {
          paramMediaFormat = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
        }
      }
      diagnosticInfo = paramMediaFormat;
    }
  }
  
  public static abstract interface EventListener
  {
    public abstract void onCryptoError(MediaCodec.CryptoException paramCryptoException);
    
    public abstract void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException paramDecoderInitializationException);
    
    public abstract void onDecoderInitialized(String paramString, long paramLong1, long paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */