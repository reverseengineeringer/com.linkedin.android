package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DrawableUtils
{
  private static final String LOG_TAG = "DrawableUtils";
  private static Field sDrawableContainerStateField;
  private static boolean sDrawableContainerStateFieldFetched;
  private static Method sSetConstantStateMethod;
  private static boolean sSetConstantStateMethodFetched;
  
  static boolean setContainerConstantState(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return setContainerConstantStateV9(paramDrawableContainer, paramConstantState);
    }
    return setContainerConstantStateV7(paramDrawableContainer, paramConstantState);
  }
  
  private static boolean setContainerConstantStateV7(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!sDrawableContainerStateFieldFetched) {}
    try
    {
      Field localField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
      sDrawableContainerStateField = localField;
      localField.setAccessible(true);
      sDrawableContainerStateFieldFetched = true;
      if (sDrawableContainerStateField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          sDrawableContainerStateField.set(paramDrawableContainer, paramConstantState);
          return true;
        }
        catch (Exception paramDrawableContainer)
        {
          Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
      }
    }
    return false;
  }
  
  private static boolean setContainerConstantStateV9(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!sSetConstantStateMethodFetched) {}
    try
    {
      Method localMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      sSetConstantStateMethod = localMethod;
      localMethod.setAccessible(true);
      sSetConstantStateMethodFetched = true;
      if (sSetConstantStateMethod == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          sSetConstantStateMethod.invoke(paramDrawableContainer, new Object[] { paramConstantState });
          return true;
        }
        catch (Exception paramDrawableContainer)
        {
          Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.DrawableUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */