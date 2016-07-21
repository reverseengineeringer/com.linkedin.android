package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.Util;

public final class Track
{
  public static final int TYPE_AUDIO;
  public static final int TYPE_SUBTITLE = Util.getIntegerCodeForString("sbtl");
  public static final int TYPE_TEXT;
  public static final int TYPE_VIDEO = Util.getIntegerCodeForString("vide");
  public final long durationUs;
  public final int id;
  public final MediaFormat mediaFormat;
  public final int nalUnitLengthFieldLength;
  public final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
  public final long timescale;
  public final int type;
  
  static
  {
    TYPE_AUDIO = Util.getIntegerCodeForString("soun");
    TYPE_TEXT = Util.getIntegerCodeForString("text");
  }
  
  public Track(int paramInt1, int paramInt2, long paramLong1, long paramLong2, MediaFormat paramMediaFormat, TrackEncryptionBox[] paramArrayOfTrackEncryptionBox, int paramInt3)
  {
    id = paramInt1;
    type = paramInt2;
    timescale = paramLong1;
    durationUs = paramLong2;
    mediaFormat = paramMediaFormat;
    sampleDescriptionEncryptionBoxes = paramArrayOfTrackEncryptionBox;
    nalUnitLengthFieldLength = paramInt3;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Track
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */