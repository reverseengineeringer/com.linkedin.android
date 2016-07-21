package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

final class ScrollerCompat$ScrollerCompatImplBase
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

/* Location:
 * Qualified Name:     android.support.v4.widget.ScrollerCompat.ScrollerCompatImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */