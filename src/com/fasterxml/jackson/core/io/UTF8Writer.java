package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer
  extends Writer
{
  private final IOContext _context;
  private OutputStream _out;
  private byte[] _outBuffer;
  private final int _outBufferEnd;
  private int _outPtr;
  private int _surrogate = 0;
  
  public UTF8Writer(IOContext paramIOContext, OutputStream paramOutputStream)
  {
    _context = paramIOContext;
    _out = paramOutputStream;
    _outBuffer = paramIOContext.allocWriteEncodingBuffer();
    _outBufferEnd = (_outBuffer.length - 4);
    _outPtr = 0;
  }
  
  private int convertSurrogate(int paramInt)
    throws IOException
  {
    int i = _surrogate;
    _surrogate = 0;
    if ((paramInt < 56320) || (paramInt > 57343)) {
      throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(paramInt) + "; illegal combination");
    }
    return 65536 + (i - 55296 << 10) + (paramInt - 56320);
  }
  
  private static void illegalSurrogate(int paramInt)
    throws IOException
  {
    throw new IOException(illegalSurrogateDesc(paramInt));
  }
  
  protected static String illegalSurrogateDesc(int paramInt)
  {
    if (paramInt > 1114111) {
      return "Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627";
    }
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319) {
        return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")";
      }
      return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")";
    }
    return "Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output";
  }
  
  public final Writer append(char paramChar)
    throws IOException
  {
    write(paramChar);
    return this;
  }
  
  public final void close()
    throws IOException
  {
    if (_out != null)
    {
      if (_outPtr > 0)
      {
        _out.write(_outBuffer, 0, _outPtr);
        _outPtr = 0;
      }
      OutputStream localOutputStream = _out;
      _out = null;
      byte[] arrayOfByte = _outBuffer;
      if (arrayOfByte != null)
      {
        _outBuffer = null;
        _context.releaseWriteEncodingBuffer(arrayOfByte);
      }
      localOutputStream.close();
      int i = _surrogate;
      _surrogate = 0;
      if (i > 0) {
        illegalSurrogate(i);
      }
    }
  }
  
  public final void flush()
    throws IOException
  {
    if (_out != null)
    {
      if (_outPtr > 0)
      {
        _out.write(_outBuffer, 0, _outPtr);
        _outPtr = 0;
      }
      _out.flush();
    }
  }
  
  public final void write(int paramInt)
    throws IOException
  {
    int i;
    if (_surrogate > 0) {
      i = convertSurrogate(paramInt);
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        if (_outPtr >= _outBufferEnd)
        {
          _out.write(_outBuffer, 0, _outPtr);
          _outPtr = 0;
        }
        if (i >= 128) {
          break;
        }
        arrayOfByte = _outBuffer;
        paramInt = _outPtr;
        _outPtr = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)i);
        return;
        i = paramInt;
      } while (paramInt < 55296);
      i = paramInt;
    } while (paramInt > 57343);
    if (paramInt > 56319) {
      illegalSurrogate(paramInt);
    }
    _surrogate = paramInt;
    return;
    paramInt = _outPtr;
    int j;
    if (i < 2048)
    {
      arrayOfByte = _outBuffer;
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i >> 6 | 0xC0));
      arrayOfByte = _outBuffer;
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
    }
    for (;;)
    {
      _outPtr = paramInt;
      return;
      if (i <= 65535)
      {
        arrayOfByte = _outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(i >> 12 | 0xE0));
        arrayOfByte = _outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(i >> 6 & 0x3F | 0x80));
        _outBuffer[paramInt] = ((byte)(i & 0x3F | 0x80));
        paramInt += 1;
      }
      else
      {
        if (i > 1114111) {
          illegalSurrogate(i);
        }
        arrayOfByte = _outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(i >> 18 | 0xF0));
        arrayOfByte = _outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(i >> 12 & 0x3F | 0x80));
        arrayOfByte = _outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(i >> 6 & 0x3F | 0x80));
        arrayOfByte = _outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
      }
    }
  }
  
  public final void write(String paramString)
    throws IOException
  {
    write(paramString, 0, paramString.length());
  }
  
  public final void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramString.charAt(paramInt1));
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (_surrogate > 0)
    {
      i = paramString.charAt(paramInt1);
      j = paramInt2 - 1;
      write(convertSurrogate(i));
      i = paramInt1 + 1;
    }
    paramInt1 = _outPtr;
    byte[] arrayOfByte = _outBuffer;
    int n = _outBufferEnd;
    int i1 = j + i;
    paramInt2 = i;
    int k;
    for (;;)
    {
      if (paramInt2 >= i1) {
        break label530;
      }
      i = paramInt1;
      if (paramInt1 >= n)
      {
        _out.write(arrayOfByte, 0, paramInt1);
        i = 0;
      }
      j = paramInt2 + 1;
      k = paramString.charAt(paramInt2);
      if (k >= 128) {
        break label517;
      }
      paramInt1 = i + 1;
      arrayOfByte[i] = ((byte)k);
      paramInt2 = i1 - j;
      k = n - paramInt1;
      i = paramInt2;
      if (paramInt2 > k) {
        i = k;
      }
      int m;
      for (paramInt2 = j;; paramInt2 = k)
      {
        if (paramInt2 >= i + j) {
          break label514;
        }
        k = paramInt2 + 1;
        m = paramString.charAt(paramInt2);
        if (m >= 128) {
          break;
        }
        arrayOfByte[paramInt1] = ((byte)m);
        paramInt1 += 1;
      }
      paramInt2 = k;
      i = m;
      label230:
      if (i < 2048)
      {
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
        arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        paramInt1 = j + 1;
      }
      else if ((i < 55296) || (i > 57343))
      {
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 12 | 0xE0));
        k = j + 1;
        arrayOfByte[j] = ((byte)(i >> 6 & 0x3F | 0x80));
        paramInt1 = k + 1;
        arrayOfByte[k] = ((byte)(i & 0x3F | 0x80));
      }
      else
      {
        if (i > 56319)
        {
          _outPtr = paramInt1;
          illegalSurrogate(i);
        }
        _surrogate = i;
        if (paramInt2 >= i1) {
          break;
        }
        i = convertSurrogate(paramString.charAt(paramInt2));
        if (i > 1114111)
        {
          _outPtr = paramInt1;
          illegalSurrogate(i);
        }
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 18 | 0xF0));
        paramInt1 = j + 1;
        arrayOfByte[j] = ((byte)(i >> 12 & 0x3F | 0x80));
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 6 & 0x3F | 0x80));
        arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        paramInt1 = j + 1;
        paramInt2 += 1;
      }
    }
    label514:
    label517:
    label530:
    for (;;)
    {
      _outPtr = paramInt1;
      return;
      break;
      paramInt1 = i;
      paramInt2 = j;
      i = k;
      break label230;
    }
  }
  
  public final void write(char[] paramArrayOfChar)
    throws IOException
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramArrayOfChar[paramInt1]);
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (_surrogate > 0)
    {
      i = paramArrayOfChar[paramInt1];
      j = paramInt2 - 1;
      write(convertSurrogate(i));
      i = paramInt1 + 1;
    }
    paramInt1 = _outPtr;
    byte[] arrayOfByte = _outBuffer;
    int n = _outBufferEnd;
    int i1 = j + i;
    paramInt2 = i;
    int k;
    for (;;)
    {
      if (paramInt2 >= i1) {
        break label520;
      }
      i = paramInt1;
      if (paramInt1 >= n)
      {
        _out.write(arrayOfByte, 0, paramInt1);
        i = 0;
      }
      j = paramInt2 + 1;
      k = paramArrayOfChar[paramInt2];
      if (k >= 128) {
        break label507;
      }
      paramInt1 = i + 1;
      arrayOfByte[i] = ((byte)k);
      paramInt2 = i1 - j;
      k = n - paramInt1;
      i = paramInt2;
      if (paramInt2 > k) {
        i = k;
      }
      int m;
      for (paramInt2 = j;; paramInt2 = k)
      {
        if (paramInt2 >= i + j) {
          break label504;
        }
        k = paramInt2 + 1;
        m = paramArrayOfChar[paramInt2];
        if (m >= 128) {
          break;
        }
        arrayOfByte[paramInt1] = ((byte)m);
        paramInt1 += 1;
      }
      paramInt2 = k;
      i = m;
      label222:
      if (i < 2048)
      {
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 6 | 0xC0));
        arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        paramInt1 = j + 1;
      }
      else if ((i < 55296) || (i > 57343))
      {
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 12 | 0xE0));
        k = j + 1;
        arrayOfByte[j] = ((byte)(i >> 6 & 0x3F | 0x80));
        paramInt1 = k + 1;
        arrayOfByte[k] = ((byte)(i & 0x3F | 0x80));
      }
      else
      {
        if (i > 56319)
        {
          _outPtr = paramInt1;
          illegalSurrogate(i);
        }
        _surrogate = i;
        if (paramInt2 >= i1) {
          break;
        }
        i = convertSurrogate(paramArrayOfChar[paramInt2]);
        if (i > 1114111)
        {
          _outPtr = paramInt1;
          illegalSurrogate(i);
        }
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 18 | 0xF0));
        paramInt1 = j + 1;
        arrayOfByte[j] = ((byte)(i >> 12 & 0x3F | 0x80));
        j = paramInt1 + 1;
        arrayOfByte[paramInt1] = ((byte)(i >> 6 & 0x3F | 0x80));
        arrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        paramInt1 = j + 1;
        paramInt2 += 1;
      }
    }
    label504:
    label507:
    label520:
    for (;;)
    {
      _outPtr = paramInt1;
      return;
      break;
      paramInt1 = i;
      paramInt2 = j;
      i = k;
      break label222;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.UTF8Writer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */