package com.linkedin.android.feed.endor.datamodel;

import android.support.annotation.Keep;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;

public class FeedDataModelMetadata$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */