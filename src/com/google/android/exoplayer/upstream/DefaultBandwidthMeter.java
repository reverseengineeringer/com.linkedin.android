package com.google.android.exoplayer.upstream;

import android.os.Handler;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Clock;
import com.google.android.exoplayer.util.SlidingPercentile;
import com.google.android.exoplayer.util.SlidingPercentile.Sample;
import com.google.android.exoplayer.util.SystemClock;
import java.util.ArrayList;
import java.util.Collections;

public final class DefaultBandwidthMeter
  implements BandwidthMeter
{
  private long bitrateEstimate;
  private long bytesAccumulator;
  private final Clock clock;
  private final Handler eventHandler = null;
  final BandwidthMeter.EventListener eventListener = null;
  private final SlidingPercentile slidingPercentile;
  private long startTimeMs;
  private int streamCount;
  
  public DefaultBandwidthMeter()
  {
    this((byte)0);
  }
  
  private DefaultBandwidthMeter(byte paramByte)
  {
    this(new SystemClock());
  }
  
  private DefaultBandwidthMeter(Clock paramClock)
  {
    this(paramClock, (byte)0);
  }
  
  private DefaultBandwidthMeter(Clock paramClock, byte paramByte)
  {
    clock = paramClock;
    slidingPercentile = new SlidingPercentile();
    bitrateEstimate = -1L;
  }
  
  public final long getBitrateEstimate()
  {
    try
    {
      long l = bitrateEstimate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onBytesTransferred(int paramInt)
  {
    try
    {
      bytesAccumulator += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onTransferEnd()
  {
    int i = 0;
    long l2;
    final int k;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (streamCount > 0)
        {
          bool = true;
          Assertions.checkState(bool);
          l2 = clock.elapsedRealtime();
          k = (int)(l2 - startTimeMs);
          if (k <= 0) {
            break label519;
          }
          f = (float)(bytesAccumulator * 8000L / k);
          localObject4 = slidingPercentile;
          j = (int)Math.sqrt(bytesAccumulator);
          if (currentSortOrder != 1)
          {
            Collections.sort(samples, SlidingPercentile.INDEX_COMPARATOR);
            currentSortOrder = 1;
          }
          if (recycledSampleCount <= 0) {
            break label323;
          }
          Object localObject1 = recycledSamples;
          int m = recycledSampleCount - 1;
          recycledSampleCount = m;
          localObject1 = localObject1[m];
          m = nextSampleIndex;
          nextSampleIndex = (m + 1);
          index = m;
          weight = j;
          value = f;
          samples.add(localObject1);
          totalWeight += j;
          if (totalWeight <= maxWeight) {
            break;
          }
          j = totalWeight - maxWeight;
          localObject1 = (SlidingPercentile.Sample)samples.get(0);
          if (weight > j) {
            break label336;
          }
          totalWeight -= weight;
          samples.remove(0);
          if (recycledSampleCount >= 5) {
            continue;
          }
          SlidingPercentile.Sample[] arrayOfSample = recycledSamples;
          j = recycledSampleCount;
          recycledSampleCount = (j + 1);
          arrayOfSample[j] = localObject1;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label323:
      localObject3 = new SlidingPercentile.Sample((byte)0);
      continue;
      label336:
      weight -= j;
      totalWeight -= j;
    }
    Object localObject3 = slidingPercentile;
    if (currentSortOrder != 0)
    {
      Collections.sort(samples, SlidingPercentile.VALUE_COMPARATOR);
      currentSortOrder = 0;
    }
    float f = totalWeight;
    int j = 0;
    if (i < samples.size())
    {
      localObject4 = (SlidingPercentile.Sample)samples.get(i);
      j += weight;
      if (j >= 0.5F * f)
      {
        f = value;
        label453:
        if (!Float.isNaN(f)) {
          break label602;
        }
      }
    }
    label519:
    label602:
    for (final long l1 = -1L;; l1 = f)
    {
      bitrateEstimate = l1;
      l1 = bytesAccumulator;
      long l3 = bitrateEstimate;
      if ((eventHandler != null) && (eventListener != null)) {
        eventHandler.post(new Runnable()
        {
          public final void run()
          {
            eventListener.onBandwidthSample(k, l1, val$bitrate);
          }
        });
      }
      streamCount -= 1;
      if (streamCount > 0) {
        startTimeMs = l2;
      }
      bytesAccumulator = 0L;
      return;
      i += 1;
      break;
      if (samples.isEmpty())
      {
        f = NaN.0F;
        break label453;
      }
      f = samples.get(samples.size() - 1)).value;
      break label453;
    }
  }
  
  public final void onTransferStart()
  {
    try
    {
      if (streamCount == 0) {
        startTimeMs = clock.elapsedRealtime();
      }
      streamCount += 1;
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DefaultBandwidthMeter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */