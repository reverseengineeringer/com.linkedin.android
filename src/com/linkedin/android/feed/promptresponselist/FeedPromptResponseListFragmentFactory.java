package com.linkedin.android.feed.promptresponselist;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FeedPromptResponseListFragmentFactory
  extends FragmentFactory<PromptResponseListBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new FeedPromptResponseListFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */