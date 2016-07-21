package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class PopupWindowCompatApi21
{
  private static Field sOverlapAnchorField;
  
  static
  {
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      sOverlapAnchorField = localField;
      localField.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
    }
  }
  
  static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (sOverlapAnchorField != null) {}
    try
    {
      sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (IllegalAccessException paramPopupWindow)
    {
      Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.PopupWindowCompatApi21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */