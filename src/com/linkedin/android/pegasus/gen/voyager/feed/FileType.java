package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum FileType
{
  DOC,  PPT,  XLS,  $UNKNOWN;
  
  private FileType() {}
  
  public static FileType of(int paramInt)
  {
    try
    {
      FileType localFileType = values()[paramInt];
      return localFileType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static FileType of(String paramString)
  {
    try
    {
      paramString = valueOf(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return $UNKNOWN;
  }
  
  public static final class Builder
    implements EnumBuilder<FileType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.FileType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */