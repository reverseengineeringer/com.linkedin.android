package com.linkedin.android.identity.shared;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import com.linkedin.android.infra.shared.PhotoCropBundle;
import javax.inject.Inject;

public final class ProfilePhotoCropFragmentFactory<T extends PhotoCropBundle>
  extends FragmentFactory<T>
{
  public final Fragment provideFragment()
  {
    return new ProfilePhotoCropFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.shared.ProfilePhotoCropFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */