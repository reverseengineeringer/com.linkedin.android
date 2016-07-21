package com.linkedin.gen.avro2pegasus.events.jobs;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class JobRecommendationImpressionEntity$Builder
  implements RecordTemplateBuilder<JobRecommendationImpressionEntity>
{
  public long duration = 0L;
  private GridPosition gridPosition = null;
  public boolean hasDuration = false;
  private boolean hasGridPosition = false;
  public boolean hasIsSponsored = false;
  public boolean hasListPosition = false;
  public boolean hasRecommendation = false;
  public boolean hasSize = false;
  public boolean hasVisibleTime = false;
  public boolean isSponsored = false;
  public ListPosition listPosition = null;
  public TrackingObject recommendation = null;
  public EntityDimension size = null;
  public long visibleTime = 0L;
  
  public final JobRecommendationImpressionEntity build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (JobRecommendationImpressionEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new JobRecommendationImpressionEntity(recommendation, isSponsored, visibleTime, duration, gridPosition, listPosition, size, hasRecommendation, hasIsSponsored, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize);
      if (!hasRecommendation) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "recommendation");
      }
      if (!hasIsSponsored) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "isSponsored");
      }
    } while (hasVisibleTime);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "visibleTime");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */