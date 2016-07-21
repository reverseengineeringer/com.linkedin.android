package android.support.v7.widget;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

final class CardViewApi21
  implements CardViewImpl
{
  private static RoundRectDrawable getCardBackground(CardViewDelegate paramCardViewDelegate)
  {
    return (RoundRectDrawable)paramCardViewDelegate.getCardBackground();
  }
  
  public final float getElevation(CardViewDelegate paramCardViewDelegate)
  {
    return paramCardViewDelegate.getCardView().getElevation();
  }
  
  public final float getMaxElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackgroundmPadding;
  }
  
  public final float getMinHeight(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackgroundmRadius * 2.0F;
  }
  
  public final float getMinWidth(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackgroundmRadius * 2.0F;
  }
  
  public final float getRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackgroundmRadius;
  }
  
  public final void initStatic() {}
  
  public final void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCardViewDelegate.setCardBackground(new RoundRectDrawable(paramInt, paramFloat1));
    paramContext = paramCardViewDelegate.getCardView();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    setMaxElevation(paramCardViewDelegate, paramFloat3);
  }
  
  public final void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getCardBackgroundmPadding);
  }
  
  public final void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getCardBackgroundmPadding);
  }
  
  public final void setBackgroundColor(CardViewDelegate paramCardViewDelegate, int paramInt)
  {
    paramCardViewDelegate = getCardBackground(paramCardViewDelegate);
    mPaint.setColor(paramInt);
    paramCardViewDelegate.invalidateSelf();
  }
  
  public final void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    paramCardViewDelegate.getCardView().setElevation(paramFloat);
  }
  
  public final void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    RoundRectDrawable localRoundRectDrawable = getCardBackground(paramCardViewDelegate);
    boolean bool1 = paramCardViewDelegate.getUseCompatPadding();
    boolean bool2 = paramCardViewDelegate.getPreventCornerOverlap();
    if ((paramFloat != mPadding) || (mInsetForPadding != bool1) || (mInsetForRadius != bool2))
    {
      mPadding = paramFloat;
      mInsetForPadding = bool1;
      mInsetForRadius = bool2;
      localRoundRectDrawable.updateBounds(null);
      localRoundRectDrawable.invalidateSelf();
    }
    if (!paramCardViewDelegate.getUseCompatPadding())
    {
      paramCardViewDelegate.setShadowPadding(0, 0, 0, 0);
      return;
    }
    paramFloat = getCardBackgroundmPadding;
    float f = getCardBackgroundmRadius;
    int i = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(paramFloat, f, paramCardViewDelegate.getPreventCornerOverlap()));
    int j = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(paramFloat, f, paramCardViewDelegate.getPreventCornerOverlap()));
    paramCardViewDelegate.setShadowPadding(i, j, i, j);
  }
  
  public final void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    paramCardViewDelegate = getCardBackground(paramCardViewDelegate);
    if (paramFloat != mRadius)
    {
      mRadius = paramFloat;
      paramCardViewDelegate.updateBounds(null);
      paramCardViewDelegate.invalidateSelf();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardViewApi21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */