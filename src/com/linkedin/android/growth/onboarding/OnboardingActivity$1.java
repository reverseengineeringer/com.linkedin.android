package com.linkedin.android.growth.onboarding;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;

final class OnboardingActivity$1
  extends DefaultModelListener<PageContent>
{
  OnboardingActivity$1(OnboardingActivity paramOnboardingActivity) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    super.onCacheError(paramDataManagerException);
    Log.e("Failed to load onboarding flow from cache", paramDataManagerException);
    this$0.exitFlow(null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */