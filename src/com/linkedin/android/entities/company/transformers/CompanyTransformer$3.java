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
import java.util.Collections;
import java.util.List;

final class CompanyTransformer$3
  implements Closure<ImpressionData, TrackingEventBuilder>
{
  CompanyTransformer$3(String paramString1, List paramList, String paramString2, TrackingObject paramTrackingObject) {}
  
  private TrackingEventBuilder apply(ImpressionData paramImpressionData)
  {
    try
    {
      FlagshipCompanyImpressionItem.Builder localBuilder = new FlagshipCompanyImpressionItem.Builder().setItemTrackingId(val$itemTrackingId).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
      if (val$itemUrns == null) {}
      for (Object localObject = new ArrayList();; localObject = val$itemUrns)
      {
        localObject = localBuilder.setUrns((List)localObject).build();
        Log.d("CompanyImpression", "onTrackImpression() - pos: " + position + " card: " + val$header);
        return new FlagshipCompanyItemImpressionEvent.Builder().setCompany(val$parentTrackingObject).setItems(Collections.singletonList(localObject));
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
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */