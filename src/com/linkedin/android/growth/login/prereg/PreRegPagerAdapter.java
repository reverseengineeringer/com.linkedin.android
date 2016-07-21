package com.linkedin.android.growth.login.prereg;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.linkedin.android.growth.login.join.PreRegBundle;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment;
import com.linkedin.android.growth.login.prereg.jobs.PreRegJobsFragment;
import com.linkedin.android.growth.login.prereg.messaging.PreRegMessagingFragment;
import com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragment;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;

public final class PreRegPagerAdapter
  extends FragmentReferencingPagerAdapter
{
  private int containerHeight = -1;
  private final FragmentManager fragmentManager;
  
  public PreRegPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    fragmentManager = paramFragmentManager;
  }
  
  public final int getCount()
  {
    return 4;
  }
  
  public final Fragment getItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new PreRegIntroFragment();
    case 1: 
      return new PreRegJobsFragment();
    case 2: 
      return new PreRegMessagingFragment();
    }
    return new PreRegPeopleFragment();
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
    if (fragmentManager.findFragmentByTag(paramViewGroup.getTag()) == null) {
      paramViewGroup.setArguments(new PreRegBundle(containerHeight).build());
    }
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */