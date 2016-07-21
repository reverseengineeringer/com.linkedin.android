package com.linkedin.android.growth.onboarding.photo;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.shared.PhotoCropFragmentFactory;
import javax.inject.Inject;

public final class OnboardingPhotoCropFragmentFactory
  extends PhotoCropFragmentFactory<OnboardingPhotoCropBundle>
{
  public final Fragment provideFragment()
  {
    return new OnboardingPhotoCropFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.photo.OnboardingPhotoCropFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */