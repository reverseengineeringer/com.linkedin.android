package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.data.lite.EnumBuilder;

public enum FlowType
{
  ABI,  INVITATION,  $UNKNOWN;
  
  private FlowType() {}
  
  public static FlowType of(String paramString)
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
    implements EnumBuilder<FlowType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.FlowType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */