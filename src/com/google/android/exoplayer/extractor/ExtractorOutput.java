package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.drm.DrmInitData;

public abstract interface ExtractorOutput
{
  public abstract void drmInitData(DrmInitData paramDrmInitData);
  
  public abstract void endTracks();
  
  public abstract void seekMap(SeekMap paramSeekMap);
  
  public abstract TrackOutput track(int paramInt);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */