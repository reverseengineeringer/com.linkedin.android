package com.bluelinelabs.logansquare.typeconverters;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DefaultDateFormatter
  extends SimpleDateFormat
{
  public DefaultDateFormatter()
  {
    super("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
    setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  private String getFixedInputString(String paramString)
  {
    if (paramString != null) {
      return paramString.replaceAll("Z$", "+0000");
    }
    return null;
  }
  
  public Date parse(String paramString)
    throws ParseException
  {
    return super.parse(getFixedInputString(paramString));
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    return super.parse(getFixedInputString(paramString), paramParsePosition);
  }
  
  public Object parseObject(String paramString)
    throws ParseException
  {
    return super.parseObject(getFixedInputString(paramString));
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    return super.parseObject(getFixedInputString(paramString), paramParsePosition);
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.DefaultDateFormatter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */