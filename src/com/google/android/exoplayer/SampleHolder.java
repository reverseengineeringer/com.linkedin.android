package com.google.android.exoplayer;

import java.nio.ByteBuffer;

public final class SampleHolder
{
  public final int bufferReplacementMode;
  public final CryptoInfo cryptoInfo = new CryptoInfo();
  public ByteBuffer data;
  public int flags;
  public int size;
  public long timeUs;
  
  public SampleHolder(int paramInt)
  {
    bufferReplacementMode = paramInt;
  }
  
  public final void clearData()
  {
    if (data != null) {
      data.clear();
    }
  }
  
  public final boolean isDecodeOnly()
  {
    return (flags & 0x8000000) != 0;
  }
  
  public final boolean isEncrypted()
  {
    return (flags & 0x2) != 0;
  }
  
  public final boolean isSyncFrame()
  {
    return (flags & 0x1) != 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.SampleHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */