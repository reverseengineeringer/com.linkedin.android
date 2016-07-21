package com.linkedin.android.premium.chooser;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageButton;
import com.linkedin.android.logger.Log;

final class PremiumChooserFragment$LargePageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int lastPosition = -1;
  
  private PremiumChooserFragment$LargePageChangeListener(PremiumChooserFragment paramPremiumChooserFragment) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    if ((paramInt == 0) && (PremiumChooserFragment.access$300(this$0) != null)) {
      onPageSelected(access$300this$0).largePager.getCurrentItem());
    }
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat == 0.0F) {
      onPageSelected(paramInt1);
    }
    while (PremiumChooserFragment.access$300(this$0) == null) {
      return;
    }
    if (paramInt2 > access$300this$0).largeDismiss.getWidth())
    {
      PremiumChooserFragment.access$1300(this$0, paramInt1 + 1);
      return;
    }
    PremiumChooserFragment.access$1300(this$0, paramInt1);
  }
  
  public final void onPageSelected(int paramInt)
  {
    if ((paramInt != lastPosition) && (PremiumChooserFragment.access$300(this$0) != null))
    {
      Log.v(PremiumChooserFragment.access$1400(), "selected large page " + paramInt);
      access$300this$0).pager.post(new PremiumChooserFragment.LargePageChangeListener.1(this));
      lastPosition = paramInt;
    }
    PremiumChooserFragment.access$1300(this$0, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment.LargePageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */