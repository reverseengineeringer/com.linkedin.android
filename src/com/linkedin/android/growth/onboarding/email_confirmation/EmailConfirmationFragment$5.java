package com.linkedin.android.growth.onboarding.email_confirmation;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class EmailConfirmationFragment$5
  extends LegoActionTrackingOnClickListener
{
  EmailConfirmationFragment$5(EmailConfirmationFragment paramEmailConfirmationFragment, String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramString1, paramActionCategory, paramLegoTrackingDataProvider, paramTracker, paramString2, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    Intent localIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.APP_EMAIL");
    try
    {
      this$0.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Snackbar.make(paramView, 2131231536, 0).show();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */