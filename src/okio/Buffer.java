package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Buffer
  implements Cloneable, BufferedSink, BufferedSource
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  Segment head;
  public long size;
  
  private Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (size == 0L) {
      return localBuffer;
    }
    head = new Segment(head);
    Segment localSegment1 = head;
    Segment localSegment2 = head;
    Segment localSegment3 = head;
    prev = localSegment3;
    next = localSegment3;
    for (localSegment1 = head.next; localSegment1 != head; localSegment1 = next) {
      head.prev.push(new Segment(localSegment1));
    }
    size = size;
    return localBuffer;
  }
  
  private void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  private String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Util.checkOffsetAndCount(size, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    Segment localSegment;
    String str;
    do
    {
      return paramCharset;
      localSegment = head;
      if (pos + paramLong > limit) {
        return new String(readByteArray(paramLong), paramCharset);
      }
      str = new String(data, pos, (int)paramLong, paramCharset);
      pos = ((int)(pos + paramLong));
      size -= paramLong;
      paramCharset = str;
    } while (pos != limit);
    head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return str;
  }
  
  private String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public final Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
  {
    try
    {
      skip(size);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final void close() {}
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("out == null");
    }
    Util.checkOffsetAndCount(size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    size += paramLong2;
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = head;; localSegment1 = next)
    {
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < limit - pos) {
        break;
      }
      paramLong1 -= limit - pos;
    }
    label103:
    if (l2 > 0L)
    {
      localSegment1 = new Segment(localSegment2);
      pos = ((int)(pos + l1));
      limit = Math.min(pos + (int)l2, limit);
      if (head != null) {
        break label215;
      }
      prev = localSegment1;
      next = localSegment1;
      head = localSegment1;
    }
    for (;;)
    {
      l2 -= limit - pos;
      l1 = 0L;
      localSegment2 = next;
      break label103;
      break;
      label215:
      head.prev.push(localSegment1);
    }
  }
  
  public final BufferedSink emit()
  {
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    paramObject = (Buffer)paramObject;
    if (size != size) {
      return false;
    }
    if (size == 0L) {
      return true;
    }
    Segment localSegment = head;
    paramObject = head;
    int i = pos;
    int j = pos;
    long l1 = 0L;
    long l2;
    int k;
    if (l1 < size)
    {
      l2 = Math.min(limit - i, limit - j);
      int m = 0;
      k = i;
      i = j;
      j = k;
      k = m;
      while (k < l2)
      {
        if (data[j] != data[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      if (j != limit) {
        break label223;
      }
      localSegment = next;
      j = pos;
    }
    label223:
    for (;;)
    {
      if (i == limit) {
        paramObject = next;
      }
      for (k = pos;; k = i)
      {
        l1 += l2;
        i = j;
        j = k;
        break;
        return true;
      }
    }
  }
  
  public final boolean exhausted()
  {
    return size == 0L;
  }
  
  public final void flush() {}
  
  public final byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(size, paramLong, 1L);
    for (Segment localSegment = head;; localSegment = next)
    {
      int i = limit - pos;
      if (paramLong < i) {
        return data[(pos + (int)paramLong)];
      }
      paramLong -= i;
    }
  }
  
  public final int hashCode()
  {
    Object localObject = head;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    Segment localSegment;
    do
    {
      int k = pos;
      int m = limit;
      i = j;
      j = k;
      while (j < m)
      {
        i = i * 31 + data[j];
        j += 1;
      }
      localSegment = next;
      j = i;
      localObject = localSegment;
    } while (localSegment != head);
    return i;
  }
  
  public final long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }
  
  public final long indexOf(byte paramByte, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("fromIndex < 0");
    }
    Object localObject1 = head;
    if (localObject1 == null) {
      return -1L;
    }
    long l = 0L;
    int j = limit - pos;
    if (paramLong >= j) {}
    for (paramLong -= j;; paramLong = 0L)
    {
      l += j;
      Object localObject2 = next;
      localObject1 = localObject2;
      if (localObject2 != head) {
        break;
      }
      return -1L;
      localObject2 = data;
      int i = (int)(pos + paramLong);
      int k = limit;
      while (i < k)
      {
        if (localObject2[i] == paramByte) {
          return i + l - pos;
        }
        i += 1;
      }
    }
  }
  
  public final InputStream inputStream()
  {
    return new Buffer.2(this);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = head;
    if (localSegment == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, limit - pos);
      System.arraycopy(data, pos, paramArrayOfByte, paramInt1, paramInt2);
      pos += paramInt2;
      size -= paramInt2;
      paramInt1 = paramInt2;
    } while (pos != limit);
    head = localSegment.pop();
    SegmentPool.recycle(localSegment);
    return paramInt2;
  }
  
  public final long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (size == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > size) {
      l = size;
    }
    paramBuffer.write(this, l);
    return l;
  }
  
  public final byte readByte()
  {
    if (size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    Segment localSegment = head;
    int i = pos;
    int j = limit;
    byte[] arrayOfByte = data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    size -= 1L;
    if (k == j)
    {
      head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return b;
    }
    pos = k;
    return b;
  }
  
  public final byte[] readByteArray()
  {
    try
    {
      byte[] arrayOfByte = readByteArray(size);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final byte[] readByteArray(long paramLong)
    throws EOFException
  {
    Util.checkOffsetAndCount(size, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  public final ByteString readByteString()
  {
    return new ByteString(readByteArray());
  }
  
  public final ByteString readByteString(long paramLong)
    throws EOFException
  {
    return new ByteString(readByteArray(paramLong));
  }
  
  public final long readDecimalLong()
  {
    if (size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int m = 0;
    int n = 0;
    int i = 0;
    long l3 = -7L;
    Object localObject = head;
    byte[] arrayOfByte = data;
    int k = pos;
    int i1 = limit;
    long l1 = l2;
    int j = m;
    l2 = l3;
    m = k;
    k = n;
    n = i;
    if (m < i1)
    {
      n = arrayOfByte[m];
      if ((n >= 48) && (n <= 57))
      {
        int i2 = 48 - n;
        if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (i2 < l2)))
        {
          localObject = new Buffer().writeDecimalLong(l1).writeByte(n);
          if (k == 0) {
            ((Buffer)localObject).readByte();
          }
          throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        }
        l1 = 10L * l1 + i2;
      }
      for (;;)
      {
        m += 1;
        j += 1;
        break;
        if ((n != 45) || (j != 0)) {
          break label247;
        }
        k = 1;
        l2 -= 1L;
      }
      label247:
      if (j == 0) {
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(n));
      }
      n = 1;
    }
    if (m == i1)
    {
      head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (n == 0)
      {
        i = n;
        n = k;
        l3 = l2;
        m = j;
        l2 = l1;
        if (head != null) {
          break;
        }
      }
      size -= j;
      if (k == 0) {
        break label361;
      }
      return l1;
      pos = m;
    }
    label361:
    return -l1;
  }
  
  public final long readHexadecimalUnsignedLong()
  {
    if (size == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l1 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = head;
    byte[] arrayOfByte = data;
    int m = pos;
    int n = limit;
    long l2 = l1;
    int k = i;
    label59:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0xF000000000000000 & l2) == 0L) {
          break label294;
        }
        localObject = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i1);
        throw new NumberFormatException("Number too large: " + ((Buffer)localObject).readUtf8());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      head = ((Segment)localObject).pop();
      SegmentPool.recycle((Segment)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l1 = l2;
        if (head != null) {
          break;
        }
      }
      size -= k;
      return l2;
      label294:
      l2 = l2 << 4 | i;
      m += 1;
      k += 1;
      break label59;
      pos = m;
    }
  }
  
  public final int readInt()
  {
    if (size < 4L) {
      throw new IllegalStateException("size < 4: " + size);
    }
    Segment localSegment = head;
    int j = pos;
    int i = limit;
    if (i - j < 4) {
      return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
    }
    byte[] arrayOfByte = data;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    size -= 4L;
    if (n == i)
    {
      head = localSegment.pop();
      SegmentPool.recycle(localSegment);
      return j;
    }
    pos = n;
    return j;
  }
  
  public final int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }
  
  public final short readShort()
  {
    if (size < 2L) {
      throw new IllegalStateException("size < 2: " + size);
    }
    Segment localSegment = head;
    int k = pos;
    int i = limit;
    if (i - k < 2) {
      return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
    }
    byte[] arrayOfByte = data;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    size -= 2L;
    if (m == i)
    {
      head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      pos = m;
    }
  }
  
  public final short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }
  
  public final String readUtf8()
  {
    try
    {
      String str = readString(size, Util.UTF_8);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  final String readUtf8Line(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      str = readUtf8(paramLong - 1L);
      skip(2L);
      return str;
    }
    String str = readUtf8(paramLong);
    skip(1L);
    return str;
  }
  
  public final String readUtf8LineStrict()
    throws EOFException
  {
    long l = indexOf((byte)10, 0L);
    if (l == -1L)
    {
      Buffer localBuffer = new Buffer();
      copyTo(localBuffer, 0L, Math.min(32L, size));
      throw new EOFException("\\n not found: size=" + size + " content=" + localBuffer.readByteString().hex() + "...");
    }
    return readUtf8Line(l);
  }
  
  public final void require(long paramLong)
    throws EOFException
  {
    if (size < paramLong) {
      throw new EOFException();
    }
  }
  
  public final void skip(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      if (head == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, head.limit - head.pos);
      size -= i;
      long l = paramLong - i;
      Segment localSegment = head;
      pos += i;
      paramLong = l;
      if (head.pos == head.limit)
      {
        localSegment = head;
        head = localSegment.pop();
        SegmentPool.recycle(localSegment);
        paramLong = l;
      }
    }
  }
  
  public final Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public final String toString()
  {
    if (size == 0L) {
      return "Buffer[size=0]";
    }
    Object localObject;
    if (size <= 16L)
    {
      localObject = clone().readByteString();
      return String.format("Buffer[size=%s data=%s]", new Object[] { Long.valueOf(size), ((ByteString)localObject).hex() });
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(head.data, head.pos, head.limit - head.pos);
      for (localObject = head.next; localObject != head; localObject = next) {
        localMessageDigest.update(data, pos, limit - pos);
      }
      localObject = String.format("Buffer[size=%s md5=%s]", new Object[] { Long.valueOf(size), ByteString.of(localMessageDigest.digest()).hex() });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
  }
  
  final Segment writableSegment(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 2048)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2;
    Segment localSegment1;
    if (head == null)
    {
      head = SegmentPool.take();
      localSegment2 = head;
      Segment localSegment3 = head;
      localSegment1 = head;
      prev = localSegment1;
      next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment2 = head.prev;
      if (limit + paramInt > 2048) {
        break;
      }
      localSegment1 = localSegment2;
    } while (owner);
    return localSegment2.push(SegmentPool.take());
  }
  
  public final Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.write(this);
    return this;
  }
  
  public final Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 2048 - limit);
      System.arraycopy(paramArrayOfByte, paramInt1, data, limit, j);
      paramInt1 += j;
      limit += j;
    }
    size += paramInt2;
    return this;
  }
  
  public final void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramBuffer == this) {
      throw new IllegalArgumentException("source == this");
    }
    Util.checkOffsetAndCount(size, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= head.limit - head.pos) {
        break label271;
      }
      if (head == null) {
        break label162;
      }
      localSegment1 = head.prev;
      if ((localSegment1 == null) || (!owner)) {
        break label178;
      }
      l = limit;
      if (!shared) {
        break label168;
      }
    }
    label162:
    label168:
    for (int i = 0;; i = pos)
    {
      if (paramLong + l - i > 2048L) {
        break label178;
      }
      head.writeTo(localSegment1, (int)paramLong);
      size -= paramLong;
      size += paramLong;
      return;
      localSegment1 = null;
      break;
    }
    label178:
    Segment localSegment1 = head;
    i = (int)paramLong;
    if ((i <= 0) || (i > limit - pos)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment2 = new Segment(localSegment1);
    limit = (pos + i);
    pos = (i + pos);
    prev.push(localSegment2);
    head = localSegment2;
    label271:
    localSegment1 = head;
    long l = limit - pos;
    head = localSegment1.pop();
    if (head == null)
    {
      head = localSegment1;
      localSegment1 = head;
      localSegment2 = head;
      Segment localSegment3 = head;
      prev = localSegment3;
      next = localSegment3;
    }
    label506:
    for (;;)
    {
      size -= l;
      size += l;
      paramLong -= l;
      break;
      localSegment1 = head.prev.push(localSegment1);
      if (prev == localSegment1) {
        throw new IllegalStateException();
      }
      if (prev.owner)
      {
        int j = limit - pos;
        int k = prev.limit;
        if (prev.shared) {}
        for (i = 0;; i = prev.pos)
        {
          if (j > i + (2048 - k)) {
            break label506;
          }
          localSegment1.writeTo(prev, j);
          localSegment1.pop();
          SegmentPool.recycle(localSegment1);
          break;
        }
      }
    }
  }
  
  public final long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 2048L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public final Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = data;
    int i = limit;
    limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    size += 1L;
    return this;
  }
  
  public final Buffer writeDecimalLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = 0;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    int i;
    if (l < 100000000L) {
      if (l < 10000L) {
        if (l < 100L) {
          if (l < 10L) {
            i = 1;
          }
        }
      }
    }
    int k;
    Segment localSegment;
    byte[] arrayOfByte;
    for (;;)
    {
      k = i;
      if (j != 0) {
        k = i + 1;
      }
      localSegment = writableSegment(k);
      arrayOfByte = data;
      i = limit + k;
      while (l != 0L)
      {
        int m = (int)(l % 10L);
        i -= 1;
        arrayOfByte[i] = DIGITS[m];
        l /= 10L;
      }
      i = 2;
      continue;
      if (l < 1000L)
      {
        i = 3;
      }
      else
      {
        i = 4;
        continue;
        if (l < 1000000L)
        {
          if (l < 100000L) {
            i = 5;
          } else {
            i = 6;
          }
        }
        else if (l < 10000000L)
        {
          i = 7;
        }
        else
        {
          i = 8;
          continue;
          if (l < 1000000000000L)
          {
            if (l < 10000000000L)
            {
              if (l < 1000000000L) {
                i = 9;
              } else {
                i = 10;
              }
            }
            else if (l < 100000000000L) {
              i = 11;
            } else {
              i = 12;
            }
          }
          else if (l < 1000000000000000L)
          {
            if (l < 10000000000000L) {
              i = 13;
            } else if (l < 100000000000000L) {
              i = 14;
            } else {
              i = 15;
            }
          }
          else if (l < 100000000000000000L)
          {
            if (l < 10000000000000000L) {
              i = 16;
            } else {
              i = 17;
            }
          }
          else if (l < 1000000000000000000L) {
            i = 18;
          } else {
            i = 19;
          }
        }
      }
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = 45;
    }
    limit += k;
    size += k;
    return this;
  }
  
  public final Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    Segment localSegment = writableSegment(j);
    byte[] arrayOfByte = data;
    int i = limit + j - 1;
    int k = limit;
    while (i >= k)
    {
      arrayOfByte[i] = DIGITS[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    limit += j;
    size += j;
    return this;
  }
  
  public final Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = data;
    int j = limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    limit = (i + 1);
    size += 4L;
    return this;
  }
  
  public final Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public final Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = data;
    int i = limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    limit = (j + 1);
    size += 2L;
    return this;
  }
  
  public final Buffer writeUtf8(String paramString)
  {
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public final Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    while (paramInt1 < paramInt2)
    {
      int k = paramString.charAt(paramInt1);
      int i;
      if (k < 128)
      {
        Segment localSegment = writableSegment(1);
        byte[] arrayOfByte = data;
        i = limit - paramInt1;
        int j = Math.min(paramInt2, 2048 - i);
        arrayOfByte[(i + paramInt1)] = ((byte)k);
        paramInt1 += 1;
        while (paramInt1 < j)
        {
          k = paramString.charAt(paramInt1);
          if (k >= 128) {
            break;
          }
          arrayOfByte[(i + paramInt1)] = ((byte)k);
          paramInt1 += 1;
        }
        i = paramInt1 + i - limit;
        limit += i;
        size += i;
      }
      else if (k < 2048)
      {
        writeByte(k >> 6 | 0xC0);
        writeByte(k & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((k < 55296) || (k > 57343))
      {
        writeByte(k >> 12 | 0xE0);
        writeByte(k >> 6 & 0x3F | 0x80);
        writeByte(k & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 < paramInt2) {}
        for (i = paramString.charAt(paramInt1 + 1);; i = 0)
        {
          if ((k <= 56319) && (i >= 56320) && (i <= 57343)) {
            break label448;
          }
          writeByte(63);
          paramInt1 += 1;
          break;
        }
        label448:
        i = 65536 + ((0xFFFF27FF & k) << 10 | 0xFFFF23FF & i);
        writeByte(i >> 18 | 0xF0);
        writeByte(i >> 12 & 0x3F | 0x80);
        writeByte(i >> 6 & 0x3F | 0x80);
        writeByte(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public final Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      writeByte(paramInt >> 6 | 0xC0);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343)) {
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
      }
      writeByte(paramInt >> 12 | 0xE0);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      writeByte(paramInt >> 18 | 0xF0);
      writeByte(paramInt >> 12 & 0x3F | 0x80);
      writeByte(paramInt >> 6 & 0x3F | 0x80);
      writeByte(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
}

/* Location:
 * Qualified Name:     okio.Buffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */