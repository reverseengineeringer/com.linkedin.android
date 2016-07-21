package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.sym.Name1;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class UTF8StreamJsonParser
  extends ParserBase
{
  protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
  private static final int[] _icUTF8 = ;
  protected boolean _bufferRecyclable;
  protected byte[] _inputBuffer;
  protected InputStream _inputStream;
  protected ObjectCodec _objectCodec;
  private int _quad1;
  protected int[] _quadBuffer = new int[16];
  protected final BytesToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public UTF8StreamJsonParser(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    _inputStream = paramInputStream;
    _objectCodec = paramObjectCodec;
    _symbols = paramBytesToNameCanonicalizer;
    _inputBuffer = paramArrayOfByte;
    _inputPtr = paramInt2;
    _inputEnd = paramInt3;
    _currInputRowStart = paramInt2;
    _currInputProcessed = (-paramInt2);
    _bufferRecyclable = paramBoolean;
  }
  
  private final void _checkMatchEnd(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (Character.isJavaIdentifierPart((char)_decodeCharForError(paramInt2))) {
      _reportInvalidToken(paramString.substring(0, paramInt1), "'null', 'true', 'false' or NaN");
    }
  }
  
  private int _decodeCharForError(int paramInt)
    throws IOException
  {
    paramInt &= 0xFF;
    int i = paramInt;
    if (paramInt > 127)
    {
      if ((paramInt & 0xE0) != 192) {
        break label153;
      }
      i = paramInt & 0x1F;
      paramInt = 1;
    }
    for (;;)
    {
      int j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      j = i << 6 | j & 0x3F;
      i = j;
      if (paramInt > 1)
      {
        i = nextByte();
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i & 0xFF);
        }
        j = j << 6 | i & 0x3F;
        i = j;
        if (paramInt > 2)
        {
          paramInt = nextByte();
          if ((paramInt & 0xC0) != 128) {
            _reportInvalidOther(paramInt & 0xFF);
          }
          i = j << 6 | paramInt & 0x3F;
        }
      }
      return i;
      label153:
      if ((paramInt & 0xF0) == 224)
      {
        i = paramInt & 0xF;
        paramInt = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        i = paramInt & 0x7;
        paramInt = 3;
      }
      else
      {
        _reportInvalidInitial(paramInt & 0xFF);
        j = 1;
        i = paramInt;
        paramInt = j;
      }
    }
  }
  
  private final int _decodeUtf8_2(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    return (paramInt & 0x1F) << 6 | i & 0x3F;
  }
  
  private final int _decodeUtf8_3(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_3fast(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_4(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int k = _inputPtr;
    _inputPtr = (k + 1);
    k = arrayOfByte[k];
    if ((k & 0xC0) != 128) {
      _reportInvalidOther(k & 0xFF, _inputPtr);
    }
    return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = paramInt;
    if (paramInt == 73)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in a value");
      }
      Object localObject = _inputBuffer;
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt == 78) {
        if (paramBoolean)
        {
          localObject = "-INF";
          _matchToken((String)localObject, 3);
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label144;
          }
          if (!paramBoolean) {
            break label137;
          }
        }
      }
      label137:
      for (double d = Double.NEGATIVE_INFINITY;; d = Double.POSITIVE_INFINITY)
      {
        return resetAsNaN((String)localObject, d);
        localObject = "+INF";
        break;
        i = paramInt;
        if (paramInt != 110) {
          break label171;
        }
        if (paramBoolean) {}
        for (localObject = "-Infinity";; localObject = "+Infinity") {
          break;
        }
      }
      label144:
      throw _constructError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
    }
    label171:
    reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    return null;
  }
  
  private Name _handleOddName(int paramInt)
    throws IOException
  {
    Object localObject1;
    int k;
    int j;
    int i;
    Object localObject3;
    label133:
    Object localObject2;
    label189:
    int m;
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)))
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing ''' for name");
      }
      localObject1 = _inputBuffer;
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      k = localObject1[paramInt] & 0xFF;
      if (k == 39) {
        return Name1.getEmptyName();
      }
      localObject1 = _quadBuffer;
      paramInt = 0;
      j = 0;
      i = 0;
      localObject3 = _icLatin1;
      if (k != 39)
      {
        if ((k == 34) || (localObject3[k] == 0)) {
          break label856;
        }
        if (k != 92)
        {
          _throwUnquotedSpace(k, "name");
          if (k <= 127) {
            break label841;
          }
          if (i < 4) {
            break label838;
          }
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = j;
          i = 0;
          paramInt += 1;
          j = 0;
          localObject1 = localObject2;
          if (k >= 2048) {
            break label331;
          }
          i += 1;
          j = k >> 6 | 0xC0 | j << 8;
          m = k & 0x3F | 0x80;
          k = j;
          j = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      if (j < 4)
      {
        i |= k << 8;
        j += 1;
        label252:
        if ((_inputPtr >= _inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject2 = _inputBuffer;
        k = _inputPtr;
        _inputPtr = (k + 1);
        k = localObject2[k];
        k &= 0xFF;
        m = i;
        i = j;
        j = m;
        break;
        k = _decodeEscaped();
        break label133;
        label331:
        j = k >> 12 | 0xE0 | j << 8;
        i += 1;
        if (i < 4) {
          break label835;
        }
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          _quadBuffer = ((int[])localObject2);
        }
        localObject2[paramInt] = j;
        j = 0;
        paramInt += 1;
        localObject1 = localObject2;
        i = 0;
      }
      label745:
      label835:
      for (;;)
      {
        j = j << 8 | k >> 6 & 0x3F | 0x80;
        i += 1;
        break;
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          _quadBuffer = ((int[])localObject2);
        }
        localObject2[paramInt] = k;
        localObject1 = localObject2;
        j = 1;
        paramInt += 1;
        break label252;
        if (i > 0)
        {
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = pad(j, i);
          localObject1 = localObject2;
          paramInt += 1;
        }
        for (;;)
        {
          localObject2 = _symbols.findName((int[])localObject1, paramInt);
          if (localObject2 == null)
          {
            return addName((int[])localObject1, paramInt, i);
            if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
              _reportUnexpectedChar((char)_decodeCharForError(paramInt), "was expecting double-quote to start field name");
            }
            localObject3 = CharTypes.getInputCodeUtf8JsNames();
            if (localObject3[paramInt] != 0) {
              _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            }
            localObject1 = _quadBuffer;
            j = 0;
            k = 0;
            m = 0;
            i = paramInt;
            paramInt = m;
            if (k < 4)
            {
              k += 1;
              j = j << 8 | i;
              i = k;
            }
            for (;;)
            {
              if ((_inputPtr >= _inputEnd) && (!loadMore())) {
                _reportInvalidEOF(" in field name");
              }
              m = _inputBuffer[_inputPtr] & 0xFF;
              if (localObject3[m] != 0) {
                break label745;
              }
              _inputPtr += 1;
              k = i;
              i = m;
              break;
              localObject2 = localObject1;
              if (paramInt >= localObject1.length)
              {
                localObject2 = growArrayBy((int[])localObject1, localObject1.length);
                _quadBuffer = ((int[])localObject2);
              }
              k = paramInt + 1;
              localObject2[paramInt] = j;
              paramInt = 1;
              j = i;
              i = paramInt;
              paramInt = k;
              localObject1 = localObject2;
            }
            k = paramInt;
            localObject2 = localObject1;
            if (i > 0)
            {
              localObject2 = localObject1;
              if (paramInt >= localObject1.length)
              {
                localObject2 = growArrayBy((int[])localObject1, localObject1.length);
                _quadBuffer = ((int[])localObject2);
              }
              localObject2[paramInt] = j;
              k = paramInt + 1;
            }
            localObject3 = _symbols.findName((int[])localObject2, k);
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = addName((int[])localObject2, k, i);
            }
            return (Name)localObject1;
          }
          return (Name)localObject2;
        }
      }
      label838:
      break label189;
      label841:
      m = k;
      k = j;
      j = i;
      i = m;
      continue;
      label856:
      m = j;
      j = i;
      i = k;
      k = m;
    }
  }
  
  private JsonToken _handleUnexpectedValue(int paramInt)
    throws IOException
  {
    Object localObject2;
    int[] arrayOfInt;
    byte[] arrayOfByte;
    Object localObject1;
    int i;
    int j;
    switch (paramInt)
    {
    default: 
    case 93: 
    case 125: 
    case 39: 
      do
      {
        if (Character.isJavaIdentifierStart(paramInt)) {
          _reportInvalidToken((char)paramInt, "('true', 'false' or 'null')");
        }
        _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
        _reportUnexpectedChar(paramInt, "expected a value");
      } while (!isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES));
      localObject2 = _textBuffer.emptyAndGetCurrentSegment();
      arrayOfInt = _icUTF8;
      arrayOfByte = _inputBuffer;
      paramInt = 0;
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject1 = localObject2;
      i = paramInt;
      if (paramInt >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        i = 0;
      }
      j = _inputEnd;
      paramInt = _inputPtr + (localObject1.length - i);
      if (paramInt < j) {
        j = paramInt;
      }
      break;
    }
    for (;;)
    {
      localObject2 = localObject1;
      paramInt = i;
      if (_inputPtr >= j) {
        break;
      }
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      paramInt = arrayOfByte[paramInt] & 0xFF;
      if ((paramInt != 39) && (arrayOfInt[paramInt] == 0))
      {
        localObject1[i] = ((char)paramInt);
        i += 1;
      }
      else
      {
        if (paramInt != 39)
        {
          switch (arrayOfInt[paramInt])
          {
          default: 
            if (paramInt < 32) {
              _throwUnquotedSpace(paramInt, "string value");
            }
            _reportInvalidChar(paramInt);
          }
          for (;;)
          {
            if (i >= localObject1.length)
            {
              localObject1 = _textBuffer.finishCurrentSegment();
              i = 0;
              label341:
              j = i + 1;
              localObject1[i] = ((char)paramInt);
              localObject2 = localObject1;
              paramInt = j;
              break;
              if (paramInt != 39)
              {
                paramInt = _decodeEscaped();
                continue;
                paramInt = _decodeUtf8_2(paramInt);
                continue;
                if (_inputEnd - _inputPtr >= 2)
                {
                  paramInt = _decodeUtf8_3fast(paramInt);
                }
                else
                {
                  paramInt = _decodeUtf8_3(paramInt);
                  continue;
                  j = _decodeUtf8_4(paramInt);
                  paramInt = i + 1;
                  localObject1[i] = ((char)(0xD800 | j >> 10));
                  if (paramInt < localObject1.length) {
                    break label613;
                  }
                  localObject1 = _textBuffer.finishCurrentSegment();
                }
              }
            }
          }
        }
        label613:
        for (i = 0;; i = paramInt)
        {
          paramInt = 0xDC00 | j & 0x3FF;
          break;
          _textBuffer._currentSize = i;
          return JsonToken.VALUE_STRING;
          _matchToken("NaN", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("NaN", NaN.0D);
          }
          throw _constructError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
          _matchToken("Infinity", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("Infinity", Double.POSITIVE_INFINITY);
          }
          throw _constructError("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            _reportInvalidEOF(" in a value");
          }
          localObject1 = _inputBuffer;
          paramInt = _inputPtr;
          _inputPtr = (paramInt + 1);
          return _handleInvalidNumberStart(localObject1[paramInt] & 0xFF, false);
          break label341;
        }
      }
    }
  }
  
  private void _matchToken(String paramString, int paramInt)
    throws IOException
  {
    int j = paramString.length();
    int i = paramInt;
    if (_inputPtr + j >= _inputEnd)
    {
      j = paramString.length();
      do
      {
        if (((_inputPtr >= _inputEnd) && (!loadMore())) || (_inputBuffer[_inputPtr] != paramString.charAt(paramInt))) {
          _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
        }
        _inputPtr += 1;
        i = paramInt + 1;
        paramInt = i;
      } while (i < j);
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        paramInt = _inputBuffer[_inputPtr] & 0xFF;
        if ((paramInt >= 48) && (paramInt != 93) && (paramInt != 125)) {
          _checkMatchEnd(paramString, i, paramInt);
        }
      }
    }
    do
    {
      return;
      do
      {
        if (_inputBuffer[_inputPtr] != paramString.charAt(i)) {
          _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
        }
        _inputPtr += 1;
        paramInt = i + 1;
        i = paramInt;
      } while (paramInt < j);
      i = _inputBuffer[_inputPtr] & 0xFF;
    } while ((i < 48) || (i == 93) || (i == 125));
    _checkMatchEnd(paramString, paramInt, i);
  }
  
  private final JsonToken _parseFloat(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException
  {
    int i1 = 0;
    int n = 0;
    int i = 0;
    int i2 = 0;
    Object localObject = paramArrayOfChar;
    int j = paramInt1;
    int k = paramInt2;
    if (paramInt2 == 46)
    {
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      paramInt1 += 1;
      m = paramInt2;
      paramInt2 = n;
      if ((_inputPtr < _inputEnd) || (loadMore())) {
        break label493;
      }
      n = 1;
      label63:
      i = n;
      i1 = paramInt2;
      localObject = paramArrayOfChar;
      j = paramInt1;
      k = m;
      if (paramInt2 == 0)
      {
        reportUnexpectedNumberChar(m, "Decimal point not followed by a digit");
        k = m;
        j = paramInt1;
        localObject = paramArrayOfChar;
        i1 = paramInt2;
        i = n;
      }
    }
    int m = 0;
    n = 0;
    int i3;
    if (k != 101)
    {
      paramInt1 = i;
      i2 = j;
      i3 = k;
      if (k != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      paramInt2 = j;
      if (j >= localObject.length)
      {
        paramArrayOfChar = _textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      paramInt1 = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)k);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      if ((paramInt2 != 45) && (paramInt2 != 43)) {
        break label643;
      }
      if (paramInt1 < paramArrayOfChar.length) {
        break label640;
      }
      paramArrayOfChar = _textBuffer.finishCurrentSegment();
      paramInt1 = 0;
      label245:
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      paramInt1 += 1;
      m = n;
    }
    for (;;)
    {
      n = i;
      k = m;
      j = paramInt1;
      if (paramInt2 <= 57)
      {
        n = i;
        k = m;
        j = paramInt1;
        if (paramInt2 >= 48)
        {
          k = m + 1;
          localObject = paramArrayOfChar;
          j = paramInt1;
          if (paramInt1 >= paramArrayOfChar.length)
          {
            localObject = _textBuffer.finishCurrentSegment();
            j = 0;
          }
          paramInt1 = j + 1;
          localObject[j] = ((char)paramInt2);
          if ((_inputPtr < _inputEnd) || (loadMore())) {
            break label605;
          }
          n = 1;
          j = paramInt1;
        }
      }
      paramInt1 = n;
      m = k;
      i2 = j;
      i3 = paramInt2;
      if (k == 0)
      {
        reportUnexpectedNumberChar(paramInt2, "Exponent indicator not followed by a digit");
        i3 = paramInt2;
        i2 = j;
        m = k;
        paramInt1 = n;
      }
      if (paramInt1 == 0)
      {
        _inputPtr -= 1;
        if (_parsingContext.inRoot()) {
          _verifyRootSpace(i3);
        }
      }
      _textBuffer._currentSize = i2;
      return resetFloat(paramBoolean, paramInt3, i1, m);
      label493:
      localObject = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      n = i2;
      m = i;
      if (i < 48) {
        break label63;
      }
      n = i2;
      m = i;
      if (i > 57) {
        break label63;
      }
      j = paramInt2 + 1;
      localObject = paramArrayOfChar;
      paramInt2 = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = _textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      localObject[paramInt2] = ((char)i);
      paramInt1 = paramInt2 + 1;
      paramInt2 = j;
      paramArrayOfChar = (char[])localObject;
      m = i;
      break;
      label605:
      paramArrayOfChar = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = paramArrayOfChar[paramInt2] & 0xFF;
      m = k;
      paramArrayOfChar = (char[])localObject;
      continue;
      label640:
      break label245;
      label643:
      m = n;
    }
  }
  
  private JsonToken _parseNegNumber()
    throws IOException
  {
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    arrayOfChar[0] = '-';
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    if ((j < 48) || (j > 57)) {
      return _handleInvalidNumberStart(j, true);
    }
    i = j;
    if (j == 48) {
      i = _verifyNoLeadingZeroes();
    }
    int m = 0 + 1 + 1;
    arrayOfChar[1] = ((char)i);
    int n = 1;
    int i1 = _inputPtr + arrayOfChar.length - 2;
    j = m;
    int k = n;
    i = i1;
    if (i1 > _inputEnd)
    {
      i = _inputEnd;
      k = n;
      j = m;
    }
    for (;;)
    {
      if (_inputPtr >= i) {
        return _parseNumber2(arrayOfChar, j, true, k);
      }
      arrayOfByte = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      m = arrayOfByte[m] & 0xFF;
      if ((m < 48) || (m > 57)) {
        break;
      }
      k += 1;
      arrayOfChar[j] = ((char)m);
      j += 1;
    }
    if ((m == 46) || (m == 101) || (m == 69)) {
      return _parseFloat(arrayOfChar, j, m, true, k);
    }
    _inputPtr -= 1;
    _textBuffer._currentSize = j;
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(m);
    }
    return resetInt(true, k);
  }
  
  private final JsonToken _parseNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        _textBuffer._currentSize = paramInt1;
        return resetInt(paramBoolean, paramInt2);
      }
      Object localObject = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48))
      {
        if ((j != 46) && (j != 101) && (j != 69)) {
          break;
        }
        return _parseFloat(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
      }
      localObject = paramArrayOfChar;
      i = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = _textBuffer.finishCurrentSegment();
        i = 0;
      }
      localObject[i] = ((char)j);
      paramInt2 += 1;
      paramInt1 = i + 1;
      paramArrayOfChar = (char[])localObject;
    }
    _inputPtr -= 1;
    _textBuffer._currentSize = paramInt1;
    if (_parsingContext.inRoot())
    {
      paramArrayOfChar = _inputBuffer;
      paramInt1 = _inputPtr;
      _inputPtr = (paramInt1 + 1);
      _verifyRootSpace(paramArrayOfChar[paramInt1] & 0xFF);
    }
    return resetInt(paramBoolean, paramInt2);
  }
  
  private JsonToken _parsePosNumber(int paramInt)
    throws IOException
  {
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int i = paramInt;
    if (paramInt == 48) {
      i = _verifyNoLeadingZeroes();
    }
    arrayOfChar[0] = ((char)i);
    int k = 1;
    int m = 1;
    int n = _inputPtr + arrayOfChar.length - 1;
    i = m;
    int j = k;
    paramInt = n;
    if (n > _inputEnd)
    {
      paramInt = _inputEnd;
      j = k;
      i = m;
    }
    for (;;)
    {
      if (_inputPtr >= paramInt) {
        return _parseNumber2(arrayOfChar, i, false, j);
      }
      byte[] arrayOfByte = _inputBuffer;
      k = _inputPtr;
      _inputPtr = (k + 1);
      k = arrayOfByte[k] & 0xFF;
      if ((k < 48) || (k > 57)) {
        break;
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    if ((k == 46) || (k == 101) || (k == 69)) {
      return _parseFloat(arrayOfChar, i, k, false, j);
    }
    _inputPtr -= 1;
    _textBuffer._currentSize = i;
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(k);
    }
    return resetInt(false, j);
  }
  
  private void _reportInvalidChar(int paramInt)
    throws JsonParseException
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  private void _reportInvalidInitial(int paramInt)
    throws JsonParseException
  {
    throw _constructError("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }
  
  private void _reportInvalidOther(int paramInt)
    throws JsonParseException
  {
    throw _constructError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }
  
  private void _reportInvalidOther(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    _inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  private void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new StringBuilder(paramString1);
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      char c = (char)_decodeCharForError(arrayOfByte[i]);
      if (!Character.isJavaIdentifierPart(c)) {
        break;
      }
      paramString1.append(c);
    }
    throw _constructError("Unrecognized token '" + paramString1.toString() + "': was expecting " + paramString2);
  }
  
  private void _skipCR()
    throws IOException
  {
    if (((_inputPtr < _inputEnd) || (loadMore())) && (_inputBuffer[_inputPtr] == 10)) {
      _inputPtr += 1;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  private final int _skipColon2(boolean paramBoolean)
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i == 47)
        {
          _skipComment();
        }
        else if ((i != 35) || (!_skipYAMLComment()))
        {
          if (paramBoolean) {
            return i;
          }
          if (i != 58)
          {
            if (i < 32) {
              _throwInvalidSpace(i);
            }
            _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
          }
          paramBoolean = true;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final void _skipComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    Object localObject = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = localObject[i] & 0xFF;
    if (i == 47)
    {
      _skipLine();
      return;
    }
    if (i == 42)
    {
      localObject = CharTypes.getInputCodeComment();
      while ((_inputPtr < _inputEnd) || (loadMore()))
      {
        byte[] arrayOfByte = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        int j = localObject[i];
        if (j != 0) {
          switch (j)
          {
          default: 
            _reportInvalidChar(i);
            break;
          case 42: 
            if ((_inputPtr >= _inputEnd) && (!loadMore())) {
              break label304;
            }
            if (_inputBuffer[_inputPtr] == 47)
            {
              _inputPtr += 1;
              return;
            }
            break;
          case 10: 
            _currInputRow += 1;
            _currInputRowStart = _inputPtr;
            break;
          case 13: 
            _skipCR();
            break;
          case 2: 
            _skipUtf8_2$13462e();
            break;
          case 3: 
            _skipUtf8_3$13462e();
            break;
          case 4: 
            _skipUtf8_4$13462e();
          }
        }
      }
      label304:
      _reportInvalidEOF(" in a comment");
      return;
    }
    _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
  }
  
  private final void _skipLine()
    throws IOException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    for (;;)
    {
      int i;
      int j;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        byte[] arrayOfByte = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        j = arrayOfInt[i];
        if (j == 0) {}
      }
      else
      {
        switch (j)
        {
        case 42: 
        default: 
          if (j < 0) {
            _reportInvalidChar(i);
          }
          break;
        case 10: 
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
          return;
        case 13: 
          _skipCR();
          return;
        case 2: 
          _skipUtf8_2$13462e();
          break;
        case 3: 
          _skipUtf8_3$13462e();
          break;
        case 4: 
          _skipUtf8_4$13462e();
        }
      }
    }
  }
  
  private final void _skipUtf8_2$13462e()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_3$13462e()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_4$13462e()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
  }
  
  private final int _skipWS()
    throws IOException
  {
    while (_inputPtr < _inputEnd)
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      if (j > 32)
      {
        if (j != 47)
        {
          i = j;
          if (j != 35) {}
        }
        else
        {
          _inputPtr -= 1;
          i = _skipWS2();
        }
        return i;
      }
      if (j != 32) {
        if (j == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (j == 13)
        {
          _skipCR();
        }
        else if (j != 9)
        {
          _throwInvalidSpace(j);
        }
      }
    }
    return _skipWS2();
  }
  
  private final int _skipWS2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final boolean _skipYAMLComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    _skipLine();
    return true;
  }
  
  private final int _verifyNoLeadingZeroes()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {}
    int j;
    do
    {
      for (int i = 48; (_inputPtr >= _inputEnd) && (!loadMore()); i = j) {
        do
        {
          return i;
          j = _inputBuffer[_inputPtr] & 0xFF;
          if ((j < 48) || (j > 57)) {
            return 48;
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
          }
          _inputPtr += 1;
          i = j;
        } while (j != 48);
      }
      j = _inputBuffer[_inputPtr] & 0xFF;
      if ((j < 48) || (j > 57)) {
        return 48;
      }
      _inputPtr += 1;
      i = j;
    } while (j == 48);
    return j;
  }
  
  private final void _verifyRootSpace(int paramInt)
    throws IOException
  {
    _inputPtr += 1;
    switch (paramInt)
    {
    default: 
      _reportMissingRootWS(paramInt);
    case 9: 
    case 32: 
      return;
    case 13: 
      _skipCR();
      return;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  private final Name addName(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws JsonParseException
  {
    int i3 = (paramInt1 << 2) - 4 + paramInt2;
    int i2;
    Object localObject1;
    int i;
    int m;
    label49:
    int j;
    int i1;
    int n;
    label120:
    Object localObject2;
    if (paramInt2 < 4)
    {
      i2 = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
      localObject1 = _textBuffer.emptyAndGetCurrentSegment();
      i = 0;
      m = 0;
      if (i >= i3) {
        break label522;
      }
      j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
      int k = i + 1;
      i1 = j;
      n = k;
      if (j <= 127) {
        break label560;
      }
      if ((j & 0xE0) != 192) {
        break label457;
      }
      i = j & 0x1F;
      j = 1;
      if (k + j > i3) {
        _reportInvalidEOF(" in field name");
      }
      i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
      n = k + 1;
      if ((i1 & 0xC0) != 128) {
        _reportInvalidOther(i1);
      }
      i1 = i << 6 | i1 & 0x3F;
      k = i1;
      i = n;
      if (j > 1)
      {
        i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
        n += 1;
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i);
        }
        i1 = i1 << 6 | i & 0x3F;
        k = i1;
        i = n;
        if (j > 2)
        {
          k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
          i = n + 1;
          if ((k & 0xC0) != 128) {
            _reportInvalidOther(k & 0xFF);
          }
          k = i1 << 6 | k & 0x3F;
        }
      }
      i1 = k;
      n = i;
      if (j <= 2) {
        break label560;
      }
      k -= 65536;
      localObject2 = localObject1;
      if (m >= localObject1.length) {
        localObject2 = _textBuffer.expandCurrentSegment();
      }
      j = m + 1;
      localObject2[m] = ((char)(55296 + (k >> 10)));
      i1 = 0xDC00 | k & 0x3FF;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= localObject1.length) {
        localObject2 = _textBuffer.expandCurrentSegment();
      }
      m = j + 1;
      localObject2[j] = ((char)i1);
      localObject1 = localObject2;
      break label49;
      i2 = 0;
      break;
      label457:
      if ((j & 0xF0) == 224)
      {
        i = j & 0xF;
        j = 2;
        break label120;
      }
      if ((j & 0xF8) == 240)
      {
        i = j & 0x7;
        j = 3;
        break label120;
      }
      _reportInvalidInitial(j);
      i = 1;
      j = 1;
      break label120;
      label522:
      localObject1 = new String((char[])localObject1, 0, m);
      if (paramInt2 < 4) {
        paramArrayOfInt[(paramInt1 - 1)] = i2;
      }
      return _symbols.addName((String)localObject1, paramArrayOfInt, paramInt1);
      label560:
      j = m;
      i = n;
    }
  }
  
  private final Name findName(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    paramInt1 = pad(paramInt1, paramInt2);
    Name localName = _symbols.findName(paramInt1);
    if (localName != null) {
      return localName;
    }
    _quadBuffer[0] = paramInt1;
    return addName(_quadBuffer, 1, paramInt2);
  }
  
  private final Name findName(int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    paramInt2 = pad(paramInt2, paramInt3);
    Name localName = _symbols.findName(paramInt1, paramInt2);
    if (localName != null) {
      return localName;
    }
    _quadBuffer[0] = paramInt1;
    _quadBuffer[1] = paramInt2;
    return addName(_quadBuffer, 2, paramInt3);
  }
  
  private final Name findName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      arrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
      _quadBuffer = arrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = pad(paramInt2, paramInt3);
    Name localName = _symbols.findName(arrayOfInt, i);
    paramArrayOfInt = localName;
    if (localName == null) {
      paramArrayOfInt = addName(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  private static int[] growArrayBy(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    return Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length + paramInt);
  }
  
  private int nextByte()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  private static final int pad(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 4) {
      return paramInt1;
    }
    return paramInt1 | -1 << (paramInt2 << 3);
  }
  
  private Name parseEscapedName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    Object localObject2 = _icLatin1;
    int i = paramInt3;
    label39:
    Object localObject1;
    if (localObject2[paramInt3] != 0) {
      if (paramInt3 != 34) {
        if (paramInt3 != 92)
        {
          _throwUnquotedSpace(paramInt3, "name");
          i = paramInt3;
          if (paramInt3 <= 127) {
            break label494;
          }
          if (paramInt4 < 4) {
            break label491;
          }
          localObject1 = paramArrayOfInt;
          if (paramInt1 >= paramArrayOfInt.length)
          {
            localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
            _quadBuffer = ((int[])localObject1);
          }
          i = paramInt1 + 1;
          localObject1[paramInt1] = paramInt2;
          paramInt2 = 0;
          paramInt4 = 0;
          paramArrayOfInt = (int[])localObject1;
          paramInt1 = i;
          label100:
          if (paramInt3 >= 2048) {
            break label245;
          }
          i = paramInt2 << 8 | paramInt3 >> 6 | 0xC0;
          paramInt2 = paramInt4 + 1;
          paramInt4 = paramInt1;
          paramInt1 = i;
          paramInt3 = paramInt3 & 0x3F | 0x80;
          i = paramInt2;
          paramInt2 = paramInt3;
          paramInt3 = paramInt1;
          paramInt1 = paramInt4;
        }
      }
    }
    for (;;)
    {
      if (i < 4)
      {
        paramInt4 = i + 1;
        paramInt2 = paramInt3 << 8 | paramInt2;
        label178:
        if ((_inputPtr >= _inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject1 = _inputBuffer;
        paramInt3 = _inputPtr;
        _inputPtr = (paramInt3 + 1);
        paramInt3 = localObject1[paramInt3] & 0xFF;
        break;
        paramInt3 = _decodeEscaped();
        break label39;
        label245:
        paramInt2 = paramInt2 << 8 | paramInt3 >> 12 | 0xE0;
        i = paramInt4 + 1;
        if (i < 4) {
          break label482;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          _quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt4 = 0;
        paramInt2 = 0;
        paramInt1 = i;
        paramArrayOfInt = (int[])localObject1;
      }
      for (;;)
      {
        i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
        paramInt2 += 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        break;
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          _quadBuffer = ((int[])localObject1);
        }
        paramInt4 = paramInt1 + 1;
        localObject1[paramInt1] = paramInt3;
        paramInt3 = 1;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = paramInt4;
        paramInt4 = paramInt3;
        break label178;
        localObject1 = paramArrayOfInt;
        paramInt3 = paramInt1;
        if (paramInt4 > 0)
        {
          localObject1 = paramArrayOfInt;
          if (paramInt1 >= paramArrayOfInt.length)
          {
            localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
            _quadBuffer = ((int[])localObject1);
          }
          localObject1[paramInt1] = pad(paramInt2, paramInt4);
          paramInt3 = paramInt1 + 1;
        }
        localObject2 = _symbols.findName((int[])localObject1, paramInt3);
        paramArrayOfInt = (int[])localObject2;
        if (localObject2 == null) {
          paramArrayOfInt = addName((int[])localObject1, paramInt3, paramInt4);
        }
        return paramArrayOfInt;
        label482:
        paramInt4 = paramInt2;
        paramInt2 = i;
      }
      label491:
      break label100;
      label494:
      paramInt3 = paramInt2;
      paramInt2 = i;
      i = paramInt4;
    }
  }
  
  private Name parseLongName(int paramInt1, int paramInt2)
    throws IOException
  {
    _quadBuffer[0] = _quad1;
    _quadBuffer[1] = paramInt2;
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = _icLatin1;
    int i = 2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (_inputPtr + 4 <= _inputEnd)
    {
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 1);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, i, 1);
      }
      paramInt2 = paramInt2 << 8 | i;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 2);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, i, 2);
      }
      paramInt2 = paramInt2 << 8 | i;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] != 0)
      {
        if (i == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 3);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, i, 3);
      }
      i = paramInt2 << 8 | i;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = arrayOfByte[paramInt2] & 0xFF;
      if (arrayOfInt[paramInt2] != 0)
      {
        if (paramInt2 == 34) {
          return findName(_quadBuffer, paramInt1, i, 4);
        }
        return parseEscapedName(_quadBuffer, paramInt1, i, paramInt2, 4);
      }
      if (paramInt1 >= _quadBuffer.length) {
        _quadBuffer = growArrayBy(_quadBuffer, paramInt1);
      }
      _quadBuffer[paramInt1] = i;
      paramInt1 += 1;
    }
    return parseEscapedName(_quadBuffer, paramInt1, 0, paramInt2, 0);
  }
  
  private final Name parseName(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    return parseEscapedName(_quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private final Name parseName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    _quadBuffer[0] = paramInt1;
    return parseEscapedName(_quadBuffer, 1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void _closeInput()
    throws IOException
  {
    if (_inputStream != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _inputStream.close();
      }
      _inputStream = null;
    }
  }
  
  protected final char _decodeEscaped()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    switch (i)
    {
    default: 
      return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(i));
    case 98: 
      return '\b';
    case 116: 
      return '\t';
    case 110: 
      return '\n';
    case 102: 
      return '\f';
    case 114: 
      return '\r';
    case 34: 
    case 47: 
    case 92: 
      return (char)i;
    }
    int j = 0;
    i = 0;
    while (i < 4)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      arrayOfByte = _inputBuffer;
      int k = _inputPtr;
      _inputPtr = (k + 1);
      k = arrayOfByte[k];
      int m = CharTypes.charToHex(k);
      if (m < 0) {
        _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
      }
      j = j << 4 | m;
      i += 1;
    }
    return (char)j;
  }
  
  protected final void _finishString()
    throws IOException
  {
    int j = _inputPtr;
    int i = j;
    if (j >= _inputEnd)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
    }
    Object localObject2 = _textBuffer.emptyAndGetCurrentSegment();
    Object localObject1 = _icUTF8;
    int k = Math.min(_inputEnd, localObject2.length + i);
    Object localObject3 = _inputBuffer;
    j = 0;
    while (i < k)
    {
      m = localObject3[i] & 0xFF;
      if (localObject1[m] != 0)
      {
        if (m != 34) {
          break;
        }
        _inputPtr = (i + 1);
        _textBuffer._currentSize = j;
        return;
      }
      i += 1;
      localObject2[j] = ((char)m);
      j += 1;
    }
    _inputPtr = i;
    localObject3 = _icUTF8;
    byte[] arrayOfByte = _inputBuffer;
    k = _inputPtr;
    i = k;
    if (k >= _inputEnd)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
    }
    localObject1 = localObject2;
    k = j;
    if (j >= localObject2.length)
    {
      localObject1 = _textBuffer.finishCurrentSegment();
      k = 0;
    }
    int m = Math.min(_inputEnd, localObject1.length - k + i);
    j = k;
    label205:
    if (i < m)
    {
      k = i + 1;
      i = arrayOfByte[i] & 0xFF;
      if (localObject3[i] != 0)
      {
        _inputPtr = k;
        if (i == 34) {
          break label481;
        }
        switch (localObject3[i])
        {
        default: 
          if (i < 32)
          {
            _throwUnquotedSpace(i, "string value");
            label290:
            if (j < localObject1.length) {
              break label490;
            }
            localObject1 = _textBuffer.finishCurrentSegment();
            j = 0;
          }
          break;
        }
      }
    }
    label481:
    label490:
    for (;;)
    {
      k = j + 1;
      localObject1[j] = ((char)i);
      localObject2 = localObject1;
      j = k;
      break;
      localObject1[j] = ((char)i);
      i = k;
      j += 1;
      break label205;
      _inputPtr = i;
      localObject2 = localObject1;
      break;
      i = _decodeEscaped();
      break label290;
      i = _decodeUtf8_2(i);
      break label290;
      if (_inputEnd - _inputPtr >= 2)
      {
        i = _decodeUtf8_3fast(i);
        break label290;
      }
      i = _decodeUtf8_3(i);
      break label290;
      m = _decodeUtf8_4(i);
      k = j + 1;
      localObject1[j] = ((char)(0xD800 | m >> 10));
      localObject2 = localObject1;
      i = k;
      if (k >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        i = 0;
      }
      k = m & 0x3FF | 0xDC00;
      localObject1 = localObject2;
      j = i;
      i = k;
      break label290;
      _reportInvalidChar(i);
      break label290;
      _textBuffer._currentSize = j;
      return;
    }
  }
  
  protected final void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    _symbols.release();
    if (_bufferRecyclable)
    {
      byte[] arrayOfByte = _inputBuffer;
      if (arrayOfByte != null)
      {
        _inputBuffer = ByteArrayBuilder.NO_BYTES;
        _ioContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public final JsonLocation getCurrentLocation()
  {
    int i = _inputPtr;
    int j = _currInputRowStart;
    return new JsonLocation(_ioContext.getSourceReference(), _currInputProcessed + _inputPtr, -1L, _currInputRow, i - j + 1);
  }
  
  public final Object getInputSource()
  {
    return _inputStream;
  }
  
  public final String getText()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == null) {
      return null;
    }
    switch (_id)
    {
    default: 
      return _serialized;
    case 5: 
      return _parsingContext.getCurrentName();
    }
    return _textBuffer.contentsAsString();
  }
  
  public final char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    if (_currToken != null)
    {
      switch (_currToken._id)
      {
      default: 
        return _currToken._serializedChars;
      case 5: 
        String str;
        int i;
        if (!_nameCopied)
        {
          str = _parsingContext.getCurrentName();
          i = str.length();
          if (_nameCopyBuffer != null) {
            break label112;
          }
          _nameCopyBuffer = _ioContext.allocNameCopyBuffer(i);
        }
        for (;;)
        {
          str.getChars(0, i, _nameCopyBuffer, 0);
          _nameCopied = true;
          return _nameCopyBuffer;
          if (_nameCopyBuffer.length < i) {
            _nameCopyBuffer = new char[i];
          }
        }
      case 6: 
        label112:
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        break;
      }
      return _textBuffer.getTextBuffer();
    }
    return null;
  }
  
  public final int getTextLength()
    throws IOException, JsonParseException
  {
    int i = 0;
    if (_currToken != null) {}
    switch (_currToken._id)
    {
    default: 
      i = _currToken._serializedChars.length;
      return i;
    case 5: 
      return _parsingContext.getCurrentName().length();
    case 6: 
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return _textBuffer.size();
  }
  
  public final int getTextOffset()
    throws IOException, JsonParseException
  {
    if (_currToken != null) {}
    switch (_currToken._id)
    {
    case 5: 
    default: 
      return 0;
    case 6: 
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return _textBuffer.getTextOffset();
  }
  
  public final String getValueAsString()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    return super.getValueAsString(null);
  }
  
  public final String getValueAsString(String paramString)
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
    return super.getValueAsString(paramString);
  }
  
  protected final boolean loadMore()
    throws IOException
  {
    _currInputProcessed += _inputEnd;
    _currInputRowStart -= _inputEnd;
    int i;
    if (_inputStream != null)
    {
      i = _inputBuffer.length;
      if (i != 0) {
        break label46;
      }
    }
    label46:
    do
    {
      return false;
      i = _inputStream.read(_inputBuffer, 0, i);
      if (i > 0)
      {
        _inputPtr = 0;
        _inputEnd = i;
        return true;
      }
      _closeInput();
    } while (i != 0);
    throw new IOException("InputStream.read() returned 0 characters when trying to read " + _inputBuffer.length + " bytes");
  }
  
  public final JsonToken nextToken()
    throws IOException
  {
    _numTypesValid = 0;
    Object localObject1;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localObject1 = _nextToken;
      _nextToken = null;
      if (localObject1 == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      }
      for (;;)
      {
        _currToken = ((JsonToken)localObject1);
        return (JsonToken)localObject1;
        if (localObject1 == JsonToken.START_OBJECT) {
          _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        }
      }
    }
    Object localObject2;
    int k;
    int j;
    int i;
    if (_tokenIncomplete)
    {
      _tokenIncomplete = false;
      localObject1 = _icUTF8;
      localObject2 = _inputBuffer;
      k = _inputPtr;
      int m = _inputEnd;
      j = m;
      i = k;
      if (k >= m)
      {
        loadMoreGuaranteed();
        i = _inputPtr;
        j = _inputEnd;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        k = i + 1;
        i = localObject2[i] & 0xFF;
        if (localObject1[i] == 0) {
          break label2661;
        }
        _inputPtr = k;
        if (i == 34) {}
      }
      else
      {
        switch (localObject1[i])
        {
        default: 
          if (i < 32)
          {
            _throwUnquotedSpace(i, "string value");
            break;
            _inputPtr = i;
          }
          break;
        case 1: 
          _decodeEscaped();
          break;
        case 2: 
          _skipUtf8_2$13462e();
          break;
        case 3: 
          _skipUtf8_3$13462e();
          break;
        case 4: 
          _skipUtf8_4$13462e();
          break;
          _reportInvalidChar(i);
          break;
        }
      }
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        i = _eofAsNextChar();
      }
      while (i < 0)
      {
        close();
        _currToken = null;
        return null;
        localObject1 = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        j = localObject1[i] & 0xFF;
        if (j > 32)
        {
          if (j != 47)
          {
            i = j;
            if (j != 35) {}
          }
          else
          {
            _inputPtr -= 1;
          }
        }
        else
        {
          for (;;)
          {
            label385:
            if ((_inputPtr >= _inputEnd) && (!loadMore())) {
              break label717;
            }
            localObject1 = _inputBuffer;
            i = _inputPtr;
            _inputPtr = (i + 1);
            j = localObject1[i] & 0xFF;
            if (j > 32)
            {
              if (j == 47)
              {
                _skipComment();
                continue;
                if (j != 32)
                {
                  if (j != 10) {
                    break label550;
                  }
                  _currInputRow += 1;
                  _currInputRowStart = _inputPtr;
                }
                for (;;)
                {
                  if (_inputPtr >= _inputEnd) {
                    break label635;
                  }
                  localObject1 = _inputBuffer;
                  i = _inputPtr;
                  _inputPtr = (i + 1);
                  j = localObject1[i] & 0xFF;
                  if (j > 32)
                  {
                    if (j != 47)
                    {
                      i = j;
                      if (j != 35) {
                        break;
                      }
                    }
                    _inputPtr -= 1;
                    break label385;
                    label550:
                    if (j == 13)
                    {
                      _skipCR();
                      continue;
                    }
                    if (j == 9) {
                      continue;
                    }
                    _throwInvalidSpace(j);
                    continue;
                  }
                  if (j != 32) {
                    if (j == 10)
                    {
                      _currInputRow += 1;
                      _currInputRowStart = _inputPtr;
                    }
                    else if (j == 13)
                    {
                      _skipCR();
                    }
                    else if (j != 9)
                    {
                      _throwInvalidSpace(j);
                    }
                  }
                }
                label635:
                continue;
              }
              i = j;
              if (j != 35) {
                break;
              }
              if (_skipYAMLComment()) {
                continue;
              }
              i = j;
              break;
            }
            if (j != 32) {
              if (j == 10)
              {
                _currInputRow += 1;
                _currInputRowStart = _inputPtr;
              }
              else if (j == 13)
              {
                _skipCR();
              }
              else if (j != 9)
              {
                _throwInvalidSpace(j);
              }
            }
          }
          label717:
          i = _eofAsNextChar();
        }
      }
      _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
      _tokenInputRow = _currInputRow;
      _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
      _binaryValue = null;
      if (i == 93)
      {
        if (!_parsingContext.inArray()) {
          _reportMismatchedEndMarker(i, '}');
        }
        _parsingContext = _parsingContext.getParent();
        localObject1 = JsonToken.END_ARRAY;
        _currToken = ((JsonToken)localObject1);
        return (JsonToken)localObject1;
      }
      if (i == 125)
      {
        if (!_parsingContext.inObject()) {
          _reportMismatchedEndMarker(i, ']');
        }
        _parsingContext = _parsingContext.getParent();
        localObject1 = JsonToken.END_OBJECT;
        _currToken = ((JsonToken)localObject1);
        return (JsonToken)localObject1;
      }
      j = i;
      if (_parsingContext.expectComma())
      {
        if (i != 44) {
          _reportUnexpectedChar(i, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
        }
        j = _skipWS();
      }
      if (!_parsingContext.inObject())
      {
        if (j == 34)
        {
          _tokenIncomplete = true;
          localObject1 = JsonToken.VALUE_STRING;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        }
        switch (j)
        {
        default: 
          localObject1 = _handleUnexpectedValue(j);
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 91: 
          _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          localObject1 = JsonToken.START_ARRAY;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 123: 
          _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
          localObject1 = JsonToken.START_OBJECT;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 116: 
          _matchToken("true", 1);
          localObject1 = JsonToken.VALUE_TRUE;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 102: 
          _matchToken("false", 1);
          localObject1 = JsonToken.VALUE_FALSE;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 110: 
          _matchToken("null", 1);
          localObject1 = JsonToken.VALUE_NULL;
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        case 45: 
          localObject1 = _parseNegNumber();
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        }
        localObject1 = _parsePosNumber(j);
        _currToken = ((JsonToken)localObject1);
        return (JsonToken)localObject1;
      }
      if (j != 34)
      {
        localObject1 = _handleOddName(j);
        _parsingContext.setCurrentName(((Name)localObject1).getName());
        _currToken = JsonToken.FIELD_NAME;
        if (_inputPtr + 4 >= _inputEnd) {
          break label2412;
        }
        j = _inputBuffer[_inputPtr];
        if (j != 58) {
          break label2222;
        }
        localObject1 = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = localObject1[i];
        if (i <= 32) {
          break label2138;
        }
        if ((i != 47) && (i != 35)) {
          break label2125;
        }
        i = _skipColon2(true);
      }
      for (;;)
      {
        if (i != 34) {
          break label2421;
        }
        _tokenIncomplete = true;
        _nextToken = JsonToken.VALUE_STRING;
        return _currToken;
        if (_inputPtr + 9 > _inputEnd)
        {
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            _reportInvalidEOF(": was expecting closing '\"' for name");
          }
          localObject1 = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i = localObject1[i] & 0xFF;
          if (i == 34)
          {
            localObject1 = Name1.getEmptyName();
            break;
          }
          localObject1 = parseEscapedName(_quadBuffer, 0, 0, i, 0);
          break;
        }
        localObject1 = _inputBuffer;
        localObject2 = _icLatin1;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = localObject1[i] & 0xFF;
        if (localObject2[i] == 0)
        {
          j = _inputPtr;
          _inputPtr = (j + 1);
          j = localObject1[j] & 0xFF;
          if (localObject2[j] == 0)
          {
            i = i << 8 | j;
            j = _inputPtr;
            _inputPtr = (j + 1);
            j = localObject1[j] & 0xFF;
            if (localObject2[j] == 0)
            {
              i = i << 8 | j;
              j = _inputPtr;
              _inputPtr = (j + 1);
              j = localObject1[j] & 0xFF;
              if (localObject2[j] == 0)
              {
                j = i << 8 | j;
                i = _inputPtr;
                _inputPtr = (i + 1);
                i = localObject1[i] & 0xFF;
                if (localObject2[i] == 0)
                {
                  _quad1 = j;
                  localObject1 = _inputBuffer;
                  localObject2 = _icLatin1;
                  j = _inputPtr;
                  _inputPtr = (j + 1);
                  j = localObject1[j] & 0xFF;
                  if (localObject2[j] != 0)
                  {
                    if (j == 34)
                    {
                      localObject1 = findName(_quad1, i, 1);
                      break;
                    }
                    localObject1 = parseName(_quad1, i, j, 1);
                    break;
                  }
                  i = i << 8 | j;
                  j = _inputPtr;
                  _inputPtr = (j + 1);
                  j = localObject1[j] & 0xFF;
                  if (localObject2[j] != 0)
                  {
                    if (j == 34)
                    {
                      localObject1 = findName(_quad1, i, 2);
                      break;
                    }
                    localObject1 = parseName(_quad1, i, j, 2);
                    break;
                  }
                  i = i << 8 | j;
                  j = _inputPtr;
                  _inputPtr = (j + 1);
                  j = localObject1[j] & 0xFF;
                  if (localObject2[j] != 0)
                  {
                    if (j == 34)
                    {
                      localObject1 = findName(_quad1, i, 3);
                      break;
                    }
                    localObject1 = parseName(_quad1, i, j, 3);
                    break;
                  }
                  i = i << 8 | j;
                  j = _inputPtr;
                  _inputPtr = (j + 1);
                  j = localObject1[j] & 0xFF;
                  if (localObject2[j] != 0)
                  {
                    if (j == 34)
                    {
                      localObject1 = findName(_quad1, i, 4);
                      break;
                    }
                    localObject1 = parseName(_quad1, i, j, 4);
                    break;
                  }
                  localObject1 = parseLongName(j, i);
                  break;
                }
                if (i == 34)
                {
                  localObject1 = findName(j, 4);
                  break;
                }
                localObject1 = parseName(j, i, 4);
                break;
              }
              if (j == 34)
              {
                localObject1 = findName(i, 3);
                break;
              }
              localObject1 = parseName(i, j, 3);
              break;
            }
            if (j == 34)
            {
              localObject1 = findName(i, 2);
              break;
            }
            localObject1 = parseName(i, j, 2);
            break;
          }
          if (j == 34)
          {
            localObject1 = findName(i, 1);
            break;
          }
          localObject1 = parseName(i, j, 1);
          break;
        }
        if (i == 34)
        {
          localObject1 = Name1.getEmptyName();
          break;
        }
        localObject1 = parseName(0, i, 0);
        break;
        label2125:
        _inputPtr += 1;
        continue;
        label2138:
        if ((i == 32) || (i == 9))
        {
          localObject1 = _inputBuffer;
          i = _inputPtr + 1;
          _inputPtr = i;
          i = localObject1[i];
          if (i > 32)
          {
            if ((i == 47) || (i == 35))
            {
              i = _skipColon2(true);
              continue;
            }
            _inputPtr += 1;
            continue;
          }
        }
        i = _skipColon2(true);
        continue;
        label2222:
        if (j != 32)
        {
          i = j;
          if (j != 9) {}
        }
        else
        {
          localObject1 = _inputBuffer;
          i = _inputPtr + 1;
          _inputPtr = i;
          i = localObject1[i];
        }
        if (i == 58)
        {
          localObject1 = _inputBuffer;
          i = _inputPtr + 1;
          _inputPtr = i;
          i = localObject1[i];
          if (i > 32)
          {
            if ((i == 47) || (i == 35)) {
              i = _skipColon2(true);
            } else {
              _inputPtr += 1;
            }
          }
          else
          {
            if ((i == 32) || (i == 9))
            {
              localObject1 = _inputBuffer;
              i = _inputPtr + 1;
              _inputPtr = i;
              i = localObject1[i];
              if (i > 32)
              {
                if ((i == 47) || (i == 35))
                {
                  i = _skipColon2(true);
                  continue;
                }
                _inputPtr += 1;
                continue;
              }
            }
            i = _skipColon2(true);
          }
        }
        else
        {
          label2412:
          i = _skipColon2(false);
        }
      }
      switch (i)
      {
      default: 
        label2421:
        localObject1 = _handleUnexpectedValue(i);
      }
      for (;;)
      {
        _nextToken = ((JsonToken)localObject1);
        return _currToken;
        localObject1 = _parseNegNumber();
        continue;
        localObject1 = _parsePosNumber(i);
        continue;
        _matchToken("false", 1);
        localObject1 = JsonToken.VALUE_FALSE;
        continue;
        _matchToken("null", 1);
        localObject1 = JsonToken.VALUE_NULL;
        continue;
        _matchToken("true", 1);
        localObject1 = JsonToken.VALUE_TRUE;
        continue;
        localObject1 = JsonToken.START_ARRAY;
        continue;
        localObject1 = JsonToken.START_OBJECT;
      }
      label2661:
      i = k;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.UTF8StreamJsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */