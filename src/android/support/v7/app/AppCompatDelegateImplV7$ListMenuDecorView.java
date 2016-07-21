package android.support.v7.app;

import android.content.Context;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

final class AppCompatDelegateImplV7$ListMenuDecorView
  extends ContentFrameLayout
{
  public AppCompatDelegateImplV7$ListMenuDecorView(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppCompatDelegateImplV7.access$1400$3f79a154(this$0);
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(getContext(), paramInt, false));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.ListMenuDecorView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */