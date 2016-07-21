package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ViewCompatLollipop
{
  private static ThreadLocal<Rect> sThreadLocalRect;
  
  static Rect getEmptyTempRect()
  {
    if (sThreadLocalRect == null) {
      sThreadLocalRect = new ThreadLocal();
    }
    Rect localRect2 = (Rect)sThreadLocalRect.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      sThreadLocalRect.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompatLollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */