package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class EdgeEffectCompat$EdgeEffectIcsImpl
  implements EdgeEffectCompat.EdgeEffectImpl
{
  public final boolean draw(Object paramObject, Canvas paramCanvas)
  {
    return ((EdgeEffect)paramObject).draw(paramCanvas);
  }
  
  public final void finish(Object paramObject)
  {
    ((EdgeEffect)paramObject).finish();
  }
  
  public final boolean isFinished(Object paramObject)
  {
    return ((EdgeEffect)paramObject).isFinished();
  }
  
  public final Object newEdgeEffect(Context paramContext)
  {
    return new EdgeEffect(paramContext);
  }
  
  public final boolean onAbsorb(Object paramObject, int paramInt)
  {
    ((EdgeEffect)paramObject).onAbsorb(paramInt);
    return true;
  }
  
  public final boolean onPull(Object paramObject, float paramFloat)
  {
    return EdgeEffectCompatIcs.onPull(paramObject, paramFloat);
  }
  
  public boolean onPull(Object paramObject, float paramFloat1, float paramFloat2)
  {
    return EdgeEffectCompatIcs.onPull(paramObject, paramFloat1);
  }
  
  public final boolean onRelease(Object paramObject)
  {
    paramObject = (EdgeEffect)paramObject;
    ((EdgeEffect)paramObject).onRelease();
    return ((EdgeEffect)paramObject).isFinished();
  }
  
  public final void setSize(Object paramObject, int paramInt1, int paramInt2)
  {
    ((EdgeEffect)paramObject).setSize(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat.EdgeEffectIcsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */