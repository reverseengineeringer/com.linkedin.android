package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class CompoundButtonCompatDonut
{
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;
  
  static Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    if (!sButtonDrawableFieldFetched) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      sButtonDrawableField = localField;
      localField.setAccessible(true);
      sButtonDrawableFieldFetched = true;
      if (sButtonDrawableField == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramCompoundButton = (Drawable)sButtonDrawableField.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", paramCompoundButton);
          sButtonDrawableField = null;
        }
        localNoSuchFieldException = localNoSuchFieldException;
        Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompatDonut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */