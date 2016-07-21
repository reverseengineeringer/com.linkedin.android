package com.linkedin.android.pegasus.gen.voyager.messaging.create.message;

import com.linkedin.data.lite.EnumBuilder;

public enum InmailAction
{
  ACCEPT,  DECLINE,  $UNKNOWN;
  
  private InmailAction() {}
  
  public static InmailAction of(int paramInt)
  {
    try
    {
      InmailAction localInmailAction = values()[paramInt];
      return localInmailAction;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static InmailAction of(String paramString)
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
    implements EnumBuilder<InmailAction>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */