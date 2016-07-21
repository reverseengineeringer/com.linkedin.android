package com.linkedin.android.growth.lego;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;

public abstract class MultiFragmentLegoWidget
  extends LegoWidget
{
  public String currentFragmentTag;
  
  public void finishCurrentFragment()
  {
    super.finishCurrentFragment();
    updateToLastFragmentTag();
  }
  
  public final String getCurrentActiveFragmentTag()
  {
    return currentFragmentTag;
  }
  
  public final void handleBack()
  {
    super.handleBack();
    updateToLastFragmentTag();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fragmentComponent.inject(this);
    if (paramBundle != null) {}
    for (String str = paramBundle.getString("currentFragmentTag", "landing");; str = "landing")
    {
      currentFragmentTag = str;
      super.onCreate(paramBundle);
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("currentFragmentTag", currentFragmentTag);
  }
  
  public void updateToLastFragmentTag()
  {
    if (getChildFragmentManager().getBackStackEntryCount() == 0)
    {
      currentFragmentTag = "landing";
      return;
    }
    currentFragmentTag = getChildFragmentManager().getBackStackEntryAt(getChildFragmentManager().getBackStackEntryCount() - 1).getName();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.MultiFragmentLegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */