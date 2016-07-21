package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class DrawableCompat$JellybeanMr1DrawableImpl
  extends DrawableCompat.HoneycombDrawableImpl
{
  public int getLayoutDirection(Drawable paramDrawable)
  {
    int i = DrawableCompatJellybeanMr1.getLayoutDirection(paramDrawable);
    if (i >= 0) {
      return i;
    }
    return 0;
  }
  
  public void setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    if (!DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched) {}
    try
    {
      Method localMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
      DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = localMethod;
      localMethod.setAccessible(true);
      DrawableCompatJellybeanMr1.sSetLayoutDirectionMethodFetched = true;
      if (DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
          DrawableCompatJellybeanMr1.sSetLayoutDirectionMethod = null;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.JellybeanMr1DrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */