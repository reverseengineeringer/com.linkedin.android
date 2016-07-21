package com.linkedin.android.entities;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;

final class EntityCoordinatorBaseFragment$3
  implements View.OnClickListener
{
  EntityCoordinatorBaseFragment$3(EntityCoordinatorBaseFragment paramEntityCoordinatorBaseFragment) {}
  
  public final void onClick(View paramView)
  {
    if (this$0.isResumed())
    {
      paramView = this$0.fragmentComponent.intentRegistry().home;
      FragmentActivity localFragmentActivity = this$0.getActivity();
      HomeBundle localHomeBundle = new HomeBundle();
      activeTab = HomeTabInfo.FEED;
      paramView = paramView.newIntent(localFragmentActivity, localHomeBundle);
      NavigationUtils.navigateUp(this$0.getActivity(), paramView, false);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */