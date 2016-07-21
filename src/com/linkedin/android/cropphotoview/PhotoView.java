package com.linkedin.android.cropphotoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class PhotoView
  extends ImageView
  implements IPhotoView
{
  public final PhotoViewAttacher mAttacher;
  private ImageView.ScaleType mPendingScaleType;
  
  public PhotoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    mAttacher = new PhotoViewAttacher(this);
    if (mPendingScaleType != null)
    {
      setScaleType(mPendingScaleType);
      mPendingScaleType = null;
    }
  }
  
  public Matrix getDisplayMatrix()
  {
    return mAttacher.getDrawMatrix();
  }
  
  public RectF getDisplayRect()
  {
    return mAttacher.getDisplayRect();
  }
  
  public IPhotoView getIPhotoViewImplementation()
  {
    return mAttacher;
  }
  
  public float getMaximumScale()
  {
    return mAttacher.mMaxScale;
  }
  
  public float getMediumScale()
  {
    return mAttacher.mMidScale;
  }
  
  public float getMinimumScale()
  {
    return mAttacher.mMinScale;
  }
  
  public PhotoViewAttacher.OnPhotoTapListener getOnPhotoTapListener()
  {
    return mAttacher.mPhotoTapListener;
  }
  
  public PhotoViewAttacher.OnViewTapListener getOnViewTapListener()
  {
    return mAttacher.mViewTapListener;
  }
  
  public float getScale()
  {
    return mAttacher.getScale();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return mAttacher.mScaleType;
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    ImageView localImageView = mAttacher.getImageView();
    if (localImageView == null) {
      return null;
    }
    return localImageView.getDrawingCache();
  }
  
  protected void onDetachedFromWindow()
  {
    mAttacher.cleanup();
    super.onDetachedFromWindow();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    mAttacher.mAllowParentInterceptOnEdge = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (mAttacher != null) {
      mAttacher.update();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (mAttacher != null) {
      mAttacher.update();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (mAttacher != null) {
      mAttacher.update();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    mAttacher.mMaxScale = paramFloat;
  }
  
  public void setMediumScale(float paramFloat)
  {
    mAttacher.mMidScale = paramFloat;
  }
  
  public void setMinimumScale(float paramFloat)
  {
    mAttacher.mMinScale = paramFloat;
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    PhotoViewAttacher localPhotoViewAttacher = mAttacher;
    if (paramOnDoubleTapListener != null)
    {
      mGestureDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
      return;
    }
    mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(localPhotoViewAttacher));
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    mAttacher.mLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    mAttacher.mMatrixChangeListener = paramOnMatrixChangedListener;
  }
  
  public void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener paramOnPhotoTapListener)
  {
    mAttacher.mPhotoTapListener = paramOnPhotoTapListener;
  }
  
  public void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener paramOnViewTapListener)
  {
    mAttacher.mViewTapListener = paramOnViewTapListener;
  }
  
  public void setRotationBy(float paramFloat)
  {
    PhotoViewAttacher localPhotoViewAttacher = mAttacher;
    mSuppMatrix.postRotate(paramFloat % 360.0F);
    localPhotoViewAttacher.checkAndDisplayMatrix();
  }
  
  public void setRotationTo(float paramFloat)
  {
    PhotoViewAttacher localPhotoViewAttacher = mAttacher;
    mSuppMatrix.setRotate(paramFloat % 360.0F);
    localPhotoViewAttacher.checkAndDisplayMatrix();
  }
  
  public void setScale(float paramFloat)
  {
    mAttacher.setScale(paramFloat, false);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (mAttacher != null)
    {
      PhotoViewAttacher localPhotoViewAttacher = mAttacher;
      if ((PhotoViewAttacher.isSupportedScaleType(paramScaleType)) && (paramScaleType != mScaleType))
      {
        mScaleType = paramScaleType;
        localPhotoViewAttacher.update();
      }
      return;
    }
    mPendingScaleType = paramScaleType;
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    PhotoViewAttacher localPhotoViewAttacher = mAttacher;
    int i = paramInt;
    if (paramInt < 0) {
      i = 200;
    }
    ZOOM_DURATION = i;
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    mAttacher.setZoomable(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.PhotoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */