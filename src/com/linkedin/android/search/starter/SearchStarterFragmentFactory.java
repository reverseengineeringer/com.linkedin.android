package com.linkedin.android.search.starter;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import com.linkedin.android.search.SearchBundleBuilder;
import javax.inject.Inject;

public final class SearchStarterFragmentFactory
  extends FragmentFactory<SearchBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new SearchStarterFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.starter.SearchStarterFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */