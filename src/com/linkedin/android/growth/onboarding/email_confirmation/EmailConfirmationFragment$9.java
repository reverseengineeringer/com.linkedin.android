package com.linkedin.android.growth.onboarding.email_confirmation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

final class EmailConfirmationFragment$9
  implements TextWatcher
{
  EmailConfirmationFragment$9(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    Object localObject = this$0.clearButton;
    if (paramEditable.length() == 0) {}
    for (int i = 8;; i = 0)
    {
      ((ImageView)localObject).setVisibility(i);
      localObject = this$0.resendEmailText;
      if (paramEditable.length() > 0) {
        bool = true;
      }
      ((TextView)localObject).setEnabled(bool);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */