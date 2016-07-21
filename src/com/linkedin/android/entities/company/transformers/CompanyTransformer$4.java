package com.linkedin.android.entities.company.transformers;

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
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class CompanyTransformer$4
  implements Closure<ImpressionData, TrackingEventBuilder>
{
  CompanyTransformer$4(Map paramMap, TrackingObject paramTrackingObject) {}
  
  private TrackingEventBuilder apply(ImpressionData paramImpressionData)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = val$itemTrackingMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        List localList = (List)val$itemTrackingMap.get(localObject);
        FlagshipCompanyImpressionItem.Builder localBuilder = new FlagshipCompanyImpressionItem.Builder().setItemTrackingId((String)localObject).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
        localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        localArrayList.add(localBuilder.setUrns((List)localObject).build());
      }
      Log.d("CompanyImpression", "onTrackImpression() - pos: " + position + " card: " + val$header);
    }
    catch (BuilderException paramImpressionData)
    {
      Util.safeThrow(new RuntimeException(paramImpressionData));
      return null;
    }
    paramImpressionData = new FlagshipCompanyItemImpressionEvent.Builder().setCompany(val$parentTrackingObject).setItems(localArrayList);
    return paramImpressionData;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyTransformer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */