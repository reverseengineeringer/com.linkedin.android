package android.support.design.widget;

import android.support.v4.view.ViewPager;

public class TabLayout$ViewPagerOnTabSelectedListener
  implements TabLayout.OnTabSelectedListener
{
  private final ViewPager mViewPager;
  
  public TabLayout$ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
  {
    mViewPager = paramViewPager;
  }
  
  public void onTabReselected(TabLayout.Tab paramTab) {}
  
  public void onTabSelected(TabLayout.Tab paramTab)
  {
    mViewPager.setCurrentItem(paramTab.getPosition());
  }
  
  public void onTabUnselected(TabLayout.Tab paramTab) {}
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.ViewPagerOnTabSelectedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */