package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.EnumBuilder;

public enum EndorsementStatus
{
  ACCEPTED,  PENDING,  $UNKNOWN;
  
  private EndorsementStatus() {}
  
  public static EndorsementStatus of(int paramInt)
  {
    try
    {
      EndorsementStatus localEndorsementStatus = values()[paramInt];
      return localEndorsementStatus;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static EndorsementStatus of(String paramString)
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
    implements EnumBuilder<EndorsementStatus>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */