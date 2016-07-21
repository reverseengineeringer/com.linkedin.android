package com.linkedin.gen.avro2pegasus.events.pymk;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class PymkRecommendation$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkRecommendation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */