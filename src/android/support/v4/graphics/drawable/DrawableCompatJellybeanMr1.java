package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

final class DrawableCompatJellybeanMr1
{
  private static Method sGetLayoutDirectionMethod;
  private static boolean sGetLayoutDirectionMethodFetched;
  static Method sSetLayoutDirectionMethod;
  static boolean sSetLayoutDirectionMethodFetched;
  
  public static int getLayoutDirection(Drawable paramDrawable)
  {
    if (!sGetLayoutDirectionMethodFetched) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      sGetLayoutDirectionMethod = localMethod;
      localMethod.setAccessible(true);
      sGetLayoutDirectionMethodFetched = true;
      if (sGetLayoutDirectionMethod == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          int i = ((Integer)sGetLayoutDirectionMethod.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", paramDrawable);
          sGetLayoutDirectionMethod = null;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
      }
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompatJellybeanMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */