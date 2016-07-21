package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.data.lite.EnumBuilder;

public enum SuggestionSourceType
{
  INFERRED,  INGESTED,  $UNKNOWN;
  
  private SuggestionSourceType() {}
  
  public static SuggestionSourceType of(int paramInt)
  {
    try
    {
      SuggestionSourceType localSuggestionSourceType = values()[paramInt];
      return localSuggestionSourceType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SuggestionSourceType of(String paramString)
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
    implements EnumBuilder<SuggestionSourceType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.SuggestionSourceType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */