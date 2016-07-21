package com.linkedin.android.identity.profile.view.interests.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.view.OptimisticModelMockUtil;
import com.linkedin.android.identity.profile.view.interests.detail.events.InterestsListFollowToggleEvent;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity.Entity;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import org.greenrobot.eventbus.Subscribe;

public class InterestPagedListFragment
  extends PagedListFragment<FollowableEntity, CollectionMetadata, InterestsDetailEntryViewModel>
{
  private InterestsFragment.InterestType interestType;
  private CollectionTemplateHelper<FollowableEntity, CollectionMetadata> interestsCollectionHelper;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  private Uri getCurrentInterestRoute(InterestsFragment.InterestType paramInterestType)
  {
    switch (InterestPagedListFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$interests$detail$InterestsFragment$InterestType[paramInterestType.ordinal()])
    {
    default: 
      return ProfileRoutes.buildFollowedChannelsRoute(profileId);
    case 1: 
      return ProfileRoutes.buildGroupsEntityRoute(profileId);
    case 4: 
      return ProfileRoutes.buildFollowedInfluencersRoute(profileId);
    case 5: 
      return ProfileRoutes.buildFollowedSchoolsRoute(profileId);
    case 3: 
      return ProfileRoutes.buildFollowedCompaniesRoute(profileId);
    }
    return ProfileRoutes.buildFollowedChannelsRoute(profileId);
  }
  
  public static InterestPagedListFragment newInstance(InterestPagedListBundleBuilder paramInterestPagedListBundleBuilder)
  {
    InterestPagedListFragment localInterestPagedListFragment = new InterestPagedListFragment();
    localInterestPagedListFragment.setArguments(paramInterestPagedListBundleBuilder.build());
    interestType = InterestPagedListBundleBuilder.getInterestType(paramInterestPagedListBundleBuilder.build());
    return localInterestPagedListFragment;
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final Uri getBaseLoadMoreUri()
  {
    return getCurrentInterestRoute(interestType);
  }
  
  public final CollectionTemplateHelper<FollowableEntity, CollectionMetadata> getCollectionHelper()
  {
    if (interestsCollectionHelper == null) {
      interestsCollectionHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, FollowableEntity.BUILDER, CollectionMetadata.BUILDER);
    }
    return interestsCollectionHelper;
  }
  
  public final Uri getInitialFetchUri()
  {
    return getCurrentInterestRoute(interestType);
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    profileId = getArguments().getString("profileId");
    interestType = InterestPagedListBundleBuilder.getInterestType(getArguments());
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969218, paramViewGroup, false);
  }
  
  @Subscribe
  public void onEvent(InterestsListFollowToggleEvent paramInterestsListFollowToggleEvent)
  {
    switch (InterestPagedListFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$interests$detail$InterestsFragment$InterestType[interestType.ordinal()])
    {
    default: 
      return;
    case 2: 
      localObject = interest;
      str = entity.channelValue.entityUrn.getId();
      if (hasFollowingInfo) {
        fragmentComponent.followPublisher().toggleFollow(str, Routes.CHANNELS, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
      }
      try
      {
        localObject = InterestsDetailTransformer.toInterestEntryViewModel(OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject, interestType, fragmentComponent), true, true, fragmentComponent);
        updateItem(viewModel, (ViewModel)localObject);
        return;
      }
      catch (BuilderException paramInterestsListFollowToggleEvent)
      {
        getContext();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Could not modify channel model"));
        return;
      }
    case 3: 
      localObject = interest;
      str = entity.miniCompanyValue.entityUrn.getId();
      if (hasFollowingInfo) {
        fragmentComponent.followPublisher().toggleFollow(str, Routes.COMPANY, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
      }
      try
      {
        localObject = InterestsDetailTransformer.toInterestEntryViewModel(OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject, interestType, fragmentComponent), true, true, fragmentComponent);
        updateItem(viewModel, (ViewModel)localObject);
        return;
      }
      catch (BuilderException paramInterestsListFollowToggleEvent)
      {
        getContext();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Could not modify company model"));
        return;
      }
    case 5: 
      localObject = interest;
      str = entity.miniSchoolValue.entityUrn.getId();
      if (hasFollowingInfo) {
        fragmentComponent.followPublisher().toggleFollow(str, Routes.SCHOOL, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
      }
      try
      {
        localObject = InterestsDetailTransformer.toInterestEntryViewModel(OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject, interestType, fragmentComponent), true, true, fragmentComponent);
        updateItem(viewModel, (ViewModel)localObject);
        return;
      }
      catch (BuilderException paramInterestsListFollowToggleEvent)
      {
        getContext();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Could not modify school model"));
        return;
      }
    }
    Object localObject = interest;
    String str = entity.miniProfileValue.entityUrn.getLastId();
    if (interest.followingInfo.following) {
      profileDataProvider.unFollowInfluencer(busSubscriberId, getRumSessionId(), str, Tracker.createPageInstanceHeader(getPageInstance()));
    }
    for (;;)
    {
      try
      {
        localObject = InterestsDetailTransformer.toInterestEntryViewModel(OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject, interestType, fragmentComponent), true, true, fragmentComponent);
        updateItem(viewModel, (ViewModel)localObject);
        return;
      }
      catch (BuilderException paramInterestsListFollowToggleEvent)
      {
        getContext();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Could not modify influencer model"));
        return;
      }
      profileDataProvider.followInfluencer(busSubscriberId, getRumSessionId(), str, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    int i;
    switch (InterestPagedListFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$interests$detail$InterestsFragment$InterestType[interestType.ordinal()])
    {
    default: 
      i = 2131233233;
    }
    for (;;)
    {
      toolbar.setTitle(i);
      toolbar.setNavigationOnClickListener(new InterestPagedListFragment.1(this));
      return;
      i = 2131233222;
      continue;
      i = 2131233220;
      continue;
      i = 2131233221;
      continue;
      i = 2131233223;
      continue;
      i = 2131233226;
    }
  }
  
  public final String pageKey()
  {
    switch (InterestPagedListFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$interests$detail$InterestsFragment$InterestType[interestType.ordinal()])
    {
    default: 
      return null;
    case 2: 
      return "profile_view_interests_all_channels";
    case 3: 
      return "profile_view_interests_all_companies";
    case 5: 
      return "profile_view_interests_all_schools";
    case 4: 
      return "profile_view_interests_all_influencers";
    }
    return "profile_view_interests_all_groups";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.interests.detail.InterestPagedListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */