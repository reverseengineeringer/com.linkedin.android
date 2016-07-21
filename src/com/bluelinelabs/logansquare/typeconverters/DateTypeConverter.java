package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class DateTypeConverter
  implements TypeConverter<Date>
{
  private final ThreadLocal<DateFormat> mDateFormat = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      return getDateFormat();
    }
  };
  
  public abstract DateFormat getDateFormat();
  
  public Date parse(JsonParser paramJsonParser)
    throws IOException
  {
    paramJsonParser = paramJsonParser.getValueAsString(null);
    if (paramJsonParser != null) {
      try
      {
        paramJsonParser = ((DateFormat)mDateFormat.get()).parse(paramJsonParser);
        return paramJsonParser;
      }
      catch (ParseException paramJsonParser)
      {
        return null;
      }
    }
    return null;
  }
  
  public void serialize(Date paramDate, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if (paramDate != null)
    {
      paramJsonGenerator.writeStringField(paramString, ((DateFormat)mDateFormat.get()).format(paramDate));
      return;
    }
    paramJsonGenerator.writeFieldName(paramString);
    paramJsonGenerator.writeNull();
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.DateTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */