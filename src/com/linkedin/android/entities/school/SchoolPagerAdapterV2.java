package com.linkedin.android.entities.school;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.school.controllers.SchoolTabFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolSections;
import java.util.ArrayList;
import java.util.List;

public final class SchoolPagerAdapterV2
  extends EntityPagerAdapter
{
  private final SchoolDataProvider schoolDataProvider;
  
  public SchoolPagerAdapterV2(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, SchoolDataProvider paramSchoolDataProvider)
  {
    super(paramFragmentComponent, paramFragmentManager);
    schoolDataProvider = paramSchoolDataProvider;
    paramFragmentManager = ((SchoolDataProvider.SchoolState)state).school();
    if (paramFragmentManager == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("School from Data Provider state null - NOOP!!"));
      return;
    }
    paramFragmentComponent = new ArrayList();
    if (sections == null)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("School sections is null!!"));
      return;
    }
    if (sections.hasHighlights) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.HIGHLIGHTS);
    }
    if (sections.hasDetails) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.DETAILS);
    }
    if (sections.hasPeople) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.PEOPLE);
    }
    setTabs(paramFragmentComponent);
  }
  
  public final Fragment getItem(int paramInt)
  {
    EntityPagerAdapter.TabType localTabType = getTabType(paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("tabType", localTabType);
    return SchoolTabFragment.newInstance(new SchoolTabBundleBuilder(localBundle));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolPagerAdapterV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */