package com.linkedin.android.growth.newtovoyager.organic;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragment;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;

public final class NewToVoyagerIntroPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private FragmentComponent fragmentComponent;
  private FragmentReferencingPagerAdapter pagerAdapter;
  
  public NewToVoyagerIntroPageChangeListener(FragmentComponent paramFragmentComponent, FragmentReferencingPagerAdapter paramFragmentReferencingPagerAdapter)
  {
    pagerAdapter = paramFragmentReferencingPagerAdapter;
    fragmentComponent = paramFragmentComponent;
  }
  
  private boolean isLastPage(int paramInt)
  {
    return !(pagerAdapter.getItemAtPosition(paramInt) instanceof PreRegBaseFragment);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (isLastPage(paramInt1 + 1))
    {
      View localView = fragmentComponent.fragment().getView();
      if (localView != null) {
        localView.setAlpha(1.0F - paramFloat);
      }
    }
  }
  
  public final void onPageSelected(int paramInt)
  {
    int j = pagerAdapter.getCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = pagerAdapter.getItemAtPosition(i);
      if ((localObject != null) && ((localObject instanceof PreRegBaseFragment)))
      {
        localObject = (PreRegBaseFragment)localObject;
        if (i != paramInt) {
          break label62;
        }
        ((PreRegBaseFragment)localObject).performAnimations();
      }
      for (;;)
      {
        i += 1;
        break;
        label62:
        if (((PreRegBaseFragment)localObject).getView() != null) {
          ((PreRegBaseFragment)localObject).cancelAnimationsAndResetViews();
        }
      }
    }
    if (isLastPage(paramInt))
    {
      localObject = fragmentComponent.activity();
      if (localObject != null)
      {
        HomeIntent localHomeIntent = fragmentComponent.intentRegistry().home;
        HomeBundle localHomeBundle = new HomeBundle();
        activeTab = HomeTabInfo.FEED;
        NavigationUtils.navigateUp((Activity)localObject, localHomeIntent.newIntent((Context)localObject, localHomeBundle), false);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroPageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */