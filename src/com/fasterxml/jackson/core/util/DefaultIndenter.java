package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public final class DefaultIndenter
  extends DefaultPrettyPrinter.NopIndenter
{
  public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE;
  public static final String SYS_LF;
  private final int charsPerLevel;
  private final String eol;
  private final char[] indents;
  
  static
  {
    try
    {
      String str1 = System.getProperty("line.separator");
      SYS_LF = str1;
      SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2 = "\n";
      }
    }
  }
  
  public DefaultIndenter()
  {
    this("  ", SYS_LF);
  }
  
  private DefaultIndenter(String paramString1, String paramString2)
  {
    charsPerLevel = paramString1.length();
    indents = new char[paramString1.length() * 16];
    int j = 0;
    int i = 0;
    while (i < 16)
    {
      paramString1.getChars(0, paramString1.length(), indents, j);
      j += paramString1.length();
      i += 1;
    }
    eol = paramString2;
  }
  
  public final boolean isInline()
  {
    return false;
  }
  
  public final void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException
  {
    paramJsonGenerator.writeRaw(eol);
    if (paramInt > 0)
    {
      paramInt *= charsPerLevel;
      while (paramInt > indents.length)
      {
        paramJsonGenerator.writeRaw(indents, 0, indents.length);
        paramInt -= indents.length;
      }
      paramJsonGenerator.writeRaw(indents, 0, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */