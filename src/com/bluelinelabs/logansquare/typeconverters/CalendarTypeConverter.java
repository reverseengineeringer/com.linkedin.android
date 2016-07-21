package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;

public abstract class CalendarTypeConverter
  implements TypeConverter<Calendar>
{
  private final ThreadLocal<DateFormat> mDateFormat = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      return getDateFormat();
    }
  };
  
  public abstract DateFormat getDateFormat();
  
  public Calendar parse(JsonParser paramJsonParser)
    throws IOException
  {
    paramJsonParser = paramJsonParser.getValueAsString(null);
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(((DateFormat)mDateFormat.get()).parse(paramJsonParser));
      return localCalendar;
    }
    catch (ParseException paramJsonParser) {}
    return null;
  }
  
  public void serialize(Calendar paramCalendar, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStringField(paramString, ((DateFormat)mDateFormat.get()).format(Long.valueOf(paramCalendar.getTimeInMillis())));
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.CalendarTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */