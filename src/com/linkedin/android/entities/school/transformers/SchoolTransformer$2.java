package com.linkedin.android.entities.school.transformers;

import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class SchoolTransformer$2
  implements Closure<ImpressionData, TrackingEventBuilder>
{
  SchoolTransformer$2(String paramString1, List paramList, String paramString2, TrackingObject paramTrackingObject) {}
  
  private TrackingEventBuilder apply(ImpressionData paramImpressionData)
  {
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new FlagshipSchoolImpressionItem.Builder();
        localObject1 = val$itemTrackingId;
        if (localObject1 == null)
        {
          hasItemTrackingId = false;
          itemTrackingId = null;
          localObject1 = Long.valueOf(timeViewed);
          if (localObject1 == null)
          {
            hasVisibleTime = false;
            visibleTime = 0L;
            localObject1 = new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD);
            hasListPosition = true;
            listPosition = ((ListPosition)localObject1);
            localObject1 = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
            hasSize = true;
            size = ((EntityDimension)localObject1);
            if (val$itemUrns != null) {
              break label292;
            }
            localObject1 = new ArrayList();
            if (localObject1 != null) {
              break label300;
            }
            hasUrns = false;
            urns = null;
            localObject1 = ((FlagshipSchoolImpressionItem.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
            Log.d("SchoolImpression", "onTrackImpression() - pos: " + position + " item: " + val$header);
            paramImpressionData = new FlagshipSchoolItemImpressionEvent.Builder();
            localObject2 = val$parentJobTrackingObject;
            if (localObject2 != null) {
              break label313;
            }
            hasSchool = false;
            school = null;
            localObject1 = Collections.singletonList(localObject1);
            if (localObject1 != null) {
              break;
            }
            hasItems = false;
            items = null;
            return paramImpressionData;
          }
        }
        else
        {
          hasItemTrackingId = true;
          itemTrackingId = ((String)localObject1);
          continue;
        }
        hasVisibleTime = true;
      }
      catch (BuilderException paramImpressionData)
      {
        Util.safeThrow(new RuntimeException(paramImpressionData));
        return null;
      }
      visibleTime = ((Long)localObject1).longValue();
      continue;
      label292:
      localObject1 = val$itemUrns;
      continue;
      label300:
      hasUrns = true;
      urns = ((List)localObject1);
      continue;
      label313:
      hasSchool = true;
      school = ((TrackingObject)localObject2);
    }
    hasItems = true;
    items = ((List)localObject1);
    return paramImpressionData;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */