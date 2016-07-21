package com.linkedin.android.growth.login.prereg;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;

final class PreRegPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  HorizontalViewPagerCarousel carousel;
  FragmentReferencingPagerAdapter pagerAdapter;
  
  public PreRegPageChangeListener(FragmentReferencingPagerAdapter paramFragmentReferencingPagerAdapter, HorizontalViewPagerCarousel paramHorizontalViewPagerCarousel)
  {
    pagerAdapter = paramFragmentReferencingPagerAdapter;
    carousel = paramHorizontalViewPagerCarousel;
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    int i;
    label14:
    PreRegBaseFragment localPreRegBaseFragment;
    if (paramInt == 0)
    {
      carousel.setInvert(false);
      i = 0;
      if (i >= pagerAdapter.getCount()) {
        return;
      }
      localPreRegBaseFragment = (PreRegBaseFragment)pagerAdapter.getItemAtPosition(i);
      if (localPreRegBaseFragment != null)
      {
        if (i == paramInt) {
          break label75;
        }
        if (localPreRegBaseFragment.getView() != null) {
          localPreRegBaseFragment.cancelAnimationsAndResetViews();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      carousel.setInvert(true);
      break;
      label75:
      localPreRegBaseFragment.performAnimations();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */