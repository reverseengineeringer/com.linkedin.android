package com.google.android.exoplayer.metadata;

public final class PrivMetadata
{
  public final String owner;
  public final byte[] privateData;
  
  public PrivMetadata(String paramString, byte[] paramArrayOfByte)
  {
    owner = paramString;
    privateData = paramArrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.metadata.PrivMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */