package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompat$EclairMotionEventVersionImpl
  extends MotionEventCompat.BaseMotionEventVersionImpl
{
  public final int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.findPointerIndex(paramInt);
  }
  
  public final int getPointerCount(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getPointerCount();
  }
  
  public final int getPointerId(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  public final float getX(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX(paramInt);
  }
  
  public final float getY(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.MotionEventCompat.EclairMotionEventVersionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */