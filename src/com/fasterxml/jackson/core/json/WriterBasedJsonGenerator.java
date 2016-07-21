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
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class WriterBasedJsonGenerator
  extends JsonGeneratorImpl
{
  protected static final char[] HEX_CHARS = ;
  protected SerializableString _currentEscape;
  protected char[] _entityBuffer;
  protected char[] _outputBuffer;
  protected int _outputEnd;
  protected int _outputHead = 0;
  protected int _outputTail = 0;
  protected final Writer _writer;
  
  public WriterBasedJsonGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, Writer paramWriter)
  {
    super(paramIOContext, paramInt, paramObjectCodec);
    _writer = paramWriter;
    _outputBuffer = paramIOContext.allocConcatBuffer();
    _outputEnd = _outputBuffer.length;
  }
  
  private char[] _allocateEntityBuffer()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '\\';
    arrayOfChar[3] = 'u';
    arrayOfChar[4] = '0';
    arrayOfChar[5] = '0';
    arrayOfChar[8] = '\\';
    arrayOfChar[9] = 'u';
    _entityBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  private void _appendCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    Object localObject;
    if (paramInt >= 0)
    {
      if (_outputTail + 2 > _outputEnd) {
        _flushBuffer();
      }
      localObject = _outputBuffer;
      paramChar = _outputTail;
      _outputTail = (paramChar + '\001');
      localObject[paramChar] = 92;
      localObject = _outputBuffer;
      paramChar = _outputTail;
      _outputTail = (paramChar + '\001');
      localObject[paramChar] = ((char)paramInt);
      return;
    }
    if (paramInt != -2)
    {
      if (_outputTail + 2 > _outputEnd) {
        _flushBuffer();
      }
      paramInt = _outputTail;
      localObject = _outputBuffer;
      int i = paramInt + 1;
      localObject[paramInt] = 92;
      paramInt = i + 1;
      localObject[i] = 117;
      if (paramChar > 'ÿ')
      {
        i = paramChar >> '\b' & 0xFF;
        int j = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(i >> 4)];
        paramInt = j + 1;
        localObject[j] = HEX_CHARS[(i & 0xF)];
        paramChar = (char)(paramChar & 0xFF);
      }
      for (;;)
      {
        i = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
        localObject[i] = HEX_CHARS[(paramChar & 0xF)];
        _outputTail = (i + 1);
        return;
        i = paramInt + 1;
        localObject[paramInt] = 48;
        paramInt = i + 1;
        localObject[i] = 48;
      }
    }
    if (_currentEscape == null) {
      localObject = _characterEscapes.getEscapeSequence$428277ea().getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (_outputTail + paramChar <= _outputEnd) {
        break;
      }
      _flushBuffer();
      if (paramChar <= _outputEnd) {
        break;
      }
      _writer.write((String)localObject);
      return;
      localObject = _currentEscape.getValue();
      _currentEscape = null;
    }
    ((String)localObject).getChars(0, paramChar, _outputBuffer, _outputTail);
    _outputTail += paramChar;
  }
  
  private void _flushBuffer()
    throws IOException
  {
    int i = _outputTail - _outputHead;
    if (i > 0)
    {
      int j = _outputHead;
      _outputHead = 0;
      _outputTail = 0;
      _writer.write(_outputBuffer, j, i);
    }
  }
  
  private int _prependOrWriteCharacterEscape(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
    throws IOException, JsonGenerationException
  {
    Object localObject;
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 2;
        paramArrayOfChar[paramInt1] = '\\';
        paramArrayOfChar[(paramInt1 + 1)] = ((char)paramInt3);
      }
      for (;;)
      {
        return paramInt1;
        localObject = _entityBuffer;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = _allocateEntityBuffer();
        }
        paramArrayOfChar[1] = ((char)paramInt3);
        _writer.write(paramArrayOfChar, 0, 2);
      }
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 6;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '\\';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = 'u';
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramInt3 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramInt2 >> 4)];
          paramInt1 = paramInt3 + 1;
          paramArrayOfChar[paramInt3] = HEX_CHARS[(paramInt2 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[paramInt2] = HEX_CHARS[(paramChar & 0xF)];
          paramInt1 = paramInt2 - 5;
        }
      }
      for (;;)
      {
        return paramInt1;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '0';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = '0';
        break;
        localObject = _entityBuffer;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = _allocateEntityBuffer();
        }
        _outputHead = _outputTail;
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramChar &= 0xFF;
          paramArrayOfChar[10] = HEX_CHARS[(paramInt2 >> 4)];
          paramArrayOfChar[11] = HEX_CHARS[(paramInt2 & 0xF)];
          paramArrayOfChar[12] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[13] = HEX_CHARS[(paramChar & 0xF)];
          _writer.write(paramArrayOfChar, 8, 6);
        }
        else
        {
          paramArrayOfChar[6] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[7] = HEX_CHARS[(paramChar & 0xF)];
          _writer.write(paramArrayOfChar, 2, 6);
        }
      }
    }
    if (_currentEscape == null)
    {
      localObject = _characterEscapes.getEscapeSequence$428277ea().getValue();
      paramChar = ((String)localObject).length();
      if ((paramInt1 < paramChar) || (paramInt1 >= paramInt2)) {
        break label455;
      }
      paramInt1 -= paramChar;
      ((String)localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
    }
    for (;;)
    {
      return paramInt1;
      localObject = _currentEscape.getValue();
      _currentEscape = null;
      break;
      label455:
      _writer.write((String)localObject);
    }
  }
  
  private void _prependOrWriteCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    char[] arrayOfChar;
    Object localObject;
    if (paramInt >= 0)
    {
      if (_outputTail >= 2)
      {
        paramChar = _outputTail - 2;
        _outputHead = paramChar;
        _outputBuffer[paramChar] = '\\';
        _outputBuffer[(paramChar + '\001')] = ((char)paramInt);
        return;
      }
      arrayOfChar = _entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      localObject[1] = ((char)paramInt);
      _writer.write((char[])localObject, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      if (_outputTail >= 6)
      {
        localObject = _outputBuffer;
        paramInt = _outputTail - 6;
        _outputHead = paramInt;
        localObject[paramInt] = 92;
        paramInt += 1;
        localObject[paramInt] = 117;
        if (paramChar > 'ÿ')
        {
          int i = paramChar >> '\b' & 0xFF;
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i >> 4)];
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        for (;;)
        {
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
          localObject[(paramInt + 1)] = HEX_CHARS[(paramChar & 0xF)];
          return;
          paramInt += 1;
          localObject[paramInt] = 48;
          paramInt += 1;
          localObject[paramInt] = 48;
        }
      }
      arrayOfChar = _entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      if (paramChar > 'ÿ')
      {
        paramInt = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        localObject[10] = HEX_CHARS[(paramInt >> 4)];
        localObject[11] = HEX_CHARS[(paramInt & 0xF)];
        localObject[12] = HEX_CHARS[(paramChar >> '\004')];
        localObject[13] = HEX_CHARS[(paramChar & 0xF)];
        _writer.write((char[])localObject, 8, 6);
        return;
      }
      localObject[6] = HEX_CHARS[(paramChar >> '\004')];
      localObject[7] = HEX_CHARS[(paramChar & 0xF)];
      _writer.write((char[])localObject, 2, 6);
      return;
    }
    if (_currentEscape == null) {
      localObject = _characterEscapes.getEscapeSequence$428277ea().getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (_outputTail < paramChar) {
        break;
      }
      paramInt = _outputTail - paramChar;
      _outputHead = paramInt;
      ((String)localObject).getChars(0, paramChar, _outputBuffer, paramInt);
      return;
      localObject = _currentEscape.getValue();
      _currentEscape = null;
    }
    _outputHead = _outputTail;
    _writer.write((String)localObject);
  }
  
  private final void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    char[] arrayOfChar = _outputBuffer;
    arrayOfChar[i] = 'n';
    i += 1;
    arrayOfChar[i] = 'u';
    i += 1;
    arrayOfChar[i] = 'l';
    i += 1;
    arrayOfChar[i] = 'l';
    _outputTail = (i + 1);
  }
  
  private void _writeQuotedRaw(String paramString)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    writeRaw(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  private void _writeString(String paramString)
    throws IOException
  {
    int i1 = paramString.length();
    int i9;
    int i3;
    if (i1 > _outputEnd)
    {
      _flushBuffer();
      i9 = paramString.length();
      i3 = 0;
    }
    for (;;)
    {
      i1 = _outputEnd;
      int i4 = i1;
      if (i3 + i1 > i9) {
        i4 = i9 - i3;
      }
      paramString.getChars(i3, i3 + i4, _outputBuffer, 0);
      Object localObject1;
      int i5;
      int i10;
      Object localObject2;
      int i2;
      int i6;
      label116:
      int i8;
      label126:
      int i7;
      if (_characterEscapes != null)
      {
        localObject1 = _outputEscapes;
        int i;
        if (_maximumNonEscapedChar <= 0)
        {
          i5 = 65535;
          i10 = Math.min(localObject1.length, i5 + 1);
          localObject2 = _characterEscapes;
          i2 = 0;
          i6 = 0;
          i1 = 0;
          if (i2 >= i4) {
            break label571;
          }
          i8 = i1;
          i = _outputBuffer[i2];
          if (i >= i10) {
            break label217;
          }
          i1 = localObject1[i];
          if (i1 == 0) {
            break label255;
          }
        }
        for (;;)
        {
          i7 = i2 - i6;
          if (i7 > 0)
          {
            _writer.write(_outputBuffer, i6, i7);
            if (i2 >= i4) {
              break label571;
            }
          }
          i2 += 1;
          i6 = _prependOrWriteCharacterEscape(_outputBuffer, i2, i4, i, i1);
          break label116;
          i5 = _maximumNonEscapedChar;
          break;
          label217:
          if (i > i5)
          {
            i1 = -1;
          }
          else
          {
            SerializableString localSerializableString = ((CharacterEscapes)localObject2).getEscapeSequence$428277ea();
            _currentEscape = localSerializableString;
            i1 = i8;
            if (localSerializableString != null)
            {
              i1 = -2;
            }
            else
            {
              label255:
              i7 = i2 + 1;
              i8 = i1;
              i2 = i7;
              if (i7 < i4) {
                break label126;
              }
              i2 = i7;
            }
          }
        }
      }
      else if (_maximumNonEscapedChar != 0)
      {
        i8 = _maximumNonEscapedChar;
        localObject1 = _outputEscapes;
        i10 = Math.min(localObject1.length, i8 + 1);
        i2 = 0;
        i5 = 0;
        i1 = 0;
        if (i2 < i4)
        {
          i7 = i1;
          label331:
          int j = _outputBuffer[i2];
          if (j < i10)
          {
            i1 = localObject1[j];
            if (i1 == 0) {
              break label427;
            }
          }
          for (;;)
          {
            i6 = i2 - i5;
            if (i6 > 0)
            {
              _writer.write(_outputBuffer, i5, i6);
              if (i2 >= i4) {
                break label571;
              }
            }
            i2 += 1;
            i5 = _prependOrWriteCharacterEscape(_outputBuffer, i2, i4, j, i1);
            break;
            i1 = i7;
            if (j > i8)
            {
              i1 = -1;
            }
            else
            {
              label427:
              i6 = i2 + 1;
              i7 = i1;
              i2 = i6;
              if (i6 < i4) {
                break label331;
              }
              i2 = i6;
            }
          }
        }
      }
      else
      {
        localObject1 = _outputEscapes;
        i6 = localObject1.length;
        i2 = 0;
        i1 = 0;
        while (i1 < i4)
        {
          int k;
          do
          {
            k = _outputBuffer[i1];
            if (k < i6)
            {
              i5 = i1;
              if (localObject1[k] != 0) {
                break;
              }
            }
            i5 = i1 + 1;
            i1 = i5;
          } while (i5 < i4);
          i1 = i5 - i2;
          if (i1 > 0)
          {
            _writer.write(_outputBuffer, i2, i1);
            if (i5 >= i4) {
              break;
            }
          }
          i1 = i5 + 1;
          i2 = _prependOrWriteCharacterEscape(_outputBuffer, i1, i4, k, localObject1[k]);
        }
      }
      label571:
      i3 += i4;
      if (i3 >= i9) {
        label648:
        label665:
        label794:
        label850:
        label946:
        label1037:
        label1105:
        for (;;)
        {
          return;
          if (_outputTail + i1 > _outputEnd) {
            _flushBuffer();
          }
          paramString.getChars(0, i1, _outputBuffer, _outputTail);
          if (_characterEscapes != null)
          {
            i3 = _outputTail + i1;
            paramString = _outputEscapes;
            if (_maximumNonEscapedChar <= 0)
            {
              i2 = 65535;
              i4 = Math.min(paramString.length, i2 + 1);
              localObject1 = _characterEscapes;
              if (_outputTail >= i3) {}
            }
            do
            {
              int m = _outputBuffer[_outputTail];
              if (m < i4)
              {
                i1 = paramString[m];
                if (i1 == 0) {}
              }
              else
              {
                for (;;)
                {
                  i5 = _outputTail - _outputHead;
                  if (i5 > 0) {
                    _writer.write(_outputBuffer, _outputHead, i5);
                  }
                  _outputTail += 1;
                  _prependOrWriteCharacterEscape(m, i1);
                  break label665;
                  break;
                  i2 = _maximumNonEscapedChar;
                  break label648;
                  if (m > i2)
                  {
                    i1 = -1;
                  }
                  else
                  {
                    localObject2 = ((CharacterEscapes)localObject1).getEscapeSequence$428277ea();
                    _currentEscape = ((SerializableString)localObject2);
                    if (localObject2 == null) {
                      break label794;
                    }
                    i1 = -2;
                  }
                }
              }
              i1 = _outputTail + 1;
              _outputTail = i1;
            } while (i1 < i3);
            return;
          }
          if (_maximumNonEscapedChar != 0)
          {
            i2 = _maximumNonEscapedChar;
            i3 = _outputTail + i1;
            paramString = _outputEscapes;
            i4 = Math.min(paramString.length, i2 + 1);
            if (_outputTail < i3) {}
            do
            {
              int n = _outputBuffer[_outputTail];
              if (n < i4)
              {
                i1 = paramString[n];
                if (i1 == 0) {}
              }
              else
              {
                for (;;)
                {
                  i5 = _outputTail - _outputHead;
                  if (i5 > 0) {
                    _writer.write(_outputBuffer, _outputHead, i5);
                  }
                  _outputTail += 1;
                  _prependOrWriteCharacterEscape(n, i1);
                  break label850;
                  break;
                  if (n <= i2) {
                    break label946;
                  }
                  i1 = -1;
                }
              }
              i1 = _outputTail + 1;
              _outputTail = i1;
            } while (i1 < i3);
            return;
          }
          i1 = _outputTail + i1;
          paramString = _outputEscapes;
          i2 = paramString.length;
          for (;;)
          {
            if (_outputTail >= i1) {
              break label1105;
            }
            for (;;)
            {
              i3 = _outputBuffer[_outputTail];
              if ((i3 < i2) && (paramString[i3] != 0)) {
                break label1037;
              }
              i3 = _outputTail + 1;
              _outputTail = i3;
              if (i3 >= i1) {
                break;
              }
            }
            i3 = _outputTail - _outputHead;
            if (i3 > 0) {
              _writer.write(_outputBuffer, _outputHead, i3);
            }
            localObject1 = _outputBuffer;
            i3 = _outputTail;
            _outputTail = (i3 + 1);
            char c = localObject1[i3];
            _prependOrWriteCharacterEscape(c, paramString[c]);
          }
        }
      }
    }
  }
  
  protected final void _releaseBuffers()
  {
    char[] arrayOfChar = _outputBuffer;
    if (arrayOfChar != null)
    {
      _outputBuffer = null;
      _ioContext.releaseConcatBuffer(arrayOfChar);
    }
  }
  
  protected final void _verifyValueWrite(String paramString)
    throws IOException
  {
    int j;
    if (_cfgPrettyPrinter != null)
    {
      j = _writeContext.writeValue();
      if (j == 5) {
        _reportError("Can not " + paramString + ", expecting field name");
      }
      switch (j)
      {
      default: 
        VersionUtil.throwInternal();
      }
    }
    do
    {
      do
      {
        return;
        _cfgPrettyPrinter.writeArrayValueSeparator(this);
        return;
        _cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
        return;
        _cfgPrettyPrinter.writeRootValueSeparator(this);
        return;
        if (_writeContext.inArray())
        {
          _cfgPrettyPrinter.beforeArrayValues(this);
          return;
        }
      } while (!_writeContext.inObject());
      _cfgPrettyPrinter.beforeObjectEntries(this);
      return;
      j = _writeContext.writeValue();
      if (j == 5) {
        _reportError("Can not " + paramString + ", expecting field name");
      }
      switch (j)
      {
      default: 
        return;
      case 1: 
      case 2: 
        for (int i = 44;; i = 58)
        {
          if (_outputTail >= _outputEnd) {
            _flushBuffer();
          }
          _outputBuffer[_outputTail] = i;
          _outputTail += 1;
          return;
        }
      }
    } while (_rootValueSeparator == null);
    writeRaw(_rootValueSeparator.getValue());
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
    if (_writer != null)
    {
      if ((!_ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        break label97;
      }
      _writer.close();
    }
    for (;;)
    {
      _releaseBuffers();
      return;
      label97:
      if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        _writer.flush();
      }
    }
  }
  
  public final void flush()
    throws IOException
  {
    _flushBuffer();
    if ((_writer != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _writer.flush();
    }
  }
  
  public final void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    _verifyValueWrite("write boolean value");
    if (_outputTail + 5 >= _outputEnd) {
      _flushBuffer();
    }
    int i = _outputTail;
    char[] arrayOfChar = _outputBuffer;
    if (paramBoolean)
    {
      arrayOfChar[i] = 't';
      i += 1;
      arrayOfChar[i] = 'r';
      i += 1;
      arrayOfChar[i] = 'u';
      i += 1;
      arrayOfChar[i] = 'e';
    }
    for (;;)
    {
      _outputTail = (i + 1);
      return;
      arrayOfChar[i] = 'f';
      i += 1;
      arrayOfChar[i] = 'a';
      i += 1;
      arrayOfChar[i] = 'l';
      i += 1;
      arrayOfChar[i] = 's';
      i += 1;
      arrayOfChar[i] = 'e';
    }
  }
  
  public final void writeEndArray()
    throws IOException, JsonGenerationException
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
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = ']';
    }
  }
  
  public final void writeEndObject()
    throws IOException, JsonGenerationException
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
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '}';
    }
  }
  
  public final void writeFieldName(String paramString)
    throws IOException
  {
    int i = 1;
    int j = _writeContext.writeFieldName(paramString);
    if (j == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (j == 1)
    {
      if (_cfgPrettyPrinter == null) {
        break label164;
      }
      if (i == 0) {
        break label145;
      }
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    for (;;)
    {
      if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
        break label158;
      }
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      arrayOfChar = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _writeString(paramString);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      paramString = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      paramString[i] = 34;
      return;
      i = 0;
      break;
      label145:
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    label158:
    _writeString(paramString);
    return;
    label164:
    if (_outputTail + 1 >= _outputEnd) {
      _flushBuffer();
    }
    if (i != 0)
    {
      arrayOfChar = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeString(paramString);
      return;
    }
    char[] arrayOfChar = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramString = _outputBuffer;
    i = _outputTail;
    _outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public final void writeNull()
    throws IOException
  {
    _verifyValueWrite("write null value");
    _writeNull();
  }
  
  public final void writeNumber(double paramDouble)
    throws IOException
  {
    if ((_cfgNumbersAsStrings) || ((isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) && ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))))
    {
      writeString(String.valueOf(paramDouble));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramDouble));
  }
  
  public final void writeNumber(float paramFloat)
    throws IOException
  {
    if ((_cfgNumbersAsStrings) || ((isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) && ((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat)))))
    {
      writeString(String.valueOf(paramFloat));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramFloat));
  }
  
  public final void writeNumber(int paramInt)
    throws IOException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      if (_outputTail + 13 >= _outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _outputTail = NumberOutput.outputInt(paramInt, _outputBuffer, _outputTail);
      arrayOfChar = _outputBuffer;
      paramInt = _outputTail;
      _outputTail = (paramInt + 1);
      arrayOfChar[paramInt] = '"';
      return;
    }
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputInt(paramInt, _outputBuffer, _outputTail);
  }
  
  public final void writeNumber(long paramLong)
    throws IOException
  {
    _verifyValueWrite("write number");
    if (_cfgNumbersAsStrings)
    {
      if (_outputTail + 23 >= _outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = _outputBuffer;
      int i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _outputTail = NumberOutput.outputLong(paramLong, _outputBuffer, _outputTail);
      arrayOfChar = _outputBuffer;
      i = _outputTail;
      _outputTail = (i + 1);
      arrayOfChar[i] = '"';
      return;
    }
    if (_outputTail + 21 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputLong(paramLong, _outputBuffer, _outputTail);
  }
  
  public final void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
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
    throws IOException
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
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public final void writeRaw(SerializableString paramSerializableString)
    throws IOException
  {
    writeRaw(paramSerializableString.getValue());
  }
  
  public final void writeRaw(String paramString)
    throws IOException
  {
    int k = paramString.length();
    int j = _outputEnd - _outputTail;
    int i = j;
    if (j == 0)
    {
      _flushBuffer();
      i = _outputEnd - _outputTail;
    }
    if (i >= k)
    {
      paramString.getChars(0, k, _outputBuffer, _outputTail);
      _outputTail += k;
      return;
    }
    j = _outputEnd - _outputTail;
    paramString.getChars(0, j, _outputBuffer, _outputTail);
    _outputTail += j;
    _flushBuffer();
    i = paramString.length() - j;
    while (i > _outputEnd)
    {
      k = _outputEnd;
      paramString.getChars(j, j + k, _outputBuffer, 0);
      _outputHead = 0;
      _outputTail = k;
      _flushBuffer();
      j += k;
      i -= k;
    }
    paramString.getChars(j, j + i, _outputBuffer, 0);
    _outputHead = 0;
    _outputTail = i;
  }
  
  public final void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 32)
    {
      if (paramInt2 > _outputEnd - _outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramArrayOfChar, 0, _outputBuffer, _outputTail, paramInt2);
      _outputTail += paramInt2;
      return;
    }
    _flushBuffer();
    _writer.write(paramArrayOfChar, 0, paramInt2);
  }
  
  public final void writeStartArray()
    throws IOException, JsonGenerationException
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
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '[';
  }
  
  public final void writeStartObject()
    throws IOException, JsonGenerationException
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
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '{';
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
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = _outputBuffer;
    int i = _outputTail;
    _outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
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
    Object localObject = _outputBuffer;
    int j = _outputTail;
    _outputTail = (j + 1);
    localObject[j] = 34;
    int i1;
    int k;
    int i2;
    label104:
    int n;
    label116:
    int i;
    int m;
    if (_characterEscapes != null)
    {
      i1 = paramInt2 + paramInt1;
      localObject = _outputEscapes;
      CharacterEscapes localCharacterEscapes;
      if (_maximumNonEscapedChar <= 0)
      {
        k = 65535;
        i2 = Math.min(localObject.length, k + 1);
        localCharacterEscapes = _characterEscapes;
        j = 0;
        paramInt2 = paramInt1;
        paramInt1 = j;
        if (paramInt2 >= i1) {
          break label722;
        }
        j = paramInt2;
        n = paramInt1;
        i = paramArrayOfChar[j];
        if (i >= i2) {
          break label240;
        }
        m = localObject[i];
        paramInt1 = m;
        if (m == 0) {
          break label279;
        }
        paramInt1 = m;
        label147:
        m = j - paramInt2;
        if (m >= 32) {
          break label306;
        }
        if (_outputTail + m > _outputEnd) {
          _flushBuffer();
        }
        if (m > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, _outputBuffer, _outputTail, m);
          _outputTail += m;
        }
      }
      for (;;)
      {
        if (j >= i1) {
          break label722;
        }
        paramInt2 = j + 1;
        _appendCharacterEscape(i, paramInt1);
        break label104;
        k = _maximumNonEscapedChar;
        break;
        label240:
        if (i > k)
        {
          paramInt1 = -1;
          break label147;
        }
        SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence$428277ea();
        _currentEscape = localSerializableString;
        paramInt1 = n;
        if (localSerializableString != null)
        {
          paramInt1 = -2;
          break label147;
        }
        label279:
        m = j + 1;
        n = paramInt1;
        j = m;
        if (m < i1) {
          break label116;
        }
        j = m;
        break label147;
        label306:
        _flushBuffer();
        _writer.write(paramArrayOfChar, paramInt2, m);
      }
    }
    else if (_maximumNonEscapedChar != 0)
    {
      n = _maximumNonEscapedChar;
      i1 = paramInt2 + paramInt1;
      localObject = _outputEscapes;
      i2 = Math.min(localObject.length, n + 1);
      j = 0;
      paramInt2 = paramInt1;
      paramInt1 = j;
      if (paramInt2 < i1)
      {
        j = paramInt2;
        m = paramInt1;
        label380:
        i = paramArrayOfChar[j];
        if (i < i2)
        {
          k = localObject[i];
          paramInt1 = k;
          if (k == 0) {
            break label510;
          }
          paramInt1 = k;
          label411:
          k = j - paramInt2;
          if (k >= 32) {
            break label537;
          }
          if (_outputTail + k > _outputEnd) {
            _flushBuffer();
          }
          if (k > 0)
          {
            System.arraycopy(paramArrayOfChar, paramInt2, _outputBuffer, _outputTail, k);
            _outputTail += k;
          }
        }
        for (;;)
        {
          if (j >= i1) {
            break label722;
          }
          paramInt2 = j + 1;
          _appendCharacterEscape(i, paramInt1);
          break;
          paramInt1 = m;
          if (i > n)
          {
            paramInt1 = -1;
            break label411;
          }
          label510:
          k = j + 1;
          m = paramInt1;
          j = k;
          if (k < i1) {
            break label380;
          }
          j = k;
          break label411;
          label537:
          _flushBuffer();
          _writer.write(paramArrayOfChar, paramInt2, k);
        }
      }
    }
    else
    {
      k = paramInt2 + paramInt1;
      localObject = _outputEscapes;
      m = localObject.length;
      if (paramInt1 < k)
      {
        paramInt2 = paramInt1;
        do
        {
          n = paramArrayOfChar[paramInt2];
          if (n < m)
          {
            j = paramInt2;
            if (localObject[n] != 0) {
              break;
            }
          }
          j = paramInt2 + 1;
          paramInt2 = j;
        } while (j < k);
        paramInt2 = j - paramInt1;
        if (paramInt2 < 32)
        {
          if (_outputTail + paramInt2 > _outputEnd) {
            _flushBuffer();
          }
          if (paramInt2 > 0)
          {
            System.arraycopy(paramArrayOfChar, paramInt1, _outputBuffer, _outputTail, paramInt2);
            _outputTail += paramInt2;
          }
        }
        for (;;)
        {
          if (j >= k) {
            break label722;
          }
          paramInt1 = j + 1;
          i = paramArrayOfChar[j];
          _appendCharacterEscape(i, localObject[i]);
          break;
          _flushBuffer();
          _writer.write(paramArrayOfChar, paramInt1, paramInt2);
        }
      }
    }
    label722:
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = _outputBuffer;
    paramInt1 = _outputTail;
    _outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.WriterBasedJsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */