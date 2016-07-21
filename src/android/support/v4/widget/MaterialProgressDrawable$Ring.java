package android.support.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;

final class MaterialProgressDrawable$Ring
{
  int mAlpha;
  Path mArrow;
  int mArrowHeight;
  final Paint mArrowPaint = new Paint();
  float mArrowScale;
  int mArrowWidth;
  int mBackgroundColor;
  private final Drawable.Callback mCallback;
  final Paint mCirclePaint = new Paint(1);
  int mColorIndex;
  int[] mColors;
  int mCurrentColor;
  float mEndTrim = 0.0F;
  final Paint mPaint = new Paint();
  double mRingCenterRadius;
  float mRotation = 0.0F;
  boolean mShowArrow;
  float mStartTrim = 0.0F;
  float mStartingEndTrim;
  float mStartingRotation;
  float mStartingStartTrim;
  float mStrokeInset = 2.5F;
  float mStrokeWidth = 5.0F;
  final RectF mTempBounds = new RectF();
  
  public MaterialProgressDrawable$Ring(Drawable.Callback paramCallback)
  {
    mCallback = paramCallback;
    mPaint.setStrokeCap(Paint.Cap.SQUARE);
    mPaint.setAntiAlias(true);
    mPaint.setStyle(Paint.Style.STROKE);
    mArrowPaint.setStyle(Paint.Style.FILL);
    mArrowPaint.setAntiAlias(true);
  }
  
  final int getNextColorIndex()
  {
    return (mColorIndex + 1) % mColors.length;
  }
  
  final void invalidateSelf()
  {
    mCallback.invalidateDrawable(null);
  }
  
  public final void resetOriginals()
  {
    mStartingStartTrim = 0.0F;
    mStartingEndTrim = 0.0F;
    mStartingRotation = 0.0F;
    setStartTrim(0.0F);
    setEndTrim(0.0F);
    setRotation(0.0F);
  }
  
  public final void setColorIndex(int paramInt)
  {
    mColorIndex = paramInt;
    mCurrentColor = mColors[mColorIndex];
  }
  
  public final void setColors(int[] paramArrayOfInt)
  {
    mColors = paramArrayOfInt;
    setColorIndex(0);
  }
  
  public final void setEndTrim(float paramFloat)
  {
    mEndTrim = paramFloat;
    invalidateSelf();
  }
  
  public final void setRotation(float paramFloat)
  {
    mRotation = paramFloat;
    invalidateSelf();
  }
  
  public final void setShowArrow(boolean paramBoolean)
  {
    if (mShowArrow != paramBoolean)
    {
      mShowArrow = paramBoolean;
      invalidateSelf();
    }
  }
  
  public final void setStartTrim(float paramFloat)
  {
    mStartTrim = paramFloat;
    invalidateSelf();
  }
  
  public final void storeOriginals()
  {
    mStartingStartTrim = mStartTrim;
    mStartingEndTrim = mEndTrim;
    mStartingRotation = mRotation;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable.Ring
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */