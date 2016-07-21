package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

final class MaterialProgressDrawable
  extends Drawable
  implements Animatable
{
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
  private final int[] COLORS = { -16777216 };
  private Animation mAnimation;
  private final ArrayList<Animation> mAnimators = new ArrayList();
  private final Drawable.Callback mCallback = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      invalidateSelf();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      unscheduleSelf(paramAnonymousRunnable);
    }
  };
  boolean mFinishing;
  private double mHeight;
  private View mParent;
  private Resources mResources;
  final Ring mRing;
  private float mRotation;
  private float mRotationCount;
  private double mWidth;
  
  public MaterialProgressDrawable(final Context paramContext, View paramView)
  {
    mParent = paramView;
    mResources = paramContext.getResources();
    mRing = new Ring(mCallback);
    mRing.setColors(COLORS);
    updateSizes(1);
    paramContext = mRing;
    paramView = new Animation()
    {
      public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        if (mFinishing)
        {
          MaterialProgressDrawable.access$000$7dc75d4f(paramAnonymousFloat, paramContext);
          return;
        }
        float f1 = MaterialProgressDrawable.access$100$6f9943cf(paramContext);
        float f2 = paramContextmStartingEndTrim;
        float f4 = paramContextmStartingStartTrim;
        float f3 = paramContextmStartingRotation;
        MaterialProgressDrawable.access$200$7dc75d4f(paramAnonymousFloat, paramContext);
        if (paramAnonymousFloat <= 0.5F)
        {
          float f5 = paramAnonymousFloat / 0.5F;
          f5 = MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f5);
          paramContext.setStartTrim(f4 + (0.8F - f1) * f5);
        }
        if (paramAnonymousFloat > 0.5F)
        {
          f4 = (paramAnonymousFloat - 0.5F) / 0.5F;
          f4 = MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f4);
          paramContext.setEndTrim(f2 + f4 * (0.8F - f1));
        }
        paramContext.setRotation(f3 + 0.25F * paramAnonymousFloat);
        f1 = mRotationCount / 5.0F;
        setRotation(216.0F * paramAnonymousFloat + 1080.0F * f1);
      }
    };
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(1);
    paramView.setInterpolator(LINEAR_INTERPOLATOR);
    paramView.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        paramContext.storeOriginals();
        MaterialProgressDrawable.Ring localRing = paramContext;
        localRing.setColorIndex(localRing.getNextColorIndex());
        paramContext.setStartTrim(paramContextmEndTrim);
        if (mFinishing)
        {
          mFinishing = false;
          paramAnonymousAnimation.setDuration(1332L);
          paramContext.setShowArrow(false);
          return;
        }
        MaterialProgressDrawable.access$402(MaterialProgressDrawable.this, (mRotationCount + 1.0F) % 5.0F);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        MaterialProgressDrawable.access$402(MaterialProgressDrawable.this, 0.0F);
      }
    });
    mAnimation = paramView;
  }
  
  private static float getMinProgressArc(Ring paramRing)
  {
    return (float)Math.toRadians(mStrokeWidth / (6.283185307179586D * mRingCenterRadius));
  }
  
  private void setSizeParameters(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat1, float paramFloat2)
  {
    Ring localRing = mRing;
    float f1 = mResources.getDisplayMetrics().density;
    mWidth = (f1 * paramDouble1);
    mHeight = (f1 * paramDouble2);
    float f2 = (float)paramDouble4 * f1;
    mStrokeWidth = f2;
    mPaint.setStrokeWidth(f2);
    localRing.invalidateSelf();
    mRingCenterRadius = (f1 * paramDouble3);
    localRing.setColorIndex(0);
    mArrowWidth = ((int)(paramFloat1 * f1));
    mArrowHeight = ((int)(paramFloat2 * f1));
    paramFloat1 = Math.min((int)mWidth, (int)mHeight);
    if ((mRingCenterRadius <= 0.0D) || (paramFloat1 < 0.0F)) {}
    for (paramFloat1 = (float)Math.ceil(mStrokeWidth / 2.0F);; paramFloat1 = (float)(paramFloat1 / 2.0F - mRingCenterRadius))
    {
      mStrokeInset = paramFloat1;
      return;
    }
  }
  
  private static void updateRingColor(float paramFloat, Ring paramRing)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int i = mColors[mColorIndex];
      int n = mColors[paramRing.getNextColorIndex()];
      int m = Integer.valueOf(i).intValue();
      i = m >> 24 & 0xFF;
      int j = m >> 16 & 0xFF;
      int k = m >> 8 & 0xFF;
      m &= 0xFF;
      n = Integer.valueOf(n).intValue();
      int i1 = (int)(((n >> 24 & 0xFF) - i) * paramFloat);
      int i2 = (int)(((n >> 16 & 0xFF) - j) * paramFloat);
      int i3 = (int)(((n >> 8 & 0xFF) - k) * paramFloat);
      mCurrentColor = ((int)(paramFloat * ((n & 0xFF) - m)) + m | i + i1 << 24 | j + i2 << 16 | i3 + k << 8);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    paramCanvas.rotate(mRotation, localRect.exactCenterX(), localRect.exactCenterY());
    Ring localRing = mRing;
    RectF localRectF = mTempBounds;
    localRectF.set(localRect);
    localRectF.inset(mStrokeInset, mStrokeInset);
    float f1 = 360.0F * (mStartTrim + mRotation);
    float f2 = (mEndTrim + mRotation) * 360.0F - f1;
    mPaint.setColor(mCurrentColor);
    paramCanvas.drawArc(localRectF, f1, f2, false, mPaint);
    if (mShowArrow)
    {
      if (mArrow != null) {
        break label437;
      }
      mArrow = new Path();
      mArrow.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      float f3 = (int)mStrokeInset / 2;
      float f4 = mArrowScale;
      float f5 = (float)(mRingCenterRadius * Math.cos(0.0D) + localRect.exactCenterX());
      float f6 = (float)(mRingCenterRadius * Math.sin(0.0D) + localRect.exactCenterY());
      mArrow.moveTo(0.0F, 0.0F);
      mArrow.lineTo(mArrowWidth * mArrowScale, 0.0F);
      mArrow.lineTo(mArrowWidth * mArrowScale / 2.0F, mArrowHeight * mArrowScale);
      mArrow.offset(f5 - f3 * f4, f6);
      mArrow.close();
      mArrowPaint.setColor(mCurrentColor);
      paramCanvas.rotate(f1 + f2 - 5.0F, localRect.exactCenterX(), localRect.exactCenterY());
      paramCanvas.drawPath(mArrow, mArrowPaint);
      if (mAlpha < 255)
      {
        mCirclePaint.setColor(mBackgroundColor);
        mCirclePaint.setAlpha(255 - mAlpha);
        paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), localRect.width() / 2, mCirclePaint);
      }
      paramCanvas.restoreToCount(i);
      return;
      label437:
      mArrow.reset();
    }
  }
  
  public final int getAlpha()
  {
    return mRing.mAlpha;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)mHeight;
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)mWidth;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    ArrayList localArrayList = mAnimators;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Animation localAnimation = (Animation)localArrayList.get(i);
      if ((localAnimation.hasStarted()) && (!localAnimation.hasEnded())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final void setAlpha(int paramInt)
  {
    mRing.mAlpha = paramInt;
  }
  
  public final void setArrowScale(float paramFloat)
  {
    Ring localRing = mRing;
    if (paramFloat != mArrowScale)
    {
      mArrowScale = paramFloat;
      localRing.invalidateSelf();
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    mRing.mBackgroundColor = paramInt;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    Ring localRing = mRing;
    mPaint.setColorFilter(paramColorFilter);
    localRing.invalidateSelf();
  }
  
  final void setRotation(float paramFloat)
  {
    mRotation = paramFloat;
    invalidateSelf();
  }
  
  public final void setStartEndTrim$2548a35(float paramFloat)
  {
    mRing.setStartTrim(0.0F);
    mRing.setEndTrim(paramFloat);
  }
  
  public final void showArrow(boolean paramBoolean)
  {
    mRing.setShowArrow(paramBoolean);
  }
  
  public final void start()
  {
    mAnimation.reset();
    mRing.storeOriginals();
    if (mRing.mEndTrim != mRing.mStartTrim)
    {
      mFinishing = true;
      mAnimation.setDuration(666L);
      mParent.startAnimation(mAnimation);
      return;
    }
    mRing.setColorIndex(0);
    mRing.resetOriginals();
    mAnimation.setDuration(1332L);
    mParent.startAnimation(mAnimation);
  }
  
  public final void stop()
  {
    mParent.clearAnimation();
    setRotation(0.0F);
    mRing.setShowArrow(false);
    mRing.setColorIndex(0);
    mRing.resetOriginals();
  }
  
  public final void updateSizes(int paramInt)
  {
    if (paramInt == 0)
    {
      setSizeParameters(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      return;
    }
    setSizeParameters(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
  }
  
  private static final class Ring
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
    
    public Ring(Drawable.Callback paramCallback)
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
}

/* Location:
 * Qualified Name:     android.support.v4.widget.MaterialProgressDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */