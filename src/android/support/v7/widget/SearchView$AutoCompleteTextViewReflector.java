package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

final class SearchView$AutoCompleteTextViewReflector
{
  Method doAfterTextChanged;
  Method doBeforeTextChanged;
  private Method ensureImeVisible;
  Method showSoftInputUnchecked;
  
  SearchView$AutoCompleteTextViewReflector()
  {
    try
    {
      doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      doBeforeTextChanged.setAccessible(true);
      try
      {
        doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        doAfterTextChanged.setAccessible(true);
        try
        {
          ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          ensureImeVisible.setAccessible(true);
          try
          {
            showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
            showSoftInputUnchecked.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        for (;;) {}
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      for (;;) {}
    }
  }
  
  final void ensureImeVisible$3d4581ed(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (ensureImeVisible != null) {}
    try
    {
      ensureImeVisible.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SearchView.AutoCompleteTextViewReflector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */