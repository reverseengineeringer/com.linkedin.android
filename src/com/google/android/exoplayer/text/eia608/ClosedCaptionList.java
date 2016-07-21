package com.google.android.exoplayer.text.eia608;

final class ClosedCaptionList
  implements Comparable<ClosedCaptionList>
{
  public final ClosedCaption[] captions;
  public final boolean decodeOnly;
  public final long timeUs;
  
  public ClosedCaptionList(long paramLong, boolean paramBoolean, ClosedCaption[] paramArrayOfClosedCaption)
  {
    timeUs = paramLong;
    decodeOnly = paramBoolean;
    captions = paramArrayOfClosedCaption;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.eia608.ClosedCaptionList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */