package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompat$GingerbreadPopupWindowImpl
  extends PopupWindowCompat.BasePopupWindowImpl
{
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (!PopupWindowCompatGingerbread.sSetWindowLayoutTypeMethodAttempted) {}
    try
    {
      Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      PopupWindowCompatGingerbread.sSetWindowLayoutTypeMethod = localMethod;
      localMethod.setAccessible(true);
      PopupWindowCompatGingerbread.sSetWindowLayoutTypeMethodAttempted = true;
      if (PopupWindowCompatGingerbread.sSetWindowLayoutTypeMethod != null) {}
      try
      {
        PopupWindowCompatGingerbread.sSetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramPopupWindow) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.GingerbreadPopupWindowImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */