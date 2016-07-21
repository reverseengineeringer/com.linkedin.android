package com.linkedin.android.identity.profile.view.interests.detail;

import android.app.Activity;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.OptimisticModelMockUtil;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.interests.detail.events.InterestCardFollowToggleEvent;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity.Entity;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;

public abstract class InterestsFollowHandlerFragment
  extends PageFragment
{
  protected ViewModelArrayAdapter<ViewModel> adapter;
  protected Map<InterestsFragment.InterestType, Integer> cardIndexMap;
  protected Map<InterestsFragment.InterestType, List<FollowableEntity>> modifiedInterestListMap;
  protected ProfileDataProvider profileDataProvider;
  protected String profileId;
  protected ProfileViewListener profileViewListener;
  
  private void handleCompanyFollowToggle(InterestCardFollowToggleEvent paramInterestCardFollowToggleEvent)
  {
    Object localObject1 = null;
    if (modifiedInterestListMap.containsKey(InterestsFragment.InterestType.COMPANY))
    {
      localObject1 = (List)modifiedInterestListMap.get(InterestsFragment.InterestType.COMPANY);
      break label40;
      label35:
      if (localObject1 != null) {
        break label69;
      }
    }
    for (;;)
    {
      label40:
      return;
      if (!CollectionUtils.isNonEmpty(profileDataProvider.getFollowedCompanies())) {
        break label35;
      }
      localObject1 = profileDataProvider.getFollowedCompanies().elements;
      break label35;
      label69:
      ArrayList localArrayList = null;
      int k = -1;
      int i = 0;
      Object localObject2;
      int j;
      for (;;)
      {
        localObject2 = localArrayList;
        j = k;
        if (i < ((List)localObject1).size())
        {
          if (getentity.miniCompanyValue._cachedId.equals(id))
          {
            localObject2 = (FollowableEntity)((List)localObject1).get(i);
            j = i;
          }
        }
        else
        {
          if (localObject2 == null) {
            break;
          }
          localArrayList = new ArrayList(((List)localObject1).size());
          i = 0;
          while (i < ((List)localObject1).size())
          {
            if (i != j) {
              localArrayList.add(((List)localObject1).get(i));
            }
            i += 1;
          }
        }
        i += 1;
      }
      try
      {
        localObject1 = OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject2, interestType, fragmentComponent);
        paramInterestCardFollowToggleEvent = entity.miniCompanyValue.entityUrn.getId();
        i = Math.max(CollectionUtils.getPagingTotal(profileDataProvider.getFollowedCompanies()), localArrayList.size());
        localArrayList.add(j, localObject1);
        modifiedInterestListMap.put(InterestsFragment.InterestType.COMPANY, localArrayList);
        localObject1 = InterestsDetailTransformer.toInterestDetailCard(localArrayList, InterestsFragment.InterestType.COMPANY, i, profileId, fragmentComponent, profileViewListener);
        adapter.changeViewModel(((Integer)cardIndexMap.get(InterestsFragment.InterestType.COMPANY)).intValue(), (ViewModel)localObject1);
        if (hasFollowingInfo)
        {
          fragmentComponent.followPublisher().toggleFollow(paramInterestCardFollowToggleEvent, Routes.COMPANY, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
          return;
        }
      }
      catch (BuilderException paramInterestCardFollowToggleEvent)
      {
        fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to modify company model"));
      }
    }
  }
  
  private void handleInfluencerFollowToggle(InterestCardFollowToggleEvent paramInterestCardFollowToggleEvent)
  {
    Object localObject1 = null;
    if (modifiedInterestListMap.containsKey(InterestsFragment.InterestType.INFLUENCER)) {
      localObject1 = (List)modifiedInterestListMap.get(InterestsFragment.InterestType.INFLUENCER);
    }
    while (localObject1 == null)
    {
      return;
      if (CollectionUtils.isNonEmpty(profileDataProvider.getFollowedInfluencers())) {
        localObject1 = profileDataProvider.getFollowedInfluencers().elements;
      }
    }
    ArrayList localArrayList = null;
    int k = -1;
    int i = 0;
    Object localObject2;
    int j;
    for (;;)
    {
      localObject2 = localArrayList;
      j = k;
      if (i < ((List)localObject1).size())
      {
        if (getentity.miniProfileValue._cachedId.equals(id))
        {
          localObject2 = (FollowableEntity)((List)localObject1).get(i);
          j = i;
        }
      }
      else
      {
        if (localObject2 == null) {
          break;
        }
        localArrayList = new ArrayList(((List)localObject1).size());
        i = 0;
        while (i < ((List)localObject1).size())
        {
          if (i != j) {
            localArrayList.add(((List)localObject1).get(i));
          }
          i += 1;
        }
      }
      i += 1;
    }
    try
    {
      localObject1 = OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject2, interestType, fragmentComponent);
      localObject2 = entity.miniProfileValue.entityUrn.getLastId();
      i = Math.max(CollectionUtils.getPagingTotal(profileDataProvider.getFollowedInfluencers()), localArrayList.size());
      localArrayList.add(j, localObject1);
      modifiedInterestListMap.put(InterestsFragment.InterestType.INFLUENCER, localArrayList);
      localObject1 = InterestsDetailTransformer.toInterestDetailCard(localArrayList, InterestsFragment.InterestType.INFLUENCER, i, profileId, fragmentComponent, profileViewListener);
      adapter.changeViewModel(((Integer)cardIndexMap.get(InterestsFragment.InterestType.INFLUENCER)).intValue(), (ViewModel)localObject1);
      if (isFollowing)
      {
        profileDataProvider.unFollowInfluencer(busSubscriberId, getRumSessionId(), (String)localObject2, Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
    }
    catch (BuilderException paramInterestCardFollowToggleEvent)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to modify profile model"));
      return;
    }
    profileDataProvider.followInfluencer(busSubscriberId, getRumSessionId(), (String)localObject2, Tracker.createPageInstanceHeader(getPageInstance()));
  }
  
  private void handleSchoolFollowToggle(InterestCardFollowToggleEvent paramInterestCardFollowToggleEvent)
  {
    Object localObject1 = null;
    if (modifiedInterestListMap.containsKey(InterestsFragment.InterestType.SCHOOL))
    {
      localObject1 = (List)modifiedInterestListMap.get(InterestsFragment.InterestType.SCHOOL);
      break label40;
      label35:
      if (localObject1 != null) {
        break label69;
      }
    }
    for (;;)
    {
      label40:
      return;
      if (!CollectionUtils.isNonEmpty(profileDataProvider.getFollowedSchools())) {
        break label35;
      }
      localObject1 = profileDataProvider.getFollowedSchools().elements;
      break label35;
      label69:
      ArrayList localArrayList = null;
      int k = -1;
      int i = 0;
      Object localObject2;
      int j;
      for (;;)
      {
        localObject2 = localArrayList;
        j = k;
        if (i < ((List)localObject1).size())
        {
          if (getentity.miniSchoolValue._cachedId.equals(id))
          {
            localObject2 = (FollowableEntity)((List)localObject1).get(i);
            j = i;
          }
        }
        else
        {
          if (localObject2 == null) {
            break;
          }
          localArrayList = new ArrayList(((List)localObject1).size());
          i = 0;
          while (i < ((List)localObject1).size())
          {
            if (i != j) {
              localArrayList.add(((List)localObject1).get(i));
            }
            i += 1;
          }
        }
        i += 1;
      }
      try
      {
        localObject1 = OptimisticModelMockUtil.toggleInterestModelFollowingInfo((FollowableEntity)localObject2, interestType, fragmentComponent);
        paramInterestCardFollowToggleEvent = entity.miniSchoolValue.entityUrn.getId();
        i = Math.max(CollectionUtils.getPagingTotal(profileDataProvider.getFollowedSchools()), localArrayList.size());
        localArrayList.add(j, localObject1);
        modifiedInterestListMap.put(InterestsFragment.InterestType.SCHOOL, localArrayList);
        localObject1 = InterestsDetailTransformer.toInterestDetailCard(localArrayList, InterestsFragment.InterestType.SCHOOL, i, profileId, fragmentComponent, profileViewListener);
        adapter.changeViewModel(((Integer)cardIndexMap.get(InterestsFragment.InterestType.SCHOOL)).intValue(), (ViewModel)localObject1);
        if (hasFollowingInfo)
        {
          fragmentComponent.followPublisher().toggleFollow(paramInterestCardFollowToggleEvent, Routes.SCHOOL, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
          return;
        }
      }
      catch (BuilderException paramInterestCardFollowToggleEvent)
      {
        fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to modify school model"));
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  @Subscribe
  public void onEvent(InterestCardFollowToggleEvent paramInterestCardFollowToggleEvent)
  {
    int j = 0;
    List localList;
    switch (InterestsFollowHandlerFragment.1.$SwitchMap$com$linkedin$android$identity$profile$view$interests$detail$InterestsFragment$InterestType[interestType.ordinal()])
    {
    default: 
      return;
    case 1: 
      if (modifiedInterestListMap.containsKey(InterestsFragment.InterestType.CHANNEL)) {
        localList = (List)modifiedInterestListMap.get(InterestsFragment.InterestType.CHANNEL);
      }
      break;
    }
    while (localList != null)
    {
      int i = 0;
      label84:
      if (i < localList.size()) {
        if (!getentity.channelValue.entityUrn.getId().equals(id)) {}
      }
      for (FollowableEntity localFollowableEntity = (FollowableEntity)localList.get(i); localFollowableEntity != null; localFollowableEntity = null)
      {
        ArrayList localArrayList = new ArrayList(localList.size());
        for (;;)
        {
          if (j < localList.size())
          {
            if (j != i) {
              localArrayList.add(localList.get(j));
            }
            j += 1;
            continue;
            if (!CollectionUtils.isNonEmpty(profileDataProvider.getFollowedChannels())) {
              break label457;
            }
            localList = profileDataProvider.getFollowedChannels().elements;
            break;
            i += 1;
            break label84;
          }
        }
        for (;;)
        {
          try
          {
            paramInterestCardFollowToggleEvent = OptimisticModelMockUtil.toggleInterestModelFollowingInfo(localFollowableEntity, interestType, fragmentComponent);
            j = Math.max(CollectionUtils.getPagingTotal(profileDataProvider.getFollowedChannels()), localArrayList.size());
            localArrayList.add(i, paramInterestCardFollowToggleEvent);
            modifiedInterestListMap.put(InterestsFragment.InterestType.CHANNEL, localArrayList);
            paramInterestCardFollowToggleEvent = InterestsDetailTransformer.toInterestDetailCard(localArrayList, InterestsFragment.InterestType.CHANNEL, j, profileId, fragmentComponent, profileViewListener);
            adapter.changeViewModel(((Integer)cardIndexMap.get(InterestsFragment.InterestType.CHANNEL)).intValue(), paramInterestCardFollowToggleEvent);
            if (localFollowableEntity != null)
            {
              paramInterestCardFollowToggleEvent = entity.channelValue.entityUrn.getId();
              if (!hasFollowingInfo) {
                break;
              }
              fragmentComponent.followPublisher().toggleFollow(paramInterestCardFollowToggleEvent, Routes.CHANNELS, followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
              return;
            }
          }
          catch (BuilderException paramInterestCardFollowToggleEvent)
          {
            fragmentComponent.context();
            Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to modify channel model"));
            return;
          }
          paramInterestCardFollowToggleEvent = null;
        }
        handleSchoolFollowToggle(paramInterestCardFollowToggleEvent);
        return;
        handleCompanyFollowToggle(paramInterestCardFollowToggleEvent);
        return;
        handleInfluencerFollowToggle(paramInterestCardFollowToggleEvent);
        return;
        i = -1;
      }
      label457:
      localList = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.interests.detail.InterestsFollowHandlerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */