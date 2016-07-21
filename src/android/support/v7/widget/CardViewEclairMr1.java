package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class CardViewEclairMr1
  implements CardViewImpl
{
  final RectF sCornerRect = new RectF();
  
  private static RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate paramCardViewDelegate)
  {
    return (RoundRectDrawableWithShadow)paramCardViewDelegate.getCardBackground();
  }
  
  private void updatePadding(CardViewDelegate paramCardViewDelegate)
  {
    Rect localRect = new Rect();
    getShadowBackground(paramCardViewDelegate).getPadding(localRect);
    paramCardViewDelegate.setMinWidthHeightInternal((int)Math.ceil(getMinWidth(paramCardViewDelegate)), (int)Math.ceil(getMinHeight(paramCardViewDelegate)));
    paramCardViewDelegate.setShadowPadding(left, top, right, bottom);
  }
  
  public final float getElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackgroundmRawShadowSize;
  }
  
  public final float getMaxElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackgroundmRawMaxShadowSize;
  }
  
  public final float getMinHeight(CardViewDelegate paramCardViewDelegate)
  {
    paramCardViewDelegate = getShadowBackground(paramCardViewDelegate);
    float f1 = Math.max(mRawMaxShadowSize, mCornerRadius + mInsetShadow + mRawMaxShadowSize * 1.5F / 2.0F);
    float f2 = mRawMaxShadowSize;
    return (mInsetShadow + f2 * 1.5F) * 2.0F + f1 * 2.0F;
  }
  
  public final float getMinWidth(CardViewDelegate paramCardViewDelegate)
  {
    paramCardViewDelegate = getShadowBackground(paramCardViewDelegate);
    float f1 = Math.max(mRawMaxShadowSize, mCornerRadius + mInsetShadow + mRawMaxShadowSize / 2.0F);
    float f2 = mRawMaxShadowSize;
    return (mInsetShadow + f2) * 2.0F + f1 * 2.0F;
  }
  
  public final float getRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackgroundmCornerRadius;
  }
  
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper()
    {
      public final void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        float f1 = paramAnonymousFloat * 2.0F;
        float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
        float f3 = paramAnonymousRectF.height();
        if (paramAnonymousFloat >= 1.0F)
        {
          float f4 = paramAnonymousFloat + 0.5F;
          sCornerRect.set(-f4, -f4, f4, f4);
          int i = paramAnonymousCanvas.save();
          paramAnonymousCanvas.translate(left + f4, top + f4);
          paramAnonymousCanvas.drawArc(sCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(sCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f3 - f1 - 1.0F, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(sCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(sCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.restoreToCount(i);
          paramAnonymousCanvas.drawRect(left + f4 - 1.0F, top, 1.0F + (right - f4), top + f4, paramAnonymousPaint);
          paramAnonymousCanvas.drawRect(left + f4 - 1.0F, 1.0F + (bottom - f4), 1.0F + (right - f4), bottom, paramAnonymousPaint);
        }
        f1 = left;
        f2 = top;
        paramAnonymousCanvas.drawRect(f1, Math.max(0.0F, paramAnonymousFloat - 1.0F) + f2, right, 1.0F + (bottom - paramAnonymousFloat), paramAnonymousPaint);
      }
    };
  }
  
  public final void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = new RoundRectDrawableWithShadow(paramContext.getResources(), paramInt, paramFloat1, paramFloat2, paramFloat3);
    paramContext.setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
    paramCardViewDelegate.setCardBackground(paramContext);
    updatePadding(paramCardViewDelegate);
  }
  
  public final void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate) {}
  
  public final void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
  {
    getShadowBackground(paramCardViewDelegate).setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public final void setBackgroundColor(CardViewDelegate paramCardViewDelegate, int paramInt)
  {
    paramCardViewDelegate = getShadowBackground(paramCardViewDelegate);
    mPaint.setColor(paramInt);
    paramCardViewDelegate.invalidateSelf();
  }
  
  public final void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    paramCardViewDelegate = getShadowBackground(paramCardViewDelegate);
    paramCardViewDelegate.setShadowSize(paramFloat, mRawMaxShadowSize);
  }
  
  public final void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    RoundRectDrawableWithShadow localRoundRectDrawableWithShadow = getShadowBackground(paramCardViewDelegate);
    localRoundRectDrawableWithShadow.setShadowSize(mRawShadowSize, paramFloat);
    updatePadding(paramCardViewDelegate);
  }
  
  public final void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    RoundRectDrawableWithShadow localRoundRectDrawableWithShadow = getShadowBackground(paramCardViewDelegate);
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Invalid radius " + paramFloat + ". Must be >= 0");
    }
    paramFloat = (int)(0.5F + paramFloat);
    if (mCornerRadius != paramFloat)
    {
      mCornerRadius = paramFloat;
      mDirty = true;
      localRoundRectDrawableWithShadow.invalidateSelf();
    }
    updatePadding(paramCardViewDelegate);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardViewEclairMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */