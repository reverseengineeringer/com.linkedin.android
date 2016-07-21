package com.example.touch;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.animation.AccelerateDecelerateInterpolator;

final class TouchImageView$DoubleTapZoom
  implements Runnable
{
  private float bitmapX;
  private float bitmapY;
  private PointF endTouch;
  private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
  private long startTime;
  private PointF startTouch;
  private float startZoom;
  private boolean stretchImageToSuper;
  private float targetZoom;
  
  TouchImageView$DoubleTapZoom(TouchImageView paramTouchImageView, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    TouchImageView.access$9(paramTouchImageView, TouchImageView.State.ANIMATE_ZOOM);
    startTime = System.currentTimeMillis();
    startZoom = TouchImageView.access$4(paramTouchImageView);
    targetZoom = paramFloat1;
    stretchImageToSuper = paramBoolean;
    PointF localPointF = TouchImageView.access$18$67c052cb(paramTouchImageView, paramFloat2, paramFloat3);
    bitmapX = x;
    bitmapY = y;
    startTouch = TouchImageView.access$19(paramTouchImageView, bitmapX, bitmapY);
    endTouch = new PointF(TouchImageView.access$10(paramTouchImageView) / 2, TouchImageView.access$13(paramTouchImageView) / 2);
  }
  
  public final void run()
  {
    float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - startTime) / 500.0F);
    f1 = interpolator.getInterpolation(f1);
    float f2 = (startZoom + (targetZoom - startZoom) * f1) / TouchImageView.access$4(this$0);
    TouchImageView.access$17(this$0, f2, bitmapX, bitmapY, stretchImageToSuper);
    f2 = startTouch.x;
    float f3 = endTouch.x;
    float f4 = startTouch.x;
    float f5 = startTouch.y;
    float f6 = endTouch.y;
    float f7 = startTouch.y;
    PointF localPointF = TouchImageView.access$19(this$0, bitmapX, bitmapY);
    TouchImageView.access$15(this$0).postTranslate(f2 + (f3 - f4) * f1 - x, f5 + (f6 - f7) * f1 - y);
    TouchImageView.access$20(this$0);
    this$0.setImageMatrix(TouchImageView.access$15(this$0));
    if (f1 < 1.0F)
    {
      TouchImageView.access$2(this$0, this);
      return;
    }
    TouchImageView.access$9(this$0, TouchImageView.State.NONE);
  }
}

/* Location:
 * Qualified Name:     com.example.touch.TouchImageView.DoubleTapZoom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */