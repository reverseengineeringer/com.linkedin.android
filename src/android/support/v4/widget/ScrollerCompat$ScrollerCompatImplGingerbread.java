package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class ScrollerCompat$ScrollerCompatImplGingerbread
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

/* Location:
 * Qualified Name:     android.support.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */