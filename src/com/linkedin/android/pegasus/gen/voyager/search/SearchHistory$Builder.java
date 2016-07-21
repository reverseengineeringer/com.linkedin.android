package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHistory$Builder
  implements RecordTemplateBuilder<SearchHistory>
{
  private String displayText = null;
  private boolean hasDisplayText = false;
  private boolean hasHistoryInfo = false;
  private boolean hasSearchType = false;
  public boolean hasSubtext = false;
  private SearchHistory.HistoryInfo historyInfo = null;
  private SearchType searchType = null;
  public String subtext = null;
  
  public final SearchHistory build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchHistory.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchHistory(displayText, subtext, searchType, historyInfo, hasDisplayText, hasSubtext, hasSearchType, hasHistoryInfo);
      if (!hasDisplayText) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistory", "displayText");
      }
      if (!hasSearchType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistory", "searchType");
      }
    } while (hasHistoryInfo);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistory", "historyInfo");
  }
  
  public final Builder setDisplayText(String paramString)
  {
    if (paramString == null)
    {
      hasDisplayText = false;
      displayText = null;
      return this;
    }
    hasDisplayText = true;
    displayText = paramString;
    return this;
  }
  
  public final Builder setHistoryInfo(SearchHistory.HistoryInfo paramHistoryInfo)
  {
    if (paramHistoryInfo == null)
    {
      hasHistoryInfo = false;
      historyInfo = null;
      return this;
    }
    hasHistoryInfo = true;
    historyInfo = paramHistoryInfo;
    return this;
  }
  
  public final Builder setSearchType(SearchType paramSearchType)
  {
    if (paramSearchType == null)
    {
      hasSearchType = false;
      searchType = null;
      return this;
    }
    hasSearchType = true;
    searchType = paramSearchType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistory.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */