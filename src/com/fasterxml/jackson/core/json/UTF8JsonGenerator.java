package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class UTF8JsonGenerator
  extends JsonGeneratorImpl
{
  private static final byte[] FALSE_BYTES = { 102, 97, 108, 115, 101 };
  static final byte[] HEX_CHARS = ;
  private static final byte[] NULL_BYTES = { 110, 117, 108, 108 };
  private static final byte[] TRUE_BYTES = { 116, 114, 117, 101 };
  protected boolean _bufferRecyclable;
  protected boolean _cfgUnqNames;
  protected char[] _charBuffer;
  protected final int _charBufferLength;
  protected byte[] _outputBuffer;
  protected final int _outputEnd;
  protected final int _outputMaxContiguous;
  protected final OutputStream _outputStream;
  protected int _outputTail = 0;
  
  public UTF8JsonGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, OutputStream paramOutputStream)
  {
    super(paramIOContext, paramInt, paramObjectCodec);
    _outputStream = paramOutputStream;
    _bufferRecyclable = true;
    _outputBuffer = paramIOContext.allocWriteEncodingBuffer();
    _outputEnd = _outputBuffer.length;
    _outputMaxContiguous = (_outputEnd >> 3);
    _charBuffer = paramIOContext.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar$1549bd1();
    }
    if (!JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(paramInt)) {}
    for (;;)
    {
      _cfgUnqNames = bool;
      return;
      bool = false;
    }
  }
  
  private void _flushBuffer()
    throws IOException
  {
    int i = _outputTail;
    if (i > 0)
    {
      _outputTail = 0;
      _outputStream.write(_outputBuffer, 0, i);
    }
  }
  
  private final int _outputMultiByteChar(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = _outputBuffer;
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = 92;
      paramInt2 = i + 1;
      arrayOfByte[i] = 117;
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 12 & 0xF)];
      paramInt2 = i + 1;
      arrayOfByte[i] = HEX_CHARS[(paramInt1 >> 8 & 0xF)];
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 4 & 0xF)];
      arrayOfByte[i] = HEX_CHARS[(paramInt1 & 0xF)];
      return i + 1;
    }
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt2 = i + 1;
    arrayOfByte[i] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    arrayOfByte[paramInt2] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2 + 1;
  }
  
  private final int _outputRawMultiByteChar(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException
  {
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      if ((paramInt2 >= paramInt3) || (paramArrayOfChar == null)) {
        _reportError("Split surrogate on writeRaw() input (last character)");
      }
      paramInt3 = paramArrayOfChar[paramInt2];
      if ((paramInt3 < 56320) || (paramInt3 > 57343)) {
        GeneratorBase._reportError("Incomplete surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt3));
      }
      paramInt1 = paramInt3 - 56320 + (65536 + (paramInt1 - 55296 << 10));
      if (_outputTail + 4 > _outputEnd) {
        _flushBuffer();
      }
      paramArrayOfChar = _outputBuffer;
      paramInt3 = _outputTail;
      _outputTail = (paramInt3 + 1);
      paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 18 | 0xF0));
      paramInt3 = _outputTail;
      _outputTail = (paramInt3 + 1);
      paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
      paramInt3 = _outputTail;
      _outputTail = (paramInt3 + 1);
      paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramInt3 = _outputTail;
      _outputTail = (paramInt3 + 1);
      paramArrayOfChar[paramInt3] = ((byte)(paramInt1 & 0x3F | 0x80));
      return paramInt2 + 1;
    }
    paramArrayOfChar = _outputBuffer;
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 12 | 0xE0));
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
    paramInt3 = _outputTail;
    _outputTail = (paramInt3 + 1);
    paramArrayOfChar[paramInt3] = ((byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2;
  }
  
  private final void _writeBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (_outputTail + i > _outputEnd)
    {
      _flushBuffer();
      if (i > 512)
      {
        _outputStream.write(paramArrayOfByte, 0, i);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, 0, _outputBuffer, _outputTail, i);
    _outputTail += i;
  }
  
  private final int _writeCustomEscape(byte[] paramArrayOfByte, int paramInt1, SerializableString paramSerializableString, int paramInt2)
    throws IOException, JsonGenerationException
  {
    paramSerializableString = paramSerializableString.asUnquotedUTF8();
    int i = paramSerializableString.length;
    int j;
    if (i > 6)
    {
      j = _outputEnd;
      int k = paramSerializableString.length;
      if (paramInt1 + k <= j) {
        break label127;
      }
      _outputTail = paramInt1;
      _flushBuffer();
      i = _outputTail;
      if (k > paramArrayOfByte.length)
      {
        _outputStream.write(paramSerializableString, 0, k);
        return i;
      }
      System.arraycopy(paramSerializableString, 0, paramArrayOfByte, i, k);
      paramInt1 = i + k;
    }
    label127:
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 * 6 + paramInt1 <= j) {
        break;
      }
      _flushBuffer();
      return _outputTail;
      System.arraycopy(paramSerializableString, 0, paramArrayOfByte, paramInt1, i);
      return paramInt1 + i;
    }
  }
  
  private int _writeGenericEscape(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = _outputBuffer;
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = 92;
    paramInt2 = i + 1;
    arrayOfByte[i] = 117;
    if (paramInt1 > 255)
    {
      i = paramInt1 >> 8 & 0xFF;
      int j = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(i >> 4)];
      paramInt2 = j + 1;
      arrayOfByte[j] = HEX_CHARS[(i & 0xF)];
      paramInt1 &= 0xFF;
    }
    for (;;)
    {
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = HEX_CHARS[(paramInt1 >> 4)];
      arrayOfByte[i] = HEX_CHARS[(paramInt1 & 0xF)];
      return i + 1;
      i = paramInt2 + 1;
      arrayOfByte[paramInt2] = 48;
      paramInt2 = i + 1;
      arrayOfByte[i] = 48;
    }
  }
  
  private final void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(NULL_BYTES, 0, _outputBuffer, _outputTail, 4);
    _outputTail += 4;
  }
  
  private final void _writeQuotedRaw(String paramString)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    writeRaw(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  private final void _writeStringSegment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int k = paramInt2 + paramInt1;
    paramInt2 = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    int i;
    while (paramInt1 < k)
    {
      i = paramArrayOfChar[paramInt1];
      if ((i > 127) || (arrayOfInt[i] != 0)) {
        break;
      }
      arrayOfByte[paramInt2] = ((byte)i);
      paramInt1 += 1;
      paramInt2 += 1;
    }
    _outputTail = paramInt2;
    if (paramInt1 < k)
    {
      if (_characterEscapes != null)
      {
        if (_outputTail + (k - paramInt1) * 6 > _outputEnd) {
          _flushBuffer();
        }
        i = _outputTail;
        arrayOfByte = _outputBuffer;
        arrayOfInt = _outputEscapes;
        int j;
        CharacterEscapes localCharacterEscapes;
        if (_maximumNonEscapedChar <= 0)
        {
          j = 65535;
          localCharacterEscapes = _characterEscapes;
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        for (;;)
        {
          if (paramInt2 >= k) {
            break label433;
          }
          i = paramInt2 + 1;
          paramInt2 = paramArrayOfChar[paramInt2];
          int m;
          SerializableString localSerializableString;
          if (paramInt2 <= 127)
          {
            if (arrayOfInt[paramInt2] == 0)
            {
              arrayOfByte[paramInt1] = ((byte)paramInt2);
              paramInt1 += 1;
              paramInt2 = i;
              continue;
              j = _maximumNonEscapedChar;
              break;
            }
            m = arrayOfInt[paramInt2];
            if (m > 0)
            {
              paramInt2 = paramInt1 + 1;
              arrayOfByte[paramInt1] = 92;
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)m);
              paramInt2 = i;
              continue;
            }
            if (m == -2)
            {
              localSerializableString = localCharacterEscapes.getEscapeSequence$428277ea();
              if (localSerializableString == null) {
                _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(paramInt2) + ", although was supposed to have one");
              }
              paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, k - i);
              paramInt2 = i;
              continue;
            }
            paramInt1 = _writeGenericEscape(paramInt2, paramInt1);
            paramInt2 = i;
            continue;
          }
          if (paramInt2 > j)
          {
            paramInt1 = _writeGenericEscape(paramInt2, paramInt1);
            paramInt2 = i;
          }
          else
          {
            localSerializableString = localCharacterEscapes.getEscapeSequence$428277ea();
            if (localSerializableString != null)
            {
              paramInt1 = _writeCustomEscape(arrayOfByte, paramInt1, localSerializableString, k - i);
              paramInt2 = i;
            }
            else if (paramInt2 <= 2047)
            {
              m = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(paramInt2 >> 6 | 0xC0));
              paramInt1 = m + 1;
              arrayOfByte[m] = ((byte)(paramInt2 & 0x3F | 0x80));
              paramInt2 = i;
            }
            else
            {
              paramInt1 = _outputMultiByteChar(paramInt2, paramInt1);
              paramInt2 = i;
            }
          }
        }
        label433:
        _outputTail = paramInt1;
      }
    }
    else {
      return;
    }
    if (_maximumNonEscapedChar == 0)
    {
      _writeStringSegment2(paramArrayOfChar, paramInt1, k);
      return;
    }
    _writeStringSegmentASCII2(paramArrayOfChar, paramInt1, k);
  }
  
  private final void _writeStringSegment2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (_outputTail + (paramInt2 - paramInt1) * 6 > _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    while (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      paramInt1 = paramArrayOfChar[paramInt1];
      int k;
      if (paramInt1 <= 127)
      {
        if (arrayOfInt[paramInt1] == 0)
        {
          arrayOfByte[i] = ((byte)paramInt1);
          i += 1;
          paramInt1 = j;
        }
        else
        {
          k = arrayOfInt[paramInt1];
          if (k > 0)
          {
            paramInt1 = i + 1;
            arrayOfByte[i] = 92;
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)k);
            paramInt1 = j;
          }
          else
          {
            i = _writeGenericEscape(paramInt1, i);
            paramInt1 = j;
          }
        }
      }
      else if (paramInt1 <= 2047)
      {
        k = i + 1;
        arrayOfByte[i] = ((byte)(paramInt1 >> 6 | 0xC0));
        i = k + 1;
        arrayOfByte[k] = ((byte)(paramInt1 & 0x3F | 0x80));
        paramInt1 = j;
      }
      else
      {
        i = _outputMultiByteChar(paramInt1, i);
        paramInt1 = j;
      }
    }
    _outputTail = i;
  }
  
  private final void _writeStringSegmentASCII2(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (_outputTail + (paramInt2 - paramInt1) * 6 > _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    byte[] arrayOfByte = _outputBuffer;
    int[] arrayOfInt = _outputEscapes;
    int k = _maximumNonEscapedChar;
    while (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      paramInt1 = paramArrayOfChar[paramInt1];
      int m;
      if (paramInt1 <= 127)
      {
        if (arrayOfInt[paramInt1] == 0)
        {
          arrayOfByte[i] = ((byte)paramInt1);
          i += 1;
          paramInt1 = j;
        }
        else
        {
          m = arrayOfInt[paramInt1];
          if (m > 0)
          {
            paramInt1 = i + 1;
            arrayOfByte[i] = 92;
            i = paramInt1 + 1;
            arrayOfByte[paramInt1] = ((byte)m);
            paramInt1 = j;
          }
          else
          {
            i = _writeGenericEscape(paramInt1, i);
            paramInt1 = j;
          }
        }
      }
      else if (paramInt1 > k)
      {
        i = _writeGenericEscape(paramInt1, i);
        paramInt1 = j;
      }
      else if (paramInt1 <= 2047)
      {
        m = i + 1;
        arrayOfByte[i] = ((byte)(paramInt1 >> 6 | 0xC0));
        i = m + 1;
        arrayOfByte[m] = ((byte)(paramInt1 & 0x3F | 0x80));
        paramInt1 = j;
      }
      else
      {
        i = _outputMultiByteChar(paramInt1, i);
        paramInt1 = j;
      }
    }
    _outputTail = i;
  }
  
  private final void _writeStringSegments(String paramString, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      localObject[i] = 34;
    }
    int i = paramString.length();
    int j = 0;
    Object localObject = _charBuffer;
    while (i > 0)
    {
      int k = Math.min(_outputMaxContiguous, i);
      paramString.getChars(j, j + k, (char[])localObject, 0);
      if (_outputTail + k > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment((char[])localObject, 0, k);
      j += k;
      i -= k;
    }
    if (paramBoolean)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
    }
  }
  
  private final void _writeStringSegments(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i;
    do
    {
      i = Math.min(_outputMaxContiguous, paramInt2);
      if (_outputTail + i > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, i);
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  protected final void _releaseBuffers()
  {
    Object localObject = _outputBuffer;
    if ((localObject != null) && (_bufferRecyclable))
    {
      _outputBuffer = null;
      _ioContext.releaseWriteEncodingBuffer((byte[])localObject);
    }
    localObject = _charBuffer;
    if (localObject != null)
    {
      _charBuffer = null;
      _ioContext.releaseConcatBuffer((char[])localObject);
    }
  }
  
  protected final void _verifyValueWrite(String paramString)
    throws IOException, JsonGenerationException
  {
    int j = _writeContext.writeValue();
    if (j == 5) {
      _reportError("Can not " + paramString + ", expecting field name");
    }
    if (_cfgPrettyPrinter == null) {
      switch (j)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          for (int i = 44;; i = 58)
          {
            if (_outputTail >= _outputEnd) {
              _flushBuffer();
            }
            _outputBuffer[_outputTail] = i;
            _outputTail += 1;
            return;
          }
        } while (_rootValueSeparator == null);
        paramString = _rootValueSeparator.asUnquotedUTF8();
      } while (paramString.length <= 0);
      _writeBytes(paramString);
      return;
      switch (j)
      {
      default: 
        VersionUtil.throwInternal();
        return;
      case 1: 
        _cfgPrettyPrinter.writeArrayValueSeparator(this);
        return;
      case 2: 
        _cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
        return;
      case 3: 
        _cfgPrettyPrinter.writeRootValueSeparator(this);
        return;
      }
      if (_writeContext.inArray())
      {
        _cfgPrettyPrinter.beforeArrayValues(this);
        return;
      }
    } while (!_writeContext.inObject());
    _cfgPrettyPrinter.beforeObjectEntries(this);
  }
  
  public final void close()
    throws IOException
  {
    super.close();
    if ((_outputBuffer != null) && (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        JsonWriteContext localJsonWriteContext = _writeContext;
        if (localJsonWriteContext.inArray())
        {
          writeEndArray();
        }
        else
        {
          if (!localJsonWriteContext.inObject()) {
            break;
          }
          writeEndObject();
        }
      }
    }
    _flushBuffer();
    if (_outputStream != null)
    {
      if ((!_ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        break label97;
      }
      _outputStream.close();
    }
    for (;;)
    {
      _releaseBuffers();
      return;
      label97:
      if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        _outputStream.flush();
      }
    }
  }
  
  public final void flush()
    throws IOException
  {
    _flushBuffer();
    if ((_outputStream != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _outputStream.flush();
    }
  }
  
  public final void writeBoolean(boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write boolean value");
    if (_outputTail + 5 >= _outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean) {}
    for (byte[] arrayOfByte = TRUE_BYTES;; arrayOfByte = FALSE_BYTES)
    {
      int i = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, _outputBuffer, _outputTail, i);
      _outputTail += i;
      return;
    }
  }
  
  public final void writeEndArray()
    throws IOException
  {
    if (!_writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + _writeContext.getTypeDesc());
    }
    if (_cfgPrettyPrinter != null) {
      _cfgPrettyPrinter.writeEndArray(this, _writeContext._index + 1);
    }
    for (;;)
    {
      _writeContext = _writeContext.getParent();
      return;
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 93;
    }
  }
  
  public final void writeEndObject()
    throws IOException
  {
    if (!_writeContext.inObject()) {
      _reportError("Current context not an object but " + _writeContext.getTypeDesc());
    }
    if (_cfgPrettyPrinter != null) {
      _cfgPrettyPrinter.writeEndObject(this, _writeContext._index + 1);
    }
    for (;;)
    {
      _writeContext = _writeContext.getParent();
      return;
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 125;
    }
  }
  
  public final void writeFieldName(String paramString)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      i = _writeContext.writeFieldName(paramString);
      if (i == 4) {
        _reportError("Can not write a field name, expecting a value");
      }
      if (i == 1) {
        _cfgPrettyPrinter.writeObjectEntrySeparator(this);
      }
      while (_cfgUnqNames)
      {
        _writeStringSegments(paramString, false);
        return;
        _cfgPrettyPrinter.beforeObjectEntries(this);
      }
      i = paramString.length();
      if (i > _charBufferLength)
      {
        _writeStringSegments(paramString, true);
        return;
      }
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      arrayOfByte = _outputBuffer;
      j = _outputTail;
      _outputTail = (j + 1);
      arrayOfByte[j] = 34;
      paramString.getChars(0, i, _charBuffer, 0);
      if (i <= _outputMaxContiguous)
      {
        if (_outputTail + i > _outputEnd) {
          _flushBuffer();
        }
        _writeStringSegment(_charBuffer, 0, i);
      }
      for (;;)
      {
        if (_outputTail >= _outputEnd) {
          _flushBuffer();
        }
        paramString = _outputBuffer;
        i = _outputTail;
        _outputTail = (i + 1);
        paramString[i] = 34;
        return;
        _writeStringSegments(_charBuffer, 0, i);
      }
    }
    int i = _writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      arrayOfByte = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 44;
    }
    if (_cfgUnqNames)
    {
      _writeStringSegments(paramString, false);
      return;
    }
    i = paramString.length();
    if (i > _charBufferLength)
    {
      _writeStringSegments(paramString, true);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int j = _outputTail;
    _outputTail = (j + 1);
    arrayOfByte[j] = 34;
    paramString.getChars(0, i, _charBuffer, 0);
    if (i <= _outputMaxContiguous)
    {
      if (_outputTail + i > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(_charBuffer, 0, i);
    }
    for (;;)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
      return;
      _writeStringSegments(_charBuffer, 0, i);
    }
  }
  
  public final void writeNull()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write null value");
    _writeNull();
  }
  
  public final void writeNumber(double paramDouble)
    throws IOException, JsonGenerationException
  {
    if ((_cfgNumbersAsStrings) || (((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramDouble));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramDouble));
  }
  
  public final void writeNumber(float paramFloat)
    throws IOException, JsonGenerationException
  {
    if ((_cfgNumbersAsStrings) || (((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramFloat));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramFloat));
  }
  
  public final void writeNumber(int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    if (_cfgNumbersAsStrings)
    {
      if (_outputTail + 13 >= _outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 34;
      _outputTail = NumberOutput.outputInt(paramInt, _outputBuffer, _outputTail);
      arrayOfByte = _outputBuffer;
      paramInt = _outputTail;
      _outputTail = (paramInt + 1);
      arrayOfByte[paramInt] = 34;
      return;
    }
    _outputTail = NumberOutput.outputInt(paramInt, _outputBuffer, _outputTail);
  }
  
  public final void writeNumber(long paramLong)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      if (_outputTail + 23 >= _outputEnd) {
        _flushBuffer();
      }
      byte[] arrayOfByte = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 34;
      _outputTail = NumberOutput.outputLong(paramLong, _outputBuffer, _outputTail);
      arrayOfByte = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = 34;
      return;
    }
    if (_outputTail + 21 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputLong(paramLong, _outputBuffer, _outputTail);
  }
  
  public final void writeNumber(BigDecimal paramBigDecimal)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigDecimal == null)
    {
      _writeNull();
      return;
    }
    if (_cfgNumbersAsStrings)
    {
      if (isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {}
      for (paramBigDecimal = paramBigDecimal.toPlainString();; paramBigDecimal = paramBigDecimal.toString())
      {
        _writeQuotedRaw(paramBigDecimal);
        return;
      }
    }
    if (isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN))
    {
      writeRaw(paramBigDecimal.toPlainString());
      return;
    }
    writeRaw(paramBigDecimal.toString());
  }
  
  public final void writeNumber(BigInteger paramBigInteger)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigInteger == null)
    {
      _writeNull();
      return;
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigInteger.toString());
      return;
    }
    writeRaw(paramBigInteger.toString());
  }
  
  public final void writeRaw(char paramChar)
    throws IOException, JsonGenerationException
  {
    if (_outputTail + 3 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i;
    if (paramChar <= '')
    {
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)paramChar);
      return;
    }
    if (paramChar < 'ࠀ')
    {
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar >> '\006' | 0xC0));
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfByte[i] = ((byte)(paramChar & 0x3F | 0x80));
      return;
    }
    _outputRawMultiByteChar(paramChar, null, 0, 0);
  }
  
  public final void writeRaw(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    paramSerializableString = paramSerializableString.asUnquotedUTF8();
    if (paramSerializableString.length > 0) {
      _writeBytes(paramSerializableString);
    }
  }
  
  public final void writeRaw(String paramString)
    throws IOException, JsonGenerationException
  {
    int j = 0;
    int i = paramString.length();
    if (i > 0)
    {
      char[] arrayOfChar = _charBuffer;
      int k = arrayOfChar.length;
      if (i < k) {
        k = i;
      }
      for (;;)
      {
        paramString.getChars(j, j + k, arrayOfChar, 0);
        writeRaw(arrayOfChar, 0, k);
        j += k;
        i -= k;
        break;
      }
    }
  }
  
  public final void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i = paramInt2 + paramInt2 + paramInt2;
    int j;
    byte[] arrayOfByte;
    int k;
    if (_outputTail + i > _outputEnd) {
      if (_outputEnd < i)
      {
        paramInt1 = 0;
        j = _outputEnd;
        arrayOfByte = _outputBuffer;
        if (paramInt1 < paramInt2) {
          do
          {
            i = paramArrayOfChar[paramInt1];
            if (i >= 128) {
              break;
            }
            if (_outputTail >= j) {
              _flushBuffer();
            }
            k = _outputTail;
            _outputTail = (k + 1);
            arrayOfByte[k] = ((byte)i);
            i = paramInt1 + 1;
            paramInt1 = i;
          } while (i < paramInt2);
        }
      }
    }
    label285:
    label384:
    for (;;)
    {
      return;
      if (_outputTail + 3 >= _outputEnd) {
        _flushBuffer();
      }
      i = paramInt1 + 1;
      paramInt1 = paramArrayOfChar[paramInt1];
      if (paramInt1 < 2048)
      {
        k = _outputTail;
        _outputTail = (k + 1);
        arrayOfByte[k] = ((byte)(paramInt1 >> 6 | 0xC0));
        k = _outputTail;
        _outputTail = (k + 1);
        arrayOfByte[k] = ((byte)(paramInt1 & 0x3F | 0x80));
        paramInt1 = i;
        break;
      }
      paramInt1 = _outputRawMultiByteChar(paramInt1, paramArrayOfChar, i, paramInt2);
      break;
      _flushBuffer();
      i = paramInt2 + 0;
      for (;;)
      {
        if (paramInt1 >= i) {
          break label384;
        }
        for (;;)
        {
          paramInt2 = paramArrayOfChar[paramInt1];
          if (paramInt2 > 127) {
            break label285;
          }
          arrayOfByte = _outputBuffer;
          j = _outputTail;
          _outputTail = (j + 1);
          arrayOfByte[j] = ((byte)paramInt2);
          paramInt1 += 1;
          if (paramInt1 >= i) {
            break;
          }
        }
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramArrayOfChar[paramInt1];
        if (paramInt1 < 2048)
        {
          arrayOfByte = _outputBuffer;
          j = _outputTail;
          _outputTail = (j + 1);
          arrayOfByte[j] = ((byte)(paramInt1 >> 6 | 0xC0));
          arrayOfByte = _outputBuffer;
          j = _outputTail;
          _outputTail = (j + 1);
          arrayOfByte[j] = ((byte)(paramInt1 & 0x3F | 0x80));
          paramInt1 = paramInt2;
        }
        else
        {
          paramInt1 = _outputRawMultiByteChar(paramInt1, paramArrayOfChar, paramInt2, i);
        }
      }
    }
  }
  
  public final void writeStartArray()
    throws IOException
  {
    _verifyValueWrite("start an array");
    _writeContext = _writeContext.createChildArrayContext();
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeStartArray(this);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 91;
  }
  
  public final void writeStartObject()
    throws IOException
  {
    _verifyValueWrite("start an object");
    _writeContext = _writeContext.createChildObjectContext();
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeStartObject(this);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 123;
  }
  
  public final void writeString(String paramString)
    throws IOException
  {
    _verifyValueWrite("write text value");
    if (paramString == null)
    {
      _writeNull();
      return;
    }
    int i = paramString.length();
    if (i > _charBufferLength)
    {
      _writeStringSegments(paramString, true);
      return;
    }
    paramString.getChars(0, i, _charBuffer, 0);
    if (i > _outputMaxContiguous)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      j = _outputTail;
      _outputTail = (j + 1);
      paramString[j] = 34;
      _writeStringSegments(_charBuffer, 0, i);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
      return;
    }
    if (_outputTail + i >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    int j = _outputTail;
    _outputTail = (j + 1);
    paramString[j] = 34;
    _writeStringSegment(_charBuffer, 0, i);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public final void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    _verifyValueWrite("write text value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    byte[] arrayOfByte = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfByte[i] = 34;
    if (paramInt2 <= _outputMaxContiguous)
    {
      if (_outputTail + paramInt2 > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(paramArrayOfChar, paramInt1, paramInt2);
    }
    for (;;)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramArrayOfChar = _outputBuffer;
      paramInt1 = _outputTail;
      _outputTail = (paramInt1 + 1);
      paramArrayOfChar[paramInt1] = '"';
      return;
      _writeStringSegments(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.UTF8JsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */