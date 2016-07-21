package com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar;

import com.linkedin.data.lite.EnumBuilder;

public enum MeetingStatus
{
  CONCLUDED,  SCHEDULED,  $UNKNOWN;
  
  private MeetingStatus() {}
  
  public static MeetingStatus of(int paramInt)
  {
    try
    {
      MeetingStatus localMeetingStatus = values()[paramInt];
      return localMeetingStatus;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static MeetingStatus of(String paramString)
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
    implements EnumBuilder<MeetingStatus>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */