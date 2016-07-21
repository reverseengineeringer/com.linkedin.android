package com.linkedin.android.pegasus.gen.voyager.search.shared;

import com.linkedin.data.lite.EnumBuilder;

public enum SpellingCorrectionType
{
  DID_YOU_MEAN,  REWRITE,  $UNKNOWN;
  
  private SpellingCorrectionType() {}
  
  public static SpellingCorrectionType of(int paramInt)
  {
    try
    {
      SpellingCorrectionType localSpellingCorrectionType = values()[paramInt];
      return localSpellingCorrectionType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SpellingCorrectionType of(String paramString)
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
    implements EnumBuilder<SpellingCorrectionType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.shared.SpellingCorrectionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */