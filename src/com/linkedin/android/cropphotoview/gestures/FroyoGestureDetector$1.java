package com.linkedin.android.cropphotoview.gestures;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

final class FroyoGestureDetector$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  FroyoGestureDetector$1(FroyoGestureDetector paramFroyoGestureDetector) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
      return false;
    }
    this$0.mListener.onScale(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.gestures.FroyoGestureDetector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */