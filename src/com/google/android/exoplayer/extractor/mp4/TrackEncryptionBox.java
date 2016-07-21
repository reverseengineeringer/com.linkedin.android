package com.google.android.exoplayer.extractor.mp4;

public final class TrackEncryptionBox
{
  public final int initializationVectorSize;
  public final boolean isEncrypted;
  public final byte[] keyId;
  
  public TrackEncryptionBox(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    isEncrypted = paramBoolean;
    initializationVectorSize = paramInt;
    keyId = paramArrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.TrackEncryptionBox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */