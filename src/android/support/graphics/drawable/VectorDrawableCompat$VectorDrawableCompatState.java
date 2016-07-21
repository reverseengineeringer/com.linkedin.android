package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class VectorDrawableCompat$VectorDrawableCompatState
  extends Drawable.ConstantState
{
  boolean mAutoMirrored;
  boolean mCacheDirty;
  boolean mCachedAutoMirrored;
  Bitmap mCachedBitmap;
  int mCachedRootAlpha;
  ColorStateList mCachedTint;
  PorterDuff.Mode mCachedTintMode;
  int mChangingConfigurations;
  Paint mTempPaint;
  ColorStateList mTint = null;
  PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
  VectorDrawableCompat.VPathRenderer mVPathRenderer;
  
  public VectorDrawableCompat$VectorDrawableCompatState()
  {
    mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
  }
  
  public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    if (paramVectorDrawableCompatState != null)
    {
      mChangingConfigurations = mChangingConfigurations;
      mVPathRenderer = new VectorDrawableCompat.VPathRenderer(mVPathRenderer);
      if (VectorDrawableCompat.VPathRenderer.access$400(mVPathRenderer) != null) {
        VectorDrawableCompat.VPathRenderer.access$402(mVPathRenderer, new Paint(VectorDrawableCompat.VPathRenderer.access$400(mVPathRenderer)));
      }
      if (VectorDrawableCompat.VPathRenderer.access$500(mVPathRenderer) != null) {
        VectorDrawableCompat.VPathRenderer.access$502(mVPathRenderer, new Paint(VectorDrawableCompat.VPathRenderer.access$500(mVPathRenderer)));
      }
      mTint = mTint;
      mTintMode = mTintMode;
      mAutoMirrored = mAutoMirrored;
    }
  }
  
  public final int getChangingConfigurations()
  {
    return mChangingConfigurations;
  }
  
  public final Drawable newDrawable()
  {
    return new VectorDrawableCompat(this, (byte)0);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new VectorDrawableCompat(this, (byte)0);
  }
  
  public final void updateCachedBitmap(int paramInt1, int paramInt2)
  {
    mCachedBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(mCachedBitmap);
    mVPathRenderer.draw$65b72e48(localCanvas, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VectorDrawableCompatState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */