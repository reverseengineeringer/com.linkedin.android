package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class PopupWindowCompat
{
  static final PopupWindowImpl IMPL = new BasePopupWindowImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new Api23PopupWindowImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new Api21PopupWindowImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatPopupWindowImpl();
      return;
    }
    if (i >= 9)
    {
      IMPL = new GingerbreadPopupWindowImpl();
      return;
    }
  }
  
  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    IMPL.setOverlapAnchor(paramPopupWindow, paramBoolean);
  }
  
  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    IMPL.setWindowLayoutType(paramPopupWindow, paramInt);
  }
  
  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.showAsDropDown(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  static class Api21PopupWindowImpl
    extends PopupWindowCompat.KitKatPopupWindowImpl
  {
    public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      PopupWindowCompatApi21.setOverlapAnchor(paramPopupWindow, paramBoolean);
    }
  }
  
  static final class Api23PopupWindowImpl
    extends PopupWindowCompat.Api21PopupWindowImpl
  {
    public final void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    
    public final void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
  }
  
  static class BasePopupWindowImpl
    implements PopupWindowCompat.PopupWindowImpl
  {
    public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {}
    
    public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt) {}
    
    public void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
    }
  }
  
  static class GingerbreadPopupWindowImpl
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
  
  static class KitKatPopupWindowImpl
    extends PopupWindowCompat.GingerbreadPopupWindowImpl
  {
    public final void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static abstract interface PopupWindowImpl
  {
    public abstract void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean);
    
    public abstract void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt);
    
    public abstract void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */