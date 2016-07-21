package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserBase
  extends ParserMinimalBase
{
  static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
  static final BigDecimal BD_MAX_LONG;
  static final BigDecimal BD_MIN_INT;
  static final BigDecimal BD_MIN_LONG;
  static final BigInteger BI_MAX_INT;
  static final BigInteger BI_MAX_LONG;
  static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
  static final BigInteger BI_MIN_LONG;
  public byte[] _binaryValue;
  protected ByteArrayBuilder _byteArrayBuilder = null;
  protected boolean _closed;
  public long _currInputProcessed = 0L;
  public int _currInputRow = 1;
  public int _currInputRowStart = 0;
  protected int _expLength;
  protected int _fractLength;
  public int _inputEnd = 0;
  public int _inputPtr = 0;
  protected int _intLength;
  public final IOContext _ioContext;
  public boolean _nameCopied = false;
  public char[] _nameCopyBuffer = null;
  public JsonToken _nextToken;
  public int _numTypesValid = 0;
  protected BigDecimal _numberBigDecimal;
  protected BigInteger _numberBigInt;
  protected double _numberDouble;
  protected int _numberInt;
  protected long _numberLong;
  protected boolean _numberNegative;
  public JsonReadContext _parsingContext;
  public final TextBuffer _textBuffer;
  public int _tokenInputCol = 0;
  public int _tokenInputRow = 1;
  public long _tokenInputTotal = 0L;
  
  static
  {
    BI_MAX_INT = BigInteger.valueOf(2147483647L);
    BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
    BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
    BD_MIN_INT = new BigDecimal(BI_MIN_INT);
  }
  
  public ParserBase(IOContext paramIOContext, int paramInt)
  {
    _features = paramInt;
    _ioContext = paramIOContext;
    _textBuffer = paramIOContext.constructTextBuffer();
    if (JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {}
    for (paramIOContext = new DupDetector(this);; paramIOContext = null)
    {
      _parsingContext = new JsonReadContext(null, paramIOContext, 0, 1, 0);
      return;
    }
  }
  
  private void _parseNumericValue(int paramInt)
    throws IOException
  {
    Object localObject;
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      char[] arrayOfChar = _textBuffer.getTextBuffer();
      int i = _textBuffer.getTextOffset();
      int j = _intLength;
      paramInt = i;
      if (_numberNegative) {
        paramInt = i + 1;
      }
      if (j <= 9)
      {
        i = NumberInput.parseInt(arrayOfChar, paramInt, j);
        paramInt = i;
        if (_numberNegative) {
          paramInt = -i;
        }
        _numberInt = paramInt;
        _numTypesValid = 1;
        return;
      }
      if (j <= 18)
      {
        long l2 = NumberInput.parseLong(arrayOfChar, paramInt, j);
        long l1 = l2;
        if (_numberNegative) {
          l1 = -l2;
        }
        if (j == 10) {
          if (_numberNegative)
          {
            if (l1 >= -2147483648L)
            {
              _numberInt = ((int)l1);
              _numTypesValid = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            _numberInt = ((int)l1);
            _numTypesValid = 1;
            return;
          }
        }
        _numberLong = l1;
        _numTypesValid = 2;
        return;
      }
      localObject = _textBuffer.contentsAsString();
      try
      {
        if (NumberInput.inLongRange(arrayOfChar, paramInt, j, _numberNegative))
        {
          _numberLong = Long.parseLong((String)localObject);
          _numTypesValid = 2;
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        _wrapError("Malformed numeric value '" + (String)localObject + "'", localNumberFormatException2);
        return;
      }
      _numberBigInt = new BigInteger((String)localObject);
      _numTypesValid = 4;
      return;
    }
    if (_currToken == JsonToken.VALUE_NUMBER_FLOAT)
    {
      if (paramInt == 16) {
        for (;;)
        {
          try
          {
            localObject = _textBuffer;
            if (_resultArray != null)
            {
              localObject = NumberInput.parseBigDecimal(_resultArray);
              _numberBigDecimal = ((BigDecimal)localObject);
              _numTypesValid = 16;
              return;
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            _wrapError("Malformed numeric value '" + _textBuffer.contentsAsString() + "'", localNumberFormatException1);
            return;
          }
          BigDecimal localBigDecimal;
          if ((_inputStart >= 0) && (_inputBuffer != null)) {
            localBigDecimal = NumberInput.parseBigDecimal(_inputBuffer, _inputStart, _inputLen);
          } else if ((_segmentSize == 0) && (_currentSegment != null)) {
            localBigDecimal = NumberInput.parseBigDecimal(_currentSegment, 0, _currentSize);
          } else {
            localBigDecimal = NumberInput.parseBigDecimal(localBigDecimal.contentsAsArray());
          }
        }
      }
      _numberDouble = NumberInput.parseDouble(_textBuffer.contentsAsString());
      _numTypesValid = 8;
      return;
    }
    throw _constructError("Current token (" + _currToken + ") not numeric, can not use numeric value accessors");
  }
  
  private void reportOverflowInt()
    throws IOException
  {
    throw _constructError("Numeric value (" + getText() + ") out of range of int (-2147483648 - 2147483647)");
  }
  
  private void reportOverflowLong()
    throws IOException
  {
    throw _constructError("Numeric value (" + getText() + ") out of range of long (-9223372036854775808 - 9223372036854775807)");
  }
  
  public abstract void _closeInput()
    throws IOException;
  
  public char _decodeEscaped()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public final int _eofAsNextChar()
    throws JsonParseException
  {
    _handleEOF();
    return -1;
  }
  
  public abstract void _finishString()
    throws IOException;
  
  protected final void _handleEOF()
    throws JsonParseException
  {
    if (!_parsingContext.inRoot()) {
      _reportInvalidEOF(": expected close marker for " + _parsingContext.getTypeDesc() + " (from " + _parsingContext.getStartLocation(_ioContext.getSourceReference()) + ")");
    }
  }
  
  public void _releaseBuffers()
    throws IOException
  {
    Object localObject = _textBuffer;
    if (_allocator == null) {
      ((TextBuffer)localObject).resetWithEmpty();
    }
    for (;;)
    {
      localObject = _nameCopyBuffer;
      if (localObject != null)
      {
        _nameCopyBuffer = null;
        _ioContext.releaseNameCopyBuffer((char[])localObject);
      }
      return;
      if (_currentSegment != null)
      {
        ((TextBuffer)localObject).resetWithEmpty();
        char[] arrayOfChar = _currentSegment;
        _currentSegment = null;
        _allocator.releaseCharBuffer(2, arrayOfChar);
      }
    }
  }
  
  public final void _reportMismatchedEndMarker(int paramInt, char paramChar)
    throws JsonParseException
  {
    String str = _parsingContext.getStartLocation(_ioContext.getSourceReference());
    throw _constructError("Unexpected close marker '" + (char)paramInt + "': expected '" + paramChar + "' (for " + _parsingContext.getTypeDesc() + " starting at " + str + ")");
  }
  
  public void close()
    throws IOException
  {
    if (!_closed) {
      _closed = true;
    }
    try
    {
      _closeInput();
      return;
    }
    finally
    {
      _releaseBuffers();
    }
  }
  
  public final BigInteger getBigIntegerValue()
    throws IOException
  {
    if ((_numTypesValid & 0x4) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(4);
      }
      if ((_numTypesValid & 0x4) == 0)
      {
        if ((_numTypesValid & 0x10) == 0) {
          break label66;
        }
        _numberBigInt = _numberBigDecimal.toBigInteger();
      }
    }
    for (;;)
    {
      _numTypesValid |= 0x4;
      return _numberBigInt;
      label66:
      if ((_numTypesValid & 0x2) != 0) {
        _numberBigInt = BigInteger.valueOf(_numberLong);
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberBigInt = BigInteger.valueOf(_numberInt);
      } else if ((_numTypesValid & 0x8) != 0) {
        _numberBigInt = BigDecimal.valueOf(_numberDouble).toBigInteger();
      } else {
        VersionUtil.throwInternal();
      }
    }
  }
  
  public JsonLocation getCurrentLocation()
  {
    int i = _inputPtr;
    int j = _currInputRowStart;
    return new JsonLocation(_ioContext.getSourceReference(), -1L, _currInputProcessed + _inputPtr, _currInputRow, i - j + 1);
  }
  
  public final String getCurrentName()
    throws IOException
  {
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
      return _parsingContext.getParent().getCurrentName();
    }
    return _parsingContext.getCurrentName();
  }
  
  public final BigDecimal getDecimalValue()
    throws IOException
  {
    if ((_numTypesValid & 0x10) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(16);
      }
      if ((_numTypesValid & 0x10) == 0)
      {
        if ((_numTypesValid & 0x8) == 0) {
          break label70;
        }
        _numberBigDecimal = NumberInput.parseBigDecimal(getText());
      }
    }
    for (;;)
    {
      _numTypesValid |= 0x10;
      return _numberBigDecimal;
      label70:
      if ((_numTypesValid & 0x4) != 0) {
        _numberBigDecimal = new BigDecimal(_numberBigInt);
      } else if ((_numTypesValid & 0x2) != 0) {
        _numberBigDecimal = BigDecimal.valueOf(_numberLong);
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberBigDecimal = BigDecimal.valueOf(_numberInt);
      } else {
        VersionUtil.throwInternal();
      }
    }
  }
  
  public final double getDoubleValue()
    throws IOException
  {
    if ((_numTypesValid & 0x8) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(8);
      }
      if ((_numTypesValid & 0x8) == 0)
      {
        if ((_numTypesValid & 0x10) == 0) {
          break label70;
        }
        _numberDouble = _numberBigDecimal.doubleValue();
      }
    }
    for (;;)
    {
      _numTypesValid |= 0x8;
      return _numberDouble;
      label70:
      if ((_numTypesValid & 0x4) != 0) {
        _numberDouble = _numberBigInt.doubleValue();
      } else if ((_numTypesValid & 0x2) != 0) {
        _numberDouble = _numberLong;
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberDouble = _numberInt;
      } else {
        VersionUtil.throwInternal();
      }
    }
  }
  
  public final float getFloatValue()
    throws IOException
  {
    return (float)getDoubleValue();
  }
  
  public final int getIntValue()
    throws IOException
  {
    if ((_numTypesValid & 0x1) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(1);
      }
      if ((_numTypesValid & 0x1) == 0)
      {
        if ((_numTypesValid & 0x2) == 0) {
          break label106;
        }
        int i = (int)_numberLong;
        if (i != _numberLong) {
          throw _constructError("Numeric value (" + getText() + ") out of range of int");
        }
        _numberInt = i;
      }
    }
    for (;;)
    {
      _numTypesValid |= 0x1;
      return _numberInt;
      label106:
      if ((_numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_INT.compareTo(_numberBigInt) > 0) || (BI_MAX_INT.compareTo(_numberBigInt) < 0)) {
          reportOverflowInt();
        }
        _numberInt = _numberBigInt.intValue();
      }
      else if ((_numTypesValid & 0x8) != 0)
      {
        if ((_numberDouble < -2.147483648E9D) || (_numberDouble > 2.147483647E9D)) {
          reportOverflowInt();
        }
        _numberInt = ((int)_numberDouble);
      }
      else if ((_numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_INT.compareTo(_numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(_numberBigDecimal) < 0)) {
          reportOverflowInt();
        }
        _numberInt = _numberBigDecimal.intValue();
      }
      else
      {
        VersionUtil.throwInternal();
      }
    }
  }
  
  public final long getLongValue()
    throws IOException
  {
    if ((_numTypesValid & 0x2) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(2);
      }
      if ((_numTypesValid & 0x2) == 0)
      {
        if ((_numTypesValid & 0x1) == 0) {
          break label63;
        }
        _numberLong = _numberInt;
      }
    }
    for (;;)
    {
      _numTypesValid |= 0x2;
      return _numberLong;
      label63:
      if ((_numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_LONG.compareTo(_numberBigInt) > 0) || (BI_MAX_LONG.compareTo(_numberBigInt) < 0)) {
          reportOverflowLong();
        }
        _numberLong = _numberBigInt.longValue();
      }
      else if ((_numTypesValid & 0x8) != 0)
      {
        if ((_numberDouble < -9.223372036854776E18D) || (_numberDouble > 9.223372036854776E18D)) {
          reportOverflowLong();
        }
        _numberLong = (_numberDouble);
      }
      else if ((_numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_LONG.compareTo(_numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(_numberBigDecimal) < 0)) {
          reportOverflowLong();
        }
        _numberLong = _numberBigDecimal.longValue();
      }
      else
      {
        VersionUtil.throwInternal();
      }
    }
  }
  
  public final JsonParser.NumberType getNumberType()
    throws IOException
  {
    if (_numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((_numTypesValid & 0x1) != 0) {
        return JsonParser.NumberType.INT;
      }
      if ((_numTypesValid & 0x2) != 0) {
        return JsonParser.NumberType.LONG;
      }
      return JsonParser.NumberType.BIG_INTEGER;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    return JsonParser.NumberType.DOUBLE;
  }
  
  public final boolean hasTextCharacters()
  {
    if (_currToken == JsonToken.VALUE_STRING) {
      return true;
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nameCopied;
    }
    return false;
  }
  
  public abstract boolean loadMore()
    throws IOException;
  
  public final void loadMoreGuaranteed()
    throws IOException
  {
    if (!loadMore()) {
      _reportInvalidEOF();
    }
  }
  
  public final void reportInvalidNumber(String paramString)
    throws JsonParseException
  {
    throw _constructError("Invalid numeric value: " + paramString);
  }
  
  public final void reportUnexpectedNumberChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str = "Unexpected character (" + _getCharDesc(paramInt) + ") in numeric value";
    throw _constructError(str + ": " + paramString);
  }
  
  public final JsonToken reset(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
      return resetInt(paramBoolean, paramInt1);
    }
    return resetFloat(paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public final JsonToken resetAsNaN(String paramString, double paramDouble)
  {
    TextBuffer localTextBuffer = _textBuffer;
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    _resultString = paramString;
    _resultArray = null;
    if (_hasSegments) {
      localTextBuffer.clearSegments();
    }
    _currentSize = 0;
    _numberDouble = paramDouble;
    _numTypesValid = 8;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public final JsonToken resetFloat(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt1;
    _fractLength = paramInt2;
    _expLength = paramInt3;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public final JsonToken resetInt(boolean paramBoolean, int paramInt)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt;
    _fractLength = 0;
    _expLength = 0;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public final Version version()
  {
    return PackageVersion.VERSION;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.base.ParserBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */