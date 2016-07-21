package com.google.android.exoplayer.hls;

import android.util.SparseArray;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.Assertions;

public final class HlsExtractorWrapper
  implements ExtractorOutput
{
  Allocator allocator;
  final Extractor extractor;
  public final Format format;
  private boolean prepared;
  final SparseArray<DefaultTrackOutput> sampleQueues;
  final boolean shouldSpliceIn;
  boolean spliceConfigured;
  public final long startTimeUs;
  private volatile boolean tracksBuilt;
  public final int trigger = 0;
  
  public HlsExtractorWrapper(Format paramFormat, long paramLong, Extractor paramExtractor, boolean paramBoolean)
  {
    format = paramFormat;
    startTimeUs = paramLong;
    extractor = paramExtractor;
    shouldSpliceIn = paramBoolean;
    sampleQueues = new SparseArray();
  }
  
  public final void clear()
  {
    int i = 0;
    while (i < sampleQueues.size())
    {
      ((DefaultTrackOutput)sampleQueues.valueAt(i)).clear();
      i += 1;
    }
  }
  
  public final void drmInitData(DrmInitData paramDrmInitData) {}
  
  public final void endTracks()
  {
    tracksBuilt = true;
  }
  
  public final MediaFormat getMediaFormat(int paramInt)
  {
    Assertions.checkState(isPrepared());
    return sampleQueues.valueAt(paramInt)).format;
  }
  
  public final int getTrackCount()
  {
    Assertions.checkState(isPrepared());
    return sampleQueues.size();
  }
  
  public final boolean hasSamples(int paramInt)
  {
    Assertions.checkState(isPrepared());
    return !((DefaultTrackOutput)sampleQueues.valueAt(paramInt)).isEmpty();
  }
  
  public final boolean isPrepared()
  {
    if ((!prepared) && (tracksBuilt))
    {
      int i = 0;
      while (i < sampleQueues.size())
      {
        if (!((DefaultTrackOutput)sampleQueues.valueAt(i)).hasFormat()) {
          return false;
        }
        i += 1;
      }
      prepared = true;
    }
    return prepared;
  }
  
  public final void seekMap(SeekMap paramSeekMap) {}
  
  public final TrackOutput track(int paramInt)
  {
    DefaultTrackOutput localDefaultTrackOutput = new DefaultTrackOutput(allocator);
    sampleQueues.put(paramInt, localDefaultTrackOutput);
    return localDefaultTrackOutput;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsExtractorWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */