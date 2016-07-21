package com.linkedin.android.feed.channel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;

final class ChannelFragment$4
  extends RecyclerView.OnScrollListener
{
  ChannelFragment$4(ChannelFragment paramChannelFragment) {}
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = this$0;
    if (layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1)
    {
      String str = RUMHelper.pageInitLoadMore(paramRecyclerView);
      channelUpdatesDataProvider.loadMoreData$727f7092(Tracker.createPageInstanceHeader(paramRecyclerView.getPageInstance()), str, FeedRouteUtils.getBaseChannelMiniFeedRoute(fragmentComponent, channel.entityUrn.getId()));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */