package com.google.android.exoplayer.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MetadataTrackRenderer<T>
  extends TrackRenderer
  implements Handler.Callback
{
  private final MediaFormatHolder formatHolder;
  private boolean inputStreamEnded;
  private final Handler metadataHandler;
  private final MetadataParser<T> metadataParser;
  private final MetadataRenderer<T> metadataRenderer;
  private T pendingMetadata;
  private long pendingMetadataTimestamp;
  private final SampleHolder sampleHolder;
  private final SampleSource.SampleSourceReader source;
  private int trackIndex;
  
  public MetadataTrackRenderer(SampleSource paramSampleSource, MetadataParser<T> paramMetadataParser, MetadataRenderer<T> paramMetadataRenderer, Looper paramLooper)
  {
    source = paramSampleSource.register();
    metadataParser = ((MetadataParser)Assertions.checkNotNull(paramMetadataParser));
    metadataRenderer = ((MetadataRenderer)Assertions.checkNotNull(paramMetadataRenderer));
    if (paramLooper == null) {}
    for (paramSampleSource = null;; paramSampleSource = new Handler(paramLooper, this))
    {
      metadataHandler = paramSampleSource;
      formatHolder = new MediaFormatHolder();
      sampleHolder = new SampleHolder(1);
      return;
    }
  }
  
  private void invokeRendererInternal(T paramT)
  {
    metadataRenderer.onMetadata(paramT);
  }
  
  private void seekToInternal()
  {
    pendingMetadata = null;
    inputStreamEnded = false;
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
      if (metadataParser.canParse(source.getTrackInfo(i).mimeType))
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
    source.continueBuffering(trackIndex, paramLong1);
    int i;
    if ((!inputStreamEnded) && (pendingMetadata == null))
    {
      i = source.readData(trackIndex, paramLong1, formatHolder, sampleHolder, false);
      if (i != -3) {
        break label173;
      }
      pendingMetadataTimestamp = sampleHolder.timeUs;
    }
    for (;;)
    {
      try
      {
        pendingMetadata = metadataParser.parse(sampleHolder.data.array(), sampleHolder.size);
        sampleHolder.data.clear();
        if ((pendingMetadata != null) && (pendingMetadataTimestamp <= paramLong1))
        {
          Object localObject = pendingMetadata;
          if (metadataHandler == null) {
            break label187;
          }
          metadataHandler.obtainMessage(0, localObject).sendToTarget();
          pendingMetadata = null;
        }
        return;
      }
      catch (IOException localIOException)
      {
        throw new ExoPlaybackException(localIOException);
      }
      label173:
      if (i == -1)
      {
        inputStreamEnded = true;
        continue;
        label187:
        invokeRendererInternal(localIOException);
      }
    }
  }
  
  protected final long getBufferedPositionUs()
  {
    return -3L;
  }
  
  protected final long getDurationUs()
  {
    return source.getTrackInfo(trackIndex).durationUs;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      return false;
    }
    invokeRendererInternal(obj);
    return true;
  }
  
  protected final boolean isEnded()
  {
    return inputStreamEnded;
  }
  
  protected final boolean isReady()
  {
    return true;
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
  
  protected final void onDisabled()
  {
    pendingMetadata = null;
    source.disable(trackIndex);
  }
  
  protected final void onEnabled(long paramLong, boolean paramBoolean)
  {
    source.enable(trackIndex, paramLong);
    seekToInternal();
  }
  
  protected final void seekTo(long paramLong)
    throws ExoPlaybackException
  {
    source.seekToUs(paramLong);
    seekToInternal();
  }
  
  public static abstract interface MetadataRenderer<T>
  {
    public abstract void onMetadata(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.metadata.MetadataTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */