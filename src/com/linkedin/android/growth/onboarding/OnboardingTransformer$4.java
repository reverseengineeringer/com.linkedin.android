package com.linkedin.android.growth.onboarding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class OnboardingTransformer$4
  extends LegoActionTrackingOnClickListener
{
  public OnboardingTransformer$4(String paramString1, ActionCategory paramActionCategory, LegoTrackingDataProvider paramLegoTrackingDataProvider, Tracker paramTracker, String paramString2, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, Context paramVarArgs)
  {
    super(paramString1, paramActionCategory, paramLegoTrackingDataProvider, paramTracker, paramString2, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.linkedin.android.jobs.jobseeker"));
    val$context.startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingTransformer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */