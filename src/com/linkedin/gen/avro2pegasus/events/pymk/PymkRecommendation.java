package com.linkedin.gen.avro2pegasus.events.pymk;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class PymkRecommendation
  implements RecordTemplate<PymkRecommendation>
{
  public static final PymkRecommendationBuilder BUILDER = PymkRecommendationBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final GridPosition gridPosition;
  public final boolean hasGridPosition;
  public final boolean hasListPosition;
  public final boolean hasRecommendationUrn;
  public final boolean hasTrackingId;
  public final ListPosition listPosition;
  public final String recommendationUrn;
  public final String trackingId;
  
  PymkRecommendation(String paramString1, GridPosition paramGridPosition, ListPosition paramListPosition, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    recommendationUrn = paramString1;
    gridPosition = paramGridPosition;
    listPosition = paramListPosition;
    trackingId = paramString2;
    hasRecommendationUrn = paramBoolean1;
    hasGridPosition = paramBoolean2;
    hasListPosition = paramBoolean3;
    hasTrackingId = paramBoolean4;
    _cachedId = null;
  }
  
  public final PymkRecommendation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRecommendationUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("recommendationUrn");
      paramDataProcessor.processString(recommendationUrn);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasGridPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("gridPosition");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = gridPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      localObject1 = null;
      bool2 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label303;
      }
      try
      {
        if (hasRecommendationUrn) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation", "recommendationUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label120;
    }
    label254:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation", "trackingId");
    }
    return new PymkRecommendation(recommendationUrn, (GridPosition)localObject2, (ListPosition)localObject1, trackingId, hasRecommendationUrn, bool1, bool2, hasTrackingId);
    label303:
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
      paramObject = (PymkRecommendation)paramObject;
      if (recommendationUrn != null)
      {
        if (recommendationUrn.equals(recommendationUrn)) {}
      }
      else {
        while (recommendationUrn != null) {
          return false;
        }
      }
      if (gridPosition != null)
      {
        if (gridPosition.equals(gridPosition)) {}
      }
      else {
        while (gridPosition != null) {
          return false;
        }
      }
      if (listPosition != null)
      {
        if (listPosition.equals(listPosition)) {}
      }
      else {
        while (listPosition != null) {
          return false;
        }
      }
      if (trackingId == null) {
        break;
      }
    } while (trackingId.equals(trackingId));
    for (;;)
    {
      return false;
      if (trackingId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (recommendationUrn != null)
    {
      i = recommendationUrn.hashCode();
      if (gridPosition == null) {
        break label110;
      }
      j = gridPosition.hashCode();
      label45:
      if (listPosition == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = listPosition.hashCode();; k = 0)
    {
      if (trackingId != null) {
        m = trackingId.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<PymkRecommendation>
  {
    public GridPosition gridPosition = null;
    public boolean hasGridPosition = false;
    private boolean hasListPosition = false;
    private boolean hasRecommendationUrn = false;
    private boolean hasTrackingId = false;
    private ListPosition listPosition = null;
    private String recommendationUrn = null;
    private String trackingId = null;
    
    public final PymkRecommendation build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PymkRecommendation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PymkRecommendation(recommendationUrn, gridPosition, listPosition, trackingId, hasRecommendationUrn, hasGridPosition, hasListPosition, hasTrackingId);
        if (!hasRecommendationUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation", "recommendationUrn");
        }
      } while (hasTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation", "trackingId");
    }
    
    public final Builder setListPosition(ListPosition paramListPosition)
    {
      if (paramListPosition == null)
      {
        hasListPosition = false;
        listPosition = null;
        return this;
      }
      hasListPosition = true;
      listPosition = paramListPosition;
      return this;
    }
    
    public final Builder setRecommendationUrn(String paramString)
    {
      if (paramString == null)
      {
        hasRecommendationUrn = false;
        recommendationUrn = null;
        return this;
      }
      hasRecommendationUrn = true;
      recommendationUrn = paramString;
      return this;
    }
    
    public final Builder setTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingId = false;
        trackingId = null;
        return this;
      }
      hasTrackingId = true;
      trackingId = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */