package com.linkedin.android.entities.group.transformers;

import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class GroupTransformer$6
  implements Closure<ImpressionData, TrackingEventBuilder>
{
  GroupTransformer$6(TrackingObject paramTrackingObject, String paramString1, List paramList, String paramString2) {}
  
  private TrackingEventBuilder apply(ImpressionData paramImpressionData)
  {
    if (val$parentJobTrackingObject == null) {
      return null;
    }
    try
    {
      FlagshipGroupImpressionItem.Builder localBuilder = new FlagshipGroupImpressionItem.Builder().setItemTrackingId(val$itemTrackingId).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
      if (val$itemUrns == null) {}
      for (Object localObject = new ArrayList();; localObject = val$itemUrns)
      {
        localObject = localBuilder.setUrns((List)localObject).build();
        Log.d("GroupImpression", "onTrackImpression() - pos: " + position + " card: " + val$header);
        return new FlagshipGroupItemImpressionEvent.Builder().setGroup(val$parentJobTrackingObject).setItems(Collections.singletonList(localObject));
      }
      return null;
    }
    catch (BuilderException paramImpressionData)
    {
      Util.safeThrow(new RuntimeException(paramImpressionData));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupTransformer.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */