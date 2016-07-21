package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;

public final class SearchResultHit
  implements RecordTemplate<SearchResultHit>
{
  public static final SearchResultHitBuilder BUILDER = SearchResultHitBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int absolutePosition;
  public final String entityUrn;
  public final GridPosition gridPosition;
  public final boolean hasAbsolutePosition;
  public final boolean hasEntityUrn;
  public final boolean hasGridPosition;
  public final boolean hasHitInfo;
  public final boolean hasIsAnonymized;
  public final boolean hasIsCacheHit;
  public final boolean hasPositionInVertical;
  public final boolean hasResultType;
  public final SearchResultHitInfo hitInfo;
  public final boolean isAnonymized;
  public final boolean isCacheHit;
  public final int positionInVertical;
  public final SearchResultType resultType;
  
  SearchResultHit(String paramString, SearchResultType paramSearchResultType, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SearchResultHitInfo paramSearchResultHitInfo, GridPosition paramGridPosition, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    entityUrn = paramString;
    resultType = paramSearchResultType;
    absolutePosition = paramInt1;
    positionInVertical = paramInt2;
    isCacheHit = paramBoolean1;
    isAnonymized = paramBoolean2;
    hitInfo = paramSearchResultHitInfo;
    gridPosition = paramGridPosition;
    hasEntityUrn = paramBoolean3;
    hasResultType = paramBoolean4;
    hasAbsolutePosition = paramBoolean5;
    hasPositionInVertical = paramBoolean6;
    hasIsCacheHit = paramBoolean7;
    hasIsAnonymized = paramBoolean8;
    hasHitInfo = paramBoolean9;
    hasGridPosition = paramBoolean10;
    _cachedId = null;
  }
  
  public final SearchResultHit accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      paramDataProcessor.processString(entityUrn);
    }
    if (hasResultType)
    {
      paramDataProcessor.startRecordField$505cff1c("resultType");
      paramDataProcessor.processEnum(resultType);
    }
    if (hasAbsolutePosition)
    {
      paramDataProcessor.startRecordField$505cff1c("absolutePosition");
      paramDataProcessor.processInt(absolutePosition);
    }
    if (hasPositionInVertical)
    {
      paramDataProcessor.startRecordField$505cff1c("positionInVertical");
      paramDataProcessor.processInt(positionInVertical);
    }
    if (hasIsCacheHit)
    {
      paramDataProcessor.startRecordField$505cff1c("isCacheHit");
      paramDataProcessor.processBoolean(isCacheHit);
    }
    if (hasIsAnonymized)
    {
      paramDataProcessor.startRecordField$505cff1c("isAnonymized");
      paramDataProcessor.processBoolean(isAnonymized);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasHitInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("hitInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = hitInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label314;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label206:
      localObject1 = null;
      bool2 = false;
      if (hasGridPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("gridPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label323;
        }
        localObject1 = gridPosition.accept(paramDataProcessor);
        label245:
        if (localObject1 == null) {
          break label341;
        }
      }
    }
    label314:
    label323:
    label341:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label446;
      }
      try
      {
        if (hasResultType) {
          break label346;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "resultType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (SearchResultHitInfo)paramDataProcessor.processDataTemplate(hitInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label206;
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break label245;
    }
    label346:
    if (!hasAbsolutePosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "absolutePosition");
    }
    if (!hasPositionInVertical) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultHit", "positionInVertical");
    }
    return new SearchResultHit(entityUrn, resultType, absolutePosition, positionInVertical, isCacheHit, isAnonymized, (SearchResultHitInfo)localObject2, (GridPosition)localObject1, hasEntityUrn, hasResultType, hasAbsolutePosition, hasPositionInVertical, hasIsCacheHit, hasIsAnonymized, bool1, bool2);
    label446:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SearchResultHit)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (resultType != null)
      {
        if (resultType.equals(resultType)) {}
      }
      else {
        while (resultType != null) {
          return false;
        }
      }
      if (absolutePosition != absolutePosition) {
        return false;
      }
      if (positionInVertical != positionInVertical) {
        return false;
      }
      if (isCacheHit != isCacheHit) {
        return false;
      }
      if (isAnonymized != isAnonymized) {
        return false;
      }
      if (hitInfo != null)
      {
        if (hitInfo.equals(hitInfo)) {}
      }
      else {
        while (hitInfo != null) {
          return false;
        }
      }
      if (gridPosition == null) {
        break;
      }
    } while (gridPosition.equals(gridPosition));
    for (;;)
    {
      return false;
      if (gridPosition == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 1;
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label48:
    int i2;
    int i3;
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (resultType == null) {
        break label166;
      }
      j = resultType.hashCode();
      i2 = absolutePosition;
      i3 = positionInVertical;
      if (!isCacheHit) {
        break label171;
      }
      k = 1;
      label69:
      if (!isAnonymized) {
        break label176;
      }
      label76:
      if (hitInfo == null) {
        break label182;
      }
    }
    label166:
    label171:
    label176:
    label182:
    for (int n = hitInfo.hashCode();; n = 0)
    {
      if (gridPosition != null) {
        i1 = gridPosition.hashCode();
      }
      i = (n + ((k + (((j + (i + 527) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + m) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label48;
      k = 0;
      break label69;
      m = 0;
      break label76;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */