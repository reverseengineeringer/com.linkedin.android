package com.linkedin.android.entities.school;

import android.os.Bundle;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.infra.BundleBuilder;

public final class SchoolTabBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  SchoolTabBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
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
 * Qualified Name:     com.linkedin.android.entities.school.SchoolTabBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */