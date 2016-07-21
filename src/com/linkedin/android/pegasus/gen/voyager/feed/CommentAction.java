package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum CommentAction
{
  DELETE,  REPORT,  $UNKNOWN;
  
  private CommentAction() {}
  
  public static CommentAction of(int paramInt)
  {
    try
    {
      CommentAction localCommentAction = values()[paramInt];
      return localCommentAction;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static CommentAction of(String paramString)
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
    implements EnumBuilder<CommentAction>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CommentAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */