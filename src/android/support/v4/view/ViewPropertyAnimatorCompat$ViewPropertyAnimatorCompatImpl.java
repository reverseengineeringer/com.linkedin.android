package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

public abstract interface ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl
{
  public abstract void alpha(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat);
  
  public abstract void cancel(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView);
  
  public abstract long getDuration$66604b42(View paramView);
  
  public abstract void setDuration$65a8a4c6(View paramView, long paramLong);
  
  public abstract void setInterpolator$4b3df29b(View paramView, Interpolator paramInterpolator);
  
  public abstract void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener);
  
  public abstract void setStartDelay$65a8a4c6(View paramView, long paramLong);
  
  public abstract void setUpdateListener$587f161e(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener);
  
  public abstract void start(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView);
  
  public abstract void translationX(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat);
  
  public abstract void translationY(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat);
  
  public abstract void withLayer(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView);
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */