package com.linkedin.android.growth.onboarding.photo;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class PhotoFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new PhotoFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.photo.PhotoFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */