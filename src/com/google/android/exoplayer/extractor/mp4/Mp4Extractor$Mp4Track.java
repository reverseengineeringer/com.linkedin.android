package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.TrackOutput;

final class Mp4Extractor$Mp4Track
{
  public int sampleIndex;
  public final TrackSampleTable sampleTable;
  public final Track track;
  public final TrackOutput trackOutput;
  
  public Mp4Extractor$Mp4Track(Track paramTrack, TrackSampleTable paramTrackSampleTable, TrackOutput paramTrackOutput)
  {
    track = paramTrack;
    sampleTable = paramTrackSampleTable;
    trackOutput = paramTrackOutput;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Mp4Extractor.Mp4Track
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */