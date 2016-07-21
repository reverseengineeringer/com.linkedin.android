package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder
{
  private static final byte[] HB = CharTypes.copyHexBytes();
  private static final char[] HC = ;
  protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal();
  protected ByteArrayBuilder _bytes;
  protected final char[] _qbuf = new char[6];
  
  public JsonStringEncoder()
  {
    _qbuf[0] = '\\';
    _qbuf[2] = '0';
    _qbuf[3] = '0';
  }
  
  private static void _illegal(int paramInt)
  {
    throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(paramInt));
  }
  
  public static JsonStringEncoder getInstance()
  {
    Object localObject1 = (SoftReference)_threadEncoder.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (JsonStringEncoder)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(localObject2));
      }
      return (JsonStringEncoder)localObject2;
    }
  }
  
  public final byte[] encodeAsUTF8(String paramString)
  {
    Object localObject1 = _bytes;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ByteArrayBuilder((byte)0);
      _bytes = ((ByteArrayBuilder)localObject2);
    }
    int i2 = paramString.length();
    int i = 0;
    ((ByteArrayBuilder)localObject2).reset();
    localObject1 = _currBlock;
    int k = localObject1.length;
    int j = 0;
    int n;
    int i1;
    if (j < i2)
    {
      int m = paramString.charAt(j);
      j += 1;
      while (m <= 127)
      {
        n = k;
        i1 = i;
        if (i >= k)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          n = localObject1.length;
          i1 = 0;
        }
        i = i1 + 1;
        localObject1[i1] = ((byte)m);
        if (j >= i2) {
          break label613;
        }
        m = paramString.charAt(j);
        j += 1;
        k = n;
      }
      if (i >= k)
      {
        localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        i = localObject1.length;
        k = 0;
        if (m < 2048)
        {
          i1 = k + 1;
          localObject1[k] = ((byte)(m >> 6 | 0xC0));
          n = j;
          k = i1;
          j = i;
          i = n;
          n = m;
        }
        for (;;)
        {
          label212:
          m = j;
          i1 = k;
          if (k >= j)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            m = localObject1.length;
            i1 = 0;
          }
          localObject1[i1] = ((byte)(n & 0x3F | 0x80));
          n = i1 + 1;
          j = i;
          k = m;
          i = n;
          break;
          if ((m >= 55296) && (m <= 57343)) {
            break label376;
          }
          i1 = k + 1;
          localObject1[k] = ((byte)(m >> 12 | 0xE0));
          k = i;
          n = i1;
          if (i1 >= i)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            k = localObject1.length;
            n = 0;
          }
          localObject1[n] = ((byte)(m >> 6 & 0x3F | 0x80));
          i1 = n + 1;
          i = j;
          n = m;
          j = k;
          k = i1;
        }
        label376:
        if (m > 56319) {
          _illegal(m);
        }
        if (j >= i2) {
          _illegal(m);
        }
        i1 = j + 1;
        j = paramString.charAt(j);
        if ((j < 56320) || (j > 57343)) {
          throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(m) + ", second 0x" + Integer.toHexString(j) + "; illegal combination");
        }
        n = 65536 + (m - 55296 << 10) + (j - 56320);
        if (n > 1114111) {
          _illegal(n);
        }
        m = k + 1;
        localObject1[k] = ((byte)(n >> 18 | 0xF0));
        j = i;
        k = m;
        if (m >= i)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          j = localObject1.length;
          k = 0;
        }
        i = k + 1;
        localObject1[k] = ((byte)(n >> 12 & 0x3F | 0x80));
        if (i < j) {
          break label644;
        }
        localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        j = localObject1.length;
        i = 0;
      }
    }
    label613:
    label644:
    for (;;)
    {
      localObject1[i] = ((byte)(n >> 6 & 0x3F | 0x80));
      k = i + 1;
      i = i1;
      break label212;
      for (;;)
      {
        paramString = _bytes;
        _currBlockPtr = i;
        return paramString.toByteArray();
        n = i;
        i = k;
        k = n;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.JsonStringEncoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */