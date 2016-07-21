package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;

final class LightboxPromo$LightboxPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private Context context;
  
  public LightboxPromo$LightboxPageChangeListener(LightboxPromo paramLightboxPromo, Context paramContext)
  {
    context = paramContext;
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    LightboxPromo.access$000(this$0, context, paramInt);
    if (LightboxPromo.access$100(this$0) != null) {
      LightboxPromo.access$100(this$0).run();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.LightboxPromo.LightboxPageChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */