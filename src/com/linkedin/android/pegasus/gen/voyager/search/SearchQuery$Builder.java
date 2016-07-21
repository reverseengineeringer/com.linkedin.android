package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class SearchQuery$Builder
  implements RecordTemplateBuilder<SearchQuery>
{
  private boolean hasParameters = false;
  private List<SearchQueryParam> parameters = null;
  
  public final SearchQuery build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
  }
  
  public final SearchQuery build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = SearchQuery.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    if (parameters != null)
    {
      paramFlavor = parameters.iterator();
      while (paramFlavor.hasNext()) {
        if ((SearchQueryParam)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.SearchQuery", "parameters");
        }
      }
    }
    return new SearchQuery(parameters, hasParameters);
  }
  
  public final Builder setParameters(List<SearchQueryParam> paramList)
  {
    if (paramList == null)
    {
      hasParameters = false;
      parameters = null;
      return this;
    }
    hasParameters = true;
    parameters = paramList;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchQuery.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */