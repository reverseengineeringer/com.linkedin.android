package com.linkedin.android.growth.onboarding.email_confirmation;

import android.support.design.widget.Snackbar;
import android.view.View;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.Result;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.ResultListener;

final class EmailConfirmationFragment$2
  implements EmailManagementController.ResultListener
{
  EmailConfirmationFragment$2(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void onResult(EmailManagementController.Result paramResult)
  {
    View localView = this$0.getView();
    if (localView != null)
    {
      if (success) {
        Snackbar.make(localView, 2131231542, 0).show();
      }
    }
    else {
      return;
    }
    Snackbar.make(localView, 2131231541, 0).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */