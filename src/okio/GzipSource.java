package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource
  implements Source
{
  private final CRC32 crc = new CRC32();
  private final Inflater inflater;
  private final InflaterSource inflaterSource;
  private int section = 0;
  private final BufferedSource source;
  
  public GzipSource(Source paramSource)
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    inflater = new Inflater(true);
    source = Okio.buffer(paramSource);
    inflaterSource = new InflaterSource(source, inflater);
  }
  
  private static void checkEqual(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 != paramInt1) {
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
  }
  
  private void updateCrc(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Object localObject;
    long l1;
    long l2;
    for (paramBuffer = head;; paramBuffer = next)
    {
      localObject = paramBuffer;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < limit - pos) {
        break;
      }
      paramLong1 -= limit - pos;
    }
    while (l2 > 0L)
    {
      int i = (int)(pos + l1);
      int j = (int)Math.min(limit - i, l2);
      crc.update(data, i, j);
      l2 -= j;
      l1 = 0L;
      localObject = next;
    }
  }
  
  public final void close()
    throws IOException
  {
    inflaterSource.close();
  }
  
  public final long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    long l;
    if (section == 0)
    {
      source.require(10L);
      int j = source.buffer().getByte(3L);
      if ((j >> 1 & 0x1) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          updateCrc(source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, source.readShort());
        source.skip(8L);
        if ((j >> 2 & 0x1) == 1)
        {
          source.require(2L);
          if (i != 0) {
            updateCrc(source.buffer(), 0L, 2L);
          }
          int k = source.buffer().readShortLe();
          source.require(k);
          if (i != 0) {
            updateCrc(source.buffer(), 0L, k);
          }
          source.skip(k);
        }
        if ((j >> 3 & 0x1) != 1) {
          break label323;
        }
        l = source.indexOf((byte)0);
        if (l != -1L) {
          break;
        }
        throw new EOFException();
      }
      if (i != 0) {
        updateCrc(source.buffer(), 0L, l + 1L);
      }
      source.skip(l + 1L);
      label323:
      if ((j >> 4 & 0x1) == 1)
      {
        l = source.indexOf((byte)0);
        if (l == -1L) {
          throw new EOFException();
        }
        if (i != 0) {
          updateCrc(source.buffer(), 0L, l + 1L);
        }
        source.skip(l + 1L);
      }
      if (i != 0)
      {
        checkEqual("FHCRC", source.readShortLe(), (short)(int)crc.getValue());
        crc.reset();
      }
      section = 1;
    }
    if (section == 1)
    {
      l = size;
      paramLong = inflaterSource.read(paramBuffer, paramLong);
      if (paramLong != -1L)
      {
        updateCrc(paramBuffer, l, paramLong);
        return paramLong;
      }
      section = 2;
    }
    if (section == 2)
    {
      checkEqual("CRC", source.readIntLe(), (int)crc.getValue());
      checkEqual("ISIZE", source.readIntLe(), inflater.getTotalOut());
      section = 3;
      if (!source.exhausted()) {
        throw new IOException("gzip finished without exhausting source");
      }
    }
    return -1L;
  }
  
  public final Timeout timeout()
  {
    return source.timeout();
  }
}

/* Location:
 * Qualified Name:     okio.GzipSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */