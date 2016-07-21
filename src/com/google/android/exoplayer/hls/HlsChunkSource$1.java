package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator;
import java.util.Comparator;

final class HlsChunkSource$1
  implements Comparator<Variant>
{
  private final Comparator<Format> formatComparator = new Format.DecreasingBandwidthComparator();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsChunkSource.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */