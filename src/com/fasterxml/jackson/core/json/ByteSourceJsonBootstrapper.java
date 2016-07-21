package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class ByteSourceJsonBootstrapper
{
  protected boolean _bigEndian = true;
  private final boolean _bufferRecyclable;
  protected int _bytesPerChar = 0;
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  private int _inputEnd;
  protected int _inputProcessed;
  private int _inputPtr;
  
  public ByteSourceJsonBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    _context = paramIOContext;
    _in = paramInputStream;
    _inputBuffer = paramIOContext.allocReadIOBuffer();
    _inputPtr = 0;
    _inputEnd = 0;
    _inputProcessed = 0;
    _bufferRecyclable = true;
  }
  
  public ByteSourceJsonBootstrapper(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt)
  {
    _context = paramIOContext;
    _in = null;
    _inputBuffer = paramArrayOfByte;
    _inputPtr = 0;
    _inputEnd = (paramInt + 0);
    _inputProcessed = 0;
    _bufferRecyclable = false;
  }
  
  private boolean checkUTF16(int paramInt)
  {
    boolean bool = false;
    if ((0xFF00 & paramInt) == 0) {}
    for (_bigEndian = true;; _bigEndian = false)
    {
      _bytesPerChar = 2;
      bool = true;
      do
      {
        return bool;
      } while ((paramInt & 0xFF) != 0);
    }
  }
  
  private boolean ensureLoaded(int paramInt)
    throws IOException
  {
    int i = _inputEnd - _inputPtr;
    while (i < paramInt)
    {
      if (_in == null) {}
      for (int j = -1; j <= 0; j = _in.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd)) {
        return false;
      }
      _inputEnd += j;
      i += j;
    }
    return true;
  }
  
  private static void reportWeirdUCS4(String paramString)
    throws IOException
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }
  
  public final JsonParser constructParser(int paramInt1, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer, int paramInt2)
    throws IOException
  {
    int j = 0;
    int i;
    int k;
    if (ensureLoaded(4))
    {
      i = _inputBuffer[_inputPtr];
      k = _inputBuffer[(_inputPtr + 1)];
      int m = _inputBuffer[(_inputPtr + 2)];
      k = _inputBuffer[(_inputPtr + 3)] & 0xFF | i << 24 | (k & 0xFF) << 16 | (m & 0xFF) << 8;
      switch (k)
      {
      default: 
        i = k >>> 16;
        if (i == 65279)
        {
          _inputPtr += 2;
          _bytesPerChar = 2;
          _bigEndian = true;
          i = 1;
          label173:
          if (i == 0) {
            break label401;
          }
          i = 1;
          label181:
          if (i != 0) {
            break label570;
          }
          localObject = JsonEncoding.UTF8;
        }
        break;
      }
    }
    for (;;)
    {
      _context.setEncoding((JsonEncoding)localObject);
      if ((localObject != JsonEncoding.UTF8) || (!JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt2))) {
        break label668;
      }
      paramBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(paramInt2);
      return new UTF8StreamJsonParser(_context, paramInt1, _in, paramObjectCodec, paramBytesToNameCanonicalizer, _inputBuffer, _inputPtr, _inputEnd, _bufferRecyclable);
      _bigEndian = true;
      _inputPtr += 4;
      _bytesPerChar = 4;
      i = 1;
      break label173;
      _inputPtr += 4;
      _bytesPerChar = 4;
      _bigEndian = false;
      i = 1;
      break label173;
      reportWeirdUCS4("2143");
      reportWeirdUCS4("3412");
      break;
      if (i == 65534)
      {
        _inputPtr += 2;
        _bytesPerChar = 2;
        _bigEndian = false;
        i = 1;
        break label173;
      }
      if (k >>> 8 == 15711167)
      {
        _inputPtr += 3;
        _bytesPerChar = 1;
        _bigEndian = true;
        i = 1;
        break label173;
      }
      i = 0;
      break label173;
      label401:
      if (k >> 8 == 0)
      {
        _bigEndian = true;
        label414:
        _bytesPerChar = 4;
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label487;
        }
        i = 1;
        break;
        if ((0xFFFFFF & k) == 0)
        {
          _bigEndian = false;
          break label414;
        }
        if ((0xFF00FFFF & k) == 0)
        {
          reportWeirdUCS4("3412");
          break label414;
        }
        if ((0xFFFF00FF & k) == 0)
        {
          reportWeirdUCS4("2143");
          break label414;
        }
      }
      label487:
      i = j;
      if (!checkUTF16(k >>> 16)) {
        break label181;
      }
      i = 1;
      break label181;
      i = j;
      if (!ensureLoaded(2)) {
        break label181;
      }
      i = j;
      if (!checkUTF16((_inputBuffer[_inputPtr] & 0xFF) << 8 | _inputBuffer[(_inputPtr + 1)] & 0xFF)) {
        break label181;
      }
      i = 1;
      break label181;
      label570:
      switch (_bytesPerChar)
      {
      case 3: 
      default: 
        throw new RuntimeException("Internal error");
      case 1: 
        localObject = JsonEncoding.UTF8;
        break;
      case 2: 
        if (_bigEndian) {
          localObject = JsonEncoding.UTF16_BE;
        } else {
          localObject = JsonEncoding.UTF16_LE;
        }
        break;
      case 4: 
        if (_bigEndian) {
          localObject = JsonEncoding.UTF32_BE;
        } else {
          localObject = JsonEncoding.UTF32_LE;
        }
        break;
      }
    }
    label668:
    Object localObject = _context;
    JsonEncoding localJsonEncoding = _context.getEncoding();
    switch (localJsonEncoding.bits())
    {
    default: 
      throw new RuntimeException("Internal error");
    case 8: 
    case 16: 
      paramBytesToNameCanonicalizer = _in;
      if (paramBytesToNameCanonicalizer == null) {
        paramBytesToNameCanonicalizer = new ByteArrayInputStream(_inputBuffer, _inputPtr, _inputEnd);
      }
      break;
    }
    label877:
    for (;;)
    {
      for (paramBytesToNameCanonicalizer = new InputStreamReader(paramBytesToNameCanonicalizer, localJsonEncoding.getJavaName());; paramBytesToNameCanonicalizer = new UTF32Reader(_context, _in, _inputBuffer, _inputPtr, _inputEnd, _context.getEncoding().isBigEndian()))
      {
        return new ReaderBasedJsonParser((IOContext)localObject, paramInt1, paramBytesToNameCanonicalizer, paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(paramInt2));
        if (_inputPtr >= _inputEnd) {
          break label877;
        }
        paramBytesToNameCanonicalizer = new MergedStream(_context, paramBytesToNameCanonicalizer, _inputBuffer, _inputPtr, _inputEnd);
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */