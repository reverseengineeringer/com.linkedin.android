package com.linkedin.android.entities.shared;

import android.text.Editable;
import android.text.TextWatcher;

final class AutofitHelper$AutofitTextWatcher
  implements TextWatcher
{
  private AutofitHelper$AutofitTextWatcher(AutofitHelper paramAutofitHelper) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this$0.autofit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.AutofitHelper.AutofitTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */