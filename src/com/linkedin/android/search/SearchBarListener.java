package com.linkedin.android.search;

import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;

public abstract interface SearchBarListener
{
  public abstract boolean onFacetAction(String paramString);
  
  public abstract boolean onQuerySubmit(String paramString1, String paramString2, SearchQuery paramSearchQuery, SearchType paramSearchType);
  
  public abstract boolean onQueryTextChange(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.SearchBarListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */