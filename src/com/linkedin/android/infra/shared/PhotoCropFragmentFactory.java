package com.linkedin.android.infra.shared;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public class PhotoCropFragmentFactory<T extends PhotoCropBundle>
  extends FragmentFactory<T>
{
  public Fragment provideFragment()
  {
    return new PhotoCropFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.PhotoCropFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */