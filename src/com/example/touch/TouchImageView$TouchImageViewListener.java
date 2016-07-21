package com.example.touch;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;

final class TouchImageView$TouchImageViewListener
  implements View.OnTouchListener
{
  private PointF last = new PointF();
  
  private TouchImageView$TouchImageViewListener(TouchImageView paramTouchImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    TouchImageView.access$7(this$0).onTouchEvent(paramMotionEvent);
    TouchImageView.access$8(this$0).onTouchEvent(paramMotionEvent);
    paramView = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((TouchImageView.access$3(this$0) == TouchImageView.State.NONE) || (TouchImageView.access$3(this$0) == TouchImageView.State.DRAG) || (TouchImageView.access$3(this$0) == TouchImageView.State.FLING)) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      this$0.setImageMatrix(TouchImageView.access$15(this$0));
      return true;
      last.set(paramView);
      if (TouchImageView.access$0(this$0) != null) {
        TouchImageView.access$0(this$0).cancelFling();
      }
      TouchImageView.access$9(this$0, TouchImageView.State.DRAG);
      continue;
      if (TouchImageView.access$3(this$0) == TouchImageView.State.DRAG)
      {
        float f3 = x;
        float f4 = last.x;
        float f1 = y;
        float f2 = last.y;
        f3 = TouchImageView.access$12$62fb2f70(f3 - f4, TouchImageView.access$10(this$0), TouchImageView.access$11(this$0));
        f1 = TouchImageView.access$12$62fb2f70(f1 - f2, TouchImageView.access$13(this$0), TouchImageView.access$14(this$0));
        TouchImageView.access$15(this$0).postTranslate(f3, f1);
        TouchImageView.access$16(this$0);
        last.set(x, y);
        continue;
        TouchImageView.access$9(this$0, TouchImageView.State.NONE);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.example.touch.TouchImageView.TouchImageViewListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */