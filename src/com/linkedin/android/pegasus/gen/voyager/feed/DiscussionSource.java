package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum DiscussionSource
{
  ORGANIC,  RECOMMENDED,  $UNKNOWN;
  
  private DiscussionSource() {}
  
  public static DiscussionSource of(int paramInt)
  {
    try
    {
      DiscussionSource localDiscussionSource = values()[paramInt];
      return localDiscussionSource;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static DiscussionSource of(String paramString)
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
    implements EnumBuilder<DiscussionSource>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */