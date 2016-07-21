package com.linkedin.android.feed.updates.common.likes.detail;

import android.net.Uri;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import java.util.Map;

final class LikesDetailFragment$1
  extends InfiniteScrollListener
{
  LikesDetailFragment$1(LikesDetailFragment paramLikesDetailFragment) {}
  
  public final void loadMore()
  {
    if ((LikesDetailFragment.access$000(this$0) == null) || (access$000this$0).threadId == null)) {}
    while ((!LikesDetailFragment.access$100(this$0)) || (LikesDetailFragment.access$200(this$0)) || (!LikesDetailFragment.access$300(this$0).hasMoreLikes())) {
      return;
    }
    LikesDetailFragment.access$202(this$0, true);
    Object localObject2 = access$000this$0).threadId;
    Object localObject1 = LikesDetailFragment.access$000(this$0);
    if ((localObject1 != null) && (likes.metadata != null) && (likes.metadata.sort != null)) {}
    Map localMap;
    String str;
    for (localObject1 = likes.metadata.sort;; localObject1 = SortOrder.$UNKNOWN)
    {
      localObject1 = FeedRouteUtils.getBaseLikesDetailRoute((String)localObject2, (SortOrder)localObject1);
      localObject2 = LikesDetailFragment.access$300(this$0);
      localMap = Tracker.createPageInstanceHeader(this$0.getPageInstance());
      str = this$0.getRumSessionId();
      if (state).collectionHelper != null) {
        break;
      }
      Util.safeThrow(new RuntimeException("Collection helper is null. Please make sure initWithCollectionTemplatehas been called"));
      return;
    }
    state).collectionHelper.fetchLoadMoreData(localMap, 1, null, (Uri)localObject1, ((LikesDataProvider)localObject2).modelListener(true), str);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */