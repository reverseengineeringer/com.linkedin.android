package com.linkedin.android.growth.onboarding.email_confirmation;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class EmailConfirmationFragment$10
  implements View.OnClickListener
{
  EmailConfirmationFragment$10(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void onClick(View paramView)
  {
    this$0.emailInput.setText("");
    this$0.emailInput.setSelection(this$0.emailInput.getText().length());
    this$0.emailInput.requestFocus();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */