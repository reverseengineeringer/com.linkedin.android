package com.linkedin.android.growth.onboarding.email_confirmation;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

final class EmailConfirmationFragment$8
  implements View.OnFocusChangeListener
{
  EmailConfirmationFragment$8(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this$0.clearButton.setVisibility(0);
      this$0.editButton.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */