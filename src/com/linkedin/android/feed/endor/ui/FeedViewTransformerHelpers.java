package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.infra.components.FragmentComponent;

public final class FeedViewTransformerHelpers
{
  public static int getFeedType(FragmentComponent paramFragmentComponent)
  {
    if ((paramFragmentComponent.fragment() instanceof FeedPageType)) {
      return ((FeedPageType)paramFragmentComponent.fragment()).feedType();
    }
    return -1;
  }
  
  public static boolean isAggregateFeedPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 4;
  }
  
  public static boolean isChannelFeedPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 3;
  }
  
  public static boolean isCommentDetailPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 13;
  }
  
  public static boolean isCompanyTab(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 7;
  }
  
  public static boolean isDetailPage(FragmentComponent paramFragmentComponent)
  {
    int i = getFeedType(paramFragmentComponent);
    return (i == 1) || (i == 8) || (i == 9);
  }
  
  public static boolean isFeedPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 0;
  }
  
  public static boolean isGroupTab(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 6;
  }
  
  public static boolean isImageViewerPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 2;
  }
  
  public static boolean isLikesDetailPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 15;
  }
  
  public static boolean isPromptResponseListPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 14;
  }
  
  public static boolean isPropDetailPage(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 8;
  }
  
  public static boolean isSharePreview(FragmentComponent paramFragmentComponent)
  {
    return getFeedType(paramFragmentComponent) == 16;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */