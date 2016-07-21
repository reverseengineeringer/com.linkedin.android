package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.growth.onboarding.rbmf.PackageRecommendationTrackingHelper;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class UnfollowEducateAdapter$1
  extends TrackingOnClickListener
{
  UnfollowEducateAdapter$1(UnfollowEducateAdapter paramUnfollowEducateAdapter, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, UnfollowEducateRowHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    int j = val$holder.getAdapterPosition();
    UnfollowEducateAdapter localUnfollowEducateAdapter = this$0;
    paramView = (TextView)paramView;
    boolean bool;
    int i;
    label72:
    RecommendedEntity localRecommendedEntity;
    String str;
    FollowingInfo localFollowingInfo;
    if (!((Boolean)followedStates.get(j)).booleanValue())
    {
      bool = true;
      followedStates.set(j, Boolean.valueOf(bool));
      if (!bool) {
        break label182;
      }
      i = 2131231223;
      paramView.setText(i);
      localRecommendedEntity = (RecommendedEntity)items.get(j);
      if (recommendedMemberValue == null) {
        break label188;
      }
      paramView = recommendedMemberValue;
      str = miniProfile.entityUrn.getId();
      localFollowingInfo = followingInfo;
      paramView = Routes.PROFILE;
    }
    for (;;)
    {
      if (str != null) {
        followPublisher.toggleFollow(str, paramView, localFollowingInfo, null);
      }
      if (!bool) {
        unfollowedCount.incrementAndGet();
      }
      trackingHelper.firePackageRecommendationActionEvent(-1, 0, false, localRecommendedEntity);
      return;
      bool = false;
      break;
      label182:
      i = 2131231215;
      break label72;
      label188:
      if (recommendedCompanyValue != null)
      {
        paramView = recommendedCompanyValue;
        str = _cachedId;
        localFollowingInfo = followingInfo;
        paramView = Routes.COMPANY;
      }
      else if (recommendedChannelValue != null)
      {
        paramView = recommendedChannelValue;
        str = _cachedId;
        localFollowingInfo = channel.followingInfo;
        paramView = Routes.CHANNELS;
      }
      else
      {
        paramView = null;
        localFollowingInfo = null;
        str = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */