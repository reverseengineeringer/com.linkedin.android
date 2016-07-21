package com.google.android.exoplayer.text.eia608;

final class ClosedCaptionCtrl
  extends ClosedCaption
{
  public final byte cc1;
  public final byte cc2;
  
  protected ClosedCaptionCtrl(byte paramByte1, byte paramByte2)
  {
    super(0);
    cc1 = paramByte1;
    cc2 = paramByte2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.eia608.ClosedCaptionCtrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */