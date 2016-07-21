package com.linkedin.android.identity.guidededit.infra.shared;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.lego.WidgetActionCategory;
import com.linkedin.gen.avro2pegasus.events.lego.WidgetVisibility;
import javax.inject.Inject;

public final class LegoTrackingDataProvider
  extends DataProvider<LegoTrackingDataProvider.LegoTrackingState, DataProvider.DataProviderListener>
{
  @Inject
  public LegoTrackingDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  private void sendLegoTrackingEvent(Routes paramRoutes, RecordTemplate paramRecordTemplate)
  {
    paramRoutes = paramRoutes.buildUponRoot().buildUpon().build().toString();
    activityComponent.dataManager().submit(Request.post().url(paramRoutes).model(paramRecordTemplate).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public final void sendActionEvent$3082e732(String paramString1, ActionCategory paramActionCategory, int paramInt, String paramString2)
  {
    try
    {
      Object localObject = new com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent.Builder().setTrackingToken(paramString1).setActionCategory(paramActionCategory).setActionCount(Integer.valueOf(paramInt)).build(RecordTemplate.Flavor.RECORD);
      sendLegoTrackingEvent(Routes.LEGO_WIDGET_ACTION, (RecordTemplate)localObject);
      localObject = new com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent.Builder();
      localBoolean = Boolean.valueOf(true);
      if (localBoolean == null)
      {
        hasIsSyncTrack = false;
        isSyncTrack = false;
        if (paramString1 != null) {
          break label202;
        }
        hasTrackingToken = false;
        trackingToken = null;
        paramString1 = Integer.valueOf(paramInt);
        if (paramString1 != null) {
          break label217;
        }
        hasActionCount = false;
        actionCount = 0;
        if (paramString2 != null) {
          break label235;
        }
        hasActionName = false;
        actionName = null;
        paramString1 = WidgetActionCategory.of(paramActionCategory.name());
        if (paramString1 != null) {
          break label251;
        }
        hasActionCategory = false;
        actionCategory = null;
        activityComponent.tracker().send((TrackingEventBuilder)localObject);
      }
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Boolean localBoolean;
        Util.safeThrow(new IllegalArgumentException("Failed to create a lego action event", localBuilderException));
        continue;
        hasIsSyncTrack = true;
        isSyncTrack = localBoolean.booleanValue();
        continue;
        label202:
        hasTrackingToken = true;
        trackingToken = paramString1;
        continue;
        label217:
        hasActionCount = true;
        actionCount = paramString1.intValue();
        continue;
        label235:
        hasActionName = true;
        actionName = paramString2;
        continue;
        label251:
        hasActionCategory = true;
        actionCategory = paramString1;
      }
    }
  }
  
  public final void sendActionEvent$67c7f505(String paramString, ActionCategory paramActionCategory)
  {
    sendActionEvent$3082e732(paramString, paramActionCategory, 1, null);
  }
  
  public final void sendPageImpressionEvent$505cbf4b(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new com.linkedin.android.pegasus.gen.voyager.common.lego.LegoPageImpressionEvent.Builder();
        if (paramString != null) {
          continue;
        }
        hasTrackingToken = false;
        trackingToken = null;
        localObject = ((com.linkedin.android.pegasus.gen.voyager.common.lego.LegoPageImpressionEvent.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
        sendLegoTrackingEvent(Routes.LEGO_PAGE_IMPRESSION, (RecordTemplate)localObject);
      }
      catch (BuilderException localBuilderException)
      {
        Object localObject;
        Boolean localBoolean;
        Util.safeThrow(new IllegalArgumentException("Failed to create a lego impression event", localBuilderException));
        continue;
        hasIsSyncTrack = true;
        isSyncTrack = localBoolean.booleanValue();
        continue;
        hasTrackingToken = true;
        trackingToken = paramString;
        continue;
      }
      localObject = new com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent.Builder();
      localBoolean = Boolean.valueOf(true);
      if (localBoolean != null) {
        continue;
      }
      hasIsSyncTrack = false;
      isSyncTrack = false;
      if (paramString != null) {
        continue;
      }
      hasTrackingToken = false;
      trackingToken = null;
      activityComponent.tracker().send((TrackingEventBuilder)localObject);
      return;
      hasTrackingToken = true;
      trackingToken = paramString;
    }
  }
  
  public final void sendWidgetImpressionEvent$4bb724c7(String paramString, Visibility paramVisibility)
  {
    try
    {
      Object localObject = new com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent.Builder().setTrackingToken(paramString).setVisibility(paramVisibility).build(RecordTemplate.Flavor.RECORD);
      sendLegoTrackingEvent(Routes.LEGO_WIDGET_IMPRESSION, (RecordTemplate)localObject);
      localObject = new com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent.Builder();
      localBoolean = Boolean.valueOf(true);
      if (localBoolean == null)
      {
        hasIsSyncTrack = false;
        isSyncTrack = false;
        if (paramString != null) {
          break label143;
        }
        hasTrackingToken = false;
        trackingToken = null;
        paramString = WidgetVisibility.of(paramVisibility.name());
        if (paramString != null) {
          break label156;
        }
        hasVisibility = false;
        visibility = null;
        activityComponent.tracker().send((TrackingEventBuilder)localObject);
      }
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Boolean localBoolean;
        Util.safeThrow(new IllegalArgumentException("Failed to create a lego impression event", localBuilderException));
        continue;
        hasIsSyncTrack = true;
        isSyncTrack = localBoolean.booleanValue();
        continue;
        label143:
        hasTrackingToken = true;
        trackingToken = paramString;
        continue;
        label156:
        hasVisibility = true;
        visibility = paramString;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */