package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;

public abstract class MediaChunk
  extends Chunk
{
  public final int chunkIndex;
  public final long endTimeUs;
  public final boolean isLastChunk;
  public final long startTimeUs;
  
  public MediaChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    super(paramDataSource, paramDataSpec, 1, paramFormat);
    Assertions.checkNotNull(paramFormat);
    startTimeUs = paramLong1;
    endTimeUs = paramLong2;
    chunkIndex = paramInt;
    isLastChunk = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.MediaChunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */