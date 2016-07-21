package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class CodedOutputStream
  implements Flushable
{
  final byte[] buffer;
  final int limit;
  final OutputStream output;
  int position;
  
  private CodedOutputStream(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    output = paramOutputStream;
    buffer = paramArrayOfByte;
    position = 0;
    limit = 4096;
  }
  
  public static int computeBoolSize$2563259(int paramInt)
  {
    return computeTagSize(paramInt) + 1;
  }
  
  public static int computeBytesSize(int paramInt, ByteString paramByteString)
  {
    return computeTagSize(paramInt) + (computeRawVarint32Size(bytes.length) + bytes.length);
  }
  
  public static int computeEnumSize(int paramInt1, int paramInt2)
  {
    int i = computeTagSize(paramInt1);
    if (paramInt2 >= 0) {}
    for (paramInt1 = computeRawVarint32Size(paramInt2);; paramInt1 = 10) {
      return paramInt1 + i;
    }
  }
  
  public static int computeFloatSize$255e745()
  {
    return computeTagSize(1) + 4;
  }
  
  public static int computeRawVarint32Size(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int computeSInt32Size$255f288(int paramInt)
  {
    return computeTagSize(2) + computeRawVarint32Size(encodeZigZag32(paramInt));
  }
  
  public static int computeTagSize(int paramInt)
  {
    return computeRawVarint32Size(WireFormat.makeTag(paramInt, 0));
  }
  
  public static int computeUInt32Size(int paramInt1, int paramInt2)
  {
    return computeTagSize(paramInt1) + computeRawVarint32Size(paramInt2);
  }
  
  public static int computeUInt64Size(int paramInt, long paramLong)
  {
    int i = computeTagSize(paramInt);
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      paramInt = 1;
    }
    for (;;)
    {
      return paramInt + i;
      if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
        paramInt = 2;
      } else if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
        paramInt = 3;
      } else if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
        paramInt = 4;
      } else if ((0xFFFFFFF800000000 & paramLong) == 0L) {
        paramInt = 5;
      } else if ((0xFFFFFC0000000000 & paramLong) == 0L) {
        paramInt = 6;
      } else if ((0xFFFE000000000000 & paramLong) == 0L) {
        paramInt = 7;
      } else if ((0xFF00000000000000 & paramLong) == 0L) {
        paramInt = 8;
      } else if ((0x8000000000000000 & paramLong) == 0L) {
        paramInt = 9;
      } else {
        paramInt = 10;
      }
    }
  }
  
  private static int encodeZigZag32(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static CodedOutputStream newInstance(OutputStream paramOutputStream)
  {
    return new CodedOutputStream(paramOutputStream, new byte['က']);
  }
  
  private void writeRawByte(int paramInt)
    throws IOException
  {
    int i = (byte)paramInt;
    if (position == limit) {
      refreshBuffer();
    }
    byte[] arrayOfByte = buffer;
    paramInt = position;
    position = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  private void writeRawVarint64(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        writeRawByte((int)paramLong);
        return;
      }
      writeRawByte((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public final void flush()
    throws IOException
  {
    if (output != null) {
      refreshBuffer();
    }
  }
  
  final void refreshBuffer()
    throws IOException
  {
    if (output == null) {
      throw new OutOfSpaceException();
    }
    output.write(buffer, 0, position);
    position = 0;
  }
  
  public final void writeBool(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    writeTag(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    writeRawByte(paramInt);
  }
  
  public final void writeBytes(int paramInt, ByteString paramByteString)
    throws IOException
  {
    writeTag(paramInt, 2);
    writeRawVarint32(bytes.length);
    paramInt = bytes.length;
    if (limit - position >= paramInt)
    {
      paramByteString.copyTo(buffer, 0, position, paramInt);
      position = (paramInt + position);
      return;
    }
    int j = limit - position;
    paramByteString.copyTo(buffer, 0, position, j);
    int i = j + 0;
    paramInt -= j;
    position = limit;
    refreshBuffer();
    if (paramInt <= limit)
    {
      paramByteString.copyTo(buffer, i, 0, paramInt);
      position = paramInt;
      return;
    }
    paramByteString = new ByteArrayInputStream(bytes);
    if (i != paramByteString.skip(i)) {
      throw new IllegalStateException("Skip failed.");
    }
    do
    {
      output.write(buffer, 0, j);
      paramInt -= j;
      if (paramInt <= 0) {
        break;
      }
      i = Math.min(paramInt, limit);
      j = paramByteString.read(buffer, 0, i);
    } while (j == i);
    throw new IllegalStateException("Read failed.");
  }
  
  public final void writeEnum(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      writeRawVarint32(paramInt2);
      return;
    }
    writeRawVarint64(paramInt2);
  }
  
  public final void writeFloat$255e752(float paramFloat)
    throws IOException
  {
    writeTag(1, 5);
    int i = Float.floatToRawIntBits(paramFloat);
    writeRawByte(i & 0xFF);
    writeRawByte(i >> 8 & 0xFF);
    writeRawByte(i >> 16 & 0xFF);
    writeRawByte(i >> 24 & 0xFF);
  }
  
  public final void writeRawVarint32(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        writeRawByte(paramInt);
        return;
      }
      writeRawByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void writeSInt32$255f295(int paramInt)
    throws IOException
  {
    writeTag(2, 0);
    writeRawVarint32(encodeZigZag32(paramInt));
  }
  
  public final void writeTag(int paramInt1, int paramInt2)
    throws IOException
  {
    writeRawVarint32(WireFormat.makeTag(paramInt1, paramInt2));
  }
  
  public final void writeUInt32(int paramInt1, int paramInt2)
    throws IOException
  {
    writeTag(paramInt1, 0);
    writeRawVarint32(paramInt2);
  }
  
  public final void writeUInt64(int paramInt, long paramLong)
    throws IOException
  {
    writeTag(paramInt, 0);
    writeRawVarint64(paramLong);
  }
  
  static final class OutOfSpaceException
    extends IOException
  {
    OutOfSpaceException()
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CodedOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */