package android.support.v4.view;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewCompat$EclairMr1ViewCompatImpl
  extends ViewCompat.BaseViewCompatImpl
{
  public final void setChildrenDrawingOrderEnabled$4d3af60(ViewGroup paramViewGroup)
  {
    if (ViewCompatEclairMr1.sChildrenDrawingOrderMethod == null) {}
    try
    {
      ViewCompatEclairMr1.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      ViewCompatEclairMr1.sChildrenDrawingOrderMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          ViewCompatEclairMr1.sChildrenDrawingOrderMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(true) });
          return;
        }
        catch (IllegalAccessException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (IllegalArgumentException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
          return;
        }
        catch (InvocationTargetException paramViewGroup)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", paramViewGroup);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.EclairMr1ViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */