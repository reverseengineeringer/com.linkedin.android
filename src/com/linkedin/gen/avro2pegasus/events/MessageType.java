package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.EnumBuilder;

public enum MessageType
{
  EMAIL,  PUSHNOTIFICATION,  SMS,  $UNKNOWN;
  
  private MessageType() {}
  
  public static MessageType of(String paramString)
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
    implements EnumBuilder<MessageType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MessageType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */