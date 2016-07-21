package com.linkedin.android.video.model;

import java.lang.annotation.Annotation;

public class VideoType
{
  public static final int AAC = 8;
  public static final int DASH = 0;
  public static final int HLS = 2;
  public static final int M4A = 5;
  public static final int MP3 = 4;
  public static final int MP4 = 3;
  public static final int SS = 1;
  public static final int TS = 7;
  public static final int WEBM = 6;
  
  @Type
  public static int videoTypeToInt(String paramString)
    throws IllegalArgumentException
  {
    if (paramString.equalsIgnoreCase("AAC")) {
      return 8;
    }
    if (paramString.equalsIgnoreCase("DASH")) {
      return 0;
    }
    if (paramString.equalsIgnoreCase("HLS")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("M4A")) {
      return 5;
    }
    if (paramString.equalsIgnoreCase("MP3")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("MP4")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("SS")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("TS")) {
      return 7;
    }
    if (paramString.equalsIgnoreCase("WEBM")) {
      return 6;
    }
    throw new IllegalArgumentException(paramString + " is not a valid video type");
  }
  
  public static String videoTypeToString(@Type int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 8: 
      return "AAC";
    case 0: 
      return "DASH";
    case 2: 
      return "HLS";
    case 5: 
      return "M4A";
    case 4: 
      return "MP3";
    case 3: 
      return "MP4";
    case 1: 
      return "SS";
    case 7: 
      return "TS";
    }
    return "WEBM";
  }
  
  public static @interface Type {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.video.model.VideoType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */