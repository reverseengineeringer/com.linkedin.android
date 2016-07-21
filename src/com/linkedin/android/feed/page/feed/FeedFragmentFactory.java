package com.linkedin.android.feed.page.feed;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FeedFragmentFactory
  extends FragmentFactory<FeedBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new FeedFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */