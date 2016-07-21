package com.linkedin.android.entities.group;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.group.controllers.GroupDiscussionsTabFragment;
import com.linkedin.android.entities.group.controllers.GroupTabFragment;
import com.linkedin.android.entities.group.transformers.GroupTransformer;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import java.util.ArrayList;
import java.util.List;

public final class GroupPagerAdapter
  extends EntityPagerAdapter
{
  public GroupPagerAdapter(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, GroupDataProvider paramGroupDataProvider)
  {
    super(paramFragmentComponent, paramFragmentManager);
    if (((GroupDataProvider.GroupState)state).group() == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Group from Data Provider state null - NOOP!!"));
      return;
    }
    paramFragmentComponent = new ArrayList();
    if (GroupTransformer.canShowConversationsTab(paramGroupDataProvider)) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.CONVERSATIONS);
    }
    paramFragmentComponent.add(EntityPagerAdapter.TabType.ABOUT);
    setTabs(paramFragmentComponent);
  }
  
  public final Fragment getItem(int paramInt)
  {
    EntityPagerAdapter.TabType localTabType = getTabType(paramInt);
    if (localTabType == EntityPagerAdapter.TabType.CONVERSATIONS) {
      return GroupDiscussionsTabFragment.newInstance(GroupTabBundleBuilder.create(localTabType));
    }
    return GroupTabFragment.newInstance(GroupTabBundleBuilder.create(localTabType));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */