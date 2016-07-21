package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class ViewCompatBase
{
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  
  static int getMinimumHeight(View paramView)
  {
    if (!sMinHeightFieldFetched) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinHeight");
      sMinHeightField = localField;
      localField.setAccessible(true);
      sMinHeightFieldFetched = true;
      if (sMinHeightField != null) {
        try
        {
          int i = ((Integer)sMinHeightField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  static int getMinimumWidth(View paramView)
  {
    if (!sMinWidthFieldFetched) {}
    try
    {
      Field localField = View.class.getDeclaredField("mMinWidth");
      sMinWidthField = localField;
      localField.setAccessible(true);
      sMinWidthFieldFetched = true;
      if (sMinWidthField != null) {
        try
        {
          int i = ((Integer)sMinWidthField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
      }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompatBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */