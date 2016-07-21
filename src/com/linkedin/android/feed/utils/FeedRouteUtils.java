package com.linkedin.android.feed.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateInfo;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Routes.QueryBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;

public final class FeedRouteUtils
{
  public static Uri getBaseChannelMiniFeedRoute(FragmentComponent paramFragmentComponent, String paramString)
  {
    return Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "findChannelFeed").appendQueryParameter("channelId", paramString).appendQueryParameter("moduleKey", FeedTracking.getModuleKey(paramFragmentComponent)).build();
  }
  
  public static Uri getBaseCommentsRoute(String paramString, SortOrder paramSortOrder)
  {
    Uri.Builder localBuilder = Routes.FEED_COMMENTS.buildUponRoot().buildUpon();
    Routes.QueryBuilder localQueryBuilder = new Routes.QueryBuilder();
    isURLEncoded = true;
    paramString = localQueryBuilder.addQueryParam("q", "comments").addQueryParam("updateId", paramString);
    if (paramSortOrder != null) {
      paramString.addQueryParam("sortOrder", paramSortOrder.toString());
    }
    localBuilder.encodedQuery(paramString.build());
    return localBuilder.build();
  }
  
  public static Uri getBaseFeedUpdatesRoute(FragmentComponent paramFragmentComponent, int paramInt)
  {
    Object localObject = paramFragmentComponent.feedValues();
    Uri.Builder localBuilder = Routes.FEED.buildUponRoot().buildUpon();
    if (((FeedKeyValueStore)localObject).isChronFeedUsed()) {}
    for (localObject = "chronFeed";; localObject = "findFeed")
    {
      localObject = localBuilder.appendQueryParameter("q", (String)localObject).appendQueryParameter("numComments", "2").appendQueryParameter("moduleKey", FeedTracking.getModuleKey(paramFragmentComponent)).appendQueryParameter("numLikes", "2");
      if (paramInt > 0)
      {
        int i = getImageHeight(paramFragmentComponent.context().getResources(), paramInt);
        ((Uri.Builder)localObject).appendQueryParameter("w", String.valueOf(paramInt)).appendQueryParameter("h", String.valueOf(i));
      }
      return ((Uri.Builder)localObject).build();
    }
  }
  
  public static Uri getBaseHighlightedUpdatesRoute(HighlightedUpdateInfo[] paramArrayOfHighlightedUpdateInfo)
  {
    Uri.Builder localBuilder = Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "highlightedFeed");
    int i = 0;
    while (i < paramArrayOfHighlightedUpdateInfo.length)
    {
      localBuilder.appendQueryParameter("highlightedUpdateUrns", urnString).appendQueryParameter("highlightedUpdateTypes", type);
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static Uri getBaseLikesDetailRoute(String paramString, SortOrder paramSortOrder)
  {
    Uri.Builder localBuilder = Routes.FEED_LIKES.buildUponRoot().buildUpon();
    Routes.QueryBuilder localQueryBuilder = new Routes.QueryBuilder();
    isURLEncoded = true;
    paramString = localQueryBuilder.addQueryParam("q", "likes").addQueryParam("objectId", paramString);
    if (paramSortOrder != null) {
      paramString.addQueryParam("sortOrder", paramSortOrder.toString());
    }
    localBuilder.encodedQuery(paramString.build());
    return localBuilder.build();
  }
  
  public static Uri getBaseProfileRecentActivityFeedUpdatesRoute(String paramString)
  {
    return Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "findMemberFeed").appendQueryParameter("profileId", paramString).appendQueryParameter("moduleKey", "member-activity:phone").build();
  }
  
  public static Uri getBaseProfileSharesFeedUpdatesRoute(String paramString)
  {
    return Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "memberShareFeed").appendQueryParameter("profileId", paramString).appendQueryParameter("moduleKey", "member-share:phone").build();
  }
  
  public static Uri getBasePromptResponseUpdatesRoute(FragmentComponent paramFragmentComponent, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = FeedTracking.getModuleKey(paramFragmentComponent);
    localObject = Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "promptFeed").appendQueryParameter("numComments", "2").appendQueryParameter("moduleKey", (String)localObject).appendQueryParameter("numLikes", "2");
    if (!TextUtils.isEmpty(paramString1)) {
      ((Uri.Builder)localObject).appendQueryParameter("promptUrn", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((Uri.Builder)localObject).appendQueryParameter("hiddenVideo", paramString2);
    }
    if (paramInt > 0)
    {
      int i = getImageHeight(paramFragmentComponent.context().getResources(), paramInt);
      ((Uri.Builder)localObject).appendQueryParameter("w", String.valueOf(paramInt)).appendQueryParameter("h", String.valueOf(i));
    }
    return ((Uri.Builder)localObject).build();
  }
  
  public static String getChannelMiniFeedRoute(FragmentComponent paramFragmentComponent, String paramString)
  {
    return getBaseChannelMiniFeedRoute(paramFragmentComponent, paramString).toString();
  }
  
  public static int getCommentCount(LixManager paramLixManager)
  {
    return FeedLixHelper.parseInt$7e416bce(paramLixManager, Lix.FEED_COMMENTS_PAGE_SIZE, 10);
  }
  
  public static String getFeedCommentUrl(LixManager paramLixManager, SponsoredMetadata paramSponsoredMetadata)
  {
    Uri.Builder localBuilder = Routes.FEED_COMMENTS.buildUponRoot().buildUpon();
    paramLixManager = paramLixManager.getTreatment(Lix.FEED_SU_CSP_COMMENT);
    if ((paramSponsoredMetadata != null) && ("su-csp-1".equals(paramLixManager)))
    {
      paramLixManager = Routes.toRestiUriQueryParam(paramSponsoredMetadata);
      return localBuilder.build().toString() + "?sponsoredMetadata=" + paramLixManager;
    }
    if ((paramSponsoredMetadata != null) && ("su-csp-2".equals(paramLixManager)))
    {
      paramLixManager = new Routes.QueryBuilder();
      isURLEncoded = true;
      paramLixManager = paramLixManager.addQueryParam("tscpUrl", tscpUrl);
      if (displayFormat != null) {
        paramLixManager.addQueryParam("displayFormat", displayFormat);
      }
      localBuilder.encodedQuery(paramLixManager.build());
    }
    return localBuilder.build().toString();
  }
  
  public static String getFeedDeleteCommentUrl(Urn paramUrn)
  {
    return Routes.FEED_COMMENTS.buildRouteForId(paramUrn.toString()).toString();
  }
  
  public static String getFeedPageSize(LixManager paramLixManager)
  {
    return String.valueOf(FeedLixHelper.parseInt$7e416bce(paramLixManager, Lix.FEED_PAGE_SIZE, 20));
  }
  
  public static String getFeedUpdatesRoute(FragmentComponent paramFragmentComponent, int paramInt)
  {
    return getBaseFeedUpdatesRoute(paramFragmentComponent, paramInt).buildUpon().appendQueryParameter("start", "0").appendQueryParameter("count", getFeedPageSize(paramFragmentComponent.lixManager())).build().toString();
  }
  
  public static int getImageHeight(Resources paramResources, int paramInt)
  {
    float f = paramResources.getInteger(2131558449);
    return (int)(paramResources.getInteger(2131558448) / f * paramInt);
  }
  
  public static String getProfileRecentActivityFeedUpdatesRoute(String paramString, int paramInt)
  {
    return getBaseProfileRecentActivityFeedUpdatesRoute(paramString).buildUpon().appendQueryParameter("start", "0").appendQueryParameter("count", String.valueOf(paramInt)).build().toString();
  }
  
  public static String getPromptResponseUpdatesRoute(FragmentComponent paramFragmentComponent, int paramInt, String paramString1, String paramString2)
  {
    return getBasePromptResponseUpdatesRoute(paramFragmentComponent, paramInt, paramString1, paramString2).buildUpon().appendQueryParameter("start", "0").appendQueryParameter("count", getFeedPageSize(paramFragmentComponent.lixManager())).build().toString();
  }
  
  public static String getReportUpdateUrl(String paramString)
  {
    return Routes.FEED.buildRouteForId(paramString).buildUpon().appendQueryParameter("action", String.valueOf("flagUpdate")).build().toString();
  }
  
  public static String getSingleCommentUrl(String paramString)
  {
    return Routes.FEED_COMMENTS.buildRouteForId(paramString).buildUpon().build().toString();
  }
  
  public static String getSingleLikeUrl(String paramString)
  {
    return Routes.FEED_LIKES.buildRouteForId(paramString).buildUpon().build().toString();
  }
  
  public static String getSingleUpdateUrl(FragmentComponent paramFragmentComponent, String paramString1, int paramInt, String paramString2)
  {
    paramFragmentComponent = Routes.FEED.buildRouteForId(paramString1).buildUpon().appendQueryParameter("commentCount", String.valueOf(paramInt)).appendQueryParameter("numLikes", "10").appendQueryParameter("moduleKey", FeedTracking.getModuleKey(paramFragmentComponent));
    if (paramString2 != null) {
      paramFragmentComponent.appendQueryParameter("originTrackingId", paramString2);
    }
    return paramFragmentComponent.build().toString();
  }
  
  public static String getSocialDetailUrl(ApplicationComponent paramApplicationComponent, String paramString, SortOrder paramSortOrder)
  {
    paramString = Routes.FEED_SOCIAL.buildRouteForId(paramString).buildUpon();
    if (paramSortOrder != null) {
      paramString.appendQueryParameter("commentSortOrder", paramSortOrder.toString());
    }
    paramString.appendQueryParameter("numComments", String.valueOf(getCommentCount(paramApplicationComponent.lixManager())));
    return paramString.build().toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedRouteUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */