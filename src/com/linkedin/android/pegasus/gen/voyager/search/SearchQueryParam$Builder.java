package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchQueryParam$Builder
  implements RecordTemplateBuilder<SearchQueryParam>
{
  public boolean hasName = false;
  public boolean hasValue = false;
  public String name = null;
  public String value = null;
  
  public final SearchQueryParam build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchQueryParam.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchQueryParam(name, value, hasName, hasValue);
      if (!hasName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam", "name");
      }
    } while (hasValue);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam", "value");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchQueryParam.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */