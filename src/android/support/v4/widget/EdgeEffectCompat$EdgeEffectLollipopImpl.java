package android.support.v4.widget;

import android.widget.EdgeEffect;

final class EdgeEffectCompat$EdgeEffectLollipopImpl
  extends EdgeEffectCompat.EdgeEffectIcsImpl
{
  public final boolean onPull(Object paramObject, float paramFloat1, float paramFloat2)
  {
    ((EdgeEffect)paramObject).onPull(paramFloat1, paramFloat2);
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat.EdgeEffectLollipopImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */