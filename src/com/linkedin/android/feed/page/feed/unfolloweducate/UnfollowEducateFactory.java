package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class UnfollowEducateFactory
  extends FragmentFactory<UnfollowEducateBundle>
{
  protected final Fragment provideFragment()
  {
    return new UnfollowEducateFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */