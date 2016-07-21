package com.linkedin.android.cropphotoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.linkedin.android.cropphotoview.gestures.CupcakeGestureDetector;
import com.linkedin.android.cropphotoview.gestures.EclairGestureDetector;
import com.linkedin.android.cropphotoview.gestures.FroyoGestureDetector;
import com.linkedin.android.cropphotoview.gestures.OnGestureListener;
import com.linkedin.android.cropphotoview.scrollerproxy.IcsScroller;
import com.linkedin.android.cropphotoview.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;

public final class PhotoViewAttacher
  implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener
{
  private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
  static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
  int ZOOM_DURATION = 200;
  public IGetImageBounds boundsListener;
  boolean mAllowParentInterceptOnEdge = true;
  private final Matrix mBaseMatrix = new Matrix();
  private FlingRunnable mCurrentFlingRunnable;
  private final RectF mDisplayRect = new RectF();
  private final Matrix mDrawMatrix = new Matrix();
  android.view.GestureDetector mGestureDetector;
  private WeakReference<ImageView> mImageView;
  private int mIvBottom;
  private int mIvLeft;
  private int mIvRight;
  private int mIvTop;
  View.OnLongClickListener mLongClickListener;
  OnMatrixChangedListener mMatrixChangeListener;
  private final float[] mMatrixValues = new float[9];
  float mMaxScale = 3.0F;
  float mMidScale = 1.75F;
  public float mMinScale = 1.0F;
  OnPhotoTapListener mPhotoTapListener;
  private com.linkedin.android.cropphotoview.gestures.GestureDetector mScaleDragDetector;
  ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private int mScrollEdge = 2;
  final Matrix mSuppMatrix = new Matrix();
  public OnViewTapListener mViewTapListener;
  boolean mZoomEnabled;
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    mImageView = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    paramImageView.getViewTreeObserver();
    setImageViewScaleTypeMatrix(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    Object localObject = paramImageView.getContext();
    int i = Build.VERSION.SDK_INT;
    if (i < 5) {
      localObject = new CupcakeGestureDetector((Context)localObject);
    }
    for (;;)
    {
      ((com.linkedin.android.cropphotoview.gestures.GestureDetector)localObject).setOnGestureListener(this);
      mScaleDragDetector = ((com.linkedin.android.cropphotoview.gestures.GestureDetector)localObject);
      mGestureDetector = new android.view.GestureDetector(paramImageView.getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          if (mLongClickListener != null) {
            mLongClickListener.onLongClick(getImageView());
          }
        }
      });
      mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
      setZoomable(true);
      return;
      if (i < 8) {
        localObject = new EclairGestureDetector((Context)localObject);
      } else {
        localObject = new FroyoGestureDetector((Context)localObject);
      }
    }
  }
  
  private void cancelFling()
  {
    if (mCurrentFlingRunnable != null)
    {
      FlingRunnable localFlingRunnable = mCurrentFlingRunnable;
      if (DEBUG) {
        Log.d("PhotoViewAttacher", "Cancel Fling");
      }
      mScroller.forceFinished$1385ff();
      mCurrentFlingRunnable = null;
    }
  }
  
  private boolean checkMatrixBounds()
  {
    ImageView localImageView = getImageView();
    if (localImageView == null) {}
    RectF localRectF;
    do
    {
      return false;
      localRectF = getDisplayRect(getDrawMatrix());
    } while (localRectF == null);
    float f4 = localRectF.height();
    float f3 = localRectF.width();
    float f2 = 0.0F;
    float f1 = 0.0F;
    Rect localRect;
    int i;
    if (getImageView() == null)
    {
      localRect = null;
      i = localRect.height();
      getImageViewHeight(localImageView);
      if (f4 > i) {
        break label270;
      }
      switch (mScaleType)
      {
      default: 
        f1 = 0.0F;
        label114:
        i = localRect.width();
        if (f3 <= i) {
          switch (mScaleType)
          {
          default: 
            f2 = (i - f3) / 2.0F - left;
            label178:
            mScrollEdge = 2;
          }
        }
        break;
      }
    }
    for (;;)
    {
      mSuppMatrix.postTranslate(f2, f1);
      return true;
      if (boundsListener != null)
      {
        localRect = boundsListener.getImageBounds();
        break;
      }
      localRect = new Rect(0, 0, getImageViewWidth(getImageView()), getImageViewHeight(getImageView()));
      break;
      f1 = -top;
      break label114;
      f1 = i - f4 - top;
      break label114;
      label270:
      if (top > top)
      {
        f1 = -(top - top);
        break label114;
      }
      if (bottom >= bottom) {
        break label114;
      }
      f1 = bottom - bottom;
      break label114;
      f2 = -left;
      break label178;
      f2 = i - f3 - left;
      break label178;
      if (left > left)
      {
        mScrollEdge = 0;
        f2 = -(left - left);
      }
      else if (right < right)
      {
        f2 = right - right;
        mScrollEdge = 1;
      }
      else
      {
        mScrollEdge = -1;
      }
    }
  }
  
  private RectF getDisplayRect(Matrix paramMatrix)
  {
    Object localObject = getImageView();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        mDisplayRect.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(mDisplayRect);
        return mDisplayRect;
      }
    }
    return null;
  }
  
  private static int getImageViewHeight(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private static int getImageViewWidth(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private float getValue(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(mMatrixValues);
    return mMatrixValues[paramInt];
  }
  
  static boolean isSupportedScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (paramScaleType)
    {
    default: 
      return true;
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }
  
  private void resetMatrix()
  {
    mSuppMatrix.reset();
    setImageViewMatrix(getDrawMatrix());
    checkMatrixBounds();
  }
  
  private void setImageViewMatrix(Matrix paramMatrix)
  {
    ImageView localImageView1 = getImageView();
    if (localImageView1 != null)
    {
      ImageView localImageView2 = getImageView();
      if ((localImageView2 != null) && (!(localImageView2 instanceof IPhotoView)) && (!ImageView.ScaleType.MATRIX.equals(localImageView2.getScaleType()))) {
        throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
      }
      localImageView1.setImageMatrix(paramMatrix);
      if (mMatrixChangeListener != null) {
        getDisplayRect(paramMatrix);
      }
    }
  }
  
  private static void setImageViewScaleTypeMatrix(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof IPhotoView)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private void updateBaseMatrix(Drawable paramDrawable)
  {
    Object localObject = getImageView();
    if ((localObject == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = getImageViewWidth((ImageView)localObject);
    float f2 = getImageViewHeight((ImageView)localObject);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    mBaseMatrix.reset();
    float f3 = f1 / i;
    float f4 = f2 / j;
    if (mScaleType == ImageView.ScaleType.CENTER) {
      mBaseMatrix.postTranslate((f1 - i) / 2.0F, (f2 - j) / 2.0F);
    }
    for (;;)
    {
      resetMatrix();
      return;
      if (mScaleType == ImageView.ScaleType.CENTER_CROP)
      {
        f3 = Math.max(f3, f4);
        mBaseMatrix.postScale(f3, f3);
        mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - j * f3) / 2.0F);
      }
      else if (mScaleType == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        mBaseMatrix.postScale(f3, f3);
        mBaseMatrix.postTranslate((f1 - i * f3) / 2.0F, (f2 - j * f3) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, i, j);
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        switch (mScaleType)
        {
        default: 
          break;
        case ???: 
          mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
          break;
        case ???: 
          mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
          break;
        case ???: 
          mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          break;
        case ???: 
          mBaseMatrix.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  final void checkAndDisplayMatrix()
  {
    if (checkMatrixBounds()) {
      setImageViewMatrix(getDrawMatrix());
    }
  }
  
  public final void cleanup()
  {
    if (mImageView == null) {
      return;
    }
    ImageView localImageView = (ImageView)mImageView.get();
    if (localImageView != null)
    {
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      localImageView.setOnTouchListener(null);
      cancelFling();
    }
    if (mGestureDetector != null) {
      mGestureDetector.setOnDoubleTapListener(null);
    }
    mMatrixChangeListener = null;
    mPhotoTapListener = null;
    mViewTapListener = null;
    mImageView = null;
  }
  
  public final RectF getDisplayRect()
  {
    checkMatrixBounds();
    return getDisplayRect(getDrawMatrix());
  }
  
  public final Matrix getDrawMatrix()
  {
    mDrawMatrix.set(mBaseMatrix);
    mDrawMatrix.postConcat(mSuppMatrix);
    return mDrawMatrix;
  }
  
  public final ImageView getImageView()
  {
    ImageView localImageView = null;
    if (mImageView != null) {
      localImageView = (ImageView)mImageView.get();
    }
    if (localImageView == null)
    {
      cleanup();
      Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return localImageView;
  }
  
  public final float getScale()
  {
    return (float)Math.sqrt(Math.pow(getValue(mSuppMatrix, 0), 2.0D) + Math.pow(getValue(mSuppMatrix, 3), 2.0D));
  }
  
  public final void onDrag(float paramFloat1, float paramFloat2)
  {
    if (mScaleDragDetector.isScaling()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (DEBUG) {
          Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
        }
        localObject = getImageView();
        mSuppMatrix.postTranslate(paramFloat1, paramFloat2);
        checkAndDisplayMatrix();
        localObject = ((ImageView)localObject).getParent();
        if ((!mAllowParentInterceptOnEdge) || (mScaleDragDetector.isScaling())) {
          break;
        }
      } while (((mScrollEdge != 2) && ((mScrollEdge != 0) || (paramFloat1 < 1.0F)) && ((mScrollEdge != 1) || (paramFloat1 > -1.0F))) || (localObject == null));
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      return;
    } while (localObject == null);
    ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
  }
  
  public final void onFling(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (DEBUG) {
      Log.d("PhotoViewAttacher", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
    }
    ImageView localImageView = getImageView();
    mCurrentFlingRunnable = new FlingRunnable(localImageView.getContext());
    FlingRunnable localFlingRunnable = mCurrentFlingRunnable;
    getImageViewWidth(localImageView);
    getImageViewHeight(localImageView);
    RectF localRectF = this$0.getDisplayRect();
    if (localRectF != null)
    {
      int i = Math.round(-left);
      int j = Math.round(-top);
      mCurrentX = i;
      mCurrentY = j;
      if (DEBUG) {
        Log.d("PhotoViewAttacher", "fling. StartX:" + i + " StartY:" + j + " MaxX:" + i + " MaxY:" + j);
      }
    }
    localImageView.post(mCurrentFlingRunnable);
  }
  
  public final void onGlobalLayout()
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if (!mZoomEnabled) {
        break label107;
      }
      int i = localImageView.getTop();
      int j = localImageView.getRight();
      int k = localImageView.getBottom();
      int m = localImageView.getLeft();
      if ((i != mIvTop) || (k != mIvBottom) || (m != mIvLeft) || (j != mIvRight))
      {
        updateBaseMatrix(localImageView.getDrawable());
        mIvTop = i;
        mIvRight = j;
        mIvBottom = k;
        mIvLeft = m;
      }
    }
    return;
    label107:
    updateBaseMatrix(localImageView.getDrawable());
  }
  
  public final void onScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (DEBUG) {
      Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    if ((getScale() < mMaxScale) || (paramFloat1 < 1.0F))
    {
      mSuppMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      checkAndDisplayMatrix();
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = (ImageView)paramView;
    int i;
    if ((localObject != null) && (((ImageView)localObject).getDrawable() != null))
    {
      i = 1;
      if (i != 0)
      {
        localObject = paramView.getParent();
        bool1 = bool2;
        switch (paramMotionEvent.getAction())
        {
        default: 
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (mZoomEnabled)
      {
        bool2 = bool1;
        if (mScaleDragDetector != null)
        {
          bool2 = bool1;
          if (mScaleDragDetector.onTouchEvent(paramMotionEvent)) {
            bool2 = true;
          }
        }
      }
      bool1 = bool2;
      if (mGestureDetector != null)
      {
        bool1 = bool2;
        if (mGestureDetector.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      return bool1;
      i = 0;
      break;
      if (localObject != null) {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
      }
      cancelFling();
      bool1 = bool2;
      continue;
      bool1 = bool2;
      if (getScale() < mMinScale)
      {
        localObject = getDisplayRect();
        bool1 = bool2;
        if (localObject != null)
        {
          paramView.post(new AnimatedZoomRunnable(getScale(), mMinScale, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
          bool1 = true;
        }
      }
    }
  }
  
  public final void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      if ((paramFloat1 < mMinScale) || (paramFloat1 > mMaxScale)) {
        Log.i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      localImageView.post(new AnimatedZoomRunnable(getScale(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    mSuppMatrix.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    checkAndDisplayMatrix();
  }
  
  public final void setScale(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = getImageView();
    if (localImageView != null) {
      setScale(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
    }
  }
  
  public final void setZoomable(boolean paramBoolean)
  {
    mZoomEnabled = paramBoolean;
    update();
  }
  
  public final void update()
  {
    ImageView localImageView = getImageView();
    if (localImageView != null)
    {
      setImageViewScaleTypeMatrix(localImageView);
      updateBaseMatrix(localImageView.getDrawable());
      if (!mZoomEnabled) {
        resetMatrix();
      }
    }
  }
  
  private final class AnimatedZoomRunnable
    implements Runnable
  {
    private final float mFocalX;
    private final float mFocalY;
    private final long mStartTime;
    private final float mZoomEnd;
    private final float mZoomStart;
    
    public AnimatedZoomRunnable(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      mFocalX = paramFloat3;
      mFocalY = paramFloat4;
      mStartTime = System.currentTimeMillis();
      mZoomStart = paramFloat1;
      mZoomEnd = paramFloat2;
    }
    
    public final void run()
    {
      ImageView localImageView = getImageView();
      if (localImageView == null) {}
      float f1;
      do
      {
        return;
        f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - mStartTime) * 1.0F / ZOOM_DURATION);
        f1 = PhotoViewAttacher.sInterpolator.getInterpolation(f1);
        float f2 = (mZoomStart + (mZoomEnd - mZoomStart) * f1) / getScale();
        mSuppMatrix.postScale(f2, f2, mFocalX, mFocalY);
        checkAndDisplayMatrix();
      } while (f1 >= 1.0F);
      Compat.postOnAnimation(localImageView, this);
    }
  }
  
  private final class FlingRunnable
    implements Runnable
  {
    int mCurrentX;
    int mCurrentY;
    final ScrollerProxy mScroller;
    
    public FlingRunnable(Context paramContext)
    {
      mScroller = new IcsScroller(paramContext);
    }
    
    public final void run()
    {
      if (mScroller.isFinished()) {}
      ImageView localImageView;
      do
      {
        return;
        localImageView = getImageView();
      } while ((localImageView == null) || (!mScroller.computeScrollOffset()));
      int i = mScroller.getCurrX();
      int j = mScroller.getCurrY();
      if (PhotoViewAttacher.DEBUG) {
        Log.d("PhotoViewAttacher", "fling run(). CurrentX:" + mCurrentX + " CurrentY:" + mCurrentY + " NewX:" + i + " NewY:" + j);
      }
      mSuppMatrix.postTranslate(mCurrentX - i, mCurrentY - j);
      PhotoViewAttacher.this.setImageViewMatrix(getDrawMatrix());
      mCurrentX = i;
      mCurrentY = j;
      Compat.postOnAnimation(localImageView, this);
    }
  }
  
  public static abstract interface IGetImageBounds
  {
    public abstract Rect getImageBounds();
  }
  
  public static abstract interface OnMatrixChangedListener {}
  
  public static abstract interface OnPhotoTapListener {}
  
  public static abstract interface OnViewTapListener
  {
    public abstract void onViewTap$17e2ac03();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.PhotoViewAttacher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */