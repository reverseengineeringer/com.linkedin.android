package com.linkedin.android.premium.chooser;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.premium.PremiumChooserPageInstance;

public final class PremiumChooserLargePagerAdapter
  extends FragmentReferencingPagerAdapter
{
  private final PremiumChooserPageInstance chooserPageInstance;
  int count;
  
  PremiumChooserLargePagerAdapter(FragmentManager paramFragmentManager, PremiumChooserPageInstance paramPremiumChooserPageInstance)
  {
    super(paramFragmentManager);
    chooserPageInstance = paramPremiumChooserPageInstance;
  }
  
  public final int getCount()
  {
    return count;
  }
  
  public final Fragment getItem(int paramInt)
  {
    return PremiumChooserLargePageFragment.newInstance(PremiumChooserPageBundleBuilder.create(paramInt, chooserPageInstance));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserLargePagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */