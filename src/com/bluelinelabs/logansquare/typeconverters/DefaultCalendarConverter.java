package com.bluelinelabs.logansquare.typeconverters;

import java.text.DateFormat;

public class DefaultCalendarConverter
  extends CalendarTypeConverter
{
  private DateFormat mDateFormat = new DefaultDateFormatter();
  
  public DateFormat getDateFormat()
  {
    return mDateFormat;
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.DefaultCalendarConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */