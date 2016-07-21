package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.R.styleable;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class CollapsingTextHelper
{
  private static final boolean DEBUG_DRAW = false;
  private static final Paint DEBUG_DRAW_PAINT;
  private static final boolean USE_SCALING_TEXTURE;
  private boolean mBoundsChanged;
  private final Rect mCollapsedBounds;
  private float mCollapsedDrawX;
  private float mCollapsedDrawY;
  private int mCollapsedShadowColor;
  private float mCollapsedShadowDx;
  private float mCollapsedShadowDy;
  private float mCollapsedShadowRadius;
  private int mCollapsedTextColor;
  private int mCollapsedTextGravity = 16;
  private float mCollapsedTextSize = 15.0F;
  private Typeface mCollapsedTypeface;
  private final RectF mCurrentBounds;
  private float mCurrentDrawX;
  private float mCurrentDrawY;
  private float mCurrentTextSize;
  private Typeface mCurrentTypeface;
  private boolean mDrawTitle;
  private final Rect mExpandedBounds;
  private float mExpandedDrawX;
  private float mExpandedDrawY;
  private float mExpandedFraction;
  private int mExpandedShadowColor;
  private float mExpandedShadowDx;
  private float mExpandedShadowDy;
  private float mExpandedShadowRadius;
  private int mExpandedTextColor;
  private int mExpandedTextGravity = 16;
  private float mExpandedTextSize = 15.0F;
  private Bitmap mExpandedTitleTexture;
  private Typeface mExpandedTypeface;
  private boolean mIsRtl;
  private Interpolator mPositionInterpolator;
  private float mScale;
  private CharSequence mText;
  private final TextPaint mTextPaint;
  private Interpolator mTextSizeInterpolator;
  private CharSequence mTextToDraw;
  private float mTextureAscent;
  private float mTextureDescent;
  private Paint mTexturePaint;
  private boolean mUseTexture;
  private final View mView;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      USE_SCALING_TEXTURE = bool;
      DEBUG_DRAW_PAINT = null;
      return;
    }
  }
  
  public CollapsingTextHelper(View paramView)
  {
    mView = paramView;
    mTextPaint = new TextPaint(129);
    mCollapsedBounds = new Rect();
    mExpandedBounds = new Rect();
    mCurrentBounds = new RectF();
  }
  
  private static int blendColors(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private void calculateBaseOffsets()
  {
    int j = 1;
    float f2 = mCurrentTextSize;
    calculateUsingTextSize(mCollapsedTextSize);
    float f1;
    int i;
    if (mTextToDraw != null)
    {
      f1 = mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length());
      int k = mCollapsedTextGravity;
      if (!mIsRtl) {
        break label387;
      }
      i = 1;
      label61:
      i = GravityCompat.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        float f3 = (mTextPaint.descent() - mTextPaint.ascent()) / 2.0F;
        float f4 = mTextPaint.descent();
        mCollapsedDrawY = (mCollapsedBounds.centerY() + (f3 - f4));
        label144:
        switch (i & 0x800007)
        {
        default: 
          mCollapsedDrawX = mCollapsedBounds.left;
          label188:
          calculateUsingTextSize(mExpandedTextSize);
          if (mTextToDraw != null)
          {
            f1 = mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length());
            label225:
            k = mExpandedTextGravity;
            if (!mIsRtl) {
              break label472;
            }
            i = j;
            label242:
            i = GravityCompat.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              f3 = (mTextPaint.descent() - mTextPaint.ascent()) / 2.0F;
              f4 = mTextPaint.descent();
              mExpandedDrawY = (mExpandedBounds.centerY() + (f3 - f4));
              label328:
              switch (i & 0x800007)
              {
              default: 
                mExpandedDrawX = mExpandedBounds.left;
              }
              break;
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      clearTexture();
      setInterpolatedTextSize(f2);
      return;
      f1 = 0.0F;
      break;
      label387:
      i = 0;
      break label61;
      mCollapsedDrawY = mCollapsedBounds.bottom;
      break label144;
      mCollapsedDrawY = (mCollapsedBounds.top - mTextPaint.ascent());
      break label144;
      mCollapsedDrawX = (mCollapsedBounds.centerX() - f1 / 2.0F);
      break label188;
      mCollapsedDrawX = (mCollapsedBounds.right - f1);
      break label188;
      f1 = 0.0F;
      break label225;
      label472:
      i = 0;
      break label242;
      mExpandedDrawY = mExpandedBounds.bottom;
      break label328;
      mExpandedDrawY = (mExpandedBounds.top - mTextPaint.ascent());
      break label328;
      mExpandedDrawX = (mExpandedBounds.centerX() - f1 / 2.0F);
      continue;
      mExpandedDrawX = (mExpandedBounds.right - f1);
    }
  }
  
  private void calculateCurrentOffsets()
  {
    calculateOffsets(mExpandedFraction);
  }
  
  private boolean calculateIsRtl(CharSequence paramCharSequence)
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(mView) == 1) {
      if (i == 0) {
        break label40;
      }
    }
    label40:
    for (TextDirectionHeuristicCompat localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;; localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR)
    {
      return localTextDirectionHeuristicCompat.isRtl$4d1ed0c3(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private void calculateOffsets(float paramFloat)
  {
    interpolateBounds(paramFloat);
    mCurrentDrawX = lerp(mExpandedDrawX, mCollapsedDrawX, paramFloat, mPositionInterpolator);
    mCurrentDrawY = lerp(mExpandedDrawY, mCollapsedDrawY, paramFloat, mPositionInterpolator);
    setInterpolatedTextSize(lerp(mExpandedTextSize, mCollapsedTextSize, paramFloat, mTextSizeInterpolator));
    if (mCollapsedTextColor != mExpandedTextColor) {
      mTextPaint.setColor(blendColors(mExpandedTextColor, mCollapsedTextColor, paramFloat));
    }
    for (;;)
    {
      mTextPaint.setShadowLayer(lerp(mExpandedShadowRadius, mCollapsedShadowRadius, paramFloat, null), lerp(mExpandedShadowDx, mCollapsedShadowDx, paramFloat, null), lerp(mExpandedShadowDy, mCollapsedShadowDy, paramFloat, null), blendColors(mExpandedShadowColor, mCollapsedShadowColor, paramFloat));
      ViewCompat.postInvalidateOnAnimation(mView);
      return;
      mTextPaint.setColor(mCollapsedTextColor);
    }
  }
  
  private void calculateUsingTextSize(float paramFloat)
  {
    boolean bool = true;
    if (mText == null) {}
    int j;
    int i;
    float f2;
    float f1;
    label80:
    label114:
    do
    {
      return;
      j = 0;
      i = 0;
      if (!isClose(paramFloat, mCollapsedTextSize)) {
        break;
      }
      f2 = mCollapsedBounds.width();
      float f3 = mCollapsedTextSize;
      mScale = 1.0F;
      paramFloat = f2;
      f1 = f3;
      if (mCurrentTypeface != mCollapsedTypeface)
      {
        mCurrentTypeface = mCollapsedTypeface;
        i = 1;
        f1 = f3;
        paramFloat = f2;
      }
      j = i;
      if (paramFloat > 0.0F)
      {
        if ((mCurrentTextSize == f1) && (!mBoundsChanged) && (i == 0)) {
          break label309;
        }
        i = 1;
        mCurrentTextSize = f1;
        mBoundsChanged = false;
        j = i;
      }
    } while ((mTextToDraw != null) && (j == 0));
    mTextPaint.setTextSize(mCurrentTextSize);
    mTextPaint.setTypeface(mCurrentTypeface);
    Object localObject = mTextPaint;
    if (mScale != 1.0F) {}
    for (;;)
    {
      ((TextPaint)localObject).setLinearText(bool);
      localObject = TextUtils.ellipsize(mText, mTextPaint, paramFloat, TextUtils.TruncateAt.END);
      if (TextUtils.equals((CharSequence)localObject, mTextToDraw)) {
        break;
      }
      mTextToDraw = ((CharSequence)localObject);
      mIsRtl = calculateIsRtl(mTextToDraw);
      return;
      f2 = mExpandedBounds.width();
      f1 = mExpandedTextSize;
      i = j;
      if (mCurrentTypeface != mExpandedTypeface)
      {
        mCurrentTypeface = mExpandedTypeface;
        i = 1;
      }
      if (isClose(paramFloat, mExpandedTextSize))
      {
        mScale = 1.0F;
        paramFloat = f2;
        break label80;
      }
      mScale = (paramFloat / mExpandedTextSize);
      paramFloat = f2;
      break label80;
      label309:
      i = 0;
      break label114;
      bool = false;
    }
  }
  
  private void clearTexture()
  {
    if (mExpandedTitleTexture != null)
    {
      mExpandedTitleTexture.recycle();
      mExpandedTitleTexture = null;
    }
  }
  
  private void ensureExpandedTexture()
  {
    if ((mExpandedTitleTexture != null) || (mExpandedBounds.isEmpty()) || (TextUtils.isEmpty(mTextToDraw))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        calculateOffsets(0.0F);
        mTextureAscent = mTextPaint.ascent();
        mTextureDescent = mTextPaint.descent();
        i = Math.round(mTextPaint.measureText(mTextToDraw, 0, mTextToDraw.length()));
        j = Math.round(mTextureDescent - mTextureAscent);
      } while ((i <= 0) || (j <= 0));
      mExpandedTitleTexture = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(mExpandedTitleTexture).drawText(mTextToDraw, 0, mTextToDraw.length(), 0.0F, j - mTextPaint.descent(), mTextPaint);
    } while (mTexturePaint != null);
    mTexturePaint = new Paint(3);
  }
  
  private void interpolateBounds(float paramFloat)
  {
    mCurrentBounds.left = lerp(mExpandedBounds.left, mCollapsedBounds.left, paramFloat, mPositionInterpolator);
    mCurrentBounds.top = lerp(mExpandedDrawY, mCollapsedDrawY, paramFloat, mPositionInterpolator);
    mCurrentBounds.right = lerp(mExpandedBounds.right, mCollapsedBounds.right, paramFloat, mPositionInterpolator);
    mCurrentBounds.bottom = lerp(mExpandedBounds.bottom, mCollapsedBounds.bottom, paramFloat, mPositionInterpolator);
  }
  
  private static boolean isClose(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3, Interpolator paramInterpolator)
  {
    float f = paramFloat3;
    if (paramInterpolator != null) {
      f = paramInterpolator.getInterpolation(paramFloat3);
    }
    return AnimationUtils.lerp(paramFloat1, paramFloat2, f);
  }
  
  private Typeface readFontFamilyTypeface(int paramInt)
  {
    TypedArray localTypedArray = mView.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return (Typeface)localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private static boolean rectEquals(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (left == paramInt1) && (top == paramInt2) && (right == paramInt3) && (bottom == paramInt4);
  }
  
  private void setInterpolatedTextSize(float paramFloat)
  {
    calculateUsingTextSize(paramFloat);
    if ((USE_SCALING_TEXTURE) && (mScale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      mUseTexture = bool;
      if (mUseTexture) {
        ensureExpandedTexture();
      }
      ViewCompat.postInvalidateOnAnimation(mView);
      return;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = paramCanvas.save();
    float f4;
    int i;
    float f1;
    label64:
    float f2;
    if ((mTextToDraw != null) && (mDrawTitle))
    {
      f4 = mCurrentDrawX;
      float f3 = mCurrentDrawY;
      if ((!mUseTexture) || (mExpandedTitleTexture == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = mTextureAscent * mScale;
      f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (mScale != 1.0F) {
        paramCanvas.scale(mScale, mScale, f4, f2);
      }
      if (i == 0) {
        break label155;
      }
      paramCanvas.drawBitmap(mExpandedTitleTexture, f4, f2, mTexturePaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      mTextPaint.ascent();
      f1 = 0.0F;
      mTextPaint.descent();
      break label64;
      label155:
      paramCanvas.drawText(mTextToDraw, 0, mTextToDraw.length(), f4, f2, mTextPaint);
    }
  }
  
  final int getCollapsedTextColor()
  {
    return mCollapsedTextColor;
  }
  
  final int getCollapsedTextGravity()
  {
    return mCollapsedTextGravity;
  }
  
  final float getCollapsedTextSize()
  {
    return mCollapsedTextSize;
  }
  
  final Typeface getCollapsedTypeface()
  {
    if (mCollapsedTypeface != null) {
      return mCollapsedTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  final int getExpandedTextColor()
  {
    return mExpandedTextColor;
  }
  
  final int getExpandedTextGravity()
  {
    return mExpandedTextGravity;
  }
  
  final float getExpandedTextSize()
  {
    return mExpandedTextSize;
  }
  
  final Typeface getExpandedTypeface()
  {
    if (mExpandedTypeface != null) {
      return mExpandedTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  final float getExpansionFraction()
  {
    return mExpandedFraction;
  }
  
  final CharSequence getText()
  {
    return mText;
  }
  
  final void onBoundsChanged()
  {
    if ((mCollapsedBounds.width() > 0) && (mCollapsedBounds.height() > 0) && (mExpandedBounds.width() > 0) && (mExpandedBounds.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      mDrawTitle = bool;
      return;
    }
  }
  
  public final void recalculate()
  {
    if ((mView.getHeight() > 0) && (mView.getWidth() > 0))
    {
      calculateBaseOffsets();
      calculateCurrentOffsets();
    }
  }
  
  final void setCollapsedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(mCollapsedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      mCollapsedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      mBoundsChanged = true;
      onBoundsChanged();
    }
  }
  
  final void setCollapsedTextAppearance(int paramInt)
  {
    TypedArray localTypedArray = mView.getContext().obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    if (localTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      mCollapsedTextColor = localTypedArray.getColor(R.styleable.TextAppearance_android_textColor, mCollapsedTextColor);
    }
    if (localTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) {
      mCollapsedTextSize = localTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)mCollapsedTextSize);
    }
    mCollapsedShadowColor = localTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    mCollapsedShadowDx = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    mCollapsedShadowDy = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    mCollapsedShadowRadius = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      mCollapsedTypeface = readFontFamilyTypeface(paramInt);
    }
    recalculate();
  }
  
  final void setCollapsedTextColor(int paramInt)
  {
    if (mCollapsedTextColor != paramInt)
    {
      mCollapsedTextColor = paramInt;
      recalculate();
    }
  }
  
  final void setCollapsedTextGravity(int paramInt)
  {
    if (mCollapsedTextGravity != paramInt)
    {
      mCollapsedTextGravity = paramInt;
      recalculate();
    }
  }
  
  final void setCollapsedTextSize(float paramFloat)
  {
    if (mCollapsedTextSize != paramFloat)
    {
      mCollapsedTextSize = paramFloat;
      recalculate();
    }
  }
  
  final void setCollapsedTypeface(Typeface paramTypeface)
  {
    if (mCollapsedTypeface != paramTypeface)
    {
      mCollapsedTypeface = paramTypeface;
      recalculate();
    }
  }
  
  final void setExpandedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(mExpandedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      mExpandedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      mBoundsChanged = true;
      onBoundsChanged();
    }
  }
  
  final void setExpandedTextAppearance(int paramInt)
  {
    TypedArray localTypedArray = mView.getContext().obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    if (localTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      mExpandedTextColor = localTypedArray.getColor(R.styleable.TextAppearance_android_textColor, mExpandedTextColor);
    }
    if (localTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) {
      mExpandedTextSize = localTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)mExpandedTextSize);
    }
    mExpandedShadowColor = localTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    mExpandedShadowDx = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    mExpandedShadowDy = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    mExpandedShadowRadius = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      mExpandedTypeface = readFontFamilyTypeface(paramInt);
    }
    recalculate();
  }
  
  final void setExpandedTextColor(int paramInt)
  {
    if (mExpandedTextColor != paramInt)
    {
      mExpandedTextColor = paramInt;
      recalculate();
    }
  }
  
  final void setExpandedTextGravity(int paramInt)
  {
    if (mExpandedTextGravity != paramInt)
    {
      mExpandedTextGravity = paramInt;
      recalculate();
    }
  }
  
  final void setExpandedTextSize(float paramFloat)
  {
    if (mExpandedTextSize != paramFloat)
    {
      mExpandedTextSize = paramFloat;
      recalculate();
    }
  }
  
  final void setExpandedTypeface(Typeface paramTypeface)
  {
    if (mExpandedTypeface != paramTypeface)
    {
      mExpandedTypeface = paramTypeface;
      recalculate();
    }
  }
  
  final void setExpansionFraction(float paramFloat)
  {
    paramFloat = MathUtils.constrain(paramFloat, 0.0F, 1.0F);
    if (paramFloat != mExpandedFraction)
    {
      mExpandedFraction = paramFloat;
      calculateCurrentOffsets();
    }
  }
  
  final void setPositionInterpolator(Interpolator paramInterpolator)
  {
    mPositionInterpolator = paramInterpolator;
    recalculate();
  }
  
  final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(mText)))
    {
      mText = paramCharSequence;
      mTextToDraw = null;
      clearTexture();
      recalculate();
    }
  }
  
  final void setTextSizeInterpolator(Interpolator paramInterpolator)
  {
    mTextSizeInterpolator = paramInterpolator;
    recalculate();
  }
  
  final void setTypefaces(Typeface paramTypeface)
  {
    mExpandedTypeface = paramTypeface;
    mCollapsedTypeface = paramTypeface;
    recalculate();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CollapsingTextHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */