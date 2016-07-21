package com.linkedin.android.imageloader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class LiImageHeaderParser$RandomAccessReader
{
  final ByteBuffer data;
  
  public LiImageHeaderParser$RandomAccessReader(byte[] paramArrayOfByte, int paramInt)
  {
    data = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
  }
  
  public final short getInt16(int paramInt)
  {
    return data.getShort(paramInt);
  }
  
  public final int getInt32(int paramInt)
  {
    return data.getInt(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageHeaderParser.RandomAccessReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */