package com.linkedin.android.growth.newtovoyager.transactional;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class NewToVoyagerIntroDialogFragmentFactory
  extends FragmentFactory<NewToVoyagerIntroDialogFragmentBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new NewToVoyagerIntroDialogFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */