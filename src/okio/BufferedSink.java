package okio;

import java.io.IOException;

public abstract interface BufferedSink
  extends Sink
{
  public abstract Buffer buffer();
  
  public abstract BufferedSink emit()
    throws IOException;
  
  public abstract BufferedSink emitCompleteSegments()
    throws IOException;
  
  public abstract BufferedSink write(ByteString paramByteString)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long writeAll(Source paramSource)
    throws IOException;
  
  public abstract BufferedSink writeByte(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeDecimalLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeHexadecimalUnsignedLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeInt(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeIntLe(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeShort(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeUtf8(String paramString)
    throws IOException;
}

/* Location:
 * Qualified Name:     okio.BufferedSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */