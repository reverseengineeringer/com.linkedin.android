package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class SearchResultComponent$Builder
  implements RecordTemplateBuilder<SearchResultComponent>
{
  public boolean hasLayoutType = false;
  private boolean hasPosition = false;
  public boolean hasResultComponentType = false;
  public boolean hasResultVerticalType = false;
  public boolean hasResults = false;
  public SearchResultComponentLayoutType layoutType = null;
  private int position = 0;
  public SearchResultComponentType resultComponentType = null;
  public SearchVertical resultVerticalType = null;
  public List<SearchResultHit> results = null;
  
  public final SearchResultComponent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchResultComponent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (results != null)
    {
      paramFlavor = results.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((SearchResultHit)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
            if (!hasResultComponentType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultComponentType");
            }
            if (!hasPosition) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "position");
            }
            if (!hasLayoutType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "layoutType");
            }
            if (!hasResultVerticalType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultVerticalType");
            }
            if (hasResults) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
          }
        }
      }
    }
    return new SearchResultComponent(resultComponentType, position, layoutType, resultVerticalType, results, hasResultComponentType, hasPosition, hasLayoutType, hasResultVerticalType, hasResults);
  }
  
  public final Builder setPosition(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasPosition = false;
      position = 0;
      return this;
    }
    hasPosition = true;
    position = paramInteger.intValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */