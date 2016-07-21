package com.linkedin.android.axle;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Button;

final class SplashPromoViewHolder$3
  implements ViewPager.OnPageChangeListener
{
  SplashPromoViewHolder$3(SplashPromoViewHolder paramSplashPromoViewHolder, Runnable paramRunnable) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    val$swipeEvent.run();
    if (SplashPromoViewHolder.access$000(this$0))
    {
      if (paramInt == 0)
      {
        this$0.secondaryPromptButton.setVisibility(8);
        this$0.promptButton.setVisibility(0);
      }
    }
    else {
      return;
    }
    this$0.secondaryPromptButton.setVisibility(0);
    this$0.promptButton.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewHolder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */