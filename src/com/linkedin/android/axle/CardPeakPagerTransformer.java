package com.linkedin.android.axle;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public final class CardPeakPagerTransformer
  implements ViewPager.PageTransformer
{
  private Context context;
  private final float mMinAlpha;
  private final float mMinScale;
  
  public CardPeakPagerTransformer(Context paramContext)
  {
    context = paramContext;
    mMinScale = 0.8F;
    mMinAlpha = 0.7F;
  }
  
  public final void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    paramView.getHeight();
    Resources localResources = context.getResources();
    int j = localResources.getDimensionPixelSize(2131493016);
    int k = localResources.getDimensionPixelSize(2131493017);
    float f1 = mMinScale + (1.0F - Math.abs(paramFloat)) * (1.0F - mMinScale);
    float f2 = i;
    float f3 = k;
    paramView.setTranslationX((-(k - j) * 2.0F - j - (f2 - f3 * 2.0F) * (1.0F - f1) / 2.0F) * paramFloat);
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.CardPeakPagerTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */