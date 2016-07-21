package com.google.android.exoplayer.metadata;

public final class GeobMetadata
{
  public final byte[] data;
  public final String description;
  public final String filename;
  public final String mimeType;
  
  public GeobMetadata(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    mimeType = paramString1;
    filename = paramString2;
    description = paramString3;
    data = paramArrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.metadata.GeobMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */