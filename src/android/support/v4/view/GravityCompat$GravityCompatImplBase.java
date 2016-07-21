package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

final class GravityCompat$GravityCompatImplBase
  implements GravityCompat.GravityCompatImpl
{
  public final void apply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2, int paramInt4)
  {
    Gravity.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2);
  }
  
  public final int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    return 0xFF7FFFFF & paramInt1;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.GravityCompat.GravityCompatImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */