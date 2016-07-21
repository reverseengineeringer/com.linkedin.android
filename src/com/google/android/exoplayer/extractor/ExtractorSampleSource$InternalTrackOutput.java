package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.Allocator;

final class ExtractorSampleSource$InternalTrackOutput
  extends DefaultTrackOutput
{
  public ExtractorSampleSource$InternalTrackOutput(ExtractorSampleSource paramExtractorSampleSource, Allocator paramAllocator)
  {
    super(paramAllocator);
  }
  
  public final void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    super.sampleMetadata(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
    ExtractorSampleSource.access$008(this$0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorSampleSource.InternalTrackOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */