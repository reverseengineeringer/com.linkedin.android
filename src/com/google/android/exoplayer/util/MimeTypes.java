package com.google.android.exoplayer.util;

public final class MimeTypes
{
  private static String getTopLevelType(String paramString)
  {
    int i = paramString.indexOf('/');
    if (i == -1) {
      throw new IllegalArgumentException("Invalid mime type: " + paramString);
    }
    return paramString.substring(0, i);
  }
  
  public static boolean isAudio(String paramString)
  {
    return getTopLevelType(paramString).equals("audio");
  }
  
  public static boolean isPassthroughAudio(String paramString)
  {
    return ("audio/ac3".equals(paramString)) || ("audio/eac3".equals(paramString));
  }
  
  public static boolean isVideo(String paramString)
  {
    return getTopLevelType(paramString).equals("video");
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.MimeTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */