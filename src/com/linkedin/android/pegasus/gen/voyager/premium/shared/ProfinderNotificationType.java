package com.linkedin.android.pegasus.gen.voyager.premium.shared;

import com.linkedin.data.lite.EnumBuilder;

public enum ProfinderNotificationType
{
  PROFINDER_SERVICE_PROPOSAL_24_HOUR_REMINDER,  PROFINDER_SERVICE_PROPOSAL_48_HOUR_REMINDER,  PROFINDER_SERVICE_PROPOSAL_4_DAY_REMINDER,  PROFINDER_SERVICE_PROPOSAL_7_DAY_REMINDER,  $UNKNOWN;
  
  private ProfinderNotificationType() {}
  
  public static ProfinderNotificationType of(int paramInt)
  {
    try
    {
      ProfinderNotificationType localProfinderNotificationType = values()[paramInt];
      return localProfinderNotificationType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static ProfinderNotificationType of(String paramString)
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
    implements EnumBuilder<ProfinderNotificationType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.shared.ProfinderNotificationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */