package com.linkedin.android.premium.chooser;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts;
import java.util.List;

final class PremiumChooserFragment$PageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int lastPosition = -1;
  
  private PremiumChooserFragment$PageChangeListener(PremiumChooserFragment paramPremiumChooserFragment) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    if ((paramInt == 0) && (PremiumChooserFragment.access$300(this$0) != null)) {
      onPageSelected(access$300this$0).pager.getCurrentItem());
    }
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat == 0.0F) {
      onPageSelected(paramInt1);
    }
  }
  
  public final void onPageSelected(int paramInt)
  {
    if ((paramInt == lastPosition) || (PremiumChooserFragment.access$1500(this$0) < 0)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt < 0)
          {
            lastPosition = -1;
            return;
          }
          Log.v(PremiumChooserFragment.access$1400(), "selected small page " + paramInt);
          localObject = this$0.getPremium();
        } while ((localObject == null) || (products == null) || (products.size() <= paramInt));
        PremiumChooserFragment.access$1502(this$0, paramInt);
        if (lastPosition >= 0)
        {
          while (paramInt < lastPosition)
          {
            PremiumChooserFragment.access$1600(this$0);
            lastPosition -= 1;
          }
          while (paramInt > lastPosition)
          {
            PremiumChooserFragment.access$1700(this$0);
            lastPosition += 1;
          }
        }
        lastPosition = paramInt;
      } while (PremiumChooserFragment.access$300(this$0) == null);
      access$300this$0).largePager.post(new PremiumChooserFragment.PageChangeListener.1(this));
      localObject = (PremiumProduct)products.get(paramInt);
    } while (localObject == null);
    PremiumChooserFragment.access$1800(this$0, (PremiumProduct)localObject, paramInt, PremiumChooserFragment.access$600(this$0).getCount());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment.PageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */