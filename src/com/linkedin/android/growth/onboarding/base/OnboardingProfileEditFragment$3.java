package com.linkedin.android.growth.onboarding.base;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.shared.Closure;

final class OnboardingProfileEditFragment$3
  extends DefaultModelListener<T>
{
  OnboardingProfileEditFragment$3(OnboardingProfileEditFragment paramOnboardingProfileEditFragment, Closure paramClosure) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    val$closure.apply(null);
  }
  
  public final void onCacheSuccess(T paramT)
  {
    val$closure.apply(paramT);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */