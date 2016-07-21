package com.linkedin.android.cropphotoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
public class EclairGestureDetector
  extends CupcakeGestureDetector
{
  private int mActivePointerId = -1;
  private int mActivePointerIndex;
  
  public EclairGestureDetector(Context paramContext)
  {
    super(paramContext);
  }
  
  final float getActiveX(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getX(mActivePointerIndex);
      return f;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramMotionEvent.getX();
  }
  
  final float getActiveY(MotionEvent paramMotionEvent)
  {
    try
    {
      float f = paramMotionEvent.getY(mActivePointerIndex);
      return f;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramMotionEvent.getY();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      for (;;)
      {
        i = j;
        if (mActivePointerId != -1) {
          i = mActivePointerId;
        }
        mActivePointerIndex = paramMotionEvent.findPointerIndex(i);
        return super.onTouchEvent(paramMotionEvent);
        mActivePointerId = paramMotionEvent.getPointerId(0);
        continue;
        mActivePointerId = -1;
      }
      i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    } while (paramMotionEvent.getPointerId(i) != mActivePointerId);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      mActivePointerId = paramMotionEvent.getPointerId(i);
      mLastTouchX = paramMotionEvent.getX(i);
      mLastTouchY = paramMotionEvent.getY(i);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.gestures.EclairGestureDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */