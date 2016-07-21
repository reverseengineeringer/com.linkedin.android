package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ViewPropertyAnimatorCompat
{
  public static final ViewPropertyAnimatorCompatImpl IMPL = new BaseViewPropertyAnimatorCompatImpl();
  private Runnable mEndAction = null;
  private int mOldLayerType = -1;
  private Runnable mStartAction = null;
  public WeakReference<View> mView;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      IMPL = new LollipopViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new JBViewPropertyAnimatorCompatImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new ICSViewPropertyAnimatorCompatImpl();
      return;
    }
  }
  
  ViewPropertyAnimatorCompat(View paramView)
  {
    mView = new WeakReference(paramView);
  }
  
  public final ViewPropertyAnimatorCompat alpha(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.alpha(this, localView, paramFloat);
    }
    return this;
  }
  
  public final void cancel()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.cancel(this, localView);
    }
  }
  
  public final ViewPropertyAnimatorCompat setDuration(long paramLong)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.setDuration$65a8a4c6(localView, paramLong);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.setInterpolator$4b3df29b(localView, paramInterpolator);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.setListener(this, localView, paramViewPropertyAnimatorListener);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompat setStartDelay(long paramLong)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.setStartDelay$65a8a4c6(localView, paramLong);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.setUpdateListener$587f161e(localView, paramViewPropertyAnimatorUpdateListener);
    }
    return this;
  }
  
  public final void start()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.start(this, localView);
    }
  }
  
  public final ViewPropertyAnimatorCompat translationX(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.translationX(this, localView, paramFloat);
    }
    return this;
  }
  
  public final ViewPropertyAnimatorCompat translationY(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      IMPL.translationY(this, localView, paramFloat);
    }
    return this;
  }
  
  static class BaseViewPropertyAnimatorCompatImpl
    implements ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
  {
    WeakHashMap<View, Runnable> mStarterMap = null;
    
    private void postStartMessage(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      Runnable localRunnable = null;
      if (mStarterMap != null) {
        localRunnable = (Runnable)mStarterMap.get(paramView);
      }
      Object localObject = localRunnable;
      if (localRunnable == null)
      {
        localObject = new Starter(paramViewPropertyAnimatorCompat, paramView, (byte)0);
        if (mStarterMap == null) {
          mStarterMap = new WeakHashMap();
        }
        mStarterMap.put(paramView, localObject);
      }
      paramView.removeCallbacks((Runnable)localObject);
      paramView.post((Runnable)localObject);
    }
    
    public void alpha(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
    {
      postStartMessage(paramViewPropertyAnimatorCompat, paramView);
    }
    
    public void cancel(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      postStartMessage(paramViewPropertyAnimatorCompat, paramView);
    }
    
    public long getDuration$66604b42(View paramView)
    {
      return 0L;
    }
    
    public void setDuration$65a8a4c6(View paramView, long paramLong) {}
    
    public void setInterpolator$4b3df29b(View paramView, Interpolator paramInterpolator) {}
    
    public void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
    {
      paramView.setTag(2113929216, paramViewPropertyAnimatorListener);
    }
    
    public void setStartDelay$65a8a4c6(View paramView, long paramLong) {}
    
    public void setUpdateListener$587f161e(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener) {}
    
    public void start(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      if (mStarterMap != null)
      {
        Runnable localRunnable = (Runnable)mStarterMap.get(paramView);
        if (localRunnable != null) {
          paramView.removeCallbacks(localRunnable);
        }
      }
      startAnimation(paramViewPropertyAnimatorCompat, paramView);
    }
    
    final void startAnimation(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      Object localObject = paramView.getTag(2113929216);
      ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
      if ((localObject instanceof ViewPropertyAnimatorListener)) {
        localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
      }
      localObject = mStartAction;
      Runnable localRunnable = mEndAction;
      ViewPropertyAnimatorCompat.access$102$1d924e4e(paramViewPropertyAnimatorCompat);
      ViewPropertyAnimatorCompat.access$002$1d924e4e(paramViewPropertyAnimatorCompat);
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      if (localViewPropertyAnimatorListener != null)
      {
        localViewPropertyAnimatorListener.onAnimationStart(paramView);
        localViewPropertyAnimatorListener.onAnimationEnd(paramView);
      }
      if (localRunnable != null) {
        localRunnable.run();
      }
      if (mStarterMap != null) {
        mStarterMap.remove(paramView);
      }
    }
    
    public void translationX(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
    {
      postStartMessage(paramViewPropertyAnimatorCompat, paramView);
    }
    
    public void translationY(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, float paramFloat)
    {
      postStartMessage(paramViewPropertyAnimatorCompat, paramView);
    }
    
    public void withLayer(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView) {}
    
    final class Starter
      implements Runnable
    {
      WeakReference<View> mViewRef;
      ViewPropertyAnimatorCompat mVpa;
      
      private Starter(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
      {
        mViewRef = new WeakReference(paramView);
        mVpa = paramViewPropertyAnimatorCompat;
      }
      
      public final void run()
      {
        View localView = (View)mViewRef.get();
        if (localView != null) {
          startAnimation(mVpa, localView);
        }
      }
    }
  }
  
  static class ICSViewPropertyAnimatorCompatImpl
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
        if (mVpa.mOldLayerType >= 0)
        {
          ViewCompat.setLayerType(paramView, mVpa.mOldLayerType, null);
          ViewPropertyAnimatorCompat.access$402(mVpa, -1);
        }
        if ((Build.VERSION.SDK_INT >= 16) || (!mAnimEndCalled))
        {
          if (mVpa.mEndAction != null)
          {
            localObject1 = mVpa.mEndAction;
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
        if (mVpa.mOldLayerType >= 0) {
          ViewCompat.setLayerType(paramView, 2, null);
        }
        if (mVpa.mStartAction != null)
        {
          localObject1 = mVpa.mStartAction;
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
  
  static class JBMr2ViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl
  {}
  
  static class JBViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl
  {
    public final void setListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
    {
      if (paramViewPropertyAnimatorListener != null)
      {
        paramView.animate().setListener(new ViewPropertyAnimatorCompatJB.1(paramViewPropertyAnimatorListener, paramView));
        return;
      }
      paramView.animate().setListener(null);
    }
    
    public final void withLayer(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
    {
      paramView.animate().withLayer();
    }
  }
  
  static class KitKatViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl
  {
    public final void setUpdateListener$587f161e(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
    {
      ViewPropertyAnimatorCompatKK.1 local1 = null;
      if (paramViewPropertyAnimatorUpdateListener != null) {
        local1 = new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView);
      }
      paramView.animate().setUpdateListener(local1);
    }
  }
  
  static final class LollipopViewPropertyAnimatorCompatImpl
    extends ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl
  {}
  
  public static abstract interface ViewPropertyAnimatorCompatImpl
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
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */