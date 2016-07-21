package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.EnumBuilder;

public enum StickerAction
{
  SELECT,  $UNKNOWN;
  
  private StickerAction() {}
  
  public static StickerAction of(String paramString)
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
    implements EnumBuilder<StickerAction>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */