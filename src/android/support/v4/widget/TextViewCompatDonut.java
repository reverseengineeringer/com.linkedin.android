package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

final class TextViewCompatDonut
{
  static Field sMaxModeField;
  static boolean sMaxModeFieldFetched;
  static Field sMaximumField;
  static boolean sMaximumFieldFetched;
  
  static Field retrieveField(String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.e("TextViewCompatDonut", "Could not retrieve " + paramString + " field.");
    }
    return (Field)localObject;
  }
  
  static int retrieveIntFromField(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      Log.d("TextViewCompatDonut", "Could not retrieve value of " + paramField.getName() + " field.");
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.TextViewCompatDonut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */