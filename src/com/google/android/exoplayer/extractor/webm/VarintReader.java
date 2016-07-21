package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader
{
  private static final int[] VARINT_LENGTH_MASKS = { 128, 64, 32, 16, 8, 4, 2, 1 };
  int length;
  private final byte[] scratch = new byte[8];
  private int state;
  
  public final long readUnsignedVarint(ExtractorInput paramExtractorInput, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, InterruptedException
  {
    if (state == 0)
    {
      if (!paramExtractorInput.readFully(scratch, 0, 1, paramBoolean1)) {
        return -1L;
      }
      int j = scratch[0];
      length = -1;
      i = 0;
      for (;;)
      {
        if (i < VARINT_LENGTH_MASKS.length)
        {
          if ((VARINT_LENGTH_MASKS[i] & j & 0xFF) != 0) {
            length = (i + 1);
          }
        }
        else
        {
          if (length != -1) {
            break;
          }
          throw new IllegalStateException("No valid varint length mask found");
        }
        i += 1;
      }
      state = 1;
    }
    paramExtractorInput.readFully(scratch, 1, length - 1);
    if (paramBoolean2)
    {
      paramExtractorInput = scratch;
      paramExtractorInput[0] = ((byte)(paramExtractorInput[0] & (VARINT_LENGTH_MASKS[(length - 1)] ^ 0xFFFFFFFF)));
    }
    long l = 0L;
    int i = 0;
    while (i < length)
    {
      l = l << 8 | scratch[i] & 0xFF;
      i += 1;
    }
    state = 0;
    return l;
  }
  
  public final void reset()
  {
    state = 0;
    length = 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.VarintReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */