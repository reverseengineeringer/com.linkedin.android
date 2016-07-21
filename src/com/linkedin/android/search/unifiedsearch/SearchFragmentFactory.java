package com.linkedin.android.search.unifiedsearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import com.linkedin.android.search.SearchBundleBuilder;
import javax.inject.Inject;

public final class SearchFragmentFactory
  extends FragmentFactory<SearchBundleBuilder>
{
  public static Fragment newFragment(SearchBundleBuilder paramSearchBundleBuilder)
  {
    if (paramSearchBundleBuilder != null) {}
    for (paramSearchBundleBuilder = paramSearchBundleBuilder.build();; paramSearchBundleBuilder = new Bundle())
    {
      SearchFragment localSearchFragment = new SearchFragment();
      localSearchFragment.setArguments(paramSearchBundleBuilder);
      return localSearchFragment;
    }
  }
  
  public final Fragment provideFragment()
  {
    return new SearchFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.unifiedsearch.SearchFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */