package com.linkedin.android.growth.login.phoneverification;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.linkedin.android.growth.login.join.JoinManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class PinVerificationFragment$1
  extends TrackingOnClickListener
{
  PinVerificationFragment$1(PinVerificationFragment paramPinVerificationFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject = this$0;
    if (!TextUtils.isEmpty(pinInputText.getText().toString()))
    {
      paramView = pinInputText.getText().toString();
      pinVerifyButton.setEnabled(false);
      Auth localAuth = auth;
      String str = registrationUri;
      RegistrationInfo localRegistrationInfo = registrationInfo;
      CheckpointChallengeResponseData localCheckpointChallengeResponseData = checkpointResponseData;
      localObject = joinManager.createRegistrationListener(new PinVerificationFragment.4((PinVerificationFragment)localObject));
      liAuth.verifySMSPin(context, str, localRegistrationInfo, localCheckpointChallengeResponseData, paramView, (LiRegistrationResponse.RegistrationListener)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */