package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HlsParserUtil
{
  public static Pattern compileBooleanAttrPattern(String paramString)
  {
    return Pattern.compile(paramString + "=(YES|NO)");
  }
  
  public static int parseIntAttr(String paramString1, Pattern paramPattern, String paramString2)
    throws ParserException
  {
    return Integer.parseInt(parseStringAttr(paramString1, paramPattern, paramString2));
  }
  
  public static boolean parseOptionalBooleanAttr(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return "YES".equals(paramString.group(1));
    }
    return false;
  }
  
  public static String parseOptionalStringAttr(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public static String parseStringAttr(String paramString1, Pattern paramPattern, String paramString2)
    throws ParserException
  {
    paramPattern = paramPattern.matcher(paramString1);
    if ((paramPattern.find()) && (paramPattern.groupCount() == 1)) {
      return paramPattern.group(1);
    }
    throw new ParserException("Couldn't match " + paramString2 + " tag in " + paramString1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsParserUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */