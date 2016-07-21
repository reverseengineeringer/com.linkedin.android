package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

public class RoundedDrawable
  extends Drawable
{
  private final Bitmap mBitmap;
  private final int mBitmapHeight;
  private final Paint mBitmapPaint;
  private final RectF mBitmapRect = new RectF();
  private final int mBitmapWidth;
  private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
  private final Paint mBorderPaint;
  private final RectF mBorderRect = new RectF();
  private float mBorderWidth = 0.0F;
  private final RectF mBounds = new RectF();
  float mCornerRadius = 0.0F;
  final boolean[] mCornersRounded = { 1, 1, 1, 1 };
  private final RectF mDrawableRect = new RectF();
  public boolean mOval = false;
  boolean mRebuildShader = true;
  ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private final Matrix mShaderMatrix = new Matrix();
  private final RectF mSquareCornersRect = new RectF();
  Shader.TileMode mTileModeX = Shader.TileMode.CLAMP;
  Shader.TileMode mTileModeY = Shader.TileMode.CLAMP;
  private PorterDuffColorFilter mTintFilter;
  private ColorStateList mTintList;
  private PorterDuff.Mode mTintMode;
  
  public RoundedDrawable(Bitmap paramBitmap)
  {
    mBitmap = paramBitmap;
    mBitmapWidth = paramBitmap.getWidth();
    mBitmapHeight = paramBitmap.getHeight();
    mBitmapRect.set(0.0F, 0.0F, mBitmapWidth, mBitmapHeight);
    mBitmapPaint = new Paint();
    mBitmapPaint.setStyle(Paint.Style.FILL);
    mBitmapPaint.setAntiAlias(true);
    mBorderPaint = new Paint();
    mBorderPaint.setStyle(Paint.Style.STROKE);
    mBorderPaint.setAntiAlias(true);
    mBorderPaint.setColor(mBorderColor.getColorForState(getState(), -16777216));
    mBorderPaint.setStrokeWidth(mBorderWidth);
  }
  
  private static boolean all(boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfBoolean[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean any(boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    int j = paramArrayOfBoolean.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfBoolean[i] != 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int j = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
      Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
    }
    return null;
  }
  
  public static RoundedDrawable fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new RoundedDrawable(paramBitmap);
    }
    return null;
  }
  
  public static Drawable fromDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == null) || ((paramDrawable instanceof RoundedDrawable))) {}
    Object localObject;
    do
    {
      do
      {
        return paramDrawable;
        if ((paramDrawable instanceof LayerDrawable))
        {
          paramDrawable = (LayerDrawable)paramDrawable;
          int j = paramDrawable.getNumberOfLayers();
          int i = 0;
          while (i < j)
          {
            localObject = paramDrawable.getDrawable(i);
            if (paramDrawable.getId(i) <= 0) {
              paramDrawable.setId(i, i + 1);
            }
            paramDrawable.setDrawableByLayerId(paramDrawable.getId(i), fromDrawable((Drawable)localObject));
            i += 1;
          }
          return paramDrawable;
        }
      } while ((paramDrawable instanceof NinePatchDrawable));
      localObject = drawableToBitmap(paramDrawable);
    } while (localObject == null);
    return new RoundedDrawable((Bitmap)localObject);
  }
  
  private void redrawBitmapForSquareCorners(Canvas paramCanvas)
  {
    if (all(mCornersRounded)) {}
    float f1;
    float f4;
    float f5;
    do
    {
      do
      {
        return;
      } while (mCornerRadius == 0.0F);
      f1 = mDrawableRect.left;
      float f2 = mDrawableRect.top;
      float f3 = f1 + mDrawableRect.width();
      f4 = f2 + mDrawableRect.height();
      f5 = mCornerRadius;
      if (mCornersRounded[0] == 0)
      {
        mSquareCornersRect.set(f1, f2, f1 + f5, f2 + f5);
        paramCanvas.drawRect(mSquareCornersRect, mBitmapPaint);
      }
      if (mCornersRounded[1] == 0)
      {
        mSquareCornersRect.set(f3 - f5, f2, f3, f5);
        paramCanvas.drawRect(mSquareCornersRect, mBitmapPaint);
      }
      if (mCornersRounded[2] == 0)
      {
        mSquareCornersRect.set(f3 - f5, f4 - f5, f3, f4);
        paramCanvas.drawRect(mSquareCornersRect, mBitmapPaint);
      }
    } while (mCornersRounded[3] != 0);
    mSquareCornersRect.set(f1, f4 - f5, f1 + f5, f4);
    paramCanvas.drawRect(mSquareCornersRect, mBitmapPaint);
  }
  
  private PorterDuffColorFilter updateTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (mRebuildShader)
    {
      BitmapShader localBitmapShader = new BitmapShader(mBitmap, mTileModeX, mTileModeY);
      if ((mTileModeX == Shader.TileMode.CLAMP) && (mTileModeY == Shader.TileMode.CLAMP)) {
        localBitmapShader.setLocalMatrix(mShaderMatrix);
      }
      mBitmapPaint.setShader(localBitmapShader);
      mRebuildShader = false;
    }
    int i;
    if ((mTintFilter != null) && (mBitmapPaint.getColorFilter() == null))
    {
      mBitmapPaint.setColorFilter(mTintFilter);
      i = 1;
      if (!mOval) {
        break label180;
      }
      if (mBorderWidth <= 0.0F) {
        break label165;
      }
      paramCanvas.drawOval(mDrawableRect, mBitmapPaint);
      paramCanvas.drawOval(mBorderRect, mBorderPaint);
    }
    for (;;)
    {
      if (i != 0) {
        mBitmapPaint.setColorFilter(null);
      }
      return;
      i = 0;
      break;
      label165:
      paramCanvas.drawOval(mDrawableRect, mBitmapPaint);
      continue;
      label180:
      if (any(mCornersRounded))
      {
        float f1 = mCornerRadius;
        if (mBorderWidth > 0.0F)
        {
          paramCanvas.drawRoundRect(mDrawableRect, f1, f1, mBitmapPaint);
          paramCanvas.drawRoundRect(mBorderRect, f1, f1, mBorderPaint);
          redrawBitmapForSquareCorners(paramCanvas);
          if ((!all(mCornersRounded)) && (mCornerRadius != 0.0F))
          {
            f1 = mDrawableRect.left;
            float f2 = mDrawableRect.top;
            float f3 = f1 + mDrawableRect.width();
            float f4 = f2 + mDrawableRect.height();
            float f5 = mCornerRadius;
            float f6 = mBorderWidth / 2.0F;
            if (mCornersRounded[0] == 0)
            {
              paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, mBorderPaint);
              paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, mBorderPaint);
            }
            if (mCornersRounded[1] == 0)
            {
              paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, mBorderPaint);
              paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, mBorderPaint);
            }
            if (mCornersRounded[2] == 0)
            {
              paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, mBorderPaint);
              paramCanvas.drawLine(f3, f4 - f5, f3, f4, mBorderPaint);
            }
            if (mCornersRounded[3] == 0)
            {
              paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, mBorderPaint);
              paramCanvas.drawLine(f1, f4 - f5, f1, f4, mBorderPaint);
            }
          }
        }
        else
        {
          paramCanvas.drawRoundRect(mDrawableRect, f1, f1, mBitmapPaint);
          redrawBitmapForSquareCorners(paramCanvas);
        }
      }
      else
      {
        paramCanvas.drawRect(mDrawableRect, mBitmapPaint);
        if (mBorderWidth > 0.0F) {
          paramCanvas.drawRect(mBorderRect, mBorderPaint);
        }
      }
    }
  }
  
  public int getAlpha()
  {
    return mBitmapPaint.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return mBitmapPaint.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return mBitmapHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return mBitmapWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return mBorderColor.isStateful();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    mBounds.set(paramRect);
    updateShaderMatrix();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = mBorderColor.getColorForState(paramArrayOfInt, 0);
    if (mBorderPaint.getColor() != i)
    {
      mBorderPaint.setColor(i);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    mBitmapPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public final RoundedDrawable setBorderColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null) {}
    for (;;)
    {
      mBorderColor = paramColorStateList;
      mBorderPaint.setColor(mBorderColor.getColorForState(getState(), -16777216));
      return this;
      paramColorStateList = ColorStateList.valueOf(0);
    }
  }
  
  public final RoundedDrawable setBorderWidth(float paramFloat)
  {
    mBorderWidth = paramFloat;
    mBorderPaint.setStrokeWidth(mBorderWidth);
    return this;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mBitmapPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    mBitmapPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    mBitmapPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    mTintList = paramColorStateList;
    mTintFilter = updateTintFilter(paramColorStateList, mTintMode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    mTintMode = paramMode;
    mTintFilter = updateTintFilter(mTintList, paramMode);
    invalidateSelf();
  }
  
  final void updateShaderMatrix()
  {
    switch (mScaleType)
    {
    case ???: 
    default: 
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.CENTER);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
    }
    for (;;)
    {
      mDrawableRect.set(mBorderRect);
      return;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      mShaderMatrix.setTranslate((int)((mBorderRect.width() - mBitmapWidth) * 0.5F + 0.5F), (int)((mBorderRect.height() - mBitmapHeight) * 0.5F + 0.5F));
      continue;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3;
      if (mBitmapWidth * mBorderRect.height() > mBorderRect.width() * mBitmapHeight)
      {
        f3 = mBorderRect.height() / mBitmapHeight;
        f1 = (mBorderRect.width() - mBitmapWidth * f3) * 0.5F;
      }
      for (;;)
      {
        mShaderMatrix.setScale(f3, f3);
        mShaderMatrix.postTranslate((int)(f1 + 0.5F), (int)(f2 + 0.5F));
        break;
        f3 = mBorderRect.width() / mBitmapWidth;
        f2 = (mBorderRect.height() - mBitmapHeight * f3) * 0.5F;
      }
      mShaderMatrix.reset();
      if ((mBitmapWidth <= mBounds.width()) && (mBitmapHeight <= mBounds.height())) {}
      for (f1 = 1.0F;; f1 = Math.min(mBounds.width() / mBitmapWidth, mBounds.height() / mBitmapHeight))
      {
        f2 = (int)((mBounds.width() - mBitmapWidth * f1) * 0.5F + 0.5F);
        f3 = (int)((mBounds.height() - mBitmapHeight * f1) * 0.5F + 0.5F);
        mShaderMatrix.setScale(f1, f1);
        mShaderMatrix.postTranslate(f2, f3);
        mBorderRect.set(mBitmapRect);
        mShaderMatrix.mapRect(mBorderRect);
        mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
        mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
        break;
      }
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.END);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      mBorderRect.set(mBitmapRect);
      mShaderMatrix.setRectToRect(mBitmapRect, mBounds, Matrix.ScaleToFit.START);
      mShaderMatrix.mapRect(mBorderRect);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
      continue;
      mBorderRect.set(mBounds);
      mBorderRect.inset(mBorderWidth / 2.0F, mBorderWidth / 2.0F);
      mShaderMatrix.reset();
      mShaderMatrix.setRectToRect(mBitmapRect, mBorderRect, Matrix.ScaleToFit.FILL);
    }
  }
}

/* Location:
 * Qualified Name:     com.makeramen.roundedimageview.RoundedDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */