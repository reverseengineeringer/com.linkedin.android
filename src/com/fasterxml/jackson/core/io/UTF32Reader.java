package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public final class UTF32Reader
  extends Reader
{
  protected final boolean _bigEndian;
  protected byte[] _buffer;
  protected int _byteCount = 0;
  protected int _charCount = 0;
  protected final IOContext _context;
  protected InputStream _in;
  protected int _length;
  protected final boolean _managedBuffers;
  protected int _ptr;
  protected char _surrogate = '\000';
  protected char[] _tmpBuf = null;
  
  public UTF32Reader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    _context = paramIOContext;
    _in = paramInputStream;
    _buffer = paramArrayOfByte;
    _ptr = paramInt1;
    _length = paramInt2;
    _bigEndian = paramBoolean;
    paramBoolean = bool;
    if (paramInputStream != null) {
      paramBoolean = true;
    }
    _managedBuffers = paramBoolean;
  }
  
  private void freeBuffers()
  {
    byte[] arrayOfByte = _buffer;
    if (arrayOfByte != null)
    {
      _buffer = null;
      _context.releaseReadIOBuffer(arrayOfByte);
    }
  }
  
  private boolean loadMore(int paramInt)
    throws IOException
  {
    _byteCount += _length - paramInt;
    if (paramInt > 0)
    {
      if (_ptr > 0)
      {
        System.arraycopy(_buffer, _ptr, _buffer, 0, paramInt);
        _ptr = 0;
      }
      _length = paramInt;
    }
    while (_length < 4)
    {
      if (_in == null) {
        paramInt = -1;
      }
      for (;;)
      {
        if (paramInt <= 0)
        {
          if (paramInt < 0)
          {
            if (_managedBuffers) {
              freeBuffers();
            }
            paramInt = _length;
            int i = _byteCount;
            int j = _charCount;
            throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt + ", needed 4, at char #" + j + ", byte #" + (i + paramInt) + ")");
            _ptr = 0;
            if (_in == null) {
              paramInt = -1;
            }
            while (paramInt <= 0)
            {
              _length = 0;
              if (paramInt < 0)
              {
                if (_managedBuffers) {
                  freeBuffers();
                }
                return false;
                paramInt = _in.read(_buffer);
              }
              else
              {
                reportStrangeStream();
              }
            }
            _length = paramInt;
            break;
            paramInt = _in.read(_buffer, _length, _buffer.length - _length);
            continue;
          }
          reportStrangeStream();
        }
      }
      _length += paramInt;
    }
    return true;
  }
  
  private static void reportStrangeStream()
    throws IOException
  {
    throw new IOException("Strange I/O stream, returned 0 bytes on read");
  }
  
  public final void close()
    throws IOException
  {
    InputStream localInputStream = _in;
    if (localInputStream != null)
    {
      _in = null;
      freeBuffers();
      localInputStream.close();
    }
  }
  
  public final int read()
    throws IOException
  {
    if (_tmpBuf == null) {
      _tmpBuf = new char[1];
    }
    if (read(_tmpBuf, 0, 1) <= 0) {
      return -1;
    }
    return _tmpBuf[0];
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_buffer == null) {
      return -1;
    }
    if (paramInt2 <= 0) {
      return paramInt2;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      throw new ArrayIndexOutOfBoundsException("read(buf," + paramInt1 + "," + paramInt2 + "), cbuf[" + paramArrayOfChar.length + "]");
    }
    int m = paramInt2 + paramInt1;
    if (_surrogate != 0)
    {
      paramArrayOfChar[paramInt1] = _surrogate;
      _surrogate = '\000';
      paramInt2 = paramInt1 + 1;
      label103:
      i = paramInt2;
      if (paramInt2 >= m) {
        break label512;
      }
      i = _ptr;
      if (!_bigEndian) {
        break label347;
      }
    }
    label347:
    for (int i = _buffer[i] << 24 | (_buffer[(i + 1)] & 0xFF) << 16 | (_buffer[(i + 2)] & 0xFF) << 8 | _buffer[(i + 3)] & 0xFF;; i = _buffer[i] & 0xFF | (_buffer[(i + 1)] & 0xFF) << 8 | (_buffer[(i + 2)] & 0xFF) << 16 | _buffer[(i + 3)] << 24)
    {
      _ptr += 4;
      if (i <= 65535) {
        break label483;
      }
      if (i <= 1114111) {
        break label410;
      }
      paramArrayOfChar = "(above " + Integer.toHexString(1114111) + ") ";
      j = _byteCount;
      k = _ptr;
      m = _charCount;
      throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + paramArrayOfChar + " at char #" + (paramInt2 - paramInt1 + m) + ", byte #" + (j + k - 1) + ")");
      paramInt2 = _length - _ptr;
      if ((paramInt2 < 4) && (!loadMore(paramInt2))) {
        break;
      }
      paramInt2 = paramInt1;
      break label103;
    }
    label410:
    int j = i - 65536;
    i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = ((char)(55296 + (j >> 10)));
    int k = 0xDC00 | j & 0x3FF;
    j = k;
    paramInt2 = i;
    if (i >= m) {
      _surrogate = ((char)k);
    }
    label483:
    label512:
    for (;;)
    {
      paramInt1 = i - paramInt1;
      _charCount += paramInt1;
      return paramInt1;
      j = i;
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)j);
      paramInt2 = i;
      if (_ptr < _length) {
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.UTF32Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */