package com.linkedin.android.cropphotoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

@TargetApi(8)
public final class FroyoGestureDetector
  extends EclairGestureDetector
{
  protected final ScaleGestureDetector mDetector = new ScaleGestureDetector(paramContext, new ScaleGestureDetector.OnScaleGestureListener()
  {
    public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      float f = paramAnonymousScaleGestureDetector.getScaleFactor();
      if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
        return false;
      }
      mListener.onScale(f, paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
  });
  
  public FroyoGestureDetector(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean isScaling()
  {
    return mDetector.isInProgress();
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    mDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.gestures.FroyoGestureDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */