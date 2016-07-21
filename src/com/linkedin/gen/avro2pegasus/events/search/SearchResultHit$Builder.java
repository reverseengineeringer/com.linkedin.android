package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;

public final class SearchResultHit$Builder
  implements RecordTemplateBuilder<SearchResultHit>
{
  private int absolutePosition = 0;
  private String entityUrn = null;
  private GridPosition gridPosition = null;
  private boolean hasAbsolutePosition = false;
  private boolean hasEntityUrn = false;
  private boolean hasGridPosition = false;
  private boolean hasHitInfo = false;
  private boolean hasIsAnonymized = false;
  private boolean hasIsCacheHit = false;
  private boolean hasPositionInVertical = false;
  private boolean hasResultType = false;
  private SearchResultHitInfo hitInfo = null;
  private boolean isAnonymized = false;
  private boolean isCacheHit = false;
  private int positionInVertical = 0;
  private SearchResultType resultType = null;
  
  public final SearchResultHit build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchResultHit.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchResultHit(entityUrn, resultType, absolutePosition, positionInVertical, isCacheHit, isAnonymized, hitInfo, gridPosition, hasEntityUrn, hasResultType, hasAbsolutePosition, hasPositionInVertical, hasIsCacheHit, hasIsAnonymized, hasHitInfo, hasGridPosition);
      if (!hasIsCacheHit) {
        isCacheHit = false;
      }
      if (!hasIsAnonymized) {
        isAnonymized = false;
      }
      if (!hasResultType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "resultType");
      }
      if (!hasAbsolutePosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "absolutePosition");
      }
    } while (hasPositionInVertical);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "positionInVertical");
  }
  
  public final Builder setAbsolutePosition(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasAbsolutePosition = false;
      absolutePosition = 0;
      return this;
    }
    hasAbsolutePosition = true;
    absolutePosition = paramInteger.intValue();
    return this;
  }
  
  public final Builder setEntityUrn(String paramString)
  {
    if (paramString == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramString;
    return this;
  }
  
  public final Builder setGridPosition(GridPosition paramGridPosition)
  {
    if (paramGridPosition == null)
    {
      hasGridPosition = false;
      gridPosition = null;
      return this;
    }
    hasGridPosition = true;
    gridPosition = paramGridPosition;
    return this;
  }
  
  public final Builder setHitInfo(SearchResultHitInfo paramSearchResultHitInfo)
  {
    if (paramSearchResultHitInfo == null)
    {
      hasHitInfo = false;
      hitInfo = null;
      return this;
    }
    hasHitInfo = true;
    hitInfo = paramSearchResultHitInfo;
    return this;
  }
  
  public final Builder setIsAnonymized(Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue()))
    {
      hasIsAnonymized = false;
      isAnonymized = false;
      return this;
    }
    hasIsAnonymized = true;
    isAnonymized = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setIsCacheHit(Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue()))
    {
      hasIsCacheHit = false;
      isCacheHit = false;
      return this;
    }
    hasIsCacheHit = true;
    isCacheHit = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setPositionInVertical(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasPositionInVertical = false;
      positionInVertical = 0;
      return this;
    }
    hasPositionInVertical = true;
    positionInVertical = paramInteger.intValue();
    return this;
  }
  
  public final Builder setResultType(SearchResultType paramSearchResultType)
  {
    if (paramSearchResultType == null)
    {
      hasResultType = false;
      resultType = null;
      return this;
    }
    hasResultType = true;
    resultType = paramSearchResultType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHit.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */