package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum HighlightedUpdateType
{
  ACCEPTED_INVITATION,  ARTICLE_SHARE,  $UNKNOWN;
  
  private HighlightedUpdateType() {}
  
  public static HighlightedUpdateType of(int paramInt)
  {
    try
    {
      HighlightedUpdateType localHighlightedUpdateType = values()[paramInt];
      return localHighlightedUpdateType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static HighlightedUpdateType of(String paramString)
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
    implements EnumBuilder<HighlightedUpdateType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.HighlightedUpdateType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */