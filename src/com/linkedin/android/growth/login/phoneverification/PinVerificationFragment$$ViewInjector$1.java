package com.linkedin.android.growth.login.phoneverification;

import android.text.Editable;
import android.text.TextWatcher;

final class PinVerificationFragment$$ViewInjector$1
  implements TextWatcher
{
  PinVerificationFragment$$ViewInjector$1(PinVerificationFragment..ViewInjector paramViewInjector, PinVerificationFragment paramPinVerificationFragment) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    val$target.onPinEdited(paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment..ViewInjector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */