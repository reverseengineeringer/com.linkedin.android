package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.Reader;

public final class ReaderBasedJsonParser
  extends ParserBase
{
  protected static final int[] _icLatin1 = ;
  protected boolean _bufferRecyclable;
  protected final int _hashSeed;
  protected char[] _inputBuffer;
  protected ObjectCodec _objectCodec;
  protected Reader _reader;
  protected final CharsToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public ReaderBasedJsonParser(IOContext paramIOContext, int paramInt1, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer, char[] paramArrayOfChar, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    _reader = null;
    _inputBuffer = paramArrayOfChar;
    _inputPtr = 0;
    _inputEnd = paramInt2;
    _objectCodec = paramObjectCodec;
    _symbols = paramCharsToNameCanonicalizer;
    _hashSeed = _hashSeed;
    _bufferRecyclable = paramBoolean;
  }
  
  public ReaderBasedJsonParser(IOContext paramIOContext, int paramInt, Reader paramReader, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    super(paramIOContext, paramInt);
    _reader = paramReader;
    _inputBuffer = paramIOContext.allocTokenBuffer();
    _inputPtr = 0;
    _inputEnd = 0;
    _objectCodec = paramObjectCodec;
    _symbols = paramCharsToNameCanonicalizer;
    _hashSeed = _hashSeed;
    _bufferRecyclable = true;
  }
  
  private JsonToken _handleApos()
    throws IOException
  {
    Object localObject1 = _textBuffer.emptyAndGetCurrentSegment();
    int k = _textBuffer._currentSize;
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    Object localObject2 = _inputBuffer;
    int m = _inputPtr;
    _inputPtr = (m + 1);
    int j = localObject2[m];
    int i = j;
    if (j <= 92)
    {
      if (j != 92) {
        break label130;
      }
      i = _decodeEscaped();
    }
    for (;;)
    {
      localObject2 = localObject1;
      m = k;
      if (k >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
      break;
      label130:
      i = j;
      if (j <= 39)
      {
        if (j == 39) {
          break label164;
        }
        i = j;
        if (j < 32)
        {
          _throwUnquotedSpace(j, "string value");
          i = j;
        }
      }
    }
    label164:
    _textBuffer._currentSize = k;
    return JsonToken.VALUE_STRING;
  }
  
  private JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException
  {
    double d = Double.NEGATIVE_INFINITY;
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
      if (paramInt == 78)
      {
        if (paramBoolean)
        {
          localObject = "-INF";
          _matchToken((String)localObject, 3);
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label117;
          }
          if (!paramBoolean) {
            break label110;
          }
        }
        for (;;)
        {
          return resetAsNaN((String)localObject, d);
          localObject = "+INF";
          break;
          label110:
          d = Double.POSITIVE_INFINITY;
        }
        label117:
        throw _constructError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean)
        {
          localObject = "-Infinity";
          _matchToken((String)localObject, 3);
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label204;
          }
          if (!paramBoolean) {
            break label197;
          }
        }
        for (;;)
        {
          return resetAsNaN((String)localObject, d);
          localObject = "+Infinity";
          break;
          label197:
          d = Double.POSITIVE_INFINITY;
        }
        label204:
        throw _constructError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }
    }
    reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    return null;
  }
  
  private String _handleOddName(int paramInt)
    throws IOException
  {
    int i1;
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)))
    {
      paramInt = _inputPtr;
      k = _hashSeed;
      n = _inputEnd;
      m = k;
      j = paramInt;
      if (paramInt < n)
      {
        localObject1 = _icLatin1;
        i1 = localObject1.length;
        do
        {
          int i2 = _inputBuffer[paramInt];
          if (i2 == 39)
          {
            j = _inputPtr;
            _inputPtr = (paramInt + 1);
            return _symbols.findSymbol(_inputBuffer, j, paramInt - j, k);
          }
          if (i2 < i1)
          {
            m = k;
            j = paramInt;
            if (localObject1[i2] != 0) {
              break;
            }
          }
          m = k * 33 + i2;
          j = paramInt + 1;
          k = m;
          paramInt = j;
        } while (j < n);
      }
      paramInt = _inputPtr;
      _inputPtr = j;
      return _parseName2(paramInt, m, 39);
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    Object localObject2 = CharTypes.getInputCodeLatin1JsNames();
    int n = localObject2.length;
    boolean bool;
    if (paramInt < n) {
      if (localObject2[paramInt] == 0)
      {
        bool = true;
        if (!bool) {
          _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        m = _inputPtr;
        k = _hashSeed;
        i1 = _inputEnd;
        paramInt = k;
        j = m;
        if (m >= i1) {
          break label404;
        }
        paramInt = m;
        j = k;
      }
    }
    label371:
    do
    {
      k = _inputBuffer[paramInt];
      if (k < n)
      {
        if (localObject2[k] == 0) {
          break label371;
        }
        k = _inputPtr - 1;
        _inputPtr = paramInt;
        return _symbols.findSymbol(_inputBuffer, k, paramInt - k, j);
        bool = false;
        break;
        bool = Character.isJavaIdentifierPart((char)paramInt);
        break;
      }
      if (!Character.isJavaIdentifierPart((char)k))
      {
        k = _inputPtr - 1;
        _inputPtr = paramInt;
        return _symbols.findSymbol(_inputBuffer, k, paramInt - k, j);
      }
      k = j * 33 + k;
      m = paramInt + 1;
      j = k;
      paramInt = m;
    } while (m < i1);
    int j = m;
    paramInt = k;
    label404:
    int k = _inputPtr - 1;
    _inputPtr = j;
    _textBuffer.resetWithShared(_inputBuffer, k, _inputPtr - k);
    Object localObject1 = _textBuffer.getCurrentSegment();
    j = _textBuffer._currentSize;
    int m = localObject2.length;
    for (;;)
    {
      int i;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        i = _inputBuffer[_inputPtr];
        if (i > m) {
          break label548;
        }
        if (localObject2[i] == 0) {
          break label555;
        }
      }
      label548:
      while (!Character.isJavaIdentifierPart(i))
      {
        _textBuffer._currentSize = j;
        localObject1 = _textBuffer;
        localObject2 = ((TextBuffer)localObject1).getTextBuffer();
        j = ((TextBuffer)localObject1).getTextOffset();
        k = ((TextBuffer)localObject1).size();
        return _symbols.findSymbol((char[])localObject2, j, k, paramInt);
      }
      label555:
      _inputPtr += 1;
      paramInt = paramInt * 33 + i;
      k = j + 1;
      localObject1[j] = i;
      if (k >= localObject1.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        j = 0;
      }
      else
      {
        j = k;
      }
    }
  }
  
  private void _matchToken(String paramString, int paramInt)
    throws IOException
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      if (_inputBuffer[_inputPtr] != paramString.charAt(paramInt)) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      _inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {}
    char c;
    do
    {
      return;
      c = _inputBuffer[_inputPtr];
    } while ((c < '0') || (c == ']') || (c == '}') || (!Character.isJavaIdentifierPart(c)));
    _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
  }
  
  private final JsonToken _parseFloat(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
    throws IOException
  {
    int i2 = _inputEnd;
    int k = 0;
    int m = 0;
    int i = paramInt1;
    int j = paramInt3;
    char[] arrayOfChar;
    if (paramInt1 == 46)
    {
      i = paramInt3;
      paramInt1 = m;
      for (;;)
      {
        if (i >= i2) {
          return _parseNumber2(paramBoolean, paramInt2);
        }
        arrayOfChar = _inputBuffer;
        paramInt3 = i + 1;
        m = arrayOfChar[i];
        if ((m < 48) || (m > 57)) {
          break;
        }
        paramInt1 += 1;
        i = paramInt3;
      }
      k = paramInt1;
      i = m;
      j = paramInt3;
      if (paramInt1 == 0)
      {
        reportUnexpectedNumberChar(m, "Decimal point not followed by a digit");
        j = paramInt3;
        i = m;
        k = paramInt1;
      }
    }
    paramInt1 = j;
    j = 0;
    int i1 = 0;
    int n;
    if (i != 101)
    {
      n = paramInt1;
      m = i;
      if (i != 69) {}
    }
    else
    {
      if (paramInt1 >= i2)
      {
        _inputPtr = paramInt2;
        return _parseNumber2(paramBoolean, paramInt2);
      }
      arrayOfChar = _inputBuffer;
      i = paramInt1 + 1;
      paramInt3 = arrayOfChar[paramInt1];
      if ((paramInt3 != 45) && (paramInt3 != 43)) {
        break label374;
      }
      if (i >= i2)
      {
        _inputPtr = paramInt2;
        return _parseNumber2(paramBoolean, paramInt2);
      }
      arrayOfChar = _inputBuffer;
      paramInt1 = i + 1;
      paramInt3 = arrayOfChar[i];
      i = i1;
    }
    for (;;)
    {
      if ((paramInt3 <= 57) && (paramInt3 >= 48))
      {
        i += 1;
        if (paramInt1 >= i2)
        {
          _inputPtr = paramInt2;
          return _parseNumber2(paramBoolean, paramInt2);
        }
        paramInt3 = _inputBuffer[paramInt1];
        paramInt1 += 1;
      }
      else
      {
        j = i;
        n = paramInt1;
        m = paramInt3;
        if (i == 0)
        {
          reportUnexpectedNumberChar(paramInt3, "Exponent indicator not followed by a digit");
          m = paramInt3;
          n = paramInt1;
          j = i;
        }
        paramInt1 = n - 1;
        _inputPtr = paramInt1;
        if (_parsingContext.inRoot()) {
          _verifyRootSpace(m);
        }
        _textBuffer.resetWithShared(_inputBuffer, paramInt2, paramInt1 - paramInt2);
        return resetFloat(paramBoolean, paramInt4, k, j);
        label374:
        paramInt1 = i;
        i = i1;
      }
    }
  }
  
  private String _parseName()
    throws IOException
  {
    int i = _inputPtr;
    int j = _hashSeed;
    int[] arrayOfInt = _icLatin1;
    while (i < _inputEnd)
    {
      k = _inputBuffer[i];
      if ((k < arrayOfInt.length) && (arrayOfInt[k] != 0))
      {
        if (k != 34) {
          break;
        }
        k = _inputPtr;
        _inputPtr = (i + 1);
        return _symbols.findSymbol(_inputBuffer, k, i - k, j);
      }
      j = j * 33 + k;
      i += 1;
    }
    int k = _inputPtr;
    _inputPtr = i;
    return _parseName2(k, j, 34);
  }
  
  private String _parseName2(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    _textBuffer.resetWithShared(_inputBuffer, paramInt1, _inputPtr - paramInt1);
    Object localObject = _textBuffer.getCurrentSegment();
    paramInt1 = _textBuffer._currentSize;
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing '" + (char)paramInt3 + "' for name");
      }
      char[] arrayOfChar = _inputBuffer;
      int k = _inputPtr;
      _inputPtr = (k + 1);
      int j = arrayOfChar[k];
      int i = j;
      if (j <= 92)
      {
        if (j != 92) {
          break label173;
        }
        i = _decodeEscaped();
      }
      for (;;)
      {
        paramInt2 = paramInt2 * 33 + j;
        k = paramInt1 + 1;
        localObject[paramInt1] = i;
        if (k < localObject.length) {
          break label262;
        }
        localObject = _textBuffer.finishCurrentSegment();
        paramInt1 = 0;
        break;
        label173:
        i = j;
        if (j <= paramInt3)
        {
          if (j == paramInt3) {
            break label216;
          }
          i = j;
          if (j < 32)
          {
            _throwUnquotedSpace(j, "name");
            i = j;
          }
        }
      }
      label216:
      _textBuffer._currentSize = paramInt1;
      localObject = _textBuffer;
      arrayOfChar = ((TextBuffer)localObject).getTextBuffer();
      paramInt1 = ((TextBuffer)localObject).getTextOffset();
      paramInt3 = ((TextBuffer)localObject).size();
      return _symbols.findSymbol(arrayOfChar, paramInt1, paramInt3, paramInt2);
      label262:
      paramInt1 = k;
    }
  }
  
  private JsonToken _parseNegNumber()
    throws IOException
  {
    int i = _inputPtr;
    int m = i - 1;
    int n = _inputEnd;
    if (i >= n) {
      return _parseNumber2(true, m);
    }
    char[] arrayOfChar = _inputBuffer;
    int j = i + 1;
    i = arrayOfChar[i];
    if ((i > 57) || (i < 48))
    {
      _inputPtr = j;
      return _handleInvalidNumberStart(i, true);
    }
    if (i == 48) {
      return _parseNumber2(true, m);
    }
    i = 1;
    int k;
    for (;;)
    {
      if (j >= n) {
        return _parseNumber2(true, m);
      }
      arrayOfChar = _inputBuffer;
      k = j + 1;
      j = arrayOfChar[j];
      if ((j < 48) || (j > 57)) {
        break;
      }
      i += 1;
      j = k;
    }
    if ((j == 46) || (j == 101) || (j == 69))
    {
      _inputPtr = k;
      return _parseFloat(j, m, k, true, i);
    }
    k -= 1;
    _inputPtr = k;
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(j);
    }
    _textBuffer.resetWithShared(_inputBuffer, m, k - m);
    return resetInt(true, i);
  }
  
  private final JsonToken _parseNumber2(boolean paramBoolean, int paramInt)
    throws IOException
  {
    int k = paramInt;
    if (paramBoolean) {
      k = paramInt + 1;
    }
    _inputPtr = k;
    Object localObject2 = _textBuffer.emptyAndGetCurrentSegment();
    paramInt = 0;
    if (paramBoolean)
    {
      paramInt = 0 + 1;
      localObject2[0] = 45;
    }
    k = 0;
    Object localObject1;
    int m;
    int j;
    int i;
    label133:
    int i1;
    label136:
    int n;
    if (_inputPtr < _inputEnd)
    {
      localObject1 = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      j = localObject1[m];
      i = j;
      if (j == 48)
      {
        if (_inputPtr >= _inputEnd) {
          break label245;
        }
        m = _inputBuffer[_inputPtr];
        if ((m >= 48) && (m <= 57)) {
          break label245;
        }
        i = 48;
      }
      i1 = 0;
      if ((i < 48) || (i > 57)) {
        break label1236;
      }
      m = k + 1;
      localObject1 = localObject2;
      n = paramInt;
      if (paramInt >= localObject2.length)
      {
        localObject1 = _textBuffer.finishCurrentSegment();
        n = 0;
      }
      k = n + 1;
      localObject1[n] = i;
      if ((_inputPtr < _inputEnd) || (loadMore())) {
        break label415;
      }
      i = 0;
      n = 1;
      paramInt = m;
      m = n;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        return _handleInvalidNumberStart(i, paramBoolean);
        j = getNextChar("No digit following minus sign");
        break;
        label245:
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          i = 48;
          break label133;
        }
        j = _inputBuffer[_inputPtr];
        if ((j < 48) || (j > 57))
        {
          i = 48;
          break label133;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
          reportInvalidNumber("Leading zeroes not allowed");
        }
        _inputPtr += 1;
        i = j;
        if (j == 48)
        {
          i = j;
          for (;;)
          {
            if ((_inputPtr < _inputEnd) || (loadMore()))
            {
              j = _inputBuffer[_inputPtr];
              if ((j < 48) || (j > 57))
              {
                i = 48;
                break;
              }
              _inputPtr += 1;
              i = j;
              if (j != 48) {
                i = j;
              }
            }
          }
        }
        break label133;
        label415:
        localObject2 = _inputBuffer;
        paramInt = _inputPtr;
        _inputPtr = (paramInt + 1);
        i = localObject2[paramInt];
        paramInt = k;
        k = m;
        localObject2 = localObject1;
        break label136;
      }
      i1 = 0;
      int i2 = 0;
      int i3;
      if (i == 46)
      {
        i1 = k + 1;
        localObject1[k] = i;
        if ((_inputPtr >= _inputEnd) && (!loadMore()))
        {
          i3 = 1;
          label497:
          j = i;
          m = i3;
          k = i2;
          localObject2 = localObject1;
          n = i1;
          if (i2 == 0)
          {
            reportUnexpectedNumberChar(i, "Decimal point not followed by a digit");
            n = i1;
            localObject2 = localObject1;
            k = i2;
            m = i3;
            j = i;
          }
        }
      }
      for (;;)
      {
        i2 = 0;
        int i5 = 0;
        int i9 = 0;
        int i10;
        int i4;
        int i6;
        int i7;
        int i8;
        if (j != 101)
        {
          i10 = j;
          i4 = m;
          i6 = k;
          i7 = paramInt;
          i8 = n;
          if (j != 69) {}
        }
        else
        {
          localObject1 = localObject2;
          i1 = n;
          if (n >= localObject2.length)
          {
            localObject1 = _textBuffer.finishCurrentSegment();
            i1 = 0;
          }
          n = i1 + 1;
          localObject1[i1] = j;
          if (_inputPtr >= _inputEnd) {
            break label1109;
          }
          localObject2 = _inputBuffer;
          i1 = _inputPtr;
          _inputPtr = (i1 + 1);
          i = localObject2[i1];
          label667:
          if ((i != 45) && (i != 43)) {
            break label1193;
          }
          if (n < localObject1.length) {
            break label1186;
          }
          localObject1 = _textBuffer.finishCurrentSegment();
          i1 = 0;
          label699:
          n = i1 + 1;
          localObject1[i1] = i;
          if (_inputPtr >= _inputEnd) {
            break label1120;
          }
          localObject2 = _inputBuffer;
          i1 = _inputPtr;
          _inputPtr = (i1 + 1);
          i = localObject2[i1];
          i3 = paramInt;
          i1 = i9;
          i2 = m;
          label759:
          paramInt = n;
          localObject2 = localObject1;
          m = i3;
          i4 = i1;
          n = i2;
        }
        for (;;)
        {
          i3 = n;
          i2 = i4;
          i1 = paramInt;
          if (i <= 57)
          {
            i3 = n;
            i2 = i4;
            i1 = paramInt;
            if (i >= 48)
            {
              i3 = i4 + 1;
              localObject1 = localObject2;
              i1 = paramInt;
              if (paramInt >= localObject2.length)
              {
                localObject1 = _textBuffer.finishCurrentSegment();
                i1 = 0;
              }
              paramInt = i1 + 1;
              localObject1[i1] = i;
              if ((_inputPtr < _inputEnd) || (loadMore())) {
                break label1142;
              }
              n = 1;
              i1 = paramInt;
              i2 = i3;
              i3 = n;
            }
          }
          i10 = i;
          i4 = i3;
          i5 = i2;
          i6 = k;
          i7 = m;
          i8 = i1;
          if (i2 == 0)
          {
            reportUnexpectedNumberChar(i, "Exponent indicator not followed by a digit");
            i8 = i1;
            i7 = m;
            i6 = k;
            i5 = i2;
            i4 = i3;
            i10 = i;
          }
          if (i4 == 0)
          {
            _inputPtr -= 1;
            if (_parsingContext.inRoot()) {
              _verifyRootSpace(i10);
            }
          }
          _textBuffer._currentSize = i8;
          return reset(paramBoolean, i7, i6, i5);
          localObject2 = _inputBuffer;
          k = _inputPtr;
          _inputPtr = (k + 1);
          j = localObject2[k];
          i = j;
          i3 = m;
          if (j < 48) {
            break label497;
          }
          i = j;
          i3 = m;
          if (j > 57) {
            break label497;
          }
          i2 += 1;
          localObject2 = localObject1;
          k = i1;
          if (i1 >= localObject1.length)
          {
            localObject2 = _textBuffer.finishCurrentSegment();
            k = 0;
          }
          localObject2[k] = j;
          i1 = k + 1;
          i = j;
          localObject1 = localObject2;
          break;
          label1109:
          i = getNextChar("expected a digit for number exponent");
          break label667;
          label1120:
          i = getNextChar("expected a digit for number exponent");
          i2 = m;
          i1 = i9;
          i3 = paramInt;
          break label759;
          label1142:
          localObject2 = _inputBuffer;
          i1 = _inputPtr;
          _inputPtr = (i1 + 1);
          i = localObject2[i1];
          i2 = n;
          i1 = i3;
          i3 = m;
          n = paramInt;
          break label759;
          label1186:
          i1 = n;
          break label699;
          label1193:
          i1 = n;
          n = m;
          i4 = i2;
          m = paramInt;
          localObject2 = localObject1;
          paramInt = i1;
        }
        n = k;
        j = i;
        k = i1;
        localObject2 = localObject1;
      }
      label1236:
      n = paramInt;
      m = i1;
      paramInt = k;
      localObject1 = localObject2;
      k = n;
    }
  }
  
  private JsonToken _parsePosNumber(int paramInt)
    throws IOException
  {
    int i = _inputPtr;
    int k = i - 1;
    int m = _inputEnd;
    if (paramInt == 48) {
      return _parseNumber2(false, k);
    }
    paramInt = 1;
    int j;
    for (;;)
    {
      if (i >= m)
      {
        _inputPtr = k;
        return _parseNumber2(false, k);
      }
      char[] arrayOfChar = _inputBuffer;
      j = i + 1;
      i = arrayOfChar[i];
      if ((i < 48) || (i > 57)) {
        break;
      }
      paramInt += 1;
      i = j;
    }
    if ((i == 46) || (i == 101) || (i == 69))
    {
      _inputPtr = j;
      return _parseFloat(i, k, j, false, paramInt);
    }
    j -= 1;
    _inputPtr = j;
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(i);
    }
    _textBuffer.resetWithShared(_inputBuffer, k, j - k);
    return resetInt(false, paramInt);
  }
  
  private void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new StringBuilder(paramString1);
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      char c = _inputBuffer[_inputPtr];
      if (!Character.isJavaIdentifierPart(c)) {
        break;
      }
      _inputPtr += 1;
      paramString1.append(c);
    }
    throw _constructError("Unrecognized token '" + paramString1.toString() + "': was expecting " + paramString2);
  }
  
  private final int _skipAfterComma2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfChar[i];
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i < 32) {
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
  
  private void _skipCR()
    throws IOException
  {
    if (((_inputPtr < _inputEnd) || (loadMore())) && (_inputBuffer[_inputPtr] == '\n')) {
      _inputPtr += 1;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  private final int _skipColon2(boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      char[] arrayOfChar = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfChar[i];
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
      else if (i < 32) {
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
  }
  
  private void _skipComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    char[] arrayOfChar = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfChar[i];
    if (i == 47)
    {
      _skipLine();
      return;
    }
    if (i == 42)
    {
      while ((_inputPtr < _inputEnd) || (loadMore()))
      {
        arrayOfChar = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i <= 42) {
          if (i == 42)
          {
            if ((_inputPtr >= _inputEnd) && (!loadMore())) {
              break;
            }
            if (_inputBuffer[_inputPtr] == '/') {
              _inputPtr += 1;
            }
          }
          else if (i < 32)
          {
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
      }
      _reportInvalidEOF(" in a comment");
      return;
    }
    _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
  }
  
  private void _skipLine()
    throws IOException
  {
    for (;;)
    {
      int i;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        char[] arrayOfChar = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i >= 32) {
          continue;
        }
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
      }
      else
      {
        return;
      }
      if (i == 13)
      {
        _skipCR();
        return;
      }
      if (i != 9) {
        _throwInvalidSpace(i);
      }
    }
  }
  
  private boolean _skipYAMLComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    _skipLine();
    return true;
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
  
  private char getNextChar(String paramString)
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(paramString);
    }
    paramString = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    return paramString[i];
  }
  
  protected final void _closeInput()
    throws IOException
  {
    if (_reader != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _reader.close();
      }
      _reader = null;
    }
  }
  
  protected final char _decodeEscaped()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    char[] arrayOfChar = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    char c2 = arrayOfChar[i];
    char c1 = c2;
    switch (c2)
    {
    default: 
      c1 = _handleUnrecognizedCharacterEscape(c2);
    case '"': 
    case '/': 
    case '\\': 
      return c1;
    case 'b': 
      return '\b';
    case 't': 
      return '\t';
    case 'n': 
      return '\n';
    case 'f': 
      return '\f';
    case 'r': 
      return '\r';
    }
    int j = 0;
    i = 0;
    while (i < 4)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      arrayOfChar = _inputBuffer;
      int k = _inputPtr;
      _inputPtr = (k + 1);
      k = arrayOfChar[k];
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
    int m = _inputPtr;
    int n = _inputEnd;
    int k = m;
    if (m < n)
    {
      localObject1 = _icLatin1;
      i1 = localObject1.length;
      do
      {
        i2 = _inputBuffer[m];
        if ((i2 < i1) && (localObject1[i2] != 0))
        {
          k = m;
          if (i2 != 34) {
            break;
          }
          _textBuffer.resetWithShared(_inputBuffer, _inputPtr, m - _inputPtr);
          _inputPtr = (m + 1);
          return;
        }
        k = m + 1;
        m = k;
      } while (k < n);
    }
    Object localObject1 = _textBuffer;
    Object localObject2 = _inputBuffer;
    int i2 = _inputPtr;
    int i1 = k - _inputPtr;
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    _resultString = null;
    _resultArray = null;
    Object localObject3;
    int i3;
    label273:
    label305:
    int j;
    int i;
    if (_hasSegments)
    {
      ((TextBuffer)localObject1).clearSegments();
      _segmentSize = 0;
      _currentSize = 0;
      if (_inputStart >= 0) {
        ((TextBuffer)localObject1).unshare(i1);
      }
      _resultString = null;
      _resultArray = null;
      localObject3 = _currentSegment;
      i3 = localObject3.length - _currentSize;
      if (i3 < i1) {
        break label456;
      }
      System.arraycopy(localObject2, i2, localObject3, _currentSize, i1);
      _currentSize = (i1 + _currentSize);
      _inputPtr = k;
      localObject1 = _textBuffer.getCurrentSegment();
      k = _textBuffer._currentSize;
      localObject3 = _icLatin1;
      n = localObject3.length;
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing quote for a string value");
      }
      localObject2 = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      j = localObject2[m];
      i = j;
      if (j < n)
      {
        i = j;
        if (localObject3[j] != 0)
        {
          if (j == 34) {
            break label591;
          }
          if (j != 92) {
            break label571;
          }
          i = _decodeEscaped();
        }
      }
    }
    for (;;)
    {
      m = k;
      localObject2 = localObject1;
      if (k >= localObject1.length)
      {
        localObject2 = _textBuffer.finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = i;
      k = m + 1;
      localObject1 = localObject2;
      break label305;
      if (_currentSegment != null) {
        break;
      }
      _currentSegment = ((TextBuffer)localObject1).buf(i1);
      break;
      label456:
      m = i1;
      n = i2;
      if (i3 > 0)
      {
        System.arraycopy(localObject2, i2, localObject3, _currentSize, i3);
        n = i2 + i3;
        m = i1 - i3;
      }
      do
      {
        ((TextBuffer)localObject1).expand$13462e();
        i1 = Math.min(_currentSegment.length, m);
        System.arraycopy(localObject2, n, _currentSegment, 0, i1);
        _currentSize += i1;
        n += i1;
        i1 = m - i1;
        m = i1;
      } while (i1 > 0);
      break label273;
      label571:
      i = j;
      if (j < 32)
      {
        _throwUnquotedSpace(j, "string value");
        i = j;
      }
    }
    label591:
    _textBuffer._currentSize = k;
  }
  
  protected final void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    _symbols.release();
    if (_bufferRecyclable)
    {
      char[] arrayOfChar = _inputBuffer;
      if (arrayOfChar != null)
      {
        _inputBuffer = null;
        _ioContext.releaseTokenBuffer(arrayOfChar);
      }
    }
  }
  
  public final Object getInputSource()
  {
    return _reader;
  }
  
  public final String getText()
    throws IOException
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      return _textBuffer.contentsAsString();
    }
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
    throws IOException
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
    throws IOException
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
    throws IOException
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
    throws IOException
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
    throws IOException
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
    boolean bool2 = false;
    _currInputProcessed += _inputEnd;
    _currInputRowStart -= _inputEnd;
    boolean bool1 = bool2;
    int i;
    if (_reader != null)
    {
      i = _reader.read(_inputBuffer, 0, _inputBuffer.length);
      if (i <= 0) {
        break label74;
      }
      _inputPtr = 0;
      _inputEnd = i;
      bool1 = true;
    }
    label74:
    do
    {
      return bool1;
      _closeInput();
      bool1 = bool2;
    } while (i != 0);
    throw new IOException("Reader returned 0 characters when trying to read " + _inputEnd);
  }
  
  public final JsonToken nextToken()
    throws IOException
  {
    _numTypesValid = 0;
    Object localObject;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localObject = _nextToken;
      _nextToken = null;
      if (localObject == JsonToken.START_ARRAY) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      }
      for (;;)
      {
        _currToken = ((JsonToken)localObject);
        return (JsonToken)localObject;
        if (localObject == JsonToken.START_OBJECT) {
          _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
        }
      }
    }
    int k;
    if (_tokenIncomplete)
    {
      _tokenIncomplete = false;
      i = _inputPtr;
      j = _inputEnd;
      localObject = _inputBuffer;
      for (;;)
      {
        k = j;
        int m = i;
        if (i >= j)
        {
          _inputPtr = i;
          if (!loadMore()) {
            _reportInvalidEOF(": was expecting closing quote for a string value");
          }
          m = _inputPtr;
          k = _inputEnd;
        }
        i = m + 1;
        j = localObject[m];
        if (j > 92) {
          break label283;
        }
        if (j != 92) {
          break;
        }
        _inputPtr = i;
        _decodeEscaped();
        i = _inputPtr;
        j = _inputEnd;
      }
      if (j > 34) {
        break label283;
      }
      if (j == 34) {
        _inputPtr = i;
      }
    }
    else
    {
      if ((_inputPtr < _inputEnd) || (loadMore())) {
        break label288;
      }
      i = _eofAsNextChar();
    }
    for (;;)
    {
      if (i < 0)
      {
        close();
        _currToken = null;
        return null;
        if (j < 32)
        {
          _inputPtr = i;
          _throwUnquotedSpace(j, "string value");
        }
        label283:
        j = k;
        break;
        label288:
        localObject = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        j = localObject[i];
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
        else {
          for (;;)
          {
            label341:
            if ((_inputPtr >= _inputEnd) && (!loadMore()))
            {
              i = _eofAsNextChar();
              break;
              if (j != 32)
              {
                if (j != 10) {
                  break label464;
                }
                _currInputRow += 1;
                _currInputRowStart = _inputPtr;
              }
              for (;;)
              {
                if (_inputPtr >= _inputEnd) {
                  break label549;
                }
                localObject = _inputBuffer;
                i = _inputPtr;
                _inputPtr = (i + 1);
                j = localObject[i];
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
                  break label341;
                  label464:
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
              label549:
              continue;
            }
            localObject = _inputBuffer;
            i = _inputPtr;
            _inputPtr = (i + 1);
            j = localObject[i];
            if (j > 32)
            {
              if (j == 47)
              {
                _skipComment();
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
        }
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
      localObject = JsonToken.END_ARRAY;
      _currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    if (i == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(i, ']');
      }
      _parsingContext = _parsingContext.getParent();
      localObject = JsonToken.END_OBJECT;
      _currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    int j = i;
    if (_parsingContext.expectComma())
    {
      if (i != 44) {
        _reportUnexpectedChar(i, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      if (_inputPtr < _inputEnd)
      {
        localObject = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = localObject[i];
        if (i <= 32) {
          break label1316;
        }
        if (i != 47)
        {
          j = i;
          if (i != 35) {}
        }
        else
        {
          _inputPtr -= 1;
        }
      }
      else
      {
        j = _skipAfterComma2();
      }
    }
    boolean bool = _parsingContext.inObject();
    int i = j;
    if (bool)
    {
      if (j == 34)
      {
        localObject = _parseName();
        label962:
        _parsingContext.setCurrentName((String)localObject);
        _currToken = JsonToken.FIELD_NAME;
        if (_inputPtr + 4 >= _inputEnd) {
          break label1673;
        }
        j = _inputBuffer[_inputPtr];
        if (j != 58) {
          break label1483;
        }
        localObject = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = localObject[i];
        if (i <= 32) {
          break label1399;
        }
        if ((i != 47) && (i != 35)) {
          break label1386;
        }
        i = _skipColon2(true);
      }
    }
    else {
      switch (i)
      {
      default: 
        label1054:
        switch (i)
        {
        default: 
          label1260:
          if (Character.isJavaIdentifierStart(i)) {
            _reportInvalidToken((char)i, "('true', 'false' or 'null')");
          }
          _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
          localObject = null;
        }
        break;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label2277;
      }
      _nextToken = ((JsonToken)localObject);
      return _currToken;
      label1316:
      if (i >= 32) {
        break;
      }
      if (i == 10)
      {
        _currInputRow += 1;
        _currInputRowStart = _inputPtr;
        break;
      }
      if (i == 13)
      {
        _skipCR();
        break;
      }
      if (i == 9) {
        break;
      }
      _throwInvalidSpace(i);
      break;
      localObject = _handleOddName(j);
      break label962;
      label1386:
      _inputPtr += 1;
      break label1054;
      label1399:
      if ((i == 32) || (i == 9))
      {
        localObject = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = localObject[i];
        if (i > 32)
        {
          if ((i == 47) || (i == 35))
          {
            i = _skipColon2(true);
            break label1054;
          }
          _inputPtr += 1;
          break label1054;
        }
      }
      i = _skipColon2(true);
      break label1054;
      label1483:
      if (j != 32)
      {
        i = j;
        if (j != 9) {}
      }
      else
      {
        localObject = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = localObject[i];
      }
      if (i == 58)
      {
        localObject = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = localObject[i];
        if (i > 32)
        {
          if ((i == 47) || (i == 35))
          {
            i = _skipColon2(true);
            break label1054;
          }
          _inputPtr += 1;
          break label1054;
        }
        if ((i == 32) || (i == 9))
        {
          localObject = _inputBuffer;
          i = _inputPtr + 1;
          _inputPtr = i;
          i = localObject[i];
          if (i > 32)
          {
            if ((i == 47) || (i == 35))
            {
              i = _skipColon2(true);
              break label1054;
            }
            _inputPtr += 1;
            break label1054;
          }
        }
        i = _skipColon2(true);
        break label1054;
      }
      label1673:
      i = _skipColon2(false);
      break label1054;
      _tokenIncomplete = true;
      localObject = JsonToken.VALUE_STRING;
      continue;
      if (!bool) {
        _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      }
      localObject = JsonToken.START_ARRAY;
      continue;
      if (!bool) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
      localObject = JsonToken.START_OBJECT;
      continue;
      _reportUnexpectedChar(i, "expected a value");
      i = _inputPtr;
      if (i + 3 < _inputEnd)
      {
        localObject = _inputBuffer;
        if (localObject[i] == 'r')
        {
          i += 1;
          if (localObject[i] == 'u')
          {
            i += 1;
            if (localObject[i] == 'e')
            {
              i += 1;
              j = localObject[i];
              if ((j < 48) || (j == 93) || (j == 125)) {
                _inputPtr = i;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = JsonToken.VALUE_TRUE;
        break;
        _matchToken("true", 1);
      }
      i = _inputPtr;
      if (i + 4 < _inputEnd)
      {
        localObject = _inputBuffer;
        if (localObject[i] == 'a')
        {
          i += 1;
          if (localObject[i] == 'l')
          {
            i += 1;
            if (localObject[i] == 's')
            {
              i += 1;
              if (localObject[i] == 'e')
              {
                i += 1;
                j = localObject[i];
                if ((j < 48) || (j == 93) || (j == 125)) {
                  _inputPtr = i;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = JsonToken.VALUE_FALSE;
        break;
        _matchToken("false", 1);
      }
      i = _inputPtr;
      if (i + 3 < _inputEnd)
      {
        localObject = _inputBuffer;
        if (localObject[i] == 'u')
        {
          i += 1;
          if (localObject[i] == 'l')
          {
            i += 1;
            if (localObject[i] == 'l')
            {
              i += 1;
              j = localObject[i];
              if ((j < 48) || (j == 93) || (j == 125)) {
                _inputPtr = i;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject = JsonToken.VALUE_NULL;
        break;
        _matchToken("null", 1);
      }
      localObject = _parseNegNumber();
      continue;
      localObject = _parsePosNumber(i);
      continue;
      if (!isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
        break label1260;
      }
      localObject = _handleApos();
      continue;
      _matchToken("NaN", 1);
      if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
      {
        localObject = resetAsNaN("NaN", NaN.0D);
      }
      else
      {
        throw _constructError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        _matchToken("Infinity", 1);
        if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS))
        {
          localObject = resetAsNaN("Infinity", Double.POSITIVE_INFINITY);
        }
        else
        {
          throw _constructError("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
          if ((_inputPtr >= _inputEnd) && (!loadMore())) {
            _reportInvalidEOF(" in a value");
          }
          localObject = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          localObject = _handleInvalidNumberStart(localObject[i], false);
        }
      }
    }
    label2277:
    _currToken = ((JsonToken)localObject);
    return (JsonToken)localObject;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.ReaderBasedJsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */