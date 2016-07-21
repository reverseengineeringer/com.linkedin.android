package com.example.touch;

import android.graphics.Matrix;
import android.widget.Scroller;

final class TouchImageView$Fling
  implements Runnable
{
  int currX;
  int currY;
  Scroller scroller;
  
  TouchImageView$Fling(TouchImageView paramTouchImageView, int paramInt1, int paramInt2)
  {
    TouchImageView.access$9(paramTouchImageView, TouchImageView.State.FLING);
    scroller = new Scroller(TouchImageView.access$21(paramTouchImageView));
    TouchImageView.access$15(paramTouchImageView).getValues(TouchImageView.access$22(paramTouchImageView));
    int i = (int)TouchImageView.access$22(paramTouchImageView)[2];
    int j = (int)TouchImageView.access$22(paramTouchImageView)[5];
    int k;
    int m;
    int n;
    int i1;
    if (TouchImageView.access$11(paramTouchImageView) > TouchImageView.access$10(paramTouchImageView))
    {
      k = TouchImageView.access$10(paramTouchImageView) - (int)TouchImageView.access$11(paramTouchImageView);
      m = 0;
      if (TouchImageView.access$14(paramTouchImageView) <= TouchImageView.access$13(paramTouchImageView)) {
        break label161;
      }
      n = TouchImageView.access$13(paramTouchImageView) - (int)TouchImageView.access$14(paramTouchImageView);
      i1 = 0;
    }
    for (;;)
    {
      scroller.fling(i, j, paramInt1, paramInt2, k, m, n, i1);
      currX = i;
      currY = j;
      return;
      m = i;
      k = i;
      break;
      label161:
      i1 = j;
      n = j;
    }
  }
  
  public final void cancelFling()
  {
    if (scroller != null)
    {
      TouchImageView.access$9(this$0, TouchImageView.State.NONE);
      scroller.forceFinished(true);
    }
  }
  
  public final void run()
  {
    if (scroller.isFinished()) {
      scroller = null;
    }
    while (!scroller.computeScrollOffset()) {
      return;
    }
    int i = scroller.getCurrX();
    int j = scroller.getCurrY();
    int k = currX;
    int m = currY;
    currX = i;
    currY = j;
    TouchImageView.access$15(this$0).postTranslate(i - k, j - m);
    TouchImageView.access$16(this$0);
    this$0.setImageMatrix(TouchImageView.access$15(this$0));
    TouchImageView.access$2(this$0, this);
  }
}

/* Location:
 * Qualified Name:     com.example.touch.TouchImageView.Fling
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */