package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import java.io.IOException;

public abstract class ParserMinimalBase
  extends JsonParser
{
  public JsonToken _currToken;
  
  protected static final String _getCharDesc(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c)) {
      return "(CTRL-CHAR, code " + paramInt + ")";
    }
    if (paramInt > 255) {
      return "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
    }
    return "'" + c + "' (code " + paramInt + ")";
  }
  
  protected abstract void _handleEOF()
    throws JsonParseException;
  
  public final char _handleUnrecognizedCharacterEscape(char paramChar)
    throws JsonProcessingException
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {}
    while ((paramChar == '\'') && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return paramChar;
    }
    throw _constructError("Unrecognized character escape " + _getCharDesc(paramChar));
  }
  
  protected final void _reportInvalidEOF()
    throws JsonParseException
  {
    _reportInvalidEOF(" in " + _currToken);
  }
  
  public final void _reportInvalidEOF(String paramString)
    throws JsonParseException
  {
    throw _constructError("Unexpected end-of-input" + paramString);
  }
  
  public final void _reportMissingRootWS(int paramInt)
    throws JsonParseException
  {
    _reportUnexpectedChar(paramInt, "Expected space separating root-level values");
  }
  
  public final void _reportUnexpectedChar(int paramInt, String paramString)
    throws JsonParseException
  {
    if (paramInt < 0) {
      _reportInvalidEOF();
    }
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ")";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    throw _constructError(str1);
  }
  
  public final void _throwInvalidSpace(int paramInt)
    throws JsonParseException
  {
    paramInt = (char)paramInt;
    throw _constructError("Illegal character (" + _getCharDesc(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }
  
  public final void _throwUnquotedSpace(int paramInt, String paramString)
    throws JsonParseException
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (paramInt > 32))
    {
      paramInt = (char)paramInt;
      throw _constructError("Illegal unquoted character (" + _getCharDesc(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }
  
  protected final void _wrapError(String paramString, Throwable paramThrowable)
    throws JsonParseException
  {
    throw new JsonParseException(paramString, getCurrentLocation(), paramThrowable);
  }
  
  public final JsonToken getCurrentToken()
  {
    return _currToken;
  }
  
  public abstract String getText()
    throws IOException;
  
  public final boolean getValueAsBoolean$138603()
    throws IOException
  {
    boolean bool2 = true;
    Object localObject = _currToken;
    boolean bool1;
    if (localObject != null) {
      bool1 = bool2;
    }
    switch (_id)
    {
    case 8: 
    default: 
      bool1 = false;
    case 9: 
    case 6: 
    case 7: 
      do
      {
        do
        {
          return bool1;
          localObject = getText().trim();
          bool1 = bool2;
        } while ("true".equals(localObject));
        if ("false".equals(localObject)) {
          return false;
        }
        if (!"null".equals(localObject)) {
          break;
        }
        return false;
        bool1 = bool2;
      } while (getIntValue() != 0);
      return false;
    }
    return false;
  }
  
  public final double getValueAsDouble$133357()
    throws IOException
  {
    Object localObject = _currToken;
    if (localObject != null) {}
    switch (_id)
    {
    case 10: 
    case 11: 
    default: 
    case 6: 
      do
      {
        return 0.0D;
        localObject = getText();
      } while ("null".equals(localObject));
      return NumberInput.parseAsDouble$505d11f3((String)localObject);
    case 7: 
    case 8: 
      return getDoubleValue();
    }
    return 1.0D;
  }
  
  public final int getValueAsInt$134621()
    throws IOException
  {
    Object localObject = _currToken;
    if (localObject != null) {}
    switch (_id)
    {
    case 10: 
    case 11: 
    default: 
    case 6: 
      do
      {
        return 0;
        localObject = getText();
      } while ("null".equals(localObject));
      return NumberInput.parseAsInt$505cff29((String)localObject);
    case 7: 
    case 8: 
      return getIntValue();
    }
    return 1;
  }
  
  public final long getValueAsLong$1349e3()
    throws IOException
  {
    Object localObject = _currToken;
    if (localObject != null) {}
    switch (_id)
    {
    case 10: 
    case 11: 
    default: 
    case 6: 
      do
      {
        return 0L;
        localObject = getText();
      } while ("null".equals(localObject));
      return NumberInput.parseAsLong$505cfb67((String)localObject);
    case 7: 
    case 8: 
      return getLongValue();
    }
    return 1L;
  }
  
  public String getValueAsString(String paramString)
    throws IOException
  {
    if ((_currToken != JsonToken.VALUE_STRING) && ((_currToken == null) || (_currToken == JsonToken.VALUE_NULL) || (!_currToken._isScalar))) {
      return paramString;
    }
    return getText();
  }
  
  public abstract JsonToken nextToken()
    throws IOException;
  
  public final JsonParser skipChildren()
    throws IOException
  {
    if ((_currToken != JsonToken.START_OBJECT) && (_currToken != JsonToken.START_ARRAY)) {
      return this;
    }
    int i = 1;
    int j;
    do
    {
      JsonToken localJsonToken;
      do
      {
        for (;;)
        {
          localJsonToken = nextToken();
          if (localJsonToken == null)
          {
            _handleEOF();
            return this;
          }
          if (!_isStructStart) {
            break;
          }
          i += 1;
        }
      } while (!_isStructEnd);
      j = i - 1;
      i = j;
    } while (j != 0);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.base.ParserMinimalBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */