package com.linkedin.android.growth.login.prereg;

import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

public abstract interface PreRegListener
{
  public abstract void onJoinSuccess(OnboardingBundleBuilder paramOnboardingBundleBuilder);
  
  public abstract void onLoginSuccess();
  
  public abstract void showJoinScreen();
  
  public abstract void showLoginScreen();
  
  public abstract void showPhoneNumberConfirmationScreen(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo);
  
  public abstract void showPinVerificationScreen(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationInfo paramRegistrationInfo);
  
  public abstract void showSSOScreenIfApplicable();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */