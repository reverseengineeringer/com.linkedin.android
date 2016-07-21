package com.linkedin.android.feed.aggregate;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class AggregateFragmentFactory
  extends FragmentFactory<AggregateBundle>
{
  protected final Fragment provideFragment()
  {
    return new AggregateFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */