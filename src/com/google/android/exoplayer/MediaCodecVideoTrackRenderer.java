package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class MediaCodecVideoTrackRenderer
  extends MediaCodecTrackRenderer
{
  private final long allowedJoiningTimeUs = 5000000L;
  private int currentHeight;
  private float currentPixelWidthHeightRatio;
  private int currentWidth;
  private long droppedFrameAccumulationStartTimeMs;
  private int droppedFrameCount;
  final EventListener eventListener;
  private final FrameReleaseTimeHelper frameReleaseTimeHelper = null;
  private long joiningDeadlineUs;
  private int lastReportedHeight;
  private float lastReportedPixelWidthHeightRatio;
  private int lastReportedWidth;
  private final int maxDroppedFrameCountToNotify;
  private float pendingPixelWidthHeightRatio;
  private boolean renderedFirstFrame;
  private boolean reportedDrawnToSurface;
  private Surface surface;
  private final int videoScalingMode = 1;
  
  public MediaCodecVideoTrackRenderer(SampleSource paramSampleSource, Handler paramHandler, EventListener paramEventListener)
  {
    this(paramSampleSource, paramHandler, paramEventListener, (byte)0);
  }
  
  public MediaCodecVideoTrackRenderer(SampleSource paramSampleSource, Handler paramHandler, EventListener paramEventListener, byte paramByte)
  {
    super(paramSampleSource, paramHandler, paramEventListener);
    eventListener = paramEventListener;
    maxDroppedFrameCountToNotify = 50;
    joiningDeadlineUs = -1L;
    currentWidth = -1;
    currentHeight = -1;
    currentPixelWidthHeightRatio = -1.0F;
    pendingPixelWidthHeightRatio = -1.0F;
    lastReportedWidth = -1;
    lastReportedHeight = -1;
    lastReportedPixelWidthHeightRatio = -1.0F;
  }
  
  private void maybeNotifyDrawnToSurface()
  {
    if ((eventHandler == null) || (eventListener == null) || (reportedDrawnToSurface)) {
      return;
    }
    final Surface localSurface = surface;
    eventHandler.post(new Runnable()
    {
      public final void run()
      {
        eventListener.onDrawnToSurface(localSurface);
      }
    });
    reportedDrawnToSurface = true;
  }
  
  private void maybeNotifyDroppedFrameCount()
  {
    if ((eventHandler == null) || (eventListener == null) || (droppedFrameCount == 0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    final int i = droppedFrameCount;
    long l2 = droppedFrameAccumulationStartTimeMs;
    eventHandler.post(new Runnable()
    {
      public final void run()
      {
        eventListener.onDroppedFrames(i, val$elapsedToNotify);
      }
    });
    droppedFrameCount = 0;
    droppedFrameAccumulationStartTimeMs = l1;
  }
  
  private void maybeNotifyVideoSizeChanged()
  {
    if ((eventHandler == null) || (eventListener == null) || ((lastReportedWidth == currentWidth) && (lastReportedHeight == currentHeight) && (lastReportedPixelWidthHeightRatio == currentPixelWidthHeightRatio))) {
      return;
    }
    final int i = currentWidth;
    final int j = currentHeight;
    final float f = currentPixelWidthHeightRatio;
    eventHandler.post(new Runnable()
    {
      public final void run()
      {
        eventListener.onVideoSizeChanged(i, j, f);
      }
    });
    lastReportedWidth = i;
    lastReportedHeight = j;
    lastReportedPixelWidthHeightRatio = f;
  }
  
  private void renderOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    maybeNotifyVideoSizeChanged();
    TraceUtil.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    TraceUtil.endSection();
    paramMediaCodec = codecCounters;
    renderedOutputBufferCount += 1;
    renderedFirstFrame = true;
    maybeNotifyDrawnToSurface();
  }
  
  @TargetApi(21)
  private void renderOutputBufferV21(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    maybeNotifyVideoSizeChanged();
    TraceUtil.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    TraceUtil.endSection();
    paramMediaCodec = codecCounters;
    renderedOutputBufferCount += 1;
    renderedFirstFrame = true;
    maybeNotifyDrawnToSurface();
  }
  
  protected final boolean canReconfigureCodec$6df5a06d(boolean paramBoolean, MediaFormat paramMediaFormat1, MediaFormat paramMediaFormat2)
  {
    return (mimeType.equals(mimeType)) && ((paramBoolean) || ((width == width) && (height == height)));
  }
  
  protected final void configureCodec(MediaCodec paramMediaCodec, String paramString, android.media.MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    paramMediaCodec.configure(paramMediaFormat, surface, paramMediaCrypto, 0);
    paramMediaCodec.setVideoScalingMode(videoScalingMode);
  }
  
  public final void handleMessage(int paramInt, Object paramObject)
    throws ExoPlaybackException
  {
    if (paramInt == 1)
    {
      paramObject = (Surface)paramObject;
      if (surface != paramObject)
      {
        surface = ((Surface)paramObject);
        reportedDrawnToSurface = false;
        paramInt = state;
        if ((paramInt == 2) || (paramInt == 3))
        {
          releaseCodec();
          maybeInitCodec();
        }
      }
      return;
    }
    super.handleMessage(paramInt, paramObject);
  }
  
  protected final boolean handlesMimeType(String paramString)
  {
    return (MimeTypes.isVideo(paramString)) && (super.handlesMimeType(paramString));
  }
  
  protected final boolean isReady()
  {
    int i;
    if (super.isReady()) {
      if (!renderedFirstFrame)
      {
        if (codec != null)
        {
          i = 1;
          if ((i != 0) && (sourceState != 2)) {
            break label49;
          }
        }
      }
      else {
        joiningDeadlineUs = -1L;
      }
    }
    label49:
    do
    {
      return true;
      i = 0;
      break;
      if (joiningDeadlineUs == -1L) {
        return false;
      }
    } while (SystemClock.elapsedRealtime() * 1000L < joiningDeadlineUs);
    joiningDeadlineUs = -1L;
    return false;
  }
  
  public final void onDisabled()
  {
    currentWidth = -1;
    currentHeight = -1;
    currentPixelWidthHeightRatio = -1.0F;
    pendingPixelWidthHeightRatio = -1.0F;
    lastReportedWidth = -1;
    lastReportedHeight = -1;
    lastReportedPixelWidthHeightRatio = -1.0F;
    super.onDisabled();
  }
  
  protected final void onEnabled(long paramLong, boolean paramBoolean)
  {
    super.onEnabled(paramLong, paramBoolean);
    renderedFirstFrame = false;
    if ((paramBoolean) && (allowedJoiningTimeUs > 0L)) {
      joiningDeadlineUs = (SystemClock.elapsedRealtime() * 1000L + allowedJoiningTimeUs);
    }
  }
  
  protected final void onInputFormatChanged(MediaFormatHolder paramMediaFormatHolder)
    throws ExoPlaybackException
  {
    super.onInputFormatChanged(paramMediaFormatHolder);
    if (format.pixelWidthHeightRatio == -1.0F) {}
    for (float f = 1.0F;; f = format.pixelWidthHeightRatio)
    {
      pendingPixelWidthHeightRatio = f;
      return;
    }
  }
  
  protected final void onOutputFormatChanged(MediaFormat paramMediaFormat, android.media.MediaFormat paramMediaFormat1)
  {
    int j;
    if ((paramMediaFormat1.containsKey("crop-right")) && (paramMediaFormat1.containsKey("crop-left")) && (paramMediaFormat1.containsKey("crop-bottom")) && (paramMediaFormat1.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0) {
        break label112;
      }
      j = paramMediaFormat1.getInteger("crop-right") - paramMediaFormat1.getInteger("crop-left") + 1;
      label65:
      currentWidth = j;
      if (i == 0) {
        break label124;
      }
    }
    label112:
    label124:
    for (int i = paramMediaFormat1.getInteger("crop-bottom") - paramMediaFormat1.getInteger("crop-top") + 1;; i = paramMediaFormat1.getInteger("height"))
    {
      currentHeight = i;
      currentPixelWidthHeightRatio = pendingPixelWidthHeightRatio;
      return;
      i = 0;
      break;
      j = paramMediaFormat1.getInteger("width");
      break label65;
    }
  }
  
  protected final void onStarted()
  {
    super.onStarted();
    droppedFrameCount = 0;
    droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
  }
  
  protected final void onStopped()
  {
    joiningDeadlineUs = -1L;
    maybeNotifyDroppedFrameCount();
    super.onStopped();
  }
  
  protected final boolean processOutputBuffer(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TraceUtil.beginSection("skipVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      TraceUtil.endSection();
      paramMediaCodec = codecCounters;
      skippedOutputBufferCount += 1;
      return true;
    }
    long l = SystemClock.elapsedRealtime();
    paramLong2 = presentationTimeUs - paramLong1 - (l * 1000L - paramLong2);
    l = System.nanoTime();
    if (frameReleaseTimeHelper != null)
    {
      paramByteBuffer = frameReleaseTimeHelper;
      paramLong1 = presentationTimeUs;
      paramLong1 = paramByteBuffer.adjustReleaseTime$2566aa9();
      paramLong2 = (paramLong1 - l) / 1000L;
    }
    while (paramLong2 < -30000L)
    {
      TraceUtil.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      TraceUtil.endSection();
      paramMediaCodec = codecCounters;
      droppedOutputBufferCount += 1;
      droppedFrameCount += 1;
      if (droppedFrameCount == maxDroppedFrameCountToNotify) {
        maybeNotifyDroppedFrameCount();
      }
      return true;
      paramLong1 = l + 1000L * paramLong2;
    }
    if (!renderedFirstFrame)
    {
      if (Util.SDK_INT >= 21) {
        renderOutputBufferV21(paramMediaCodec, paramInt, System.nanoTime());
      }
      for (;;)
      {
        return true;
        renderOutputBuffer(paramMediaCodec, paramInt);
      }
    }
    if (state != 3) {
      return false;
    }
    if (Util.SDK_INT >= 21)
    {
      if (paramLong2 < 50000L)
      {
        renderOutputBufferV21(paramMediaCodec, paramInt, paramLong1);
        return true;
      }
    }
    else if (paramLong2 < 30000L)
    {
      if (paramLong2 > 11000L) {}
      try
      {
        Thread.sleep((paramLong2 - 10000L) / 1000L);
        renderOutputBuffer(paramMediaCodec, paramInt);
        return true;
      }
      catch (InterruptedException paramByteBuffer)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    return false;
  }
  
  protected final void seekTo(long paramLong)
    throws ExoPlaybackException
  {
    super.seekTo(paramLong);
    renderedFirstFrame = false;
    joiningDeadlineUs = -1L;
  }
  
  protected final boolean shouldInitCodec()
  {
    return (super.shouldInitCodec()) && (surface != null) && (surface.isValid());
  }
  
  public static abstract interface EventListener
    extends MediaCodecTrackRenderer.EventListener
  {
    public abstract void onDrawnToSurface(Surface paramSurface);
    
    public abstract void onDroppedFrames(int paramInt, long paramLong);
    
    public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, float paramFloat);
  }
  
  public static abstract interface FrameReleaseTimeHelper
  {
    public abstract long adjustReleaseTime$2566aa9();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecVideoTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */