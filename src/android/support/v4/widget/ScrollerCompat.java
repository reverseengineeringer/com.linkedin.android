package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

public final class ScrollerCompat
{
  ScrollerCompatImpl mImpl;
  Object mScroller;
  
  private ScrollerCompat(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      mImpl = new ScrollerCompatImplIcs();
    }
    for (;;)
    {
      mScroller = mImpl.createScroller(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        mImpl = new ScrollerCompatImplGingerbread();
      } else {
        mImpl = new ScrollerCompatImplBase();
      }
    }
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public final void abortAnimation()
  {
    mImpl.abortAnimation(mScroller);
  }
  
  public final boolean computeScrollOffset()
  {
    return mImpl.computeScrollOffset(mScroller);
  }
  
  public final void fling$69c647f5(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    mImpl.fling$f2fc891(mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public final float getCurrVelocity()
  {
    return mImpl.getCurrVelocity(mScroller);
  }
  
  public final int getCurrX()
  {
    return mImpl.getCurrX(mScroller);
  }
  
  public final int getCurrY()
  {
    return mImpl.getCurrY(mScroller);
  }
  
  public final int getFinalX()
  {
    return mImpl.getFinalX(mScroller);
  }
  
  public final int getFinalY()
  {
    return mImpl.getFinalY(mScroller);
  }
  
  public final boolean isFinished()
  {
    return mImpl.isFinished(mScroller);
  }
  
  public final boolean springBack$6046c8d9(int paramInt1, int paramInt2, int paramInt3)
  {
    return mImpl.springBack$2bf03f8b(mScroller, paramInt1, paramInt2, paramInt3);
  }
  
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mImpl.startScroll(mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  static abstract interface ScrollerCompatImpl
  {
    public abstract void abortAnimation(Object paramObject);
    
    public abstract boolean computeScrollOffset(Object paramObject);
    
    public abstract Object createScroller(Context paramContext, Interpolator paramInterpolator);
    
    public abstract void fling$26e48b1(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void fling$f2fc891(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
    
    public abstract float getCurrVelocity(Object paramObject);
    
    public abstract int getCurrX(Object paramObject);
    
    public abstract int getCurrY(Object paramObject);
    
    public abstract int getFinalX(Object paramObject);
    
    public abstract int getFinalY(Object paramObject);
    
    public abstract boolean isFinished(Object paramObject);
    
    public abstract boolean springBack$2bf03f8b(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void startScroll$364c3051(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
  }
  
  static final class ScrollerCompatImplBase
    implements ScrollerCompat.ScrollerCompatImpl
  {
    public final void abortAnimation(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public final boolean computeScrollOffset(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public final Object createScroller(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
    
    public final void fling$26e48b1(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, 0, paramInt3, 0, 0, 0, paramInt4);
    }
    
    public final void fling$f2fc891(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      ((Scroller)paramObject).fling(0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    
    public final float getCurrVelocity(Object paramObject)
    {
      return 0.0F;
    }
    
    public final int getCurrX(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public final int getCurrY(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public final int getFinalX(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public final int getFinalY(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
    
    public final boolean isFinished(Object paramObject)
    {
      return ((Scroller)paramObject).isFinished();
    }
    
    public final boolean springBack$2bf03f8b(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      return false;
    }
    
    public final void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public final void startScroll$364c3051(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, 0, paramInt3);
    }
  }
  
  static class ScrollerCompatImplGingerbread
    implements ScrollerCompat.ScrollerCompatImpl
  {
    public final void abortAnimation(Object paramObject)
    {
      ((OverScroller)paramObject).abortAnimation();
    }
    
    public final boolean computeScrollOffset(Object paramObject)
    {
      return ((OverScroller)paramObject).computeScrollOffset();
    }
    
    public final Object createScroller(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new OverScroller(paramContext, paramInterpolator);
      }
      return new OverScroller(paramContext);
    }
    
    public final void fling$26e48b1(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((OverScroller)paramObject).fling(paramInt1, paramInt2, 0, paramInt3, 0, 0, 0, paramInt4, 0, paramInt5);
    }
    
    public final void fling$f2fc891(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      ((OverScroller)paramObject).fling(0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    
    public float getCurrVelocity(Object paramObject)
    {
      return 0.0F;
    }
    
    public final int getCurrX(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrX();
    }
    
    public final int getCurrY(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrY();
    }
    
    public final int getFinalX(Object paramObject)
    {
      return ((OverScroller)paramObject).getFinalX();
    }
    
    public final int getFinalY(Object paramObject)
    {
      return ((OverScroller)paramObject).getFinalY();
    }
    
    public final boolean isFinished(Object paramObject)
    {
      return ((OverScroller)paramObject).isFinished();
    }
    
    public final boolean springBack$2bf03f8b(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      return ((OverScroller)paramObject).springBack(paramInt1, paramInt2, 0, 0, 0, paramInt3);
    }
    
    public final void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public final void startScroll$364c3051(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, 0, paramInt3);
    }
  }
  
  static final class ScrollerCompatImplIcs
    extends ScrollerCompat.ScrollerCompatImplGingerbread
  {
    public final float getCurrVelocity(Object paramObject)
    {
      return ((OverScroller)paramObject).getCurrVelocity();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */