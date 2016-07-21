package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class SearchHistory$HistoryInfo$Builder
{
  public EntityAwareSearchQuery entityAwareSearchQueryValue = null;
  public boolean hasEntityAwareSearchQueryValue = false;
  private boolean hasSearchHistoryCompanyValue = false;
  private boolean hasSearchHistoryGroupValue = false;
  public boolean hasSearchHistoryJobValue = false;
  private boolean hasSearchHistoryProfileValue = false;
  private boolean hasSearchHistorySchoolValue = false;
  private boolean hasSearchHistoryTrendingResultContainerValue = false;
  public boolean hasSearchQueryValue = false;
  private SearchHistoryCompany searchHistoryCompanyValue = null;
  private SearchHistoryGroup searchHistoryGroupValue = null;
  public SearchHistoryJob searchHistoryJobValue = null;
  private SearchHistoryProfile searchHistoryProfileValue = null;
  private SearchHistorySchool searchHistorySchoolValue = null;
  private SearchHistoryTrendingResultContainer searchHistoryTrendingResultContainerValue = null;
  public SearchQuery searchQueryValue = null;
  
  public final SearchHistory.HistoryInfo build()
    throws BuilderException
  {
    int j = 0;
    if (hasSearchHistoryProfileValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasSearchHistoryJobValue) {
      i = j + 1;
    }
    j = i;
    if (hasSearchHistoryCompanyValue) {
      j = i + 1;
    }
    i = j;
    if (hasSearchHistoryGroupValue) {
      i = j + 1;
    }
    j = i;
    if (hasSearchHistorySchoolValue) {
      j = i + 1;
    }
    i = j;
    if (hasSearchQueryValue) {
      i = j + 1;
    }
    j = i;
    if (hasEntityAwareSearchQueryValue) {
      j = i + 1;
    }
    i = j;
    if (hasSearchHistoryTrendingResultContainerValue) {
      i = j + 1;
    }
    if (i > 1) {
      throw new UnionMemberCountException("HistoryInfo", i);
    }
    return new SearchHistory.HistoryInfo(searchHistoryProfileValue, searchHistoryJobValue, searchHistoryCompanyValue, searchHistoryGroupValue, searchHistorySchoolValue, searchQueryValue, entityAwareSearchQueryValue, searchHistoryTrendingResultContainerValue, hasSearchHistoryProfileValue, hasSearchHistoryJobValue, hasSearchHistoryCompanyValue, hasSearchHistoryGroupValue, hasSearchHistorySchoolValue, hasSearchQueryValue, hasEntityAwareSearchQueryValue, hasSearchHistoryTrendingResultContainerValue);
  }
  
  public final Builder setSearchHistoryCompanyValue(SearchHistoryCompany paramSearchHistoryCompany)
  {
    if (paramSearchHistoryCompany == null)
    {
      hasSearchHistoryCompanyValue = false;
      searchHistoryCompanyValue = null;
      return this;
    }
    hasSearchHistoryCompanyValue = true;
    searchHistoryCompanyValue = paramSearchHistoryCompany;
    return this;
  }
  
  public final Builder setSearchHistoryGroupValue(SearchHistoryGroup paramSearchHistoryGroup)
  {
    if (paramSearchHistoryGroup == null)
    {
      hasSearchHistoryGroupValue = false;
      searchHistoryGroupValue = null;
      return this;
    }
    hasSearchHistoryGroupValue = true;
    searchHistoryGroupValue = paramSearchHistoryGroup;
    return this;
  }
  
  public final Builder setSearchHistoryProfileValue(SearchHistoryProfile paramSearchHistoryProfile)
  {
    if (paramSearchHistoryProfile == null)
    {
      hasSearchHistoryProfileValue = false;
      searchHistoryProfileValue = null;
      return this;
    }
    hasSearchHistoryProfileValue = true;
    searchHistoryProfileValue = paramSearchHistoryProfile;
    return this;
  }
  
  public final Builder setSearchHistorySchoolValue(SearchHistorySchool paramSearchHistorySchool)
  {
    if (paramSearchHistorySchool == null)
    {
      hasSearchHistorySchoolValue = false;
      searchHistorySchoolValue = null;
      return this;
    }
    hasSearchHistorySchoolValue = true;
    searchHistorySchoolValue = paramSearchHistorySchool;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.HistoryInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */