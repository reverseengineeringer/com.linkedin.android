package com.linkedin.android.growth.onboarding.email_confirmation;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class EmailConfirmationBundle
  implements BundleBuilder
{
  public final Bundle bundle = new Bundle();
  
  public static String getWidgetTrackingToken(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("widgetTrackingToken");
    }
    return null;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final EmailConfirmationBundle setConfirmEmailError(boolean paramBoolean)
  {
    bundle.putBoolean("hasConfirmEmailError", paramBoolean);
    return this;
  }
  
  public final EmailConfirmationBundle setConfirmEmailUrl(String paramString)
  {
    bundle.putString("confirmEmailUrl", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */