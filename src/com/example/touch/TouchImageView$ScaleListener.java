package com.example.touch;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

final class TouchImageView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private TouchImageView$ScaleListener(TouchImageView paramTouchImageView) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    TouchImageView.access$17(this$0, paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), true);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    TouchImageView.access$9(this$0, TouchImageView.State.ZOOM);
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    super.onScaleEnd(paramScaleGestureDetector);
    TouchImageView.access$9(this$0, TouchImageView.State.NONE);
    int i = 0;
    float f = 0.0F;
    if (TouchImageView.access$4(this$0) > TouchImageView.access$6(this$0))
    {
      f = TouchImageView.access$6(this$0);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramScaleGestureDetector = new TouchImageView.DoubleTapZoom(this$0, f, TouchImageView.access$10(this$0) / 2, TouchImageView.access$13(this$0) / 2, true);
        TouchImageView.access$2(this$0, paramScaleGestureDetector);
      }
      return;
      if (TouchImageView.access$4(this$0) < TouchImageView.access$5(this$0))
      {
        f = TouchImageView.access$5(this$0);
        i = 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.example.touch.TouchImageView.ScaleListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */