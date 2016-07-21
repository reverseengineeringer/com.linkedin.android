package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;

public final class IOContext
{
  protected byte[] _base64Buffer = null;
  protected final BufferRecycler _bufferRecycler;
  protected char[] _concatCBuffer = null;
  protected JsonEncoding _encoding;
  protected final boolean _managedResource;
  protected char[] _nameCopyBuffer = null;
  protected byte[] _readIOBuffer = null;
  protected final Object _sourceRef;
  protected char[] _tokenCBuffer = null;
  protected byte[] _writeEncodingBuffer = null;
  
  public IOContext(BufferRecycler paramBufferRecycler, Object paramObject, boolean paramBoolean)
  {
    _bufferRecycler = paramBufferRecycler;
    _sourceRef = paramObject;
    _managedResource = paramBoolean;
  }
  
  private static void _verifyAlloc(Object paramObject)
  {
    if (paramObject != null) {
      throw new IllegalStateException("Trying to call same allocXxx() method second time");
    }
  }
  
  private static void _verifyRelease(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != paramArrayOfByte2) && (paramArrayOfByte1.length <= paramArrayOfByte2.length)) {
      throw wrongBuf();
    }
  }
  
  private static void _verifyRelease(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if ((paramArrayOfChar1 != paramArrayOfChar2) && (paramArrayOfChar1.length <= paramArrayOfChar2.length)) {
      throw wrongBuf();
    }
  }
  
  private static IllegalArgumentException wrongBuf()
  {
    return new IllegalArgumentException("Trying to release buffer not owned by the context");
  }
  
  public final char[] allocConcatBuffer()
  {
    _verifyAlloc(_concatCBuffer);
    char[] arrayOfChar = _bufferRecycler.allocCharBuffer(1);
    _concatCBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public final char[] allocNameCopyBuffer(int paramInt)
  {
    _verifyAlloc(_nameCopyBuffer);
    char[] arrayOfChar = _bufferRecycler.allocCharBuffer(3, paramInt);
    _nameCopyBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public final byte[] allocReadIOBuffer()
  {
    _verifyAlloc(_readIOBuffer);
    byte[] arrayOfByte = _bufferRecycler.allocByteBuffer(0);
    _readIOBuffer = arrayOfByte;
    return arrayOfByte;
  }
  
  public final char[] allocTokenBuffer()
  {
    _verifyAlloc(_tokenCBuffer);
    char[] arrayOfChar = _bufferRecycler.allocCharBuffer(0);
    _tokenCBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public final char[] allocTokenBuffer(int paramInt)
  {
    _verifyAlloc(_tokenCBuffer);
    char[] arrayOfChar = _bufferRecycler.allocCharBuffer(0, paramInt);
    _tokenCBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public final byte[] allocWriteEncodingBuffer()
  {
    _verifyAlloc(_writeEncodingBuffer);
    byte[] arrayOfByte = _bufferRecycler.allocByteBuffer(1);
    _writeEncodingBuffer = arrayOfByte;
    return arrayOfByte;
  }
  
  public final TextBuffer constructTextBuffer()
  {
    return new TextBuffer(_bufferRecycler);
  }
  
  public final JsonEncoding getEncoding()
  {
    return _encoding;
  }
  
  public final Object getSourceReference()
  {
    return _sourceRef;
  }
  
  public final boolean isResourceManaged()
  {
    return _managedResource;
  }
  
  public final void releaseConcatBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, _concatCBuffer);
      _concatCBuffer = null;
      _bufferRecycler.releaseCharBuffer(1, paramArrayOfChar);
    }
  }
  
  public final void releaseNameCopyBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, _nameCopyBuffer);
      _nameCopyBuffer = null;
      _bufferRecycler.releaseCharBuffer(3, paramArrayOfChar);
    }
  }
  
  public final void releaseReadIOBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _verifyRelease(paramArrayOfByte, _readIOBuffer);
      _readIOBuffer = null;
      _bufferRecycler.releaseByteBuffer(0, paramArrayOfByte);
    }
  }
  
  public final void releaseTokenBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, _tokenCBuffer);
      _tokenCBuffer = null;
      _bufferRecycler.releaseCharBuffer(0, paramArrayOfChar);
    }
  }
  
  public final void releaseWriteEncodingBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _verifyRelease(paramArrayOfByte, _writeEncodingBuffer);
      _writeEncodingBuffer = null;
      _bufferRecycler.releaseByteBuffer(1, paramArrayOfByte);
    }
  }
  
  public final void setEncoding(JsonEncoding paramJsonEncoding)
  {
    _encoding = paramJsonEncoding;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.IOContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */