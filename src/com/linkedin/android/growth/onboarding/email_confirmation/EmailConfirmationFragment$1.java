package com.linkedin.android.growth.onboarding.email_confirmation;

import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.litrackinglib.metric.Tracker;

final class EmailConfirmationFragment$1
  implements Runnable
{
  EmailConfirmationFragment$1(EmailConfirmationFragment paramEmailConfirmationFragment) {}
  
  public final void run()
  {
    EmailConfirmationFragment localEmailConfirmationFragment = this$0;
    if ((localEmailConfirmationFragment.isAdded()) && (localEmailConfirmationFragment.isResumed())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        EmailConfirmationFragment.access$000(this$0).fetchEmailConfirmationTask(this$0.busSubscriberId, Tracker.createPageInstanceHeader(this$0.getPageInstance()));
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */