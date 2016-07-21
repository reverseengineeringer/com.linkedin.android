package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchFilter$Builder
  implements RecordTemplateBuilder<SearchFilter>
{
  public String filterName = null;
  public int filterPosition = 0;
  public SearchFilterType filterType = null;
  public String filterValue = null;
  public boolean hasFilterName = false;
  public boolean hasFilterPosition = false;
  public boolean hasFilterType = false;
  public boolean hasFilterValue = false;
  public boolean hasIsSelected = false;
  public boolean isSelected = false;
  
  public final SearchFilter build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchFilter.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchFilter(filterType, filterName, filterValue, filterPosition, isSelected, hasFilterType, hasFilterName, hasFilterValue, hasFilterPosition, hasIsSelected);
      if (!hasFilterType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterType");
      }
      if (!hasFilterName) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterName");
      }
      if (!hasFilterValue) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterValue");
      }
      if (!hasFilterPosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterPosition");
      }
    } while (hasIsSelected);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "isSelected");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFilter.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */