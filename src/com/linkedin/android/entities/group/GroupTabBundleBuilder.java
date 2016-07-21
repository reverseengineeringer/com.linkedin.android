package com.linkedin.android.entities.group;

import android.os.Bundle;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.infra.BundleBuilder;

public final class GroupTabBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  private GroupTabBundleBuilder(EntityPagerAdapter.TabType paramTabType)
  {
    bundle.putSerializable("tabType", paramTabType);
  }
  
  public static GroupTabBundleBuilder create(EntityPagerAdapter.TabType paramTabType)
  {
    return new GroupTabBundleBuilder(paramTabType);
  }
  
  public static EntityPagerAdapter.TabType getTabType(Bundle paramBundle)
  {
    return (EntityPagerAdapter.TabType)paramBundle.getSerializable("tabType");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupTabBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */