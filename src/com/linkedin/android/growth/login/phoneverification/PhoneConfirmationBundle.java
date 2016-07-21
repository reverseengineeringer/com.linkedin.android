package com.linkedin.android.growth.login.phoneverification;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;

public final class PhoneConfirmationBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public PhoneConfirmationBundle(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo)
  {
    bundle.putString("registrationUri", paramString);
    bundle.putParcelable("checkpointResponseData", paramCheckpointChallengeResponseData);
    bundle.putParcelable("registrationResponseData", paramRegistrationResponseData);
    bundle.putParcelable("registrationInfo", paramRegistrationInfo);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */