package com.linkedin.android.artdeco.components;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;

final class HorizontalViewPagerCarousel$1
  extends DataSetObserver
{
  HorizontalViewPagerCarousel$1(HorizontalViewPagerCarousel paramHorizontalViewPagerCarousel) {}
  
  public final void onChanged()
  {
    HorizontalViewPagerCarousel localHorizontalViewPagerCarousel = this$0;
    if (HorizontalViewPagerCarousel.access$000(this$0) == null) {}
    for (int i = 0;; i = HorizontalViewPagerCarousel.access$000(this$0).getCount())
    {
      HorizontalViewPagerCarousel.access$100(localHorizontalViewPagerCarousel, i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */