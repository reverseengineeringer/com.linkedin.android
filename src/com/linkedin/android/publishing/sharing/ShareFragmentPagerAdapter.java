package com.linkedin.android.publishing.sharing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.messaging.compose.ComposeBundleBuilder;
import com.linkedin.android.messaging.compose.ComposeFragment;
import com.linkedin.android.publishing.sharing.compose.FeedShareComposeFragment;
import com.linkedin.android.publishing.sharing.compose.GroupShareComposeFragment;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;

public final class ShareFragmentPagerAdapter
  extends FragmentReferencingPagerAdapter
{
  private Bundle bundle;
  Fragment currentPrimaryItem;
  private I18NManager i18n;
  
  public ShareFragmentPagerAdapter(FragmentManager paramFragmentManager, FragmentComponent paramFragmentComponent, Bundle paramBundle)
  {
    super(paramFragmentManager);
    bundle = paramBundle;
    i18n = paramFragmentComponent.i18NManager();
  }
  
  public final int getCount()
  {
    if (ShareBundle.isReshare(bundle)) {
      return 2;
    }
    return 1;
  }
  
  public final Fragment getItem(int paramInt)
  {
    int i = 0;
    ShareComposeBundle localShareComposeBundle = ShareBundle.getShareCreatorBundle(bundle);
    Object localObject2;
    if (paramInt == 1)
    {
      if (localShareComposeBundle != null) {}
      for (localObject1 = localShareComposeBundle.build();; localObject1 = new Bundle())
      {
        localObject2 = new ComposeFragment();
        localObject1 = new ComposeBundleBuilder((Bundle)localObject1);
        bundle.putInt("usage", 0);
        ((Fragment)localObject2).setArguments(((ComposeBundleBuilder)localObject1).build());
        return (Fragment)localObject2;
      }
    }
    Object localObject1 = bundle;
    paramInt = i;
    if (localObject1 != null) {
      paramInt = ((Bundle)localObject1).getInt("usage", 0);
    }
    if (paramInt == 1) {}
    for (localObject1 = new GroupShareComposeFragment();; localObject1 = new FeedShareComposeFragment())
    {
      localObject2 = localObject1;
      if (localShareComposeBundle == null) {
        break;
      }
      ((Fragment)localObject1).setArguments(localShareComposeBundle.build());
      return (Fragment)localObject1;
    }
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return i18n.getString(ComposeFragment.getPageTitle());
    }
    return ShareBundle.getTitle(bundle, i18n);
  }
  
  public final void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    currentPrimaryItem = ((Fragment)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareFragmentPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */