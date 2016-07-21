package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.data.lite.EnumBuilder;

public enum InmailActionType
{
  ACCEPTED,  DECLINED,  RECEIVED,  $UNKNOWN;
  
  private InmailActionType() {}
  
  public static InmailActionType of(int paramInt)
  {
    try
    {
      InmailActionType localInmailActionType = values()[paramInt];
      return localInmailActionType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static InmailActionType of(String paramString)
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
    implements EnumBuilder<InmailActionType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailActionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */