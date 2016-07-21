package com.linkedin.android.growth.login.presenters;

import android.support.design.widget.TextInputLayout;
import com.linkedin.android.infra.network.I18NManager;
import javax.inject.Inject;

public final class InputValidationPresenter
{
  private static final int[] ERROR_MESSAGES = { 2131231430, 2131231435, 2131231433, 2131231444, 2131231446, 2131231431, 2131231436, 2131231434, 2131231428, 2131231437, 2131231445, 2131231429, 2131231432 };
  private final I18NManager i18NManager;
  
  @Inject
  public InputValidationPresenter(I18NManager paramI18NManager)
  {
    i18NManager = paramI18NManager;
  }
  
  public final void presentValidation(int paramInt, TextInputLayout paramTextInputLayout)
  {
    boolean bool = true;
    String str;
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      str = i18NManager.getString(ERROR_MESSAGES[paramInt]);
      if (paramInt == 13) {
        break;
      }
    }
    for (;;)
    {
      paramTextInputLayout.setErrorEnabled(bool);
      paramTextInputLayout.setError(str);
      return;
      str = null;
      break;
      str = i18NManager.getString(ERROR_MESSAGES[paramInt], new Object[] { Integer.valueOf(20) });
      break;
      str = i18NManager.getString(ERROR_MESSAGES[paramInt], new Object[] { Integer.valueOf(40) });
      break;
      str = i18NManager.getString(ERROR_MESSAGES[paramInt], new Object[] { Integer.valueOf(60) });
      break;
      str = i18NManager.getString(ERROR_MESSAGES[paramInt], new Object[] { Integer.valueOf(6) });
      break;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.InputValidationPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */