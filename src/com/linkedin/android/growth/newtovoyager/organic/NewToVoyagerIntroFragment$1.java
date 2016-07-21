package com.linkedin.android.growth.newtovoyager.organic;

import com.linkedin.android.infra.ui.ViewPager;

final class NewToVoyagerIntroFragment$1
  implements Runnable
{
  NewToVoyagerIntroFragment$1(NewToVoyagerIntroFragment paramNewToVoyagerIntroFragment, NewToVoyagerIntroPageChangeListener paramNewToVoyagerIntroPageChangeListener) {}
  
  public final void run()
  {
    if (this$0.viewPager != null) {
      val$pageChangeListener.onPageSelected(this$0.viewPager.getCurrentItem());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */