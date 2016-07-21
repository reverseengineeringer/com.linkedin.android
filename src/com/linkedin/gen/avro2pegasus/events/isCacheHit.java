package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.EnumBuilder;

public enum isCacheHit
{
  HIT,  MISS,  UNKNOWN,  $UNKNOWN;
  
  private isCacheHit() {}
  
  public static isCacheHit of(String paramString)
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
    implements EnumBuilder<isCacheHit>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.isCacheHit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */