package com.linkedin.android.growth.login.prereg;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public final class PreRegPageTransformer
  implements ViewPager.PageTransformer
{
  public final void transformPage(View paramView, float paramFloat)
  {
    View localView = paramView.findViewById(2131756192);
    int i = paramView.getWidth();
    if ((paramFloat > -1.0F) && ((-1.0F < paramFloat) || (paramFloat < 1.0F)))
    {
      paramView.setAlpha(1.0F);
      localView.setTranslationX(i * -paramFloat);
      return;
    }
    paramView.setAlpha(0.0F);
    localView.setTranslationX(0.0F);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPageTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */