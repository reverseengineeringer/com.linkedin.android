package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class DiscussionUpdateContent$Content$Builder
{
  public DiscussionBase discussionBaseValue = null;
  public DiscussionWithArticle discussionWithArticleValue = null;
  public DiscussionWithImage discussionWithImageValue = null;
  public boolean hasDiscussionBaseValue = false;
  public boolean hasDiscussionWithArticleValue = false;
  public boolean hasDiscussionWithImageValue = false;
  
  public final DiscussionUpdateContent.Content build()
    throws BuilderException
  {
    int j = 0;
    if (hasDiscussionBaseValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasDiscussionWithArticleValue) {
      i = j + 1;
    }
    j = i;
    if (hasDiscussionWithImageValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Content", j);
    }
    return new DiscussionUpdateContent.Content(discussionBaseValue, discussionWithArticleValue, discussionWithImageValue, hasDiscussionBaseValue, hasDiscussionWithArticleValue, hasDiscussionWithImageValue);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdateContent.Content.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */