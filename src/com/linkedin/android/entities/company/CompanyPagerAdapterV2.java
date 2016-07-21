package com.linkedin.android.entities.company;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.company.controllers.CompanyTabFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanySections;
import java.util.ArrayList;
import java.util.List;

public class CompanyPagerAdapterV2
  extends EntityPagerAdapter
{
  public static final String TAG = CompanyPagerAdapterV2.class.getSimpleName();
  private final boolean isShowcase;
  
  public CompanyPagerAdapterV2(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, CompanyDataProvider paramCompanyDataProvider, boolean paramBoolean)
  {
    super(paramFragmentComponent, paramFragmentManager);
    isShowcase = paramBoolean;
    paramFragmentManager = ((CompanyDataProvider.CompanyState)state).company();
    if (paramFragmentManager == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Company from Data Provider state null - NOOP!!"));
      return;
    }
    paramFragmentComponent = new ArrayList();
    if (sections == null)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Company sections is null!!"));
      return;
    }
    if (sections.hasHighlights) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.HIGHLIGHTS);
    }
    if (sections.hasDetails) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.DETAILS);
    }
    if (sections.hasCareers) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.CAREERS);
    }
    setTabs(paramFragmentComponent);
  }
  
  public final Fragment getItem(int paramInt)
  {
    EntityPagerAdapter.TabType localTabType = getTabType(paramInt);
    boolean bool = isShowcase;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("tabType", localTabType);
    localBundle.putBoolean("isShowcase", bool);
    return CompanyTabFragment.newInstance(new CompanyTabBundleBuilder(localBundle));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyPagerAdapterV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */