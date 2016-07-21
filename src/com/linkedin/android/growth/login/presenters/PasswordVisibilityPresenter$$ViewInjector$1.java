package com.linkedin.android.growth.login.presenters;

import android.text.Editable;
import android.text.TextWatcher;

final class PasswordVisibilityPresenter$$ViewInjector$1
  implements TextWatcher
{
  PasswordVisibilityPresenter$$ViewInjector$1(PasswordVisibilityPresenter..ViewInjector paramViewInjector, PasswordVisibilityPresenter paramPasswordVisibilityPresenter) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    val$target.onPasswordEdited(paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter..ViewInjector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */