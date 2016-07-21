package com.linkedin.android.cropphotoview;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

public final class DefaultOnDoubleTapListener
  implements GestureDetector.OnDoubleTapListener
{
  private PhotoViewAttacher photoViewAttacher;
  
  public DefaultOnDoubleTapListener(PhotoViewAttacher paramPhotoViewAttacher)
  {
    photoViewAttacher = paramPhotoViewAttacher;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((photoViewAttacher == null) || (!photoViewAttacher.mZoomEnabled)) {
      return false;
    }
    try
    {
      float f1 = photoViewAttacher.getScale();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < photoViewAttacher.mMidScale)
      {
        photoViewAttacher.setScale(photoViewAttacher.mMidScale, f2, f3, true);
        return true;
      }
      if ((f1 >= photoViewAttacher.mMidScale) && (f1 < photoViewAttacher.mMaxScale))
      {
        photoViewAttacher.setScale(photoViewAttacher.mMaxScale, f2, f3, true);
        return true;
      }
      photoViewAttacher.setScale(photoViewAttacher.mMinScale, f2, f3, true);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return true;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (photoViewAttacher == null) {}
    do
    {
      return false;
      photoViewAttacher.getImageView();
      if (photoViewAttacher.mPhotoTapListener != null)
      {
        localObject = photoViewAttacher.getDisplayRect();
        if ((localObject != null) && (((RectF)localObject).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
        {
          float f = left;
          ((RectF)localObject).width();
          f = top;
          ((RectF)localObject).height();
          paramMotionEvent = photoViewAttacher.mPhotoTapListener;
          return true;
        }
      }
    } while (photoViewAttacher.mViewTapListener == null);
    Object localObject = photoViewAttacher.mViewTapListener;
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    ((PhotoViewAttacher.OnViewTapListener)localObject).onViewTap$17e2ac03();
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.DefaultOnDoubleTapListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */