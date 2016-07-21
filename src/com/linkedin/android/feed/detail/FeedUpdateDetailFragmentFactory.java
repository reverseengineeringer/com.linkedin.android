package com.linkedin.android.feed.detail;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FeedUpdateDetailFragmentFactory
  extends FragmentFactory<FeedUpdateDetailBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new FeedUpdateDetailFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */