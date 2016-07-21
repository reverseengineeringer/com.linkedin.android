package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.ParsableByteArray;

final class TrackFragment
{
  public boolean definesEncryptionData;
  public int length;
  public int[] sampleCompositionTimeOffsetTable;
  public long[] sampleDecodingTimeTable;
  public int sampleDescriptionIndex;
  public ParsableByteArray sampleEncryptionData;
  public int sampleEncryptionDataLength;
  public boolean sampleEncryptionDataNeedsFill;
  public boolean[] sampleHasSubsampleEncryptionTable;
  public boolean[] sampleIsSyncFrameTable;
  public int[] sampleSizeTable;
  
  public final void initEncryptionData(int paramInt)
  {
    if ((sampleEncryptionData == null) || (sampleEncryptionData.limit < paramInt)) {
      sampleEncryptionData = new ParsableByteArray(paramInt);
    }
    sampleEncryptionDataLength = paramInt;
    definesEncryptionData = true;
    sampleEncryptionDataNeedsFill = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.TrackFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */