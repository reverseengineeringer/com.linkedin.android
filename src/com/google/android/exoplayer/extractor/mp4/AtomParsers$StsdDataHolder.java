package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.MediaFormat;

final class AtomParsers$StsdDataHolder
{
  public MediaFormat mediaFormat;
  public int nalUnitLengthFieldLength;
  public final TrackEncryptionBox[] trackEncryptionBoxes;
  
  public AtomParsers$StsdDataHolder(int paramInt)
  {
    trackEncryptionBoxes = new TrackEncryptionBox[paramInt];
    nalUnitLengthFieldLength = -1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.AtomParsers.StsdDataHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */