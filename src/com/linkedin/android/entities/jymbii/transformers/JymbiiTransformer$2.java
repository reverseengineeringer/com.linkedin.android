package com.linkedin.android.entities.jymbii.transformers;

import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity.Builder;
import com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent.Builder;
import java.util.Collections;
import java.util.List;

public final class JymbiiTransformer$2
  implements Closure<ImpressionData, TrackingEventBuilder>
{
  public JymbiiTransformer$2(Jymbii paramJymbii, FragmentComponent paramFragmentComponent) {}
  
  private TrackingEventBuilder apply(ImpressionData paramImpressionData)
  {
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = new JobRecommendationImpressionEntity.Builder();
        localObject2 = new TrackingObject.Builder().setObjectUrn(val$jymbiiRecommendation.objectUrn.toString()).setTrackingId(val$jymbiiRecommendation.trackingId).build(RecordTemplate.Flavor.RECORD);
        hasRecommendation = true;
        recommendation = ((TrackingObject)localObject2);
        localObject2 = Long.valueOf(timeViewed);
        if (localObject2 == null)
        {
          hasVisibleTime = false;
          visibleTime = 0L;
          localObject2 = Long.valueOf(duration);
          if (localObject2 == null)
          {
            hasDuration = false;
            duration = 0L;
            localObject2 = new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD);
            hasListPosition = true;
            listPosition = ((ListPosition)localObject2);
            localObject2 = Boolean.valueOf(val$jymbiiRecommendation.sponsored);
            if (localObject2 != null) {
              break label295;
            }
            hasIsSponsored = false;
            isSponsored = false;
            paramImpressionData = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
            hasSize = true;
            size = paramImpressionData;
            localObject1 = ((JobRecommendationImpressionEntity.Builder)localObject1).build(RecordTemplate.Flavor.RECORD);
            paramImpressionData = new JobRecommendationImpressionEvent.Builder();
            localObject1 = Collections.singletonList(localObject1);
            if (localObject1 != null) {
              break;
            }
            hasEntities = false;
            entities = null;
            return paramImpressionData;
          }
        }
        else
        {
          hasVisibleTime = true;
          visibleTime = ((Long)localObject2).longValue();
          continue;
        }
        hasDuration = true;
      }
      catch (BuilderException paramImpressionData)
      {
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramImpressionData));
        return null;
      }
      duration = ((Long)localObject2).longValue();
      continue;
      label295:
      hasIsSponsored = true;
      isSponsored = ((Boolean)localObject2).booleanValue();
    }
    hasEntities = true;
    entities = ((List)localObject1);
    return paramImpressionData;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.transformers.JymbiiTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */