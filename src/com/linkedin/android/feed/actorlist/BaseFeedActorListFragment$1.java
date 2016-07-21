package com.linkedin.android.feed.actorlist;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;

final class BaseFeedActorListFragment$1
  implements View.OnClickListener
{
  BaseFeedActorListFragment$1(BaseFeedActorListFragment paramBaseFeedActorListFragment) {}
  
  public final void onClick(View paramView)
  {
    paramView = this$0.getActivity();
    Object localObject = this$0;
    HomeIntent localHomeIntent = fragmentComponent.intentRegistry().home;
    localObject = ((BaseFeedActorListFragment)localObject).getActivity();
    HomeBundle localHomeBundle = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    NavigationUtils.navigateUp(paramView, localHomeIntent.newIntent((Context)localObject, localHomeBundle), false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.BaseFeedActorListFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */