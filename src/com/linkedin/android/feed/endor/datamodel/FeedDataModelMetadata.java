package com.linkedin.android.feed.endor.datamodel;

import android.support.annotation.Keep;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;

public final class FeedDataModelMetadata
{
  public static final FeedDataModelMetadata DEFAULT = new Builder().build();
  public final String[] highlightedCommentUrns;
  public final Like highlightedLike;
  public final String[] highlightedReplyUrns;
  public final boolean isHorizontalCarouselUpdate;
  public final int pendingState;
  public final String searchId;
  
  private FeedDataModelMetadata(Like paramLike, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, int paramInt, boolean paramBoolean)
  {
    highlightedLike = paramLike;
    highlightedCommentUrns = paramArrayOfString1;
    highlightedReplyUrns = paramArrayOfString2;
    pendingState = paramInt;
    searchId = paramString;
    isHorizontalCarouselUpdate = paramBoolean;
  }
  
  public static class Builder
  {
    public String[] highlightedCommentUrns;
    public Like highlightedLike;
    public String[] highlightedReplyUrns;
    private boolean isHorizontalCarouselUpdate;
    public int pendingState;
    public String searchId;
    
    public final FeedDataModelMetadata build()
    {
      return new FeedDataModelMetadata(highlightedLike, highlightedCommentUrns, highlightedReplyUrns, searchId, pendingState, isHorizontalCarouselUpdate, (byte)0);
    }
    
    @Keep
    public Builder setIsHorizontalCarouselUpdate(boolean paramBoolean)
    {
      isHorizontalCarouselUpdate = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */