package com.google.android.exoplayer.metadata;

import java.util.Map;

public final class Id3Parser
  implements MetadataParser<Map<String, Object>>
{
  private static int delimiterLength(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3)) {
      return 1;
    }
    return 2;
  }
  
  private static String getCharsetName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ISO-8859-1";
    case 0: 
      return "ISO-8859-1";
    case 1: 
      return "UTF-16";
    case 2: 
      return "UTF-16BE";
    }
    return "UTF-8";
  }
  
  private static int indexOf$1cf981f8(byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt] == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramArrayOfByte.length;
  }
  
  private static int indexOfEOS(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = indexOf$1cf981f8(paramArrayOfByte, paramInt1);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (paramInt2 != 3) {}
    }
    else
    {
      return i;
    }
    do
    {
      paramInt1 = indexOf$1cf981f8(paramArrayOfByte, paramInt1 + 1);
      if (paramInt1 >= paramArrayOfByte.length - 1) {
        break;
      }
    } while (paramArrayOfByte[(paramInt1 + 1)] != 0);
    return paramInt1;
    return paramArrayOfByte.length;
  }
  
  public final boolean canParse(String paramString)
  {
    return paramString.equals("application/id3");
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.metadata.Id3Parser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */