package com.linkedin.android.growth.login.phoneverification;

import android.view.View;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class PinVerificationFragment$2
  extends TrackingOnClickListener
{
  PinVerificationFragment$2(PinVerificationFragment paramPinVerificationFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0;
    auth.phoneJoin(registrationInfo.mPhoneNumber, registrationInfo.mCountryCode, registrationInfo.mPassword, registrationInfo.mFirstName, registrationInfo.mLastName, new PinVerificationFragment.5(paramView));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */