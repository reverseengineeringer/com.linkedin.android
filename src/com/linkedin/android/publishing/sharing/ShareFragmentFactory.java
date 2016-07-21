package com.linkedin.android.publishing.sharing;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class ShareFragmentFactory
  extends FragmentFactory<ShareBundle>
{
  protected final Fragment provideFragment()
  {
    return new ShareFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */