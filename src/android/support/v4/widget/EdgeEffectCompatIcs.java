package android.support.v4.widget;

import android.widget.EdgeEffect;

final class EdgeEffectCompatIcs
{
  public static boolean onPull(Object paramObject, float paramFloat)
  {
    ((EdgeEffect)paramObject).onPull(paramFloat);
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompatIcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */