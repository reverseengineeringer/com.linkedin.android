package com.linkedin.android.premium.chooser;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;

final class PremiumChooserFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PremiumChooserFragment$3(PremiumChooserFragment paramPremiumChooserFragment) {}
  
  public final void onGlobalLayout()
  {
    int k = 0;
    if (PremiumChooserFragment.access$300(this$0) != null)
    {
      Object localObject1 = access$300this$0).large;
      float f;
      Object localObject2;
      if (PremiumChooserFragment.access$400(this$0))
      {
        f = 0.0F;
        ((View)localObject1).setTranslationY(f);
        localObject1 = access$300this$0).largeDismissBackground;
        localObject2 = PremiumChooserFragment.access$500(this$0).getItemAtPosition(access$300this$0).largePager.getCurrentItem());
        if (!(localObject2 instanceof PremiumChooserLargePageFragment)) {
          break label348;
        }
        localObject2 = (PremiumChooserLargePageFragment)localObject2;
        if ((ui == null) || (ui.header == null)) {
          break label348;
        }
      }
      int j;
      label348:
      for (int i = ui.header.getHeight();; i = 0)
      {
        PremiumChooserLargePageViewHolder.setHeight((View)localObject1, i);
        localObject1 = PremiumChooserFragment.access$600(this$0);
        j = Math.max(access$300this$0).headerText.getBottom(), access$300this$0).pageIndicator.getBottom()) + access$300this$0).headerText.getPaddingBottom() - access$300this$0).multiViewPager.getTop();
        int m = access$300this$0).footer.getHeight();
        i = 0;
        while (i < ((PremiumChooserPagerAdapter)localObject1).getCount())
        {
          localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
          if ((localObject2 instanceof PremiumChooserPageFragment))
          {
            localObject2 = (PremiumChooserPageFragment)localObject2;
            if ((ui != null) && ((ui.layout.getPaddingTop() != j) || (ui.layout.getPaddingBottom() != m))) {
              ui.layout.setPadding(ui.layout.getPaddingLeft(), j, ui.layout.getPaddingRight(), m);
            }
          }
          i += 1;
        }
        f = access$300this$0).layout.getHeight();
        break;
      }
      if (!hidSomeData)
      {
        i = 0;
        if (i >= ((PremiumChooserPagerAdapter)localObject1).getCount()) {
          break label523;
        }
        localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
        if (!(localObject2 instanceof PremiumChooserPageFragment)) {
          break label516;
        }
        localObject2 = (PremiumChooserPageFragment)localObject2;
        if ((productBoundToUi == null) || (ui == null) || (ui.features.getChildCount() <= 0) || (ui.features.getBottom() <= ui.smallToLarge.getTop())) {
          break label511;
        }
        j = 1;
        label452:
        if (j == 0) {
          break label516;
        }
      }
      label511:
      label516:
      label523:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          return;
        }
        hidSomeData = true;
        i = k;
        while (i < ((PremiumChooserPagerAdapter)localObject1).getCount())
        {
          localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
          if ((localObject2 instanceof PremiumChooserPageFragment)) {
            ((PremiumChooserPageFragment)localObject2).hideSomeData();
          }
          i += 1;
        }
        j = 0;
        break label452;
        i += 1;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */