package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.data.lite.EnumBuilder;

public enum SuggestionSource
{
  EMAIL,  GUIDED_EDIT,  NOTIFICATION,  $UNKNOWN;
  
  private SuggestionSource() {}
  
  public static SuggestionSource of(String paramString)
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
    implements EnumBuilder<SuggestionSource>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestionSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */