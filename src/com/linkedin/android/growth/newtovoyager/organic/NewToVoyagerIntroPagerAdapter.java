package com.linkedin.android.growth.newtovoyager.organic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;

public final class NewToVoyagerIntroPagerAdapter
  extends FragmentReferencingPagerAdapter
{
  public NewToVoyagerIntroPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public final int getCount()
  {
    return 5;
  }
  
  public final Fragment getItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new NewToVoyagerIntroWelcomeFragment();
    case 1: 
      return new NewToVoyagerIntroFeedFragment();
    case 2: 
      return new NewToVoyagerIntroMessageFragment();
    case 3: 
      return new NewToVoyagerIntroSearchFragment();
    }
    return new NewToVoyagerIntroEmptyFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */