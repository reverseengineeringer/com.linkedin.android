package com.linkedin.android.cropphotoview.gestures;

import android.view.MotionEvent;

public abstract interface GestureDetector
{
  public abstract boolean isScaling();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setOnGestureListener(OnGestureListener paramOnGestureListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.gestures.GestureDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */