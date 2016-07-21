package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class RoundRectDrawable
  extends Drawable
{
  private final RectF mBoundsF;
  private final Rect mBoundsI;
  boolean mInsetForPadding = false;
  boolean mInsetForRadius = true;
  float mPadding;
  final Paint mPaint;
  float mRadius;
  private ColorStateList mTint;
  private PorterDuffColorFilter mTintFilter;
  private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
  
  public RoundRectDrawable(int paramInt, float paramFloat)
  {
    mRadius = paramFloat;
    mPaint = new Paint(5);
    mPaint.setColor(paramInt);
    mBoundsF = new RectF();
    mBoundsI = new Rect();
  }
  
  private PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Paint localPaint = mPaint;
    if ((mTintFilter != null) && (localPaint.getColorFilter() == null)) {
      localPaint.setColorFilter(mTintFilter);
    }
    for (int i = 1;; i = 0)
    {
      paramCanvas.drawRoundRect(mBoundsF, mRadius, mRadius, localPaint);
      if (i != 0) {
        localPaint.setColorFilter(null);
      }
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(mBoundsI, mRadius);
  }
  
  public final boolean isStateful()
  {
    return ((mTint != null) && (mTint.isStateful())) || (super.isStateful());
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    updateBounds(paramRect);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if ((mTint != null) && (mTintMode != null))
    {
      mTintFilter = createTintFilter(mTint, mTintMode);
      return true;
    }
    return false;
  }
  
  public final void setAlpha(int paramInt)
  {
    mPaint.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    mPaint.setColorFilter(paramColorFilter);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    mTint = paramColorStateList;
    mTintFilter = createTintFilter(mTint, mTintMode);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    mTintMode = paramMode;
    mTintFilter = createTintFilter(mTint, mTintMode);
    invalidateSelf();
  }
  
  final void updateBounds(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    mBoundsF.set(left, top, right, bottom);
    mBoundsI.set(localRect);
    if (mInsetForPadding)
    {
      float f1 = RoundRectDrawableWithShadow.calculateVerticalPadding(mPadding, mRadius, mInsetForRadius);
      float f2 = RoundRectDrawableWithShadow.calculateHorizontalPadding(mPadding, mRadius, mInsetForRadius);
      mBoundsI.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      mBoundsF.set(mBoundsI);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RoundRectDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */