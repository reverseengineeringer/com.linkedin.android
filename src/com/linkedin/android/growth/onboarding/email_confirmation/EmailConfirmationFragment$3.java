package com.linkedin.android.growth.onboarding.email_confirmation;

import android.support.design.widget.Snackbar;
import android.view.View;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.Result;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.ResultListener;
import com.linkedin.android.growth.lego.LegoWidget;

final class EmailConfirmationFragment$3
  implements EmailManagementController.ResultListener
{
  EmailConfirmationFragment$3(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void onResult(EmailManagementController.Result paramResult)
  {
    View localView = this$0.getView();
    if (localView != null)
    {
      if (success) {
        EmailConfirmationFragment.access$100(this$0, paramResult, localView);
      }
    }
    else {
      return;
    }
    Snackbar.make(localView, 2131231541, 0).show();
    EmailConfirmationFragment.access$200(this$0).finishCurrentFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */