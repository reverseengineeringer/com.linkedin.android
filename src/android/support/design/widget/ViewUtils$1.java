package android.support.design.widget;

import android.os.Build.VERSION;

final class ViewUtils$1
  implements ValueAnimatorCompat.Creator
{
  public final ValueAnimatorCompat createAnimator()
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (Object localObject = new ValueAnimatorCompatImplHoneycombMr1();; localObject = new ValueAnimatorCompatImplEclairMr1()) {
      return new ValueAnimatorCompat((ValueAnimatorCompat.Impl)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.ViewUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */