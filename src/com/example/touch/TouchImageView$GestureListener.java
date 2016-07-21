package com.example.touch;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class TouchImageView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private TouchImageView$GestureListener(TouchImageView paramTouchImageView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (TouchImageView.access$3(this$0) == TouchImageView.State.NONE) {
      if (TouchImageView.access$4(this$0) != TouchImageView.access$5(this$0)) {
        break label75;
      }
    }
    label75:
    for (float f = TouchImageView.access$6(this$0);; f = TouchImageView.access$5(this$0))
    {
      paramMotionEvent = new TouchImageView.DoubleTapZoom(this$0, f, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
      TouchImageView.access$2(this$0, paramMotionEvent);
      bool = true;
      return bool;
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (TouchImageView.access$0(this$0) != null) {
      TouchImageView.access$0(this$0).cancelFling();
    }
    TouchImageView.access$1(this$0, new TouchImageView.Fling(this$0, (int)paramFloat1, (int)paramFloat2));
    TouchImageView.access$2(this$0, TouchImageView.access$0(this$0));
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    this$0.performLongClick();
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return this$0.performClick();
  }
}

/* Location:
 * Qualified Name:     com.example.touch.TouchImageView.GestureListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */