package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class DrawableUtils
{
  public static final Rect INSETS_NONE = new Rect();
  private static Class<?> sInsetsClazz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sInsetsClazz = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static boolean canSafelyMutateDrawable(Drawable paramDrawable)
  {
    for (;;)
    {
      if ((paramDrawable instanceof LayerDrawable)) {
        if (Build.VERSION.SDK_INT < 16) {}
      }
      do
      {
        for (;;)
        {
          return true;
          return false;
          if ((paramDrawable instanceof InsetDrawable))
          {
            if (Build.VERSION.SDK_INT < 14) {
              return false;
            }
          }
          else if ((paramDrawable instanceof StateListDrawable))
          {
            if (Build.VERSION.SDK_INT < 8) {
              return false;
            }
          }
          else if ((paramDrawable instanceof GradientDrawable))
          {
            if (Build.VERSION.SDK_INT < 14) {
              return false;
            }
          }
          else
          {
            if (!(paramDrawable instanceof DrawableContainer)) {
              break;
            }
            paramDrawable = paramDrawable.getConstantState();
            if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
            {
              paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
              int j = paramDrawable.length;
              int i = 0;
              while (i < j)
              {
                if (!canSafelyMutateDrawable(paramDrawable[i])) {
                  return false;
                }
                i += 1;
              }
            }
          }
        }
        if ((paramDrawable instanceof android.support.v4.graphics.drawable.DrawableWrapper))
        {
          paramDrawable = ((android.support.v4.graphics.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable();
          break;
        }
        if ((paramDrawable instanceof android.support.v7.graphics.drawable.DrawableWrapper))
        {
          paramDrawable = ((android.support.v7.graphics.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable();
          break;
        }
      } while (!(paramDrawable instanceof ScaleDrawable));
      paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
    }
  }
  
  static void fixDrawable(Drawable paramDrawable)
  {
    int[] arrayOfInt;
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        break label52;
      }
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      label52:
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    }
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    if (sInsetsClazz != null) {}
    for (;;)
    {
      Object localObject;
      Rect localRect;
      int j;
      int i;
      try
      {
        paramDrawable = DrawableCompat.unwrap(paramDrawable);
        localObject = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (localObject == null) {
          break label215;
        }
        localRect = new Rect();
        Field[] arrayOfField = sInsetsClazz.getFields();
        int k = arrayOfField.length;
        j = 0;
        paramDrawable = localRect;
        if (j >= k) {
          break label219;
        }
        paramDrawable = arrayOfField[j];
        str = paramDrawable.getName();
        i = -1;
        switch (str.hashCode())
        {
        case 3317767: 
          if (!str.equals("left")) {
            break label263;
          }
          i = 0;
        }
      }
      catch (Exception paramDrawable)
      {
        String str;
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
      if (str.equals("top"))
      {
        i = 1;
        break label263;
        if (str.equals("right"))
        {
          i = 2;
          break label263;
          if (str.equals("bottom"))
          {
            i = 3;
            break label263;
            left = paramDrawable.getInt(localObject);
            break label296;
            label215:
            paramDrawable = INSETS_NONE;
            label219:
            return paramDrawable;
            top = paramDrawable.getInt(localObject);
            break label296;
            right = paramDrawable.getInt(localObject);
            break label296;
            bottom = paramDrawable.getInt(localObject);
            break label296;
          }
        }
      }
      label263:
      switch (i)
      {
      }
      label296:
      j += 1;
    }
  }
  
  static PorterDuff.Mode parseTintMode$49602678(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    } while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.valueOf("ADD");
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DrawableUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */