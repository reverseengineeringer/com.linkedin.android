package com.google.android.exoplayer.metadata;

import java.io.IOException;

public abstract interface MetadataParser<T>
{
  public abstract boolean canParse(String paramString);
  
  public abstract T parse(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.metadata.MetadataParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */