package com.bluelinelabs.logansquare.typeconverters;

import java.text.DateFormat;

public class DefaultDateConverter
  extends DateTypeConverter
{
  private DateFormat mDateFormat = new DefaultDateFormatter();
  
  public DateFormat getDateFormat()
  {
    return mDateFormat;
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.DefaultDateConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */