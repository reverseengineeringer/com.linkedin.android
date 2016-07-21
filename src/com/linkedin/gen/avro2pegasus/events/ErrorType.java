package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.EnumBuilder;

public enum ErrorType
{
  CRASH,  LOGGED_ERROR,  $UNKNOWN;
  
  private ErrorType() {}
  
  public static ErrorType of(String paramString)
  {
    try
    {
      paramString = valueOf(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return $UNKNOWN;
  }
  
  public static final class Builder
    implements EnumBuilder<ErrorType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ErrorType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */