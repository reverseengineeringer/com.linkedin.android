package com.linkedin.android.infra.shared;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import javax.inject.Inject;

public final class KeyboardUtil
{
  public static InputMethodManager fetchKeyboard(Context paramContext)
  {
    return (InputMethodManager)paramContext.getSystemService("input_method");
  }
  
  public static boolean hideKeyboard(View paramView)
  {
    boolean bool2 = false;
    paramView.clearFocus();
    InputMethodManager localInputMethodManager = fetchKeyboard(paramView.getContext());
    boolean bool1 = bool2;
    if (localInputMethodManager != null)
    {
      bool1 = bool2;
      if (localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean showKeyboard(View paramView)
  {
    boolean bool2 = false;
    paramView.requestFocus();
    InputMethodManager localInputMethodManager = fetchKeyboard(paramView.getContext());
    boolean bool1 = bool2;
    if (localInputMethodManager != null)
    {
      bool1 = bool2;
      if (localInputMethodManager.showSoftInput(paramView, 0)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.KeyboardUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */