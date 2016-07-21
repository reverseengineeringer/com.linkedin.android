package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.linkedin.android.imageloader.R.styleable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundedImageView
  extends ImageView
{
  public static final float DEFAULT_BORDER_WIDTH = 0.0F;
  public static final float DEFAULT_RADIUS = 0.0F;
  public static final Shader.TileMode DEFAULT_TILE_MODE = Shader.TileMode.CLAMP;
  private static final ImageView.ScaleType[] SCALE_TYPES = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  public static final String TAG = "RoundedImageView";
  private static final int TILE_MODE_CLAMP = 0;
  private static final int TILE_MODE_MIRROR = 2;
  private static final int TILE_MODE_REPEAT = 1;
  private static final int TILE_MODE_UNDEFINED = -2;
  private Drawable mBackgroundDrawable;
  private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
  private float mBorderWidth = 0.0F;
  private ColorFilter mColorFilter = null;
  private boolean mColorMod = false;
  private final float[] mCornerRadii = { 0.0F, 0.0F, 0.0F, 0.0F };
  private Drawable mDrawable;
  private boolean mHasColorFilter = false;
  private boolean mIsOval = false;
  private boolean mMutateBackground = false;
  private int mResource;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private Shader.TileMode mTileModeX = DEFAULT_TILE_MODE;
  private Shader.TileMode mTileModeY = DEFAULT_TILE_MODE;
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
    float f2;
    int i;
    if (paramInt >= 0)
    {
      setScaleType(SCALE_TYPES[paramInt]);
      f2 = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
      mCornerRadii[0] = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_left, -1);
      mCornerRadii[1] = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_right, -1);
      mCornerRadii[2] = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_right, -1);
      mCornerRadii[3] = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_left, -1);
      i = 0;
      paramInt = 0;
      int j = mCornerRadii.length;
      label206:
      if (paramInt >= j) {
        break label253;
      }
      if (mCornerRadii[paramInt] >= 0.0F) {
        break label247;
      }
      mCornerRadii[paramInt] = 0.0F;
    }
    for (;;)
    {
      paramInt += 1;
      break label206;
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      break;
      label247:
      i = 1;
    }
    label253:
    if (i == 0)
    {
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      paramInt = 0;
      i = mCornerRadii.length;
      while (paramInt < i)
      {
        mCornerRadii[paramInt] = f1;
        paramInt += 1;
      }
    }
    mBorderWidth = paramContext.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
    if (mBorderWidth < 0.0F) {
      mBorderWidth = 0.0F;
    }
    mBorderColor = paramContext.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
    if (mBorderColor == null) {
      mBorderColor = ColorStateList.valueOf(-16777216);
    }
    mMutateBackground = paramContext.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
    mIsOval = paramContext.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
    paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
    if (paramInt != -2)
    {
      setTileModeX(parseTileMode(paramInt));
      setTileModeY(parseTileMode(paramInt));
    }
    paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
    if (paramInt != -2) {
      setTileModeX(parseTileMode(paramInt));
    }
    paramInt = paramContext.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
    if (paramInt != -2) {
      setTileModeY(parseTileMode(paramInt));
    }
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(true);
    paramContext.recycle();
  }
  
  private void applyColorMod()
  {
    if ((mDrawable != null) && (mColorMod))
    {
      mDrawable = mDrawable.mutate();
      if (mHasColorFilter) {
        mDrawable.setColorFilter(mColorFilter);
      }
    }
  }
  
  private static Shader.TileMode parseTileMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
  
  private Drawable resolveResource()
  {
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (mResource != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(mResource);
      return RoundedDrawable.fromDrawable((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("RoundedImageView", "Unable to find resource: " + mResource, localException);
        mResource = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void updateAttrs(Drawable paramDrawable)
  {
    int m = 1;
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      if ((paramDrawable instanceof RoundedDrawable))
      {
        RoundedDrawable localRoundedDrawable = (RoundedDrawable)paramDrawable;
        Object localObject2 = mScaleType;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ImageView.ScaleType.FIT_CENTER;
        }
        if (mScaleType != localObject1)
        {
          mScaleType = ((ImageView.ScaleType)localObject1);
          localRoundedDrawable.updateShaderMatrix();
        }
        localObject1 = localRoundedDrawable.setBorderWidth(mBorderWidth).setBorderColor(mBorderColor);
        mOval = mIsOval;
        localObject2 = mTileModeX;
        if (mTileModeX != localObject2)
        {
          mTileModeX = ((Shader.TileMode)localObject2);
          mRebuildShader = true;
          ((RoundedDrawable)localObject1).invalidateSelf();
        }
        localObject2 = mTileModeY;
        if (mTileModeY != localObject2)
        {
          mTileModeY = ((Shader.TileMode)localObject2);
          mRebuildShader = true;
          ((RoundedDrawable)localObject1).invalidateSelf();
        }
        if (mCornerRadii != null)
        {
          paramDrawable = (RoundedDrawable)paramDrawable;
          float f1 = mCornerRadii[0];
          float f2 = mCornerRadii[1];
          float f3 = mCornerRadii[2];
          float f4 = mCornerRadii[3];
          localObject1 = new HashSet(4);
          ((Set)localObject1).add(Float.valueOf(f1));
          ((Set)localObject1).add(Float.valueOf(f2));
          ((Set)localObject1).add(Float.valueOf(f3));
          ((Set)localObject1).add(Float.valueOf(f4));
          ((Set)localObject1).remove(Float.valueOf(0.0F));
          if (((Set)localObject1).size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
          }
          if (((Set)localObject1).isEmpty()) {
            break label469;
          }
          float f5 = ((Float)((Set)localObject1).iterator().next()).floatValue();
          if ((Float.isInfinite(f5)) || (Float.isNaN(f5)) || (f5 < 0.0F)) {
            throw new IllegalArgumentException("Invalid radius value: " + f5);
          }
          mCornerRadius = f5;
          localObject1 = mCornersRounded;
          if (f1 <= 0.0F) {
            break label477;
          }
          k = 1;
          label394:
          localObject1[0] = k;
          localObject1 = mCornersRounded;
          if (f2 <= 0.0F) {
            break label483;
          }
          k = 1;
          label415:
          localObject1[1] = k;
          localObject1 = mCornersRounded;
          if (f3 <= 0.0F) {
            break label489;
          }
          k = 1;
          label437:
          localObject1[2] = k;
          paramDrawable = mCornersRounded;
          if (f4 <= 0.0F) {
            break label495;
          }
        }
        label469:
        label477:
        label483:
        label489:
        label495:
        for (int k = m;; k = 0)
        {
          paramDrawable[3] = k;
          applyColorMod();
          return;
          mCornerRadius = 0.0F;
          break;
          k = 0;
          break label394;
          k = 0;
          break label415;
          k = 0;
          break label437;
        }
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = 0;
        int j = paramDrawable.getNumberOfLayers();
        while (i < j)
        {
          updateAttrs(paramDrawable.getDrawable(i));
          i += 1;
        }
      }
    }
  }
  
  private void updateBackgroundDrawableAttrs(boolean paramBoolean)
  {
    if (mMutateBackground)
    {
      if (paramBoolean) {
        mBackgroundDrawable = RoundedDrawable.fromDrawable(mBackgroundDrawable);
      }
      updateAttrs(mBackgroundDrawable);
    }
  }
  
  private void updateDrawableAttrs()
  {
    updateAttrs(mDrawable);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public int getBorderColor()
  {
    return mBorderColor.getDefaultColor();
  }
  
  public ColorStateList getBorderColors()
  {
    return mBorderColor;
  }
  
  public float getBorderWidth()
  {
    return mBorderWidth;
  }
  
  public float getCornerRadius()
  {
    return getMaxCornerRadius();
  }
  
  public float getCornerRadius(int paramInt)
  {
    return mCornerRadii[paramInt];
  }
  
  public float getMaxCornerRadius()
  {
    float f = 0.0F;
    float[] arrayOfFloat = mCornerRadii;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      f = Math.max(arrayOfFloat[i], f);
      i += 1;
    }
    return f;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return mScaleType;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return mTileModeX;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return mTileModeY;
  }
  
  public boolean isOval()
  {
    return mIsOval;
  }
  
  public void mutateBackground(boolean paramBoolean)
  {
    if (mMutateBackground == paramBoolean) {
      return;
    }
    mMutateBackground = paramBoolean;
    updateBackgroundDrawableAttrs(true);
    invalidate();
  }
  
  public boolean mutatesBackground()
  {
    return mMutateBackground;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mBackgroundDrawable = paramDrawable;
    updateBackgroundDrawableAttrs(true);
    super.setBackgroundDrawable(mBackgroundDrawable);
  }
  
  public void setBorderColor(int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (mBorderColor.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList != null) {}
    for (;;)
    {
      mBorderColor = paramColorStateList;
      updateDrawableAttrs();
      updateBackgroundDrawableAttrs(false);
      if (mBorderWidth <= 0.0F) {
        break;
      }
      invalidate();
      return;
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (mBorderWidth == paramFloat) {
      return;
    }
    mBorderWidth = paramFloat;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (mColorFilter != paramColorFilter)
    {
      mColorFilter = paramColorFilter;
      mHasColorFilter = true;
      mColorMod = true;
      applyColorMod();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    setCornerRadius(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((mCornerRadii[0] == paramFloat1) && (mCornerRadii[1] == paramFloat2) && (mCornerRadii[2] == paramFloat4) && (mCornerRadii[3] == paramFloat3)) {
      return;
    }
    mCornerRadii[0] = paramFloat1;
    mCornerRadii[1] = paramFloat2;
    mCornerRadii[3] = paramFloat3;
    mCornerRadii[2] = paramFloat4;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setCornerRadius(int paramInt, float paramFloat)
  {
    if (mCornerRadii[paramInt] == paramFloat) {
      return;
    }
    mCornerRadii[paramInt] = paramFloat;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setCornerRadiusDimen(int paramInt)
  {
    float f = getResources().getDimension(paramInt);
    setCornerRadius(f, f, f, f);
  }
  
  public void setCornerRadiusDimen(int paramInt1, int paramInt2)
  {
    setCornerRadius(paramInt1, getResources().getDimensionPixelSize(paramInt2));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    mResource = 0;
    mDrawable = RoundedDrawable.fromBitmap(paramBitmap);
    updateDrawableAttrs();
    super.setImageDrawable(mDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    mResource = 0;
    mDrawable = RoundedDrawable.fromDrawable(paramDrawable);
    updateDrawableAttrs();
    super.setImageDrawable(mDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    if (mResource != paramInt)
    {
      mResource = paramInt;
      mDrawable = resolveResource();
      updateDrawableAttrs();
      super.setImageDrawable(mDrawable);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    mIsOval = paramBoolean;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (mScaleType != paramScaleType)
    {
      mScaleType = paramScaleType;
      super.setScaleType(paramScaleType);
      updateDrawableAttrs();
      updateBackgroundDrawableAttrs(false);
      invalidate();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (mTileModeX == paramTileMode) {
      return;
    }
    mTileModeX = paramTileMode;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (mTileModeY == paramTileMode) {
      return;
    }
    mTileModeY = paramTileMode;
    updateDrawableAttrs();
    updateBackgroundDrawableAttrs(false);
    invalidate();
  }
}

/* Location:
 * Qualified Name:     com.makeramen.roundedimageview.RoundedImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */