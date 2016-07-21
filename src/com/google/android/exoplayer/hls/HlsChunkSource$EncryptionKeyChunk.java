package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.io.IOException;
import java.util.Arrays;

final class HlsChunkSource$EncryptionKeyChunk
  extends DataChunk
{
  public final String iv;
  byte[] result;
  public final int variantIndex;
  
  public HlsChunkSource$EncryptionKeyChunk(DataSource paramDataSource, DataSpec paramDataSpec, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    super(paramDataSource, paramDataSpec, 3, paramArrayOfByte);
    iv = paramString;
    variantIndex = paramInt;
  }
  
  protected final void consume(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    result = Arrays.copyOf(paramArrayOfByte, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsChunkSource.EncryptionKeyChunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */