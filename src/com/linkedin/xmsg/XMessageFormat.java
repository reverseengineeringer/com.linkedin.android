package com.linkedin.xmsg;

import com.linkedin.xmsg.util.PseudoUtils;
import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class XMessageFormat
{
  private Message message;
  
  public XMessageFormat(String paramString)
  {
    this(paramString, Locale.getDefault());
  }
  
  public XMessageFormat(String paramString, Locale paramLocale)
  {
    paramLocale = new MessageParser(paramLocale, false);
    try
    {
      message = paramLocale.parse(paramString);
      return;
    }
    catch (ParseException paramLocale)
    {
      throw new IllegalArgumentException(formatExceptionMessage(paramString, paramLocale));
    }
  }
  
  /* Error */
  public XMessageFormat(String paramString, Locale paramLocale, ResourceBundle paramResourceBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	java/lang/Object:<init>	()V
    //   4: aload_3
    //   5: ifnonnull +13 -> 18
    //   8: new 36	java/lang/IllegalArgumentException
    //   11: dup
    //   12: ldc 47
    //   14: invokespecial 42	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_3
    //   19: aload_1
    //   20: invokevirtual 53	java/util/ResourceBundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: new 25	com/linkedin/xmsg/MessageParser
    //   28: dup
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokespecial 56	com/linkedin/xmsg/MessageParser:<init>	(Ljava/util/Locale;Ljava/util/ResourceBundle;Z)V
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: aload 4
    //   40: invokevirtual 32	com/linkedin/xmsg/MessageParser:parse	(Ljava/lang/String;)Lcom/linkedin/xmsg/Message;
    //   43: putfield 34	com/linkedin/xmsg/XMessageFormat:message	Lcom/linkedin/xmsg/Message;
    //   46: return
    //   47: astore_2
    //   48: new 36	java/lang/IllegalArgumentException
    //   51: dup
    //   52: new 58	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 60
    //   58: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 67
    //   67: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 42	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: astore_1
    //   78: new 36	java/lang/IllegalArgumentException
    //   81: dup
    //   82: aload_0
    //   83: aload 4
    //   85: aload_1
    //   86: invokespecial 40	com/linkedin/xmsg/XMessageFormat:formatExceptionMessage	(Ljava/lang/String;Ljava/text/ParseException;)Ljava/lang/String;
    //   89: invokespecial 42	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	XMessageFormat
    //   0	93	1	paramString	String
    //   0	93	2	paramLocale	Locale
    //   0	93	3	paramResourceBundle	ResourceBundle
    //   23	61	4	str	String
    // Exception table:
    //   from	to	target	type
    //   18	25	47	java/util/MissingResourceException
    //   36	46	77	java/text/ParseException
  }
  
  public XMessageFormat(String paramString, ResourceBundle paramResourceBundle)
  {
    this(paramString, Locale.getDefault(), paramResourceBundle);
  }
  
  public static String format(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    return new XMessageFormat(paramString1, Locale.getDefault(), ResourceBundle.getBundle(paramString2)).format(paramMap);
  }
  
  public static String format(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    return new XMessageFormat(paramString1, Locale.getDefault(), ResourceBundle.getBundle(paramString2)).format(paramArrayOfObject);
  }
  
  public static String format(String paramString, Locale paramLocale, ResourceBundle paramResourceBundle, Map<String, Object> paramMap)
  {
    return new XMessageFormat(paramString, paramLocale, paramResourceBundle).format(paramMap);
  }
  
  public static String format(String paramString, Locale paramLocale, ResourceBundle paramResourceBundle, Object[] paramArrayOfObject)
  {
    return new XMessageFormat(paramString, paramLocale, paramResourceBundle).format(paramArrayOfObject);
  }
  
  public static String format(String paramString, Map<String, Object> paramMap)
  {
    return new XMessageFormat(paramString).format(paramMap);
  }
  
  public static String format(String paramString, Map<String, Object> paramMap, Locale paramLocale)
  {
    return new XMessageFormat(paramString, paramLocale).format(paramMap);
  }
  
  public static String format(String paramString, Map<String, Object> paramMap1, Locale paramLocale, Map<String, Object> paramMap2)
  {
    return new XMessageFormat(paramString, paramLocale).format(paramMap1, paramMap2);
  }
  
  public static String format(String paramString, Object[] paramArrayOfObject)
  {
    return new XMessageFormat(paramString).format(paramArrayOfObject);
  }
  
  public static String format(String paramString, Object[] paramArrayOfObject, Locale paramLocale)
  {
    return new XMessageFormat(paramString, paramLocale).format(paramArrayOfObject);
  }
  
  public static String format(String paramString, Object[] paramArrayOfObject, Locale paramLocale, Map<String, Object> paramMap)
  {
    return new XMessageFormat(paramString, paramLocale).format(paramArrayOfObject, paramMap);
  }
  
  private String formatExceptionMessage(String paramString, ParseException paramParseException)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramParseException.getMessage());
    localStringBuilder.append(": \"");
    int i1 = paramParseException.getErrorOffset();
    int i = 0;
    if (i1 > 15)
    {
      i = i1 - 15;
      localStringBuilder.append("...");
    }
    int n = i1 + 15;
    int m = 1;
    int j = n;
    int k = i;
    if (n > paramString.length())
    {
      j = paramString.length();
      m = 0;
      k = i;
    }
    while (k < j)
    {
      char c2 = paramString.charAt(k);
      char c1 = c2;
      if (Character.isISOControl(c2)) {
        c1 = ' ';
      }
      localStringBuilder.append(c1);
      if (k == i1) {
        localStringBuilder.append("<<<");
      }
      k += 1;
    }
    if (m != 0) {
      localStringBuilder.append("...");
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public static void setPseudoLocale(Locale paramLocale)
  {
    PseudoUtils.setPseudoLocale(paramLocale);
  }
  
  public String format(Map<String, Object> paramMap)
  {
    return format(paramMap, Collections.EMPTY_MAP);
  }
  
  public String format(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    return format(new Object[] { paramMap1 }, paramMap2);
  }
  
  public String format(Object[] paramArrayOfObject)
  {
    return format(paramArrayOfObject, Collections.EMPTY_MAP);
  }
  
  public String format(Object[] paramArrayOfObject, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    message.format(paramArrayOfObject, paramMap, localStringBuilder);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.xmsg.XMessageFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */