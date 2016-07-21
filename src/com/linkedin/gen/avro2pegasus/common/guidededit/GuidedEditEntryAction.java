package com.linkedin.gen.avro2pegasus.common.guidededit;

import com.linkedin.data.lite.EnumBuilder;

public enum GuidedEditEntryAction
{
  DISMISS,  ENTER,  NOT_MINE,  $UNKNOWN;
  
  private GuidedEditEntryAction() {}
  
  public static GuidedEditEntryAction of(String paramString)
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
    implements EnumBuilder<GuidedEditEntryAction>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEntryAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */