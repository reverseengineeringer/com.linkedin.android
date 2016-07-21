package com.linkedin.android.identity.profile.view.groups;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity;
import javax.inject.Inject;

public class ProfileGroupsFragment
  extends PagedListFragment<FollowableEntity, CollectionMetadata, ProfileViewGroupsCardEntryViewModel>
{
  private CollectionTemplateHelper<FollowableEntity, CollectionMetadata> groupsCollectionHelper;
  @Inject
  MemberUtil memberUtil;
  private ProfileViewListener profileViewListener;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public static ProfileGroupsFragment newInstance(ProfileGroupsBundleBuilder paramProfileGroupsBundleBuilder)
  {
    ProfileGroupsFragment localProfileGroupsFragment = new ProfileGroupsFragment();
    localProfileGroupsFragment.setArguments(paramProfileGroupsBundleBuilder.build());
    return localProfileGroupsFragment;
  }
  
  private void setTitle(int paramInt)
  {
    toolbar.setTitle(paramInt);
  }
  
  public final Uri getBaseLoadMoreUri()
  {
    String str = getArguments().getString("profileId");
    switch (getArguments().getInt("usage", 0))
    {
    default: 
      return ProfileRoutes.buildGroupsEntityRoute(str);
    }
    return ProfileRoutes.buildMutualGroupsEntityRoute(str);
  }
  
  public final CollectionTemplateHelper<FollowableEntity, CollectionMetadata> getCollectionHelper()
  {
    if (groupsCollectionHelper == null) {
      groupsCollectionHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, FollowableEntity.BUILDER, CollectionMetadata.BUILDER);
    }
    return groupsCollectionHelper;
  }
  
  public final Uri getInitialFetchUri()
  {
    String str = getArguments().getString("profileId");
    switch (getArguments().getInt("usage", 0))
    {
    default: 
      return ProfileRoutes.buildGroupsEntityRoute(str, 20);
    }
    return ProfileRoutes.buildMutualGroupsEntityRoute$68d17de5(str);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969208, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    switch (getArguments().getInt("usage", 0))
    {
    default: 
      setTitle(2131233166);
    }
    for (;;)
    {
      toolbar.setNavigationOnClickListener(new ProfileGroupsFragment.1(this));
      return;
      setTitle(2131233235);
    }
  }
  
  public final String pageKey()
  {
    return "profile_view_groups_list";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.groups.ProfileGroupsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */