package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl
  extends ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl
{
  WeakHashMap<View, Integer> mLayerMap = null;
  
  public final void alpha(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    paramView.animate().alpha(paramFloat);
  }
  
  public final void cancel(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    paramView.animate().cancel();
  }
  
  public final long getDuration$66604b42(View paramView)
  {
    return paramView.animate().getDuration();
  }
  
  public final void setDuration$65a8a4c6(View paramView, long paramLong)
  {
    paramView.animate().setDuration(paramLong);
  }
  
  public final void setInterpolator$4b3df29b(View paramView, Interpolator paramInterpolator)
  {
    paramView.animate().setInterpolator(paramInterpolator);
  }
  
  public void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    paramView.setTag(2113929216, paramViewPropertyAnimatorListener);
    ViewPropertyAnimatorCompatICS.setListener(paramView, new MyVpaListener(paramViewPropertyAnimatorCompat));
  }
  
  public final void setStartDelay$65a8a4c6(View paramView, long paramLong)
  {
    paramView.animate().setStartDelay(paramLong);
  }
  
  public final void start(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    paramView.animate().start();
  }
  
  public final void translationX(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    paramView.animate().translationX(paramFloat);
  }
  
  public final void translationY(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
  {
    paramView.animate().translationY(paramFloat);
  }
  
  public void withLayer(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    ViewPropertyAnimatorCompat.access$402(paramViewPropertyAnimatorCompat, ViewCompat.getLayerType(paramView));
    ViewPropertyAnimatorCompatICS.setListener(paramView, new MyVpaListener(paramViewPropertyAnimatorCompat));
  }
  
  static final class MyVpaListener
    implements ViewPropertyAnimatorListener
  {
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;
    
    MyVpaListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
    {
      mVpa = paramViewPropertyAnimatorCompat;
    }
    
    public final void onAnimationCancel(View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
      if ((localObject instanceof ViewPropertyAnimatorListener)) {
        localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
      }
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationCancel(paramView);
      }
    }
    
    public final void onAnimationEnd(View paramView)
    {
      if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0)
      {
        ViewCompat.setLayerType(paramView, ViewPropertyAnimatorCompat.access$400(mVpa), null);
        ViewPropertyAnimatorCompat.access$402(mVpa, -1);
      }
      if ((Build.VERSION.SDK_INT >= 16) || (!mAnimEndCalled))
      {
        if (ViewPropertyAnimatorCompat.access$000(mVpa) != null)
        {
          localObject1 = ViewPropertyAnimatorCompat.access$000(mVpa);
          ViewPropertyAnimatorCompat.access$002$1d924e4e(mVpa);
          ((Runnable)localObject1).run();
        }
        Object localObject2 = paramView.getTag(2113929216);
        Object localObject1 = null;
        if ((localObject2 instanceof ViewPropertyAnimatorListener)) {
          localObject1 = (ViewPropertyAnimatorListener)localObject2;
        }
        if (localObject1 != null) {
          ((ViewPropertyAnimatorListener)localObject1).onAnimationEnd(paramView);
        }
        mAnimEndCalled = true;
      }
    }
    
    public final void onAnimationStart(View paramView)
    {
      mAnimEndCalled = false;
      if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0) {
        ViewCompat.setLayerType(paramView, 2, null);
      }
      if (ViewPropertyAnimatorCompat.access$100(mVpa) != null)
      {
        localObject1 = ViewPropertyAnimatorCompat.access$100(mVpa);
        ViewPropertyAnimatorCompat.access$102$1d924e4e(mVpa);
        ((Runnable)localObject1).run();
      }
      Object localObject2 = paramView.getTag(2113929216);
      Object localObject1 = null;
      if ((localObject2 instanceof ViewPropertyAnimatorListener)) {
        localObject1 = (ViewPropertyAnimatorListener)localObject2;
      }
      if (localObject1 != null) {
        ((ViewPropertyAnimatorListener)localObject1).onAnimationStart(paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */