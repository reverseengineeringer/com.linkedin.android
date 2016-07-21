package com.linkedin.android.entities;

import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;

final class EntityCoordinatorBaseFragment$2
  implements Toolbar.OnMenuItemClickListener
{
  EntityCoordinatorBaseFragment$2(EntityCoordinatorBaseFragment paramEntityCoordinatorBaseFragment) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return this$0.onMenuClick(paramMenuItem);
    }
    this$0.startActivity(this$0.fragmentComponent.intentRegistry().search.newIntent(this$0.getActivity(), SearchBundleBuilder.create()));
    EntityCoordinatorBaseFragment.access$100(this$0, "search_icon");
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityCoordinatorBaseFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */