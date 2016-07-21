package com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation;

import com.linkedin.data.lite.EnumBuilder;

public enum FormatType
{
  BOLD,  ITALIC,  $UNKNOWN;
  
  private FormatType() {}
  
  public static FormatType of(int paramInt)
  {
    try
    {
      FormatType localFormatType = values()[paramInt];
      return localFormatType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static FormatType of(String paramString)
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
    implements EnumBuilder<FormatType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.FormatType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */