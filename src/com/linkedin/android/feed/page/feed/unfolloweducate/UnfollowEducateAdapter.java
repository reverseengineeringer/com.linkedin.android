package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.growth.onboarding.rbmf.PackageRecommendationTrackingHelper;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class UnfollowEducateAdapter
  extends RecyclerView.Adapter<UnfollowEducateRowHolder>
{
  FollowPublisher followPublisher;
  List<Boolean> followedStates;
  private final WeakReference<FragmentComponent> fragmentComponentRef;
  private I18NManager i18Manager;
  List<RecommendedEntity> items;
  private LayoutInflater layoutInflater;
  private MediaCenter mediaCenter;
  private Tracker tracker;
  PackageRecommendationTrackingHelper trackingHelper;
  final AtomicInteger unfollowedCount = new AtomicInteger(0);
  
  public UnfollowEducateAdapter(FragmentComponent paramFragmentComponent, PackageRecommendationTrackingHelper paramPackageRecommendationTrackingHelper, List<RecommendedEntity> paramList)
  {
    layoutInflater = paramFragmentComponent.activity().getLayoutInflater();
    items = paramList;
    initializeFollowedState();
    mediaCenter = activityapplicationComponent.mediaCenter();
    i18Manager = paramFragmentComponent.i18NManager();
    followPublisher = paramFragmentComponent.followPublisher();
    tracker = paramFragmentComponent.tracker();
    trackingHelper = paramPackageRecommendationTrackingHelper;
    fragmentComponentRef = new WeakReference(paramFragmentComponent);
  }
  
  private void bindValues(final UnfollowEducateRowHolder paramUnfollowEducateRowHolder, String paramString1, String paramString2, ImageModel paramImageModel, boolean paramBoolean)
  {
    title.setText(paramString1);
    subTitle.setText(paramString2);
    paramString1 = followStatus;
    if (paramBoolean) {}
    for (int i = 2131231223;; i = 2131231215)
    {
      paramString1.setText(i);
      followStatus.setOnClickListener(new TrackingOnClickListener(tracker, "unfollow", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          int j = paramUnfollowEducateRowHolder.getAdapterPosition();
          UnfollowEducateAdapter localUnfollowEducateAdapter = UnfollowEducateAdapter.this;
          paramAnonymousView = (TextView)paramAnonymousView;
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
            paramAnonymousView.setText(i);
            localRecommendedEntity = (RecommendedEntity)items.get(j);
            if (recommendedMemberValue == null) {
              break label188;
            }
            paramAnonymousView = recommendedMemberValue;
            str = miniProfile.entityUrn.getId();
            localFollowingInfo = followingInfo;
            paramAnonymousView = Routes.PROFILE;
          }
          for (;;)
          {
            if (str != null) {
              followPublisher.toggleFollow(str, paramAnonymousView, localFollowingInfo, null);
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
              paramAnonymousView = recommendedCompanyValue;
              str = _cachedId;
              localFollowingInfo = followingInfo;
              paramAnonymousView = Routes.COMPANY;
            }
            else if (recommendedChannelValue != null)
            {
              paramAnonymousView = recommendedChannelValue;
              str = _cachedId;
              localFollowingInfo = channel.followingInfo;
              paramAnonymousView = Routes.CHANNELS;
            }
            else
            {
              paramAnonymousView = null;
              localFollowingInfo = null;
              str = null;
            }
          }
        }
      });
      paramImageModel.setImageView(mediaCenter, image);
      return;
    }
  }
  
  private void initializeFollowedState()
  {
    if (CollectionUtils.isEmpty(items)) {
      return;
    }
    followedStates = new ArrayList(items.size());
    Iterator localIterator = items.iterator();
    label41:
    RecommendedEntity localRecommendedEntity;
    boolean bool;
    if (localIterator.hasNext())
    {
      localRecommendedEntity = (RecommendedEntity)localIterator.next();
      bool = false;
      if (recommendedChannelValue == null) {
        break label100;
      }
      bool = recommendedChannelValue.channel.followingInfo.following;
    }
    for (;;)
    {
      followedStates.add(Boolean.valueOf(bool));
      break label41;
      break;
      label100:
      if (recommendedCompanyValue != null) {
        bool = recommendedCompanyValue.followingInfo.following;
      } else if (recommendedMemberValue != null) {
        bool = recommendedMemberValue.followingInfo.following;
      }
    }
  }
  
  public final int getItemCount()
  {
    if (items == null) {
      return 0;
    }
    return items.size();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */