package com.linkedin.xmsg.util;

public class StringUtils
{
  public static final String EMPTY = "";
  public static final int INDEX_NOT_FOUND = -1;
  private static final int PAD_LIMIT = 8192;
  
  public static String capitalize(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0) {}
    }
    else
    {
      return paramString;
    }
    return i + Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1);
  }
  
  public static boolean isBlank(String paramString)
  {
    int j;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {
        break label15;
      }
    }
    for (;;)
    {
      return true;
      label15:
      int i = 0;
      while (i < j)
      {
        if (!Character.isWhitespace(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isNotBlank(String paramString)
  {
    return !isBlank(paramString);
  }
  
  public static boolean isNotEmpty(String paramString)
  {
    return !isEmpty(paramString);
  }
  
  public static String toSafeString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.xmsg.util.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */