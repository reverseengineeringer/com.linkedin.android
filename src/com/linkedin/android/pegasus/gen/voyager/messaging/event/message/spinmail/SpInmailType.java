package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

import com.linkedin.data.lite.EnumBuilder;

public enum SpInmailType
{
  LANDING_PAGE,  LEADGEN,  $UNKNOWN;
  
  private SpInmailType() {}
  
  public static SpInmailType of(int paramInt)
  {
    try
    {
      SpInmailType localSpInmailType = values()[paramInt];
      return localSpInmailType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SpInmailType of(String paramString)
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
    implements EnumBuilder<SpInmailType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */